
package ar.com.smartprice.models.services;

import ar.com.smartprice.dtos.AdministratorDto;
import ar.com.smartprice.dtos.CredentialsDto;
import ar.com.smartprice.dtos.UserDto;


/**
 * @author Andres
 * @version 0.1.0
 *
 * Servicios de usuarios
 */
public class UsersService {

    /**
     * Servicio para la creacion de un usuario.
     *
     * @param user UserDto
     * @return 
     */
    public boolean create(UserDto user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
    }

    /**
     * Servicio para eliminar un usuario.
     *
     * @param user UserDto es el usuario a borrar
     * @return 
     * 
     */
    public static boolean delete(UserDto user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Servicio para eliminar un usuario.
     *
     * @param user UserDto es el usuario a borrar
     * @param userRequest usuario que realizar la operacion
     * @return 
     */
    public static boolean delete(UserDto user, AdministratorDto userRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Servicio para actualizar datos de un usuario.
     *
     * @param user UserDto
     * @return 
     *
     */
    public static boolean update(UserDto user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Servicio para obtener un usuario.
     *
     * @param user UserDto
     * @return 
     *
     */
    public static UserDto read(UserDto user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Servicio de autenticacion de usuarios.
     *
     * @param credentials CredentialsDto credentials
     * @return UserDto
     */
    //authentication
    public static UserDto logIn(CredentialsDto credentials) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Servicio de cierre de session de un usuario.
     *
     * @param user UserDto usuario que quiere cerrar la session
     */
    public static void logOut(UserDto user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
