package persistence;

import java.sql.Connection;
import java.util.List;

import model.Academy;

public interface AcademyDAO {

	void save(Connection connection, Academy academy) throws DAOException;
	
	void update(Connection connection, Academy academy) throws DAOException;
	
	void delete(Connection connection, Academy academy) throws DAOException;
	
	Academy findById(Connection connection, int id) throws DAOException;
	
	List<Academy> findByNome(Connection connection, String nome) throws DAOException;

	List<Academy> findAll(Connection connection) throws DAOException;
	
}