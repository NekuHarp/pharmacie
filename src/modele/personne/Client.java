package modele.personne;

import modele.cartebancaire.CarteBancaire;
import modele.produit.Produit;
import javafx.collections.ObservableList;

public class Client extends Personne {

    private ObservableList<CarteBancaire> cartes;

    public Client(String nom, String prenom, String adresse) {
        super(nom, prenom, adresse);
    }

    public boolean acheter(Produit produit, CarteBancaire carte){
        // TODO : Rafraîchir l'interface pour le pattern Observer
        return carte.paiement(produit.getPrixVente());
    }

}
