package Models;

public class Model_pageEtudiant {


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    String nom,prenom;

    public Model_pageEtudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;

    }


    @Override
    public String toString() {
        return this.getNom()+" "+this.getPrenom();
    }
}
