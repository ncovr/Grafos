import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GND implements Grafo {
    private Map<Integer, List<Integer>> listaDeAdyacencia; // <int, lista de enteros (conexiones con int)>

    public GND() {
        this.listaDeAdyacencia = new HashMap<>();
    }

    /**Añade un vértice al grafo <p>Recibe un int vértice, luego lo añade al hashMap del grafo junto con una nueva lista.
     * Es decir, (vértice, lista). La lista contendrá los vértices adyacentes del vértice. Es decir, los vértices con los
     * que está conectado mediante una arista. Si tenemos (a, {b, c}), significa que a está conectado con b y c</p>*/
    @Override
    public void addVertex(int vertex) {
        listaDeAdyacencia.putIfAbsent(vertex, new ArrayList<>());
    }

    /**Añade una relación entre dos vértices (una arista) <p>Recibe dos vértices. Si no están en el grafo, los inserta.
     * Luego, inserta el vértice2 en la lista del indice1. Después inserta el vértice1 en la lista del indice2</p>*/
    @Override
    public void addEdge(int vertex1, int vertex2) {
        listaDeAdyacencia.putIfAbsent(vertex1, new ArrayList<>());
        listaDeAdyacencia.putIfAbsent(vertex2, new ArrayList<>());
        listaDeAdyacencia.get(vertex1).add(vertex2);
        listaDeAdyacencia.get(vertex2).add(vertex1); // Para que sea no dirigido
    }

    /**Entrega los nodos que tienen relación con el vértice dado <p>Recibe un vértice y retorna la lista del vértice
     * dado</p>*/
    @Override
    public List<Integer> getNeighbors(int vertex) {
        return listaDeAdyacencia.get(vertex);
    }

    /**Imprime en consola el grafo*/
    @Override
    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : listaDeAdyacencia.entrySet()) {
            System.out.print("Vértice " + entry.getKey() + ": ");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    /**Elimina un vértice <p>Recorre todos los value <key, value> de la tabla y elimina el vértice. Después, elimina
     * el vértice (key) del grafo (hashMap)</p>*/
    @Override
    public void removeVertex(int vertex) {
        listaDeAdyacencia.values().forEach(e -> e.remove(vertex));
        listaDeAdyacencia.remove(vertex);
    }

    /**Elimina una relación (arista) entre dos vértices <p>Recibe dos vértices. Luego recupera las listas de ambos
     * vértices. Verifica si no son nulas. Si no lo son, elimina los vértices (key) del grafo (hashMap)</p>*/
    @Override
    public void removeEdge(int vertex1, int vertex2) {
        List<Integer> eV1 = listaDeAdyacencia.get(vertex1);
        List<Integer> eV2 = listaDeAdyacencia.get(vertex2);
        if (eV1 != null) eV1.remove(vertex2);
        if (eV2 != null) eV2.remove(vertex1);
    }
}
