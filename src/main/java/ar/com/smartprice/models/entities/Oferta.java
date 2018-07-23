/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
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
 * @author Usuario
 */
@Entity
@Table(name = "oferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o")
    , @NamedQuery(name = "Oferta.findByIdOferta", query = "SELECT o FROM Oferta o WHERE o.idOferta = :idOferta")
    , @NamedQuery(name = "Oferta.findByConstraint", query = "SELECT o FROM Oferta o WHERE o.oferente = :idoferente and o.productoYServicio = :idproducto and o.cantidadMinima = :cantMinima")
    , @NamedQuery(name = "Oferta.findByIdoferente", query = "SELECT o FROM Oferta o WHERE o.oferente = :idoferente")
    , @NamedQuery(name = "Oferta.findByIdproducto", query = "SELECT o FROM Oferta o WHERE o.productoYServicio = :idproducto")
    , @NamedQuery(name = "Oferta.findByUserAndProduct", query = "SELECT o FROM Oferta o WHERE o.productoYServicio = :idproducto and o.oferente = :idoferente")
    , @NamedQuery(name = "Oferta.findByFechaInicio", query = "SELECT o FROM Oferta o WHERE o.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Oferta.findByFechaFinalizacion", query = "SELECT o FROM Oferta o WHERE o.fechaFinalizacion = :fechaFinalizacion")
    , @NamedQuery(name = "Oferta.findByPrecio", query = "SELECT o FROM Oferta o WHERE o.precio = :precio")
    , @NamedQuery(name = "Oferta.findByCantidadMinima", query = "SELECT o FROM Oferta o WHERE o.cantidadMinima = :cantidadMinima")
    , @NamedQuery(name = "Oferta.findByDescripcion", query = "SELECT o FROM Oferta o WHERE o.descripcion = :descripcion")})
public class Oferta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_oferta")
    private Integer idOferta = null;
    @JoinColumn(name = "id_producto", referencedColumnName = "idproductos_y_servicios")
    @ManyToOne(optional = false)
    private ProductoYServicio productoYServicio = null;
    @JoinColumn(name = "id_oferente", referencedColumnName = "id_usuario_oferente")
    @ManyToOne(optional = false)
    private Oferente oferente = null;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_finalizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @Basic(optional = false)
    @Column(name = "precio")
    private float precio;
    @Column(name = "cantidad_minima")
    private Integer cantidadMinima;
    @Column(name = "descripcion")
    private String descripcion;

    public Oferta() {

    }

    public Oferta(ProductoYServicio productoYServicio, Oferente oferente, Date fechaInicio, Date fechaFinalizacion, float precio, Integer cantidadMinima, String descripcion) {
        this.productoYServicio = productoYServicio;
        this.oferente = oferente;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.precio = precio;
        this.cantidadMinima = cantidadMinima;
        this.descripcion = descripcion;
    }

    public ProductoYServicio getProductoYServicio() {
        return productoYServicio;
    }

    public void setProductoYServicio(ProductoYServicio productoYServicio) {
        this.productoYServicio = productoYServicio;
    }

    public Oferente getOferente() {
        return oferente;
    }

    public void setOferente(Oferente oferente) {
        this.oferente = oferente;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Integer getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(Integer cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOferta != null ? idOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.idOferta == null && other.idOferta != null) || (this.idOferta != null && !this.idOferta.equals(other.idOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.smartprice.models.Oferta[ idOferta=" + idOferta + " ]";
    }

    public void set(Oferta other) {
        //     this.productoYServicio = other.getProductoYServicio();
        //     this.oferente = other.getOferente();
        //     this.cantidadMinima = other.getCantidadMinima();
        //Las comento porque son las identificadoras, no deberiamos permitir modificarlas
        this.fechaInicio = other.getFechaInicio();
        this.fechaFinalizacion = other.getFechaFinalizacion();
        this.precio = other.getPrecio();
        this.descripcion = other.getDescripcion();
    }
}
