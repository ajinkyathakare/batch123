package com.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Model.Employee;
import com.Service.ServiceInterf;


@Controller
public class MyController 
{
	@Autowired
	private ServiceInterf s;
	
	
	@RequestMapping("/reg")
	public String addEmployee(@ModelAttribute Employee employee)
	{
		System.out.println("Emloyee_Data : "+employee);
		int i=s.addEmployee(employee);
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
	public String viewAllData(@RequestParam("username") String un,@RequestParam("password") String ps,ModelMap m)
	{
		System.out.println("Login Credentials: "+un+" "+ps);
		List<Employee> list=s.viewAllData(un, ps);
		m.addAttribute("data",list);
		return "success";
		
	}
	@RequestMapping("/edit")
	public String editData(@RequestParam("rd") int rd,ModelMap m)
	{
		System.out.println("Id from Success Page: "+rd);
		Employee e=s.getSingleEmployee(rd);
		m.addAttribute("employee",e);
		return "edit";
		
	}
	
	@RequestMapping("/update")
	public String updateData(@ModelAttribute Employee employee,ModelMap m)
	{
		System.out.println("UpdateData from edit page: "+employee);
		List<Employee> elist=s.updateData(employee);
		m.addAttribute("data",elist);
		return "success";
		
	}
	@RequestMapping("/delete")
	public String deleteEmployeeData(@RequestParam("rd") int rd,ModelMap m)
	{
		System.out.println("Id from succes_page: "+rd);
		List<Employee> elist=s.deleteEmployeeData(rd);
		m.addAttribute("data",elist);
		return "success";
		
	}

}
