package Controllers;

import Entities.Destino;
import Entities.Viaje;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;

public class SelectController {
    public static void getDestinos(EntityManagerFactory emf) {
        try(EntityManager em = emf.createEntityManager()){
            //para consultas que no implican modificaciones no hace falta
            //crear la tx
            Query sqlDestinos = em.createQuery("from Destino");
            List<Destino> destinos = sqlDestinos.getResultList();
            for (Destino destino : destinos) {
                System.out.println(destino.getNombreDestino());
                for (Viaje viaje : destino.getViajes()){
                    System.out.println(viaje.getOrganizador().getNombre());
                }
            }
        }
    }
}
