/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

import java.util.ArrayList;

/**
 *
 * @author emili
 */
public class Carte {
    /*ATTRIBUTS*/
    private ArrayList<Case> listeCase;
    private Graph graphe_simple;
    
    
    /*CONSTRUCTEUR*/
    public Carte(){
        this.listeCase = new ArrayList();
        this.graphe_simple= new Graph();
    }
    
    /*METHODES*/
    //Renvoie la liste des cases
    public ArrayList<Case> getListeCase() {
        return this.listeCase;
    }
    
     private void genererGrapheSimple(){
       for ( Case c : getListeCase()){
           graphe_simple.addVertex(/*a trouver */);
       }
       
       for ( Case c : getListeCase()){
            for ( Case c1 : getListeCase()){
                 if (Math.abs((c.getLigne()-c1.getLigne())+(c.getColonne()-c1.getColonne()))==1 && c1.getType()!=Type_Case.MurDur && c1.getType()!=Type_Case.MurIndestructible){
                    graphe_simple.addEdge(c.toString(), c1.toString());
                    graphe_simple.setLabel(c.toString(), c1.toString(), 1);
                 }
            }     
        }
        
       //générer les voisins 
      for ( Case c : getListeCase()){
             Vertex caseActuelle = graphe_simple.getVertex(c.toString());
             System.out.println("Coordonnée de la case : "+c.getLigne()+"/"+c.getColonne());
        }   
     }
}

      
