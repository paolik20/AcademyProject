package service.impl;

import java.sql.Connection;
import java.util.List;

import model.Modulo;
import persistence.DAOException;
import persistence.DBUtil;
import persistence.DataSource;
import persistence.ModuloDAO;
import persistence.impl.ModuloDAOImpl;
import service.ModuloService;
import service.ServiceException;

public class ModuloServiceImpl implements ModuloService {

	ModuloDAO moduloDAO = new ModuloDAOImpl();
	
	@Override
	public void save(Modulo modulo) throws ServiceException {
		Connection c = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			moduloDAO.save(c, modulo);
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
	public void update(Modulo modulo) throws ServiceException {
		Connection c = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			moduloDAO.update(c, modulo);
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
	public void delete(Modulo modulo) throws ServiceException {
		Connection c = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			moduloDAO.delete(c, modulo);
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
	public Modulo findById(int id) throws ServiceException {
		Connection c = null;
		Modulo modulo = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			modulo = moduloDAO.findById(c, id);
			DBUtil.commit(c);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(c);
		}	
		return modulo;
	}

	@Override
	public List<Modulo> findByNome(String nome) throws ServiceException {
		Connection c = null;
		List<Modulo> moduli = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			moduli = moduloDAO.findByNome(c, nome);
			DBUtil.commit(c);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(c);
		}	
		return moduli;
	}

	@Override
	public List<Modulo> findAll() throws ServiceException {
		Connection c = null;
		List<Modulo> modulo = null;
		try {
			c = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(c, false);
			modulo = moduloDAO.findAll(c);
			DBUtil.commit(c);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(c);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(c);
		}	
		return modulo;
	}

}
