package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// pattern singleton (schema di esecuzione: creazione di un singolo oggetto di una classe)
// costruttore private
// proprietà statica che punta all'unico oggetto di quella classe
// metodo statico che permette di ottenere l'unico oggetto della classe creato

public class DataSource {
	
	// private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test2?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "Galdino123";
	
	// proprietà privata statica che regge l'unico oggetto creato a partire dalla classe
	private static DataSource instance;
	
	// impedisco di creare un oggetto della classe DataSource dall'esterno
	private DataSource() {
		
	}
	
	public static DataSource getInstance() {
		// controlla l'esistenza dell'oggetto e in caso di non esistenza forza la sua creazione
		if(instance == null) 
			instance = new DataSource();
		return instance;
	}
	
	public Connection getConnection() throws DAOException {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e);
		}
	}
	
}
