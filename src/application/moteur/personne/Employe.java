package application.moteur.personne;

public abstract class Employe extends Personne {

    private double salaireFinal;

    public Employe(String nom, String prenom, String adresse) {
        super(nom, prenom, adresse);
    }

    public abstract double calcSalaire();

}
