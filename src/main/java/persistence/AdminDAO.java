package persistence;

import java.sql.Connection;
import java.util.List;

import model.Admin;

public interface AdminDAO {

	void save(Connection connection, Admin admin) throws DAOException;
	
	List<Admin> findAll(Connection connection) throws DAOException;
	
	Admin findById(Connection connection, int id) throws DAOException;
	
	Admin findByUsername(Connection connection, String username) throws DAOException;

	void update(Connection connection, Admin admin) throws DAOException;
	
	void delete(Connection connection, Admin admin) throws DAOException;

}
