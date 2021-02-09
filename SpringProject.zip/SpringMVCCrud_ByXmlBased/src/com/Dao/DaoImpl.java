package com.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Model.Employee;

@Repository
public class DaoImpl implements DaoInterf 
{
	@Autowired
	private SessionFactory sf;

	@Override
	public int addEmployee(Employee employee) 
	{
		Session session=sf.openSession();
		session.save(employee);
		session.beginTransaction().commit();
		System.out.println("Data__Insert Succesfully");
		return employee.getId();
	}

	@Override
	public List<Employee> viewAllData(String username, String password) {
		Session session=sf.openSession();
		if(username.equals("admin")&&password.equals("admin"))
		{
			List<Employee> elist=session.createQuery("from Employee").getResultList();
			return elist;
		}
		else
		{
			Query<Employee> query=session.createQuery("from Employee where username= : username and password= :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<Employee> elist=query.getResultList();
			return elist;
		}
		
	}

	@Override
	public Employee getSingleEmployee(int id) {
		Session session=sf.openSession();
		Employee e=session.get(Employee.class, id);
		return e;
	}

	@Override
	public List<Employee> updateData(Employee employee) {
		System.out.println("InDao___Impl layer");
		Session session1=sf.openSession();
		session1.beginTransaction();
		session1.update(employee);
		session1.getTransaction().commit();
		System.out.println("Data Update Succesfully");
		
		List<Employee> elist=session1.createQuery("from Employee").getResultList();
		return elist;
	}

	@Override
	public List<Employee> deleteEmployeeData(int id) {
		Session session=sf.openSession();
		session.beginTransaction();
		Employee e=session.get(Employee.class, id);
		session.delete(e);
		session.getTransaction().commit();
		System.out.println("Data Delte Succesfully");
		
		List<Employee> elist=session.createQuery("from Employee").getResultList();
		return elist;
	}
	

}
