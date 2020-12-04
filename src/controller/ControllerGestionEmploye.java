package controller;

import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modele.personne.PharmacienManager;
import modele.pharmacie.Pharmacie;
import modele.produit.Produit;

import java.time.LocalDate;

public class ControllerGestionEmploye {

    @FXML
    private Pane ComFormPane;

    @FXML
    private Pane ItemListPane;

    @FXML
    private Pane ItemFormPane;

    @FXML
    private TextField nomPharma;

    @FXML
    private TextField nbEmployes;

    @FXML
    private TextField nomEmploye;

    @FXML
    private TextField prenomEmploye;

    @FXML
    private TextField PrixItemField;

    @FXML
    private TextField NameItemField;

    @FXML
    private TextField VarItemField;

    @FXML
    private TextField BonusComField;

    @FXML
    private DatePicker DateComPicker;

    @FXML
    private DatePicker DateItemPicker;

    @FXML
    private ComboBox TypeComCombo;

    @FXML
    private ComboBox CompteComCombo;

    @FXML
    private ComboBox ReseauComCombo;

    @FXML
    private ListView ComListview;

    @FXML
    private ListView listEmployes;


    @FXML
    private Button ajoutEmploye;

    @FXML
    private Button DeleteComBtn;

    @FXML
    private Button supprEmploye;

    @FXML
    private Button CancelBtn;

    @FXML
    private Label TypeComLabel;

    @FXML
    private Label NumComLabel;

    @FXML
    private Label CompteComLabel;

    @FXML
    private Label ReseauComLabel;

    private FadeTransition ft;
    private Pharmacie selectedcom;
    private Produit selecteditem;

    @FXML
    public void initialize(PharmacienManager pharmacienManager, Thread thread) {

        TypeComCombo.getItems().addAll("Indépendant","Franchisé");
        CompteComCombo.getItems().addAll("Classique","Client");
        ReseauComCombo.getItems().addAll("Visa","Mastercard");
        TypeComCombo.getSelectionModel().selectFirst();
        CompteComCombo.getSelectionModel().selectFirst();
        ReseauComCombo.getSelectionModel().selectFirst();

        ComListview.setItems(pharmacienManager.listePharmacie);

        ComListview.setCellFactory(param -> new ListCell<Pharmacie>() {
            @Override
            protected void updateItem(Pharmacie p, boolean empty){
                super.updateItem(p, empty);
                if(empty || p == null || p.getNom() == null){
                    setText("");
                }
                else{
                    setText(p.getNom());
                }
            }
        });

        listEmployes.setCellFactory(param -> new ListCell<Produit>() {
            @Override
            protected void updateItem(Produit p, boolean empty){
                super.updateItem(p, empty);
                if(empty || p == null || p.getNom() == null){
                    setText("");
                }
                else{
                    setText(p.getNom()+" "+p.getType());
                }
            }
        });

        ComListview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pharmacie>() {
            @Override
            public void changed(ObservableValue<? extends Pharmacie> observable, Pharmacie oldValue, Pharmacie newValue) {

                try {
                    ft = new FadeTransition(Duration.millis(200), ComFormPane);
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    ComFormPane.setDisable(false);
                    ft.setFromValue(0);
                    ft.setToValue(0);
                    ft.play();
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    ft = new FadeTransition(Duration.millis(200), ItemListPane);
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    ItemListPane.setDisable(false);
                    ft = new FadeTransition(Duration.millis(200), TypeComLabel);
                    ft.setFromValue(0);
                    ft.setToValue(0);
                    ft.play();
                    TypeComLabel.setDisable(true);
                    ft = new FadeTransition(Duration.millis(200), TypeComCombo);
                    ft.setFromValue(0);
                    ft.setToValue(0);
                    ft.play();
                    TypeComCombo.setDisable(true);
                    ft = new FadeTransition(Duration.millis(200), NumComLabel);
                    ft.setFromValue(0);
                    ft.setToValue(0);
                    ft.play();
                    NumComLabel.setDisable(true);

                    ft = new FadeTransition(Duration.millis(200), CompteComLabel);
                    ft.setFromValue(0);
                    ft.setToValue(0);
                    ft.play();
                    CompteComLabel.setDisable(true);
                    ft = new FadeTransition(Duration.millis(200), ReseauComLabel);
                    ft.setFromValue(0);
                    ft.setToValue(0);
                    ft.play();
                    ReseauComLabel.setDisable(true);
                    ft = new FadeTransition(Duration.millis(200), CompteComCombo);
                    ft.setFromValue(0);
                    ft.setToValue(0);
                    ft.play();
                    CompteComCombo.setDisable(true);
                    ft = new FadeTransition(Duration.millis(200), ReseauComCombo);
                    ft.setFromValue(0);
                    ft.setToValue(0);
                    ft.play();
                    ReseauComCombo.setDisable(true);

                    selectedcom=newValue;

                    nomPharma.setText(newValue.getNom());
                    nbEmployes.setText(newValue.getNbEmploye()+"");
                    listEmployes.setItems(selectedcom.getListeProduit());
                } catch(Exception ex) {

                }
            }
        });

        listEmployes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Produit>() {
            @Override
            public void changed(ObservableValue<? extends Produit> observable, Produit oldValue, Produit newValue) {

                try {
                    ft = new FadeTransition(Duration.millis(200), ItemFormPane);
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    ItemFormPane.setDisable(false);
                    ft.setFromValue(0);
                    ft.setToValue(0);
                    ft.play();
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    ft = new FadeTransition(Duration.millis(200), ItemListPane);
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    ItemListPane.setDisable(false);

                    selecteditem=newValue;

                    NameItemField.setText(newValue.getNom());
                    VarItemField.setText(newValue.getType());
                    DateComPicker.setValue(newValue.getDatePeremption());
                    PrixItemField.setText(newValue.getPrixAchat()+""); // pris initial = prix achat non ?
                } catch(Exception ex) {

                }

            }
        });

        DeleteComBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {


                pharmacienManager.listePharmacie.remove(selectedcom);
                ComListview.getSelectionModel().clearSelection();

                ft = new FadeTransition(Duration.millis(200), ComFormPane);
                ft.setFromValue(0);
                ft.setToValue(0);
                ft.play();
                ComFormPane.setDisable(true);
                ft = new FadeTransition(Duration.millis(200), ItemListPane);
                ft.setFromValue(0);
                ft.setToValue(0);
                ft.play();
                ItemListPane.setDisable(true);
                ft = new FadeTransition(Duration.millis(200), ItemFormPane);
                ft.setFromValue(0);
                ft.setToValue(0);
                ft.play();
                ItemFormPane.setDisable(true);
            }
        });

        ajoutEmploye.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                listEmployes.getSelectionModel().clearSelection();

                ft = new FadeTransition(Duration.millis(200), ItemFormPane);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                ItemFormPane.setDisable(false);
                ft.setFromValue(0);
                ft.setToValue(0);
                ft.play();
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();

                NameItemField.setText("");
                VarItemField.setText("");
                DateItemPicker.setValue(LocalDate.now());
                PrixItemField.setText("");

            }
        });

        supprEmploye.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {


                selectedcom.getListeProduit().remove(selecteditem);
                listEmployes.getSelectionModel().clearSelection();

                ft = new FadeTransition(Duration.millis(200), ItemFormPane);
                ft.setFromValue(0);
                ft.setToValue(0);
                ft.play();
                ItemFormPane.setDisable(true);

            }
        });

    }
}
