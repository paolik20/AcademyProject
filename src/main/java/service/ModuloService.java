package service;

import java.util.List;

import model.Modulo;

public interface ModuloService {

	void save(Modulo modulo) throws ServiceException;
	
	void update(Modulo modulo) throws ServiceException;
	
	void delete(Modulo modulo) throws ServiceException;
	
	Modulo findById(int id) throws ServiceException;
	
	List<Modulo> findByNome(String nome) throws ServiceException;

	List<Modulo> findAll() throws ServiceException;
	
}
