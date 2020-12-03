package modele.cartebancaire;

import modele.reseaubancaire.ReseauBancaire;

public class CartePharma extends CarteBancaire {

    double montantfinmois;

    public CartePharma(ReseauBancaire reseau, double x) {
        super(reseau, x);
        this.montantfinmois = 0;
    }

    public double getMontantfinmois() {
        return montantfinmois;
    }

    public void setMontantfinmois(double montantfinmois) {
        this.montantfinmois = montantfinmois;
    }

    public boolean paiement(double somme){
        if((montantfinmois+reseau.calculTransaction(somme))>montant){
            return false;
        } else {
            montantfinmois += reseau.calculTransaction(somme);
            return true;
        }
    }

    public void paiementmensuel(){
        montant = montant - montantfinmois;
        montantfinmois = 0;
    }

}
