package de.throsenheim.gui.locations.business.protocol;

import de.throsenheim.gui.locations.business.protocol.api.ProtocolService;
import de.throsenheim.gui.locations.business.protocol.impl.ProtocolServiceImpl;

public class ProtocolServiceFactory {
    public static ProtocolService getProtocolService() {
        return new ProtocolServiceImpl();
    }
}
