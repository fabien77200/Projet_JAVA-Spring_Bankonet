package com.bankonet.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.dao.IClientDao;
import com.bankonet.model.Client;

@Service("metier")
@Transactional (readOnly = true)
public class BankonetMetier implements IClientMetier{

	@Resource(name="dao")
	private IClientDao icd;

	public BankonetMetier() {
		super();
	}

	public BankonetMetier(IClientDao icd) {
		super();
		this.icd = icd;
	}
	
	
	public IClientDao getIcd() {
		return icd;
	}


	public void setIcd(IClientDao icd) {
		this.icd = icd;
	}

	@Transactional(rollbackFor=Exception.class)
	public void addClient(Client c) /*throws Exception*/{
	
		icd.addClient(c);
	}


	@Transactional(readOnly=true)
	public List<Client> listClients() {
		return icd.listClients();
	}

	@Transactional
	public void deleteClient(int idClient) {
		
//		for(Client c: icd.chercherClients(idClient)){
//			icd.deleteClient(idClient);
//		}
		icd.deleteClient(idClient);
		
	}

	@Transactional(readOnly=true)
	public Client editClient(int idClient) {
		return icd.editClient(idClient);
	}

	@Transactional
	public void updateClient(Client c) {
		icd.updateClient(c);
		
	}

	@Transactional(readOnly=true)
	public List<Client> chercherClients(String motCle) {
		
		return icd.chercherClients(motCle);
	}

}
