package unsorted;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Sample Data Access Object - simple dummy implementation with hard coded locations
 * This could be replaced with some real database access.
 */
public interface LocationStore {

    Set<LocationEt> queryAllLocations();
}
