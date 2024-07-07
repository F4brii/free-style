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
@Table(name = "tl_fs_tipodoc", catalog = "FreeStyle", schema = "public")
@jakarta.xml.bind.annotation.XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlFsTipodoc.findAll", query = "SELECT t FROM TlFsTipodoc t"),
    @NamedQuery(name = "TlFsTipodoc.findByIdTipodoc", query = "SELECT t FROM TlFsTipodoc t WHERE t.idTipodoc = :idTipodoc"),
    @NamedQuery(name = "TlFsTipodoc.findByDescTipodoc", query = "SELECT t FROM TlFsTipodoc t WHERE t.descTipodoc = :descTipodoc"),
    @NamedQuery(name = "TlFsTipodoc.findBySnActivo", query = "SELECT t FROM TlFsTipodoc t WHERE t.snActivo = :snActivo")})
public class TlFsTipodoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipodoc", nullable = false)
    private Integer idTipodoc;
    @jakarta.validation.constraints.Size(max = 255)
    @Column(name = "desc_tipodoc", length = 255)
    private String descTipodoc;
    @Column(name = "sn_activo")
    private Boolean snActivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipodoc")
    private List<TlFsUsuario> tlFsUsuarioList;

    public TlFsTipodoc() {
    }

    public TlFsTipodoc(Integer idTipodoc) {
        this.idTipodoc = idTipodoc;
    }

    public Integer getIdTipodoc() {
        return idTipodoc;
    }

    public void setIdTipodoc(Integer idTipodoc) {
        this.idTipodoc = idTipodoc;
    }

    public String getDescTipodoc() {
        return descTipodoc;
    }

    public void setDescTipodoc(String descTipodoc) {
        this.descTipodoc = descTipodoc;
    }

    public Boolean getSnActivo() {
        return snActivo;
    }

    public void setSnActivo(Boolean snActivo) {
        this.snActivo = snActivo;
    }

    @jakarta.xml.bind.annotation.XmlTransient
    public List<TlFsUsuario> getTlFsUsuarioList() {
        return tlFsUsuarioList;
    }

    public void setTlFsUsuarioList(List<TlFsUsuario> tlFsUsuarioList) {
        this.tlFsUsuarioList = tlFsUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipodoc != null ? idTipodoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TlFsTipodoc)) {
            return false;
        }
        TlFsTipodoc other = (TlFsTipodoc) object;
        return !((this.idTipodoc == null && other.idTipodoc != null) || (this.idTipodoc != null && !this.idTipodoc.equals(other.idTipodoc)));
    }

    @Override
    public String toString() {
        return "com.proyectofinal.freestyle.model.TlFsTipodoc[ idTipodoc=" + idTipodoc + " ]";
    }
    
}
