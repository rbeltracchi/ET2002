/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.services;

import ar.com.smartprice.models.Categoria;
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
public class Search_DBAdmin {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("SmartPricePU");
        EntityManager em=null;
        
                //trae los productos que satisfacen un nombre
    public List<ProductoYServicio> getProductosByNombre(String nombre){
        if (em==null) em = emf.createEntityManager();
        
        em.getTransaction().begin();
        TypedQuery<ProductoYServicio> q = em.createNamedQuery("ProductoYServicio.findByNombre", ProductoYServicio.class);
        q.setParameter("nombre", nombre);
        List<ProductoYServicio> productos = q.getResultList();
        em.getTransaction().commit();
        if (productos.isEmpty())
            return null;
        return productos;
    }
    
     //Trae precios para un producto dado
    public List<PrecioRegular> getPrecios(ProductoYServicio p, int max){
        if (em==null) em = emf.createEntityManager();
        
        em.getTransaction().begin();
        TypedQuery<PrecioRegular> q = em.createNamedQuery("PrecioRegular.findByIdproducto",PrecioRegular.class);
        q.setParameter("idproducto", p.getIdproductosYServicios());
        q.setMaxResults(max); 
        List<PrecioRegular> precios = q.getResultList();
        em.getTransaction().commit();
        if (precios.isEmpty())
            return null;
        return precios;
    }
    
    //Trae los productos que satisfacen una categoria
    public List<ProductoYServicio> getProductosByCategoria(Categoria cat){
        if (em==null) em = emf.createEntityManager();
        TypedQuery<ProductoYServicio> q = em.createNamedQuery("ProductoYServicio.findByCategoria", ProductoYServicio.class);
        q.setParameter("idCategoria", cat.getIdCategoria());
        List<ProductoYServicio> productos = q.getResultList();
        if (productos.isEmpty())
            return null;
        return productos;
    }
}
