package com.admercad.jpaproject.dao.impl;

import com.admercad.jpaproject.dao.DisqueraDAO;
import com.admercad.jpaproject.entity.Disquera;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author aybso
 * Clase que implementa las transacciones para la tabla de disquera
 */
public class DisqueraDAOImpl implements DisqueraDAO{
    
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistenceTiendaMusical");

    @Override
    public void guardar(Disquera disquera) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        
        EntityTransaction et = em.getTransaction();
        et.begin();
        
        try {
            em.persist(disquera);
            et.commit();
        } catch(Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        
    }

    @Override
    public void actualizar(Disquera disquera) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        
        EntityTransaction et = em.getTransaction();
        et.begin();
        
        try {
            em.merge(disquera);
            et.commit();
        } catch(Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        Disquera disqueraConsultada = em.find(Disquera.class, id);
        
        EntityTransaction et = em.getTransaction();
        et.begin();
        
        try {
            em.remove(disqueraConsultada);
            et.commit();
        } catch(Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Disquera> consultar() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        TypedQuery<Disquera> queryDisquera = (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");
        return queryDisquera.getResultList();
    }

    @Override
    public Disquera consultarById(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        
        Disquera disqueraConsultada = em.find(Disquera.class, id);
        
        if (disqueraConsultada == null){
            throw new EntityNotFoundException("La disquera con id: " + id + " no se encontro");
        }
        
        return disqueraConsultada;
    }
    
}
