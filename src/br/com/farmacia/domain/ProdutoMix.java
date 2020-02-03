package br.com.farmacia.domain;

public class ProdutoMix {

	private Long codigo_pk;
	private Integer codigo;
	private String descricao;
	private Integer quantidade;
	private Produtos produtos = new Produtos();
	
	public Long getCodigo_pk() {
		return codigo_pk;
	}
	public void setCodigo_pk(Long codigo_pk) {
		this.codigo_pk = codigo_pk;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Produtos getProdutos() {
		return produtos;
	}
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	
	@Override
	public String toString() {
		return "Produtos [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
}
