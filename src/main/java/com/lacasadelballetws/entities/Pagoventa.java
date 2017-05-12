/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacasadelballetws.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Seeting
 */
@Entity
@Table(name = "pagoventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagoventa.findAll", query = "SELECT p FROM Pagoventa p"),
    @NamedQuery(name = "Pagoventa.findById", query = "SELECT p FROM Pagoventa p WHERE p.id = :id"),
    @NamedQuery(name = "Pagoventa.findByValor", query = "SELECT p FROM Pagoventa p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pagoventa.findByFecha", query = "SELECT p FROM Pagoventa p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Pagoventa.findByNumrecibo", query = "SELECT p FROM Pagoventa p WHERE p.numrecibo = :numrecibo"),
    @NamedQuery(name = "Pagoventa.findByEstado", query = "SELECT p FROM Pagoventa p WHERE p.estado = :estado")})
public class Pagoventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "numrecibo")
    private Integer numrecibo;
    @Column(name = "estado")
    private Character estado;
    @JoinColumn(name = "idventa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Venta idventa;

    public Pagoventa() {
    }

    public Pagoventa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNumrecibo() {
        return numrecibo;
    }

    public void setNumrecibo(Integer numrecibo) {
        this.numrecibo = numrecibo;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Venta getIdventa() {
        return idventa;
    }

    public void setIdventa(Venta idventa) {
        this.idventa = idventa;
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
        if (!(object instanceof Pagoventa)) {
            return false;
        }
        Pagoventa other = (Pagoventa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lacasadelballetws.entities.Pagoventa[ id=" + id + " ]";
    }
    
}
