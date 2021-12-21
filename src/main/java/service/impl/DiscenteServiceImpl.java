package service.impl;

import java.sql.Connection;
import java.util.List;

import model.Discente;
import persistence.DAOException;
import persistence.DBUtil;
import persistence.DataSource;
import persistence.DiscenteDAO;
import persistence.impl.DiscenteDAOImpl;
import service.DiscenteService;
import service.ServiceException;

public class DiscenteServiceImpl implements DiscenteService {

	DiscenteDAO discenteDAO = new DiscenteDAOImpl();
	
	@Override
	public void save(Discente discente) throws ServiceException {
		Connection c = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			discenteDAO.save(c, discente);
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
	public List<Discente> findAll() throws ServiceException {
		Connection c = null;
		List<Discente> discenti = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			discenti = discenteDAO.findAll(c);
			DBUtil.commit(c);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(c);
		}	
		return discenti;
	}

	@Override
	public Discente findById(int id) throws ServiceException {
		Connection c = null;
		Discente discente = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			discente = discenteDAO.findById(c,id);
			DBUtil.commit(c);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(c);
		}	
		return discente;
	}

	@Override
	public void update(Discente discente) throws ServiceException {
		Connection c = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			discenteDAO.update(c, discente);
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
	public void delete(Discente discente) throws ServiceException {
		Connection c = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			discenteDAO.delete(c, discente);
			DBUtil.commit(c);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(c);
		}	
	}

}
