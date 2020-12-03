package application.moteur.reseaubancaire;

public interface ReseauBancaire {

	double calculTransaction(double montant);

	double calculRemboursement(double montant);

}