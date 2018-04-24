package br.com.loja.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionPool().getConnection()) {
			connection.setAutoCommit(false);
			String sql = "insert into Produto (nome, descricao) values (?,?)";
			
			try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				Adiciona("Geladeira", "Geladeira duas portas", statement);
				Adiciona("Ferro de passar", "Ferro de passar com vaporizador", statement);
				connection.commit();
				statement.close();

			} catch (Exception ex) {
				ex.printStackTrace();
				connection.rollback();
			}

		}
	}

	private static void Adiciona(String nome, String descricao, PreparedStatement statement) throws SQLException {
		
		statement.setString(1, nome);
		statement.setString(2, descricao);

		boolean resultado = statement.execute();
		System.out.println(resultado);

		ResultSet resultSet = statement.getGeneratedKeys();
		while (resultSet.next()) {
			String id = resultSet.getString("id");
			System.out.println(id + " gerado");
		}

		resultSet.close();
	}
}
