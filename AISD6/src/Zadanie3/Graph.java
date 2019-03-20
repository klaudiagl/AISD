package Zadanie3;

import java.io.*;
import java.util.*;
import Zadanie1.PriorityQueue;

public class Graph {
    public ArrayList<Vertex> vertices;
    public ArrayList<Edge> edges;


    public Graph() throws IOException {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
        
        File file = new File("src/Zadanie3/graph.txt");
        Scanner in = new Scanner(file);
        int vertexNumber = Integer.parseInt(in.nextLine());
        System.out.println("Number of vertices: "+vertexNumber);
        int edgeNumber = Integer.parseInt(in.nextLine());
        System.out.println("Number of edges: "+edgeNumber);
        
        for(int i=0;i<vertexNumber;i++){
            vertices.add(new Vertex(i));
            vertices.get(i).setDistance(1000000);
            vertices.get(i).setPrev(null);
        }
        
        for(int i=0;i<edgeNumber;i++){
            String line = in.nextLine();
            String edgeLine[] = line.split(" ");
            int from = Integer.parseInt(edgeLine[0]);
            int to = Integer.parseInt(edgeLine[1]);
            float weight = Float.parseFloat(edgeLine[2]);
            Edge edge = new Edge(from, to, weight);
            edges.add(edge);
            vertices.get(from).addEdge(edge);
        }
        in.close();
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void DijkstraAlgorithm(int sourceId) {
        vertices.get(sourceId).setDistance(0);
        PriorityQueue<Vertex> prioQueue= new PriorityQueue<>(vertices, new ComparatorVertex());

        while(!prioQueue.isEmpty()) {
            Vertex start = prioQueue.extractMin();
            for(Edge edge : start.getEdgeList()) {
                Vertex connectedVertex = vertices.get(edge.getTo());

                if(connectedVertex.getDistance() > (start.getDistance()+edge.getWeight())) {
                    int index = prioQueue.getIndex(connectedVertex);
                	connectedVertex.setDistance(start.getDistance()+edge.getWeight());
                    connectedVertex.setPrev(start);
                    prioQueue.decreaseKey(index, connectedVertex);
                }
            }
        }

        for(Vertex vertex : vertices) {
        	float dist = vertex.getDistance();
        	System.out.print("\nDistance ("+sourceId+"-->"+vertex.getId()+")= "+dist);
            System.out.print(",   Path: "+vertex.getId());
        	while(vertex.getPrev() != null) {
                vertex = vertex.getPrev();
                System.out.print(" <-- "+vertex.getId());
            }
        }
    }
    
    public void printVertices() {
        for(Vertex vertex : vertices) {
     	   System.out.print("Vertex "+ vertex.getId()+ "\n");
        
            for(Edge edge : vertex.getEdgeList()) {
                System.out.println("  "+edge.getFrom()+"->"+edge.getTo()+": "+edge.getWeight());
            }
        }
     }
    
    private static class ComparatorVertex implements Comparator<Vertex>{

    	@Override
    	public int compare(Vertex child, Vertex parent) {
    		if(child.getDistance()>parent.getDistance()){
    			return 1;
    		}else if(child.getDistance()<parent.getDistance()){
    			return -1;
    		}else{
    			return 0;
    		}
    	}
    }
}
