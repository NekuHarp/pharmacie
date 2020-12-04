package modele.memento;

import java.util.ArrayList;

public final class AllSnapShot {
	
	public static AllSnapShot instance = null;
	
	private ArrayList<Snapshot> snapshotHistory = null;
	
	public AllSnapShot() {
		snapshotHistory = new ArrayList<Snapshot>();
	}
	
	
	public void addSnapshot(Snapshot snapshot) {
		this.snapshotHistory.add(snapshot);
		// TODO : Updater le fichier de log et rajouter le nouvel état dans le fichier
	}
	
	public Snapshot goBack() {
		Snapshot temp = snapshotHistory.get(snapshotHistory.size()-1);
		snapshotHistory.remove(snapshotHistory.size()-1);
		System.out.println("Retour à l'état précédent");
		// TODO : Récupérer à partir d'un fichier l'état précédent
		return temp;
	}

	
	public static AllSnapShot getAllSnapshotInstance() {
		if (instance == null) {
			return new AllSnapShot();
		}
		return instance;
	}
	
	public ArrayList<Snapshot> getSnapshotHistory() {
		return snapshotHistory;
	}

	public void setSnapshotHistory(ArrayList<Snapshot> snapshotHistory) {
		this.snapshotHistory = snapshotHistory;
	}
}
