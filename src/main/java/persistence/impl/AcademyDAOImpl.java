package persistence.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Academy;
import persistence.AcademyDAO;
import persistence.DAOException;
import persistence.DBUtil;

public class AcademyDAOImpl implements AcademyDAO {

	@Override
	public void save(Connection connection, Academy academy) throws DAOException {
		String sql = "INSERT INTO academy(nome, data_inizio, data_fine) VALUES (?, ?, ?)";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		try {
			statement = connection.prepareStatement(sql, new String[] { "id" });
			statement.setString(1, academy.getNome());
			statement.setDate(2, academy.getDataInizio());
			statement.setDate(3, academy.getDataFine());
			
			statement.executeUpdate();
			generatedKeys = statement.getGeneratedKeys();
			if(generatedKeys.next()) {
				int id = generatedKeys.getInt(1);
				academy.setId(id);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {  
			DBUtil.close(generatedKeys);
			DBUtil.close(statement);
		}
	}

	@Override
	public void update(Connection connection, Academy academy) throws DAOException {
		String sql = "UPDATE academy SET nome=?, data_inizio=?, data_fine=? WHERE id = ?";
		System.out.println(sql);
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, academy.getNome());
			statement.setDate(2, academy.getDataInizio());
			statement.setDate(3, academy.getDataFine());
			statement.setInt(4, academy.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {
			DBUtil.close(statement);
		}
	}

	@Override
	public void delete(Connection connection, Academy academy) throws DAOException {
		String sql = "DELETE FROM academy WHERE id = ?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, academy.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {  
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
	}

	@Override
	public Academy findById(Connection connection, int id) throws DAOException {
		String sql = "SELECT * FROM academy WHERE id = ?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Academy academy = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				String nome = resultSet.getString(2);
				Date dataInizio = resultSet.getDate(3);
				Date dataFine = resultSet.getDate(4);
				academy = new Academy(id, nome, dataInizio, dataFine);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {  
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return academy;
	}

	@Override
	public List<Academy> findByNome(Connection connection, String nome) throws DAOException {
		String sql = "SELECT * FROM academy WHERE nome=?";
		List<Academy> academies = new ArrayList<Academy>();
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    Academy academy = null;
		try {
	    	statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				Date dataInizio = resultSet.getDate(3);
				Date dataFine = resultSet.getDate(4);
				academy = new Academy(id, nome, dataInizio, dataFine);
				academies.add(academy);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {  
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return academies;
	}

	@Override
	public List<Academy> findAll(Connection connection) throws DAOException {
		String sql = "SELECT * FROM academy";
		List<Academy> academies = new ArrayList<Academy>();
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
		try {
	    	statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String nome = resultSet.getString(2);
				Date dataInizio = resultSet.getDate(3);
				Date dataFine = resultSet.getDate(4);
				Academy academy = new Academy(id, nome, dataInizio, dataFine);
				academies.add(academy);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {  
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return academies;
	}

	@Override
	public List<Academy> findByNomeEDate(Connection connection, String nome, Date dataInizio,
			Date dataFine) throws DAOException {
		
		
		
		
		
		
		
		return null;
	}

}
