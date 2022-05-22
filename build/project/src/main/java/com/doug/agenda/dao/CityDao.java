package com.doug.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.doug.agenda.model.Contact;

public class CityDao {

	public static boolean freeDelete(Long id) {
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		List<Contact> contacts = new ArrayList<>();
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			String query = "FROM Contact c WHERE c.city.id = " + id;
			
			contacts = manager.createQuery(query, Contact.class).getResultList();
			
			transaction.commit();
			
			if (contacts.isEmpty()) {
				return true;
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			System.out.println("Erro in freeDelete of CityDao: " + e.getMessage());
		} finally {
			manager.close();
			DatabaseConnection.closeConnection();
		}
		
		return false;
	}
	
}
