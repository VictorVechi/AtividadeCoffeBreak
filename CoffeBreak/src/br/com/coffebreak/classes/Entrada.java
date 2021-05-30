package br.com.coffebreak.classes;

import java.io.Serializable;

public class Entrada implements Serializable {

	private static final long serialVersionUID = 2L;

	private String id;
	private String idProduto;
	private String quantidade;
	private String valor;
	private String data;

	// construtor

	public Entrada(String id, String idProduto, String quantidade, String valor, String data) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.data = data;
		this.valor = valor;
		this.idProduto = idProduto;
	}

	// getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", quantidade=" + quantidade + ", data=" + data + ", valor=" + valor
				+ ", idProduto=" + idProduto + "]";
	}

}