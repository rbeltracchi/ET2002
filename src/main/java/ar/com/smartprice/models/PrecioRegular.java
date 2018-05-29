/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Agustin
 */
@Entity
@Table(name = "precio_regular")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrecioRegular.findAll", query = "SELECT p FROM PrecioRegular p")
    , @NamedQuery(name = "PrecioRegular.findByIdoferente", query = "SELECT p FROM PrecioRegular p WHERE p.precioRegularPK.idOferente = :idoferente")
    , @NamedQuery(name = "PrecioRegular.findByIdproducto", query = "SELECT p FROM PrecioRegular p WHERE p.precioRegularPK.idProducto = :idproducto ORDER BY p.precioRegular ASC")
    , @NamedQuery(name = "PrecioRegular.mejoresByNombre", query = "SELECT p FROM PrecioRegular p JOIN ProductoYServicio pys on p.precioRegularPK.idProducto = pys.idproductosYServicios WHERE pys.nombre = :nombre ORDER BY p.precioRegular ASC ")
    , @NamedQuery(name = "PrecioRegular.findByKey", query = "SELECT p FROM PrecioRegular p WHERE p.precioRegularPK.idProducto = :idproducto and p.precioRegularPK.idOferente = :idoferente")
    , @NamedQuery(name = "PrecioRegular.findByPrecioRegular", query = "SELECT p FROM PrecioRegular p WHERE p.precioRegular = :precioRegular")})
public class PrecioRegular implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrecioRegularPK precioRegularPK;
    @Basic(optional = false)
    @Column(name = "precio_regular")
    private float precioRegular;
    @JoinColumn(name = "id_producto", referencedColumnName = "idproductos_y_servicios", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductoYServicio productoYServicio;
    @JoinColumn(name = "id_oferente", referencedColumnName = "id_usuario_oferente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oferente oferente;

    public PrecioRegular(){}
    
    public PrecioRegular(int idoferente, int idproducto, float precio) {
        this.precioRegularPK = new PrecioRegularPK(idoferente, idproducto);
        this.precioRegular =precio;
    }

    public PrecioRegularPK getPrecioRegularPK() {
        return precioRegularPK;
    }

    public void setPrecioRegularPK(PrecioRegularPK precioRegularPK) {
        this.precioRegularPK = precioRegularPK;
    }

    public float getPrecioRegular() {
        return precioRegular;
    }

    public void setPrecioRegular(float precioRegular) {
        this.precioRegular = precioRegular;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (precioRegularPK != null ? precioRegularPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecioRegular)) {
            return false;
        }
        PrecioRegular other = (PrecioRegular) object;
        if ((this.precioRegularPK == null && other.precioRegularPK != null) || (this.precioRegularPK != null && !this.precioRegularPK.equals(other.precioRegularPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.PrecioRegular[ precioRegularPK=" + precioRegularPK + " ]";
    }
    
}
