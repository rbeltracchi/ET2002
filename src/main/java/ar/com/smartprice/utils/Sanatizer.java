/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Andres
 * @version 0.1.0 Clase encargada de sanatizar datos ingresados por los usuarios
 *
 */
public class Sanatizer {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * @author Andres
     * @version 0.1.0 Metodo que verifica si es String ingresado corresponde al
     * formato de un email
     * @param emailStr String email a verificar
     * @return boolean retorna true si corresponde al formato de un email
     *
     */
    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

}
