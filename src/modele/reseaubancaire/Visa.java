package modele.reseaubancaire;

import modele.pays.Pays;

public class Visa implements ReseauBancaire{

    private Pays pays;

    public Visa(Pays pays) {
        this.pays = pays;
    }

    @Override
    public double calculTransaction(double montant) {
        return montant - montant*0.0025;
    }

    @Override
    public double calculRemboursement(double montant){
        switch (this.pays.getNom()) {
            case "France":
                return montant - montant*0;
            case "Espagne":
                return montant - montant*0.001;
            case "Etats-Unis":
                return montant - montant*0.002;
            case "Portugal":
                return montant - montant*0.0015;
            case "Royaume-Uni":
                return montant - montant*0.0025;
            default:
                return montant - montant*0.003;
        }
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
}
