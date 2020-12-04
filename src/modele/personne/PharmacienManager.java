package modele.personne;

import modele.pharmacie.Pharmacie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PharmacienManager extends Pharmacien {

    public ObservableList<Pharmacie> listePharmacie;
    public ObservableList<Client> listeClient;
    public PharmacienManager instance;

    public PharmacienManager(String nom, String prenom, String adresse, double sal) {
        super(nom, prenom, adresse, sal);
        this.setVentesTotal(0);
        instance = this;
        listePharmacie = FXCollections.observableArrayList();
        listeClient = FXCollections.observableArrayList();
    }

    public void addPharma(Pharmacie x){
        this.listePharmacie.add(x);
        x.addEmployee(this);
    }

    public void addClient(Client x){
        this.listeClient.add(x);
    }
}
