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
    private String input; //fichier envoyé par le serveur
    
    
    /*CONSTRUCTEUR*/
    public Parseur(String _adresseFichier, Carte _carte){
        this.adresseFichier=_adresseFichier;
        this.carte=_carte;
        input = "0_4_13:13,XXXXXXXXXXXXX,X......01...X,X...XX.XX...X,X.X......4X.X,X1X.......X1X,X.....3.....X,X...0...2...X,X0....3....0X,X1X.......X.X,X.X4.....4X.X,X...XX.XX...X,X...10.0....X,XXXXXXXXXXXXX_Equipe0,P,P0:3:5:4,P1:5:1:x,P2:4:6:2,Z,Z0:2:1,Z1:1:1,Z2:1:2,G,2,F,F0:1,F1:1,F2:0,F3:0,F4:0_Equipe1,P,P0:8:11:x,P1:9:8:x,P2:11:8:x,Z,Z0:11:10,Z1:11:11,Z2:10:11,G,2,F,F0:0,F1:2,F2:0,F3:0,F4:1_Equipe2,P,P0:1:11:x,P1:4:11:x,P2:3:8:x,Z,Z0:2:11,Z1:1:10,Z2:1:11,G,-3,F,F0:0,F1:0,F2:0,F3:0,F4:2_Equipe3,P,P0:11:5:0,P1:7:5:x,P2:10:1:x,Z,Z0:11:1,Z1:10:1,Z2:11:2,G,0,F,F0:0,F1:0,F2:0,F3:0,F4:0";
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
            
           
            //créer les cases sol et cloture
            switch(c){
                case 'X' : nouvelleCase = Fabrique.creer_case(Type_Case.cloture,numColonne,numLigne,this.map)
                ;break;
                case '.' : nouvelleCase = Fabrique.creer_case(Type_Case.sol,numColonne,numLigne,this.map)
                ;break;    
                
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
    
    public void decoupeString(String texte){
        
    }
}
