package application;

public class CarteClassique extends CarteBancaire {

    public CarteClassique(ReseauBancaire reseau, double x) {
        super(reseau, x);
    }

    public boolean paiement(double somme){
        if(reseau.calculTransaction(somme)>montant){
            return false;
        } else {
            montant = montant - reseau.calculTransaction(somme);
            return true;
        }
    }

}
