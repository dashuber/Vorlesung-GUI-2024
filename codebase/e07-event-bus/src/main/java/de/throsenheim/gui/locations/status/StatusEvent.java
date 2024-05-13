package de.throsenheim.gui.locations.status;

public class StatusEvent {
    private String message;

    public StatusEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
