import java.util.*;

public class GND implements Grafo {
    private Map<Integer, List<Pair<Integer, Integer>>> listaDeAdyacencia;

    public GND() {
        this.listaDeAdyacencia = new HashMap<>();
    }

    /**Añade un vértice*/
    @Override
    public void addVertex(int vertex) {
        listaDeAdyacencia.putIfAbsent(vertex, new ArrayList<>());
    }

    /**Añade una arista entre dos vértices y un peso*/
    @Override
    public void addEdge(int vertex1, int vertex2, int peso) {
        listaDeAdyacencia.putIfAbsent(vertex1, new ArrayList<>());
        listaDeAdyacencia.putIfAbsent(vertex2, new ArrayList<>());
        listaDeAdyacencia.get(vertex1).add(new Pair<>(vertex2, peso));
        listaDeAdyacencia.get(vertex2).add(new Pair<>(vertex1, peso));
    }

    @Override
    public List<Integer> getNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        for (Pair<Integer, Integer> pair : listaDeAdyacencia.getOrDefault(vertex, new ArrayList<>())) {
            neighbors.add(pair.getKey());
        }
        return neighbors;
    }

    @Override
    public List<Pair<Integer, Integer>> getWeightedNeighbors(int vertex) {
        return listaDeAdyacencia.getOrDefault(vertex, new ArrayList<>());
    }

    @Override
    public void printGraph() {
        for (Map.Entry<Integer, List<Pair<Integer, Integer>>> entry : listaDeAdyacencia.entrySet()) {
            System.out.print("Vértice " + entry.getKey() + ": ");
            for (Pair<Integer, Integer> neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void removeVertex(int vertex) {
        listaDeAdyacencia.values().forEach(e -> e.removeIf(pair -> pair.getKey() == vertex));
        listaDeAdyacencia.remove(vertex);
    }

    @Override
    public void removeEdge(int vertex1, int vertex2) {
        List<Pair<Integer, Integer>> eV1 = listaDeAdyacencia.get(vertex1);
        List<Pair<Integer, Integer>> eV2 = listaDeAdyacencia.get(vertex2);
        if (eV1 != null) eV1.removeIf(pair -> pair.getKey() == vertex2);
        if (eV2 != null) eV2.removeIf(pair -> pair.getKey() == vertex1);
    }
}
