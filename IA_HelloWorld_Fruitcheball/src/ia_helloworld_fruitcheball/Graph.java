/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_helloworld_fruitcheball;

import ia_helloworld_fruitcheball.Carte;
import java.util.Collection;

import java.util.HashMap;
import javafx.util.Pair;

/**
 *
 * @author aurian
 */
public class Graph {
    
    private final Carte map;
    private final HashMap<String,Vertex> vertices;
    private final HashMap<Pair<Vertex,Vertex>,Integer> labels;
    
    public Graph(Carte m) {
        map = m;
        vertices = new HashMap<>();
        labels = new HashMap<>();
    }    
    
    public void addVertex(String name, int line, int column) {
        vertices.put(name,new Vertex(this,line,column));
    }
    
    public void addEdge(String name1, String name2) {
        vertices.get(name1).addNeighbour(vertices.get(name2));      
    }
    
    public Vertex getVertex(String name) {
        return vertices.get(name);
    }
    
    public Integer getLabel(String name1,String name2) {
        return getLabel(vertices.get(name1),vertices.get(name2));
    }
    
    public Integer getLabel(Vertex v1, Vertex v2) {
        return labels.get(new Pair(v1,v2));
    }
    
    public void setLabel(String name1,String name2,Integer label) {
        labels.put(new Pair(vertices.get(name1),vertices.get(name2)),label);
    }
    public Collection<Vertex> getVertices() {
        return vertices.values();
    }
}
