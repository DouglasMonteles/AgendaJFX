package com.doug.agenda.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.doug.agenda.model.City;
import com.doug.agenda.model.Contact;
import com.doug.agenda.model.TypeContact;

public class ContactDao {
	
	public boolean save(Contact c) {
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			var ct = manager.getReference(City.class, c.getCity().getId());
			var tc = manager.getReference(TypeContact.class, c.getTypeContact().getId());
			
			c.setCity(ct);
			c.setTypeContact(tc);
			
			manager.persist(c);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			System.out.println("Error in save of Contact: " + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			manager.close();
			DatabaseConnection.closeConnection();
		}
		
		return true;
	}
	
	public boolean update(Contact contact) {
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			manager.merge(contact);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			System.out.println("Error in update of Contact: " + e.getMessage());
		} finally {
			manager.close();
			DatabaseConnection.closeConnection();
		}
		
		return false;
	}
	
}
