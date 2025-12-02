package Entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<ParticipantesViaje> participantesViajes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "organizador", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Viaje> viajes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ParticipantesViaje> getParticipantesViajes() {
        return participantesViajes;
    }

    public void setParticipantesViajes(Set<ParticipantesViaje> participantesViajes) {
        this.participantesViajes = participantesViajes;
    }

    public Set<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(Set<Viaje> viajes) {
        this.viajes = viajes;
    }

}