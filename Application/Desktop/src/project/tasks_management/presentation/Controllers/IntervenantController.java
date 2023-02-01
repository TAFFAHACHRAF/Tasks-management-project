package project.tasks_management.presentation.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Builder;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import project.tasks_management.entities.Intervenant;
import project.tasks_management.entities.Projet;
import project.tasks_management.entities.User;
import project.tasks_management.services.intervenant.intervenant;
public class IntervenantController implements Initializable {

    intervenant interImpl = new intervenant();

    @FXML
    private TextField CIN;

    @FXML
    private TextField FirstNom;

    @FXML
    private TextField Tel;

    @FXML
    private TextField email;
    @FXML
    private TextField lastNom;
    @FXML
    private Button ajouterIntervenant;

    @FXML
    private TableColumn nom;
    @FXML
    private TableColumn prenom;
    @FXML
    private TableColumn cin;

    @FXML
    private TableColumn phone;

    @FXML
    private TableColumn actions;

    @FXML
    private TableView table = new TableView();

    @FXML
    private Button home;

    private ObservableList<User> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nom.setCellValueFactory(
                new PropertyValueFactory<User,String>("NOM")
        );
        prenom.setCellValueFactory(
                new PropertyValueFactory<User,String>("PRENOM")
        );
        cin.setCellValueFactory(
                new PropertyValueFactory<User,String>("CIN")
        );

        phone.setCellValueFactory(
                new PropertyValueFactory<User,String>("TEL")
        );

        actions.setCellValueFactory(
                new PropertyValueFactory<String,String>("NOM")
        );

        try {
            List<Intervenant> intervenants = interImpl.retournerIntervenants();
            for (Intervenant inter:intervenants) {
                observableList.add(inter)  ;
            }
            table.setItems(observableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void getAjouterIntervenantScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./../Views/ajouterIntervenat.fxml"));
        Stage window = (Stage) ajouterIntervenant.getScene().getWindow();
        window.setTitle("ajouter intervenant");
        window.setScene(new Scene(root , 600, 400));
    }

    public void getHomeScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./../Views/dashboard.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setTitle("ajouter intervenant");
        window.setScene(new Scene(root , 600, 400));
    }


}
