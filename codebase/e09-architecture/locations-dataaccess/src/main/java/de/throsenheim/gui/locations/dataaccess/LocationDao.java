package de.throsenheim.gui.locations.dataaccess;

import java.util.Set;

public interface LocationDao {
    Set<LocationEt> queryAllLocations();
}
