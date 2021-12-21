package persistence;

import java.sql.Connection;
import java.util.List;

import model.Docente;

public interface DocenteDAO {

	void save(Connection connection, Docente docente) throws DAOException;
	
	List<Docente> findAll(Connection connection) throws DAOException;
	
	Docente findById(Connection connection, int id) throws DAOException;
	
	void update(Connection connection, Docente docente) throws DAOException;
	
	void delete(Connection connection, Docente docente) throws DAOException;
	
}