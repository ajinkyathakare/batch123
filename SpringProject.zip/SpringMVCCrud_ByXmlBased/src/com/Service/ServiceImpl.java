package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.DaoInterf;
import com.Model.Employee;

@Service
public class ServiceImpl implements ServiceInterf
{
	@Autowired
	private DaoInterf d;

	@Override
	public int addEmployee(Employee employee) {
		
		return d.addEmployee(employee);
	}

	@Override
	public List<Employee> viewAllData(String username, String password) {
		
		return d.viewAllData(username, password);
	}

	@Override
	public Employee getSingleEmployee(int id) {
		
		return d.getSingleEmployee(id);
	}

	@Override
	public List<Employee> updateData(Employee employee) {
		
		return d.updateData(employee);
	}

	@Override
	public List<Employee> deleteEmployeeData(int id) {
		
		return d.deleteEmployeeData(id);
	}
	

}
