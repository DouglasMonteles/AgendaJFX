package com.doug.agenda.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseConnection {
	
	private static final String PERSISTENCE_UNIT_NAME = "agedaJFX";
	
	private static EntityManagerFactory connection;
	
	public static EntityManager openConnection() {
		try {
			if (connection == null) {
				connection = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			}
			
			return connection.createEntityManager();
		} catch (Exception e) {
			System.out.println("Open connection error: " + e.getMessage());
		}
		
		return null;
	}
	
}
