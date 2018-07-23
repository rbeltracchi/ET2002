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
public class ComparatorConDesempate implements Comparator<PrecioDto>{
    private Comparator<PrecioDto> primario;
    private Comparator<PrecioDto> secundario;

    public ComparatorConDesempate(Comparator<PrecioDto> primario, Comparator<PrecioDto> secundario) {
        this.primario = primario;
        this.secundario = secundario;
    }
    
    

    @Override
    public int compare(PrecioDto t, PrecioDto t1) {
        int comparacionPrimaria = primario.compare(t, t1);
        if (comparacionPrimaria==0){
            return secundario.compare(t, t1);
        }
        else 
            return comparacionPrimaria;
    }
    
}

