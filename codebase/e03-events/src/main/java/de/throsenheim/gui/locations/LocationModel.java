package de.throsenheim.gui.locations;

import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Model for locations
 *
 * @author dominik.haas
 */
public class LocationModel {
    private String id;
    private String name;

    private String label;
    private String type;
    private String subType;
    private Boolean active;

    private String street;
    private String streetNumber;

    private String zip;
    private String city;

    private String notes;

    private LocalDate since;

    /**
     *  Constructor for events - this initialies the immutable id
     */
    public LocationModel() {
        id = java.util.UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "LocationModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                ", active=" + active +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
