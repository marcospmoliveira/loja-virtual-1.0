package br.com.loja.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.loja.jdbc.dao.ProdutosDAO;
import br.com.loja.jdbc.modelo.Produto;

public class TestaDAODeProduto {

	public static void main(String[] args) throws SQLException {
		Produto mesa = new Produto("Mesa vermelha", "Mesa com 3 pés");

		try (Connection con = new ConnectionPool().getConnection()) {
			ProdutosDAO dao = new ProdutosDAO(con);
			dao.salva(mesa);
			
			List<Produto> produtos = dao.lista();
			for (Produto produto : produtos) {
				System.out.println("Existe o Produto: " + produto);
			}
		}
	}
}
