package de.throsenheim.gui.locations;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocationFormModel {
    private final ListProperty<String> types = new SimpleListProperty<>();
    private final StringProperty currentType = new SimpleStringProperty();

    private final ListProperty<String> subTypes = new SimpleListProperty<>();
    private final StringProperty currentSubType = new SimpleStringProperty();

    public LocationFormModel() {
        List<String> abcList = Arrays.asList("a", "b", "c");
        types.set(FXCollections.observableArrayList(abcList));

        // All values in one list (Exercise 2)
        List<String> subAbcList = Arrays.asList("a-1", "a-1", "a-1", "b-1", "b-2", "b-3", "c-1", "c-2", "c-3");
        subTypes.set(FXCollections.observableArrayList(subAbcList));
        currentType.addListener((observable, oldValue, newValue) -> updateSubTypes(newValue));
    }

    private void updateSubTypes(String newValue) {
        if (newValue==null) {
            subTypes.set(FXCollections.observableArrayList());
        } else {
            List<String> subTypesList = switch (newValue) {
                case "a" -> Arrays.asList("a-1", "a-2", "a-3");
                case "b" -> Arrays.asList("b-1", "b-2", "b-3");
                case "c" -> Arrays.asList("c-1", "c-2", "c-3");
                default -> new ArrayList<>();
            };

            subTypes.set(FXCollections.observableArrayList(subTypesList));
        }
        currentSubType.set(null);
    }

    public ObservableList<String> getTypes() {
        return types.get();
    }

    public ListProperty<String> typesProperty() {
        return types;
    }

    public String getCurrentType() {
        return currentType.get();
    }

    public StringProperty currentTypeProperty() {
        return currentType;
    }

    public ObservableList<String> getSubTypes() {
        return subTypes.get();
    }

    public ListProperty<String> subTypesProperty() {
        return subTypes;
    }

    public String getCurrentSubType() {
        return currentSubType.get();
    }

    public StringProperty currentSubTypeProperty() {
        return currentSubType;
    }
}
