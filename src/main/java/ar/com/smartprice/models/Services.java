/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models;

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
    
    public void insertarProducto(String nombre, String marca, String categoria, String descripcion){
        Marca marcaCargada = admin_productos.cargarMarca(marca);
        Categoria idCategoria = admin_productos.cargarCategoria(categoria);
        ProductoYServicio pys = new ProductoYServicio(nombre, marcaCargada, idCategoria, descripcion);
        
        boolean exito = admin_productos.insertarProducto(pys);
        if (!exito){
            System.out.println("EXEPCION EL PRODUCTO YA EXISTIA");
        }
    }
    
    public List<ProductoYServicio> buscarProductos(String nombre,String cat){
        Categoria categoria = admin_productos.getCategoria(cat);
        List<ProductoYServicio> productos = admin_busquedas.getProductosByNombre(nombre);
        return productos;
    }
    public List<PrecioRegular> getPrecios(int idProducto){
        
        ProductoYServicio p = admin_productos.getProductoById(idProducto);
        if ( p == null ) return null;
        
        return admin_busquedas.getPrecios(p, cantPrecios);
    }
    
    
}