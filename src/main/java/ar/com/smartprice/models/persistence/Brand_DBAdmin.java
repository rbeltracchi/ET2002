/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.persistence;

import ar.com.smartprice.models.entities.DBConnection;
import ar.com.smartprice.models.entities.Marca;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 */
public class Brand_DBAdmin {

    private static DBConnection DB = new DBConnection();

    public Brand_DBAdmin() {
    }

    //Carga una marca nueva, si ya existia trae el resto de los datos
    /* viejo metodo create
    public Marca create(String marca) {
        //Carga una nueva marca, o si ya existe devuelve su id
        Marca m = this.getMarca(marca);
        if (m == null) {
            EntityManager em=DB.getEm();
            em.getTransaction().begin();
    
            m = new Marca(marca);
            em.persist(m);
            em.getTransaction().commit();
        }
        return m;
    }
     */
    public boolean create(Marca marca) {
        boolean exito = false;

        Marca exist = this.getMarca(marca.getNombre());
        EntityManager em = DB.getEm();
        if (exist == null) {

            em.getTransaction().begin();
            em.persist(marca);
            em.getTransaction().commit();
            exito = true;
        }

        return exito;
    }

    public Marca getMarca(String marca) {
        EntityManager em = DB.getEm();
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
        EntityManager em = DB.getEm();
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
        EntityManager em = DB.getEm();
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
        EntityManager em = DB.getEm();
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
