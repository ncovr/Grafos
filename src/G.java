import java.util.List;

public interface G {
    void addVertex(int vertex);
    void addEdge(int vertex1, int vertex2, int peso);
    List<Integer> getNeighbors(int vertex);
    List<Par<Integer, Integer>> getWeightedNeighbors(int vertex);
    void printGraph();
    void removeVertex(int vertex);
    void removeEdge(int vertex1, int vertex2);
}
