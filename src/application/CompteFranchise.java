package application;

class CompteFranchise extends CompteBancaire {

    public CompteFranchise(ReseauBancaire reseauBancaire){
        super(reseauBancaire);
    }

    @Override
    public void debiter(double somme) {
        this.setMontant(this.getMontant());
    }

}
