package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.DAO.ProdutoMixDAO;
import br.com.farmacia.domain.ProdutoMix;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name= "MBProdutoMix")
@ViewScoped
public class ProdutoMixBean {
	
	private ProdutoMix produtoMix;
	private ArrayList<ProdutoMix> listaProdutoMix;
	private ArrayList<ProdutoMix> produtoMixFiltro;
	private Produtos produtos;
	private ArrayList<Produtos> comboProdutos;
	
	public ProdutoMix getProdutoMix() {
		return produtoMix;
	}
	public void setProdutoMix(ProdutoMix produtoMix) {
		this.produtoMix = produtoMix;
	}
	public ArrayList<ProdutoMix> getListaProdutoMix() {
		return listaProdutoMix;
	}
	public void setListaProdutoMix(ArrayList<ProdutoMix> listaProdutoMix) {
		this.listaProdutoMix = listaProdutoMix;
	}
	public ArrayList<ProdutoMix> getProdutoMixFiltro() {
		return produtoMixFiltro;
	}
	public void setProdutoMixFiltro(ArrayList<ProdutoMix> produtoMixFiltro) {
		this.produtoMixFiltro = produtoMixFiltro;
	}
	public Produtos getProdutos() {
		return produtos;
	}
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	public ArrayList<Produtos> getComboProdutos() {
		return comboProdutos;
	}
	public void setComboProdutos(ArrayList<Produtos> comboProdutos) {
		this.comboProdutos = comboProdutos;
	}
	
	@PostConstruct
	public void prepararPesquisa()  {
		try {
			ProdutoMixDAO pdao = new ProdutoMixDAO();	
			listaProdutoMix = pdao.listar();
		}catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.getMessage();
		}
	}
	
	public void prepararNovo() {
		
		try {
			produtoMix = new ProdutoMix();
			ProdutoDAO dao = new ProdutoDAO();
			comboProdutos = dao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("Erro ao pesquisar");
			e.printStackTrace();
		}
	}
	public void novo() {
		ProdutoMixDAO pdao = new ProdutoMixDAO();	
		try {
			pdao.salvar(produtoMix);
			JSFUtil.adicionarMensagemSucesso("Salvo com sucesso");
	
			listaProdutoMix= pdao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	public void excluir() {
		ProdutoMixDAO fdao = new ProdutoMixDAO();	
		try {
			fdao.excluir(produtoMix);
	
			listaProdutoMix  = fdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Excluido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void editar() {
		try {
			ProdutoMixDAO fdao = new ProdutoMixDAO();	
			fdao.editar(produtoMix);
			
			listaProdutoMix = fdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Alterado com sucesso");
		} catch (SQLException e) {
			e.getMessage();
		}

	}
	
	public void prepararEditar() {
		try {
			produtoMix = new ProdutoMix();
			ProdutoDAO dao = new ProdutoDAO();
			comboProdutos = dao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("Erro ao pesquisar");
			e.printStackTrace();
		}
	}
	
}
