package project.tasks_management.presentation;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import project.tasks_management.entities.Intervenant;
import project.tasks_management.entities.Materiel;
import project.tasks_management.services.intervenant.intervenant;
import project.tasks_management.services.materiel.materiel;
import project.tasks_management.services.notification.notification;
import project.tasks_management.services.order_de_travail.order_de_travail;
import project.tasks_management.services.projet.projet;
import project.tasks_management.services.responsable.responsable;
import project.tasks_management.services.task.task;

import java.sql.SQLException;

public class ApplicationJavaFx extends Application
{


       public static void main(String[] args) {
         launch(args);
        }


@Override
public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("Views/login.fxml"));
        Scene scene = new Scene(root, 600 , 400);
        // get CSS
        //  scene.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
        }
}