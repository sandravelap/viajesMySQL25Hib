package Controllers;

import Entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class InsertController {
    public static void insertPersona(EntityManagerFactory emf, Persona persona) {
        try(EntityManager em = emf.createEntityManager()){
            //Para insertar elementos nuevo hace falta transacción
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(persona);
            tx.commit();
            System.out.println("Persona insertada correctamente");
        }
    }
}
