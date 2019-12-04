package application;

import java.util.Date;

public class Produit {

    public String nom;
    public String variété;
    public double PrixInitial;
    public Date datePéremption;

    public Produit(String a, String b, double c, Date d){

        nom = a;
        variété = b;
        PrixInitial = c;
        datePéremption = d;

    }

}
