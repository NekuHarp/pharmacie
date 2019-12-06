package application;

class PlusCinqAns implements EtatAnnee {

    @Override
    public double calculRistourne(double montant) {
        return montant*0.2;
    }

    @Override
    public double calculPrixMinimumAchat() {
        return 50;
    }
}