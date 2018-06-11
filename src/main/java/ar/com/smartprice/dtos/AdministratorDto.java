
package ar.com.smartprice.dtos;

import ar.com.smartprice.utils.SPError;

/**
 *
 * @author Andres
 */
public class AdministratorDto {
    
    private String email;
    private String password;
    private int userType;
    private int userId;
    private SPError error;
    private String token;

    public AdministratorDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
