package application;

class EntreTroisEtSix implements Anciennete {

    @Override
    public double calculBonus(double montant) {
        return montant*0.1;
    }

}