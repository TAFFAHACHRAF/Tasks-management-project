package project.tasks_management.presentation.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import netscape.security.UserTarget;
import project.tasks_management.entities.Intervenant;
import project.tasks_management.services.intervenant.intervenant;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField emailLogin;

    @FXML
    private Button loginButton;

    @FXML
    private Text errorMessage;

    @FXML
    private TextField passwordLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void loginButtonFunc() throws IOException {
        intervenant intervenant = new intervenant();
        String email = emailLogin.getText();
        String password = passwordLogin.getText();
       // intervenant.findByEmailAndPassword();

        Intervenant intervenant1 = intervenant.findByEmailAndPassword(email , password);

        if (intervenant1.getNOM() == "") {
            System.out.println("Nom : " + intervenant1.getNOM());
            errorMessage.setText("Something wen wrong");
        } else {
            System.out.println("Nom : " + intervenant1.getNOM());
            Parent root = FXMLLoader.load(getClass().getResource("./../Views/dashboard.fxml"));
            Stage window = (Stage) loginButton.getScene().getWindow();
            window.setTitle("Dashboard");
            window.setScene(new Scene(root , 600, 400));
        }


    }

    public void forgetPassword() {

    }

}
