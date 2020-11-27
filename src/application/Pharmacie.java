package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Pharmacie {

    private String nom;
    private int nbEmploye;
    private ObservableList<Produit> listeProduit;
	private ObservableList<Employe> listeEmploye;
    private CompteBancaire compte;
    private double taille;
    private String siret;
    private double chiffreAffaires;

    public Pharmacie(String nom, int nbEmploye, CompteBancaire compte, double taille, String siret){
    	this.setNom(nom);
        this.setNbEmploye(nbEmploye);
        this.setCompte(compte);
        this.setListeProduit(FXCollections.observableArrayList());
        this.setTaille(taille);
		this.setSiret(siret);
		this.chiffreAffaires = 0;
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

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public double getChiffreAffaires() {
		return chiffreAffaires;
	}

	public void setChiffreAffaires(double chiffreAffaires) {
		this.chiffreAffaires = chiffreAffaires;
	}

	public boolean canPayEmployees(){
    	double temp = 0;
		for (int i = 0; i < listeEmploye.size(); i++) {
			temp += listeEmploye.get(i).calcSalaire();
		}
		if(temp>compte.getMontant()){
			return false;
		} else {
			return true;
		}
	}

	public void payEmployees(){
    	if(canPayEmployees()){
			double temp = 0;
			for (int i = 0; i < listeEmploye.size(); i++) {
				temp += listeEmploye.get(i).calcSalaire();
			}
			compte.debiter(temp);
		}
	}

	public abstract void acheterProduit(Produit produit);

	public void vendreProduit(Produit produit){
		if(listeProduit.contains(produit)){
			listeProduit.remove(produit);
			compte.ajoutargent(produit.getPrixVente());
		}
	}
}