package ar.com.smartprice.models.services;

import ar.com.smartprice.dtos.AdministratorDto;
import ar.com.smartprice.dtos.CredentialsDto;
import ar.com.smartprice.dtos.TokenInfoDto;
import ar.com.smartprice.models.entities.Administradores;
import ar.com.smartprice.models.mappers.AdministratorMapper;
import ar.com.smartprice.models.persistence.Administrator_DBAdmin;
import ar.com.smartprice.utils.Authentication;
import ar.com.smartprice.utils.Cryptography;

/**
 * Clase Servicio Administradores las operacion con la base de datos de la tabla
 * Administradores
 *
 * @author Andres
 * @version 0.1
 */
public class AdministratorService{

    private static final Administrator_DBAdmin ADMINISTRATORDB = new Administrator_DBAdmin();

    /**
     * Servicio de creacion de un administrador en la base de datos
     *
     * @param admin Recibe un AdministradorDto para crear en la base de datos
     * @param requester Recibe un AdministradorDto el cual realiza el pedido de creacion *REQUERIDO*
     * @return boolean true si pudo registrar el Administrador, en caso
     * contrario false;
     */
    public boolean create(AdministratorDto admin, AdministratorDto requester) {
        boolean success = false;

        if (requester == null || !Authentication.verifyAdministrator(requester)) {
            System.out.println("requester invalido");
            return success;
        }
        if (admin == null || admin.getEmail() == null || admin.getPassword() == null || admin.getName() == null) {
            System.out.println("Datos requeridos incompletos null");
            return success;
        }
        if (admin.getEmail().isEmpty() || admin.getPassword().isEmpty() || admin.getName().isEmpty()) {
            System.out.println("Datos requeridos incompletos");
            return success;
        }
        if (getAdministratorByEmail(admin.getEmail(), requester) != null) {
            System.out.println("Administrador ya existe");
            return success;
        }

        admin.setPassword(Cryptography.encrypt(admin.getPassword(), admin.getEmail()));

        return ADMINISTRATORDB.create(AdministratorMapper.AdministratorDtoToAdministrador(admin));
    }

    public boolean update(AdministratorDto admin, AdministratorDto requester) {
        boolean success = false;

        // verifica que el admin no sea null y que tenga los datos principales
        // verificar si el requester es null en ese caso verificar el token del admin
        // en caso contrarion verificar el token del requester
        //realizar el update
        //fin
        
        if (admin == null || admin.getEmail() == null || admin.getPassword() == null || admin.getName() == null) {
            return success;
        }
        if (admin.getEmail().isEmpty() || admin.getPassword().isEmpty() || admin.getName().isEmpty()) {
            return success;
        }
        
        if (requester == null || !Authentication.verifyAdministrator(requester)) {
            System.out.println("requester invalido");
            return success;
        }
        
        return success;
    }

    public void delete(AdministratorDto admin, AdministratorDto requester) {
    }

    /**
     * Servicio de autenticacion de Administradores.
     *
     * @param credentials Recibe un {@link ar.com.smartprice.dtos.CredentialsDto}
     * @return Retorna un {@link ar.com.smartprice.dtos.AdministratorDto} logueado
     */
    //authentication
    public AdministratorDto logIn(CredentialsDto credentials) {
        if (credentials.getEmail() == null
                || credentials.getPassword() == null
                || credentials.getEmail().isEmpty()
                || credentials.getPassword().isEmpty()) {

            return null;
        }

        Administradores admin = ADMINISTRATORDB.getAdministratorByEmail(credentials.getEmail());
        if (admin == null || !admin.getActivo()) {
            System.out.println("Administrador sin datos o desactivado.");
            return null;
        } else if (!admin.getPassword().equals(Cryptography.encrypt(credentials.getPassword(), credentials.getEmail()))) {
            System.out.println("Contraseña incorrecta.");
            return null;
        }

        System.out.println("Ususario logeado correctamente.");

        AdministratorDto administrator = AdministratorMapper.AdministradorToAdministratorDto(admin);

        administrator.setUserType(1);

        //crear token para el Administrador
        administrator.setToken(Authentication.createToken(administrator));
        System.out.println("Admin loged " + administrator.toString());
        return administrator;

    }

    /**
     * Servicio de cierre de session de un Administrador.
     *
     * @return 
     */
    public AdministratorDto logOut() {
        return null;
    }

    public void setActive(Administradores admin, AdministratorDto requester) {
    }

    public void setInactive(Administradores admin, AdministratorDto requester) {
    }

    public void getAll(AdministratorDto requester) {
    }

    public void getAllActive(AdministratorDto requester) {
    }

    public void getAllInactive(AdministratorDto requester) {
    }

    public void getAdministratorById(int id, AdministratorDto requester) {
    }

    public AdministratorDto getAdministratorByEmail(String email, AdministratorDto requester) {

        Administradores admin = ADMINISTRATORDB.getAdministratorByEmail(email);
        if (admin == null) {
            return null;
        }

        return AdministratorMapper.AdministradorToAdministratorDto(admin);
    }

    public void getAdministratorByName(String name, AdministratorDto requester) {
    }

    public void getAmountOfAdministrators(AdministratorDto requester) {
    }
}
