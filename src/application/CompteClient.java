package application;

class CompteClient extends CompteBancaire {
    private double montantDebiterfinMois = 0 ;

    public CompteClient(ReseauBancaire reseauBancaire){
        super(reseauBancaire);
    }

    public double getMontantDebiterfinMois() {
        return montantDebiterfinMois;
    }

    public void setMontantDebiterfinMois(double montantDebiterfinMois) {
        this.montantDebiterfinMois = montantDebiterfinMois;
    }

    @Override
    public void debiter(double somme) {
        this.montantDebiterfinMois = this.montantDebiterfinMois + getReseauBancaire().calculTransaction(somme);
        System.out.println("On ajoute " + getReseauBancaire().calculTransaction(somme) + "€ au total à débiter à la fin du mois");
    }

    @SuppressWarnings("unused")
    private void finDeMois() {
        this.setMontant(this.getMontant() - this.montantDebiterfinMois);
        this.setMontantDebiterfinMois(0);
    }

}
