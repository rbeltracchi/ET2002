/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.services;

import ar.com.smartprice.models.Oferente;
import ar.com.smartprice.models.Usuario;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andres
 */
public class Users_DBAdminTest {

    public Users_DBAdminTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insertarUsuario method, of class Users_DBAdmin.
     */
    @Test
    public void testInsertarUsuario() {
        System.out.println("insertarUsuario");
        Usuario usr = new Usuario("test5@smartprice.com.ar", "test", null);
        Users_DBAdmin instance = new Users_DBAdmin();
        boolean expResult = true;
        boolean result = instance.insertarUsuario(usr);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarUsuario method, of class Users_DBAdmin.
     */
    @Test
    public void testBorrarUsuario() {
        System.out.println("borrarUsuario");
        Usuario usr = new Usuario("emailtest", "pepe", "nombre");
        Users_DBAdmin instance = new Users_DBAdmin();
        boolean expResult = true;
        boolean result = instance.borrarUsuario(usr);
        assertEquals(expResult, result);
    }

    /**
     * Test of reactivarUsuario method, of class Users_DBAdmin.
     */
    @Test
    public void testReactivarUsuario() {
        System.out.println("reactivarUsuario");
        Usuario usr = new Usuario("emailtest", "asd", "emailtest");
        Users_DBAdmin instance = new Users_DBAdmin();
        boolean expResult = true;
        boolean result = instance.reactivarUsuario(usr);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsuarioByEmail method, of class Users_DBAdmin.
     */
    @Test
    public void testGetUsuarioByEmail() {
        System.out.println("getUsuarioByEmail");
        String email = "emailtest";
        Users_DBAdmin instance = new Users_DBAdmin();
        Usuario expResult = new Usuario("emailtest", "passtest", "nombretest");
        expResult.setIdUsuario(2);
        Usuario result = instance.getUsuarioByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of actualizarUsuario method, of class Users_DBAdmin.
     */
    @Test
    public void testActualizarUsuario() {
        System.out.println("actualizarUsuario");
        Usuario user = new Usuario("test@smartprice.com.ar", "prueba", "juan");
        user.setIdUsuario(4);

        Users_DBAdmin instance = new Users_DBAdmin();
        boolean expResult = true;
        boolean result = instance.actualizarUsuario(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of cantOferentes method, of class Users_DBAdmin.
     */
    @Test
    public void testCantOferentes() {
        System.out.println("cantOferentes");
        Users_DBAdmin instance = new Users_DBAdmin();
        int expResult = 0;
        int result = instance.cantOferentes();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOferentes method, of class Users_DBAdmin.
     */
    @Test
    public void testGetOferentes() {
        System.out.println("getOferentes");
        Users_DBAdmin instance = new Users_DBAdmin();
        List<Oferente> expResult = null;
        List<Oferente> result = instance.getOferentes();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}
