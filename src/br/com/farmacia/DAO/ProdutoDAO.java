package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.factory.ConexaoFactory;

public class ProdutoDAO {
	
	public void salvar(Produtos produto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produtos ");
		sql.append("(descricao, preco, quantidade, fornecedores_codigo) ");
		sql.append("VALUES(?,?,?,?)");
		
	
			Connection conexao = ConexaoFactory.conectar();
			
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			
			comando.setString(1, produto.getDescricao());
			comando.setDouble(2, produto.getPreco());
			comando.setLong(3, produto.getQuantidade());
			comando.setLong(4, produto.getFornecedor().getCodigo());
			comando.executeUpdate();		
	}
	
	public ArrayList<Produtos> listar()throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.codigo, p.descricao, p.preco, p.quantidade, f.codigo, f.descricao ");
		sql.append("FROM produtos p ");
		sql.append("INNER JOIN fornecedores f ON f.codigo = p.fornecedores_codigo ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
				
		ResultSet resultado = comando.executeQuery();
		 
		ArrayList<Produtos>lista = new ArrayList<Produtos>();
		
		while(resultado.next()){
			Fornecedores f = new Fornecedores();
			f.setCodigo(resultado.getLong("f.codigo"));
			f.setDescricao(resultado.getString("f.descricao"));
			
			Produtos p = new Produtos();
			p.setCodigo(resultado.getLong("p.codigo"));
			p.setDescricao(resultado.getString("p.descricao"));
			p.setPreco(resultado.getDouble("p.preco"));
			p.setQuantidade(resultado.getInt("p.quantidade"));
			p.setFornecedor(f);
			
			lista.add(p);
		}

		return lista;
	}
	
	public void excluir(Produtos produto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE from produtos ");
		sql.append("where codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, produto.getCodigo());
		comando.executeUpdate();	 

	}
	
	public void editar(Produtos produto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produtos ");
		sql.append("SET descricao = ?, preco = ?, quantidade = ?, fornecedores_codigo = ? ");
		sql.append("WHERE codigo = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, produto.getDescricao());
		comando.setDouble(2, produto.getPreco());
		comando.setInt(3, produto.getQuantidade());
		comando.setLong(4, produto.getFornecedor().getCodigo());
		comando.setLong(5, produto.getCodigo());
		comando.executeUpdate();	

	}

}
