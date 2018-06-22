/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.services;

import ar.com.smartprice.models.Categoria;
import ar.com.smartprice.models.Marca;
import ar.com.smartprice.models.Oferente;
import ar.com.smartprice.models.PrecioRegular;
import ar.com.smartprice.models.ProductoYServicio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Agustin
 */
public class PyS_DBAdmin {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SmartPricePU");
    EntityManager em = null;

    public ProductoYServicio getProductoById(int id) {
        if (em == null) {
            em = emf.createEntityManager();
        }
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
        if (em == null) {
            em = emf.createEntityManager();
        }
        em.getTransaction().begin();
        TypedQuery<ProductoYServicio> q = em.createNamedQuery("ProductoYServicio.findByNombreYMarca", ProductoYServicio.class);
        q.setParameter("nombre", pys.getNombre());
        q.setParameter("idMarca", pys.getIdmarca());
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
        if (em == null) {
            em = emf.createEntityManager();
        }
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
        if (em == null) {
            em = emf.createEntityManager();
        }
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

    //Carga un precioRegular de un oferente o para un producto p. Si habia un precio cargado, lo actualiza
    public void publicarPrecioRegular(Oferente o, ProductoYServicio p, float precio) {
        PrecioRegular pRegular = new PrecioRegular(o.getIdUsuario(), p.getIdproductosYServicios(), precio);

        if (em == null) {
            em = emf.createEntityManager();
        }

        em.getTransaction().begin();

        TypedQuery<PrecioRegular> q = em.createNamedQuery("PrecioRegular.findByKey", PrecioRegular.class);
        q.setParameter("idproducto", p.getIdproductosYServicios());
        q.setParameter("idoferente", o.getIdUsuario());
        List<PrecioRegular> encontrados = q.getResultList();
        if (encontrados.isEmpty()) {
            em.persist(pRegular);
        } else {
            PrecioRegular yaCargado = encontrados.get(0);
            yaCargado.setPrecioRegular(precio);
            em.merge(yaCargado);
        }
        em.getTransaction().commit();
    }

    public int cantPyS() {
        if (em == null) {
            em = emf.createEntityManager();
        }

        em.getTransaction().begin();
        int cant = em.createNamedQuery("ProductoYServicio.countAll", Integer.class).getSingleResult();
        em.getTransaction().commit();
        return cant;
    }

}
