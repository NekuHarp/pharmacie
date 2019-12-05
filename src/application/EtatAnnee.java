package application;

public interface EtatAnnee {
	double calculRistourne(double montant);
	double calculPrixMinimumAchat();
}

class MoinsDeuxAns implements EtatAnnee {
	
	@Override
	public double calculRistourne(double montant) {
		return 0;
	}
	
	@Override
	public double calculPrixMinimumAchat() {
		return 100;
	}
}

class PlusDeuxAns implements EtatAnnee {
	
	@Override
	public double calculRistourne(double montant) {
		return montant*0.1;
	}
	
	@Override
	public double calculPrixMinimumAchat() {
		return 80;
	}
}

class PlusCinqAns implements EtatAnnee {
	
	@Override
	public double calculRistourne(double montant) {
		return montant*0.2;
	}
	
	@Override
	public double calculPrixMinimumAchat() {
		return 50;
	}
}