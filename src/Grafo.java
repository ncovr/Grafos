import java.util.List;

public interface Grafo {
    void addVertex(int vertex);
    void addEdge(int vertex1, int vertex2);
    List<Integer> getNeighbors(int vertex);
    void printGraph();
    void removeVertex(int vertex);
    void removeEdge(int vertex1, int vertex2);
}
