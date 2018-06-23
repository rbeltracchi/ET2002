package ar.com.smartprice.utils;

import ar.com.smartprice.dtos.TokenInfoDto;
import ar.com.smartprice.dtos.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 * @version 0.1.0
 * Clase encargada de la autenticacion de usuarios
 * genera un token JWT encriptado a partir de datos obtenidos de
 * un objeto UserDto.
 * Verifica si el token no ha expirado o ha sido manipulado.
 * 
 */
public class Authentication {
    
    private final static String ULTRASECURITYKEY = "oWPVo5Je0nCm6D24ZcA0W3EX95kGLsFxK78v4rvn0jH8RYnhiFyxs55liBwzT1se";

    //7200000 son 2 horas en milisegundos
    private final static int EXPIRATIONTIMEMILLIS = 7200000;
    
    /**
     * Recibe un UserDto del cual obtiene su userId, email y userType y genera el token con tiempo de expiracion
     * @param user UserDto
     * @return String retorna el token generado
     *
     */
    public static String createToken(UserDto user){

        try {
            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);
            long expMillis = nowMillis + EXPIRATIONTIMEMILLIS;
            Date expiration = new Date(expMillis);
            
            return Jwts.builder()
                    .setId("" + user.getUserId())
                    
                    .setIssuedAt(now)
                    .setExpiration(expiration)
                    .claim("email", user.getEmail())
                    .claim("userType", ""+user.getUserType())
                    .signWith(
                            SignatureAlgorithm.HS256,
                            ULTRASECURITYKEY.getBytes("UTF-8")
                    )
                    .compact();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Verifica si el token es valido, si no ha expirado, en caso de exito retorna un TokenInfoDto
     * @param token recibe un String token a verificar
     * @return TokenInfoDto
     * 
     */
    public static TokenInfoDto getTokenInfo(String token) {
        TokenInfoDto response = new TokenInfoDto();
        try {
            String jwtr = token;
            Jws<Claims> claims = Jwts.parser().setSigningKey(ULTRASECURITYKEY.getBytes("UTF-8")).parseClaimsJws(jwtr);
            String email = (String) claims.getBody().get("email");
            String userId = (String) claims.getBody().getId();
            String userType = (String) claims.getBody().get("userType");
            
            //System.out.println("userId obtenidos del token:" + userId);
            //System.out.println("email obtenidos del token:" + email);
            //System.out.println("userType obtenidos del token:" + userType);
            
            response.setUserId(Integer.parseInt(userId));
            response.setEmail(email);
            response.setUserType(Integer.parseInt(userType));
            
            return response;
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExpiredJwtException ex) {
            System.out.println("El token ha expirado");
            response.setError(new SPError("El token ha expirado"));
        } catch (SignatureException ex) {
            System.out.println("El token ha sido adulterado");
            response.setError(new SPError("No se ha podido verificar el token"));
        }
        return null;
    }

}
