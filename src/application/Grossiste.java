package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Grossiste {

    public ObservableList<Produit> listeProduit;
    public ObservableList<Commerce> listeCommerce;
    public Grossiste instance;

    public Grossiste(){

        instance = this;
        listeCommerce = FXCollections.observableArrayList();
        listeProduit = FXCollections.observableArrayList();

    }

}
