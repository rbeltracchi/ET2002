package ar.com.smartprice.dtos;

import java.util.List;

/**
 *
 * @author Andres
 */
public class AdministratorDto extends UserDto{

    private int userType;
    private int id;
    private boolean active;
    private String email;
    private String name;
    private String password;
    private String token;
    
    public AdministratorDto() {
    }

    @Override
    public int getUserType() {
        return userType;
    }

    @Override
    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AdministratorDto{" + "userType=" + userType + ", id=" + id + ", active=" + active + ", email=" + email + ", name=" + name + ", password=" + password + ", token=" + token + '}';
    }
}
