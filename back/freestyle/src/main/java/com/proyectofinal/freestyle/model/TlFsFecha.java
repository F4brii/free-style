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
@Table(name = "tl_fs_fecha", catalog = "FreeStyle", schema = "public")
@jakarta.xml.bind.annotation.XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlFsFecha.findAll", query = "SELECT t FROM TlFsFecha t"),
    @NamedQuery(name = "TlFsFecha.findByIdFecha", query = "SELECT t FROM TlFsFecha t WHERE t.idFecha = :idFecha"),
    @NamedQuery(name = "TlFsFecha.findByFecha", query = "SELECT t FROM TlFsFecha t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TlFsFecha.findByDiaSemana", query = "SELECT t FROM TlFsFecha t WHERE t.diaSemana = :diaSemana")})
public class TlFsFecha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fecha", nullable = false)
    private Integer idFecha;
    @Basic(optional = false)
    @jakarta.validation.constraints.NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @jakarta.validation.constraints.NotNull
    @Column(name = "dia_semana", nullable = false)
    private int diaSemana;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFecha")
    private List<TlFsHorario> tlFsHorarioList;
    @JoinColumn(name = "id_tarifa", referencedColumnName = "id_tarifa", nullable = false)
    @ManyToOne(optional = false)
    private TlFsTarifa idTarifa;

    public TlFsFecha() {
    }

    public TlFsFecha(Integer idFecha) {
        this.idFecha = idFecha;
    }

    public TlFsFecha(Integer idFecha, Date fecha, int diaSemana) {
        this.idFecha = idFecha;
        this.fecha = fecha;
        this.diaSemana = diaSemana;
    }

    public Integer getIdFecha() {
        return idFecha;
    }

    public void setIdFecha(Integer idFecha) {
        this.idFecha = idFecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    @jakarta.xml.bind.annotation.XmlTransient
    public List<TlFsHorario> getTlFsHorarioList() {
        return tlFsHorarioList;
    }

    public void setTlFsHorarioList(List<TlFsHorario> tlFsHorarioList) {
        this.tlFsHorarioList = tlFsHorarioList;
    }

    public TlFsTarifa getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(TlFsTarifa idTarifa) {
        this.idTarifa = idTarifa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFecha != null ? idFecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TlFsFecha)) {
            return false;
        }
        TlFsFecha other = (TlFsFecha) object;
        return !((this.idFecha == null && other.idFecha != null) || (this.idFecha != null && !this.idFecha.equals(other.idFecha)));
    }

    @Override
    public String toString() {
        return "com.proyectofinal.freestyle.model.TlFsFecha[ idFecha=" + idFecha + " ]";
    }
    
}
