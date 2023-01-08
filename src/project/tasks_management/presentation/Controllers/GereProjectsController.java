package project.tasks_management.presentation.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import project.tasks_management.entities.Projet;
import project.tasks_management.entities.Responsable;
import project.tasks_management.services.responsable.responsable;
import project.tasks_management.services.projet.projet;


public class GereProjectsController implements Initializable {
    responsable responsableImlp = new responsable();
    projet projetImpl = new projet();

    @FXML
    private ChoiceBox<String> choiPriorité;

    @FXML
    private ChoiceBox<String> choiResponsable;

    @FXML
    private Button home;

    @FXML
    private Button ajouterProjet;

    @FXML
    private TextField titre;
    @FXML
    private DatePicker dateDebut;

    @FXML
    private DatePicker dateFin;
    private String[] prioritéChoix = {"low" , "high"};
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiPriorité.getItems().addAll(prioritéChoix);
        try {
            List<Responsable> responsables = responsableImlp.retournerResponsables();
            for (Responsable res: responsables) {
                choiResponsable.getItems().add(res.getNOM());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getHomeScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./../Views/dashboard.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setTitle("dashboard");
        window.setScene(new Scene(root , 600, 400));
    }

    public void ajouterProjectHandler() throws SQLException {
        System.out.println("Hello Abdelmalek");
        String title = titre.getText();
       // Date date_debut = (Date) dateDebut.getDayCellFactory();
        LocalDate date_debut = dateDebut.getValue();
       // Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        // Date date = Date.from(instant);
        Date date_fin = Date.valueOf(dateFin.getValue());
      //  Instant instant = Instant.from(date_fin.atStartOfDay(ZoneId.systemDefault()));
       // Date date = (Date) Date.from(instant);

        String res = choiResponsable.getValue();
        String prio = choiPriorité.getValue();

        projetImpl.ajouterProjet(new  Projet(1 , title , date_fin , responsableImlp.retournerResponsableParId(16)));

    }


}
