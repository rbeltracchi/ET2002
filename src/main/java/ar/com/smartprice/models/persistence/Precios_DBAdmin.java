/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.persistence;

import ar.com.smartprice.models.entities.DBConnection;
import ar.com.smartprice.models.entities.Oferente;
import ar.com.smartprice.models.entities.Oferta;
import ar.com.smartprice.models.entities.PrecioRegular;
import ar.com.smartprice.models.entities.ProductoYServicio;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Usuario
 */
public class Precios_DBAdmin {

    private static PyS_DBAdmin pysDBA = new PyS_DBAdmin();
    private static DBConnection DB = new DBConnection();

//Carga un precioRegular de un oferente o para un producto p. Si habia un precio cargado, lo actualiza
    public boolean publicarPrecioRegular(Oferente o, ProductoYServicio p, float precio) {
        PrecioRegular precioNuevo = new PrecioRegular(o, p, precio);

        PrecioRegular yaPublicado = this.getByConstraint(precioNuevo);
        if (yaPublicado == null) {
            EntityManager em = DB.getEm();
            em.getTransaction().begin();
            em.persist(precioNuevo);
            em.getTransaction().commit();
        } else {
            yaPublicado.set(precioNuevo);
            EntityManager em = DB.getEm();
            em.getTransaction().begin();
            em.merge(yaPublicado);
            em.getTransaction().commit();
        }
        return true;
    }

    public Oferta getOfertaByID(Integer id) {
        EntityManager em = DB.getEm();
        em.getTransaction().begin();
        TypedQuery<Oferta> q;
        q = em.createNamedQuery("Oferta.findByIdOferta", Oferta.class);
        q.setParameter("idOferta", id);
        List<Oferta> resultados = q.getResultList();
        em.getTransaction().commit();
        if (resultados.isEmpty()) {
            return null;
        }
        return resultados.get(0);
    }
    public Oferta getOfertaByProductID(Integer idUser, Integer idProduct) {
        EntityManager em = DB.getEm();
        em.getTransaction().begin();
        TypedQuery<Oferta> q;
        q = em.createNamedQuery("Oferta.findByIdproducto", Oferta.class);
        q.setParameter("idproducto", idProduct);
        q.setParameter("iduser", idUser);
        List<Oferta> resultados = q.getResultList();
        em.getTransaction().commit();
        if (resultados.isEmpty()) {
            return null;
        }
        return resultados.get(0);
    }

    public boolean rePublicarOferta(ProductoYServicio productoYServicio, Oferente oferente, Date fechaInicio, Date fechaFinalizacion, float precio, Integer cantidadMinima, String descripcion) {
        
        if (fechaInicio.after(fechaFinalizacion))
            return false;
        Oferta ofertaNueva = new Oferta(productoYServicio, oferente, fechaInicio, fechaFinalizacion, precio, cantidadMinima, descripcion);
        Oferta yaPublicada = this.getByConstraint(ofertaNueva);
        if (yaPublicada != null) {
            yaPublicada.set(ofertaNueva);
            EntityManager em = DB.getEm();
            em.getTransaction().begin();
            em.merge(yaPublicada);
            em.getTransaction().commit();
        } else {
            EntityManager em = DB.getEm();
            em.getTransaction().begin();
            em.persist(ofertaNueva);
            em.getTransaction().commit();
        }
        return true;
    }

    public Oferta getByConstraint(Oferta nuevaOferta) {
        EntityManager em = DB.getEm();
        em.getTransaction().begin();
        TypedQuery<Oferta> q = em.createNamedQuery("Oferta.findByConstraint", Oferta.class);
        q.setParameter("idproducto", nuevaOferta.getProductoYServicio());
        q.setParameter("idoferente", nuevaOferta.getOferente());
        q.setParameter("cantMinima", nuevaOferta.getCantidadMinima());
        
        List<Oferta> ofertasEncontradas = q.getResultList();
        em.getTransaction().commit();
        if (ofertasEncontradas.isEmpty()) {
            return null;
        } else {
            return ofertasEncontradas.get(0);
        }
    }
    
    public PrecioRegular getByConstraint(PrecioRegular p){
        EntityManager em = DB.getEm();
        em.getTransaction().begin();

        TypedQuery<PrecioRegular> q = em.createNamedQuery("PrecioRegular.findByKey", PrecioRegular.class);
        q.setParameter("idproducto", p.getProductoYServicio().getIdproductosYServicios());
        q.setParameter("idoferente", p.getOferente().getIdUsuario());
        List<PrecioRegular> encontrados = q.getResultList();
        em.getTransaction().commit();
        if (encontrados.isEmpty())
            return null;
        else 
            return encontrados.get(0);
    }

    public Oferta getByUserAndProduct(Oferente oferente, ProductoYServicio productoYServicio) {
        EntityManager em = DB.getEm();
        em.getTransaction().begin();
        TypedQuery<Oferta> q = em.createNamedQuery("Oferta.findByUserAndProduct", Oferta.class);
        q.setParameter("idproducto", productoYServicio);
        q.setParameter("idoferente", oferente);
        
        
        List<Oferta> ofertasEncontradas = q.getResultList();
        em.getTransaction().commit();
        if (ofertasEncontradas.isEmpty()) {
            return null;
        } else {
            return ofertasEncontradas.get(0);
        }
    }

    public boolean eliminarOferta(Oferta oferta) {
        Oferta aBorrar = this.getByConstraint(oferta);
        if (aBorrar!=null){
            EntityManager em = DB.getEm();
            em.getTransaction().begin();
            em.remove(aBorrar);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean eliminarPrecioRegular(PrecioRegular precio) {
        PrecioRegular aBorrar = this.getByConstraint(precio);
        if (aBorrar!=null){
            EntityManager em = DB.getEm();
            em.getTransaction().begin();
            em.remove(aBorrar);
            em.getTransaction().commit();
            return true;
        }
        return false;        
    }

}
