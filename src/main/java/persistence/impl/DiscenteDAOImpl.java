package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Discente;
import persistence.DAOException;
import persistence.DBUtil;
import persistence.DiscenteDAO;

public class DiscenteDAOImpl implements DiscenteDAO {

	@Override
	public void save(Connection connection, Discente discente) throws DAOException {
		String sql = "INSERT INTO discente(codice_fiscale, nome, cognome) VALUES(?,?,?)";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		try {
			statement = connection.prepareStatement(sql, new String[] { "id" });
			statement.setString(1, discente.getCodiceFiscale());
			statement.setString(2, discente.getNome());
			statement.setString(3, discente.getCognome());
			statement.executeUpdate();
			generatedKeys = statement.getGeneratedKeys();
			if(generatedKeys.next()) {
				int id = generatedKeys.getInt(1);
				discente.setId(id);
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
	public List<Discente> findAll(Connection connection) throws DAOException {
		String sql = "SELECT * FROM discente";
		List<Discente> discenti = new ArrayList<Discente>();
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
				Discente discente = new Discente(id, codiceFiscale, nome, cognome);
				discenti.add(discente);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {  
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return discenti;
	}

	@Override
	public Discente findById(Connection connection, int id) throws DAOException {
		String sql = "SELECT * FROM discente WHERE id = ?";
		System.out.println(sql);
		Discente discente = null;
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
				discente = new Discente(id, codiceFiscale, nome, cognome);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
		} finally {  
			DBUtil.close(resultSet);
			DBUtil.close(statement);
		}
		return discente;
	}

	@Override
	public void update(Connection connection, Discente discente) throws DAOException {
		String sql = "UPDATE discente SET nome = ?, cognome = ?, codice_fiscale = ? WHERE id = ?";
		System.out.println(sql);
		PreparedStatement statement = null;
		try {
			//statement = connection.createStatement();
			statement = connection.prepareStatement(sql);
			statement.setString(1, discente.getNome());
			statement.setString(2, discente.getCognome());
			statement.setString(3, discente.getCodiceFiscale());
			statement.setInt(4, discente.getId());
			//statement.executeUpdate(sql);
			statement.executeUpdate();
			// COMMIT
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("errore nell'accesso ai dati", e);
			// ROLLBACK
		}finally {
			DBUtil.close(statement);
		}
	}

	@Override
	public void delete(Connection connection, Discente discente) throws DAOException {
		String sql = "DELETE FROM discente WHERE id = ?";
		System.out.println(sql);
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, discente.getId());
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
