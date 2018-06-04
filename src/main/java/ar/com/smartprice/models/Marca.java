/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Agustin
 */
@Entity
@Table(name = "marca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m")
    , @NamedQuery(name = "Marca.findByIdmarcas", query = "SELECT m FROM Marca m WHERE m.idMarca = :idMarca")
    , @NamedQuery(name = "Marca.findByNombre", query = "SELECT m FROM Marca m WHERE m.nombre = :nombre")})
public class Marca implements Serializable {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("SmartPricePU");
        EntityManager em=null;
    @Lob
    @Column(name = "logotipo")
    private byte[] logotipo;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMarca")
    private Integer idMarca;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idMarca")
    private Collection<ProductoYServicio> productoYServicioCollection;

    public Marca() {
    }

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdmarca() {
        return idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @XmlTransient
    public Collection<ProductoYServicio> getProductoYServicioCollection() {
        return productoYServicioCollection;
    }

    public void setProductoYServicioCollection(Collection<ProductoYServicio> productoYServicioCollection) {
        this.productoYServicioCollection = productoYServicioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarca != null ? idMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.idMarca == null && other.idMarca != null) || (this.idMarca != null && !this.idMarca.equals(other.idMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Marca[ idMarca=" + idMarca + " ]";
    }

    public byte[] getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(byte[] logotipo) {
        this.logotipo = logotipo;
    }
    private boolean existMarca(String nombre){
        if (em==null){
            em = emf.createEntityManager();
        }
        em.getTransaction().begin();
        TypedQuery<Marca> q;
        q = em.createNamedQuery("Marca.findByNombre", Marca.class);
        q.setParameter("nombre", nombre);
        List<Marca> marcas  = q.getResultList();
        em.getTransaction().commit();
        if (marcas.isEmpty())
            return false;
        
        return true;
    }
    
    public void insertMarca(Marca mrc){
       
      if (!existMarca(mrc.getNombre())) {
          if (em==null)
            em = emf.createEntityManager();
           em.getTransaction().begin();
           em.persist(mrc);
           em.getTransaction().commit();
      }
      
      
    }
}
