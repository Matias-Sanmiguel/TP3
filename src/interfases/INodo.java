package interfaces;

import java.util.List;

public interface INodo<T> {
	
    T getValor();
    void setValor(T valor);
    void agregarVecino(INodo<T> vecino);
    List<INodo<T>> getVecinos();
}
