package sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pago_detalle", schema = "public")
public class PagoDetalle {
    @Id
    @Column(name = "id_pago_detalle", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagoDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pago")
    private Pago idPago;

    @Column(name = "monto", precision = 10, scale = 2)
    private BigDecimal monto;

    @Lob
    @Column(name = "concepto")
    private String concepto;

    public Long getIdPagoDetalle() {
        return idPagoDetalle;
    }

    public void setIdPagoDetalle(Long id) {
        this.idPagoDetalle = id;
    }

    public Pago getIdPago() {
        return idPago;
    }

    public void setIdPago(Pago idPago) {
        this.idPago = idPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

}