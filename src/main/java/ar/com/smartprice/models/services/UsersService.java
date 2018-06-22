package ar.com.smartprice.models.services;

import ar.com.smartprice.dtos.AdministratorDto;
import ar.com.smartprice.dtos.CredentialsDto;
import ar.com.smartprice.dtos.TokenInfoDto;
import ar.com.smartprice.dtos.UserDto;
import ar.com.smartprice.models.Oferente;
import ar.com.smartprice.models.Usuario;
import ar.com.smartprice.utils.Authentication;
import ar.com.smartprice.utils.Cryptography;
import ar.com.smartprice.utils.Mapper;
import ar.com.smartprice.utils.SPError;

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
     * @param user Recibe un {@link ar.com.smartprice.dtos.UserDto} usuario a
     * borrar
     * @param userRequest Recibe un {@link ar.com.smartprice.dtos.UserDto}
     * usuario que realizar la operacion
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
     * @param credentials Recibe un
     * {@link ar.com.smartprice.dtos.CredentialsDto} credentials
     * @return Retorna un {@link ar.com.smartprice.dtos.UserDto}
     */
    //authentication
    public static UserDto logIn(CredentialsDto credentials) {
        UserDto userdto;

        if (credentials.getEmail() == null || credentials.getPassword() == null
                || credentials.getEmail().isEmpty() || credentials.getPassword().isEmpty()) {
            return null;
        }

        Users_DBAdmin usersDb = new Users_DBAdmin();

        Usuario user = usersDb.getUsuarioByEmail(credentials.getEmail());

        //??
        //Oferente user = usersDb.getByEmail(credentials.getEmail());
        if (user == null) {
            userdto = new UserDto();
            userdto.setError(new SPError("Usuario sin datos."));
        } 
        //verifico si el usuario esta habilitado
        else if (!user.getActivo()) {
           
            userdto = new UserDto();
            userdto.setError(new SPError("Usuario inhabilitado."));
        }
        //comparo passwords
        else if (!user.getPassword().equals(Cryptography.encrypt(credentials.getPassword(), credentials.getEmail()))) {
            userdto = new UserDto();
            userdto.setError(new SPError("Correo o contraseña incorrectos."));
        } else {
            //mapper Usuario to UserDto

            userdto = Mapper.UsuarioToUserDto(user);

            //crear token para el usuario
            userdto.setToken(Authentication.createToken(userdto));
        }
        return userdto;
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
