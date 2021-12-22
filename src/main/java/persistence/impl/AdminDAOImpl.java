package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Admin;
import persistence.AdminDAO;
import persistence.DAOException;
import persistence.DBUtil;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public void save(Connection connection, Admin admin) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Admin> findAll(Connection connection) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findById(Connection connection, int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findByUsername(Connection connection, String username) throws DAOException {
		String sql = "SELECT * FROM amministratore WHERE username = ?";
		System.out.println(sql);
		Admin admin = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				int id = resultSet.getInt(1);
				username = resultSet.getString(2);
				String password = resultSet.getString(3);
				admin = new Admin(id, username, password);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {  
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return admin;
	}

	@Override
	public void update(Connection connection, Admin admin) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Connection connection, Admin admin) throws DAOException {
		// TODO Auto-generated method stub

	}

}