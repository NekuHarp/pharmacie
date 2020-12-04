package vue;

import controller.Controller;
import controller.ControllerMenu;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import modele.comptebancaire.CompteBancaire;
import modele.comptebancaire.CompteClassique;
import modele.comptebancaire.CompteFranchise;
import modele.personne.PharmacienManager;
import modele.pharmacie.Pharmacie;
import modele.pharmacie.PharmacieFranchise;
import modele.pharmacie.PharmacieIndependante;
import modele.produit.Produit;
import modele.reseaubancaire.Mastercard;
import modele.reseaubancaire.ReseauBancaire;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		PharmacienManager pharmacienManager = new PharmacienManager("Bonbeurre", "Jean", "35 Rue du pique-nique", 9001);
		FadeTransition ft;
		Pharmacie selectedcom;
		Produit selecteditem;

		// TODO : remplacer date de création pharmacie par taille
		// TODO : afficher compte de la pharma
		// TODO : gestion de client -> achat produit

		ReseauBancaire testreseau = new Mastercard();
		CompteBancaire testcompte = new CompteClassique(testreseau);
		CompteBancaire testcompte2 = new CompteFranchise(testreseau);
		Pharmacie Test = new PharmacieFranchise("la croix verte", testcompte, 30,"siretoui420420");
		pharmacienManager.addPharma(Test);
		Pharmacie Test2 = new PharmacieIndependante("Leclerc Pharma", testcompte2, 50,"siretnon42069");
		pharmacienManager.addPharma(Test2);

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
			Parent root = loader.load();
			ControllerMenu controller = loader.getController();

			primaryStage.setTitle("Gestion de pharmacies");
			primaryStage.setScene(new Scene(root, 800, 600));
			primaryStage.setResizable(false);
			primaryStage.show();

			try {
				controller.initialize(pharmacienManager, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//splitpanebase.lookupAll(".split-pane-divider").stream()
			//		.forEach(div ->  div.setMouseTransparent(true) );
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
