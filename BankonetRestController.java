package com.bankonet.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bankonet.metier.IClientMetier;
import com.bankonet.model.Client;

@Controller
@RequestMapping(value = "rest")

public class BankonetRestController {
	@Autowired
	IClientMetier icm;
	
	@RequestMapping(value = "/get/{mot}", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> getClients(@PathVariable("mot") String mot) {

		return icm.chercherClients(mot);
	}
	
	@RequestMapping(value="/getAll")
	@ResponseBody
	public List<Client> getAllClients(){
		return icm.listClients();
	}
	
	@RequestMapping(value="/addClient", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED) 
	@ResponseBody
	public void createClient(@RequestBody Client c1){
		icm.addClient(c1);
	}

	@RequestMapping(value="/updateClient", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateClient(@RequestBody Client c1){
		icm.updateClient(c1);
	}
	
	@RequestMapping(value = "deleteClient/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteClient(@PathVariable("id") int id){
		icm.deleteClient(id);
	}
	
	
	
}
