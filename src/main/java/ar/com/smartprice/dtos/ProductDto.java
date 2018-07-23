/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.dtos;

import ar.com.smartprice.models.entities.ProductoYServicio;
import ar.com.smartprice.models.mappers.CategoryMapper;

/**
 *
 * @author Usuario
 */
public class ProductDto {
    private int id=0;
    private String nombre;
    private String marca;
    private CategoryDto categoria;
    private String descripcion;
    private ListadoDePreciosDto precios= new ListadoDePreciosDto();
    
    public ProductDto(ProductoYServicio p){
        this.id= p.getIdproductosYServicios();
        this.nombre = p.getNombre();
        this.marca = p.getMarca().getNombre();
        this.categoria = CategoryMapper.CategoriaToCategoryDto(p.getCategoria());
        this.descripcion = p.getDescripcion();
    }

    public ProductDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public CategoryDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoryDto categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ListadoDePreciosDto getPrecios() {
        return precios;
    }

    public void setPrecios(ListadoDePreciosDto precios) {
        this.precios = precios;
    }
    
    
    
    
}
