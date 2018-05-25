/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

/**
 *
 * @author Alexiane
 */
public abstract class Case {
    
    //Atribut//
    private int ligne ; 
    private int colonne ; 
    private Carte carte; 
    
    //Constructeur// 
    public Case (int ligne, int colonne, Carte carte ) {
      this.carte = carte; 
      this.colonne = colonne;
      this.ligne = ligne; 
    }
    
    //Retourne la ligne de la case//
    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }
   
       
    public abstract Type_Case getType(); 
        
    public String toString(){
        return ""; 
    }
}
