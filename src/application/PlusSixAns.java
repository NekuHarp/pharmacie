package application;

class PlusSixAns implements Anciennete {

    @Override
    public double calculBonus(double montant) {
        return montant*0.2;
    }
}