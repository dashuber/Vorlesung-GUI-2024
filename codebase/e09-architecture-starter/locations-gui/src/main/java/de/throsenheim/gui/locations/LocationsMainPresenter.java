package de.throsenheim.gui.locations;

import de.throsenheim.gui.locations.eventbus.SimpleEventBus;
import de.throsenheim.gui.locations.location.LocationModel;
import de.throsenheim.gui.locations.locationform.LocationFormPresenter;
import de.throsenheim.gui.locations.status.StatusEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unsorted.LocationDto;
import unsorted.LocationService;
import unsorted.LocationServiceImpl;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Controller/presenter for the locations main dialog
 */
public class LocationsMainPresenter implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationsMainPresenter.class);

    @FXML
    private TableView<LocationModel> locationsTable;
    @FXML
    private LocationFormPresenter locationFormController;
    @FXML
    private Button exportButton;
    @FXML
    private ProgressBar progressBar;

    private final LocationsMainModel model = new LocationsMainModel();

    private final ExportLocationsService service = new ExportLocationsService();

    private final LocationService locationService = new LocationServiceImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateListWithData();

        registerEventHandlers();

        initiateDataBindings();

        //exercise 3 - JavaFx concurrent
        service.locationsProperty().bind(model.locationsProperty());

        service.setOnSucceeded((value) -> {
            SimpleEventBus.get().publish(new StatusEvent("Exported " + service.getValue() + " locations!"));
        });

        exportButton.disableProperty().bind(service.runningProperty());
        progressBar.progressProperty().bind(service.progressProperty());
        progressBar.visibleProperty().bind(service.runningProperty());
    }

    private void populateListWithData() {
        Set<LocationDto> locationDtos = locationService.loadLocations();


        //we ignore some attributes here
        List<LocationModel> locationModelList = locationDtos.stream().map((location) -> {
            return new LocationModel(location.getName(), location.getType(), location.getLabel());
        }).collect(Collectors.toList());

        model.setLocations(locationModelList);
    }

    private void registerEventHandlers() {
        //register save listener - component interaction
        locationFormController.addSaveListener(location -> {
            this.saveLocation(location);
        });

        exportButton.setOnAction((e) -> {
            //exercise 2 - export using threads
            //ex2ExportInNewThread();

            //exercise 3 - export using the javaFx concurrent helper classes
            ex3ExportWithJavaFxConcurrent();
        });
    }

    private void initiateDataBindings() {
        //ui bindings - display locations in table
        locationsTable.itemsProperty().bind(model.locationsProperty());
    }

    private void saveLocation(LocationModel location) {
        LOGGER.info("Save location");
        //add the current location to the list
        model.addLocation(location);
        //set up a new one
        locationFormController.setEvent(new LocationModel());
    }


    private void ex3ExportWithJavaFxConcurrent() {
        service.restart();
    }

    private void ex2ExportInNewThread() {
        //main GUI thread
        exportButton.setText("Export running ...");
        exportButton.setDisable(true);


        new Thread(() -> {
            //new thread
            int exportedEvents = exportLocations(model.getLocations());

          Platform.runLater(() -> {
                //main GUI thread
                SimpleEventBus.get().publish(new StatusEvent("Exported " + exportedEvents + " locations!"));

                exportButton.setText("Export");
                exportButton.setDisable(false);
          });
        }).start();
    }

    private int exportLocations(List<LocationModel> locations) {
        int exportCount = 0;
        for (LocationModel location : locations) {
            try {
                exportLocation(location);
                exportCount++;
            } catch (Exception e) {
                LOGGER.error("Export for location " + location + " failed!", e);
            }
        }
        return exportCount;
    }

    private void exportLocation(LocationModel location) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("Exported location {}", location);
    }
}
