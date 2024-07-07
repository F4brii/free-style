package com.proyectofinal.freestyle.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tl_fs_reserva", catalog = "FreeStyle", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_horario", "id_usuario"})})
@jakarta.xml.bind.annotation.XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlFsReserva.findAll", query = "SELECT t FROM TlFsReserva t"),
    @NamedQuery(name = "TlFsReserva.findByIdReserva", query = "SELECT t FROM TlFsReserva t WHERE t.idReserva = :idReserva"),
    @NamedQuery(name = "TlFsReserva.findByFechaReserva", query = "SELECT t FROM TlFsReserva t WHERE t.fechaReserva = :fechaReserva"),
    @NamedQuery(name = "TlFsReserva.findByFechaCreacion", query = "SELECT t FROM TlFsReserva t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TlFsReserva.findByFechaActualizacion", query = "SELECT t FROM TlFsReserva t WHERE t.fechaActualizacion = :fechaActualizacion")})
public class TlFsReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reserva", nullable = false)
    private Integer idReserva;
    @Column(name = "fecha_reserva")
    @Temporal(TemporalType.DATE)
    private Date fechaReserva;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReserva")
    private List<TlFsPago> tlFsPagoList;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = false)
    @ManyToOne(optional = false)
    private TlFsEstado idEstado;
    @JoinColumn(name = "id_horario", referencedColumnName = "id_horario", nullable = false)
    @ManyToOne(optional = false)
    private TlFsHorario idHorario;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private TlFsUsuario idUsuario;

    public TlFsReserva() {
    }

    public TlFsReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
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

    @jakarta.xml.bind.annotation.XmlTransient
    public List<TlFsPago> getTlFsPagoList() {
        return tlFsPagoList;
    }

    public void setTlFsPagoList(List<TlFsPago> tlFsPagoList) {
        this.tlFsPagoList = tlFsPagoList;
    }

    public TlFsEstado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(TlFsEstado idEstado) {
        this.idEstado = idEstado;
    }

    public TlFsHorario getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(TlFsHorario idHorario) {
        this.idHorario = idHorario;
    }

    public TlFsUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(TlFsUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TlFsReserva)) {
            return false;
        }
        TlFsReserva other = (TlFsReserva) object;
        return !((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva)));
    }

    @Override
    public String toString() {
        return "com.proyectofinal.freestyle.model.TlFsReserva[ idReserva=" + idReserva + " ]";
    }
    
}
