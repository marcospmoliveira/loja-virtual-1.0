package br.com.loja.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCPool;

public class ConnectionPool {
	private DataSource dataSource;

	// cd C:\Users\marco\eclipse-workspace\Loja_Virtual_1.0
	// java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:loja-virtual --dbname.0 loja-virtual
	// java -cp hsqldb.jar org.hsqldb.util.DatabaseManager

	ConnectionPool() {
		JDBCPool pool = new JDBCPool();
		pool.setUrl("jdbc:hsqldb:hsql://localhost/loja-virtual");
		pool.setUser("SA");
		pool.setPassword("");
		this.dataSource = pool;
	}

	Connection getConnection() throws SQLException {
//		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
		Connection connection = dataSource.getConnection();
		return connection;
	}
}
