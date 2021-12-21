package persistence;

import java.sql.Connection;
import java.util.List;

import model.Modulo;

public interface ModuloDAO {
	
	void save(Connection connection, Modulo modulo) throws DAOException;
	
	void update(Connection connection, Modulo modulo) throws DAOException;
	
	void delete(Connection connection, Modulo modulo) throws DAOException;
	
	Modulo findById(Connection connection, int id) throws DAOException;
	
	List<Modulo> findByNome(Connection connection, String nome) throws DAOException;

	List<Modulo> findAll(Connection connection) throws DAOException;
	
}