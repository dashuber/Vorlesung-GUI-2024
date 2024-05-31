package de.throsenheim.gui.locations.location;

import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Model for locations
 *
 * @author dominik.haas
 */
public class LocationModel {

    private StringProperty id = new SimpleStringProperty();
    private StringProperty name = new SimpleStringProperty();

    private StringProperty label = new SimpleStringProperty();
    private StringProperty type = new SimpleStringProperty();
    private StringProperty subType = new SimpleStringProperty();
    private ObjectProperty<LocalDate> since = new SimpleObjectProperty<>();
    private BooleanProperty active = new SimpleBooleanProperty();

    private StringProperty street = new SimpleStringProperty();
    private StringProperty streetNumber = new SimpleStringProperty();

    private StringProperty zip = new SimpleStringProperty();
    private StringProperty city = new SimpleStringProperty();

    private StringProperty notes = new SimpleStringProperty();

    /**
     *  Constructor for events - this initialies the immutable id
     */
    public LocationModel() {
        id.set(java.util.UUID.randomUUID().toString());
    }

    public LocationModel(String name, String type, String label) {
        id.set(java.util.UUID.randomUUID().toString());
        this.name.set(name);
        this.type.set(type);
        this.label.set(label);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLabel() {
        return label.get();
    }

    public StringProperty labelProperty() {
        return label;
    }

    public void setLabel(String label) {
        this.label.set(label);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getSubType() {
        return subType.get();
    }

    public StringProperty subTypeProperty() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType.set(subType);
    }

    public LocalDate getSince() {
        return since.get();
    }

    public ObjectProperty<LocalDate> sinceProperty() {
        return since;
    }

    public void setSince(LocalDate since) {
        this.since.set(since);
    }

    public boolean isActive() {
        return active.get();
    }

    public BooleanProperty activeProperty() {
        return active;
    }

    public void setActive(boolean active) {
        this.active.set(active);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getStreetNumber() {
        return streetNumber.get();
    }

    public StringProperty streetNumberProperty() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber.set(streetNumber);
    }

    public String getZip() {
        return zip.get();
    }

    public StringProperty zipProperty() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip.set(zip);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getNotes() {
        return notes.get();
    }

    public StringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }


    public void reset() {
        name.set(null);

        label.set(null);
        type.setValue(null);
        subType.setValue(null);
        since.set(null);
        active.set(true);

        street.set(null);
        streetNumber.set(null);
        zip.set(null);
        city.set(null);

        notes.set(null);
    }

    @Override
    public String toString() {
        return "LocationModel{" +
                "id=" + id +
                ", name=" + name +
                ", label=" + label +
                ", type=" + type +
                ", subType=" + subType +
                ", since=" + since +
                ", active=" + active +
                ", street=" + street +
                ", streetNumber=" + streetNumber +
                ", zip=" + zip +
                ", city=" + city +
                ", notes=" + notes +
                '}';
    }
}
