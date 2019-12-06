package application;

import java.time.LocalDate;

class CommerceFranchise extends Commerce {

    private String siret;

    public CommerceFranchise(String nom, int nbEmploye, LocalDate date, CompteBancaire compte, String siret){
        super(nom, nbEmploye, date, compte);
        this.setSiret(siret);
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getBonus(){ return getSiret(); }

    public void setBonus(String x) { this.setSiret(x); }

}