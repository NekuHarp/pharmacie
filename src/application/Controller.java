package application;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.time.LocalDate;
import java.time.Month;

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
    private ComboBox ReseauComCombo;

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

    @FXML
    private Button ValItemBtn;

    @FXML
    private Button AddItemBtn;

    @FXML
    private Button AddListItemBtn;

    @FXML
    private Button DeleteComBtn;

    @FXML
    private Button DeleteItemBtn;

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

    private PharmacienManager pharmacienManager = new PharmacienManager("Bonbeurre", "Jean", "35 Rue du pique-nique", 9001);
    private FadeTransition ft;
    private Pharmacie selectedcom;
    private Produit selecteditem;

    public Controller() {
    }

    @FXML
    private void initialize() {

        ReseauBancaire testreseau = new Mastercard();
        CompteBancaire testcompte = new CompteClassique(testreseau);
        CompteBancaire testcompte2 = new CompteFranchise(testreseau);
		Pharmacie Test = new PharmacieFranchise("Lidl",2500, testcompte, 30,"siretoui420420");
        pharmacienManager.listePharmacie.add(Test);
        LocalDate dateexemple = LocalDate.of(1998, Month.MAY, 31);
        Pharmacie Test2 = new PharmacieIndependante("Leclerc",4500, testcompte2, 50,"siretnon42069");
        pharmacienManager.listePharmacie.add(Test2);

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

        ItemListview.setCellFactory(param -> new ListCell<Produit>() {
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
                    ft = new FadeTransition(Duration.millis(200), AddComBtn);
                    ft.setFromValue(0);
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
                    ft = new FadeTransition(Duration.millis(200), CompteComField);
                    ft.setFromValue(0);
                    ft.setToValue(0);
                    ft.play();
                    CompteComField.setDisable(true);
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

                    NameComField.setText(newValue.getNom());
                    NbrEmpComField.setText(newValue.getNbEmploye()+"");
                    ItemListview.setItems(selectedcom.getListeProduit());
                } catch(Exception ex) {

                }
            }
        });

        ItemListview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Produit>() {
            @Override
            public void changed(ObservableValue<? extends Produit> observable, Produit oldValue, Produit newValue) {

                try {
                    ft = new FadeTransition(Duration.millis(200), ItemFormPane);
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    ItemFormPane.setDisable(false);
                    ft = new FadeTransition(Duration.millis(200), AddItemBtn);
                    ft.setFromValue(0);
                    ft.setToValue(0);
                    ft.play();
                    AddItemBtn.setDisable(true);
                    ft = new FadeTransition(Duration.millis(200), ValItemBtn);
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    ValItemBtn.setDisable(false);
                    ft = new FadeTransition(Duration.millis(200), ItemListPane);
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    ItemListPane.setDisable(false);

                    selecteditem=newValue;

                    NameItemField.setText(newValue.getNom());
                    NbrItemField.setDisable(true);
                    NbrItemField.setText("1");
                    VarItemField.setText(newValue.getType());
                    DateComPicker.setValue(newValue.getDatePeremption());
                    PrixItemField.setText(newValue.getPrixAchat()+""); // pris initial = prix achat non ?
                } catch(Exception ex) {

                }

            }
        });

        ValComBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                Pharmacie temp = selectedcom;

                temp.setNom(NameComField.getText());
                temp.setNbEmploye(Integer.parseInt(NbrEmpComField.getText()));
                temp.setSiret(BonusComField.getText());


                pharmacienManager.listePharmacie.remove(selectedcom);
                pharmacienManager.listePharmacie.add(temp);
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
                ft = new FadeTransition(Duration.millis(200), ItemFormPane);
                ft.setFromValue(0);
                ft.setToValue(0);
                ft.play();
                ItemFormPane.setDisable(true);

            }
        });

        AddComBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ReseauBancaire reseau;
                if(ReseauComCombo.getValue().equals("Mastercard")){
                    reseau = new Mastercard();
                } else {
                    reseau = new Visa(new Pays("France"));
                }
                CompteBancaire compte;
                if(CompteComCombo.getValue().equals("Classique")){
                    compte = new CompteClassique(reseau);
                } else {
                    compte = new CompteFranchise(reseau);
                }


                if(TypeComCombo.getValue().equals("Indépendant")){
                    Pharmacie x = new PharmacieIndependante(NameComField.getText(),Integer.parseInt(NbrEmpComField.getText()),compte, /*Integer.parseInt(TaillePharma.getText())*/ 20,BonusComField.getText());
                    pharmacienManager.listePharmacie.add(x);
                } else {
                    Pharmacie x = new PharmacieFranchise(NameComField.getText(),Integer.parseInt(NbrEmpComField.getText()),compte, /*Integer.parseInt(TaillePharma.getText())*/ 20,BonusComField.getText());
                    pharmacienManager.listePharmacie.add(x);
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

                ComListview.getSelectionModel().clearSelection();

                ft = new FadeTransition(Duration.millis(200), ComFormPane);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                ComFormPane.setDisable(false);
                ft = new FadeTransition(Duration.millis(200), ValComBtn);
                ft.setFromValue(0);
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
                ft = new FadeTransition(Duration.millis(200), ItemFormPane);
                ft.setFromValue(0);
                ft.setToValue(0);
                ft.play();
                ItemFormPane.setDisable(true);
                ft = new FadeTransition(Duration.millis(200), TypeComLabel);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                TypeComLabel.setDisable(false);
                ft = new FadeTransition(Duration.millis(200), TypeComCombo);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                TypeComCombo.setDisable(false);
                ft = new FadeTransition(Duration.millis(200), NumComLabel);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                NumComLabel.setDisable(false);
                ft = new FadeTransition(Duration.millis(200), CompteComField);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                CompteComField.setDisable(false);
                ft = new FadeTransition(Duration.millis(200), CompteComLabel);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                CompteComLabel.setDisable(false);
                ft = new FadeTransition(Duration.millis(200), ReseauComLabel);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                ReseauComLabel.setDisable(false);
                ft = new FadeTransition(Duration.millis(200), CompteComCombo);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                CompteComCombo.setDisable(false);
                ft = new FadeTransition(Duration.millis(200), ReseauComCombo);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                ReseauComCombo.setDisable(false);

                NameComField.setText("");
                TypeComCombo.getSelectionModel().selectFirst();
                NbrEmpComField.setText("");
                DateComPicker.setValue(LocalDate.now());
                BonusComField.setText("");
                CompteComField.setText("");
                CompteComCombo.getSelectionModel().selectFirst();
                ReseauComCombo.getSelectionModel().selectFirst();
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

        ValItemBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                Produit temp = selecteditem;

                temp.setNom(NameItemField.getText());
                temp.setDatePeremption(DateComPicker.getValue());
                temp.setType(VarItemField.getText());
                temp.setPrixAchat(Double.parseDouble(PrixItemField.getText())); // prix achat = prix initial non ?

                selectedcom.getListeProduit().remove(selecteditem);
                selectedcom.getListeProduit().add(temp);
                ItemListview.getSelectionModel().clearSelection();

                NbrItemField.setDisable(false);

                ft = new FadeTransition(Duration.millis(200), ItemFormPane);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
                ItemFormPane.setDisable(true);

            }
        });

        AddItemBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {


                for(int i = 0; i<Integer.parseInt(NbrItemField.getText());i++){
                    // TODO : ici prix achat = prix de vente -> à modifier
                    Produit temp = new Produit(NameItemField.getText(),VarItemField.getText(),Double.parseDouble(PrixItemField.getText()), Double.parseDouble(PrixItemField.getText()),DateComPicker.getValue());
                    selectedcom.getListeProduit().add(temp);
                    selectedcom.getCompte().debiter(Double.parseDouble(PrixItemField.getText()));

                }

                ft = new FadeTransition(Duration.millis(200), ItemFormPane);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
                ItemFormPane.setDisable(true);
            }
        });

        AddListItemBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                ItemListview.getSelectionModel().clearSelection();

                ft = new FadeTransition(Duration.millis(200), ItemFormPane);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                ItemFormPane.setDisable(false);
                ft = new FadeTransition(Duration.millis(200), ValItemBtn);
                ft.setFromValue(0);
                ft.setToValue(0);
                ft.play();
                ValItemBtn.setDisable(true);
                ft = new FadeTransition(Duration.millis(200), AddItemBtn);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
                AddItemBtn.setDisable(false);

                NameItemField.setText("");
                NbrItemField.setDisable(false);
                NbrItemField.setText("");
                VarItemField.setText("");
                DateItemPicker.setValue(LocalDate.now());
                PrixItemField.setText("");

            }
        });

        DeleteItemBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {


                selectedcom.getListeProduit().remove(selecteditem);
                ItemListview.getSelectionModel().clearSelection();

                ft = new FadeTransition(Duration.millis(200), ItemFormPane);
                ft.setFromValue(0);
                ft.setToValue(0);
                ft.play();
                ItemFormPane.setDisable(true);

            }
        });

    }
}
