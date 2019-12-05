package application;

import java.util.ArrayList;

public interface ReseauBancaire {

	double calculTransaction(double montant);
}

class Mastercard implements ReseauBancaire {

	@Override
	public double calculTransaction(double montant) {
		return montant - montant*0.005;
	}
	
}

class Visa implements ReseauBancaire{

	private Pays pays;
	
	public Visa(Pays pays) {
		this.pays = pays;
	}
	
	@Override
	public double calculTransaction(double montant) {
		
		switch (this.pays.getNom()) {
		case "France":
			return montant - montant*0 - montant*0.0025;
		case "Espagne":
			return montant - montant*0.001 - montant*0.0025;
		case "Etats-Unis":
			return montant - montant*0.002 - montant*0.0025;
		case "Portugal":
			return montant - montant*0.0015 - montant*0.0025;
		case "Royaume-Uni":
			return montant - montant*0.0025 - montant*0.0025;
		default:
			return montant - montant*0.003 - montant*0.0025;
		}
		
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}
}

class Pays {
	private String nom;

	public Pays(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}


class FlyweightPays {
	ArrayList<Pays> listePaysCree = null;
	
	public Pays createPays(String nom) {
		for (int i = 0 ; i < this.listePaysCree.size()-1 ; i++) {
			if (this.listePaysCree.get(i).getNom() == nom) return this.listePaysCree.get(i);
		}
		return new Pays(nom);
	}
}