import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class GD implements Grafo {
    private Map<Integer, List<Integer>> listaDeAdyacencia;

    public GD() {
        listaDeAdyacencia = new HashMap<>();
    }

    /**Añade un vértice al grafo <p>Agrega un nuevo elemento al hashMap donde vertex es el vértice y la lista corresponde
     * a los vértices con los que tiene conexión dirigida</p>*/
    @Override
    public void addVertex(int vertex) {
        listaDeAdyacencia.putIfAbsent(vertex, new ArrayList<>());
    }

    /**Agrega una relación unidireccional entre dos nodos <p>Recibe dos vértices 1 y 2. Si no existen en el grafo, los
     * crea. Luego añade el vértice2 a la lista del vértice1</p>*/
    @Override
    public void addEdge(int vertex1, int vertex2) {
        listaDeAdyacencia.putIfAbsent(vertex1, new ArrayList<>());
        listaDeAdyacencia.putIfAbsent(vertex2, new ArrayList<>());
        listaDeAdyacencia.get(vertex1).add(vertex2); // Solo agregar una dirección
    }

    /**Retorna la lista de vértices asociados a vertex (retorna los vértices con los que se relaciona unidireccionalmente
     * con vertex) <p>El método getOrDefault del hashMap nos retorna la lista (value) del vertex (key)</p>*/
    @Override
    public List<Integer> getNeighbors(int vertex) {
        return listaDeAdyacencia.getOrDefault(vertex, new ArrayList<>());
    }

    /**Imprime en consola los vértices y sus aristas*/
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

    /**Elimina un vértice del grafo <p>Remueve del hashMap la key vertex. Luego recorre todos los value valores del hashMap
     * y elimina los que tengan como valor vertex</p>*/
    @Override
    public void removeVertex(int vertex) {
        listaDeAdyacencia.remove(vertex);
        for (List<Integer> neighbors : listaDeAdyacencia.values()) {
            neighbors.remove(Integer.valueOf(vertex));
        }
    }

    /**Elimina una arista <p>Recibe dos vértices. Primero recoge la lista de vértices del vértice1. Luego, si es que
     * la lista es no nula, procede a eliminar el valor igual al del vértice2</p>*/
    @Override
    public void removeEdge(int vertex1, int vertex2) {
        List<Integer> eV1 = listaDeAdyacencia.get(vertex1);
        if (eV1 != null) eV1.remove(Integer.valueOf(vertex2));
    }


}
