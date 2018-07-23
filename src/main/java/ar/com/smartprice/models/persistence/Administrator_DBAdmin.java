package ar.com.smartprice.models.persistence;

import ar.com.smartprice.models.entities.Administradores;
import ar.com.smartprice.models.entities.DBConnection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Clase encargada de realizar las operacion con la base de datos de la tabla
 * Administradores
 *
 * @author Andres
 * @version 0.1
 */
public class Administrator_DBAdmin {

    private static final DBConnection DB = new DBConnection();

    /**
     * Persiste en la base de datos un Administrador
     *
     * @param admin Recibe un Administrador
     * @return boolean true si pudo registrar el Administrador, en caso
     * contrario false;
     */
    public boolean create(Administradores admin) {
        boolean success = false;
        try {
            EntityManager em = DB.getEm();
            em.getTransaction().begin();
            admin.setActivo(true);
            em.persist(admin);
            em.getTransaction().commit();
            em.close();
            success = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return success;
    }

    /**
     * Actualiza los datos de un Administrador en la base de datos
     *
     * @param admin Recibe un Administrador
     * @return boolean true si pudo actualizar los datos del Administrador, en
     * caso contrario false;
     */
    public boolean update(Administradores admin) {
        boolean success = false;
        try {
            EntityManager em = DB.getEm();
            em.getTransaction().begin();
            em.merge(admin);
            em.getTransaction().commit();
            em.close();
            success = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return success;
    }

    /**
     * Borra un Administrador de la base de datos
     *
     * @param admin Recibe un Administradores
     * @return boolean true si pudo borrar al Administrador, en caso contrario
     * false;
     */
    public boolean delete(Administradores admin) {
        boolean success = false;
        try {
            EntityManager em = DB.getEm();
            em.getTransaction().begin();
            em.remove(admin);
            em.getTransaction().commit();
            em.close();
            success = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return success;
    }

    /**
     * Activa a un Administrador de la base de datos
     *
     * @param admin Recibe un Administradores
     * @return boolean true si pudo activar al Administrador, en caso contrario
     * false;
     */
    public boolean setActive(Administradores admin) {
        boolean success = false;
        try {
            EntityManager em = DB.getEm();
            em.getTransaction().begin();
            admin.setActivo(true);
            em.merge(admin);
            em.getTransaction().commit();
            em.close();
            success = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return success;
    }

    /**
     * Desactiva a un Administrador de la base de datos
     *
     * @param admin Recibe un Administradores
     * @return boolean true si pudo desactivar al Administrador, en caso
     * contrario false;
     */
    public boolean setInactive(Administradores admin) {
        boolean success = false;
        try {
            EntityManager em = DB.getEm();
            em.getTransaction().begin();
            admin.setActivo(false);
            em.merge(admin);
            em.getTransaction().commit();
            em.close();
            success = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return success;
    }

    /**
     * Obtiene un listado de todos los Administradores
     *
     * @return retorna un listado de Administradores
     */
    public List<Administradores> getAll() {
        List<Administradores> admin;
        try {
            EntityManager em = DB.getEm();
            TypedQuery<Administradores> query;
            query = em.createNamedQuery("Administradores.findAll", Administradores.class);

            admin = query.getResultList();
        } catch (Exception e) {
            return null;
        }

        if (admin.isEmpty()) {
            return null;
        }
        return admin;
    }

    /**
     * Obtiene un listado de todos los Administradores activos
     *
     * @return retorna un listado de Administradores
     */
    public List<Administradores> getAllActive() {
        List<Administradores> admin;
        try {
            EntityManager em = DB.getEm();
            TypedQuery<Administradores> query;
            query = em.createNamedQuery("Administradores.findByActivo", Administradores.class);
            query.setParameter("activo", true);
            admin = query.getResultList();
        } catch (Exception e) {
            return null;
        }

        if (admin.isEmpty()) {
            return null;
        }
        return admin;
    }

    /**
     * Obtiene un listado de todos los Administradores desactivos
     *
     * @return retorna un listado de Administradores
     */
    public List<Administradores> getAllInactive() {
        List<Administradores> admin;
        try {
            EntityManager em = DB.getEm();
            TypedQuery<Administradores> query;
            query = em.createNamedQuery("Administradores.findByActivo", Administradores.class);
            query.setParameter("activo", false);
            admin = query.getResultList();
        } catch (Exception e) {
            return null;
        }

        if (admin.isEmpty()) {
            return null;
        }
        return admin;
    }

    /**
     * Obtiene un Administrador buscando por su id
     *
     * @param id int
     * @return retorna un Administradores
     */
    public Administradores getAdministratorById(int id) {
        Administradores admin;
        try {
            EntityManager em = DB.getEm();
            TypedQuery<Administradores> query;
            query = em.createNamedQuery("Administradores.findByIdadministradores", Administradores.class);
            query.setParameter("idadministradores", id);

            admin = query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

        return admin;
    }

    /**
     * Obtiene un Administrador buscando por su correo electronico
     *
     * @param email String
     * @return retorna un Administradores
     */
    public Administradores getAdministratorByEmail(String email) {
        Administradores admin;
        try {
            EntityManager em = DB.getEm();
            TypedQuery<Administradores> query;
            query = em.createNamedQuery("Administradores.findByEmail", Administradores.class);
            query.setParameter("email", email);

            admin = query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

        return admin;
    }

    /**
     * Obtiene un Administrador buscando por su nombre
     *
     * @param name String
     * @return retorna un Administradores
     */
    public Administradores getAdministratorByName(String name) {
        Administradores admin;
        try {
            EntityManager em = DB.getEm();
            TypedQuery<Administradores> query;
            query = em.createNamedQuery("Administradores.findByNombre", Administradores.class);
            query.setParameter("nombre", name);

            admin = query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return admin;
    }
    
    /**
     * Obtiene la cantidad de Administradores registrados
     *
     * @return int retorna la cantidad total de administradores.
     */
    public int getAmountOfAdministrators() {
        EntityManager em = DB.getEm();
        int amount = 0;
        try {
            amount = em.createNamedQuery("Administradores.countAll", Integer.class).getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return amount;
    }

}
