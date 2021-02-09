package com.Dao;

import java.util.List;

import com.Model.Employee;

public interface DaoInterf 
{
	public int addEmployee(Employee employee);
	
	public List<Employee> viewAllData(String username,String password);
	
	public Employee getSingleEmployee(int id);
	
	public List<Employee> updateData(Employee employee);

	public List<Employee> deleteEmployeeData(int id);
}
