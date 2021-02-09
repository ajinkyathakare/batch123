package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Client;

@Repository
public class DaoImpl implements DaoInterf {

	@Autowired
	private SessionFactory sf;
	@Override
	public int addClientData(Client client) 
	{
		Session session=sf.openSession();
		session.save(client);
		session.beginTransaction().commit();
		System.out.println("Data Insert Succesfully");
		
		
		return client.getId();
	}
	@Override
	public List<Client> displayAllData(String username, String password) {
		Session session=sf.openSession();
		if(username.equals("admin")&&password.equals("admin"))
		{
			List<Client> clist=session.createQuery("from Client").getResultList();
			return clist;
		}
		else
		{
			Query<Client> query=session.createQuery("from Client where username=:username&& and password=:password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<Client> clist=query.getResultList();
			return clist;
		}
		
	}
	@Override
	public Client getSingleClient(int id) 
	{
		Session session=sf.openSession();
		Client c=session.get(Client.class, id);
		session.beginTransaction().commit();
		
		return c;
	}
	@Override
	public List<Client> updateClientData(Client client) 
	{
		Session session=sf.openSession();
		session.beginTransaction();
		session.update(client);
		session.getTransaction().commit();
		System.out.println("Data_update Succesfully");
		
		List<Client> clist=session.createQuery("from Client").getResultList();
		
		return clist;
	}
	@Override
	public List<Client> deleteClient(int id)
	{
		Session session=sf.openSession();
		session.beginTransaction();
		Client c=session.get(Client.class, id);
		session.delete(c);
		session.getTransaction().commit();
		System.out.println("Delete_client Succesfully");
		
		List<Client> clist=session.createQuery("from Client").getResultList();
		return clist;
	}

}
