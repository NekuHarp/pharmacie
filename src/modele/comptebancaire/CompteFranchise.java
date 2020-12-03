package modele.comptebancaire;

import modele.reseaubancaire.ReseauBancaire;

public class CompteFranchise extends CompteBancaire {

    public CompteFranchise(ReseauBancaire reseauBancaire){
        super(reseauBancaire);
    }

    @Override
    public void debiter(double somme) {
        this.setMontant(this.getMontant());
    }

}
