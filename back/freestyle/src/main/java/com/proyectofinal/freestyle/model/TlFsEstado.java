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
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tl_fs_estado", catalog = "FreeStyle", schema = "public")
@jakarta.xml.bind.annotation.XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlFsEstado.findAll", query = "SELECT t FROM TlFsEstado t"),
    @NamedQuery(name = "TlFsEstado.findByIdEstado", query = "SELECT t FROM TlFsEstado t WHERE t.idEstado = :idEstado"),
    @NamedQuery(name = "TlFsEstado.findByDiscriminador", query = "SELECT t FROM TlFsEstado t WHERE t.discriminador = :discriminador"),
    @NamedQuery(name = "TlFsEstado.findByDescEstado", query = "SELECT t FROM TlFsEstado t WHERE t.descEstado = :descEstado"),
    @NamedQuery(name = "TlFsEstado.findBySnActivo", query = "SELECT t FROM TlFsEstado t WHERE t.snActivo = :snActivo")})
public class TlFsEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado", nullable = false)
    private Integer idEstado;
    @jakarta.validation.constraints.Size(max = 255)
    @Column(length = 255)
    private String discriminador;
    @jakarta.validation.constraints.Size(max = 255)
    @Column(name = "desc_estado", length = 255)
    private String descEstado;
    @Column(name = "sn_activo")
    private Boolean snActivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<TlFsPago> tlFsPagoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<TlFsReserva> tlFsReservaList;

    public TlFsEstado() {
    }

    public TlFsEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getDiscriminador() {
        return discriminador;
    }

    public void setDiscriminador(String discriminador) {
        this.discriminador = discriminador;
    }

    public String getDescEstado() {
        return descEstado;
    }

    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }

    public Boolean getSnActivo() {
        return snActivo;
    }

    public void setSnActivo(Boolean snActivo) {
        this.snActivo = snActivo;
    }

    @jakarta.xml.bind.annotation.XmlTransient
    public List<TlFsPago> getTlFsPagoList() {
        return tlFsPagoList;
    }

    public void setTlFsPagoList(List<TlFsPago> tlFsPagoList) {
        this.tlFsPagoList = tlFsPagoList;
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
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TlFsEstado)) {
            return false;
        }
        TlFsEstado other = (TlFsEstado) object;
        return !((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado)));
    }

    @Override
    public String toString() {
        return "com.proyectofinal.freestyle.model.TlFsEstado[ idEstado=" + idEstado + " ]";
    }
    
}
