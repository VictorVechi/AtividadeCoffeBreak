package br.com.coffebreak.classes;

import java.io.Serializable;

public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 2L;

	private String id;
	private String nomeFornecedor;

	// construtor
	public Fornecedor(String id, String nomeFornecedor) {
		super();
		this.id = id;
		this.nomeFornecedor = nomeFornecedor;
	}

	// getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	@Override
	public String toString() {
		return "Fornecedor id=" + id + ", nomeFornecedor=" + nomeFornecedor;
	}

}