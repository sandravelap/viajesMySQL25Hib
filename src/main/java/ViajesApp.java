import Entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ViajesApp {
    public static void main(String[] args) {
        Persona personaNueva = new Persona();
        personaNueva.setNombre("Juanito");
        personaNueva.setEmail("juanito@gmail.com");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        try(EntityManager em = emf.createEntityManager()){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(personaNueva);
            tx.commit();
            System.out.println("Museo insertado correctamente");
        }

    }
}
