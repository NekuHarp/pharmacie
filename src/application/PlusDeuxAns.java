package application;

class PlusDeuxAns implements EtatAnnee {

    @Override
    public double calculRistourne(double montant) {
        return montant*0.1;
    }

    @Override
    public double calculPrixMinimumAchat() {
        return 80;
    }
}