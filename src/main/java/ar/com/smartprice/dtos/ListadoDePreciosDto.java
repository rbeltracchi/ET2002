/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.dtos;

import ar.com.smartprice.models.entities.Oferta;
import ar.com.smartprice.models.entities.PrecioRegular;
import ar.com.smartprice.models.services.GmapService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Usuario
 */


public class ListadoDePreciosDto implements Iterable<PrecioDto>{
    private List<PrecioDto> precios = new ArrayList();
    
    private String userLocation;
    
    public int size(){
        return precios.size();
    }
    public PrecioDto getAtIndex(int index){
        if (index>=0 && index<precios.size()){
            return precios.get(index);
        }
        return null;
    }
    public void addPrecio(PrecioDto p){
        precios.add(p);
    }
    public void setUserLocation(String location){
        userLocation=location;
    }
 
    public void ordenar(Comparator<PrecioDto> comparator){
        precios.sort(comparator);
    }

    @Override
    public Iterator<PrecioDto> iterator() {
        return precios.iterator();
    }
    
    public Vector<Vector<String>> getData(){
        Vector<Vector<String>> dataReturn = new Vector<Vector<String>>();
        for(PrecioDto p :precios){
            Vector<String> aux = new Vector<String>();
            aux.add(p.getOferente().getBusinessName());
            if (p.getGmap()!=null){
                aux.add(String.valueOf(p.getGmap().getDistanceWalk()));
            }
            else
                aux.add("");            
            aux.add(p.getOferente().getDireccion());
            aux.add((String.valueOf(p.getPrecio())));
            aux.add(String.valueOf(p.getCompraMinima()));
            aux.add(p.getFechaInicio());
            aux.add(p.getFechaFin());
            aux.add(p.getDescripcion());
            dataReturn.add(aux);            
        }
        
        return dataReturn;
    }
    
    public Vector<String> getHeader(){
        Vector<String> header = new Vector<String>();
        header.add("Oferente");
        header.add("Distancia");
        header.add("Direccion");
        header.add("Precio");
        header.add("Compra Minima");
        header.add("fechaInicio");
        header.add("fechaFin");
        header.add("descripcion");        
        return header;
    }
    public static ListadoDePreciosDto filtrarPorOferente(ListadoDePreciosDto precios, UserDto oferente){
        ListadoDePreciosDto retorno = new ListadoDePreciosDto();
        if (precios!=null && oferente!=null){
            for(PrecioDto precio: precios){
                if (precio.getOferente().equals(oferente)){
                    retorno.addPrecio(precio);
                }
            }
        }
        return retorno;
    }
}
    

