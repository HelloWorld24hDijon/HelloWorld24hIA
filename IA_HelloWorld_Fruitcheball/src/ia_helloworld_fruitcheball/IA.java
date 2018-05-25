/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;
import java.util.ArrayList;
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
    private ArrayList<Vertex> cheminQuetcherback = new ArrayList<>();
    private ArrayList<Vertex> cheminLanceur1 = new ArrayList<>();
    private ArrayList<Vertex> cheminLanceur2 = new ArrayList<>();
    
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
    
    public String ordresPersos(){
        System.out.println("cooQuetcherback : "+cooQuetcherback);
        System.out.println("fruit plus proche : "+caseFruitProche(graph.getVertex(cooQuetcherback)));
        dijkstra.calcul(graph.getVertex(cooQuetcherback), graph.getVertex(caseFruitProche(graph.getVertex(cooQuetcherback))));
        System.out.println("Chemin de Quetcherback :");
        cheminQuetcherback = dijkstra.getPath();
        for(Vertex v : cheminQuetcherback) {
            System.out.println(v.getCoordinates());
        }
        
        System.out.println("cooLanceur1 : "+cooLanceur1);
        System.out.println("fruit plus proche : "+caseFruitProche(graph.getVertex(cooQuetcherback)));
        dijkstra.calcul(graph.getVertex(cooLanceur1), graph.getVertex(caseFruitProche(graph.getVertex(cooLanceur1))));
        System.out.println("Chemin de Lanceur1 :");
        cheminLanceur1 = cheminLanceur1;
        for(Vertex v : dijkstra.getPath()) {
            System.out.println(v.getCoordinates());
        }
        
        System.out.println("cooLanceur2 : "+cooLanceur2);
        System.out.println("fruit plus proche : "+caseFruitProche(graph.getVertex(cooQuetcherback)));
        dijkstra.calcul(graph.getVertex(cooLanceur2), graph.getVertex(caseFruitProche(graph.getVertex(cooLanceur2))));
        System.out.println("Chemin de Lanceur2 :");
        cheminLanceur2 = dijkstra.getPath();
        for(Vertex v : cheminLanceur2) {
            System.out.println(v.getCoordinates());
        }
        return ordreFinal();
    }
    
    private String ordreFinal(){
        String ordre = "";
        if(cheminQuetcherback.get(1).getLine()>graph.getVertex(cooQuetcherback).getLine()){
            ordre += "N";
        }
        if(cheminQuetcherback.get(1).getLine()<graph.getVertex(cooQuetcherback).getLine()){
            ordre += "S";
        }
        if(cheminQuetcherback.get(1).getColumn()>graph.getVertex(cooQuetcherback).getColumn()){
            ordre += "E";
        }
        if(cheminQuetcherback.get(1).getColumn()<graph.getVertex(cooQuetcherback).getColumn()){
            ordre += "O";
        }
        ordre += "-";
        if(cheminLanceur1.get(1).getLine()>graph.getVertex(cooLanceur1).getLine()){
            ordre += "N";
        }
        if(cheminLanceur1.get(1).getLine()<graph.getVertex(cooLanceur1).getLine()){
            ordre += "S";
        }
        if(cheminLanceur1.get(1).getColumn()>graph.getVertex(cooLanceur1).getColumn()){
            ordre += "E";
        }
        if(cheminLanceur1.get(1).getColumn()<graph.getVertex(cooLanceur1).getColumn()){
            ordre += "O";
        }
        ordre += "-";
        if(cheminLanceur2.get(1).getLine()>graph.getVertex(cooLanceur2).getLine()){
            ordre += "N";
        }
        if(cheminLanceur2.get(1).getLine()<graph.getVertex(cooLanceur2).getLine()){
            ordre += "S";
        }
        if(cheminLanceur2.get(1).getColumn()>graph.getVertex(cooLanceur2).getColumn()){
            ordre += "E";
        }
        if(cheminLanceur2.get(1).getColumn()<graph.getVertex(cooLanceur2).getColumn()){
            ordre += "O";
        }
        return ordre+"\n";
    }
}
