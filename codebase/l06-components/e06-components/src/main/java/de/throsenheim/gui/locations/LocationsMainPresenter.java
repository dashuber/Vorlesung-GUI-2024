package de.throsenheim.gui.locations;

import de.throsenheim.gui.locations.location.LocationModel;
import de.throsenheim.gui.locations.locationform.LocationFormPresenter;
import de.throsenheim.gui.locations.locationform.SaveListener;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ArrayList;
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

    private ListProperty<LocationModel> locationsMainModel = new SimpleListProperty<>(FXCollections.observableList(new ArrayList<>()));

//    private LocationsMainModel locationsMainModel = new LocationsMainModel();

    private void saveLocation(LocationModel locationModel) {
        LOGGER.info("save locationModel in parent");
        //add the current locationModel to the list
        locationsMainModel.add(locationModel);
        //set up a new one
        locationFormController.setLocation(new LocationModel());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Aufgabe 2 - don't do this!
        /*
        locationFormController.getSaveButton().setOnAction(e -> {
            LOGGER.info("### Parent (main) - received save from form");
            LocationModel locationModel = locationFormController.getLocationModel();
            locationsMainModel.addLocation(locationModel);
            saveLocation(locationModel);
        });
         */

        //register save listener - component interaction
        locationFormController.addSaveListener(loc -> {
            this.saveLocation(loc);
        });

        //ui bindings - display events in table
        locationsTable.itemsProperty().bind(locationsMainModel);
    }
}
