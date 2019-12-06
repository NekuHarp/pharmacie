package application;

import java.time.LocalDate;

class CommerceIndependant extends Commerce {

    private double taille;

    private EtatAnnee etatAnnee;


    public CommerceIndependant(String nom, int nbEmploye, LocalDate date, CompteBancaire compte, double taille, int nbAnneePartenariat){
        super(nom, nbEmploye, date, compte);

        this.setTaille(taille);

        EtatAnnee newEtatAnnee;
        if (nbAnneePartenariat < 2) {
            newEtatAnnee = new MoinsDeuxAns();
        }
        else if (nbAnneePartenariat > 4) {
            newEtatAnnee = new PlusCinqAns();
        }
        else {
            newEtatAnnee = new PlusCinqAns();
        }
        this.setEtatAnnee(newEtatAnnee);
    }


    public double getTaille() {
        return taille;
    }


    public void setTaille(double taille) {
        this.taille = taille;
    }


    public EtatAnnee getEtatAnnee() {
        return etatAnnee;
    }


    public void setEtatAnnee(EtatAnnee etatAnnee) {
        this.etatAnnee = etatAnnee;
    }

    public String getBonus(){ return getTaille()+""; }

    public void setBonus(String x) { this.setTaille(Double.parseDouble(x)); }

}
