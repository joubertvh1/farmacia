package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedorDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.JSFUtil;


@ManagedBean(name = "MBfornecedores")
@ViewScoped
public class FornecedoresBean {

	private ArrayList<Fornecedores> itens;
	private ArrayList<Fornecedores> itensFiltrados;
	private Fornecedores fornecedores;
	
	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	public ArrayList<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fornecedores> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Fornecedores> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fornecedores> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa()  {
		try {
			FornecedorDAO fdao = new FornecedorDAO();	
			itens = fdao.listar();
		}catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.getMessage();
		}
	}
	
	public void prepararNovo() {
		fornecedores = new Fornecedores();
	}
	
	public void novo() {
		FornecedorDAO fdao = new FornecedorDAO();	
		try {
			fdao.salvar(fornecedores);
			JSFUtil.adicionarMensagemSucesso("Salvo com sucesso");
	
			itens= fdao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	public void excluir() {
		FornecedorDAO fdao = new FornecedorDAO();	
		try {
			fdao.excluir(fornecedores);
	
			itens  = fdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Excluido com sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("Não é possivel excluir fornecedor com produto cadastrado");
			e.printStackTrace();
		}
	}
	

	
	public void editar() {
		try {
			FornecedorDAO fdao = new FornecedorDAO();	
			fdao.editar(fornecedores);
			
			itens = fdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Alterado com sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("Não é possivel editar fornecedor com produto cadastrado");
			e.getMessage();
		}

	}
	
}
