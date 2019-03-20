package Zadanie3;

import java.util.ArrayList;

public class Vertex {
    private ArrayList<Edge> edgesFrom;
    private int id;
    private float distance;
    private Vertex prev;

    public Vertex(int i){
        this.id = i;
        edgesFrom = new ArrayList<Edge>();
    }

    public int getId(){
        return this.id;
    }
    public void setPrev(Vertex prev){
        this.prev = prev;
    }

    public Vertex getPrev(){
        return this.prev;
    }

    public void setDistance(float dist){
        this.distance = dist;
    }

    public float getDistance(){
        return this.distance;
    }

    public void addEdge(Edge newEdge){
        edgesFrom.add(newEdge);
    }

    public ArrayList<Edge> getEdgeList(){
        return edgesFrom;
    }
    




}
