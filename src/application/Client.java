package application;

import javafx.collections.ObservableList;

public class Client extends Personne {

    private ObservableList<CarteBancaire> cartes;

    public Client(String nom, String prenom, String adresse) {
        super(nom, prenom, adresse);
    }

}
