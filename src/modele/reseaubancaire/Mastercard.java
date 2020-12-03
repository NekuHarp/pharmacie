package modele.reseaubancaire;

public class Mastercard implements ReseauBancaire {

    @Override
    public double calculTransaction(double montant) {
        return montant - montant*0.005;
    }

    @Override
    public double calculRemboursement(double montant){
        return montant;
    }

}