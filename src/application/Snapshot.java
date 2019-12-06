package application;

import java.io.Console;
import java.util.Observable;

import javafx.collections.ObservableList;

public class Snapshot {
	private ObservableList<Commerce> listeCommerceSaved;
	
	public Snapshot(ObservableList<Commerce> listeCommerceSaved) {
		//System.out.println("Add " + listeCommerceSaved + " to log");
		this.setListeCommerceSaved(listeCommerceSaved);
	}

	public ObservableList<Commerce> getListeCommerceSaved() {
		return listeCommerceSaved;
	}

	public void setListeCommerceSaved(ObservableList<Commerce> listeCommerceSaved) {
		this.listeCommerceSaved = listeCommerceSaved;
	}
}
