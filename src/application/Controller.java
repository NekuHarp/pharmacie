package application;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.File;
import java.util.Date;

public class Controller {

    @FXML
    private TextField NameComField;

    @FXML
    private TextField NbrEmpComField;

    @FXML
    private TextField CompteComField;

    @FXML
    private DatePicker DateComPicker;

    @FXML
    private TextField NbrItemField;

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

    public Grossiste grossiste = new Grossiste();

    public Controller() {
    }

    @FXML
    private void initialize() {

        NbrItemField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("\\d*")) {
                    int value = Integer.parseInt(newValue);
                } else {
                    NbrItemField.setText(oldValue);
                }
            }
        });

        
		CommerceFranchise Test = new CommerceFranchise("Test",123,new Date(1996,12,30),"s1r3tlol");
        grossiste.listeCommerce.add(Test);

        TypeComCombo.getItems().addAll("Independant","Franchise");
        CompteComCombo.getItems().addAll("Visa","Mastercard");
        TypeComCombo.getSelectionModel().selectFirst();
        CompteComCombo.getSelectionModel().selectFirst();

        TypeComCombo.valueProperty().addListener(new ChangeListener<String>() {
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
        });

        ComListview.setItems(grossiste.listeCommerce);

        ItemListview.setItems(grossiste.listeProduit);



        ValComBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println(NameComField.getText());
            }
        });

    }
}
