/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.dtos;

import ar.com.smartprice.models.entities.Oferta;
import ar.com.smartprice.models.entities.PrecioRegular;
import ar.com.smartprice.models.mappers.UsersMapper;
import java.text.SimpleDateFormat;

/**
 *
 * @author Usuario
 */
public class PrecioDto {
    UserDto oferente;
    ProductDto producto;
    float precio;
    Integer compraMinima=1;
    String fechaInicio=null;
    String fechaFin=null;
    String descripcion;
    GmapsDto gmap;

    public PrecioDto() {
    }
    
    public void copiar(PrecioDto otro){
        this.oferente = otro.getOferente();
        this.producto= otro.getProducto();
        this.precio= otro.getPrecio();
        this.compraMinima= otro.getCompraMinima();
        this.fechaInicio= otro.getFechaInicio();
        this.fechaFin = otro.getFechaFin();
        this.descripcion = otro.getDescripcion();
        this.gmap= otro.getGmap();
    }
    public PrecioDto(Oferta o){
        this.oferente = UsersMapper.UsuarioToUserDto(o.getOferente());
        this.producto = new ProductDto(o.getProductoYServicio());
        this.precio = o.getPrecio();
        this.compraMinima = o.getCantidadMinima();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.fechaInicio = sdf.format(o.getFechaInicio());
        this.fechaFin = sdf.format(o.getFechaFinalizacion());
        this.descripcion = o.getDescripcion();
    }

    public GmapsDto getGmap() {
        return gmap;
    }

    public void setGmap(GmapsDto gmap) {
        this.gmap = gmap;
    }
    
    public PrecioDto(PrecioRegular p){
        this.oferente = UsersMapper.UsuarioToUserDto(p.getOferente());
        this.producto =new ProductDto(p.getProductoYServicio());
        this.precio = p.getPrecio();
        this.compraMinima = 1;
        this.fechaInicio = null;
        this.fechaFin = null;
        this.descripcion = null;
        
    }

    public UserDto getOferente() {
        return oferente;
    }

    public void setOferente(UserDto oferente) {
        this.oferente = oferente;
    }

    public ProductDto getProducto() {
        return producto;
    }

    public void setProducto(ProductDto producto) {
        this.producto = producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Integer getCompraMinima() {
        return compraMinima;
    }

    public void setCompraMinima(Integer compraMinima) {
        this.compraMinima = compraMinima;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }    

    @Override
    public String toString() {
        String retorno="";
        String separador = "____";
        retorno+=this.oferente.getId() + separador;
        retorno+=this.producto.getNombre() + separador;
        retorno+=this.precio +separador;
        retorno+=this.compraMinima +separador;
        retorno+=this.fechaInicio +separador;
        retorno+=this.fechaFin +separador;
        retorno+=this.descripcion;
        return retorno;
    }
    
}
