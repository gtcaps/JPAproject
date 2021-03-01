/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admercad.jpaproject.dao.impl;

import com.admercad.jpaproject.entity.Disquera;
import com.admercad.jpaproject.dao.DisqueraDAO;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aybso
 */
public class DisqueraDAOImplTest {
    
    private DisqueraDAO disqueraDAO = new DisqueraDAOImpl();
    
    public DisqueraDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of guardar method, of class DisqueraDAOImpl.
     */
    @Test
    public void testGuardar() {
        Disquera disquera = new Disquera();
        disquera.setDescripcion("MegaForce");
        disquera.setFechaCreacion(LocalDateTime.now());
        disquera.setEstatus(true);
        
        this.disqueraDAO.guardar(disquera);
    }

    /**
     * Test of actualizar method, of class DisqueraDAOImpl.
     */
    @Test
    public void testActualizar() {
        Disquera disqueraConsultada = this.disqueraDAO.consultarById(9L);
        
        disqueraConsultada.setDescripcion("Sony");
        disqueraConsultada.setFechaModificacion(LocalDateTime.now());
        
        this.disqueraDAO.actualizar(disqueraConsultada);
        
    }

    /**
     * Test of eliminar method, of class DisqueraDAOImpl.
     */
    @Test
    public void testEliminar() {
        Long id = 10L;
        this.disqueraDAO.eliminar(id);
    }

    /**
     * Test of consultar method, of class DisqueraDAOImpl.
     */
    @Test
    public void testConsultar() {
        List<Disquera> disquerasConsultadas = this.disqueraDAO.consultar();
        assertTrue(disquerasConsultadas.size() > 0);
        
        disquerasConsultadas.forEach(disquera -> {
            System.out.println("Disquera: " + disquera.getDescripcion());
        });
        
    }

    /**
     * Test of consultarById method, of class DisqueraDAOImpl.
     */
    @Test
    public void testConsultarById() {
        System.out.println("consultarById");
        Long id = null;
        DisqueraDAOImpl instance = new DisqueraDAOImpl();
        Disquera expResult = null;
        Disquera result = instance.consultarById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
