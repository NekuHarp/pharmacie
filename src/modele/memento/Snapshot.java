package modele.memento;

import java.io.Console;
import java.util.Observable;

import javafx.collections.ObservableList;
import modele.personne.Client;
import modele.pharmacie.Pharmacie;

public class Snapshot {
	private ObservableList<Pharmacie> listePharmaSaved;
	private ObservableList<Client> listeClientSaved;
	
	public Snapshot(ObservableList<Pharmacie> listePharmaSaved, ObservableList<Client> listeClientSaved) {
		//System.out.println("Add " + listePharmaSaved + " to log");
		this.setListePharmaSaved(listePharmaSaved);
		this.setListeClientSaved(listeClientSaved);
	}

	public ObservableList<Pharmacie> getListePharmaSaved() {
		return listePharmaSaved;
	}

	public void setListePharmaSaved(ObservableList<Pharmacie> listePharmaSaved) {
		this.listePharmaSaved = listePharmaSaved;
	}

	public ObservableList<Client> getListeClientSaved() {
		return listeClientSaved;
	}

	public void setListeClientSaved(ObservableList<Client> listeClientSaved) {
		this.listeClientSaved = listeClientSaved;
	}
}
