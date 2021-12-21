package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Docente;
import persistence.DAOException;
import persistence.DBUtil;
import persistence.DocenteDAO;

public class DocenteDAOImpl implements DocenteDAO{

	@Override
	public void save(Connection connection, Docente docente) throws DAOException {
		String sql = "INSERT INTO docente(codice_fiscale, nome, cognome) VALUES(?,?,?)";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		try {
			statement = connection.prepareStatement(sql, new String[] { "id" });
			statement.setString(1, docente.getCodiceFiscale());
			statement.setString(2, docente.getNome());
			statement.setString(3, docente.getCognome());
			statement.executeUpdate();
			generatedKeys = statement.getGeneratedKeys();
			if(generatedKeys.next()) {
				int id = generatedKeys.getInt(1);
				docente.setId(id);
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
	public List<Docente> findAll(Connection connection) throws DAOException {
		String sql = "SELECT * FROM docente";
		List<Docente> docenti = new ArrayList<Docente>();
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
		try {
	    	statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String codiceFiscale = resultSet.getString(2);
				String nome = resultSet.getString("nome");
				String cognome = resultSet.getString(4);
				Docente docente = new Docente(id, codiceFiscale, nome, cognome);
				docenti.add(docente);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {  
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return docenti;
	}

	@Override
	public Docente findById(Connection connection, int id) throws DAOException {
		String sql = "SELECT * FROM docente WHERE id = ?";
		System.out.println(sql);
		Docente docente = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				id = resultSet.getInt(1);
				String codiceFiscale = resultSet.getString(2);
				String nome = resultSet.getString(3);
				String cognome = resultSet.getString(4);
				docente = new Docente(id, codiceFiscale, nome, cognome);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {  
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return docente;
	}

	@Override
	public void update(Connection connection, Docente docente) throws DAOException {
		String sql = "UPDATE docente SET nome = ?, cognome = ?, codice_fiscale = ? WHERE id = ?";
		System.out.println(sql);
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, docente.getNome());
			statement.setString(2, docente.getCognome());
			statement.setString(3, docente.getCodiceFiscale());
			statement.setInt(4, docente.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		}finally {
			DBUtil.close(statement);
		}
	}

	@Override
	public void delete(Connection connection, Docente docente) throws DAOException {
		String sql = "DELETE FROM docente WHERE id = ?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, docente.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {  
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
	}

}
