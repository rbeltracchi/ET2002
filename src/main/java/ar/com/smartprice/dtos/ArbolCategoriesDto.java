/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.dtos;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Usuario
 */
public class ArbolCategoriesDto {
    private Vector<String> padres = new Vector<>();
    private Hashtable<String,Vector<CategoryDto>> hijos = new Hashtable();
    
    
    public ArbolCategoriesDto(){

    }

    public void setPadres(Vector<String> padres) {
        this.padres = padres;
    }

    public void setHijos(Hashtable<String, Vector<CategoryDto>> hijos) {
        this.hijos = hijos;
    }

    public Vector<String> getPadres(){
            return padres;
    }
    public Vector<CategoryDto> getHijos(String nombrePadre){
        Vector<CategoryDto> retorno = new Vector<>();
        retorno.addAll(hijos.get(nombrePadre));
        return retorno;
    }
}
