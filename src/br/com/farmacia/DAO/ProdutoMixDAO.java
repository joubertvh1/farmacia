package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.ProdutoMix;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.factory.ConexaoFactory;

public class ProdutoMixDAO {
	
	public void salvar(ProdutoMix produtoMix) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produtosMix ");
		sql.append("(codigo, descricao, quantidade, codigo_produto) ");
		sql.append("VALUES(?,?,?,?)");
		
	
			Connection conexao = ConexaoFactory.conectar();
			
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			
			comando.setInt(1, produtoMix.getCodigo());
			comando.setString(2, produtoMix.getDescricao());
			comando.setLong(3, produtoMix.getQuantidade());
			comando.setLong(4, produtoMix.getProdutos().getCodigo());
			comando.executeUpdate();		
	}
	
	public ArrayList<ProdutoMix> listar()throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.codigo_pk, p.codigo, p.descricao, p.quantidade, f.codigo, f.descricao ");
		sql.append("FROM produtosMix p ");
		sql.append("INNER JOIN produtos f ON f.codigo =  p.codigo_produto ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
				
		ResultSet resultado = comando.executeQuery();
		 
		ArrayList<ProdutoMix>lista = new ArrayList<ProdutoMix>();
		
		while(resultado.next()){
			Produtos f = new Produtos();
			f.setCodigo(resultado.getLong("f.codigo"));
			f.setDescricao(resultado.getString("f.descricao"));
			
			ProdutoMix p = new ProdutoMix();
			p.setCodigo_pk(resultado.getLong("p.codigo_pk"));
			p.setCodigo(resultado.getInt("p.codigo"));
			p.setDescricao(resultado.getString("p.descricao"));
			p.setQuantidade(resultado.getInt("p.quantidade"));
			p.setProdutos(f);
			
			lista.add(p);
		}

		return lista;
	}
	
	public ArrayList<ProdutoMix> listarSomenteMaximo()throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.codigo_pk, p.codigo, p.descricao, p.quantidade, f.codigo, f.descricao ");
		sql.append("FROM produtosMix p ");
		sql.append("INNER JOIN produtos f ON f.codigo =  p.codigo_produto ");
		sql.append("order by 1");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
				
		ResultSet resultado = comando.executeQuery();
		 
		ArrayList<ProdutoMix>lista = new ArrayList<ProdutoMix>();
		
		while(resultado.next()){
			Produtos f = new Produtos();
			f.setCodigo(resultado.getLong("f.codigo"));
			f.setDescricao(resultado.getString("f.descricao"));
			
			ProdutoMix p = new ProdutoMix();
			p.setCodigo_pk(resultado.getLong("p.codigo_pk"));
			p.setCodigo(resultado.getInt("p.codigo"));
			p.setDescricao(resultado.getString("p.descricao"));
			p.setQuantidade(resultado.getInt("p.quantidade"));
			p.setProdutos(f);
			
			lista.add(p);
		}

		return lista;
	}
	
	public void excluir(ProdutoMix produtoMix) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE from produtosMix ");
		sql.append("where codigo_pk = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, produtoMix.getCodigo());
		comando.executeUpdate();	 

	}
	
	public void editar(ProdutoMix produtoMix) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produtosMix ");
		sql.append("SET descricao = ?, quantidade = ?, codigo_produto = ? ");
		sql.append("WHERE codigo_pk = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, produtoMix.getDescricao());
		comando.setInt(2, produtoMix.getQuantidade());
		comando.setLong(3, produtoMix.getProdutos().getCodigo());
		comando.setLong(4, produtoMix.getCodigo());
		comando.executeUpdate();	

	}


}
