/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models;

import ar.com.smartprice.models.services.Users_DBAdmin;

/**
 *
 * @author Agustin
 */
public class Session {
    
    Usuario usuario;
    boolean precios,catalogoAlta,catalogoModif,denunciar=false;
    Users_DBAdmin users = new Users_DBAdmin();
    boolean valida=false;
    String error;

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
