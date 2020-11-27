package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Pharmacie {

    private String nom;
    private int nbEmploye;
    private ObservableList<Produit> listeProduit;
	private ObservableList<Employe> listeEmploye;
    private CompteBancaire compte;
    private String siret;

    public Pharmacie(String nom, int nbEmploye, CompteBancaire compte, String siret){
    	this.setNom(nom);
        this.setNbEmploye(nbEmploye);
        this.setCompte(compte);
        this.setListeProduit(FXCollections.observableArrayList());
		this.setSiret(siret);
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

	public ObservableList<Employe> getListeEmploye() {
		return listeEmploye;
	}

	public void setListeEmploye(ObservableList<Employe> listeEmploye) {
		this.listeEmploye = listeEmploye;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}
}