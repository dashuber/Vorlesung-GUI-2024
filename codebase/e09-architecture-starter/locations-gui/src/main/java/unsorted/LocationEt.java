package unsorted;

import java.time.LocalDate;

/**
 * Sample entity
 */
public class LocationEt {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getSince() {
        return since;
    }

    public void setSince(LocalDate since) {
        this.since = since;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreeNumber() {
        return streeNumber;
    }

    public void setStreeNumber(String streeNumber) {
        this.streeNumber = streeNumber;
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
        return "EventEt{" +
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
