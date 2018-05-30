
package ar.com.smartprice.utils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Andres
 * @version 0.1.0
 */
public class Cryptography {
    
    /**
     * Encripta una cadena de texto usando el algoritmo SHA-2 512 a su vez se le
     * añade un salt para hacer mas complejo el encriptado.
     *
     * @param passwordToHash String a convertirse en contraseña
     * @param salt String que se complementa a la contraseña para que si dos
     * usuarios generan una misma contraseña su hash no sea identico, o evitar
     * que pueda ser buscada en una tabla "rainbow".
     * @return devuelve un String de 128 caracteres que conforma la contraseña
     * encriptada
     */
    
    public static String encrypt(String passwordToHash, String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
