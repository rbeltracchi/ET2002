/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.persistence;

import ar.com.smartprice.models.entities.Categoria;
import ar.com.smartprice.models.entities.DBConnection;
import ar.com.smartprice.models.entities.Oferente;
import ar.com.smartprice.models.entities.Oferta;
import ar.com.smartprice.models.entities.PrecioRegular;
import ar.com.smartprice.models.entities.ProductoYServicio;
import ar.com.smartprice.models.entities.Usuario;
import ar.com.smartprice.utils.ComparadorPrecios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Agustin
 */
public class Search_DBAdmin {
        private static DBConnection DB = new DBConnection();
        private static PyS_DBAdmin productosDba = new PyS_DBAdmin();

    public Search_DBAdmin() {
        
    }
    
        
    //REEMPLAZADA POR ByKeys-- BORRABLE            //trae los productos que satisfacen un nombre
    public List<ProductoYServicio> getProductosByNombre(String nombre){
        EntityManager em=DB.getEm();
        
        em.getTransaction().begin();
        TypedQuery<ProductoYServicio> q = em.createNamedQuery("ProductoYServicio.findByNombre", ProductoYServicio.class);
        q.setParameter("nombre", nombre);
        List<ProductoYServicio> productos = q.getResultList();
        em.getTransaction().commit();
        if (productos.isEmpty())
            return null;
        return productos;
    }
    
    public List<ProductoYServicio> getProductosByKeys(String entrada,Categoria categoria){
        entrada=entrada.toLowerCase();
        String[] keys = entrada.split("\\s");
        String condicion = "SELECT p FROM ProductoYServicio p WHERE (p.categoria=:categoria AND ( ";
        boolean agregadoPrimero=false;
        for (int i=0; i<keys.length; i++){
            String key = keys[i];
            if (!key.matches("\\bla\\b|"
                    + "\\blas\\b|"
                    +"\\bde\\b|"
                    +"\\bdel\\b|"
                    +"\\ba\\b|"
                    +"\\bcon\\b|"
                    +"\\bsin\\b|"
                    +"\\ben\\b"
                    )){
                if (agregadoPrimero)
                    condicion += " OR ";  
               condicion+= "( p.nombre like '%"+keys[i]+"%')";
               agregadoPrimero=true;        
            }
        }
        condicion+= "))";
        System.out.println("Query de busqueda generada");
        System.out.println(condicion);
        EntityManager em=DB.getEm();
        
        em.getTransaction().begin();
        TypedQuery<ProductoYServicio> q = em.createQuery(condicion, ProductoYServicio.class);
        q.setParameter("categoria", categoria);
        List<ProductoYServicio> productos = q.getResultList();
        em.getTransaction().commit();
        if (productos.isEmpty())
            return null;
        return productos;
    }
    
     //Trae precios para un producto dado
    public List<PrecioRegular> getPrecios(ProductoYServicio p){
        EntityManager em=DB.getEm();
        
        em.getTransaction().begin();
        TypedQuery<PrecioRegular> q = em.createNamedQuery("PrecioRegular.findByIdproducto",PrecioRegular.class);
        q.setParameter("idproducto", p.getIdproductosYServicios());
        List<PrecioRegular> precios = q.getResultList();
        //java.util.Collections.sort(precios, new ComparadorPrecios());
        //Comentado ya que no conviene ordenarlo ahora, sino luego cuando se junten los precios con las ofertas
        em.getTransaction().commit();
        if (precios.isEmpty())
            return null;
        return precios;
    }
     public List<PrecioRegular> getPreciosForOfferer(Oferente o){
        EntityManager em=DB.getEm();
        em.getTransaction().begin();
        TypedQuery<PrecioRegular> q = em.createNamedQuery("PrecioRegular.findByIdoferente",PrecioRegular.class);
        q.setParameter("idOferente", o.getIdUsuario());
        List<PrecioRegular> precios = q.getResultList();
        em.getTransaction().commit();
        if (precios.isEmpty())
            return null;
        return precios;
    }
     public List<Oferta> getOfertasByOferente(Oferente o){
        EntityManager em = DB.getEm();
        em.getTransaction().begin();
        TypedQuery<Oferta> q = em.createNamedQuery("Oferta.findByIdoferente",Oferta.class);
        q.setParameter("idoferente", o);
        List<Oferta> ofertas = q.getResultList();
        em.getTransaction().commit();
        if (ofertas.isEmpty())
            return null;
        return ofertas;
    }
    
    public List<Oferta> getOfertas(ProductoYServicio p){
        EntityManager em = DB.getEm();
        em.getTransaction().begin();
        TypedQuery<Oferta> q = em.createNamedQuery("Oferta.findByIdproducto",Oferta.class);
        q.setParameter("idproducto", p);
        List<Oferta> ofertas = q.getResultList();
        //java.util.Collections.sort(ofertas, new ComparadorPrecios());
        em.getTransaction().commit();
        if (ofertas.isEmpty())
            return null;
        return ofertas;
    }
    
    //Trae los productos que satisfacen una categoria
    public List<ProductoYServicio> getProductosByCategoria(Categoria cat){
        EntityManager em=DB.getEm();
        em.getTransaction().begin();
        TypedQuery<ProductoYServicio> q = em.createNamedQuery("ProductoYServicio.findByCategoria", ProductoYServicio.class);
        q.setParameter("idCategoria", cat.getIdCategoria());
        List<ProductoYServicio> productos = q.getResultList();
        em.getTransaction().commit();
        if (productos.isEmpty())
            return null;
        return productos;
    }
    
    public List<Oferta> ofertasOferenteProducto(Oferente oferente, ProductoYServicio producto){
        EntityManager em = DB.getEm();
        TypedQuery<Oferta> q = em.createNamedQuery("Oferta.findByUserAndProduct", Oferta.class);
        q.setParameter("idproducto", producto);
        q.setParameter("idoferente", oferente);
        em.getTransaction().begin();
        List<Oferta> ofertasEncontradas = q.getResultList();
        em.getTransaction().commit();
        if (ofertasEncontradas.isEmpty())
            return null;
        return ofertasEncontradas;
    }
}
