package v4.mvp;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

public class IntervalModel {
    private final IntegerProperty valueProperty = new SimpleIntegerProperty(0);

    public IntegerProperty getValueProperty() {
        return valueProperty;
    }

    public void increase() {
        valueProperty.set(valueProperty.get() + 1);
    }

    public void decrease() {
        valueProperty.set(valueProperty.get() - 1);
    }

    public BooleanBinding maxReachedProperty() {
        return valueProperty.greaterThanOrEqualTo(10);
    }

    public BooleanBinding minReachedProperty() {
        return valueProperty.lessThanOrEqualTo(0);
    }
}
