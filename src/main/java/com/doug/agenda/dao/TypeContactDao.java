package com.doug.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.doug.agenda.model.TypeContact;

public class TypeContactDao {
	
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
			System.out.println("Error findAll: " + e.getMessage());
		}
		
		return typesOfContacts;
	}

	public void save(TypeContact tc) {
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			manager.merge(tc); // salva ou atualiza: se tive id é atualizado
			
			transaction.commit();
			
			System.out.println("Tipo de Contato salvo com sucesso!");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
