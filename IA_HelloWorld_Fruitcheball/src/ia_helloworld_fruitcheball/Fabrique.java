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
public class Fabrique {
    
    /*ATTRIBUTS*/
    private static Fabrique instance;
    
    /*CONSTRUCTEUR*/
    private Fabrique(){
        
    }
    /*METHODES*/
    /**
     * 
     * @return la nouvelle instance créée
     */
    public static Fabrique get(){
        if(instance==null){
            instance=new Fabrique();
        }
        return instance;
    }
    
    /**
     * retourne la case créée
     * @param type type de la case
     * @param ligne
     * @param colonne
     * @param carte
     * @return 
     */
    :*
    public static Case creer_case(Type_Case type, int ligne, int colonne, Carte carte){
        Case nouvelleCase = null;
        
        switch(type){
            case cloture : nouvelleCase= new Case_Cloture(ligne,colonne,carte);break;
            case sol : nouvelleCase = new Case_Sol(ligne,colonne,carte);break;            
        }
        return nouvelleCase;
    }
}
