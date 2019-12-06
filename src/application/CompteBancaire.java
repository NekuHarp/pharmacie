package application;

public abstract class CompteBancaire {

    private double montant;

    private ReseauBancaire reseauBancaire;
    
    public CompteBancaire(ReseauBancaire reseauBancaire) {
		this.montant = 0;
		this.reseauBancaire = reseauBancaire;
	}
    
    public CompteBancaire(double montant) {
		this.montant = montant;
	}
    
    public abstract void debiter(double somme);

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public ReseauBancaire getReseauBancaire() {
		return reseauBancaire;
	}

	public void setReseauBancaire(ReseauBancaire reseauBancaire) {
		this.reseauBancaire = reseauBancaire;
	}

}



