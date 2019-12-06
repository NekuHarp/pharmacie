package application;
import javafx.animation.*;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Controller {

    @FXML
    private Pane ComFormPane;

    @FXML
    private Pane ItemListPane;

    @FXML
    private Pane ItemFormPane;

    @FXML
    private TextField NameComField;

    @FXML
    private TextField NbrEmpComField;

    @FXML
    private TextField CompteComField;

    @FXML
    private TextField NbrItemField;

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
    private ListView ComListview;

    @FXML
    private ListView ItemListview;

    @FXML
    private Button ValComBtn;

    @FXML
    private Button AddComBtn;

    @FXML
    private Button AddListComBtn;

    public Grossiste grossiste = new Grossiste();
    private FadeTransition ft;
    private Commerce selectedcom;
    private int selectedcomindex;
    private Produit selecteditem;
    private int selecteditemindex;

    public Controller() {
    }

    @FXML
    private void initialize() {
        
		CommerceFranchise Test = new CommerceFranchise("Test",25,LocalDate.of(1996, Month.DECEMBER, 30),"s1r3tlol");
        grossiste.listeCommerce.add(Test);
        LocalDate dateexemple = LocalDate.of(1998, Month.MAY, 31);
        CommerceIndependant Test2 = new CommerceIndependant("Test2",450,dateexemple,1000, LocalDate.now().getYear()-dateexemple.getYear());
        grossiste.listeCommerce.add(Test2);

        TypeComCombo.getItems().addAll("Indépendant","Franchisé");
        CompteComCombo.getItems().addAll("Visa","Mastercard");
        TypeComCombo.getSelectionModel().selectFirst();
        CompteComCombo.getSelectionModel().selectFirst();

        /*TypeComCombo.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                System.out.println(ov);
                System.out.println(t);
                System.out.println(t1);
            }
        });

        CompteComCombo.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                System.out.println(ov);
                System.out.println(t);
                System.out.println(t1);
            }
        });*/

        ComListview.setItems(grossiste.listeCommerce);

        ItemListview.setItems(grossiste.listeProduit);

        ComListview.setCellFactory(param -> new ListCell<Commerce>() {
            @Override
            protected void updateItem(Commerce p, boolean empty){
                super.updateItem(p, empty);
                if(empty || p == null || p.getNom() == null){
                    setText("");
                }
                else{
                    setText(p.getNom());
                }
            }
        });

        ComListview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Commerce>() {
            @Override
            public void changed(ObservableValue<? extends Commerce> observable, Commerce oldValue, Commerce newValue) {

                ft = new FadeTransition(Duration.millis(200), ComFormPane);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                ComFormPane.setDisable(false);
                ft = new FadeTransition(Duration.millis(200), AddComBtn);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
                AddComBtn.setDisable(true);
                ft = new FadeTransition(Duration.millis(200), ValComBtn);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                ValComBtn.setDisable(false);
                ft = new FadeTransition(Duration.millis(200), ItemListPane);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                ItemListPane.setDisable(false);

                selectedcom=newValue;

                NameComField.setText(newValue.getNom());
                TypeComCombo.setDisable(true);
                NbrEmpComField.setText(newValue.getNbEmploye()+"");
                DateComPicker.setValue(newValue.getDatePartenariat());
                BonusComField.setText(newValue.getBonus());
                ItemListview.setItems(selectedcom.getListeProduit());


            }
        });

        /*ComListview.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + ComListview.getSelectionModel().getSelectedItem());
            }
        });*/

        //ItemListview.setItems(grossiste.listeProduit);

        ValComBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                Commerce temp = selectedcom;

                temp.setNom(NameComField.getText());
                temp.setNbEmploye(Integer.parseInt(NbrEmpComField.getText()));
                temp.setDatePartenariat(DateComPicker.getValue());
                temp.setBonus(BonusComField.getText());

                grossiste.listeCommerce.remove(selectedcom);
                grossiste.listeCommerce.add(temp);
                ComListview.getSelectionModel().clearSelection();

                ft = new FadeTransition(Duration.millis(200), ComFormPane);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
                ComFormPane.setDisable(true);
                ft = new FadeTransition(Duration.millis(200), ItemListPane);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
                ItemListPane.setDisable(true);

            }
        });

        AddComBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                /*System.out.println(NameComField.getText());
                System.out.println(NbrEmpComField.getText());
                System.out.println(DateComPicker.getValue().toString());
                System.out.println(BonusComField.getText());*/

                if(TypeComCombo.getValue().equals("Indépendant")){
                    CommerceIndependant x = new CommerceIndependant(NameComField.getText(),Integer.parseInt(NbrEmpComField.getText()),DateComPicker.getValue(),Double.parseDouble(BonusComField.getText()),LocalDate.now().getYear()-DateComPicker.getValue().getYear());
                    grossiste.listeCommerce.add(x);
                } else {
                    CommerceFranchise x = new CommerceFranchise(NameComField.getText(),Integer.parseInt(NbrEmpComField.getText()),DateComPicker.getValue(),BonusComField.getText());
                    grossiste.listeCommerce.add(x);
                }

                ft = new FadeTransition(Duration.millis(200), ComFormPane);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
                ComFormPane.setDisable(true);
            }
        });

        AddListComBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                ft = new FadeTransition(Duration.millis(200), ComFormPane);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                ComFormPane.setDisable(false);
                ft = new FadeTransition(Duration.millis(200), ValComBtn);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
                ValComBtn.setDisable(true);
                ft = new FadeTransition(Duration.millis(200), AddComBtn);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                AddComBtn.setDisable(false);
                ft = new FadeTransition(Duration.millis(200), ItemListPane);
                ft.setFromValue(0);
                ft.setToValue(0);
                ft.play();
                ItemListPane.setDisable(true);

                NameComField.setText("");
                TypeComCombo.setDisable(false);
                NbrEmpComField.setText("");
                DateComPicker.setValue(LocalDate.now());
                BonusComField.setText("");

            }
        });


    }
}
