package application.moteur.personne;

import application.moteur.anciennete.Anciennete;
import application.moteur.personne.Employe;

public class Preparateur extends Employe {

    private double coutHeures;
    private int nbrHeures;
    private Anciennete anciennete;

    public Preparateur(String nom, String prenom, String adresse, double cout, int nbrH, Anciennete anc) {
        super(nom, prenom, adresse);
        this.setCoutHeures(cout);
        this.setNbrHeures(nbrH);
        this.setAnciennete(anc);
    }

    public double getCoutHeures() {
        return coutHeures;
    }

    public void setCoutHeures(double coutHeures) {
        this.coutHeures = coutHeures;
    }

    public int getNbrHeures() {
        return nbrHeures;
    }

    public void setNbrHeures(int nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

    public Anciennete getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(Anciennete anciennete) {
        this.anciennete = anciennete;
    }

    public double calcSalaire(){
        return 0;
    }
}
