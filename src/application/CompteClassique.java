package application;

class CompteClassique extends CompteBancaire {

    public CompteClassique(ReseauBancaire reseauBancaire){
        super(reseauBancaire);
    }

    @Override
    public void debiter(double somme) {
        this.setMontant(this.getMontant());
    }

}
