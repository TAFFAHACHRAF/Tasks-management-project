package project.tasks_management.presentation.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import project.tasks_management.services.ExportData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {

    @FXML
    private Button getCharts;

    @FXML
    private Button getIntervenant;

    @FXML
    private Button getProjects;

    @FXML
    private Button getTasks;

    @FXML
    private Button getprofile;

    @FXML
    private Button home;

    @FXML
    private Button importExport;

    @FXML
    private Button logout;

    @FXML
    private Button tacheAffectation;

    @FXML
    private Button tasks;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getProjectsScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./../Views/projects.fxml"));
        Stage window = (Stage) getProjects.getScene().getWindow();
        window.setTitle("projects");
        window.setScene(new Scene(root , 600, 400));
    }

    public void getInterenantsList() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./../Views/Intervanats.fxml"));
        Stage window = (Stage) getIntervenant.getScene().getWindow();
        window.setTitle("projects");
        window.setScene(new Scene(root , 600, 400));
    }

    public void getTasksList() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./../Views/Tasks.fxml"));
        Stage window = (Stage) getTasks.getScene().getWindow();
        window.setTitle("Tasks");
        window.setScene(new Scene(root , 600, 400));
    }

    public void logSceneOut() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./../Views/login.fxml"));
        Stage window = (Stage) logout.getScene().getWindow();
        window.setTitle("login");
        window.setScene(new Scene(root , 600, 400));
    }

    public void getProfileScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./../Views/profile.fxml"));
        Stage window = (Stage) getprofile.getScene().getWindow();
        // call the profile class to file the informations
        window.setTitle("profile");
        window.setScene(new Scene(root , 600, 400));
    }

    public void getHomeScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./../Views/dashboard.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setTitle("dashboard");
        window.setScene(new Scene(root , 600, 400));
    }

    public void getTacheAffectationScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./../Views/affectation.fxml"));
        Stage window = (Stage) tacheAffectation.getScene().getWindow();
        window.setTitle("dashboard");
        window.setScene(new Scene(root , 600, 400));
    }

    public void exportData() throws SQLException, FileNotFoundException {
        ExportData exportData = new ExportData();
        exportData.exportData("project_data.csv");
        System.out.println("Clicked");
    }

}
