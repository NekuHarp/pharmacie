package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;

public abstract class Commerce {

    public String nom;
    public int nbEmployé;
    public ObservableList<Produit> listeProduit;
    public Date datePartenariat;

    public Commerce(){
        nom = null;
        nbEmployé = 0;
        listeProduit = FXCollections.observableArrayList();
        datePartenariat = null;
    }

}

class CommerceIndépendant extends Commerce {

    public double taille;

    public CommerceIndépendant(String a, int b, double c, Date d){
        nom = a;
        nbEmployé = b;
        listeProduit = FXCollections.observableArrayList();
        taille = c;
        datePartenariat = d;
    }

}

class CommerceFranchisé extends Commerce {

    public String siret;

    public CommerceFranchisé(String a, int b, String c, Date d){
        nom = a;
        nbEmployé = b;
        listeProduit = FXCollections.observableArrayList();
        siret = c;
        datePartenariat = d;
    }

}