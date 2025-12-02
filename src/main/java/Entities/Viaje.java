package Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Viajes")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "viaje_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organizador_id", nullable = false)
    private Persona organizador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destino_id", nullable = false)
    private Destino destino;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "presupuesto_estimado", precision = 10, scale = 2)
    private BigDecimal presupuestoEstimado;

    @OneToMany(mappedBy = "viaje", cascade = CascadeType.REMOVE)
    private Set<ParticipantesViaje> participantesViajes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Persona organizador) {
        this.organizador = organizador;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPresupuestoEstimado() {
        return presupuestoEstimado;
    }

    public void setPresupuestoEstimado(BigDecimal presupuestoEstimado) {
        this.presupuestoEstimado = presupuestoEstimado;
    }

    public Set<ParticipantesViaje> getParticipantesViajes() {
        return participantesViajes;
    }

    public void setParticipantesViajes(Set<ParticipantesViaje> participantesViajes) {
        this.participantesViajes = participantesViajes;
    }

}