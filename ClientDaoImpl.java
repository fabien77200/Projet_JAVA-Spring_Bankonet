package com.bankonet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.model.Client;

@Repository("dao")
public class ClientDaoImpl implements IClientDao {

	@PersistenceContext
	private EntityManager em = null;

	
	public void addClient(Client c) /*throws Exception*/ {
		em.persist(c);
//	throw new Exception("Erreur runtime unchecked");
	}


	public void deleteClient(int idClient) {
	
		Client c1 = em.find(Client.class, idClient);
		em.remove(c1);
	}



	public Client editClient(int idClient) {

		Client c1 = em.find(Client.class, idClient);
		return c1;
	}


	public void updateClient(Client c) {
		
		em.merge(c);		
	}



	public List<Client> listClients() {
		
		Query req = em.createQuery("select c from Client c", Client.class);
		
		return req.getResultList();
	}

	public List<Client> chercherClients(String motCle) {
		
		Query req = em.createQuery("select c from Client c where c.nom like :x or c.prenom like :x");

		req.setParameter("x", "%"+motCle+"%");
		
		
		return req.getResultList();

	}
	
}
