package com.doug.agenda.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.doug.agenda.model.TypeContact;

public class TypeContactDao {

	public void save(TypeContact tc) {
		EntityManager manager = DatabaseConnection.openConnection();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			manager.persist(tc); // salva ou atualiza: se tive id ele atualiza
			
			transaction.commit();
			
			System.out.println("Tipo de Contato salvo com sucesso!");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			manager.close();
			DatabaseConnection.closeConnection();
		}
	}
	
}
