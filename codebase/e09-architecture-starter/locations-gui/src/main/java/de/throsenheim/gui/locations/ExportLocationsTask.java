package de.throsenheim.gui.locations;

import de.throsenheim.gui.locations.location.LocationModel;
import javafx.concurrent.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Export Locations Task implemented as JavaFX concurrent task.
 * The input has to be provided in the constructor. The output is the generic parameter (integer = count of successfully
 * exported locations).
 */
public class ExportLocationsTask extends Task<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExportLocationsTask.class);

    private final List<LocationModel> locations;

    public ExportLocationsTask(List<LocationModel> locations) {
        this.locations = locations;
    }

    /**
     * This method has to be implemented. It is called during execution and returns the result.
     *
     * @return count of successfully exported locations
     */
    @Override
    protected Integer call()  {
        return exportLocations(locations);
    }

    /**
     * Exports all locations and returns the number of successfully exported locations.
     *
     * @param locations list of locations ot export
     * @return  count of successfully exported locations
     */
    private int exportLocations(List<LocationModel> locations) {
        updateProgress(0, locations.size());
        int exportCount = 0;
        for (int i = 0; i < locations.size(); i++) {
            try {
                exportLocation(locations.get(i));
                updateProgress(i + 1, locations.size());
                exportCount++;
            } catch (Exception e) {
                LOGGER.error("Export for location " + locations.get(i) + " failed!", e);
            }
        }
        return exportCount;
    }

    private void exportLocation(LocationModel location) {
        //simulated long running export
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("Exported location {}", location);
    }
}
