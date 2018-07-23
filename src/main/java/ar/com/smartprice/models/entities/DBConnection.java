/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class DBConnection {
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("SmartPricePU");
    private static EntityManager em = null;
    
    public EntityManager getEm(){
        if (em==null){
            em= EMF.createEntityManager();
        }
        return em;
    }
    
    public void close(){
        em.close();
        em=null;
    }
    // REVISAR EL TEMA DE LOS CLOSE Y QUE NO QUEDEN SESIONES ABIERTAS
}
