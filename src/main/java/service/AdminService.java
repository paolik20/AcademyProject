package service;

import model.Admin;

public interface AdminService {

	Admin findByUsername(String username) throws ServiceException;
	
}
