/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.utils;

import ar.com.smartprice.models.entities.PrecioRegular;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class ComparadorPrecios implements Comparator<PrecioRegular>{

    @Override
    public int compare(PrecioRegular t, PrecioRegular t1) {
        return (int) (t.getPrecio() - t1.getPrecio());
    }
    
}
