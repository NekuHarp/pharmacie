package application.moteur.anciennete;

class EntreTroisEtSix implements Anciennete {

    @Override
    public double calculBonus(double montant) {
        return montant*0.1;
    }

}