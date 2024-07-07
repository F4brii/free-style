package com.proyectofinal.freestyle.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tl_fs_pago", catalog = "FreeStyle", schema = "public")
@jakarta.xml.bind.annotation.XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlFsPago.findAll", query = "SELECT t FROM TlFsPago t"),
    @NamedQuery(name = "TlFsPago.findByIdPago", query = "SELECT t FROM TlFsPago t WHERE t.idPago = :idPago"),
    @NamedQuery(name = "TlFsPago.findByValorPagado", query = "SELECT t FROM TlFsPago t WHERE t.valorPagado = :valorPagado"),
    @NamedQuery(name = "TlFsPago.findByFechaPago", query = "SELECT t FROM TlFsPago t WHERE t.fechaPago = :fechaPago"),
    @NamedQuery(name = "TlFsPago.findByFechaCreacion", query = "SELECT t FROM TlFsPago t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TlFsPago.findByFechaActualizacion", query = "SELECT t FROM TlFsPago t WHERE t.fechaActualizacion = :fechaActualizacion")})
public class TlFsPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago", nullable = false)
    private Integer idPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_pagado", precision = 18, scale = 2)
    private BigDecimal valorPagado;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = false)
    @ManyToOne(optional = false)
    private TlFsEstado idEstado;
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", nullable = false)
    @ManyToOne(optional = false)
    private TlFsReserva idReserva;

    public TlFsPago() {
    }

    public TlFsPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public BigDecimal getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(BigDecimal valorPagado) {
        this.valorPagado = valorPagado;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public TlFsEstado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(TlFsEstado idEstado) {
        this.idEstado = idEstado;
    }

    public TlFsReserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(TlFsReserva idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TlFsPago)) {
            return false;
        }
        TlFsPago other = (TlFsPago) object;
        return !((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago)));
    }

    @Override
    public String toString() {
        return "com.proyectofinal.freestyle.model.TlFsPago[ idPago=" + idPago + " ]";
    }
    
}
