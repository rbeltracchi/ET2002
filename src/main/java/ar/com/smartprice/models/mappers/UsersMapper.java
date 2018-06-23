/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.mappers;

import ar.com.smartprice.dtos.UserDto;
import ar.com.smartprice.models.Usuario;

/**
 *
 * @author Andres
 */
public class UsersMapper {

    public static UserDto UsuarioToUserDto(Usuario user) {
        UserDto userdto = new UserDto();

        userdto.setUserId(user.getIdUsuario());
        userdto.setEmail(user.getEmail());
        userdto.setPassword(user.getPassword());

        switch (user.getType()) {
            case "Usuario":
                userdto.setUserType(2);
                break;
            case "Oferente":
                userdto.setUserType(3);
                break;
        }
        
        userdto.setUserId(user.getIdUsuario());

//TODO seguir mapeando los demas atributos.. tanto de un consumidor como del oferente 
        return userdto;
    }

    public static Usuario userDtoToUsuario(UserDto user) {
        Usuario usuario = new Usuario();

        switch (user.getUserType()) {
            case 2:

                usuario.setIdUsuario(user.getUserId());
                usuario.setEmail(user.getEmail());
                usuario.setPassword(user.getPassword());

                break;
            case 3:
                System.out.println("[UsersMapper] El oferente no esta implementado");
                break;
        }

        return usuario;
    }

}
