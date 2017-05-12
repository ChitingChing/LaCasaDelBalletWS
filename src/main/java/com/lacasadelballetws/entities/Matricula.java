/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacasadelballetws.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Seeting
 */
@Entity
@Table(name = "matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findById", query = "SELECT m FROM Matricula m WHERE m.id = :id"),
    @NamedQuery(name = "Matricula.findByFecha", query = "SELECT m FROM Matricula m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "Matricula.findByValormatricula", query = "SELECT m FROM Matricula m WHERE m.valormatricula = :valormatricula"),
    @NamedQuery(name = "Matricula.findByValormensualidad", query = "SELECT m FROM Matricula m WHERE m.valormensualidad = :valormensualidad"),
    @NamedQuery(name = "Matricula.findByNummeses", query = "SELECT m FROM Matricula m WHERE m.nummeses = :nummeses"),
    @NamedQuery(name = "Matricula.findByEstado", query = "SELECT m FROM Matricula m WHERE m.estado = :estado")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valormatricula")
    private BigDecimal valormatricula;
    @Column(name = "valormensualidad")
    private BigDecimal valormensualidad;
    @Column(name = "nummeses")
    private BigDecimal nummeses;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmatricula")
    private Collection<Venta> ventaCollection;
    @JoinColumn(name = "idalumno", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Alumno idalumno;
    @JoinColumn(name = "idcategoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria idcategoria;
    @JoinColumn(name = "idcurso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Curso idcurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmatricula")
    private Collection<Pago> pagoCollection;

    public Matricula() {
    }

    public Matricula(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getValormatricula() {
        return valormatricula;
    }

    public void setValormatricula(BigDecimal valormatricula) {
        this.valormatricula = valormatricula;
    }

    public BigDecimal getValormensualidad() {
        return valormensualidad;
    }

    public void setValormensualidad(BigDecimal valormensualidad) {
        this.valormensualidad = valormensualidad;
    }

    public BigDecimal getNummeses() {
        return nummeses;
    }

    public void setNummeses(BigDecimal nummeses) {
        this.nummeses = nummeses;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Curso getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Curso idcurso) {
        this.idcurso = idcurso;
    }

    @XmlTransient
    public Collection<Pago> getPagoCollection() {
        return pagoCollection;
    }

    public void setPagoCollection(Collection<Pago> pagoCollection) {
        this.pagoCollection = pagoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacasadelballetws.entities.Matricula[ id=" + id + " ]";
    }
    
}
