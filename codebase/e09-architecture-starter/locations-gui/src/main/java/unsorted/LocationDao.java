package unsorted;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Sample Data Access Object - simple dummy implementation with hard coded locations
 * This could be replaced with some real database access.
 */
public class LocationDao implements LocationStore {

    private Set<LocationEt> locations = new HashSet<>();

    public LocationDao() {
        LocationEt location = new LocationEt();
        location.setId("id1");
        location.setName("Schlawinchen");
        location.setType("Pub");
        location.setLabel("Boazn");
        location.setSince(LocalDate.now());
        locations.add(location);

        location = new LocationEt();
        location.setId("id2");
        location.setName("Iron Works Barbecue");
        location.setType("Restaurant");
        location.setLabel("Barbecue");
        location.setSince(LocalDate.now());
        locations.add(location);


    }

    public Set<LocationEt> queryAllLocations() {
        return locations;
    }
}
