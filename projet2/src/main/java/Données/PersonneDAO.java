package Données;
import BDD.Connexion1;
import java.sql.*;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonneDAO {
  
   private static final String SQL_SELECT  ="select * from personne;";
   private static final String SQL_INSERT  ="insert into personne values(null,?,?,?;";
   
   public List<Personne> selectionner() throws SQLException {
      
           Connection conn = null;
           PreparedStatement stmt = null;
           ResultSet rs = null ;
           Personne personne = null;
           List<Personne> personnes = new ArrayList<>();
           
           try { 
                conn = Connexion1.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT);
                rs = stmt.executeQuery();
                while (rs.next()) {
                            int idPersonne = rs.getInt("id_personne");
                            String nom =rs.getString("nom");
                            String prenom =rs.getString("prenoml");
                            String tel =rs.getString("tel");
                            String email =rs.getString("email");
                personne =new Personne(idPersonne,nom,prenom,tel,email);
                    personnes.add(personne);
                    
                }
       } catch (SQLException ex) {
           ex.printStackTrace(System.out);
       }finally{
               rs.close();
               stmt.close();
               conn.close(); 
           }
           return personnes;
   }
    public static List<Personne> selectionner(String mail) throws SQLException {
           String requete  ="select * from personne where email='"+mail+"';";
           Connection conn = null;
           PreparedStatement stmt = null;
           ResultSet rs = null ;
           Personne personne = null;
           List<Personne> personnes = new ArrayList<>();
           
           try { 
                conn = Connexion1.getConnection();
                stmt = conn.prepareStatement(requete);
                rs = stmt.executeQuery();
                while (rs.next()) {
                            int idPersonne = rs.getInt("id_personne");
                            String nom =rs.getString("nom");
                            String prenom =rs.getString("prenoml");
                            String tel =rs.getString("tel");
                            String email =rs.getString("email");
                personne =new Personne(idPersonne,nom,prenom,tel,email);
                    personnes.add(personne);
                    
                }
       } catch (SQLException ex) {
           ex.printStackTrace(System.out);
       }finally{
               rs.close();
               stmt.close();
               conn.close(); 
           }
           return personnes;
   }
  /* public  void  inserer(Personne personne) throws SQLException{
            Connection conn = null;
            PreparedStatement stmt = null;
            int enregistrement =0;
        
       try {
            conn =  Connexion1.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(0, personne.getNom());
            stmt.setString(1, personne.getPrenom());
            stmt.setString(2, personne.getTel());
            stmt.setString(3, personne.getEmail());
            stmt.execute(SQL_INSERT);
            } catch (SQLException ex) {
           ex.printStackTrace(System.out);
       }
       finally{
               stmt.close();
               conn.close(); 
           }
   }
   */
public static void insertPersonne(Personne unePersonne) {
                String requete ="insert into Personne values(null,'"+unePersonne.getNom()
                + "','"+unePersonne.getPrenom()+"','"+unePersonne.getTel()+"','"+unePersonne.getEmail()+"');";

                                try {
                                Connexion1.getConnection();
                                Statement unStat = Connexion1.getConnection().createStatement();
                                unStat.execute(requete);
                                unStat.close();						
                                }catch(SQLException exp) {
                                System.out.println("Erreur d'excution de la requete :"+requete);
                                }
                        }
public static void deletePersonne(int idpersonne){
                String requete="delete from personne where id_personne="+idpersonne+";";
                
                try {
                                Connexion1.getConnection();
                                Statement unStat = Connexion1.getConnection().createStatement();
                                unStat.execute(requete);
                                System.out.println("la personne est bien supprimé :"+idpersonne);      
                                unStat.close();						
                                }catch(SQLException exp) {
                                System.out.println("Erreur d'excution de la requete :"+requete);
                                }
               }
        
public static void rechercherParmail(String mail){
            
            String requete="select * from personne where email='"+mail+"';";
                
                try {
                                Connexion1.getConnection();
                                Statement unStat = Connexion1.getConnection().createStatement();
                                unStat.execute(requete);
                                System.out.println("la personne est bien trouver :"+mail);      
                               
                                unStat.close();						
                                }catch(SQLException exp) {
                                System.out.println("Erreur d'excution de la requete :"+requete);
                                }
    
            }
   
}
