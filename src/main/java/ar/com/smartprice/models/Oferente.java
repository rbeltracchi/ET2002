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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Agustin
 */
@Entity
@Table(name = "oferente")
@PrimaryKeyJoinColumn(name="id_usuario_oferente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferente.findAll", query = "SELECT o FROM Oferente o")
    , @NamedQuery(name = "Oferente.countAll", query = "SELECT COUNT(o) FROM Oferente o")    
    , @NamedQuery(name = "Oferente.findByCuit", query = "SELECT o FROM Oferente o WHERE o.cuit = :cuit")
    , @NamedQuery(name = "Oferente.findByRazonSocial", query = "SELECT o FROM Oferente o WHERE o.razonSocial = :razonSocial")
    , @NamedQuery(name = "Oferente.findByDireccion", query = "SELECT o FROM Oferente o WHERE o.direccion = :direccion")
    , @NamedQuery(name = "Oferente.findByTelefono", query = "SELECT o FROM Oferente o WHERE o.telefono = :telefono")})

public class Oferente extends Usuario implements Serializable {
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oferente")
    private Collection<PrecioRegular> precioRegularCollection;
    private static final long serialVersionUID = 1L;
    
    @Column(name = "cuit")
    private int cuit;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private Integer telefono;
    

    public Oferente() {
    }


    public Oferente(String email, String password, String nombre, int cuit, String razon_social, String direccion, Integer telefono) {
        super(email,password,nombre);
        this.cuit = cuit;
        this.tipo="Oferente";
        this.razonSocial=razon_social;
        this.telefono=telefono;
        this.direccion=direccion;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<PrecioRegular> getPrecioRegularCollection() {
        return precioRegularCollection;
    }
    
    public boolean esActivo(){
        return activo;
    }
}

