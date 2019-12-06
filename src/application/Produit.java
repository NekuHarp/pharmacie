package application;

import java.time.LocalDate;

public class Produit {

    private String nom;
    private String variete;
    private double prixInitial;
    private LocalDate datePeremption;


	public Produit(String nom, String variete, double prixInitial, LocalDate datePeremption){

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

	public LocalDate getDatePeremption() {
		return datePeremption;
	}

	public void setDatePeremption(LocalDate datePeremption) {
		this.datePeremption = datePeremption;
	}

}
