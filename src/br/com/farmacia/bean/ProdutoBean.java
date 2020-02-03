package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedorDAO;
import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.util.JSFUtil;

@ManagedBean (name = "MBProdutos")
@ViewScoped
public class ProdutoBean {
	
	private Produtos produtos;
	private ArrayList<Produtos> itens;
	private ArrayList<Produtos> itensFiltrados;
	private ArrayList<Fornecedores> comboFornecedores;
	
	public Produtos getProdutos() {
		return produtos;
	}
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	public ArrayList<Produtos> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Produtos> itens) {
		this.itens = itens;
	}
	public ArrayList<Produtos> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Produtos> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	public ArrayList<Fornecedores> getComboFornecedores() {
		return comboFornecedores;
	}
	public void setComboFornecedores(ArrayList<Fornecedores> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}
	
	@PostConstruct
	public void prepararPesquisa()  {
		try {
			ProdutoDAO pdao = new ProdutoDAO();	
			itens = pdao.listar();
		}catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.getMessage();
		}
	}
	public void prepararNovo() {
		
		try {
			produtos = new Produtos();
			FornecedorDAO dao = new FornecedorDAO();
			comboFornecedores = dao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("Erro ao pesquisar");
			e.printStackTrace();
		}
	}
	public void novo() {
		ProdutoDAO pdao = new ProdutoDAO();	
		try {
			pdao.salvar(produtos);
			JSFUtil.adicionarMensagemSucesso("Salvo com sucesso");
	
			itens= pdao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	public void excluir() {
		ProdutoDAO fdao = new ProdutoDAO();	
		try {
			fdao.excluir(produtos);
	
			itens  = fdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Excluido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void editar() {
		try {
			ProdutoDAO fdao = new ProdutoDAO();	
			fdao.editar(produtos);
			
			itens = fdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Alterado com sucesso");
		} catch (SQLException e) {
			e.getMessage();
		}

	}
	
	public void prepararEditar() {
		try {
			produtos = new Produtos();
			FornecedorDAO dao = new FornecedorDAO();
			comboFornecedores = dao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("Erro ao pesquisar");
			e.printStackTrace();
		}
	}
	
}
