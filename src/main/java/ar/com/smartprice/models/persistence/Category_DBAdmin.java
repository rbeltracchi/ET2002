package ar.com.smartprice.models.persistence;

import ar.com.smartprice.models.entities.Categoria;
import ar.com.smartprice.models.entities.DBConnection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Agustin
 */
public class Category_DBAdmin {
    
    private static  DBConnection DB = new DBConnection();
    private EntityManager em=null;
    public Category_DBAdmin() {
    }
       
    //Se obtienen todas las categorías cargadas.
    public List<Categoria> obtenerTodasCategorias() {
        em=DB.getEm();
        TypedQuery<Categoria> c = em.createNamedQuery("Categoria.findAll", Categoria.class);
        List<Categoria> categorias = c.getResultList();
        return categorias;
    }

    public Categoria getCategoriaPorID(int id) {

         em=DB.getEm();
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

        em=DB.getEm();
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
    private void persistirCategoria(Categoria c){
        em = DB.getEm();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        
    }
    //Carga una categoria nueva. Si ya existia carga el resto de los datos (id, padre, etc)
    public Categoria cargarCategoria(String cat, String padre) {
        //Carga una nueva categoriaa, retorna
        
        Categoria cPadre = this.getCategoria(padre);
        if (cPadre==null && padre!=null){
            cPadre= new Categoria(padre);
            this.persistirCategoria(cPadre);
        }
        Categoria c = this.getCategoria(cat);
        if (c== null){
            c = new Categoria(cat);
            c.setCategoriaPadre(cPadre);
            this.persistirCategoria(c);
        }
        else{
            if (cPadre!=null && c.getCategoriaPadre()!=null){
                if (!cPadre.equals(c.getCategoriaPadre())){
                    c.setCategoriaPadre(cPadre);
                    this.actualizarCategoria(c);
                }
                
            }
        }
        return c;
    }

    public boolean actualizarCategoria(Categoria categoria) {

        boolean exito = false;
        em=DB.getEm();
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
        em=DB.getEm();
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
