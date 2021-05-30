package br.com.coffebreak.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.coffebreak.classes.Entrada;
import br.com.coffebreak.classes.Estoque;
import br.com.coffebreak.classes.Fornecedor;
import br.com.coffebreak.classes.Produto;
import br.com.coffebreak.classes.Saida;

public class BancoDados {

	String nome;
	String funcao;
	float pVenda;
	float pCompra;
	float saldo;
	float lucro;
	int retorno;
	int qtd;
	String dia;

	public static void insereDados(Connection con, String sql_table, String sql_data) {
		PreparedStatement ps;
		try {
			String sql = "INSERT INTO " + sql_table + " VALUES " + sql_data;
			ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void alteraDados(Connection con, String tabela, String campos, String chave) {
		PreparedStatement ps;
		try {
			String sql = "UPDATE " + tabela + " SET " + campos + " WHERE " + chave;
			ps = con.prepareStatement(sql);
			int retorno = ps.executeUpdate();
			if (retorno > 0) {
				System.out.printf("Registro alterado com sucesso");
			} else {
				System.out.println("Não foi possível alterar os registros!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void excluirRegistro(Connection con, String tabela, String chave) {
		PreparedStatement ps;
		try {
			String sql = "DELETE FROM " + tabela + " WHERE " + chave;
			ps = con.prepareStatement(sql);
			int retorno = ps.executeUpdate();
			if (retorno > 0) {
				System.out.printf("Registro excluido com sucesso");
			} else {
				System.out.println("Não foi possível excluir o registro!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Entrada> listaEntrada(Connection con, String tabela) {
		PreparedStatement ps;
		ArrayList<Entrada> listaEntrada = new ArrayList<Entrada>();
		try {
			String sql = "SELECT * FROM " + tabela;
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();

			while (retorno.next()) {
				listaEntrada.add(new Entrada(retorno.getString("id"), retorno.getString("id_Produto"),
						retorno.getString("quantidade"), retorno.getString("valor"), retorno.getString("data")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEntrada;
	}

	public static ArrayList<Estoque> listaEstoque(Connection con, String tabela) {
		PreparedStatement ps;
		ArrayList<Estoque> listaEstoque = new ArrayList<Estoque>();
		try {
			String sql = "SELECT * FROM " + tabela;
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();

			while (retorno.next()) {
				listaEstoque.add(new Estoque(retorno.getString("id"), retorno.getString("id_produto"),
						retorno.getString("quantidade"), retorno.getString("perc_lucro"),
						retorno.getString("valor_entrada"), retorno.getString("valor_saida"),
						retorno.getString("data_atualizacao")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEstoque;
	}

	public static ArrayList<Fornecedor> listaFornecedor(Connection con, String tabela) {
		PreparedStatement ps;
		ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
		try {
			String sql = "SELECT * FROM " + tabela;
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();

			while (retorno.next()) {
				listaFornecedor.add(new Fornecedor(retorno.getString("id"), retorno.getString("nome_fornecedor")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaFornecedor;
	}

	public static ArrayList<Produto> listaProduto(Connection con, String tabela) {
		PreparedStatement ps;
		ArrayList<Produto> listaProduto = new ArrayList<Produto>();
		try {
			String sql = "SELECT * FROM " + tabela;
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();

			while (retorno.next()) {
				listaProduto.add(new Produto(retorno.getString("id"), retorno.getString("id_fornecedor"),
						retorno.getString("nome"), retorno.getString("descricao"), retorno.getString("tipo"),
						retorno.getString("unidade_medida")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProduto;
	}

	public static ArrayList<Saida> listaSaida(Connection con, String tabela) {
		PreparedStatement ps;
		ArrayList<Saida> listaSaida = new ArrayList<Saida>();
		try {
			String sql = "SELECT * FROM " + tabela;
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();

			while (retorno.next()) {
				listaSaida.add(new Saida(retorno.getString("id"), retorno.getString("id_produto"),
						retorno.getString("quantidade"), retorno.getString("valor"), retorno.getString("data")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaSaida;
	}

	public void atualizaVendaEstoque(Connection con, int quantidade, String id) {
		PreparedStatement ps;
		try {
			String sql = "SELECT * " + "FROM estoque WHERE id = '" + id + "';";
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();
			if (retorno != null && retorno.next()) {
				this.setQtd(Integer.parseInt(retorno.getString("quantidade")));
				this.setQtd(this.getQtd() - quantidade);
				sql = "UPDATE estoque SET quantidade = '" + this.getQtd() + "' WHERE id = '" + id + "';";
				ps = con.prepareStatement(sql);
				int retorno2 = ps.executeUpdate();
				if (retorno2 > 0) {
					System.out.println("deu certo, alterou");
				} else {
					System.out.println("deu pau");
				}
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (java.lang.NullPointerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Oops! Algo deu errado");
		}
	}

	public void atualizaCompraEstoque(Connection con, int quantidade, String id) {
		PreparedStatement ps;
		try {
			String sql = "SELECT * " + "FROM estoque WHERE id_produto = '" + id + "';";
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();
			if (retorno != null && retorno.next()) {
				this.setQtd(Integer.parseInt(retorno.getString("quantidade")));
				this.setQtd(this.getQtd() + quantidade);
				sql = "UPDATE estoque SET quantidade = '" + this.getQtd() + "' WHERE id_produto = '" + id + "';";
				ps = con.prepareStatement(sql);
				int retorno2 = ps.executeUpdate();
				if (retorno2 > 0) {
					JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Houve um problema! Estoque não atualizado");
				}
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (java.lang.NullPointerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Oops! Algo deu errado");
		}
	}

	public float getpVenda() {
		return pVenda;
	}

	public void setpVenda(float pVenda) {
		this.pVenda = pVenda;
	}

	public float getpCompra() {
		return pCompra;
	}

	public void setpCompra(float pCompra) {
		this.pCompra = pCompra;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

}