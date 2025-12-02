package Controllers;

import Entities.Persona;
import Entities.Viaje;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class UpdateController {
    public static void cambiarOrganizador(EntityManagerFactory emf){
        //update de Persona organizadora de un Viaje
        try(EntityManager em = emf.createEntityManager()){
            //si sabemos el nombre de la persona y el nombre del destino podemos recuperar el viaje
            Query selectViaje =em.createQuery("select v from Viaje v " +
                    "where organizador.nombre like :nombreOrganizador " +
                    "and destino.nombreDestino like :nombreDestino");
            selectViaje.setParameter("nombreOrganizador", "Ana García");
            selectViaje.setParameter("nombreDestino", "Kioto");
            Viaje viaje = (Viaje) selectViaje.getSingleResult();
            //recuperamos la nueva Persona organizador:
            Query selectNuevoOrganizador = em.createQuery("select p from Persona p where nombre like :nuevoOrganizador");
            selectNuevoOrganizador.setParameter("nuevoOrganizador", "Juanito");
            //guardamos en un objeto Persona el nuevo organizador:
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Persona nuevoOrganizador = (Persona) selectNuevoOrganizador.getSingleResult();
            //cambiamos el organizador del viaje recuperado
            viaje.setOrganizador(nuevoOrganizador);
            tx.commit();
            System.out.println("Espera");
        }
    }
}
