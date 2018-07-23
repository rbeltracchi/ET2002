package ar.com.smartprice.models.mappers;

import ar.com.smartprice.dtos.UserDto;
import ar.com.smartprice.models.entities.Oferente;
import ar.com.smartprice.models.entities.Usuario;

/**
 * Clase mapeadora de Entidades a Dtos
 * Usuario a UserDto
 * UserDto a Usuario
 * @author Andres
 */
public class UsersMapper {
    /**
     * Mapea los datos de un Usuario a UserDto
     * @param user Usuario
     * @return UserDto 
     */
    public static UserDto UsuarioToUserDto(Usuario user) {
        UserDto userdto = new UserDto();

        userdto.setId(user.getIdUsuario());
        userdto.setEmail(user.getEmail());
        userdto.setPassword(user.getPassword());
        

        switch (user.getType()) {
            case "Usuario":
                userdto.setUserType(2);
                break;
            case "Oferente":
                Oferente o = (Oferente) user;
                userdto.setUserType(3);
                userdto.setBusinessName(o.getRazonSocial());
                userdto.setCuit(String.valueOf(o.getCuit()));
                userdto.setName(o.getNombre());
                userdto.setDireccion(o.getDireccion());
                break;
        } 
        return userdto;
    }
    /**
     * Mapea los datos de un UserDto a Usuario
     * @param user UserDto
     * @return Usuario
     */
    public static Usuario userDtoToUsuario(UserDto user) {
        Usuario usuario = null;

        switch (user.getUserType()) {
            case 2:
                usuario =  new Usuario();
                usuario.setIdUsuario(user.getId());
                usuario.setEmail(user.getEmail());
                usuario.setPassword(user.getPassword());

                break;
            case 3:
                user.toString();
                usuario =  new Oferente(user.getEmail(), user.getPassword(), user.getName(), Long.parseLong(user.getCuit()), user.getBusinessName(), user.getDireccion(), 111111111);
                usuario.setIdUsuario(user.getId());
                usuario.toString();
                break;
        }
        return usuario;
    }
}
