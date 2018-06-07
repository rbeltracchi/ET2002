/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models;

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
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("SmartPricePU");
    EntityManager em=null;
    
    
    public ProductoYServicio getProductoById(int id){
        if (em==null){
            em = emf.createEntityManager();
        }
        em.getTransaction().begin();
        TypedQuery<ProductoYServicio> q;
        q = em.createNamedQuery("ProductoYServicio.findByIdproductosYServicios", ProductoYServicio.class);
        q.setParameter("idproductosYServicios", id);
        List<ProductoYServicio> resultados  = q.getResultList();
        em.getTransaction().commit();
        if (resultados.isEmpty())
            return null;
        return  resultados.get(0);
        
    }
        
    //Inserta un nuevo producto al catalogo
    public boolean insertarProducto(ProductoYServicio pys){
        boolean exito=false;
        if (em==null) em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ProductoYServicio> q = em.createNamedQuery("ProductoYServicio.findByNombreYMarca", ProductoYServicio.class);
        q.setParameter("nombre", pys.getNombre());
        q.setParameter("idMarca", pys.getIdmarca());
        List<ProductoYServicio> pCargados = q.getResultList();
        if (pCargados.isEmpty())
        {
            em.persist(pys);
            exito=true;
        }
        em.getTransaction().commit();
        return exito;
    }
    
    //Carga una marca nueva, si ya existia trae el resto de los datos
    public Marca cargarMarca(String marca){
        //Carga una nueva marca, o si ya existe devuelve su id
        Marca m = this.getMarca(marca);
        if ( m == null){
            if (em==null) em = emf.createEntityManager();
            em.getTransaction().begin();
            m = new Marca(marca);
            em.persist(m);
            em.getTransaction().commit();
        }
        return m;
    }
    
    //Carga una categoria nueva. Si ya existia carga el resto de los datos (id, padre, etc)
    public Categoria cargarCategoria(String cat){
        //Carga una nueva marca, o si ya existe devuelve su id
        Categoria c = this.getCategoria(cat);
        if (c == null)
        {
            if (em==null) em = emf.createEntityManager();
            em.getTransaction().begin();
            c = new Categoria(cat);
            em.persist(c);
            em.getTransaction().commit();
        }
        
        return c;
    }
    
    //Carga un precioRegular de un oferente o para un producto p. Si habia un precio cargado, lo actualiza
    public void publicarPrecioRegular( Oferente o,ProductoYServicio p, float precio){
        PrecioRegular pRegular = new PrecioRegular(o.getIdUsuario(),p.getIdproductosYServicios() , precio);
        
        if (em==null) em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        TypedQuery<PrecioRegular> q = em.createNamedQuery("PrecioRegular.findByKey", PrecioRegular.class);
        q.setParameter("idproducto", p.getIdproductosYServicios());
        q.setParameter("idoferente", o.getIdUsuario());
        List<PrecioRegular> encontrados = q.getResultList();        
        if (encontrados.isEmpty()){
            em.persist(pRegular);
        }
        else {
            PrecioRegular yaCargado = encontrados.get(0);
            yaCargado.setPrecioRegular(precio);
            em.merge(yaCargado);
        }
        em.getTransaction().commit();
    }
    
    public int cantPyS(){
        if (em==null) em = emf.createEntityManager();
        
        em.getTransaction().begin();
        int cant = em.createNamedQuery("ProductoYServicio.countAll",Integer.class).getSingleResult();
        em.getTransaction().commit();
        return cant;
    }

    public Categoria getCategoria(String cat){
        
        if (em==null) em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Categoria>  encontradas = em.createNamedQuery("Categoria.findByNombre", Categoria.class).setParameter("nombre", cat).getResultList();
        Categoria c;
        if (encontradas.isEmpty()) {
            c= null;
        }
        else{
            c = encontradas.get(0);
        }
        em.getTransaction().commit();
        return c;
    }
    
    public Marca getMarca(String marca){
        if (em==null) em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Marca> encontradas = em.createNamedQuery("Marca.findByNombre", Marca.class).setParameter("nombre", marca).getResultList();
        Marca m;
        if (encontradas.isEmpty()) {
             m = null;
        }
        else 
        {
            m = encontradas.get(0);
        }
        em.getTransaction().commit();
        return m;
    }
    
      //Se obtienen todas las categorías cargadas
    public List<Categoria> obtenerTodasCategorias (){
        if (em==null) em = emf.createEntityManager();
        TypedQuery<Categoria> c=em.createNamedQuery("Categoria.findAll", Categoria.class);
        List<Categoria>categorias=c.getResultList();
        return categorias;
    }   
}
