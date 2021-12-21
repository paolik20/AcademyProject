package service;

import java.util.List;

import model.Academy;

public interface AcademyService {

	void save(Academy academy) throws ServiceException;
	
	void update(Academy academy) throws ServiceException;
	
	void delete(Academy academy) throws ServiceException;
	
	Academy findById(int id) throws ServiceException;
	
	List<Academy> findByNome(String nome) throws ServiceException;

	List<Academy> findAll() throws ServiceException;
	
}
