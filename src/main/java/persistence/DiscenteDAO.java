package persistence;

import java.sql.Connection;
import java.util.List;

import model.Discente;

public interface DiscenteDAO {

	void save(Connection connection, Discente discente) throws DAOException;
	
	List<Discente> findAll(Connection connection) throws DAOException;
	
	Discente findById(Connection connection, int id) throws DAOException;
	
	void update(Connection connection, Discente discente) throws DAOException;
	
	void delete(Connection connection, Discente discente) throws DAOException;

}