package com.bankonet.spring;

import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankonet.metier.IClientMetier;
import com.bankonet.model.Client;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BankonetController {
	
	@Resource(name="metier")
	private IClientMetier icm;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		model.addAttribute("client", new Client());
		model.addAttribute("listClients", icm.listClients());
		
		return "listeClients";
		
	}
	
	//Service ajout d'un client
	@RequestMapping(value = "/saveClient", method = RequestMethod.POST)
	public String saveClient(@Valid Client c, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			System.out.println("------------erreurs : "+bindingResult.toString());
			model.addAttribute("listClients", icm.listClients());
			return "listeClients";
		}

			System.out.println("------------pas erreur");
		
			if(c.getId()==0)
			icm.addClient(c);
			else
			icm.updateClient(c);
			
			model.addAttribute("client", new Client());
			model.addAttribute("listClients", icm.listClients());

		
		return "redirect:/spring/";
		
	}
	
	//Service merge
	@RequestMapping(value="/editClient/{id}")
	public String updateClient(@PathVariable(value="id")int id, Model model){

		
		Client c1 = icm.editClient(id);
		
		model.addAttribute("client", c1);
		model.addAttribute("listClients", icm.listClients());
		//model.addAttribute("mssg",String )
		return "listeClients";
	}
	
	
	
	//service delete
	@RequestMapping(value="/deleteClient")
	public String deleteClient(@RequestParam(value="id") int id, Model model){
			
		icm.deleteClient(id);

		model.addAttribute("client", new Client());
		model.addAttribute("listClients", icm.listClients());
		return "listeClients";
		
	}
	
	
	
}