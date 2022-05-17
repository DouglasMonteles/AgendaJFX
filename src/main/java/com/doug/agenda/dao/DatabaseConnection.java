package com.doug.agenda.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseConnection {
	
	private static EntityManagerFactory connection;
	
	public static EntityManager openConnection() {
		try {
			if (connection == null) {
				connection = Persistence.createEntityManagerFactory("agedaJFX");
			}
			
			return connection.createEntityManager();
		} catch (Exception e) {
			System.out.println("Erro ao abrir conexão: " + e.getMessage());
		}
		
		return null;
	}
	
	public static void closeConnection() {
		if (connection != null) {
			connection.close();
		}
	}
	
}
