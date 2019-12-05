package application;

import java.util.ArrayList;

public final class AllSnapShot {
	
	public static AllSnapShot instance = null;
	
	private ArrayList<Snapshot> snapshotHistory = null;
	
	private AllSnapShot() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void addSnapshot(Snapshot snapshot) {
		this.snapshotHistory.add(snapshot);
	}
	
	public Snapshot goBack() {
		getSnapshotHistory().remove(getSnapshotHistory().size()-1);
		return getSnapshotHistory().get(getSnapshotHistory().size()-1);
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
