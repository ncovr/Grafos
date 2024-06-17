import java.util.*;

public class GD implements G {
    private Map<Integer, List<Par<Integer, Integer>>> listaDeAdyacencia;

    public GD() {
        listaDeAdyacencia = new HashMap<>();
    }

    @Override
    public void addVertex(int vertex) {
        listaDeAdyacencia.putIfAbsent(vertex, new ArrayList<>());
    }

    @Override
    public void addEdge(int vertex1, int vertex2, int peso) {
        listaDeAdyacencia.putIfAbsent(vertex1, new ArrayList<>());
        listaDeAdyacencia.putIfAbsent(vertex2, new ArrayList<>());
        listaDeAdyacencia.get(vertex1).add(new Par<>(vertex2, peso));
    }

    @Override
    public List<Integer> getNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        for (Par<Integer, Integer> pair : listaDeAdyacencia.getOrDefault(vertex, new ArrayList<>())) {
            neighbors.add(pair.getKey());
        }
        return neighbors;
    }

    @Override
    public List<Par<Integer, Integer>> getWeightedNeighbors(int vertex) {
        return listaDeAdyacencia.getOrDefault(vertex, new ArrayList<>());
    }

    @Override
    public void printGraph() {
        for (Map.Entry<Integer, List<Par<Integer, Integer>>> entry : listaDeAdyacencia.entrySet()) {
            System.out.print("Vértice " + entry.getKey() + ": ");
            for (Par<Integer, Integer> neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void removeVertex(int vertex) {
        listaDeAdyacencia.remove(vertex);
        for (List<Par<Integer, Integer>> neighbors : listaDeAdyacencia.values()) {
            neighbors.removeIf(pair -> pair.getKey() == vertex);
        }
    }

    @Override
    public void removeEdge(int vertex1, int vertex2) {
        List<Par<Integer, Integer>> eV1 = listaDeAdyacencia.get(vertex1);
        if (eV1 != null) eV1.removeIf(pair -> pair.getKey() == vertex2);
    }
}
