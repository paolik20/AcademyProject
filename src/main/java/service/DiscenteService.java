package service;

import java.util.List;

import model.Discente;

public interface DiscenteService {

	void save(Discente discente) throws ServiceException;
	
	List<Discente> findAll() throws ServiceException;
	
	Discente findById(int id) throws ServiceException;
	
	void update(Discente discente) throws ServiceException;
	
	void delete(Discente discente) throws ServiceException;
}
