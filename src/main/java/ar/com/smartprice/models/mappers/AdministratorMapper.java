
package ar.com.smartprice.models.mappers;

import ar.com.smartprice.dtos.AdministratorDto;
import ar.com.smartprice.models.entities.Administradores;

/**
 * Mapeador de clases Administrador y AdministratorDto
 *
 * @author Andres
 * @version 0.1
 */
public class AdministratorMapper {

    /**
     * Realizar un mapeo de valores Administradores a AdministratorDto
     *
     * @param admin recibe un objeto Administradores
     * @return un objeto AdministratorDto
     */
    public static AdministratorDto AdministradorToAdministratorDto(Administradores admin) {
        AdministratorDto mapped = new AdministratorDto();
        mapped.setId(admin.getIdadministradores());
        mapped.setActive(admin.getActivo());
        mapped.setEmail(admin.getEmail());
        mapped.setName(admin.getNombre());
        mapped.setPassword(admin.getPassword());
        return mapped;
    }

    /**
     * Realizar un mapeo de valores AdministratorDto a Administradores
     *
     * @param admin recibe un objeto AdministratorDto
     * @return un objeto Administradores
     */
    public static Administradores AdministratorDtoToAdministrador(AdministratorDto admin) {
        Administradores mapped = new Administradores();
        mapped.setIdadministradores(admin.getId());
        mapped.setActivo(admin.getActive());
        mapped.setEmail(admin.getEmail());
        mapped.setNombre(admin.getName());
        mapped.setPassword(admin.getPassword());
        return mapped;
    }

}
