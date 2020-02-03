package br.com.farmacia.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;


public class ProdutoDAOTest {
		
	@Test
	@Ignore
	public  void salvar() throws SQLException {
		Produtos produtos1 = new Produtos();
			produtos1.setDescricao("remedio 2");
			produtos1.setPreco(2.99);
			produtos1.setQuantidade(10);
	
			Fornecedores fornecedores = new Fornecedores();
			fornecedores.setCodigo(13L);
			
			produtos1.setFornecedor(fornecedores);
				
			ProdutoDAO produtoDAO = new ProdutoDAO();
			
			produtoDAO.salvar(produtos1);
	}	
	
	
	@Test
	@Ignore
	public void listar() throws SQLException  {
			ProdutoDAO produtoDao =  new ProdutoDAO();
			ArrayList<Produtos> lista = produtoDao.listar();
			for (Produtos produtos : lista) {
				System.out.println("O codigo é : " + produtos.getCodigo());
				System.out.println(produtos.getDescricao());
				System.out.println(produtos.getPreco());
				System.out.println(produtos.getQuantidade());
				System.out.println(produtos.getFornecedor().getCodigo());
				System.out.println(produtos.getFornecedor().getDescricao());
				System.out.println("");


			}
			
		}
	
	@Test
	@Ignore
	public void excluir() throws SQLException {
			Produtos pruduto = new Produtos();
			pruduto.setCodigo(3L);
			
			ProdutoDAO produtoDao = new ProdutoDAO();
			produtoDao.excluir(pruduto);
		}
	
	@Test
	public void editar() throws SQLException {
		Produtos p = new Produtos();
		p.setCodigo(5L);
		p.setDescricao("Cataflan");
		p.setPreco(15.75);
		p.setQuantidade(2);
		
		Fornecedores f = new Fornecedores();
		f.setCodigo(10L);
		p.setFornecedor(f);
		
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.editar(p);
		}
}
