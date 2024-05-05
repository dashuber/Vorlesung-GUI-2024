package de.throsenheim.gui.locations.locationform;

import de.throsenheim.gui.locations.location.LocationModel;
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

/**
 * Controller for the location form. This class is used in the GUI defined in FXML and provides the necessary functions
 * to implement the dialog's logic.
 *
 * @author dominik.haas
 */
public class LocationFormPresenter implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationFormPresenter.class);

    @FXML
    private Text headerText;

    @FXML
    private GridPane locationFormPane;

    @FXML
    private TextField idInput;
    @FXML
    private TextField nameInput;

    @FXML
    private TextField labelInput;
    @FXML
    private ComboBox<String> typeInput;
    @FXML
    private ComboBox<String> subTypeInput;
    @FXML
    private DatePicker sinceInput;
    @FXML
    private CheckBox activeInput;

    @FXML
    private TextField streetInput;
    @FXML
    private TextField streetNumberInput;
    @FXML
    private TextField zipInput;
    @FXML
    private TextField cityInput;
    @FXML
    private TextArea notesInput;



    @FXML
    private Button resetButton;
    @FXML
    private Button cancelButton;

    private LocationModel locationModel = new LocationModel();
    private LocationFormModel locationFormModel = new LocationFormModel();

    private Set<SaveListener> saveListeners = new HashSet<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeBindings();
        initializeEventHandlers();
    }

    private void initializeBindings() {
        initializeComboBoxBindings();
        initializeFormBindings();
    }

    private void initializeComboBoxBindings() {
        typeInput.itemsProperty().bind(locationFormModel.typesProperty());
        subTypeInput.itemsProperty().bind(locationFormModel.subTypesProperty());



        locationFormModel.currentTypeProperty().bind(typeInput.valueProperty());
        subTypeInput.valueProperty().bindBidirectional(locationFormModel.currentSubTypeProperty());
    }


    private void initializeFormBindings() {
        //unidirectional bindings for the output
        headerText.textProperty().bind(locationModel.nameProperty());
        idInput.textProperty().bind(locationModel.idProperty());
        //bidirectional bindings for input
        nameInput.textProperty().bindBidirectional(locationModel.nameProperty());

        labelInput.textProperty().bindBidirectional(locationModel.labelProperty());
        typeInput.valueProperty().bindBidirectional(locationModel.typeProperty());
        subTypeInput.valueProperty().bindBidirectional(locationModel.subTypeProperty());
        sinceInput.valueProperty().bindBidirectional(locationModel.sinceProperty());
        activeInput.selectedProperty().bindBidirectional(locationModel.activeProperty());

        streetInput.textProperty().bindBidirectional(locationModel.streetProperty());
        streetNumberInput.textProperty().bindBidirectional(locationModel.streetNumberProperty());
        zipInput.textProperty().bindBidirectional(locationModel.zipProperty());
        cityInput.textProperty().bindBidirectional(locationModel.cityProperty());

        notesInput.textProperty().bindBidirectional(locationModel.notesProperty());
    }


    private void unbindForm() {
        headerText.textProperty().unbind();
        idInput.textProperty().unbind();

        //bidirectional bindings for input
        nameInput.textProperty().unbindBidirectional(locationModel.nameProperty());

        labelInput.textProperty().unbindBidirectional(locationModel.labelProperty());
        typeInput.valueProperty().unbindBidirectional(locationModel.typeProperty());
        subTypeInput.valueProperty().unbindBidirectional(locationModel.subTypeProperty());
        sinceInput.valueProperty().unbindBidirectional(locationModel.sinceProperty());
        activeInput.selectedProperty().unbindBidirectional(locationModel.activeProperty());

        streetInput.textProperty().unbindBidirectional(locationModel.streetProperty());
        streetNumberInput.textProperty().unbindBidirectional(locationModel.streetNumberProperty());
        zipInput.textProperty().unbindBidirectional(locationModel.zipProperty());
        cityInput.textProperty().unbindBidirectional(locationModel.cityProperty());

        notesInput.textProperty().unbindBidirectional(locationModel.notesProperty());
    }



        private void initializeEventHandlers() {
        //programmatic simple registration of events
        //event handler is implemented as anonymous
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                reset();
            }
        });

        //programmatic registration of events (rich api)
        //event handler is implemented as lambda expression
        cancelButton.addEventHandler(ActionEvent.ACTION, (e) -> {
            cancel();
        });

        //example for event filter (pointless example)
        //handlers can be registered for parents too
        locationFormPane.addEventFilter(KeyEvent.KEY_TYPED, (KeyEvent e) -> {
            if(e.getCharacter().equals("a")) {
                e.consume();
            }
        });
    }

    /**
     * This method is triggered if the user presses the save button.
     *
     * @param event JavaFX's action event
     */
    @FXML
    private void onSave(ActionEvent event) {
        LOGGER.info("OnSave: {}", locationModel);
        for (SaveListener listener : saveListeners) {
            listener.onSave(locationModel);
        }

    }

    /**
     * Cancels the current editing
     */
    private void cancel() {
        LOGGER.info("cancel");
    }

    /**
     * Resets the current input
     */
    private void reset() {
        LOGGER.info("reset");
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

    public void setLocation(LocationModel locationModel) {
        unbindForm();
        this.locationModel = locationModel;
        initializeFormBindings();
    }


}
