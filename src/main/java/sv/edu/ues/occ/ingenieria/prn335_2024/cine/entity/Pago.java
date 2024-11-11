package sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "pago", schema = "public")
public class Pago {
    @Id
    @Column(name = "id_pago", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura")
    private Factura idFactura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_pago")
    private TipoPago idTipoPago;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "idPago")
    private List<PagoDetalle> pagoDetalleList;

    @Column(name = "fecha")
    private OffsetDateTime fecha;

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long id) {
        this.idPago = id;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public TipoPago getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(TipoPago idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public OffsetDateTime getFecha() {
        return fecha;
    }

    public void setFecha(OffsetDateTime fecha) {
        this.fecha = fecha;
    }

    public List<PagoDetalle> getPagoDetalleList() {
        return pagoDetalleList;
    }

    public void setPagoDetalleList(List<PagoDetalle> pagoDetalleList) {
        this.pagoDetalleList = pagoDetalleList;
    }
}