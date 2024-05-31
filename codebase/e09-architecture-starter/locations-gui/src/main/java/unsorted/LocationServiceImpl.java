package unsorted;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Sample implementation for a business service - very basic
 */
public class LocationServiceImpl implements LocationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationServiceImpl.class);

    //hard coded dao - you should use Dependency Injection
    private LocationStore dao = new LocationDao();

    @Override
    public Set<LocationDto> loadLocations() {
        LOGGER.info("Loading all locations...");
        return dao.queryAllLocations().stream().map((e) -> new LocationDto(
                e.getId(),
                e.getName(),
                e.getLabel(),
                e.getType(),
                e.getSubType(),
                e.getSince(),
                e.isActive(),
                e.getStreet(),
                e.getStreeNumber(),
                e.getZip(),
                e.getCity(),
                e.getNotes()
        )).collect(Collectors.toSet());
    }
}
