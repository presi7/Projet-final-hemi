package modele;

public class User {
    private String nom;
    private String prenom;
    private String adresse;
    private String mail;
    private String profil;


    public User(String nom, String prenom, String mail, String profil) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.profil = profil;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public String getAdresse() {
        return adresse;
    }

    public String getMail() {
        return mail;
    }

    public String getProfil() {
        return profil;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", mail='" + mail + '\'' +
                ", profil='" + profil + '\'' +
                '}';
    }
}
