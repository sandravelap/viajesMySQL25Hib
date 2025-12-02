
import Entities.Persona;
import Entities.Viaje;
import jakarta.persistence.*;

import java.util.List;

import static Controllers.InsertController.insertPersona;
import static Controllers.SelectController.getDestinos;

public class ViajesApp {
    public static void main(String[] args) {
        Persona personaNueva = new Persona();
        personaNueva.setNombre("Juanito");
        personaNueva.setEmail("juanito@gmail.com");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        //insertPersona(emf, personaNueva);
        getDestinos(emf);
        //cambiarOrganizador(emf);
        String nombrePersona = "Juanito";
        borrarPersona(nombrePersona, emf);
    }

    public static void  borrarPersona(String nombrePersona, EntityManagerFactory emf){
        //creamos el contexto de persistencia
        try(EntityManager em = emf.createEntityManager()) {
            //transacción para modificar la base de datos
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            //recuperar el elemento para que esté en el contexto de persistencia
            Query selectPersona = em.createQuery("from Persona where nombre like :nombrePersona");
            selectPersona.setParameter("nombrePersona", nombrePersona);
            Persona persona = (Persona) selectPersona.getSingleResult();
            //como ya está en el contexto de persistencia lo puedo borrar en la base de datos
            em.remove(persona);
            //ejecuto en la base de datos
            tx.commit();
        }
    }
}
