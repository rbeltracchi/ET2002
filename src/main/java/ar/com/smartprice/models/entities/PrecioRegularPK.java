/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Agustin
 */
@Embeddable
public class PrecioRegularPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_oferente")
    private int idOferente;
    @Basic(optional = false)
    @Column(name = "id_producto")
    private int idProducto;

    public PrecioRegularPK() {
    }

    public PrecioRegularPK(int idOferente, int idProducto) {
        this.idOferente = idOferente;
        this.idProducto = idProducto;
    }

    public int getIdOferente() {
        return idOferente;
    }

    public void setIdoferente(int idOferente) {
        this.idOferente = idOferente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdproducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOferente;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecioRegularPK)) {
            return false;
        }
        PrecioRegularPK other = (PrecioRegularPK) object;
        if (this.idOferente != other.idOferente) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.PrecioRegularPK[ idOferente=" + idOferente + ", idProducto=" + idProducto + " ]";
    }
    
}
