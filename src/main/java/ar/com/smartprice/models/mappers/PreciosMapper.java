/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.mappers;

import ar.com.smartprice.dtos.PrecioDto;
import ar.com.smartprice.models.entities.Oferente;
import ar.com.smartprice.models.entities.Oferta;
import ar.com.smartprice.models.entities.PrecioRegular;
import ar.com.smartprice.models.entities.ProductoYServicio;
import ar.com.smartprice.models.services.PreciosService;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class PreciosMapper {
    public static Oferta precioDtoToOferta(PrecioDto precio){
        if (precio==null || precio.getFechaInicio()==null)
            return null;
        Oferta oferta = new Oferta();
        oferta.setOferente((Oferente) UsersMapper.userDtoToUsuario(precio.getOferente()));
        oferta.setProductoYServicio(ProductMapper.dtoTOproduct(precio.getProducto()));
        oferta.setPrecio(precio.getPrecio());
        oferta.setCantidadMinima(precio.getCompraMinima());
        oferta.setDescripcion(precio.getDescripcion());
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date inicioOferta;
            Date finOferta;
            try{
            inicioOferta = (Date) formatter.parseObject(precio.getFechaInicio());
            finOferta = (Date) formatter.parseObject(precio.getFechaFin());
            oferta.setFechaInicio(inicioOferta);
            oferta.setFechaFinalizacion(finOferta);
            
            }catch (ParseException ex) {
                Logger.getLogger(PreciosService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return oferta;
    }

    public static PrecioRegular precioDtoToPrecioRegular(PrecioDto precioSeleccionado) {
        Oferente oferente = (Oferente) UsersMapper.userDtoToUsuario(precioSeleccionado.getOferente());
        ProductoYServicio producto = ProductMapper.dtoTOproduct(precioSeleccionado.getProducto());
        PrecioRegular precio = new PrecioRegular(oferente, producto, precioSeleccionado.getPrecio());
        return precio;
    }
}
