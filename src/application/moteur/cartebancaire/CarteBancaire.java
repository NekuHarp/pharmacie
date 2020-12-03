package application.moteur.cartebancaire;

import application.moteur.reseaubancaire.ReseauBancaire;

public abstract class CarteBancaire {

    ReseauBancaire reseau;
    double montant;

    public CarteBancaire(ReseauBancaire reseau, double x) {
        this.reseau = reseau;
        this.montant = x;
    }

    public ReseauBancaire getReseau() {
        return reseau;
    }

    public void setReseau(ReseauBancaire reseau) {
        this.reseau = reseau;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public abstract boolean paiement(double somme);

    public void remboursement(double somme){
        montant += reseau.calculRemboursement(somme);
    }
}
