/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.utils;

import ar.com.smartprice.dtos.PrecioDto;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class ComparatorPorPrecio implements Comparator<PrecioDto>{

    @Override
    public int compare(PrecioDto t, PrecioDto t1) {
        return (int) (t.getPrecio() - t1.getPrecio());
    }
    
}
