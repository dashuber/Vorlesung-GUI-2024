package v4.mvp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author haas
 */
public class IntervalPresenter implements Initializable {

    private IntervalModel model = new IntervalModel();

    @FXML
    private TextField valueTextField;
    @FXML
    private ProgressBar valueProgressbar;
    @FXML
    private Button buttonDown;
    @FXML
    private Button buttonUp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        valueTextField.textProperty().bind(model.getValueProperty().asString());
        valueProgressbar.progressProperty().bind(model.getValueProperty().divide(10d));

        //add event handlers
        buttonUp.setOnAction(e -> model.increase());
        buttonDown.setOnAction(e -> model.decrease());
//
//        //UI logic - disabled button on min and max value
        buttonUp.disableProperty().bind(model.maxReachedProperty());
        buttonDown.disableProperty().bind(model.minReachedProperty());
    }
}
