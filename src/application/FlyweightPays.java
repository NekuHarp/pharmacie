package application;

import java.util.ArrayList;

class FlyweightPays {
    ArrayList<Pays> listePaysCree = null;

    public Pays createPays(String nom) {
        for (int i = 0 ; i < this.listePaysCree.size()-1 ; i++) {
            if (this.listePaysCree.get(i).getNom() == nom) return this.listePaysCree.get(i);
        }
        return new Pays(nom);
    }
}
