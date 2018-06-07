/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Agustin
 */
@Entity
@Table(name = "producto_y_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoYServicio.findAll", query = "SELECT p FROM ProductoYServicio p")
    , @NamedQuery(name = "ProductoYServicio.countAll", query = "SELECT COUNT(p) FROM ProductoYServicio p")    
    , @NamedQuery(name = "ProductoYServicio.findByIdproductosYServicios", query = "SELECT p FROM ProductoYServicio p WHERE p.idproductosYServicios = :idproductosYServicios")
    , @NamedQuery(name = "ProductoYServicio.findByNombre", query = "SELECT p FROM ProductoYServicio p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "ProductoYServicio.findByNombreYMarca", query = "SELECT p FROM ProductoYServicio p WHERE p.nombre = :nombre and p.idMarca = :idMarca")
    , @NamedQuery(name = "ProductoYServicio.findByDescripcion", query = "SELECT p FROM ProductoYServicio p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "ProductoYServicio.findByCategoria", query = "SELECT p FROM ProductoYServicio p WHERE p.idCategoria = :idCategoria")})
public class ProductoYServicio implements Serializable {

    @Lob
    @Column(name = "foto")
    private byte[] foto;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproductos_y_servicios")
    private Integer idproductosYServicios;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoYServicio")
    private Collection<PrecioRegular> precioRegularCollection;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne
    private Categoria idCategoria;
    @JoinColumn(name = "idMarca", referencedColumnName = "idMarca")
    @ManyToOne
    private Marca idMarca;

    public ProductoYServicio() {
    }

    public ProductoYServicio(String nombre, Marca idMarca, Categoria idCategoria, String descripcion) {
        this.nombre = nombre;
        this.idMarca=idMarca;
        this.idCategoria=idCategoria;
        this.descripcion=descripcion;
    }

    public Integer getIdproductosYServicios() {
        return idproductosYServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @XmlTransient
    public Collection<PrecioRegular> getPrecioRegularCollection() {
        return precioRegularCollection;
    }

    public void setPrecioRegularCollection(Collection<PrecioRegular> precioRegularCollection) {
        this.precioRegularCollection = precioRegularCollection;
    }

    public Categoria getIdCcategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idcategoria) {
        this.idCategoria = idcategoria;
    }

    public Marca getIdmarca() {
        return idMarca;
    }

    public void setIdmarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproductosYServicios != null ? idproductosYServicios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoYServicio)) {
            return false;
        }
        ProductoYServicio other = (ProductoYServicio) object;
        if ((this.idproductosYServicios == null && other.idproductosYServicios != null) || (this.idproductosYServicios != null && !this.idproductosYServicios.equals(other.idproductosYServicios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ProductoYServicio[ idproductosYServicios=" + idproductosYServicios + " ]";
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
