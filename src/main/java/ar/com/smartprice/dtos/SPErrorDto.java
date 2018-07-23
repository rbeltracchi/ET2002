
package ar.com.smartprice.dtos;

/**
 *
 * @author ze
 */
public class SPErrorDto {

    private String message;

    public SPErrorDto() {
    }

    public SPErrorDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SPError{" + "message=" + message + '}';
    }
}
