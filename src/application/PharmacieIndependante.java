package application;

class PharmacieIndependante extends Pharmacie {

    private String siret;

    public PharmacieIndependante(String nom, int nbEmploye, CompteBancaire compte, String siret){
        super(nom, nbEmploye, compte, siret);
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

}
