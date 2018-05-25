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
        graphe_simple= null; 
    }
    
    public void addCase(Case _c) {
        listeCase.add(_c);
    }
    
    /*METHODES*/
    //Renvoie la liste des cases
    public ArrayList<Case> getListeCase() {
        return this.listeCase;
    }
    
     private void genererGrapheSimple(){
       for ( Case c : listeCase){
           graphe_simple.addVertex(c.toString(), c.getLigne() , c.getColonne());
       }
       
       for(Case c : listeCase) {
            //System.out.println("Case : "+c.toString()+" : "+c.getType());
            for(Case c1 : listeCase) {
                if((Math.abs(c.getLigne()-c1.getLigne())==0)&&
                        (Math.abs(c.getColonne()-c1.getColonne())==1)) {
                    addEdgeAndLabelGraphSimple(c,c1);
                    //System.out.println("        It's coordinates are "+c1.toString());
                }
                if(((Math.abs(c.getLigne()-c1.getLigne())==0)&&
                        (Math.abs(c.getColonne()-c1.getColonne())==-1))
                        &&(Math.abs(c.getColonne()-c1.getColonne())>=0)) {
                    addEdgeAndLabelGraphSimple(c,c1);
                    //System.out.println("        It's coordinates are "+c1.toString());
                }
                if((Math.abs(c.getLigne()-c1.getLigne())==1)&&
                        (Math.abs(c.getColonne()-c1.getColonne())==0)) {
                    addEdgeAndLabelGraphSimple(c,c1);
                    //System.out.println("        It's coordinates are "+c1.toString());
                }
                if(((Math.abs(c.getLigne()-c1.getLigne())==-1)&&
                        (Math.abs(c.getColonne()-c1.getColonne())==0))
                        &&(Math.abs(c.getLigne()-c1.getLigne())>=0)) {
                    addEdgeAndLabelGraphSimple(c,c1);
                    //System.out.println("        It's coordinates are "+c1.toString());
                }
                
            }
            //A mettre en commentaire si on ne veut pas afficher la matrice
            System.out.println(this.stringMatrixGrapheSimple());
        }
       
       
        
       //générer les voisins 
      for ( Case c : getListeCase()){
             Vertex caseActuelle = graphe_simple.getVertex(c.toString());
             System.out.println("Coordonnée de la case : "+c.getLigne()+"/"+c.getColonne());
        }   
     }
     
     
     private void addEdgeAndLabelGraphSimple(Case c, Case c1) {
        graphe_simple.addEdge(c.toString(), c1.toString());
        if(c1.getType()==Type_Case.cloture) {
            graphe_simple.setLabel(c.toString(), c1.toString(),Integer.MAX_VALUE);
            System.out.println("    Neighbour of "+c.toString()+" is a Mur");
            System.out.println("    "+graphe_simple.getLabel(c.toString(), c1.toString()));
        }
        if(c1.getType()==Type_Case.sol) {
            graphe_simple.setLabel(c.toString(), c1.toString(),1);
            System.out.println("    Neighbour of "+c.toString()+" is a MurDur");
            System.out.println("    "+graphe_simple.getLabel(c.toString(), c1.toString()));
        }
    }
     
         
     public String stringMatrixGrapheSimple() {
        String m = "Graphe Simple Matrix :\n";
        for(Case c1 : listeCase) {
            for(Case c2 : listeCase) {
                if(graphe_simple.getLabel(c1.toString(), c2.toString()) != null) {
                    m += graphe_simple.getLabel(c1.toString(), c2.toString())+" ";
                }
                else {
                    m += "0 ";
                }
            }
            m += "\n";
        }
        return m;
    }
     
     
}

      
