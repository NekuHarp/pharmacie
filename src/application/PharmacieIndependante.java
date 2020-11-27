package application;

class PharmacieIndependante extends Pharmacie {

    private String siret;

    public PharmacieIndependante(String nom, int nbEmploye, CompteBancaire compte, double taille, String siret){
        super(nom, nbEmploye, compte, taille, siret);
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public void acheterProduit(Produit produit){
        if(this.getCompte().getMontant()>=produit.getPrixAchat()){
            this.getListeProduit().add(produit);
            this.getCompte().debiter(produit.getPrixAchat());
        }
    }

}
