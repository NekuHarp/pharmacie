package application;

public class Pharmacien extends Employe {

    private double salaire;
    private double ventesTotal;

    public Pharmacien(String nom, String prenom, String adresse, double sal) {
        super(nom, prenom, adresse);
        this.setSalaire(sal);
        this.setVentesTotal(0);
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public double getVentesTotal() {
        return ventesTotal;
    }

    public void setVentesTotal(double ventesTotal) {
        this.ventesTotal = ventesTotal;
    }

    public double calcSalaire(){
        return salaire+(ventesTotal*0.01);
    }
}
