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
    private String pass;
    private int userType;
    private int userId;
    private SPError error;
    private String token;

    public UserDto(){
        
    }
    
    public UserDto(String name, String lastName, String email, String cuit, String businessName, String pass, int userType, int userId, SPError error, String token) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.cuit = cuit;
        this.businessName = businessName;
        this.pass = pass;
        this.userType = userType;
        this.userId = userId;
        this.error = error;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public SPError getError() {
        return error;
    }

    public void setError(SPError error) {
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}
