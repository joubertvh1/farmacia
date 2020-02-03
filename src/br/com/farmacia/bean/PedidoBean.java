package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.DAO.ProdutoMixDAO;
import br.com.farmacia.domain.ProdutoMix;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.util.JSFUtil;

@ManagedBean (name = "MBpedido")
@ViewScoped
public class PedidoBean {
	
	private Long numeroPedido;
	private Date dataPedido;
	private Long quantidade;
	private Produtos produtos;
	private ProdutoMix produtosMix;
	private List<Produtos> listaProdutos = new ArrayList<Produtos>();
	private List<ProdutoMix> listaProdutosMix = new ArrayList<ProdutoMix>();
	private List<ProdutoMix> listaProdutosMixFiltrado;
	private List<Produtos> listaProdutosSelecionados = new ArrayList<Produtos>();
	private List<ProdutoMix> listaProdutosMixSelecionados = new ArrayList<ProdutoMix>();
	
	
	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}



	public Date getDataPedido() {
		return dataPedido;
	}



	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}



	public Long getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}



	public Produtos getProdutos() {
		return produtos;
	}



	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}



	public List<Produtos> getListaProdutos() {
		return listaProdutos;
	}



	public void setListaProdutos(List<Produtos> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}



	public List<ProdutoMix> getListaProdutosMix() {
		return listaProdutosMix;
	}



	public void setListaProdutosMix(List<ProdutoMix> listaProdutosMix) {
		this.listaProdutosMix = listaProdutosMix;
	}



	public List<Produtos> getListaProdutosSelecionados() {
		return listaProdutosSelecionados;
	}



	public void setListaProdutosSelecionados(List<Produtos> listaProdutosSelecionados) {
		this.listaProdutosSelecionados = listaProdutosSelecionados;
	}



	public List<ProdutoMix> getListaProdutosMixSelecionados() {
		return listaProdutosMixSelecionados;
	}



	public void setListaProdutosMixSelecionados(List<ProdutoMix> listaProdutosMixSelecionados) {
		this.listaProdutosMixSelecionados = listaProdutosMixSelecionados;
	}



	public ProdutoMix getProdutosMix() {
		return produtosMix;
	}



	public void setProdutosMix(ProdutoMix produtosMix) {
		this.produtosMix = produtosMix;
	}
	
	public List<ProdutoMix> getListaProdutosMixFiltrado() {
		return listaProdutosMixFiltrado;
	}

	public void setListaProdutosMixFiltrado(List<ProdutoMix> listaProdutosMixFiltrado) {
		this.listaProdutosMixFiltrado = listaProdutosMixFiltrado;
	}

	@PostConstruct 
	public void init() {
			try {
				ProdutoMixDAO pdao = new ProdutoMixDAO();	
				listaProdutosMix = pdao.listar();
				ProdutoDAO ppdao = new ProdutoDAO();
				listaProdutos = ppdao.listar();
				}catch (SQLException e) {
				JSFUtil.adicionarMensagemErro(e.getMessage());
				e.getMessage();
			}
		}

	public void salvar(){
		System.out.println("teste");
		return;
	}
	

}
