package sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "programacion", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Programacion.findByIdSala",query = "SELECT prn FROM Programacion prn WHERE prn.idSala.idSala=:idSala ORDER BY prn.idProgramacion ASC "),
        @NamedQuery(name = "Programacion.countByIdSala", query = "SELECT COUNT(prn.idProgramacion) FROM Programacion prn WHERE prn.idSala.idSala=:idSala")
})
public class Programacion {
    @Id
    @Column(name = "id_programacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgramacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sala")
    private Sala idSala;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pelicula")
    private Pelicula idPelicula;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "idProgramacion")
    private List<Reserva> reservaList;

    @Column(name = "desde")
    private OffsetDateTime desde;

    @Column(name = "hasta")
    private OffsetDateTime hasta;

    @Lob
    @Column(name = "comentarios")
    private String comentarios;

    public Long getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(Long id) {
        this.idProgramacion = id;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }

    public Pelicula getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Pelicula idPelicula) {
        this.idPelicula = idPelicula;
    }

    public OffsetDateTime getDesde() {
        return desde;
    }

    public void setDesde(OffsetDateTime desde) {
        this.desde = desde;
    }

    public OffsetDateTime getHasta() {
        return hasta;
    }

    public void setHasta(OffsetDateTime hasta) {
        this.hasta = hasta;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }
}