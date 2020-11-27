package application;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class PharmacieFranchise extends Pharmacie {

    private String siret;

    private int nbrDependante;

    private ObservableList<PharmacieFranchise> listeDependante;

    private boolean isDependante;

    private PharmacieFranchise pharMere;

    public PharmacieFranchise(String nom, int nbEmploye, CompteBancaire compte, String siret){
        super(nom, nbEmploye, compte, siret);

        this.setNbrDependante(0);
        this.setDependante(false);
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public int getNbrDependante() {
        return nbrDependante;
    }

    public void setNbrDependante(int nbrDependante) {
        this.nbrDependante = nbrDependante;
    }

    public ObservableList<PharmacieFranchise> getListeDependante() {
        return listeDependante;
    }

    public void setListeDependante(ObservableList<PharmacieFranchise> listeDependante) {
        this.listeDependante = listeDependante;
    }

    public boolean isDependante() {
        return isDependante;
    }

    public void setDependante(boolean dependante) {
        isDependante = dependante;
    }

    public PharmacieFranchise getPharMere() {
        return pharMere;
    }

    public void setPharMere(PharmacieFranchise pharMere) {
        this.pharMere = pharMere;
    }
}