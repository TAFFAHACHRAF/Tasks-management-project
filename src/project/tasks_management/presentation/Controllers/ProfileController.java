package project.tasks_management.presentation.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    @FXML
    private Button modifierProfileBtn;
    @FXML
    private Button home;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getModifierProfilePage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./../Views/modiferProfile.fxml"));
        Stage window = (Stage) modifierProfileBtn.getScene().getWindow();
        window.setTitle("projects");
        window.setScene(new Scene(root , 600, 400));
    }

    public void goHome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./../Views/dashboard.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setTitle("dashboard");
        window.setScene(new Scene(root , 600, 400));
    }
}
