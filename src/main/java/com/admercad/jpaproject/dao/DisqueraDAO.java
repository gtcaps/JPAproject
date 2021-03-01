
package com.admercad.jpaproject.dao;

import com.admercad.jpaproject.entity.Disquera;
import java.util.List;
        
/**
 *
 * @author aybso
 * Interface que genera el DAO para las transacciones del CRUD a la tabla disquera
 */
public interface DisqueraDAO {
    
    void guardar(Disquera disquera);
    
    void actualizar(Disquera disquera);
    
    void eliminar(Long id);
    
    List<Disquera> consultar();
    
    Disquera consultarById(Long id);
}
