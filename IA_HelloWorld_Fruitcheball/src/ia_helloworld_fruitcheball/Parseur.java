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
    private String scoreGlobal ; 

    private String qFruit; //fruit dans inventaire
    private String l1Fruit;
    private String l2Fruit;
    
                                //Nombre de fruits de l'équipe
    private String nbMirabelle;
    private String nbPrune;
    private String nbCerise;
    private String nbFramboise;
    private String nbChataigne;

    
   
                                //Troupes ennemies
    private String equipeEnnemi0;
    private String equipeEnnemi1;
    private String equipeEnnemi2;
    private String equipeEnnemi3;

    private String quetcherbackEquipe0;
    private String lanceur1Equipe0;
    private String lanceur2Equipe0;

    private String quetcherbackEquipe1;
    private String lanceur1Equipe1;
    private String lanceur2Equipe1;

    private String quetcherbackEquipe2;
    private String lanceur1Equipe2;
    private String lanceur2Equipe2;

    private String quetcherbackEquipe3;
    private String lanceur1Equipe3;
    private String lanceur2Equipe3;
    
    
    
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
        
        input = _adresseFichier;
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
                    case 'X' : nouvelleCase = Fabrique.creer_case(Type_Case.cloture,i-1,numColonne,this.carte);
                    break;
                    default : nouvelleCase = Fabrique.creer_case(Type_Case.cloture,i-1,numColonne,this.carte);
                    break;
                    

                }
                           
                System.out.println("");
                    switch(c){
                        case '0' : nouvelleCase.ajouteFruit(new Fruit_Mirabelle(nouvelleCase));
                        tabCooCasesFruits.add(nouvelleCase);
                        break;
                        case '1' : nouvelleCase.ajouteFruit(new Fruit_Prune(nouvelleCase));
                        tabCooCasesFruits.add(nouvelleCase);
                        break;
                        case '2' : nouvelleCase.ajouteFruit(new Fruit_Cerise(nouvelleCase));
                        tabCooCasesFruits.add(nouvelleCase);
                        break;
                        case '3' : nouvelleCase.ajouteFruit(new Fruit_Framboise(nouvelleCase));
                        tabCooCasesFruits.add(nouvelleCase);
                        break;
                        case '4' : nouvelleCase.ajouteFruit(new Fruit_Chataigne(nouvelleCase));
                        tabCooCasesFruits.add(nouvelleCase);
                        break;
                   
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
    
    //Fruit que possède notre équipe
    public void getFruitPossede(){
        
        if (splitRes[0].equals("0")){
            String[] tabInfoEquipe0 = infoEquipe0.split(",");
            String[] Mirabelle = tabInfoEquipe0[12].split(":");     
            String[] Prune = tabInfoEquipe0[13].split(":");
            String[] Cerise = tabInfoEquipe0[14].split(":");
            String[] Framboise = tabInfoEquipe0[15].split(":");
            String[] Chataigne = tabInfoEquipe0[16].split(":");
        
            setNbMirabelle(Mirabelle[1]);
            setNbPrune(Prune[1]);
            setNbCerise(Cerise[1]);
            setNbFramboise(Framboise[1]);
            setNbChataigne(Chataigne[1]);
            
        }else if(splitRes[0].equals("1")){
            String[] tabInfoEquipe1 = infoEquipe1.split(",");
            String[] Mirabelle = tabInfoEquipe1[12].split(":");
            String[] Prune = tabInfoEquipe1[13].split(":");
            String[] Cerise = tabInfoEquipe1[14].split(":");
            String[] Framboise = tabInfoEquipe1[15].split(":");
            String[] Chataigne = tabInfoEquipe1[16].split(":");
            
            setNbMirabelle(Mirabelle[1]);
            setNbPrune(Prune[1]);
            setNbCerise(Cerise[1]);
            setNbFramboise(Framboise[1]);
            setNbChataigne(Chataigne[1]);
            
        }else if(splitRes[0].equals("2")){
            
           String[] tabInfoEquipe2 = infoEquipe2.split(",");
            String[] Mirabelle = tabInfoEquipe2[12].split(":");
            String[] Prune = tabInfoEquipe2[13].split(":");
            String[] Cerise = tabInfoEquipe2[14].split(":");
            String[] Framboise = tabInfoEquipe2[15].split(":");
            String[] Chataigne = tabInfoEquipe2[16].split(":");
            
            setNbMirabelle(Mirabelle[1]);
            setNbPrune(Prune[1]);
            setNbCerise(Cerise[1]);
            setNbFramboise(Framboise[1]);
            setNbChataigne(Chataigne[1]);
            
        }else if(splitRes[0].equals("3")){
           String[] tabInfoEquipe3 = infoEquipe3.split(",");
            String[] Mirabelle = tabInfoEquipe3[12].split(":");
            String[] Prune = tabInfoEquipe3[13].split(":");
            String[] Cerise = tabInfoEquipe3[14].split(":");
            String[] Framboise = tabInfoEquipe3[15].split(":");
            String[] Chataigne = tabInfoEquipe3[16].split(":");
            
            setNbMirabelle(Mirabelle[1]);
            setNbPrune(Prune[1]);
            setNbCerise(Cerise[1]);
            setNbFramboise(Framboise[1]);
            setNbChataigne(Chataigne[1]);
        }
         
        System.out.println("Mirabelle : "+getNbMirabelle()+" | Prune : "+getNbPrune()+" | Cerise : "+getNbCerise()+" | Framboise : "+getNbFramboise()+" | Chataigne : "+getNbChataigne());
    }
    
    public void getScoreNotreEquipe(){
        
        if (splitRes[0].equals("0")){
            String[] tabInfoEquipe0 = infoEquipe0.split(",");    
            setScoreGlobal(tabInfoEquipe0[10]) ;  
        } else if (splitRes[0].equals("1")) {
             String[] tabInfoEquipe1 = infoEquipe1.split(",");    
            setScoreGlobal(tabInfoEquipe1[10]) ;  
        } else if (splitRes[0].equals("2")) {
             String[] tabInfoEquipe2 = infoEquipe2.split(",");    
            setScoreGlobal(tabInfoEquipe2[10]) ;  
        } else if (splitRes[0].equals("3")) {
             String[] tabInfoEquipe3 = infoEquipe3.split(",");    
            setScoreGlobal(tabInfoEquipe3[10]) ;  
        } 
        System.out.println("Score de notre équipe : "+ getScoreGlobal());
    }
    
    private String getCoo(String[] coo){
        return coo[2]+"/"+coo[1];
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
    
    public ArrayList<Case> getTabCooCasesFruits() {
        return tabCooCasesFruits;
    }
    
    
    public String getQuetcherback() {
        return quetcherback;
    }

    public String getLanceur1() {
        return lanceur1;
    }

    public String getLanceur2() {
        return lanceur2;
    }
    
    public String getNbMirabelle() {
        return nbMirabelle;
    }

    public void setNbMirabelle(String nbMirabelle) {
        this.nbMirabelle = nbMirabelle;
    }

    public String getNbPrune() {
        return nbPrune;
    }

    public void setNbPrune(String nbPrune) {
        this.nbPrune = nbPrune;
    }

    public String getNbCerise() {
        return nbCerise;
    }

    public void setNbCerise(String nbCerise) {
        this.nbCerise = nbCerise;
    }

    public String getNbFramboise() {
        return nbFramboise;
    }

    public void setNbFramboise(String nbFramboise) {
        this.nbFramboise = nbFramboise;
    }

    public String getNbChataigne() {
        return nbChataigne;
    }

    public void setNbChataigne(String nbChataigne) {
        this.nbChataigne = nbChataigne;
    }
    
    public String getScoreGlobal() {
        return scoreGlobal;
    }

    public void setScoreGlobal(String scoreGlobal) {
        this.scoreGlobal = scoreGlobal;
    }
    
    /**************************************************************ENNEMI*/
    public void getPosEnnemi(){
         String numEquipe=splitRes[0];
         String equipeEnnemi0="";
         String equipeEnnemi1="";
         String equipeEnnemi2="";
         String equipeEnnemi3="";
        //if(equipeEnnemi.get())
        
       if (splitRes[0].equals("0")){
            String[] tabInfoEquipe1 = infoEquipe1.split(",");
            String[] perso0 = tabInfoEquipe1[2].split(":");
            String[] perso1 = tabInfoEquipe1[3].split(":");
            String[] perso2 = tabInfoEquipe1[4].split(":");
            quetcherbackEquipe1 = getCoo(perso0);
            lanceur1Equipe1 = getCoo(perso1);
            lanceur2Equipe1 = getCoo(perso2);
            equipeEnnemi1="Equipe 1";
            
            String[] tabInfoEquipe2 = infoEquipe2.split(",");
            String[] perso02 = tabInfoEquipe2[2].split(":");
            String[] perso12 = tabInfoEquipe2[3].split(":");
            String[] perso22 = tabInfoEquipe2[4].split(":");
            quetcherbackEquipe2 = getCoo(perso02);
            lanceur1Equipe2 = getCoo(perso12);
            lanceur2Equipe2 = getCoo(perso22);
            equipeEnnemi2="Equipe 2";
            
            String[] tabInfoEquipe3 = infoEquipe3.split(",");
            String[] perso03 = tabInfoEquipe3[2].split(":");
            String[] perso13 = tabInfoEquipe3[3].split(":");
            String[] perso23 = tabInfoEquipe3[4].split(":");
            quetcherbackEquipe3 = getCoo(perso03);
            lanceur1Equipe3 = getCoo(perso13);
            lanceur2Equipe3 = getCoo(perso23);
            equipeEnnemi3="Equipe 3";
       }
       
       /*AFFICHAGE*/
        System.out.println();
        System.out.println("Liste équipes ennemies");
        System.out.println("---------------------");
        System.out.println("num équipe : "+equipeEnnemi0+"\ncoo de quetcherback : "+quetcherbackEquipe0+"\ncoo de lanceur1 : "+lanceur1Equipe0+"\ncoo de lanceur2 : "+lanceur2Equipe0);
        
        System.out.println("---------------------");
        System.out.println("num équipe : "+equipeEnnemi1+"\ncoo de quetcherback : "+quetcherbackEquipe1+"\ncoo de lanceur1 : "+lanceur1Equipe1+"\ncoo de lanceur2 : "+lanceur2Equipe1);
        System.out.println("---------------------");
        System.out.println("num équipe : "+equipeEnnemi2+"\ncoo de quetcherback : "+quetcherbackEquipe2+"\ncoo de lanceur1 : "+lanceur1Equipe2+"\ncoo de lanceur2 : "+lanceur2Equipe2);
        System.out.println("---------------------");
        System.out.println("num équipe : "+equipeEnnemi3+"\ncoo de quetcherback : "+quetcherbackEquipe3+"\ncoo de lanceur1 : "+lanceur1Equipe3+"\ncoo de lanceur2 : "+lanceur2Equipe3);
        
        System.out.println();
    }
    
}
