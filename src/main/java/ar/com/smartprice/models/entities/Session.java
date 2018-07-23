/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.entities;

import ar.com.smartprice.models.persistence.Users_DBAdmin;

/**
 *
 * @author Agustin
 */
public class Session {
    
    private Usuario usuario;
    private boolean precios,catalogoAlta,catalogoModif,denunciar=false;
    private static Users_DBAdmin users;
    private boolean valida=false;
    private String error;
    
    public static void setUserDBA(Users_DBAdmin dba){
        users= dba;
    }
    public Session(String email, String pass) {
        Usuario usr = users.getUsuarioByEmail(email);
        if (usr != null){
            if (!usr.getPassword().equals(pass)){
                error="Contraseña Incorrecta";
                return; //CONTRASEÑA INCORRECTA
            }
            if (usr.getType().equals("Usuario")){
                denunciar=true;
                usuario=usr;
            }
            else if (usr.getType().equals("Oferente")){
                usuario = (Oferente) usr;
                precios=true;
                catalogoAlta=true;
            }
            valida=true;
        }
        
    }
    public boolean puedeAltaCatalogo(){
        return catalogoAlta;
    }
    public boolean puedeDenunciar(){
        return denunciar;
    }
    public boolean esValida(){
        return valida;
    }
    public String getError(){
        return error;
    }
    
    
}
