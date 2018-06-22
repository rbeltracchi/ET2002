/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.services;

import ar.com.smartprice.models.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Andres
 */
public class CategoriesService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SmartPricePU");
    EntityManager em = null;

    //Se obtienen todas las categorías cargadas
    public List<Categoria> obtenerTodasCategorias() {
        if (em == null) {
            em = emf.createEntityManager();
        }
        TypedQuery<Categoria> c = em.createNamedQuery("Categoria.findAll", Categoria.class);
        List<Categoria> categorias = c.getResultList();
        return categorias;
    }

    public Categoria getCategoriaPorID(int id) {

        if (em == null) {
            em = emf.createEntityManager();
        }
        em.getTransaction().begin();
        List<Categoria> encontradas = em.createNamedQuery("Categoria.findByIdCategoria", Categoria.class).setParameter("idCategoria", id).getResultList();
        Categoria c;
        if (encontradas.isEmpty()) {
            c = null;
        } else {
            c = encontradas.get(0);
        }
        em.getTransaction().commit();
        return c;

    }

    public Categoria getCategoria(String cat) {

        if (em == null) {
            em = emf.createEntityManager();
        }
        em.getTransaction().begin();
        List<Categoria> encontradas = em.createNamedQuery("Categoria.findByNombre", Categoria.class).setParameter("nombre", cat).getResultList();
        Categoria c;
        if (encontradas.isEmpty()) {
            c = null;
        } else {
            c = encontradas.get(0);
        }
        em.getTransaction().commit();
        return c;
    }

    //Carga una categoria nueva. Si ya existia carga el resto de los datos (id, padre, etc)
    public Categoria cargarCategoria(String cat) {
        //Carga una nueva marca, o si ya existe devuelve su id
        Categoria c = this.getCategoria(cat);
        if (c == null) {
            if (em == null) {
                em = emf.createEntityManager();
            }
            em.getTransaction().begin();
            c = new Categoria(cat);
            em.persist(c);
            em.getTransaction().commit();
        }

        return c;
    }

    public boolean actualizarCategoria(Categoria categoria) {

        boolean exito = false;
        if (em == null) {
            em = emf.createEntityManager();
        }
        em.getTransaction().begin();

        if (this.getCategoriaPorID(categoria.getIdCategoria()) == null) {
            exito = false;
        } else {
            em.merge(categoria);

            exito = true;
        }
        em.getTransaction().commit();
        return exito;
    }

    public boolean borrarCategoria(Categoria categoria) {
        boolean exito = false;
        if (em == null) {
            em = emf.createEntityManager();
        }
        em.getTransaction().begin();

        if (this.getCategoriaPorID(categoria.getIdCategoria()) == null) {
            exito = false;
        } else {
            em.remove(categoria);

            exito = true;
        }
        em.getTransaction().commit();
        return exito;
    }
}
