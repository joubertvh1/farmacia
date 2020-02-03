package br.com.farmacia.domain;

public class Fornecedores {
	
	private Long codigo;
	private String descricao;
	private Long cnpj;
	
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
	
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	@Override
	public String toString() {
		String saida = codigo + " - " + descricao;
		return saida;
	}
	
	
	
}
