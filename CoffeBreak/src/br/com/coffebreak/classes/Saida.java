package br.com.coffebreak.classes;

import java.io.Serializable;

public class Saida implements Serializable {

	private static final long serialVersionUID = 2L;

	private String id;
	private String idProduto;
	private String quantidade;
	private String valor;
	private String data;

	// construtor
	public Saida(String id, String idProduto, String quantidade, String valor, String data) {
		super();
		this.id = id;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.valor = valor;
		this.data = data;
	}

	// getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProdutoId() {
		return idProduto;
	}

	public void setProdutoId(String produto_id) {
		this.idProduto = produto_id;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Saida [id=" + id + ", produto_id=" + idProduto + ", quantidade=" + quantidade + ", valor=" + valor
				+ ", data=" + data + "]";
	}

}