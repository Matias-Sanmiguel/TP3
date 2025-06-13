package interfaces;

public interface IGrafo<T> {

    void agregarNodo(T valor);
    void agregarArista(T origen, T destino);
    void mostrarMatrizAdyacencia();
    void mostrarListaAdyacencia();
    void bfs(T inicio);
    void dfs(T inicio);
}