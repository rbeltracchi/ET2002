/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.utils;

import ar.com.smartprice.dtos.UserDto;
import ar.com.smartprice.models.Usuario;

/**
 *
 * @author Andres
 */
public class Mapper {
    
    public static UserDto UsuarioToUserDto(Usuario user){
        UserDto userdto = new UserDto();
        
        userdto.setEmail(user.getEmail());
        userdto.setPassword(user.getPassword());
        
        //tendria que ser un int ????
        //userdto.setUserType(user.getType());
        
        userdto.setUserId(user.getIdUsuario());
        
//TODO seguir mapeando los demas atributos.. tanto de un consumidor como del oferente 
        
        return userdto;
    } 
    
}
