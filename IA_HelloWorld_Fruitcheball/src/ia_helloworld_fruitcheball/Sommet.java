/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

import java.util.HashSet;

/**
 *
 * @author Alexiane
 */
public class Sommet {
   
    //Atribut///
    private HashSet<Sommet> voisins; 
    
    //Constructeur//
    public Sommet(Graphe grph){
       voisins = new HashSet();  
    }
    
    //donne les voisin de la case// 
    public HashSet<Sommet> GetVoisin(){
        return voisins ; 
    }
    
    //ajoute les voisin a une case///
    public void addVoisin(Sommet noeud){
        voisins.add(noeud); 
    }
}
