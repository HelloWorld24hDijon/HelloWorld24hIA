/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

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
    
    public Case caseFruitProche(Vertex v ){
        return null ;
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
