package modelo;

import interfaces.INodo;
import java.util.*;

public class Nodo<T> implements INodo<T> {
    private T valor;
    private List <INodo<T>> vecinos;

    public Nodo(T valor) {
        this.valor = valor;
        this.vecinos = new ArrayList<>();
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public void agregarVecino(INodo<T> vecino) {
        if (!vecinos.contains(vecino)) {
            vecinos.add(vecino);
        }
    }

    public List<INodo<T>> getVecinos() {
        return vecinos;
    }
}