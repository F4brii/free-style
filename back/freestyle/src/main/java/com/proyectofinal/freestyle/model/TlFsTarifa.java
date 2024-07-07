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
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tl_fs_tarifa", catalog = "FreeStyle", schema = "public")
@jakarta.xml.bind.annotation.XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlFsTarifa.findAll", query = "SELECT t FROM TlFsTarifa t"),
    @NamedQuery(name = "TlFsTarifa.findByIdTarifa", query = "SELECT t FROM TlFsTarifa t WHERE t.idTarifa = :idTarifa"),
    @NamedQuery(name = "TlFsTarifa.findByValorTarifa", query = "SELECT t FROM TlFsTarifa t WHERE t.valorTarifa = :valorTarifa"),
    @NamedQuery(name = "TlFsTarifa.findBySnBajoTrafico", query = "SELECT t FROM TlFsTarifa t WHERE t.snBajoTrafico = :snBajoTrafico"),
    @NamedQuery(name = "TlFsTarifa.findBySnWeekend", query = "SELECT t FROM TlFsTarifa t WHERE t.snWeekend = :snWeekend"),
    @NamedQuery(name = "TlFsTarifa.findBySnFestivo", query = "SELECT t FROM TlFsTarifa t WHERE t.snFestivo = :snFestivo"),
    @NamedQuery(name = "TlFsTarifa.findBySnDiurno", query = "SELECT t FROM TlFsTarifa t WHERE t.snDiurno = :snDiurno"),
    @NamedQuery(name = "TlFsTarifa.findBySnNocturno", query = "SELECT t FROM TlFsTarifa t WHERE t.snNocturno = :snNocturno"),
    @NamedQuery(name = "TlFsTarifa.findBySnActivo", query = "SELECT t FROM TlFsTarifa t WHERE t.snActivo = :snActivo")})
public class TlFsTarifa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarifa", nullable = false)
    private Integer idTarifa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_tarifa", precision = 18, scale = 2)
    private BigDecimal valorTarifa;
    @Column(name = "sn_bajo_trafico")
    private Boolean snBajoTrafico;
    @Column(name = "sn_weekend")
    private Boolean snWeekend;
    @Column(name = "sn_festivo")
    private Boolean snFestivo;
    @Column(name = "sn_diurno")
    private Boolean snDiurno;
    @Column(name = "sn_nocturno")
    private Boolean snNocturno;
    @Column(name = "sn_activo")
    private Boolean snActivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTarifa")
    private List<TlFsFecha> tlFsFechaList;

    public TlFsTarifa() {
    }

    public TlFsTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    public Integer getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    public BigDecimal getValorTarifa() {
        return valorTarifa;
    }

    public void setValorTarifa(BigDecimal valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

    public Boolean getSnBajoTrafico() {
        return snBajoTrafico;
    }

    public void setSnBajoTrafico(Boolean snBajoTrafico) {
        this.snBajoTrafico = snBajoTrafico;
    }

    public Boolean getSnWeekend() {
        return snWeekend;
    }

    public void setSnWeekend(Boolean snWeekend) {
        this.snWeekend = snWeekend;
    }

    public Boolean getSnFestivo() {
        return snFestivo;
    }

    public void setSnFestivo(Boolean snFestivo) {
        this.snFestivo = snFestivo;
    }

    public Boolean getSnDiurno() {
        return snDiurno;
    }

    public void setSnDiurno(Boolean snDiurno) {
        this.snDiurno = snDiurno;
    }

    public Boolean getSnNocturno() {
        return snNocturno;
    }

    public void setSnNocturno(Boolean snNocturno) {
        this.snNocturno = snNocturno;
    }

    public Boolean getSnActivo() {
        return snActivo;
    }

    public void setSnActivo(Boolean snActivo) {
        this.snActivo = snActivo;
    }

    @jakarta.xml.bind.annotation.XmlTransient
    public List<TlFsFecha> getTlFsFechaList() {
        return tlFsFechaList;
    }

    public void setTlFsFechaList(List<TlFsFecha> tlFsFechaList) {
        this.tlFsFechaList = tlFsFechaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarifa != null ? idTarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TlFsTarifa)) {
            return false;
        }
        TlFsTarifa other = (TlFsTarifa) object;
        return !((this.idTarifa == null && other.idTarifa != null) || (this.idTarifa != null && !this.idTarifa.equals(other.idTarifa)));
    }

    @Override
    public String toString() {
        return "com.proyectofinal.freestyle.model.TlFsTarifa[ idTarifa=" + idTarifa + " ]";
    }
    
}
