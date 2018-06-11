/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.dtos;

import ar.com.smartprice.utils.SPError;

/**
 *
 * @author Ezequiel
 */
public class UserDto {
    
    private String name;
    private String lastName;
    private String email;
    private String cuit;
    private String businessName;
    private String password;
    private int userType;
    private int userId;
    private SPError error;
    private String token;

    public UserDto(){
        
    }
    
    public UserDto(String name, String lastName, String email, String cuit, String businessName, String password, int userType, int userId, SPError error, String token) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.cuit = cuit;
        this.businessName = businessName;
        this.password = password;
        this.userType = userType;
        this.userId = userId;
        this.error = error;
        this.token = token;
    }
    
    /**
     * @author Andres 
     * @return Retorna un {@code String} con el nombre del usuario oferente.
     */
    public String getName() {
        return name;
    }
    /**
     * @author Andres
     * @param  name
     *         Recibe un {@code String} para setear el nombre a usuario oferente. 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @author Andres 
     * @return Retorna un {@code String} con el apellido de un usuario oferente
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @author Andres
     * @param  lastName
     *         Recibe un {@code String} para setear el apellido a usuario oferente.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * @author Andres 
     * @return Retorna un {@code String} con el correo de un usuario.
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * @author Andres
     * @param  email
     *         Recibe un {@code String} para setear el correo a usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @author Andres 
     * @return Retorna un {@code String} con el cuit de un usuario oferente.
     */
    public String getCuit() {
        return cuit;
    }

    /**
     * @author Andres
     * @param  cuit
     *         Recibe un {@code String} para setear el cuit al usuario oferente.
     */
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    /**
     * @author Andres 
     * @return Retorna un {@code String} con la razon social de un usuario oferente.
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * @author Andres
     * @param  businessName
     *         Recibe un {@code String} para setear la razon social al usuario oferente.
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    
    /**
     * @author Andres 
     * @return Retorna un {@code String} con la contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @author Andres
     * @param  password
     *         Recibe un {@code String} para setear la contraseña al usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @author Andres
     * @return  Retorna un {@code int} con el numero de tipo de usuario.
     * <p>1- administrador
     * <p>2- consumidor
     * <p>3- oferente
     */
    public int getUserType() {
        return userType;
    }

    /**
     * @author Andres
     * @param  userType
     *         Recibe un {@code int} para setear el numero de tipo al usuario.
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

    /**
     * @author Andres
     * @return  Retorna un {@code int} con el numero de id del usuario.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @author Andres
     * @param  userId
     *         Recibe un {@code int} para setear el numero de id al usuario.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    /**
     * @author Andres
     * @return  Retorna un {@link ar.com.smartprice.utils.SPError}.
     */
    public SPError getError() {
        return error;
    }

    /**
     * @author Andres
     * @param  error
     *         Error tipo {@link ar.com.smartprice.utils.SPError}
     */
    public void setError(SPError error) {
        this.error = error;
    }

     /**
     * @author Andres 
     * @return Retorna un {@code String} con el token del usuario.
     */
    public String getToken() {
        return token;
    }

    /**
     * @author Andres
     * @param  token
     *         Recibe un {@code String} para setear el token al usuario.
     */
    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}
