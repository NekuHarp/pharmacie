package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.personne.PharmacienManager;
import vue.Main;

import java.io.IOException;

public class ControllerMenu {

    @FXML
    private Button gestionPharma;

    @FXML
    private Button gestionEmployes;

    @FXML
    public void initialize(PharmacienManager pharmacienManager, Thread thread) {

        gestionPharma.setOnAction((event) -> {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Sample.fxml"));
            Pane page = null;
            try {
                page = (Pane) loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene nouvelleFenetre = new Scene(page, 800, 600);
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(nouvelleFenetre);
            primaryStage.setResizable(false);
            primaryStage.show();
            Controller controller = loader.<Controller>getController();

            try {
                controller.initialize(pharmacienManager, null);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        gestionEmployes.setOnAction((event) -> {
            FXMLLoader loader2 = new FXMLLoader(Main.class.getResource("GestionEmploye.fxml"));
            Pane page2 = null;
            try {
                page2 = (Pane) loader2.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene nouvelleFenetre2 = new Scene(page2, 800, 600);
            Stage secondStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            secondStage.setScene(nouvelleFenetre2);
            secondStage.setResizable(false);
            secondStage.show();
            ControllerGestionEmploye controller2 = loader2.<ControllerGestionEmploye>getController();

            try {
                controller2.initialize(pharmacienManager, null);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }
}