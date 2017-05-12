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
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findById", query = "SELECT c FROM Curso c WHERE c.id = :id"),
    @NamedQuery(name = "Curso.findByFechainicio", query = "SELECT c FROM Curso c WHERE c.fechainicio = :fechainicio"),
    @NamedQuery(name = "Curso.findByFechafin", query = "SELECT c FROM Curso c WHERE c.fechafin = :fechafin"),
    @NamedQuery(name = "Curso.findByNummeses", query = "SELECT c FROM Curso c WHERE c.nummeses = :nummeses"),
    @NamedQuery(name = "Curso.findByValormatricularef", query = "SELECT c FROM Curso c WHERE c.valormatricularef = :valormatricularef"),
    @NamedQuery(name = "Curso.findByValormensualidadref", query = "SELECT c FROM Curso c WHERE c.valormensualidadref = :valormensualidadref"),
    @NamedQuery(name = "Curso.findByEstado", query = "SELECT c FROM Curso c WHERE c.estado = :estado")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nummeses")
    private BigDecimal nummeses;
    @Column(name = "valormatricularef")
    private BigDecimal valormatricularef;
    @Column(name = "valormensualidadref")
    private BigDecimal valormensualidadref;
    @Column(name = "estado")
    private Character estado;
    @JoinColumn(name = "idtipocurso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipocurso idtipocurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
    private Collection<Matricula> matriculaCollection;

    public Curso() {
    }

    public Curso(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public BigDecimal getNummeses() {
        return nummeses;
    }

    public void setNummeses(BigDecimal nummeses) {
        this.nummeses = nummeses;
    }

    public BigDecimal getValormatricularef() {
        return valormatricularef;
    }

    public void setValormatricularef(BigDecimal valormatricularef) {
        this.valormatricularef = valormatricularef;
    }

    public BigDecimal getValormensualidadref() {
        return valormensualidadref;
    }

    public void setValormensualidadref(BigDecimal valormensualidadref) {
        this.valormensualidadref = valormensualidadref;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Tipocurso getIdtipocurso() {
        return idtipocurso;
    }

    public void setIdtipocurso(Tipocurso idtipocurso) {
        this.idtipocurso = idtipocurso;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
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
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacasadelballetws.entities.Curso[ id=" + id + " ]";
    }
    
}
