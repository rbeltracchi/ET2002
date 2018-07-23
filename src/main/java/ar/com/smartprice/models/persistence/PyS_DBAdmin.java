/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.persistence;

import ar.com.smartprice.models.entities.DBConnection;
import ar.com.smartprice.models.entities.Oferente;
import ar.com.smartprice.models.entities.PrecioRegular;
import ar.com.smartprice.models.entities.ProductoYServicio;
import java.util.List;
import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;

/**
 *
 * @author Agustin
 */
public class PyS_DBAdmin {

    private static  DBConnection DB = new DBConnection();

    public PyS_DBAdmin() {
    }

    
    public ProductoYServicio getProductoById(int id) {
        EntityManager em=DB.getEm();
        em.getTransaction().begin();
        TypedQuery<ProductoYServicio> q;
        q = em.createNamedQuery("ProductoYServicio.findByIdproductosYServicios", ProductoYServicio.class);
        q.setParameter("idproductosYServicios", id);
        List<ProductoYServicio> resultados = q.getResultList();
        em.getTransaction().commit();
        if (resultados.isEmpty()) {
            return null;
        }
        return resultados.get(0);

    }

    //Inserta un nuevo producto al catalogo
    public boolean insertarProducto(ProductoYServicio pys) {
        boolean exito = false;
        EntityManager em=DB.getEm();
        em.getTransaction().begin();
        TypedQuery<ProductoYServicio> q = em.createNamedQuery("ProductoYServicio.findByNombreYMarca", ProductoYServicio.class);
        q.setParameter("nombre", pys.getNombre());
        q.setParameter("idMarca", pys.getMarca());
        List<ProductoYServicio> pCargados = q.getResultList();
        if (pCargados.isEmpty()) {
            em.persist(pys);
            exito = true;
        }
        em.getTransaction().commit();
        return exito;
    }

    public boolean acualizarProducto(ProductoYServicio pys) {

        boolean exito = false;
        EntityManager em=DB.getEm();
        em.getTransaction().begin();

        if (this.getProductoById(pys.getIdproductosYServicios()) == null) {
            exito = false;
        } else {
            em.merge(pys);

            exito = true;
        }
        em.getTransaction().commit();
        return exito;
    }

    public boolean borrarProducto(ProductoYServicio pys) {
        boolean exito = false;
        EntityManager em=DB.getEm();
        em.getTransaction().begin();

        if (this.getProductoById(pys.getIdproductosYServicios()) == null) {
            exito = false;
        } else {
            em.remove(pys);

            exito = true;
        }
        em.getTransaction().commit();
        return exito;

    }


    


    public int cantPyS() {
        EntityManager em=DB.getEm();

        em.getTransaction().begin();
        int cant = em.createNamedQuery("ProductoYServicio.countAll", Integer.class).getSingleResult();
        em.getTransaction().commit();
        return cant;
    }
    
}
