package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection){
		this.connection = connection;
	}
	
	public List<Categoria> listar() throws SQLException{
		
		Categoria ultima = null;
		List<Categoria> categorias = new ArrayList<>();
		
		System.out.println("Executando a query de listar");
		
		String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN"
				+ " PRODUTO P ON C.ID = P.CATEGORIA_ID";
		
		try(PreparedStatement pstm = this.connection.prepareStatement(sql)){
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				String nomeCategoria;
				while (rst.next()) {
					nomeCategoria = rst.getString(2);
					if(ultima == null || !ultima.getNome().equals(nomeCategoria)){
						Categoria categoria = new Categoria(rst.getInt(1), nomeCategoria);		
						ultima = categoria;
						categorias.add(categoria);
					}
					Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
  					ultima.adicionar(produto);
				}
			}
			
		}
		
		return categorias;
		
	}
	
}
