package com.doug.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ComboBoxGenericDao<T> {
	
	private ObservableList<T> obsList = FXCollections.observableArrayList();

	
	public ObservableList<T> findAll(Class<T> entity) {
		List<T> list = new ArrayList<>();
		
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			String query = "SELECT obj FROM " + entity.getName() + " obj";
			
			list = manager.createQuery(query, entity)
					.getResultList();
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			System.out.println("Error in comboBox of ComboBoxDao: " + e.getMessage());
		} finally {
			manager.close();
		}
		
		list.forEach(obsList::add);
		
		return obsList;
	}

}
