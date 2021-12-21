package service.impl;

import java.sql.Connection;
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
		Connection c = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			academyDAO.save(c, academy);
			DBUtil.commit(c);
		} catch (DAOException e1) {
			System.err.println(e1.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e1.getMessage(), e1);
		} finally {
			DBUtil.close(c);
		}
	}

	@Override
	public void update(Academy academy) throws ServiceException {
		Connection c = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			academyDAO.update(c, academy);
			DBUtil.commit(c);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(c);
		}
	}

	@Override
	public void delete(Academy academy) throws ServiceException {
		Connection c = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			academyDAO.delete(c, academy);
			DBUtil.commit(c);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(c);
		}
	}

	@Override
	public Academy findById(int id) throws ServiceException {
		Connection c = null;
		Academy academy = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			academy = academyDAO.findById(c, id);
			DBUtil.commit(c);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(c);
		}	
		return academy;
	}

	@Override
	public List<Academy> findByNome(String nome) throws ServiceException {
		Connection c = null;
		List<Academy> academies = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			academies = academyDAO.findByNome(c, nome);
			DBUtil.commit(c);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(c);
		}	
		return academies;
	}

	@Override
	public List<Academy> findAll() throws ServiceException {
		Connection c = null;
		List<Academy> academy = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			academy = academyDAO.findAll(c);
			DBUtil.commit(c);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(c);
		}	
		return academy;
	}

}
