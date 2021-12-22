package service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import model.Academy;
import persistence.AcademyDAO;
import persistence.DAOException;
import persistence.DBUtil;
import persistence.DataSource;
import persistence.impl.AcademyDAOImpl;
import service.AcademyService;
import service.ServiceException;

public class AcademyServiceImpl implements AcademyService {

	AcademyDAO academyDAO = new AcademyDAOImpl();
	
	@Override
	public void save(Academy academy) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			academyDAO.save(connection, academy);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public void update(Academy academy) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			academyDAO.update(connection, academy);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public void delete(Academy academy) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			academyDAO.delete(connection, academy);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Academy findById(int id) throws ServiceException {
		Connection connection = null;
		Academy academy = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			academy = academyDAO.findById(connection, id);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}	
		return academy;
	}

	@Override
	public List<Academy> findByNome(String nome) throws ServiceException {
		Connection connection = null;
		List<Academy> academies = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			academies = academyDAO.findByNome(connection, nome);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}	
		return academies;
	}

	@Override
	public List<Academy> findAll() throws ServiceException {
		Connection connection = null;
		List<Academy> academy = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			academy = academyDAO.findAll(connection);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}	
		return academy;
	}

	@Override
	public List<Academy> findByNomeEDate(String nome, Date dataInizio, Date dataFine) throws ServiceException {
		Connection connection = null;
		List<Academy> academies = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			academies = academyDAO.findByNomeEDate(connection, nome, dataInizio, dataFine);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}	
		return academies;
	}

}
