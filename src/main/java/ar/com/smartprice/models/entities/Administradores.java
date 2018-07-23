/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "administradores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administradores.findAll", query = "SELECT a FROM Administradores a")
    , @NamedQuery(name = "Administradores.countAll", query = "SELECT COUNT(a) FROM Administradores a")
    , @NamedQuery(name = "Administradores.findByIdadministradores", query = "SELECT a FROM Administradores a WHERE a.idadministradores = :idadministradores")
    , @NamedQuery(name = "Administradores.findByActivo", query = "SELECT a FROM Administradores a WHERE a.activo = :activo")
    , @NamedQuery(name = "Administradores.findByNombre", query = "SELECT a FROM Administradores a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Administradores.findByEmail", query = "SELECT a FROM Administradores a WHERE a.email = :email")})
public class Administradores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadministradores")
    private Integer idadministradores;
    @Basic(optional = true)
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "password")
    private String password;

    public Administradores() {
    }

    public Administradores(Integer idadministradores) {
        this.idadministradores = idadministradores;
    }

    public Administradores(Integer idadministradores, boolean activo, String nombre, String email, String password) {
        this.idadministradores = idadministradores;
        this.activo = activo;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public Integer getIdadministradores() {
        return idadministradores;
    }

    public void setIdadministradores(Integer idadministradores) {
        this.idadministradores = idadministradores;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadministradores != null ? idadministradores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administradores)) {
            return false;
        }
        Administradores other = (Administradores) object;
        if ((this.idadministradores == null && other.idadministradores != null) || (this.idadministradores != null && !this.idadministradores.equals(other.idadministradores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.smartprice.models.entities.Administradores[ idadministradores=" + idadministradores + " ]";
    }

}
