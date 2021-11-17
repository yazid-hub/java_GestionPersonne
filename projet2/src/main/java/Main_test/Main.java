package Main_test;

import Données.Personne;
import Données.PersonneDAO;
import java.sql.*;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;

public class Main {
       public static void main(String[] args) throws SQLException {
          
            Scanner sc = new Scanner(System.in);
            int choice = 0 ; 
            String order;
            String stop ="o";
            do{
            System.out.println("--------MENU----------");
            System.out.println("1.ajouter");
            System.out.println("2.supprimer");
            System.out.println("3.Rechercher");
            System.out.println("4.Afficher");
            System.out.println("0.Quitter");
            
            System.out.println("Entrez un choix(1-4)");
            choice=sc.nextInt();
                                                

            switch(choice){
                case 1:
                    PersonneDAO  personneDAO = new PersonneDAO();//nait@yaghooo.fr
                     System.out.println("Entrez votre nom:"); 
                    String nom = sc.next();
                    
                    System.out.println("Entrez votre prenom:"); // demander au client d'inserer son prenom
                    String prenom = sc.next();
                    
                    System.out.println("Entrez votre tel:");
                    String tel = sc.next();
                    
                    System.out.println("Entrez votre email:");
                    String email = sc.next();
                    
                    //iserer la personne  dans la base de données 
                    Personne unePersonne = new Personne(""+nom,""+prenom,""+tel,""+email);
                    personneDAO.insertPersonne(unePersonne);
                    System.out.println("la personne est bien inserer dans la base de donnée ");
                            
                    break;
                case 2:
                    System.out.println("Entrer un id personne pour la supprimer de la base de données "); 
                    int id = sc.nextInt();
                    PersonneDAO.deletePersonne(id);
                    break;
                 case 3:
                    System.out.println("Entrez le mail de la personne que vous rechercher:");
                    String mail = sc.next();
                    PersonneDAO.rechercherParmail(mail);

                    List<Personne> personnes1 = PersonneDAO.selectionner(mail);
                    personnes1.forEach(personne ->{
                    System.out.println("la personne rechercher est :"+personne);   
                            });
                    break;
                case 4:
                    //affihcer la liste des personnes
                    PersonneDAO  PersonneDAO = new PersonneDAO();
                    List<Personne> personnes = PersonneDAO.selectionner();
                    personnes.forEach(personne ->{
                    System.out.println("personne="+ personne);   
                    });
                    break;
                    
                   
                  
                default:
                       System.out.println("il existe pas ce numéro dans le menu :");
            }
            }while(stop !="n");
             /*
             
               //affihcer la liste des personnes
             List<Personne> personnes5 = personneDAO.selectionner();
             personnes.forEach(personne ->{
             System.out.println("personne="+ personne);   
                    });
          */
         }
    }
