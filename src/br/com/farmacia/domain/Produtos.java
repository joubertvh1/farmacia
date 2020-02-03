package br.com.farmacia.domain;

public class Produtos {

	
	private Long codigo;
	private String descricao;
	private Double preco;
	private Integer quantidade;
	private Fornecedores fornecedor = new Fornecedores();
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Fornecedores getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedores fornecedor) {
		this.fornecedor = fornecedor;
	}
	@Override
	public String toString() {
		return "Produtos [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
	
}
