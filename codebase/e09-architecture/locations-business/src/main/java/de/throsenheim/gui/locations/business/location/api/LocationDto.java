package de.throsenheim.gui.locations.business.location.api;

import java.time.LocalDate;

/**
 * Sample Data Transfer Object
 */
public class LocationDto {
    private  String id;
    private  String name;

    private  String label;
    private  String type;
    private  String subType;

    private LocalDate since;
    private  boolean active;

    private  String street;
    private  String streeNumber;
    private  String zip;
    private  String city;
    private  String notes;


    public LocationDto(String id, String name, String label, String type, String subType, LocalDate since, boolean active, String street, String streeNumber, String zip, String city, String notes) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.type = type;
        this.subType = subType;
        this.since = since;
        this.active = active;
        this.street = street;
        this.streeNumber = streeNumber;
        this.zip = zip;
        this.city = city;
        this.notes = notes;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getType() {
        return type;
    }

    public String getSubType() {
        return subType;
    }

    public LocalDate getSince() {
        return since;
    }

    public boolean isActive() {
        return active;
    }

    public String getStreet() {
        return street;
    }

    public String getStreeNumber() {
        return streeNumber;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "LocationDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                ", since=" + since +
                ", active=" + active +
                ", street='" + street + '\'' +
                ", streeNumber='" + streeNumber + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
