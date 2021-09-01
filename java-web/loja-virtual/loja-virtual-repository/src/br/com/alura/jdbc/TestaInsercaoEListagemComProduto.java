package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Cômoda", "Cômada vertical");

		try( Connection connection = new ConnectionFactory().recuperarConexao()){			
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(comoda);
			List<Produto> listaDeProdutos = produtoDAO.listar();
			
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
			
		}
		
		System.out.println(comoda);
	}

}
