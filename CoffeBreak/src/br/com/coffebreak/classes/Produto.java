package br.com.coffebreak.classes;

import java.io.Serializable;

public class Produto implements Serializable {

	private static final long serialVersionUID = 2L;

	private String id;
	private String idFornecedor;
	private String nome;
	private String descricao;
	private String tipo;
	private String unidadeMedida;

	// construtor
	public Produto(String id, String idFornecedor, String nome, String descricao, String tipo, String unidadeMedida) {
		super();
		this.id = id;
		this.idFornecedor = idFornecedor;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
		this.unidadeMedida = unidadeMedida;
	}

	// getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(String idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", idFornecedor=" + idFornecedor + ", nome=" + nome + ", descricao=" + descricao
				+ ", tipo=" + tipo + ", unidadeMedida=" + unidadeMedida + "]";
	}

}