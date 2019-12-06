package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public abstract class Commerce {

    private String nom;
    private int nbEmploye;
    private ObservableList<Produit> listeProduit;
    private LocalDate datePartenariat;
    private CompteBancaire compte;

    public Commerce(String nom, int nbEmploye, LocalDate date, CompteBancaire compte){
    	this.setNom(nom);
        this.setNbEmploye(nbEmploye);
        this.setDatePartenariat(date);
        this.setCompte(compte);
        this.setListeProduit(FXCollections.observableArrayList());
    }

	public LocalDate getDatePartenariat() {
		return datePartenariat;
	}

	public void setDatePartenariat(LocalDate datePartenariat) {
		this.datePartenariat = datePartenariat;
	}

	public int getNbEmploye() {
		return nbEmploye;
	}

	public void setNbEmploye(int nbEmploye) {
		this.nbEmploye = nbEmploye;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public CompteBancaire getCompte() {
		return compte;
	}

	public void setCompte(CompteBancaire compte) {
		this.compte = compte;
	}

	public ObservableList<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(ObservableList<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}

	public abstract String getBonus();

    public abstract void setBonus(String x);

}