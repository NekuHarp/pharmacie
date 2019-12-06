package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public abstract class Commerce {

    private String nom;
    private int nbEmploye;
    private ObservableList<Produit> listeProduit;
    private LocalDate datePartenariat;

    public Commerce(String nom, int nbEmploye, LocalDate date){
    	this.setNom(nom);
        this.setNbEmploye(nbEmploye);
        this.setDatePartenariat(date);
        
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

	public ObservableList<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(ObservableList<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}

	public abstract String getBonus();

    public abstract void setBonus(String x);

}

class CommerceIndependant extends Commerce {

	private double taille;
	
	private EtatAnnee etatAnnee;
    

    public CommerceIndependant(String nom, int nbEmploye, LocalDate date, double taille, int nbAnneePartenariat){
        super(nom, nbEmploye, date);
        
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

class CommerceFranchise extends Commerce {

	private String siret;

    public CommerceFranchise(String nom, int nbEmploye, LocalDate date, String siret){
    	super(nom, nbEmploye, date);
        this.setSiret(siret);
    }

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getBonus(){ return getSiret(); }

	public void setBonus(String x) { this.setSiret(x); }

}