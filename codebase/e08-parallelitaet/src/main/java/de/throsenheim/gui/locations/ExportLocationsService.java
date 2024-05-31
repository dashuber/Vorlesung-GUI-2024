package de.throsenheim.gui.locations;

import de.throsenheim.gui.locations.location.LocationModel;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.List;

/**
 * Simple javafx.concurrent.Service implementation for the locations export.
 */
public class ExportLocationsService extends Service<Integer> {

    private List<LocationModel> locations;

    public ExportLocationsService(List<LocationModel> locations) {
        this.locations = locations;
    }

    @Override
    protected Task<Integer> createTask() {
        return new ExportLocationsTask(locations);
    }
}
