package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.SnapshotParameters;

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
    
    public void createSnapshot(ObservableList<Commerce> listeCommerce) {
    	AllSnapShot.getAllSnapshotInstance().addSnapshot(new Snapshot(listeCommerce)); 
    }

}
