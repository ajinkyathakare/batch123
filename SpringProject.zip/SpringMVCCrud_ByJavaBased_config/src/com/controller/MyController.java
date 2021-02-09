package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Client;
import com.service.ServiceInterf;

@Controller
public class MyController
{
	@Autowired 
	private ServiceInterf s;
	
	@RequestMapping("/")
	public String landingPage()
	{
		System.out.println("Landing__page Called");
		return "index";
	}
	
	@RequestMapping("/reg")
	public String addClientData(@ModelAttribute Client client)
	{
		System.out.println("ClientData: "+client);
		int i=s.addClientData(client);
		if(i>0)
		{
			return "index";
		}
		else
		{
			return "register";
		}
		
	}
	
	@RequestMapping("/log")
	public String DisplayAllData(@RequestParam("username") String uname,@RequestParam("password") String pass,ModelMap m )
	{
		System.out.println("From_login: "+uname+" "+pass);
		List<Client> clist=s.displayAllData(uname, pass);
		m.addAttribute("data",clist);
		return "success";
		
	}
	
	@RequestMapping("/edit")
	public String getSingleClient(@RequestParam("rd") int rd,ModelMap m)
	{
		System.out.println("from_succespage_"+rd);
		Client c=s.getSingleClient(rd);
		m.addAttribute("client",c);
		return "edit";
		
	}
	
	@RequestMapping("/update")
	public String updateData(@ModelAttribute Client client,ModelMap m)
	{
		System.out.println("ClientData: "+client);
		List<Client> clist=s.updateClientData(client);
		m.addAttribute("data",clist);
		return "success";
		
	}
	
	@RequestMapping("/delete")
	public String deleteData(@RequestParam("rd") int rd,ModelMap m)
	{
		System.out.println("DeleteData: "+rd);
		List<Client> clist=s.deleteClient(rd);
		m.addAttribute("data",clist);
		return "success";
	
	}
}
