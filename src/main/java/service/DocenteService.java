package service;

import java.util.List;

import model.Docente;

public interface DocenteService {

	void save(Docente docente) throws ServiceException;
	
	List<Docente> findAll() throws ServiceException;
	
	Docente findById(int id) throws ServiceException;
	
	void update(Docente docente) throws ServiceException;
	
	void delete(Docente docente) throws ServiceException;
	
}
