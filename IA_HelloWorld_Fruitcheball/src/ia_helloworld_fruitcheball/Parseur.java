/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

/**
 *
 * @author emili
 */
public class Parseur {
    
    
    //ATTRIBUTS 
    private final String adresseFichier;
    private Carte carte;
    
    
    /*CONSTRUCTEUR*/
    public Parseur(String _adresseFichier, Carte _carte){
        this.adresseFichier=_adresseFichier;
        this.carte=_carte;
    }
    
    /*METHODE*/
    /**
     * 
     * @return LA CARTE
     */
    public Carte creer_carte(){
        return carte;
    }
    
    public void compteLigne(int numLigne, String ligne){
        for(int numColonne=0; numColonne<ligne.length();numColonne++){
            char c = ligne.charAt(numColonne);
            
            Case nouvelleCase=null;
            
           
            //créer les cases sol, cloture et zone d'équipes
            switch(c){
                case 'X' : nouvelleCase = Fabrique.creer_case(Type_Case.cloture,numColonne,numLigne,this.map)
                );break;
                case '.' : nouvelleCase = Fabrique.creer_case(Type_Case.sol,numColonne,numLigne,this.map)
                );break;    
                case 'Z' : nouvelleCase = Fabrique.creer_case(Type_Case.zoneEquipe,numColonne,numLigne,this.map)
                );break;  
            }
            
            //gestion des différents fruits
             switch(c){
                 case '0' : this.carte.ajouteFruit(numLigne,numColonne, new Fruit_Mirabelle());break;
                 case '1' : this.carte.ajouteFruit(numLigne,numColonne, new Fruit_Prune());break;
                 case '2' : this.carte.ajouteFruit(numLigne,numColonne, new Fruit_Cerise());break;
                 case '3' : this.carte.ajouteFruit(numLigne,numColonne, new Fruit_Framboise());break;
                 case '4' : this.carte.ajouteFruit(numLigne,numColonne, new Fruit_Chataigne());break;
             }
            
        }
    }
}
