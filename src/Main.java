public class Main {
    public static void main(String[] args) {
        // Prueba del Grafo Dirigido (GD)
        System.out.println("Grafo Dirigido:");
        GD grafoDirigido = new GD();
        grafoDirigido.addVertex(1);
        grafoDirigido.addVertex(2);
        grafoDirigido.addVertex(3);
        grafoDirigido.addEdge(1, 2, 5);
        grafoDirigido.addEdge(2, 3, 10);
        grafoDirigido.addEdge(3, 1, 15);
        grafoDirigido.printGraph();

        // Obtener vecinos de un vértice en grafo dirigido
        System.out.println("Vecinos del vértice 1 en Grafo Dirigido: " + grafoDirigido.getNeighbors(1));
        System.out.println("Vecinos ponderados del vértice 1 en Grafo Dirigido: " + grafoDirigido.getWeightedNeighbors(1));

        // Prueba del Grafo No Dirigido (GND)
        System.out.println("\nGrafo No Dirigido:");
        GND grafoNoDirigido = new GND();
        grafoNoDirigido.addVertex(1);
        grafoNoDirigido.addVertex(2);
        grafoNoDirigido.addVertex(3);
        grafoNoDirigido.addEdge(1, 2, 5);
        grafoNoDirigido.addEdge(2, 3, 10);
        grafoNoDirigido.addEdge(3, 1, 15);
        grafoNoDirigido.printGraph();

        // Obtener vecinos de un vértice en grafo no dirigido
        System.out.println("Vecinos del vértice 1 en Grafo No Dirigido: " + grafoNoDirigido.getNeighbors(1));
        System.out.println("Vecinos ponderados del vértice 1 en Grafo No Dirigido: " + grafoNoDirigido.getWeightedNeighbors(1));
    }
}
