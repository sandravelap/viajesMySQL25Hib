package Entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Destinos")
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "destino_id", nullable = false)
    private Integer id;

    @Column(name = "nombre_destino", nullable = false, length = 100)
    private String nombreDestino;

    @Column(name = "pais", nullable = false, length = 100)
    private String pais;

    @OneToMany
    @JoinColumn(name = "destino_id")
    private Set<Viaje> viajes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Set<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(Set<Viaje> viajes) {
        this.viajes = viajes;
    }

}