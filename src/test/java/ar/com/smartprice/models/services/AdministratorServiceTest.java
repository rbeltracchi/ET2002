/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.services;

import ar.com.smartprice.dtos.AdministratorDto;
import ar.com.smartprice.dtos.CredentialsDto;
import ar.com.smartprice.models.entities.Administradores;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andres
 */
public class AdministratorServiceTest {

    public AdministratorServiceTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class AdministratorService.
     */
    //@Test //Passed!
    public void testCreate() {
        System.out.println("create");
        AdministratorService adminService = new AdministratorService();
        AdministratorDto admin = new AdministratorDto();
        admin.setEmail("lucho");
        admin.setName("lucho");
        admin.setPassword("lucho");
        
        CredentialsDto credentials = new CredentialsDto("martin", "martin");
        AdministratorDto requester = adminService.logIn(credentials);
        
        boolean expResult = true;
        boolean result = adminService.create(admin, requester);
        assertEquals(expResult, result);

    }

    /**
     * Test of update method, of class AdministratorService.
     */
    //@Test
    public void testUpdate() {
        System.out.println("update");
        AdministratorService adminService = new AdministratorService();
        AdministratorDto admin = null;
        AdministratorDto requester = null;
        adminService.update(admin, requester);
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class AdministratorService.
     */
    //@Test
    public void testDelete() {
        System.out.println("delete");
        AdministratorService adminService = new AdministratorService();
        AdministratorDto admin = null;
        AdministratorDto requester = null;
        adminService.delete(admin, requester);
        fail("The test case is a prototype.");
    }

    /**
     * Test of logIn method, of class AdministratorService.
     */
    //@Test
    public void testLogIn() {
        System.out.println("logIn");
        AdministratorService adminService = new AdministratorService();
        AdministratorDto requester = null;
        //AdministratorService.logIn(requester);
        fail("The test case is a prototype.");
    }

    /**
     * Test of logOut method, of class AdministratorService.
     */
    //@Test
    public void testLogOut() {
        System.out.println("logOut");
        AdministratorDto admin = new AdministratorDto();
        admin.setEmail("lucho");
        admin.setName("lucho");
        admin.setPassword("lucho");
        AdministratorService adminService = new AdministratorService();
        AdministratorDto requester = null;
        adminService.logOut();
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActive method, of class AdministratorService.
     */
    //@Test
    public void testSetActive() {
        System.out.println("setActive");
        AdministratorService adminService = new AdministratorService();
        Administradores admin = null;
        AdministratorDto requester = null;
        adminService.setActive(admin, requester);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInactive method, of class AdministratorService.
     */
    //@Test
    public void testSetInactive() {
        System.out.println("setInactive");
        AdministratorService adminService = new AdministratorService();
        Administradores admin = null;
        AdministratorDto requester = null;
        adminService.setInactive(admin, requester);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class AdministratorService.
     */
    //@Test
    public void testGetAll() {
        System.out.println("getAll");
        AdministratorService adminService = new AdministratorService();
        AdministratorDto requester = null;
        adminService.getAll(requester);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllActive method, of class AdministratorService.
     */
    //@Test
    public void testGetAllActive() {
        System.out.println("getAllActive");
        AdministratorService adminService = new AdministratorService();
        AdministratorDto requester = null;
        adminService.getAllActive(requester);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllInactive method, of class AdministratorService.
     */
    //@Test
    public void testGetAllInactive() {
        System.out.println("getAllInactive");
        AdministratorService adminService = new AdministratorService();
        AdministratorDto requester = null;
        adminService.getAllInactive(requester);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdministratorById method, of class AdministratorService.
     */
    //@Test
    public void testGetAdministratorById() {
        System.out.println("getAdministratorById");
        AdministratorService adminService = new AdministratorService();
        int id = 0;
        AdministratorDto requester = null;
        adminService.getAdministratorById(id, requester);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdministratorByEmail method, of class AdministratorService.
     */
    //@Test
    public void testGetAdministratorByEmail() {
        System.out.println("getAdministratorByEmail");
        AdministratorService adminService = new AdministratorService();
        String email = "";
        AdministratorDto requester = null;
        AdministratorDto expResult = null;
        AdministratorDto result = adminService.getAdministratorByEmail(email, requester);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdministratorByName method, of class AdministratorService.
     */
    //@Test
    public void testGetAdministratorByName() {
        System.out.println("getAdministratorByName");
        AdministratorService adminService = new AdministratorService();
        String name = "";
        AdministratorDto requester = null;
        adminService.getAdministratorByName(name, requester);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmountOfAdministrators method, of class AdministratorService.
     */
    //@Test
    public void testGetAmountOfAdministrators() {
        System.out.println("getAmountOfAdministrators");
        AdministratorService adminService = new AdministratorService();
        AdministratorDto requester = null;
        adminService.getAmountOfAdministrators(requester);
        fail("The test case is a prototype.");
    }

}
