package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PharmacienManager extends Pharmacien {

    public ObservableList<Pharmacie> listePharmacie;
    public PharmacienManager instance;

    public PharmacienManager(String nom, String prenom, String adresse, double sal) {
        super(nom, prenom, adresse, sal);
        this.setVentesTotal(0);
        instance = this;
        listePharmacie = FXCollections.observableArrayList();
    }
}
