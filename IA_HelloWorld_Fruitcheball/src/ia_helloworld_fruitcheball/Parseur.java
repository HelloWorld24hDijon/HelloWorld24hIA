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
    private String[] splitRes;
    private String[] tabCarte;
    private String quetcherback;
    private String lanceur1;
    private String lanceur2;
    private String infoEquipe0;
    private String infoEquipe1;
    private String infoEquipe2;
    private String infoEquipe3;
    
    private int nbCase;
    
    
    
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
        decoupeString();
        creationCarte();
        for(Case c : carte.getListeCase()){
            System.out.println(c.toString());
        }
        return carte;
    }

    /**
     * découpe ma chaine de caractères en trois parties
     */
    public void decoupeString(){
                                    //Différentes parties du code      
        
        //Récupère toutes les grandes parties du fichier séparées par "_"
        this.splitRes=input.split("_");
        
        //taille tableau récu^père la taille du tableau et les différentes lignes composant la map
        tabCarte= this.splitRes[2].split(",");
        
        infoEquipe0 = splitRes[3];
        infoEquipe1 = splitRes[4];
        infoEquipe2 = splitRes[5];
        infoEquipe3 = splitRes[6];
        /*
        switch (splitRes[0]){
            case "0" : infoNotreEquipe = splitRes[3];
            case "1" : infoNotreEquipe = splitRes[4];
            case "2" : infoNotreEquipe = splitRes[5];
            case "3" : infoNotreEquipe = splitRes[6];
        }*/

    }
    
    public void creationCarte() {
        
        for(int i=1;i<=tabCarte.length-1;i++){
            char[] ligne = tabCarte[i].toCharArray();
            for(int numColonne=0; numColonne<ligne.length;numColonne++){
                char c = ligne[numColonne];
                
                Case nouvelleCase=null;
                
                //créer les cases sol et cloture
                switch(c){
                    case 'X' : nouvelleCase = Fabrique.creer_case(Type_Case.cloture,i-1,numColonne,this.carte)
                    ;break;
                    case '.' : nouvelleCase = Fabrique.creer_case(Type_Case.sol,i-1,numColonne,this.carte)
                    ;break;    

                }
                /*
                //gestion des différents fruits
                 switch(c){
                     case '0' : this.carte.ajouteFruit(i,numColonne, new Fruit_Mirabelle());break;
                     case '1' : this.carte.ajouteFruit(i,numColonne, new Fruit_Prune());break;
                     case '2' : this.carte.ajouteFruit(i,numColonne, new Fruit_Cerise());break;
                     case '3' : this.carte.ajouteFruit(i,numColonne, new Fruit_Framboise());break;
                     case '4' : this.carte.ajouteFruit(i,numColonne, new Fruit_Chataigne());break;
                }*/
            
            }
        
        }
    }
    
    public void getCooNosPerso(){
        
        
        String[] tabInfoEquipe0 = infoEquipe0.split(",");
        String[] perso0 = tabInfoEquipe0[2].split(":");
        quetcherback = getCoo(perso0);
        System.out.println("coo de quetcherback : "+quetcherback);
    }
    
    private String getCoo(String[] infoPerso){
        return infoPerso[1]+"/"+infoPerso[2];
    }
}
