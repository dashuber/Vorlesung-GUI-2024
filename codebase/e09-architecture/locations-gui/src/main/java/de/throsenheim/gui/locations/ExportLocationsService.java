package de.throsenheim.gui.locations;

import de.throsenheim.gui.locations.location.LocationModel;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * Simple javafx.concurrent.Service implementation for the locations export.
 */
public class ExportLocationsService extends Service<Integer> {

    //This is actually the input for the export task. We have to provide it as property.
    private final ListProperty<LocationModel> locations = new SimpleListProperty<>();

    public ObservableList<LocationModel> getLocations() {
        return locations.get();
    }

    public ListProperty<LocationModel> locationsProperty() {
        return locations;
    }

    public void setLocations(ObservableList<LocationModel> locations) {
        this.locations.set(locations);
    }

    @Override
    protected Task<Integer> createTask() {
        return new ExportLocationsTask(locations.get());
    }
}
