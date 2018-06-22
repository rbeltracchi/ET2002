/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models;

import ar.com.smartprice.models.services.BrandsService;
import ar.com.smartprice.models.services.CategoriesService;
import ar.com.smartprice.models.services.PyS_DBAdmin;
import ar.com.smartprice.models.services.Search_DBAdmin;
import ar.com.smartprice.models.services.Users_DBAdmin;
import java.util.List;

/**
 *
 * @author Agustin
 */
public class Services {
    int cantPrecios= 15;
    Users_DBAdmin admin_usuarios = new Users_DBAdmin();
    PyS_DBAdmin admin_productos = new PyS_DBAdmin();
    Search_DBAdmin admin_busquedas = new Search_DBAdmin();
    BrandsService brandService = new BrandsService();
    CategoriesService categoriesServices = new CategoriesService();
    
    public void insertarProducto(String nombre, String marca, String categoria, String descripcion){
        Marca marcaCargada = brandService.cargarMarca(marca);
        Categoria idCategoria = categoriesServices.cargarCategoria(categoria);
        ProductoYServicio pys = new ProductoYServicio(nombre, marcaCargada, idCategoria, descripcion);
        
        boolean exito = admin_productos.insertarProducto(pys);
        if (!exito){
            System.out.println("EXCEPCION EL PRODUCTO YA EXISTIA");
        }
    }
    
    public List<ProductoYServicio> buscarProductos(String nombre,String cat){
        Categoria categoria = categoriesServices.getCategoria(cat);
        List<ProductoYServicio> productos = admin_busquedas.getProductosByNombre(nombre);
        return productos;
    }
    public List<PrecioRegular> getPrecios(int idProducto){
        
        ProductoYServicio p = admin_productos.getProductoById(idProducto);
        if ( p == null ) return null;
        
        return admin_busquedas.getPrecios(p, cantPrecios);
    }
    
    
}