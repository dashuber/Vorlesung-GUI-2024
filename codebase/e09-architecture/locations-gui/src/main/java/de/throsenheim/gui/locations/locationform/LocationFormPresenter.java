package de.throsenheim.gui.locations.locationform;

import de.throsenheim.gui.locations.eventbus.SimpleEventBus;
import de.throsenheim.gui.locations.location.LocationModel;
import de.throsenheim.gui.locations.status.StatusEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class LocationFormPresenter implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationFormPresenter.class);


    @FXML
    private Text headerText;


    @FXML
    private GridPane locationFormPane;

    public TextField idOutput;
    public TextField nameInput;

    public TextField labelInput;
    public ComboBox<String> typeInput;
    public ComboBox<String> subTypeInput;
    public DatePicker sinceInput;
    public CheckBox activeInput;


    public TextField streetInput;
    public TextField streetNumberInput;
    public TextField zipInput;
    public TextField cityInput;

    public TextArea notesInput;

    public Button cancelButton;
    public Button resetButton;
    public Button saveButton;


    private LocationModel model = new LocationModel();
    private LocationFormModel formModel = new LocationFormModel();

    private Set<SaveListener> saveListeners = new HashSet<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeBindings();
        initializeEventHandlers();
    }

    private void initializeBindings() {
        initializeFormBindings();
        initializeComboBoxBindings();
    }


    private void initializeComboBoxBindings() {
        this.typeInput.itemsProperty().bind(formModel.typesProperty());
        formModel.currentTypeProperty().bind(this.typeInput.valueProperty());

        this.subTypeInput.itemsProperty().bind(formModel.subTypesProperty());
        formModel.currentSubTypeProperty().bindBidirectional(this.subTypeInput.valueProperty());

    }

    private void initializeFormBindings() {
        this.idOutput.textProperty().bind(model.idProperty());
        this.nameInput.textProperty().bindBidirectional(model.nameProperty());

        this.labelInput.textProperty().bindBidirectional(model.labelProperty());

        typeInput.valueProperty().bindBidirectional(model.typeProperty());
        subTypeInput.valueProperty().bindBidirectional(model.subTypeProperty());
        sinceInput.valueProperty().bindBidirectional(model.sinceProperty());
        activeInput.selectedProperty().bindBidirectional(model.activeProperty());

        streetInput.textProperty().bindBidirectional(model.streetProperty());
        streetNumberInput.textProperty().bindBidirectional(model.streetNumberProperty());
        zipInput.textProperty().bindBidirectional(model.zipProperty());
        cityInput.textProperty().bindBidirectional(model.cityProperty());
        notesInput.textProperty().bindBidirectional(model.notesProperty());
    }

    private void unbindForm() {
        headerText.textProperty().unbind();
        idOutput.textProperty().unbind();

        this.idOutput.textProperty().unbindBidirectional(model.idProperty());
        this.nameInput.textProperty().unbindBidirectional(model.nameProperty());

        this.labelInput.textProperty().unbindBidirectional(model.labelProperty());

        typeInput.valueProperty().unbindBidirectional(model.typeProperty());
        subTypeInput.valueProperty().unbindBidirectional(model.subTypeProperty());
        sinceInput.valueProperty().unbindBidirectional(model.sinceProperty());
        activeInput.selectedProperty().unbindBidirectional(model.activeProperty());

        streetInput.textProperty().unbindBidirectional(model.streetProperty());
        streetNumberInput.textProperty().unbindBidirectional(model.streetNumberProperty());
        zipInput.textProperty().unbindBidirectional(model.zipProperty());
        cityInput.textProperty().unbindBidirectional(model.cityProperty());
        notesInput.textProperty().unbindBidirectional(model.notesProperty());
    }

    private void initializeEventHandlers() {
        resetButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                reset();
            }
        });

        cancelButton.setOnAction((ActionEvent e) -> {
            cancel();
        });



        locationFormPane.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //LOGGER.info("Key typed: {}", event.getCharacter());
            }
        });
    }


    public void onSave(ActionEvent actionEvent) {
        LOGGER.info("OnSave: {}", this.model);
        for (SaveListener listener : saveListeners) {
            listener.onSave(this.model);
        }
        SimpleEventBus.get().publish(new StatusEvent("Save done!"));    }

    private void reset() {
        LOGGER.info("reset");

        this.model.reset();
        SimpleEventBus.get().publish(new StatusEvent("Reset done!"));
    }

    private void cancel() {
        LOGGER.info("cancel");
        SimpleEventBus.get().publish(new StatusEvent("Cancel done!"));
    }


    public void setEvent(LocationModel locationModel) {
        unbindForm();
        this.model = locationModel;
        initializeFormBindings();
    }

    /**
     * Adds a save listener to this component. All save listeners will be informed if the user
     * wants to save the form.
     *
     * @param listener callback for the save event
     */
    public void addSaveListener(SaveListener listener) {
        this.saveListeners.add(listener);
    }
}
