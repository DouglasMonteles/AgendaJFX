package com.doug.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.doug.agenda.model.Contact;

public class TypeContactDao {
		
	public static boolean freeDelete(Long id) {
		List<Contact> contacts = new ArrayList<>();
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			String query = "FROM Contact c WHERE c.typeContact.id = " + id;
			contacts = manager.createQuery(query, Contact.class).getResultList();
			
			transaction.commit();
			
			if (contacts.isEmpty()) {
				return true;
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			System.out.println("Erro in freeDelete of TypeContactDao: " + e.getMessage());
		} finally {
			manager.close();
			DatabaseConnection.closeConnection();
		}
		
		return false;
	}
	
}
