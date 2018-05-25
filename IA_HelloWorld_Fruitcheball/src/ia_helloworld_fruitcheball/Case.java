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
    private Personnage personne_sur_case ; 
    private Fruit fruit_sur_case ; 
    
    //Constructeur// 
    public Case (int ligne, int colonne, Carte carte ) {
      this.carte = carte; 
      this.colonne = colonne;
      this.ligne = ligne; 
      this.personne_sur_case = null ; 
      this.fruit_sur_case = null ; 
      
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
    
    
    public Fruit getFruitCase(){
      return fruit_sur_case ;   
    }
    public void setFruitCase(Fruit f ){
        this.fruit_sur_case = f ;
    } 
    
    public Personnage getPersonneCase (){
        return personne_sur_case ; 
    }
    
    public void setPeronneCase(Personnage p ){
       this.personne_sur_case = p ;  
    }
    
    public String toString(){
        return ligne+"/"+colonne; 
    }
    
    public void ajouteFruit(Case ca , Fruit f ){
        
    }
    
    public void supprimeFruit(Case ca , Fruit f){
        
    }
}
