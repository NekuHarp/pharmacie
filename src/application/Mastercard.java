package application;

class Mastercard implements ReseauBancaire {

    @Override
    public double calculTransaction(double montant) {
        return montant - montant*0.005;
    }

}