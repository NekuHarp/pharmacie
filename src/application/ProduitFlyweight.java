package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ProduitFlyweight {
	ArrayList<Produit> produitCree = null;
	
	public Produit createProduit(String nom, String variete, double prixInitial, LocalDate datePeremption) {
		for (int i = 0 ; i < this.produitCree.size() ; i++) {
			if (produitCree.get(i).getNom() == nom) return produitCree.get(i);
		}
		return new Produit(nom, variete, prixInitial, datePeremption);
	}
	
}
