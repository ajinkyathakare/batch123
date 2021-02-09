package com.dao;

import java.util.List;

import com.model.Client;

public interface DaoInterf {
	
	public int addClientData(Client client);
	
	public List<Client> displayAllData(String username,String password);
	
	public Client getSingleClient(int id);
	
	public List<Client> updateClientData(Client client);
	
	public List<Client> deleteClient(int id);

}