package Practica3.pr2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Graph <V>{
    private Map<V, Set<V>> adjacencyList = new HashMap<>();
    //añade un vertice v al grafo, añadiendo true si no estaba anteriormente y false si ya estaba
    public boolean addVertex(V v) {
        if (adjacencyList.containsKey(v)) {
            return false;
        }
        adjacencyList.put(v, null);
        return true;
    }
    public boolean addEdge(V v1, V v2){
        if (!adjacencyList.containsKey(v1) || !adjacencyList.containsKey(v2)) {
            return false;
        }
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
        return true;
    }
    public Set<V> getAdjacentVertices(V v) {
        return adjacencyList.get(v);
    }
    public boolean containsVertex(V v) {
        return adjacencyList.containsKey(v);
    }

    @Override
    public String toString() {
        String cadena = "";
        for (V v : adjacencyList.keySet()) {
            cadena += v + " -> " + adjacencyList.get(v) + "";

        }
        return cadena;
    }
    public Set<V> getPath(V v1, V v2) {
        return null;
    }

    public Object onePath(V v1, V v2) {

        Map<V, V> traza = new HashMap<>();
        Stack<V> abierta = new Stack<>();
        abierta.push(v1);
        traza.put(v1, null);

        boolean encontrado = false;

        while (!abierta.isEmpty() && !encontrado) {
            V actual = abierta.pop();
            for (V v : getAdjacentVertices(actual)) {
                if (!traza.containsKey(v)) {
                    traza.put(v, actual);
                    abierta.push(v);
                    if (v.equals(v2)) {
                        encontrado = true;
                        break;
                    }
                }
            }
        }
        if (encontrado) {
            Stack<V> pila = new Stack<>();
            V actual = v2;
            while (actual != null) {
                pila.push(actual);
                actual = traza.get(actual);
            }
            while (!pila.isEmpty()) {
                System.out.print(pila.pop() + " ");
            }
        } else {
            System.out.println("No hay camino");
        }


        return null;
    }

}
