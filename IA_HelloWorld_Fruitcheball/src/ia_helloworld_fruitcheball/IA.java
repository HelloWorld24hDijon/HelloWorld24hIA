/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;
import java.lang.Math;
/**
 *
 * @author aurian
 */
public class IA {
    
    private Carte carte;
    private Graph graph;
    private Parseur parseur;
    
    public IA(Carte _c, Graph _g, Parseur _p){
        carte = _c;
        graph = _g;
        parseur = _p;
    }
    
    public String caseFruitProche(Vertex v ){
        int ligneV = v.getLine();
        int colonneV = v.getColumn();
        int valeurMin = Integer.MAX_VALUE;
        int ColMin = Integer.MAX_VALUE;
        int LigMin = Integer.MAX_VALUE;
        
        for (Case c : parseur.getTabCooCasesFruits()){
            int cL = c.getLigne(); 
            int cO= c.getColonne();
            
            int distance = (int) Math.sqrt( ( cL - ligneV)*( cL - ligneV) +(cO -colonneV )*(cO -colonneV ));
            if(distance < valeurMin){
                valeurMin= distance;
                ColMin=cO;
                LigMin=cL;
            }
        }
        
        
        
        
        
        
        String s = LigMin+"/"+ColMin;
        return s;
    }
}
