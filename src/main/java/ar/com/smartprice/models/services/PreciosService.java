/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.services;

import ar.com.smartprice.models.persistence.Precios_DBAdmin;
import ar.com.smartprice.dtos.PrecioDto;
import ar.com.smartprice.models.entities.DBConnection;
import ar.com.smartprice.models.entities.Oferente;
import ar.com.smartprice.models.entities.Oferta;
import ar.com.smartprice.models.entities.PrecioRegular;
import ar.com.smartprice.models.entities.ProductoYServicio;
import ar.com.smartprice.models.mappers.PreciosMapper;
import ar.com.smartprice.models.mappers.ProductMapper;
import ar.com.smartprice.models.mappers.UsersMapper;
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
public class PreciosService {
    private static final DBConnection DB = new DBConnection();
    private static final Precios_DBAdmin preciosDBA = new Precios_DBAdmin();

    public static boolean publicarPrecio(PrecioDto precioDto){
        if (precioDto==null)
            return false;
        Oferente oferente = (Oferente) UsersMapper.userDtoToUsuario(precioDto.getOferente());
        ProductoYServicio pys = ProductMapper.dtoTOproduct(precioDto.getProducto());
        if (precioDto.getFechaInicio()==null){
            return preciosDBA.publicarPrecioRegular(oferente, pys, precioDto.getPrecio());
        }
        else{
            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date inicioOferta;
            Date finOferta; 
            try {
                inicioOferta = (Date) formatter.parseObject(precioDto.getFechaInicio());
                finOferta = (Date) formatter.parseObject(precioDto.getFechaFin());
                return preciosDBA.rePublicarOferta(pys, oferente, inicioOferta, finOferta, precioDto.getPrecio(), precioDto.getCompraMinima(), precioDto.getDescripcion());
            } catch (ParseException ex) {
                Logger.getLogger(PreciosService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return false;
        
    }

    public static boolean eliminarPrecio(PrecioDto precioSeleccionado) {
        System.out.println("Entro a eliminar precio con");
        System.out.println(precioSeleccionado);
        if (precioSeleccionado==null)
            return false;
        if (precioSeleccionado.getFechaInicio()!=null){
            Oferta oferta = PreciosMapper.precioDtoToOferta(precioSeleccionado);
            return preciosDBA.eliminarOferta(oferta);
        }
        else{
            PrecioRegular precio = PreciosMapper.precioDtoToPrecioRegular(precioSeleccionado);
            return preciosDBA.eliminarPrecioRegular(precio);
        }
    }

}
