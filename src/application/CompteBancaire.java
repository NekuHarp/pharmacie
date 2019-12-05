package application;

public abstract class CompteBancaire {

    private double montant;
    
    public CompteBancaire() {
		this.montant = 0;
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

}

class CompteClient extends CompteBancaire {
	private double montantDebiterfinMois = 0 ;
	
	
	public double getMontantDebiterfinMois() {
		return montantDebiterfinMois;
	}

	public void setMontantDebiterfinMois(double montantDebiterfinMois) {
		this.montantDebiterfinMois = montantDebiterfinMois;
	}

	@Override
	public void debiter(double somme) {
		this.montantDebiterfinMois = this.montantDebiterfinMois + somme;
	}
	
	@SuppressWarnings("unused")
	private void finDeMois() {
		this.setMontant(this.getMontant() - this.montantDebiterfinMois);
		this.setMontantDebiterfinMois(0);
	}
	
}

class CompteClassique extends CompteBancaire {

	@Override
	public void debiter(double somme) {
		this.setMontant(this.getMontant() - somme);
		
	}
	
}