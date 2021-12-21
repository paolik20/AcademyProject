package persistence.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Academy;
import model.Modulo;
import persistence.AcademyDAO;
import persistence.DAOException;
import persistence.DBUtil;
import persistence.ModuloDAO;

public class ModuloDAOImpl implements ModuloDAO {

	AcademyDAO academyDAO = new AcademyDAOImpl();
	
	@Override
	public void save(Connection connection, Modulo modulo) throws DAOException {
		String sql = "INSERT INTO modulo(posizione, nome, argomenti, data_inizio, data_fine, academy_id) VALUES (?, ?, ?, ?, ?, ?)";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		try {
			statement = connection.prepareStatement(sql, new String[] { "id" });
			statement.setInt(1, modulo.getPosizione());
			statement.setString(2, modulo.getNome());
			statement.setString(3, modulo.getArgomenti());
			statement.setDate(4, modulo.getDataInizio());
			statement.setDate(5, modulo.getDataFine());
			statement.setInt(6, modulo.getAcademy().getId());
			
			statement.executeUpdate();
			generatedKeys = statement.getGeneratedKeys();
			if(generatedKeys.next()) {
				int id = generatedKeys.getInt(1);
				modulo.setId(id);
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
	public void update(Connection connection, Modulo modulo) throws DAOException {
		String sql = "UPDATE modulo SET posizione=?, nome=?, argomenti=?, data_inizio=?, data_fine=?, academy_id=? WHERE id = ?";
		System.out.println(sql);
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, modulo.getPosizione());
			statement.setString(2, modulo.getNome());
			statement.setString(3, modulo.getArgomenti());
			statement.setDate(4, modulo.getDataInizio());
			statement.setDate(5, modulo.getDataFine());
			statement.setInt(6, modulo.getAcademy().getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
			// ROLLBACK
		}finally {
			DBUtil.close(statement);
		}
	}

	@Override
	public void delete(Connection connection, Modulo modulo) throws DAOException {
		String sql = "DELETE FROM modulo WHERE id = ?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, modulo.getId());
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
	public Modulo findById(Connection connection, int id) throws DAOException {
		String sql = "SELECT * FROM modulo WHERE id = ?";
		System.out.println(sql);
		Modulo modulo = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				id = resultSet.getInt(1);
				int posizione = resultSet.getInt(2);
				String nome = resultSet.getString(3);
				String argomenti = resultSet.getString(4);
				Date dataInizio = resultSet.getDate(5);
				Date dataFine = resultSet.getDate(6);
				int idAcademy = resultSet.getInt(7);
				Academy academy = academyDAO.findById(connection, idAcademy);
				modulo = new Modulo(id, posizione, nome, argomenti, dataInizio, dataFine, academy);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {  
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return modulo;
	}

	@Override
	public List<Modulo> findByNome(Connection connection, String nome) throws DAOException {
		String sql = "SELECT * FROM modulo WHERE nome=?";
		List<Modulo> moduli = new ArrayList<Modulo>();
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
		try {
	    	statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				int posizione = resultSet.getInt(2);
				String argomenti = resultSet.getString(4);
				Date dataInizio = resultSet.getDate(5);
				Date dataFine = resultSet.getDate(6);
				int idAcademy = resultSet.getInt(7);
				Academy academy = academyDAO.findById(connection, idAcademy);
				Modulo modulo = new Modulo(id, posizione, nome, argomenti, dataInizio, dataFine, academy);
				moduli.add(modulo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {  
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return moduli;
	}

	@Override
	public List<Modulo> findAll(Connection connection) throws DAOException {
		String sql = "SELECT * FROM modulo";
		List<Modulo> moduli = new ArrayList<Modulo>();
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
		try {
	    	statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				int posizione = resultSet.getInt(2);
				String nome = resultSet.getString(3);
				String argomenti = resultSet.getString(4);
				Date dataInizio = resultSet.getDate(5);
				Date dataFine = resultSet.getDate(6);
				int idAcademy = resultSet.getInt(7);
				Academy academy = academyDAO.findById(connection, idAcademy);
				Modulo modulo = new Modulo(id, posizione, nome, argomenti, dataInizio, dataFine, academy);
				moduli.add(modulo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {  
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return moduli;
	}

}


