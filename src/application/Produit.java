package application;

import java.util.Date;

public class Produit {

    private String nom;
    private String variete;
    private double prixInitial;
    private Date datePeremption;


	public Produit(String nom, String variete, double prixInitial, Date datePeremption){

        this.nom = nom;
        this.variete = variete;
        this.prixInitial = prixInitial;
        this.datePeremption = datePeremption;

    }
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVariete() {
		return variete;
	}

	public void setVariete(String variete) {
		this.variete = variete;
	}

	public double getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(double prixInitial) {
		this.prixInitial = prixInitial;
	}

	public Date getDatePeremption() {
		return datePeremption;
	}

	public void setDatePeremption(Date datePeremption) {
		this.datePeremption = datePeremption;
	}

}
