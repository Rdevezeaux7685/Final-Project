package ui.fx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import domain.MovieService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginScreenController {

    private static final Logger LOGGER = Logger.getLogger(LoginScreenController.class.getName());

    MovieService service = new MovieService();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblErrorMessage;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void onLogin(ActionEvent event) {
        if (service.login(txtUsername.getText(), txtPassword.getText())) {
            lblErrorMessage.setText("User logged in");
            showMainScreen(event2stage(event), service);
        } else {
            lblErrorMessage.setText("Invalid username and/or password. Please try again");
        }
    }

    private Stage event2stage(ActionEvent event) {
        Node node = (Node) event.getSource();
        return (Stage) node.getScene().getWindow();
    }


    private void showMainScreen(Stage stage, MovieService service) {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("i22");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MovieReview.fxml"), resourceBundle);
            Parent root = loader.load();

            MovieScreenController controller = loader.getController();
            controller.setService(service);
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Failed to open the main screen", e);
            lblErrorMessage.setText("Failed to open the main screen");
        }
    }


    @FXML
    void onRegister(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        if (!service.usernameValidation(username)) {
            lblErrorMessage.setText("The username format is not valid. \n Letter and numbers only. \n Cannot start by number.");
        }
        else if (!service.passwordValidation(password)) {
            lblErrorMessage.setText("The password format is not valid. \nPassword requirement: \n\n - At least 8 characters.\n - Contains at least one uppercase letter, one lowercase letter, and one digit.");
        }
        else
        {
            service.register(txtUsername.getText(), txtPassword.getText());
            lblErrorMessage.setText("User created");
        }

    }

    @FXML
    void initialize() {
        assert lblErrorMessage != null : "fx:id=\"lblErrorMessage\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'Login.fxml'.";
    }

}
