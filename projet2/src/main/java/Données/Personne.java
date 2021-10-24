package Données;

public class Personne {
    
    private int idpersonne ; 
    private String nom; 
    private String prenom; 
    private String tel ; 
    private String email; 

    public Personne() {
    }

    public Personne(int idpersonne) {
        this.idpersonne = idpersonne;
    }
    
    public Personne(int idpersonne, String nom, String prenom, String tel, String email) {
        this.idpersonne = idpersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
    }

    public Personne(String nom, String prenom, String tel, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
    }
    

    public int getIdpersonne() {
        return idpersonne;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public void setIdpersonne(int idpersonne) {
        this.idpersonne = idpersonne;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Personne{" + "idpersonne=" + idpersonne + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", email=" + email + '}';
    }

    void add(Personne personne) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        
   
}
