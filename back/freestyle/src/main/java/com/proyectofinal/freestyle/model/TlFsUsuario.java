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
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tl_fs_usuario", catalog = "FreeStyle", schema = "public")
@jakarta.xml.bind.annotation.XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlFsUsuario.findAll", query = "SELECT t FROM TlFsUsuario t"),
    @NamedQuery(name = "TlFsUsuario.findByIdUsuario", query = "SELECT t FROM TlFsUsuario t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TlFsUsuario.findByNumdocUsuario", query = "SELECT t FROM TlFsUsuario t WHERE t.numdocUsuario = :numdocUsuario"),
    @NamedQuery(name = "TlFsUsuario.findByNombreUsuario", query = "SELECT t FROM TlFsUsuario t WHERE t.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "TlFsUsuario.findByEmailUsuario", query = "SELECT t FROM TlFsUsuario t WHERE t.emailUsuario = :emailUsuario"),
    @NamedQuery(name = "TlFsUsuario.findByTelefonoUsuario", query = "SELECT t FROM TlFsUsuario t WHERE t.telefonoUsuario = :telefonoUsuario"),
    @NamedQuery(name = "TlFsUsuario.findByPassHash", query = "SELECT t FROM TlFsUsuario t WHERE t.passHash = :passHash"),
    @NamedQuery(name = "TlFsUsuario.findByFechaCreacion", query = "SELECT t FROM TlFsUsuario t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TlFsUsuario.findByFechaActualizacion", query = "SELECT t FROM TlFsUsuario t WHERE t.fechaActualizacion = :fechaActualizacion")})
public class TlFsUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @Basic(optional = false)
    @jakarta.validation.constraints.NotNull
    @Column(name = "numdoc_usuario", nullable = false)
    private int numdocUsuario;
    @jakarta.validation.constraints.Size(max = 255)
    @Column(name = "nombre_usuario", length = 255)
    private String nombreUsuario;
    @jakarta.validation.constraints.Size(max = 255)
    @Column(name = "email_usuario", length = 255)
    private String emailUsuario;
    @jakarta.validation.constraints.Size(max = 11)
    @Column(name = "telefono_usuario", length = 11)
    private String telefonoUsuario;
    @jakarta.validation.constraints.Size(max = 256)
    @Column(name = "pass_hash", length = 256)
    private String passHash;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @JoinColumn(name = "id_tipodoc", referencedColumnName = "id_tipodoc", nullable = false)
    @ManyToOne(optional = false)
    private TlFsTipodoc idTipodoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<TlFsReserva> tlFsReservaList;

    public TlFsUsuario() {
    }

    public TlFsUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TlFsUsuario(Integer idUsuario, int numdocUsuario) {
        this.idUsuario = idUsuario;
        this.numdocUsuario = numdocUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getNumdocUsuario() {
        return numdocUsuario;
    }

    public void setNumdocUsuario(int numdocUsuario) {
        this.numdocUsuario = numdocUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
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

    public TlFsTipodoc getIdTipodoc() {
        return idTipodoc;
    }

    public void setIdTipodoc(TlFsTipodoc idTipodoc) {
        this.idTipodoc = idTipodoc;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TlFsUsuario)) {
            return false;
        }
        TlFsUsuario other = (TlFsUsuario) object;
        return !((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario)));
    }

    @Override
    public String toString() {
        return "com.proyectofinal.freestyle.model.TlFsUsuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
