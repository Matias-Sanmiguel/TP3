package test;

import modelo.*;

public class TestGrafoGenerico {
    public static void main (String[] args) {
        Grafo<Persona> grafo = new Grafo<>();

        Persona terry = new Persona("Terry");
        Persona horacio = new Persona("Horacio");
        Persona carla = new Persona("Carla");
        Persona daniel = new Persona("Daniel");
        Persona emilia = new Persona("Emilia");
        Persona francisco = new Persona("Francisco");
        Persona gabriela = new Persona("Gabriela");

        grafo.agregarNodo(terry);
        grafo.agregarNodo(horacio);
        grafo.agregarNodo(carla);
        grafo.agregarNodo(daniel);
        grafo.agregarNodo(emilia);
        grafo.agregarNodo(francisco);
        grafo.agregarNodo(gabriela);

        grafo.agregarArista(terry, horacio);
        grafo.agregarArista(horacio, carla);
        grafo.agregarArista(carla, daniel);
        grafo.agregarArista(daniel, terry);
        grafo.agregarArista(terry, emilia);
        grafo.agregarArista(emilia, francisco);
        grafo.agregarArista(francisco, gabriela);

        grafo.mostrarMatrizAdyacencia();
        grafo.mostrarListaAdyacencia();
        grafo.bfs(terry);
        grafo.dfs(terry);
    }
}