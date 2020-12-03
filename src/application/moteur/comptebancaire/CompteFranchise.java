package application.moteur.comptebancaire;

import application.moteur.reseaubancaire.ReseauBancaire;

public class CompteFranchise extends CompteBancaire {

    public CompteFranchise(ReseauBancaire reseauBancaire){
        super(reseauBancaire);
    }

    @Override
    public void debiter(double somme) {
        this.setMontant(this.getMontant());
    }

}
