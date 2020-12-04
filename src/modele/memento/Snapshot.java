package modele.memento;

import java.io.Console;
import java.util.Observable;

import javafx.collections.ObservableList;
import modele.pharmacie.Pharmacie;

public class Snapshot {
	private ObservableList<Pharmacie> listePharmaSaved;
	
	public Snapshot(ObservableList<Pharmacie> listePharmaSaved) {
		//System.out.println("Add " + listePharmaSaved + " to log");
		this.setListePharmaSaved(listePharmaSaved);
	}

	public ObservableList<Pharmacie> getListePharmaSaved() {
		return listePharmaSaved;
	}

	public void setListePharmaSaved(ObservableList<Pharmacie> listePharmaSaved) {
		this.listePharmaSaved = listePharmaSaved;
	}
}
