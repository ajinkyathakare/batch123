package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DaoInterf;
import com.model.Client;

@Service
public class ServiceImpl implements ServiceInterf {

	@Autowired
	private DaoInterf d;
	@Override
	public int addClientData(Client client) {
		
		return d.addClientData(client);
	}
	@Override
	public List<Client> displayAllData(String username, String password) {
		
		return d.displayAllData(username, password);
	}
	@Override
	public Client getSingleClient(int id) {
		
		return d.getSingleClient(id);
	}
	@Override
	public List<Client> updateClientData(Client client) {
	
		return d.updateClientData(client);
	}
	@Override
	public List<Client> deleteClient(int id) {
		
		return d.deleteClient(id);
	}

}
