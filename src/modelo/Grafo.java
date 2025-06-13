package modelo;

import interfaces.IGrafo;
import interfaces.INodo;
import java.util.*;

public class Grafo<T> implements IGrafo<T> {
    private Map<T, Nodo<T>> nodos = new HashMap<>();

    public void agregarNodo(T valor) {
        if (!nodos.containsKey(valor)) {
            nodos.put(valor, new Nodo<>(valor));
        }
    }

    public void agregarArista(T origen, T destino) {
        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            Nodo<T> nodoOrigen = nodos.get(origen);
            Nodo<T> nodoDestino = nodos.get(destino);
            nodoOrigen.agregarVecino(nodoDestino);
            nodoDestino.agregarVecino(nodoOrigen); // Grafo no dirigido
        }
    }

    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        List<T> claves = new ArrayList<>(nodos.keySet());
        claves.sort(Comparator.comparing(Object::toString));

        System.out.print("   ");
        for (T i : claves) System.out.print(i + " ");
        System.out.println();

        for (T i : claves) {
            System.out.print(i + ": ");
            for (T j : claves) {
                Nodo<T> nodoI = nodos.get(i);
                Nodo<T> nodoJ = nodos.get(j);
                System.out.print(nodoI.getVecinos().contains(nodoJ) ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public void mostrarListaAdyacencia() {
        System.out.println("Lista de Adyacencia:");
        for (Map.Entry<T, Nodo<T>> entrada : nodos.entrySet()) {
            System.out.print(entrada.getKey() + ": ");
            List<INodo<T>> vecinos = entrada.getValue().getVecinos();
            for (INodo<T> vecino : vecinos) {
                System.out.print(vecino.getValor() + " ");
            }
            System.out.println();
        }
    }

    public void bfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;
        Set<T> visitados = new HashSet<>();
        Queue<Nodo<T>> cola = new LinkedList<>();
        Nodo<T> nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            Nodo<T> actual = cola.poll();
            System.out.print(actual.getValor() + " ");
            for (INodo<T> vecino : actual.getVecinos()) {
                if (!visitados.contains(vecino.getValor())) {
                    visitados.add(vecino.getValor());
                    cola.add((Nodo<T>) vecino);
                }
            }
        }
        System.out.println();
    }

    public void dfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;
        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados);
        System.out.println();
    }

    private void dfsRec(Nodo<T> actual, Set<T> visitados) {
        visitados.add(actual.getValor());
        System.out.print(actual.getValor() + " ");
        for (INodo<T> vecino : actual.getVecinos()) {
            if (!visitados.contains(vecino.getValor())) {
                dfsRec((Nodo<T>) vecino, visitados);
            }
        }
    }
}
