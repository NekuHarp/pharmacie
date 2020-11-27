package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Grossiste {

    public ObservableList<Produit> listeProduit;
    public ObservableList<Pharmacie> listePharmacie;
    public Grossiste instance;

    public Grossiste(){
        instance = this;
        listePharmacie = FXCollections.observableArrayList();
        listeProduit = FXCollections.observableArrayList();
    }

}
