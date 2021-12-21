package service.impl;

import java.sql.Connection;
import java.util.List;

import model.Docente;
import persistence.DAOException;
import persistence.DBUtil;
import persistence.DataSource;
import persistence.DocenteDAO;
import persistence.impl.DocenteDAOImpl;
import service.DocenteService;
import service.ServiceException;

public class DocenteServiceImpl implements DocenteService {

	DocenteDAO docenteDAO = new DocenteDAOImpl();
	
	@Override
	public void save(Docente docente) throws ServiceException {
		Connection c = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			docenteDAO.save(c, docente);
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
	public List<Docente> findAll() throws ServiceException {
		Connection c = null;
		List<Docente> docenti = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			docenti = docenteDAO.findAll(c);
			DBUtil.commit(c);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(c);
		}	
		return docenti;
	}

	@Override
	public Docente findById(int id) throws ServiceException {
		Connection c = null;
		Docente docente = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			docente = docenteDAO.findById(c,id);
			DBUtil.commit(c);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(c);
		}	
		return docente;
	}

	@Override
	public void update(Docente docente) throws ServiceException {
		Connection c = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			docenteDAO.update(c, docente);
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
	public void delete(Docente docente) throws ServiceException {
		Connection c = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			docenteDAO.delete(c, docente);
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
