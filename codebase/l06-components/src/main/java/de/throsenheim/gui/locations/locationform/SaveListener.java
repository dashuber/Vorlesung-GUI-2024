package de.throsenheim.gui.locations.locationform;


import de.throsenheim.gui.locations.location.LocationModel;

/**
 * Simple custom listener interface to display basic component interaction
 */
public interface SaveListener {

    /**
     * This method is called if the form should be saved
     *
     * @param location the location that should be saved
     */
    void onSave(LocationModel location);
}
