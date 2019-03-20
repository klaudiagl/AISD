package Zadanie3;

public class Edge {
    private int from;
    private int to;
    private float weight;

    public Edge(int from, int to, float weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return this.from;
    }

    public int getTo() {
        return this.to;
    }

    public float getWeight() {
        return this.weight;
    }
}
