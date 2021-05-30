package br.com.coffebreak.classes;

import java.io.Serializable;

public class Estoque implements Serializable {

	private static final long serialVersionUID = 2L;

	private String id;
	private String quantidade;
	private String valorEntrada;
	private String valorSaida;
	private String idProduto;
	private String percLucro;
	private String dataAtualização;

	// construtor
	public Estoque(String id, String idProduto, String quantidade, String percLucro, String valorEntrada,
			String valorSaida, String dataAtualização) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valorEntrada = valorEntrada;
		this.valorSaida = valorSaida;
		this.idProduto = idProduto;
		this.percLucro = percLucro;
		this.dataAtualização = dataAtualização;
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

	public String getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(String valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public String getValorSaida() {
		return valorSaida;
	}

	public void setValorSaida(String valorSaida) {
		this.valorSaida = valorSaida;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getPercLucro() {
		return percLucro;
	}

	public void setPercLucro(String percLucro) {
		this.percLucro = percLucro;
	}

	public String getDataAtualização() {
		return dataAtualização;
	}

	public void setDataAtualização(String dataAtualização) {
		this.dataAtualização = dataAtualização;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", quantidade=" + quantidade + ", valorEntrada=" + valorEntrada + ", valorSaida="
				+ valorSaida + ", idProduto=" + idProduto + ", percLucro=" + percLucro + ", dataAtualização="
				+ dataAtualização + "]";
	}

}