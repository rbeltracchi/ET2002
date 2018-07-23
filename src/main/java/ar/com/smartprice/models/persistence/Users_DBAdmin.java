/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.persistence;

import ar.com.smartprice.models.entities.Categoria;
import ar.com.smartprice.models.entities.DBConnection;
import ar.com.smartprice.models.entities.Oferente;
import ar.com.smartprice.models.entities.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Agustin
 */
public class Users_DBAdmin {
    private static  DBConnection DB = new DBConnection();
    
    
    public Users_DBAdmin() {
    }
    

    public boolean insertarUsuario(Usuario usr) {

        boolean success = false;
        if (usr == null) {
            return success;
        }

        Usuario yaCargado = this.getUsuarioByEmail(usr.getEmail());
        if (yaCargado != null) {
            return success;
        }
        EntityManager em=DB.getEm();
        try {
            em.getTransaction().begin();
            em.persist(usr);
            em.getTransaction().commit();
            success = true;

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //Close comentado porque al registrar y despues loguear explotaba
           // em.close();
        }
        return success;
    }

    public boolean borrarUsuario(Usuario usr) {

        boolean success = false;

        if (usr == null) {
            return success;
        }
        System.out.println("Id del usuario pasado por parametro " + usr.getIdUsuario());

        //Si no es el de la base de datos, lo traigo
        if (usr.getIdUsuario() == null || usr.getIdUsuario() == 0) {
            usr = this.getUsuarioByEmail(usr.getEmail());
        }

        if (usr == null) {
            return success; //EL usuario no estaba cargado en la BD
        }
        //TODO OK podemos cambiarlo
        EntityManager em=DB.getEm();
        try {
            em.getTransaction().begin();
            usr.setActivo(false);
            em.merge(usr);
            em.getTransaction().commit();
            success = true;

        } catch (Exception e) {

        } finally {
            //em.close();
        }
        return success;
    }

    public boolean reactivarUsuario(Usuario usr) {
        boolean success = false;

        if (usr == null) {
            return success;
        }
        if (usr.getIdUsuario() == null) {
            usr = this.getUsuarioByEmail(usr.getEmail());
        }

        if (usr == null) {
            return success; //EL usuario no estaba cargado en la BD
        }
        //TODO OK podemos cambiarlo
        EntityManager em=DB.getEm();
        try {

        } catch (Exception e) {
        } finally {
            em.getTransaction().begin();
            TypedQuery<Usuario> q;
            q = em.createNamedQuery("Usuario.findByEmail", Usuario.class);
            q.setParameter("email", usr.getEmail());
            List<Usuario> usuariosConEseEmail = q.getResultList();
            em.getTransaction().commit();

            //boolean elEmailEstaCargado = usuariosConEseEmail.size() > 0;
            if (usuariosConEseEmail.size() > 0) {
                em=DB.getEm();
                em.getTransaction().begin();
                Usuario aReactivar = usuariosConEseEmail.get(0);
                aReactivar.setActivo(true);
                em.merge(aReactivar);
                em.getTransaction().commit();
                //em.close();
                success = true;
            } else {
                System.out.println("El Usuario no pertenece a la base de datos");
            }
        }
        return success;
    }

    // Trae un usuario por su email, si no existe, trae null
    public Usuario getUsuarioByEmail(String email) {
        EntityManager em=DB.getEm();
        
        em.getTransaction().begin();
        TypedQuery<Usuario> q;
        q = em.createNamedQuery("Usuario.findByEmail", Usuario.class);
        q.setParameter("email", email);
        List<Usuario> usrs = q.getResultList();
        em.getTransaction().commit();
        if (usrs.isEmpty()) {
            return null;
        }
        Usuario usr = usrs.get(0);//Si no hay usuario devuelve NULL
        return usr;
    }

    public boolean actualizarUsuario(Usuario user) {

        boolean success = false;
        EntityManager em=DB.getEm();
        /*
        if (this.getUsuarioByEmail(user.getEmail()) == null) {
            return success;
        }
         */
        if (user == null || this.getUsuarioByEmail(user.getEmail()) == null) {
            return success;
        }

        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            success = true;

        } catch (Exception e) {
        } finally {
            //em.close();
        }
        return success;
    }

// OFERENTES
    public int cantOferentes() {
        EntityManager em=DB.getEm();

        em.getTransaction().begin();
        int cant = em.createNamedQuery("Oferente.countAll", Integer.class).getSingleResult();
        em.getTransaction().commit();
        return cant;
    }

    //trae una lista de oferentes
    public List<Oferente> getOferentes() {
        EntityManager em=DB.getEm();

        em.getTransaction().begin();
        List<Oferente> oferentesCargados = em.createNamedQuery("Oferente.findAll", Oferente.class).getResultList();
        em.getTransaction().commit();
        if (oferentesCargados.isEmpty()) {
            return null;
        } else {
            return oferentesCargados;
        }
    }

}
