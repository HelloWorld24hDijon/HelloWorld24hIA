/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

import java.util.ArrayList;
import java.util.HashMap;

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
    private ArrayList<Case> tabCooCasesFruits;
    
                                //Nos troupes
    private String quetcherback;
    private String lanceur1;
    private String lanceur2;
    private String qFruit; //fruit dans inventaire
    private String l1Fruit;
    private String l2Fruit;
                                //Troupes ennemies
    private HashMap<String,String[]> equipeEnnemi;
    
    
    private String infoEquipe0;
    private String infoEquipe1;
    private String infoEquipe2;
    private String infoEquipe3;
     
    private String zone0;
    private String zone1;
    private String zone2;
    
    private int nbCase;
    
    
    
    /*CONSTRUCTEUR*/
    public Parseur(String _adresseFichier, Carte _carte){
        this.adresseFichier=_adresseFichier;
        this.carte=_carte;
        tabCooCasesFruits = new ArrayList<>();
        equipeEnnemi=new HashMap();
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
        /*for(Case c : carte.getListeCase()){
            System.out.println(c.toString());
        }*/
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
                
                //gestion des différents fruits
                 switch(c){
                     case '0' : nouvelleCase.ajouteFruit(new Fruit_Mirabelle(nouvelleCase));break;
                     case '1' : nouvelleCase.ajouteFruit(new Fruit_Prune(nouvelleCase));break;
                     case '2' : nouvelleCase.ajouteFruit(new Fruit_Cerise(nouvelleCase));break;
                     case '3' : nouvelleCase.ajouteFruit(new Fruit_Framboise(nouvelleCase));break;
                     case '4' : nouvelleCase.ajouteFruit(new Fruit_Chataigne(nouvelleCase));break;
                }
                 
                 if((0<=c)&&(c<5)){
                     tabCooCasesFruits.add(nouvelleCase);
                 }
            
            }
   
        
        }
    }
    
    /**************************************************NOTRE EQUIPE*/
    
    // Retourne les coordonnées de nos personnages
    public void getCooNosPerso(){
        String numEquipe = splitRes[0];
        
        if (splitRes[0].equals("0")){
            String[] tabInfoEquipe0 = infoEquipe0.split(",");
            String[] perso0 = tabInfoEquipe0[2].split(":");
            String[] perso1 = tabInfoEquipe0[3].split(":");
            String[] perso2 = tabInfoEquipe0[4].split(":");
            quetcherback = getCoo(perso0);
            lanceur1 = getCoo(perso1);
            lanceur2 = getCoo(perso2);
            qFruit=getFruitInventairePerso(perso0);
            l1Fruit=getFruitInventairePerso(perso1);
            l2Fruit=getFruitInventairePerso(perso2);
            
        }else if(splitRes[0].equals("1")){
            String[] tabInfoEquipe1 = infoEquipe1.split(",");
            String[] perso0 = tabInfoEquipe1[2].split(":");
            String[] perso1 = tabInfoEquipe1[3].split(":");
            String[] perso2 = tabInfoEquipe1[4].split(":");
            quetcherback = getCoo(perso0);
            lanceur1 = getCoo(perso1);
            lanceur2 = getCoo(perso2);
            qFruit=getFruitInventairePerso(perso0);
            l1Fruit=getFruitInventairePerso(perso1);
            l2Fruit=getFruitInventairePerso(perso2);
            
        }else if(splitRes[0].equals("2")){
            
            String[] tabInfoEquipe2 = infoEquipe2.split(",");
            String[] perso0 = tabInfoEquipe2[2].split(":");
            String[] perso1 = tabInfoEquipe2[3].split(":");
            String[] perso2 = tabInfoEquipe2[4].split(":");
            quetcherback = getCoo(perso0);
            lanceur1 = getCoo(perso1);
            lanceur2 = getCoo(perso2);
            qFruit=getFruitInventairePerso(perso0);
            l1Fruit=getFruitInventairePerso(perso1);
            l2Fruit=getFruitInventairePerso(perso2);
            
        }else if(splitRes[0].equals("3")){
            String[] tabInfoEquipe3 = infoEquipe3.split(",");
            String[] perso0 = tabInfoEquipe3[2].split(":");
            String[] perso1 = tabInfoEquipe3[3].split(":");
            String[] perso2 = tabInfoEquipe3[4].split(":");
            quetcherback = getCoo(perso0);
            lanceur1 = getCoo(perso1);
            lanceur2 = getCoo(perso2);
            qFruit=getFruitInventairePerso(perso0);
            l1Fruit=getFruitInventairePerso(perso1);
            l2Fruit=getFruitInventairePerso(perso2);
        }
        
        System.out.println("num équipe : "+numEquipe+"\ncoo de quetcherback : "+quetcherback+" possède : "+getFruit(qFruit)+"\ncoo de lanceur1 : "+lanceur1+" possède : "+getFruit(l1Fruit)+"\ncoo de lanceur2 : "+lanceur2+" possède : "+getFruit(l2Fruit));
       
    }
    
    //Retourne la zone de notre camp
    public void getNotreZone(){
        String numEquipe=splitRes[0] ; 
        
         if (splitRes[0].equals("0")){
            String[] tabInfoEquipe0 = infoEquipe0.split(",");
            String[] z0 = tabInfoEquipe0[6].split(":");
            String[] z1 = tabInfoEquipe0[7].split(":");
            String[] z2 = tabInfoEquipe0[8].split(":");
            zone0 = getCoo(z0);
            zone1 = getCoo(z1);
            zone2 = getCoo(z2);
            
        }else if(splitRes[0].equals("1")){
            String[] tabInfoEquipe1 = infoEquipe1.split(",");
            String[] z0 = tabInfoEquipe1[6].split(":");
            String[] z1 = tabInfoEquipe1[7].split(":");
            String[] z2 = tabInfoEquipe1[8].split(":");
            zone0 = getCoo(z0);
            zone1 = getCoo(z1);
            zone2 = getCoo(z2);
        }else if(splitRes[0].equals("2")){
            String[] tabInfoEquipe2 = infoEquipe2.split(",");
            String[] z0 = tabInfoEquipe2[6].split(":");
            String[] z1 = tabInfoEquipe2[7].split(":");
            String[] z2 = tabInfoEquipe2[8].split(":");
            zone0 = getCoo(z0);
            zone1 = getCoo(z1);
            zone2 = getCoo(z2);
            
        }else if(splitRes[0].equals("3")){
            String[] tabInfoEquipe3 = infoEquipe3.split(",");
            String[] z0 = tabInfoEquipe3[6].split(":");
            String[] z1 = tabInfoEquipe3[7].split(":");
            String[] z2 = tabInfoEquipe3[8].split(":");
            zone0 = getCoo(z0);
            zone1 = getCoo(z1);
            zone2 = getCoo(z2);
        }
        
        System.out.println("Coordonnées notre camp : \nZ0 : "+zone0+"\nZ1 : "+zone1+"\nZ2 : "+zone2);
       
    }
    
    /**
     * Correspond au fruit présent dans l'inventaire de chaque personnage
     */
    public String getFruitInventairePerso(String[] coo){
        return coo[3];
    }
    
    
    public void getPosEnnemi(){
        String numEquipe=splitRes[0];
      
        //if(equipeEnnemi.get())
        
       /*if (splitRes[0].equals("0")){
            String[] tabInfoEquipe1 = infoEquipe1.split(",");
            String[] perso0 = tabInfoEquipe1[2].split(":");
            String[] perso1 = tabInfoEquipe1[3].split(":");
            String[] perso2 = tabInfoEquipe1[4].split(":");
            quetcherback = getCoo(perso0);
            lanceur1 = getCoo(perso1);
            lanceur2 = getCoo(perso2);
            String equipeEnnemi1="Equipe 1";
            
            String[] tabInfoEquipe2 = infoEquipe2.split(",");
            String[] perso02 = tabInfoEquipe2[2].split(":");
            String[] perso12 = tabInfoEquipe2[3].split(":");
            String[] perso22 = tabInfoEquipe2[4].split(":");
            quetcherback = getCoo(perso02);
            lanceur1 = getCoo(perso12);
            lanceur2 = getCoo(perso22);
            String equipeEnnemi2="Equipe 2";
       }
        System.out.println("num équipe : "+equipeEnnemi1+"\ncoo de quetcherback : "+quetcherback+"\ncoo de lanceur1 : "+lanceur1+"\ncoo de lanceur2 : "+lanceur2);
    */
    }
    
    private String getCoo(String[] coo){
        return coo[1]+"/"+coo[2];
    }
    
    private String getFruit(String fruit){
        String _fruit="";
        
        switch(fruit){
            case "x" : _fruit="rien";break;
            case "0" : _fruit="Mirabelle";break;
            case "1" : _fruit="Prune";break;
            case "2" : _fruit="Cerise";break;
            case "3" : _fruit="Framboise";break;
            case "4" : _fruit="Chataigne";break;
        }
        
        return _fruit;
    }
}
