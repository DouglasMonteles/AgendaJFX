package com.doug.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.doug.agenda.model.TypeContact;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TypeContactDao {
	
	private ObservableList<TypeContact> obsTypesContacts = FXCollections.observableArrayList();
	
	public List<TypeContact> findAll(String description) {
		List<TypeContact> typesOfContacts = new ArrayList<>();
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			if (description.length() == 0) {
				String query = "SELECT tc FROM TypeContact tc";
				
				typesOfContacts = manager.createQuery(query, TypeContact.class)
						.getResultList();
			} else {
				String query = "SELECT tc FROM TypeContact tc "
						+ "WHERE tc.description LIKE " 
						+ "'" + description + "%'";
				
				typesOfContacts = manager.createQuery(query, TypeContact.class)
						.getResultList();
			}
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("Error in findAll of TypeContact: " + e.getMessage());
		} finally {
			manager.close();
		}
		
		return typesOfContacts;
	}
	
	public ObservableList<TypeContact> findAll() {
		List<TypeContact> typesOfContacts = new ArrayList<TypeContact>();
		
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			String query = "SELECT tc FROM TypeContact tc";
			
			typesOfContacts = manager.createQuery(query, TypeContact.class)
					.getResultList();
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			System.out.println("Error in comboBox of TypeContact: " + e.getMessage());
		} finally {
			manager.close();
		}
		
		typesOfContacts.forEach(obsTypesContacts::add);
		
		return obsTypesContacts;
	}

	public boolean save(TypeContact tc) {
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			manager.merge(tc); // salva ou atualiza: se tive id � atualizado
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			System.out.println("Error in save of TypeContact: " + e.getMessage());
			return false;
		} finally {
			manager.close();
		}
		
		return true;
	}
	
	public void delete(TypeContact tc) {
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			tc = manager.find(TypeContact.class, tc.getId());
			manager.remove(tc);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			System.out.println("Error in delete of TypeContact: " + e.getMessage());
		} finally {
			manager.close();
		}
	}
	
}
