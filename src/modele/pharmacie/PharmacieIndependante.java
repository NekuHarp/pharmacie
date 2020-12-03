package modele.pharmacie;

import modele.comptebancaire.CompteBancaire;
import modele.produit.Produit;

public class PharmacieIndependante extends Pharmacie {

    private String siret;

    public PharmacieIndependante(String nom, CompteBancaire compte, double taille, String siret){
        super(nom, compte, taille, siret);
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public boolean acheterProduit(Produit produit){
        if(this.getCompte().getMontant()>=produit.getPrixAchat()){
            this.getListeProduit().add(produit);
            this.getCompte().debiter(produit.getPrixAchat());
            return true;
        } else {
            return false;
        }
    }

}
