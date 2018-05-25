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

    //Met à jour la ligne de la case// 
    public void setLigne(int ligne) {
        this.ligne = ligne;
    }
    
    //Retourne la colonne de la case //
    public int getColonne() {
        return colonne;
    }

    //Met à jour la colonne de la case//
    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    //Renvoie la carte // 
    public Carte getCarte() {
        return carte;
    }

    //Met à jour de la carte//
    public void setCarte(Carte carte) {
        this.carte = carte;
    }
   
       
    public abstract Type_Case getType(); 
        
    public abstract boolean franchissable();
    
    public String toString(){
        return ""; 
    }
}
