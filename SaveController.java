package com.bankonet.spring;

import javax.annotation.Resource;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankonet.metier.IClientMetier;
import com.bankonet.model.Client;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SaveController {

	@Resource(name = "metier")
	private IClientMetier icm;

//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public String saveClient(@Valid Client c, BindingResult bindingResult, Model model) {
//
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("listClients", icm.listClients());
//			return "/";
//		}
//
//		icm.addClient(c);
//		
//		
//		
//	}

}