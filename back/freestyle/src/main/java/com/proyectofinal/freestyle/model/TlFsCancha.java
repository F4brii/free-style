package com.proyectofinal.freestyle.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tl_fs_cancha", catalog = "FreeStyle", schema = "public")
@jakarta.xml.bind.annotation.XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlFsCancha.findAll", query = "SELECT t FROM TlFsCancha t"),
    @NamedQuery(name = "TlFsCancha.findByIdCancha", query = "SELECT t FROM TlFsCancha t WHERE t.idCancha = :idCancha"),
    @NamedQuery(name = "TlFsCancha.findByNombreCancha", query = "SELECT t FROM TlFsCancha t WHERE t.nombreCancha = :nombreCancha"),
    @NamedQuery(name = "TlFsCancha.findByUbicacionCancha", query = "SELECT t FROM TlFsCancha t WHERE t.ubicacionCancha = :ubicacionCancha"),
    @NamedQuery(name = "TlFsCancha.findByDescCancha", query = "SELECT t FROM TlFsCancha t WHERE t.descCancha = :descCancha"),
    @NamedQuery(name = "TlFsCancha.findByFechaCreacion", query = "SELECT t FROM TlFsCancha t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TlFsCancha.findByFechaActualizacion", query = "SELECT t FROM TlFsCancha t WHERE t.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "TlFsCancha.findBySnActivo", query = "SELECT t FROM TlFsCancha t WHERE t.snActivo = :snActivo")})
public class TlFsCancha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cancha", nullable = false)
    private Integer idCancha;
    @Column(name = "nombre_cancha")
    private Integer nombreCancha;
    @jakarta.validation.constraints.Size(max = 255)
    @Column(name = "ubicacion_cancha", length = 255)
    private String ubicacionCancha;
    @jakarta.validation.constraints.Size(max = 255)
    @Column(name = "desc_cancha", length = 255)
    private String descCancha;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Column(name = "sn_activo")
    private Boolean snActivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCancha")
    private List<TlFsHorario> tlFsHorarioList;

    public TlFsCancha() {
    }

    public TlFsCancha(Integer idCancha) {
        this.idCancha = idCancha;
    }

    public Integer getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(Integer idCancha) {
        this.idCancha = idCancha;
    }

    public Integer getNombreCancha() {
        return nombreCancha;
    }

    public void setNombreCancha(Integer nombreCancha) {
        this.nombreCancha = nombreCancha;
    }

    public String getUbicacionCancha() {
        return ubicacionCancha;
    }

    public void setUbicacionCancha(String ubicacionCancha) {
        this.ubicacionCancha = ubicacionCancha;
    }

    public String getDescCancha() {
        return descCancha;
    }

    public void setDescCancha(String descCancha) {
        this.descCancha = descCancha;
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

    public Boolean getSnActivo() {
        return snActivo;
    }

    public void setSnActivo(Boolean snActivo) {
        this.snActivo = snActivo;
    }

    @jakarta.xml.bind.annotation.XmlTransient
    public List<TlFsHorario> getTlFsHorarioList() {
        return tlFsHorarioList;
    }

    public void setTlFsHorarioList(List<TlFsHorario> tlFsHorarioList) {
        this.tlFsHorarioList = tlFsHorarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCancha != null ? idCancha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TlFsCancha)) {
            return false;
        }
        TlFsCancha other = (TlFsCancha) object;
        return !((this.idCancha == null && other.idCancha != null) || (this.idCancha != null && !this.idCancha.equals(other.idCancha)));
    }

    @Override
    public String toString() {
        return "com.proyectofinal.freestyle.model.TlFsCancha[ idCancha=" + idCancha + " ]";
    }
    
}
