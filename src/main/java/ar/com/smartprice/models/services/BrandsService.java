/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.services;

import ar.com.smartprice.models.Marca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andres
 */
public class BrandsService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SmartPricePU");
    EntityManager em = null;

    //Carga una marca nueva, si ya existia trae el resto de los datos
    public Marca cargarMarca(String marca) {
        //Carga una nueva marca, o si ya existe devuelve su id
        Marca m = this.getMarca(marca);
        if (m == null) {
            if (em == null) {
                em = emf.createEntityManager();
            }
            em.getTransaction().begin();
            m = new Marca(marca);
            em.persist(m);
            em.getTransaction().commit();
        }
        return m;
    }

    public Marca getMarca(String marca) {
        if (em == null) {
            em = emf.createEntityManager();
        }
        em.getTransaction().begin();
        List<Marca> encontradas = em.createNamedQuery("Marca.findByNombre", Marca.class).setParameter("nombre", marca).getResultList();
        Marca m;
        if (encontradas.isEmpty()) {
            m = null;
        } else {
            m = encontradas.get(0);
        }
        em.getTransaction().commit();
        return m;
    }

    public Marca getMarcaPorId(int id) {
        if (em == null) {
            em = emf.createEntityManager();
        }
        em.getTransaction().begin();
        List<Marca> encontradas = em.createNamedQuery("Marca.findByIdmarcas", Marca.class).setParameter("idMarca", id).getResultList();
        Marca m;
        if (encontradas.isEmpty()) {
            m = null;
        } else {
            m = encontradas.get(0);
        }
        em.getTransaction().commit();
        return m;
    }

    public boolean actualizarMarca(Marca marca) {

        boolean exito = false;
        if (em == null) {
            em = emf.createEntityManager();
        }
        em.getTransaction().begin();

        if (this.getMarcaPorId(marca.getIdmarca()) == null) {
            exito = false;
        } else {
            em.merge(marca);

            exito = true;
        }
        em.getTransaction().commit();
        return exito;
    }

    public boolean borrarMarca(Marca marca) {
        boolean exito = false;
        if (em == null) {
            em = emf.createEntityManager();
        }
        em.getTransaction().begin();

        if (this.getMarcaPorId(marca.getIdmarca()) == null) {
            exito = false;
        } else {
            em.remove(marca);

            exito = true;
        }
        em.getTransaction().commit();
        return exito;
    }

}
