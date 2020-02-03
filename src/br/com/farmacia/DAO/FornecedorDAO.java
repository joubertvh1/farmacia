package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.ConexaoFactory;

public class FornecedorDAO {

	public void salvar(Fornecedores fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao, cnpj) ");
		sql.append("VALUES(?,?)");
		
	
			Connection conexao = ConexaoFactory.conectar();
			
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, fornecedor.getDescricao());
			comando.setLong(2, fornecedor.getCnpj());
			comando.executeUpdate();		
	}
	public void excluir(Fornecedores fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE from fornecedores ");
		sql.append("where codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, fornecedor.getCodigo());
		comando.executeUpdate();	 

	}
	public void editar(Fornecedores fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET descricao = ?, cnpj = ? ");
		sql.append("where codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, fornecedor.getDescricao());
		comando.setLong(2, fornecedor.getCnpj());
		comando.setLong(3, fornecedor.getCodigo());
		comando.executeUpdate();	 

	}
	public Fornecedores  buscaPorCodigo(Fornecedores fornecedores) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao, cnpj ");
		sql.append("FROM fornecedores  ");
		sql.append("where codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setLong(1, fornecedores.getCodigo());
		
		ResultSet resultado = comando.executeQuery();
		Fornecedores retorno = null;
		
		if(resultado.next()) {
			retorno = new Fornecedores();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
			retorno.setCnpj(resultado.getLong("cnpj"));
		}
		
		return retorno; 
	}
	public ArrayList<Fornecedores> buscaPorDescricao(Fornecedores fornecedores) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao, cnpj ");
		sql.append("FROM fornecedores  ");
		sql.append("where descricao LIKE  ? ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, "%" +  fornecedores.getDescricao() + "%");
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fornecedores> lista =  new ArrayList<Fornecedores>();
		
		while(resultado.next()) {
			Fornecedores item = new Fornecedores();
			item.setCodigo(resultado.getLong("codigo"));
			item.setDescricao(resultado.getString("descricao"));
			item.setCnpj(resultado.getLong("cnpj"));
			
			lista.add(item);
		}
		 return lista;
	}
	
	
	public ArrayList<Fornecedores> listar() throws SQLException{
	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao, cnpj ");
		sql.append("FROM fornecedores  ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fornecedores> lista =  new ArrayList<Fornecedores>();
		
		while(resultado.next()) {
			Fornecedores f = new Fornecedores();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			f.setCnpj(resultado.getLong("cnpj"));
			
			lista.add(f);
		}
		 return lista;
	}
	
	
	public static void main(String[] args) {
	
		Fornecedores fornecedores1 = new Fornecedores();
		fornecedores1.setDescricao("joubert 6");
		
		Fornecedores fornecedores2 = new Fornecedores();
		fornecedores2.setDescricao("Descricao 7");
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		try {
			fornecedorDAO.salvar(fornecedores1);
			fornecedorDAO.salvar(fornecedores2);
			System.out.println("ok!");
		} catch (SQLException e) {
			System.out.println("Erro ao Salvar" + e.getMessage());
			e.printStackTrace();
			
		}
		/* Fornecedores fornecedores1 = new Fornecedores();
		fornecedores1.setCodigo(3L);
		
		FornecedorDAO fornecedorDao = new FornecedorDAO();
		try {
			fornecedorDao.excluir(fornecedores1);
			System.out.println("ok!");
			
		} catch (SQLException e) {
			System.out.println("Falha " + e.getMessage());
			e.printStackTrace();
		}
		*/
		/*
		Fornecedores fornecedores1 = new Fornecedores();
		fornecedores1.setCodigo(1L);
		fornecedores1.setDescricao("TESTE !!!!!");
		
		FornecedorDAO fornecedorDao = new FornecedorDAO();
		try {
			fornecedorDao.editar(fornecedores1);
			System.out.println("ok!");
			
		} catch (SQLException e) {
			System.out.println("Falha " + e.getMessage());
			e.printStackTrace();
		}
		*/
		/*
		Fornecedores fornecedores1 = new Fornecedores();
		fornecedores1.setCodigo(1L);
		

		Fornecedores fornecedores2 = new Fornecedores();
		fornecedores2.setCodigo(3L);
		
		FornecedorDAO fornecedorDao = new FornecedorDAO();
		
		try {
			Fornecedores f1 = fornecedorDao.buscaPorCodigo(fornecedores1);
			Fornecedores f2 = fornecedorDao.buscaPorCodigo(fornecedores2);
			System.out.println("Resultado 1: " + f1);
			System.out.println("Resultado 2: " + f2);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("falha ao buscar registro");
		}
		
		*/
		/*
		FornecedorDAO fornecedorDao = new FornecedorDAO();

		try {
			ArrayList<Fornecedores> lista =  fornecedorDao.listar();
			
			for (Fornecedores f : lista) {
				System.out.println("Resultado " + f);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("falha ao buscar registro");
		}
		*/
		/*
		Fornecedores f1 = new Fornecedores();
		f1.setDescricao("teste");
		FornecedorDAO fornecedorDao = new FornecedorDAO();

		
		try {
			ArrayList<Fornecedores> lista =  fornecedorDao.buscaPorDescricao(f1);
			
			for (Fornecedores f : lista) {
				System.out.println("Resultado " + f);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("falha ao buscar registro");
		}
		*/
	}	
	
}
