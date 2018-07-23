/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.dtos;

import ar.com.smartprice.models.entities.ProductoYServicio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Usuario
 */
public class ListadoDeProductDto implements Iterable<ProductDto>{
    private List<ProductDto> productos = new ArrayList<>();

    public ListadoDeProductDto() {
    }
    public ProductDto getAtIndex(int index){
        if (index>=0 && index < productos.size()){
            return productos.get(index);
        }
        return null;
    }
    
    public ListadoDeProductDto(List<ProductDto> p) {
        productos=p;
    }
    public void addListado(List<ProductoYServicio> ps){
        if (ps == null) {
            return;
        }
        for(ProductoYServicio p: ps){
            this.addProducto(new ProductDto(p));
        }
    }
    public void addProducto(ProductDto p){
        productos.add(p);
    }
    public Vector<Vector<String>> getData(){
        Vector<Vector<String>> dataReturn = new Vector<Vector<String>>();
        for (ProductDto p : productos){
            Vector<String> aux = new Vector<String>();
            aux.add(p.getNombre());
            aux.add(p.getMarca());
            if (p.getCategoria()!=null)
                aux.add(p.getCategoria().getName());
            else aux.add("");
            aux.add(p.getDescripcion());
            dataReturn.add(aux);
        }
        
        return dataReturn;
    }
    public Vector<String> getHeader(){
        Vector<String> header = new Vector<String>();
        header.add("Nombre");
        header.add("Marca");
        header.add("Categoria");
        header.add("Descripcion");
        return header;
    }
    @Override
    public Iterator<ProductDto> iterator() {
        return productos.iterator();
    }
}
