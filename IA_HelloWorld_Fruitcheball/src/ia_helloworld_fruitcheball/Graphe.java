/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

import java.util.HashMap;
import javafx.util.Pair;

/**
 *
 * @author Alexiane
 */
public class Graphe {
    
    //Atributs // 
    private HashMap<Case ,Sommet> sommet ; 
    private HashMap<Pair<Sommet,Sommet>,Integer> etiquette ; 
    
    //private HashMap<,String> etiquette ; 
    
    public Graphe(){
      sommet = new HashMap();   
    }
    
    public void addSommet(Case nom){ 
     sommet.put(nom, new Sommet(this));    
    }
    
    public void addArrete( Case nom1 , Case nom2){
      sommet.get(nom1).addVoisin(sommet.get(nom2));  
    }
    
    public Sommet getSommet(Case nom){
        return sommet.get(nom); 
    }
    
    public void addVoisin(){
        
    }
    
    public Integer getEtiquette(Case nom1,Case nom2){
        return etiquette.get(new Pair(sommet.get(nom1),sommet.get(nom2)));
    } 
    
    
    public void setEtiquette (Case nom1, Case nom2, int eti){
        etiquette.put(new Pair(sommet.get(nom1),sommet.get(nom2)),eti);
    }
}
