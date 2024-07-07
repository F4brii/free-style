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
@Table(name = "tl_fs_horario", catalog = "FreeStyle", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_cancha", "id_fecha"})})
@jakarta.xml.bind.annotation.XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlFsHorario.findAll", query = "SELECT t FROM TlFsHorario t"),
    @NamedQuery(name = "TlFsHorario.findByIdHorario", query = "SELECT t FROM TlFsHorario t WHERE t.idHorario = :idHorario"),
    @NamedQuery(name = "TlFsHorario.findByFechaCreacion", query = "SELECT t FROM TlFsHorario t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TlFsHorario.findByFechaActualizacion", query = "SELECT t FROM TlFsHorario t WHERE t.fechaActualizacion = :fechaActualizacion")})
public class TlFsHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_horario", nullable = false)
    private Integer idHorario;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @JoinColumn(name = "id_cancha", referencedColumnName = "id_cancha", nullable = false)
    @ManyToOne(optional = false)
    private TlFsCancha idCancha;
    @JoinColumn(name = "id_fecha", referencedColumnName = "id_fecha", nullable = false)
    @ManyToOne(optional = false)
    private TlFsFecha idFecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHorario")
    private List<TlFsReserva> tlFsReservaList;

    public TlFsHorario() {
    }

    public TlFsHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
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

    public TlFsCancha getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(TlFsCancha idCancha) {
        this.idCancha = idCancha;
    }

    public TlFsFecha getIdFecha() {
        return idFecha;
    }

    public void setIdFecha(TlFsFecha idFecha) {
        this.idFecha = idFecha;
    }

    @jakarta.xml.bind.annotation.XmlTransient
    public List<TlFsReserva> getTlFsReservaList() {
        return tlFsReservaList;
    }

    public void setTlFsReservaList(List<TlFsReserva> tlFsReservaList) {
        this.tlFsReservaList = tlFsReservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TlFsHorario)) {
            return false;
        }
        TlFsHorario other = (TlFsHorario) object;
        return !((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario)));
    }

    @Override
    public String toString() {
        return "com.proyectofinal.freestyle.model.TlFsHorario[ idHorario=" + idHorario + " ]";
    }
    
}
