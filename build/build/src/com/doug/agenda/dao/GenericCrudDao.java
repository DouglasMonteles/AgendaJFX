package com.doug.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.doug.agenda.model.City;

public class GenericCrudDao<T> {
	
	private Class<T> className;
	
	public GenericCrudDao(Class<T> className) {
		this.className = className;
	}
	
	public T findById(Object primaryKey) {
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		T entity = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			entity = manager.find(className, primaryKey);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			System.out.println("Error in findById: " + e.getMessage());
		} finally {
			manager.close();
			DatabaseConnection.closeConnection();
		}
		
		return entity;
	}

	public List<T> findAll(String description) {
		List<T> typesOfContacts = new ArrayList<>();
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			if (description.length() == 0) {
				String query = "SELECT obj FROM " + className.getName() + " obj";
				
				typesOfContacts = manager.createQuery(query, className)
						.getResultList();
			} else {
				String query = "SELECT obj FROM " + className.getName() + " obj "
						+ "WHERE obj.description LIKE " 
						+ "'" + description + "%'";
				
				typesOfContacts = manager.createQuery(query, className)
						.getResultList();
			}
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("Error in findAll: " + e.getMessage());
		} finally {
			manager.close();
			DatabaseConnection.closeConnection();
		}
		
		return typesOfContacts;
	}

	public boolean save(T entity) {
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			manager.merge(entity); // salva ou atualiza: se tive id é atualizado
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			System.out.println("Error in save: " + e.getMessage());
			return false;
		} finally {
			manager.close();
			DatabaseConnection.closeConnection();
		}
		
		return true;
	}
	
	public void delete(T entity, Object primaryKey) {
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			entity = manager.find(className, primaryKey);
			manager.remove(entity);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			System.out.println("Error in delete:" + e.getMessage());
		} finally {
			manager.close();
			DatabaseConnection.closeConnection();
		}
	}
	
}
