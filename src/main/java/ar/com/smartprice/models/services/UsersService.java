package ar.com.smartprice.models.services;

import ar.com.smartprice.models.persistence.Users_DBAdmin;
import ar.com.smartprice.dtos.AdministratorDto;
import ar.com.smartprice.dtos.CredentialsDto;
import ar.com.smartprice.dtos.TokenInfoDto;
import ar.com.smartprice.dtos.UserDto;
import ar.com.smartprice.models.entities.Usuario;
import ar.com.smartprice.utils.Authentication;
import ar.com.smartprice.utils.Cryptography;
import ar.com.smartprice.models.mappers.UsersMapper;
import ar.com.smartprice.dtos.SPErrorDto;

/**
 * @author Andres
 * @version 0.1.0
 *
 * Servicios de usuarios
 */
public class UsersService {
    private static Users_DBAdmin userDB= new Users_DBAdmin();
    

    public UsersService() {
    }
    
    
    
    /**
     * Servicio para la creacion de un usuario.
     *
     * @param user UserDto
     * @return
     */
    public boolean create(UserDto user) {

        boolean success = false;

        //controlar que este todo completo
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return success;
        }
        //Encriptamos la contraseña del usuario
        user.setPassword(Cryptography.encrypt(user.getPassword(), user.getEmail()));

        Usuario usuario = UsersMapper.userDtoToUsuario(user);
        
        success = userDB.insertarUsuario(usuario);
       
        return success;
    }

    /**
     * Servicio para eliminar un usuario.
     *
     * @param user UserDto es el usuario a borrar
     * @return
     *
     */
    public boolean delete(UserDto user) {
        boolean success = false;

        if (user == null || user.getToken().isEmpty() || user.getToken() == null) {
            return success;
        }

        TokenInfoDto tokendata = Authentication.getTokenInfo(user.getToken());
        if (tokendata == null) {
            return success;
        }

        if (user.getId() != tokendata.getUserId()) {
            System.out.println("[UsersService]El id del usuario no coinciden con el id del token");
            return success;
        }

        Usuario usuario = UsersMapper.userDtoToUsuario(user);
        System.out.println("[USER SERVICE DELETE] "+ usuario.toString());
        

        success = userDB.borrarUsuario(usuario);

        return success;
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
    public boolean delete(UserDto user, AdministratorDto userRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Servicio para actualizar datos de un usuario.
     *
     * @param user UserDto
     * @return
     *
     */
    public boolean update(UserDto user) {

        boolean success = false;

        if (user == null || user.getToken().isEmpty() || user.getToken() == null) {
            return success;
        }

        TokenInfoDto tokendata = Authentication.getTokenInfo(user.getToken());
        if (tokendata == null) {
            return success;
        }
               
        if (user.getId() != tokendata.getUserId()) {
            System.out.println("[UsersService]El id del usuario no coinciden con el id del token");
            return success;
        } else if (!user.getEmail().equals(tokendata.getEmail())) {
            System.out.println("[UsersService]El usuario no puede cambiar su email");
            return success;
        }

        

        // verificar si la contraseña cambio... si no cambio no tendriamos que re encriptarlo
        Usuario passwordMatch = userDB.getUsuarioByEmail(tokendata.getEmail());

        if (!passwordMatch.getPassword().equals(user.getPassword())) {
            user.setPassword(Cryptography.encrypt(user.getPassword(), user.getEmail()));
        }
        Usuario usuario = UsersMapper.userDtoToUsuario(user);

        switch (user.getUserType()) {
            case 2:
                success = userDB.actualizarUsuario(usuario);

                break;
            case 3:
                success = userDB.actualizarUsuario(usuario);
                System.out.println("[UsersService] La actualizacion del oferente no esta implementada");
                break;
        }

        return success;
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
        UserDto userdto = null;
        System.out.println(credentials.toString());
        if (credentials.getEmail() == null || credentials.getPassword() == null
                || credentials.getEmail().isEmpty() || credentials.getPassword().isEmpty()) {
            userdto = new UserDto();
            userdto.setError(new SPErrorDto("Faltan completar campos requeridos."));
            
        }

        Usuario user = null;
        user = userDB.getUsuarioByEmail(credentials.getEmail());
        if(user != null)
            System.out.println("[UsersService login] "+ user.toString() );
        
        //??
        //Oferente user = usersDb.getByEmail(credentials.getEmail());
        if (user == null) {
            userdto = new UserDto();
            userdto.setError(new SPErrorDto("Correo o contraseña incorrectos."));
            
            //return null;
        } //verifico si el usuario esta habilitado
         //comparo passwords
        else if (!user.getPassword().equals(Cryptography.encrypt(credentials.getPassword(), credentials.getEmail()))) {
            userdto = new UserDto();
            userdto.setError(new SPErrorDto("Correo o contraseña incorrectos."));
            
            //return null;
        }else if (!user.getActivo()) {

            userdto = new UserDto();
            userdto.setError(new SPErrorDto("Usuario inhabilitado/Borrado."));
            System.out.println("Usuario inhabilitado/Borrado.");
            //return null;
        } else {
            System.out.println("Ususario logeado correctamente.");
            //mapper Usuario to UserDto

            userdto = UsersMapper.UsuarioToUserDto(user);

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
    public static UserDto logOut(UserDto user) {
        return new UserDto();
        //user.setToken(null);
    }

    /**
     * Servicio de generacion de nueva contraseña cuando es olvidada por un
     * usuario.
     *
     * @param user UserDto usuario que quiere regenerar la contraseña
     */
    public static void passwordReset(UserDto user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
