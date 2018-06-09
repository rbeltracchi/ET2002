/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.dtos;

import ar.com.smartprice.utils.SPError;

/**
 *
 * @author Andres
 */
public class TokenInfoDto{

    private int userId;
    private String email;
    private int userType;
    private SPError error;

    public TokenInfoDto() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public SPError getError() {
        return error;
    }

    public void setError(SPError error) {
        this.error = error;
    }
}
