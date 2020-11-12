/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.interfaces;

import java.util.List;

/**
 *
 * @author fabry
 * @param <T>
 * @param <K>
 */
public interface DaoBase<T,K> {
    
    void insertar(T a);
    void modificar (T a);
    void eliminar (T a);
    List<T> obtenerRegistros();
    T obtener (K id);
}
