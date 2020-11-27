package application;

public abstract class CompteBancaire {

    private double montant;
    
    public CompteBancaire(ReseauBancaire reseauBancaire) {
		this.montant = 0;
	}
    
    public CompteBancaire(double montant) {
		this.montant = montant;
	}
    
    public abstract void debiter(double somme);

    public void ajoutargent(double somme){
    	montant += somme;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

}



