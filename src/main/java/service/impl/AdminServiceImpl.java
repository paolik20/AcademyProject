package service.impl;

import java.sql.Connection;

import model.Admin;
import persistence.AdminDAO;
import persistence.DAOException;
import persistence.DBUtil;
import persistence.DataSource;
import persistence.impl.AdminDAOImpl;
import service.AdminService;
import service.ServiceException;

public class AdminServiceImpl implements AdminService {

	AdminDAO adminDAO = new AdminDAOImpl();
	
	@Override
	public Admin findByUsername(String username) throws ServiceException {
		Connection connection = null;
		Admin admin = null;
		try {
			connection = DataSource.getInstance().getConnection();
			DBUtil.setAutoCommit(connection, false);
			admin = adminDAO.findByUsername(connection, username);
			DBUtil.commit(connection);
		} catch (DAOException e) {
			System.err.println(e.getMessage());
			DBUtil.rollback(connection);
			throw new ServiceException(e.getMessage(), e);
		} finally {
			DBUtil.close(connection);
		}	
		return admin;
	}
	
}
