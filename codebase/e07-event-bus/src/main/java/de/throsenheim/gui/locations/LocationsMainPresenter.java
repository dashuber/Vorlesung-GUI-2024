package de.throsenheim.gui.locations;

import de.throsenheim.gui.locations.location.LocationModel;
import de.throsenheim.gui.locations.locationform.LocationFormPresenter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller/presenter for the locations main dialog
 */
public class LocationsMainPresenter implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationsMainPresenter.class);

    @FXML
    private TableView<LocationModel> locationsTable;
    @FXML
    private LocationFormPresenter locationFormController;

    private LocationsMainModel model = new LocationsMainModel();



    private void saveLocation(LocationModel location) {
        LOGGER.info("safeEvent");
        //add the current location to the list
        model.addLocation(location);
        //set up a new one
        locationFormController.setLocation(new LocationModel());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Aufgabe 2 - don't do this!
        /*
        eventFormController.saveButton.setOnAction(e -> {
            System.out.println("### Parent (main) - received save from form");
        });*/


        //register save listener - component interaction
        locationFormController.addSaveListener(loc -> {
            this.saveLocation(loc);
        });

        //ui bindings - display events in table
        locationsTable.itemsProperty().bind(model.locationsProperty());
    }
}
