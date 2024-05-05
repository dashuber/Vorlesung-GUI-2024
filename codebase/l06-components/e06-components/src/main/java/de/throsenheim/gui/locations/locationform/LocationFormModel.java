package de.throsenheim.gui.locations.locationform;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LocationFormModel {
    private ListProperty<String> types = new SimpleListProperty<>();
    private ObjectProperty<String> currentType = new SimpleObjectProperty<>();

    private ListProperty<String> subTypes = new SimpleListProperty<>();
    private ObjectProperty<String> currentSubType = new SimpleObjectProperty<>();



    public LocationFormModel() {
        List<String> aToZList = IntStream.rangeClosed('a', 'z').mapToObj(value -> "" + (char) value).collect(Collectors.toList());
        types.set(FXCollections.observableArrayList(aToZList));
        updateSubTypes(null);

        currentType.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                updateSubTypes(newValue);
            }
        });

    }

    private void updateSubTypes(String newValue) {
        if(newValue == null) {
            subTypes.set(FXCollections.observableArrayList());
        } else {
            List<String> subTypesList = IntStream.rangeClosed(1, 10).mapToObj(i -> newValue + "-" + i).collect(Collectors.toList());
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

    public ObjectProperty<String> currentTypeProperty() {
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

    public ObjectProperty<String> currentSubTypeProperty() {
        return currentSubType;
    }
}
