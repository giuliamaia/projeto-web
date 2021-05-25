package model.classes;

import java.io.Serializable;


public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String codigo;
	private String descricao;
	private String preco;
	
	public Produto() {
		
	}
	
	public Produto(String codigo, String descricao, String preco) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String string) {
		this.preco = string;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + "]";
	}
	
}
