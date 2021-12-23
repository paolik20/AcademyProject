package service;

import java.sql.Date;
import java.util.List;

import model.Academy;

public interface AcademyService {

	void save(Academy academy) throws ServiceException;
	
	void update(Academy academy) throws ServiceException;
	
	void delete(Academy academy) throws ServiceException;
	
	Academy findById(int id) throws ServiceException;
	
	List<Academy> findByNome(String nome) throws ServiceException;

	List<Academy> findByNomeEDate(String nome, Date dataInizio, Date dataFine) throws ServiceException;

	List<Academy> findAll() throws ServiceException;
	
	List<Academy> findByModulo(String modulo) throws ServiceException;
	
}
