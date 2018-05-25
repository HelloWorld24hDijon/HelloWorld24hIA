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
    public Carte creer_carte(){
        return carte;
    }
    
}
