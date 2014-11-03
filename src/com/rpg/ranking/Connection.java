/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpg.ranking;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class Connection {

    //nome da unidade de persistencia definia no persistence.xml
    private static final String UNIT_NAME = "RPGPU";

    private static EntityManagerFactory emf = null;

    private static EntityManager em = null;

    public Connection() {
        this.getEntityManager();
    }

    public static EntityManager getEntityManager() {

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(UNIT_NAME);
        }

        if (em == null) {
            em = emf.createEntityManager();
        }

        return em;
    }

    public static EntityManagerFactory getFactory() {
        return Connection.getEntityManager().getEntityManagerFactory();
    }
}
