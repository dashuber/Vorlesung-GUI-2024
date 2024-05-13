package de.throsenheim.gui.locations;

import de.throsenheim.gui.locations.location.LocationModel;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Locations main model backing the locations main dialog.
 */
public class LocationsMainModel {
    private ListProperty<LocationModel> locations = new SimpleListProperty<>(FXCollections.observableList(new ArrayList<>()));

    public ObservableList<LocationModel> getLocations() {
        return locations.get();
    }

    public ListProperty<LocationModel> locationsProperty() {
        return locations;
    }

    public void addLocation(LocationModel location) {
        getLocations().add(location);
    }
}
