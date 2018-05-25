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
    private String cooQuetcherback;
    private String cooLanceur1;
    private String cooLanceur2;
    private Dijkstra dijkstra;
    
    public IA(Carte _c, Graph _g, Parseur _p){
        carte = _c;
        graph = _g;
        parseur = _p;
        cooQuetcherback = parseur.getQuetcherback();;
        cooLanceur1 = parseur.getLanceur1();
        cooLanceur2 = parseur.getLanceur2();
        dijkstra = new Dijkstra(graph);
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
    
    public void ordresPersos(){
        
        dijkstra.calcul(graph.getVertex(cooQuetcherback), graph.getVertex(caseFruitProche(graph.getVertex(cooQuetcherback))));
        System.out.println("Chemin de Quetcherback :");
        for(Vertex v : dijkstra.getPath()) {
            System.out.println(v.getCoordinates());
        }
        
        dijkstra.calcul(graph.getVertex(cooLanceur1), graph.getVertex(caseFruitProche(graph.getVertex(cooLanceur1))));
        System.out.println("Chemin de Lanceur1 :");
        for(Vertex v : dijkstra.getPath()) {
            System.out.println(v.getCoordinates());
        }
        
        dijkstra.calcul(graph.getVertex(cooLanceur2), graph.getVertex(caseFruitProche(graph.getVertex(cooLanceur2))));
        System.out.println("Chemin de Lanceur2 :");
        for(Vertex v : dijkstra.getPath()) {
            System.out.println(v.getCoordinates());
        }
    }
}
