package br.com.coffebreak.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.coffebreak.classes.Entrada;
import br.com.coffebreak.classes.Estoque;
import br.com.coffebreak.classes.Saida;
import br.com.coffebreak.connection.BancoDados;
import br.com.coffebreak.connection.Conexao;

public class MainMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JPanel painelEstoque;
	private JPanel painelEntradaEstoque;
	private JScrollPane scrollPane;
	private JPanel painelRegEntrada;
	private JButton btnAtualizar;
	@SuppressWarnings("rawtypes")
	private JList listEstoque;
	@SuppressWarnings("rawtypes")
	private DefaultListModel model = new DefaultListModel();
	@SuppressWarnings("rawtypes")
	private DefaultListModel modelEntrada = new DefaultListModel();
	@SuppressWarnings("rawtypes")
	private DefaultListModel modelSaida = new DefaultListModel();
	private JLabel lblTitulo;
	private JLabel lblIdProduto;
	private JLabel lblQuantidade;
	private JLabel lblLucro;
	private JLabel lblEntrada;
	private JTextField txtIdProduto;
	private JTextField txtQuantidade;
	private JTextField txtPercLucro;
	private JTextField txtEntrada;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JLabel lblNewLabel;
	private JTextField txtData;
	private JPanel painelVendaEstoque;
	private JLabel lblTituloVenda;
	private JLabel lblIdProduto1;
	private JLabel lblQuantidade_1;
	private JLabel lblSaida;
	private JTextField txtQuantidadeSaida;
	private JTextField txtValorSaida;
	private JButton btnSalvarSaida;
	private JButton btnLimparSaida;
	private JLabel lblDataSaida;
	private JTextField txtDataAttSaida;
	private JLabel lblIdEstoqueSaida;
	private JTextField txtEstoqueSaida;
	private JPanel painelRegSaida;
	private JPanel painelCadastros;
	private JLabel lblTituloCadastro;
	private JButton btnFornecedor;
	private JButton btnProduto;
	private JLabel lblFormato1;
	private JLabel lblFormato2;
	private JLabel lblFormato3;
	private JTextField txtIdProdutoSaida;
	private JScrollPane scrollPane_1;
	private JButton btnRegistroEntrada;
	@SuppressWarnings("rawtypes")
	private JList listEntrada;
	private JScrollPane scrollPane_2;
	@SuppressWarnings("rawtypes")
	private JList listSaida;
	private JButton btnRegistroSaida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public MainMenu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(0, 0, 594, 371);
		contentPane.add(tabbedPane);

		painelVendaEstoque = new JPanel();
		painelVendaEstoque.setLayout(null);
		tabbedPane.addTab("Venda", null, painelVendaEstoque, null);

		lblTituloVenda = new JLabel("Saída do Estoque");
		lblTituloVenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVenda.setForeground(Color.BLACK);
		lblTituloVenda.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloVenda.setBounds(0, 11, 589, 14);
		painelVendaEstoque.add(lblTituloVenda);

		lblIdProduto1 = new JLabel("Id do Produto :");
		lblIdProduto1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdProduto1.setBounds(10, 60, 150, 14);
		painelVendaEstoque.add(lblIdProduto1);

		lblQuantidade_1 = new JLabel("Quantidade :");
		lblQuantidade_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantidade_1.setBounds(10, 100, 150, 14);
		painelVendaEstoque.add(lblQuantidade_1);

		lblSaida = new JLabel("Valor de venda do produto :");
		lblSaida.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSaida.setBounds(10, 140, 168, 14);
		painelVendaEstoque.add(lblSaida);

		txtQuantidadeSaida = new JTextField();
		txtQuantidadeSaida.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantidadeSaida.setColumns(10);
		txtQuantidadeSaida.setBounds(170, 97, 290, 20);
		painelVendaEstoque.add(txtQuantidadeSaida);

		txtValorSaida = new JTextField();
		txtValorSaida.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorSaida.setColumns(10);
		txtValorSaida.setBounds(170, 137, 290, 20);
		painelVendaEstoque.add(txtValorSaida);

		btnSalvarSaida = new JButton("Salvar");
		btnSalvarSaida.addActionListener(this);
		btnSalvarSaida.setForeground(Color.BLACK);
		btnSalvarSaida.setBackground(Color.GREEN);
		btnSalvarSaida.setBounds(190, 285, 89, 23);
		painelVendaEstoque.add(btnSalvarSaida);

		btnLimparSaida = new JButton("Limpar");
		btnLimparSaida.setForeground(Color.BLACK);
		btnLimparSaida.setBackground(Color.LIGHT_GRAY);
		btnLimparSaida.setBounds(330, 285, 89, 23);
		painelVendaEstoque.add(btnLimparSaida);

		lblDataSaida = new JLabel("Data :");
		lblDataSaida.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataSaida.setBounds(10, 180, 150, 14);
		painelVendaEstoque.add(lblDataSaida);

		txtDataAttSaida = new JTextField();
		txtDataAttSaida.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataAttSaida.setColumns(10);
		txtDataAttSaida.setBounds(170, 177, 290, 20);
		painelVendaEstoque.add(txtDataAttSaida);

		lblIdEstoqueSaida = new JLabel("Id do estoque :");
		lblIdEstoqueSaida.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdEstoqueSaida.setBounds(10, 220, 116, 14);
		painelVendaEstoque.add(lblIdEstoqueSaida);

		txtEstoqueSaida = new JTextField();
		txtEstoqueSaida.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstoqueSaida.setColumns(10);
		txtEstoqueSaida.setBounds(170, 217, 290, 20);
		painelVendaEstoque.add(txtEstoqueSaida);

		lblFormato1 = new JLabel("Insira no formato 0.0");
		lblFormato1.setBounds(459, 140, 120, 14);
		painelVendaEstoque.add(lblFormato1);

		txtIdProdutoSaida = new JTextField();
		txtIdProdutoSaida.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdProdutoSaida.setBounds(170, 57, 290, 20);
		painelVendaEstoque.add(txtIdProdutoSaida);
		txtIdProdutoSaida.setColumns(10);

		painelEntradaEstoque = new JPanel();
		tabbedPane.addTab("Entrada", null, painelEntradaEstoque, null);
		painelEntradaEstoque.setLayout(null);

		lblTitulo = new JLabel("Entrada do Estoque");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setBounds(0, 11, 589, 14);
		painelEntradaEstoque.add(lblTitulo);

		lblIdProduto = new JLabel("Id do Produto :");
		lblIdProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdProduto.setBounds(10, 60, 150, 14);
		painelEntradaEstoque.add(lblIdProduto);

		lblQuantidade = new JLabel("Quantidade :");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantidade.setBounds(10, 100, 150, 14);
		painelEntradaEstoque.add(lblQuantidade);

		lblLucro = new JLabel("Porcentagem de lucro :");
		lblLucro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLucro.setBounds(10, 140, 150, 14);
		painelEntradaEstoque.add(lblLucro);

		lblEntrada = new JLabel("Valor pago pelo produto :");
		lblEntrada.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEntrada.setBounds(10, 180, 150, 14);
		painelEntradaEstoque.add(lblEntrada);

		txtIdProduto = new JTextField();
		txtIdProduto.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdProduto.setBounds(170, 57, 290, 20);
		painelEntradaEstoque.add(txtIdProduto);
		txtIdProduto.setColumns(10);

		txtQuantidade = new JTextField();
		txtQuantidade.setLocation(170, 97);
		txtQuantidade.setSize(290, 20);
		txtQuantidade.setHorizontalAlignment(SwingConstants.CENTER);

		painelEntradaEstoque.add(txtQuantidade);
		txtQuantidade.setColumns(10);

		txtPercLucro = new JTextField();
		txtPercLucro.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercLucro.setBounds(170, 137, 290, 20);
		painelEntradaEstoque.add(txtPercLucro);
		txtPercLucro.setColumns(10);

		txtEntrada = new JTextField();
		txtEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		txtEntrada.setBounds(170, 177, 290, 20);
		painelEntradaEstoque.add(txtEntrada);
		txtEntrada.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		btnSalvar.setBackground(Color.GREEN);
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBounds(190, 285, 89, 23);
		painelEntradaEstoque.add(btnSalvar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(Color.LIGHT_GRAY);
		btnLimpar.setForeground(Color.BLACK);
		btnLimpar.setBounds(330, 285, 89, 23);
		painelEntradaEstoque.add(btnLimpar);

		lblNewLabel = new JLabel("Data :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 220, 150, 14);
		painelEntradaEstoque.add(lblNewLabel);

		txtData = new JTextField();
		txtData.setHorizontalAlignment(SwingConstants.CENTER);
		txtData.setBounds(170, 221, 290, 20);
		painelEntradaEstoque.add(txtData);
		txtData.setColumns(10);

		lblFormato2 = new JLabel("Insira no formato 0.0");
		lblFormato2.setBounds(459, 140, 120, 14);
		painelEntradaEstoque.add(lblFormato2);

		lblFormato3 = new JLabel("Insira no formato 0.0");
		lblFormato3.setBounds(459, 180, 120, 14);
		painelEntradaEstoque.add(lblFormato3);

		painelEstoque = new JPanel();
		tabbedPane.addTab("Estoque", null, painelEstoque, null);
		painelEstoque.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 585, 287);
		painelEstoque.add(scrollPane);

		listEstoque = new JList();
		scrollPane.setViewportView(listEstoque);

		btnAtualizar = new JButton("Atualizar Estoque");
		btnAtualizar.addActionListener(this);
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtualizar.setBackground(Color.GREEN);
		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setBounds(224, 290, 145, 23);
		painelEstoque.add(btnAtualizar);

		painelRegEntrada = new JPanel();
		tabbedPane.addTab("Registro Entradas", null, painelRegEntrada, null);
		painelRegEntrada.setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 585, 287);
		painelRegEntrada.add(scrollPane_1);

		listEntrada = new JList();
		scrollPane_1.setViewportView(listEntrada);

		btnRegistroEntrada = new JButton("Atualizar");
		btnRegistroEntrada.addActionListener(this);
		btnRegistroEntrada.setForeground(Color.BLACK);
		btnRegistroEntrada.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistroEntrada.setBackground(Color.GREEN);
		btnRegistroEntrada.setBounds(224, 290, 145, 23);
		painelRegEntrada.add(btnRegistroEntrada);

		painelRegSaida = new JPanel();
		tabbedPane.addTab("Registros de Saidas", null, painelRegSaida, null);
		painelRegSaida.setLayout(null);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 585, 287);
		painelRegSaida.add(scrollPane_2);

		listSaida = new JList();
		scrollPane_2.setViewportView(listSaida);

		btnRegistroSaida = new JButton("Atualizar");
		btnRegistroSaida.addActionListener(this);
		btnRegistroSaida.setForeground(Color.BLACK);
		btnRegistroSaida.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistroSaida.setBackground(Color.GREEN);
		btnRegistroSaida.setBounds(224, 290, 145, 23);
		painelRegSaida.add(btnRegistroSaida);

		painelCadastros = new JPanel();
		tabbedPane.addTab("Cadastros", null, painelCadastros, null);
		painelCadastros.setLayout(null);

		lblTituloCadastro = new JLabel("Cadastro de Produtos e Fornecedores");
		lblTituloCadastro.setForeground(Color.BLACK);
		lblTituloCadastro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTituloCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloCadastro.setBounds(0, 29, 589, 20);
		painelCadastros.add(lblTituloCadastro);

		btnFornecedor = new JButton("Fornecedor");
		btnFornecedor.addActionListener(this);
		btnFornecedor.setBackground(Color.LIGHT_GRAY);
		btnFornecedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFornecedor.setForeground(Color.BLACK);
		btnFornecedor.setBounds(165, 160, 100, 23);
		painelCadastros.add(btnFornecedor);

		btnProduto = new JButton("Produto");
		btnProduto.addActionListener(this);
		btnProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProduto.setForeground(Color.BLACK);
		btnProduto.setBackground(Color.LIGHT_GRAY);
		btnProduto.setBounds(316, 160, 100, 23);
		painelCadastros.add(btnProduto);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProduto) {
			do_btnProduto_actionPerformed(e);
		}
		if (e.getSource() == btnRegistroSaida) {
			do_btnRegistroSaida_actionPerformed(e);
		}
		if (e.getSource() == btnRegistroEntrada) {
			do_btnRegistroEntrada_actionPerformed(e);
		}
		if (e.getSource() == btnSalvarSaida) {
			do_btnSalvarSaida_actionPerformed(e);
		}
		if (e.getSource() == btnFornecedor) {
			do_btnFornecedor_actionPerformed(e);
		}
		if (e.getSource() == btnSalvar) {
			do_btnSalvar_actionPerformed(e);
		}
		if (e.getSource() == btnAtualizar) {
			do_btnAtualizar_actionPerformed(e);
		}
	}

	@SuppressWarnings("unchecked")
	protected void do_btnAtualizar_actionPerformed(ActionEvent e) {

		try {
			model.clear();
			ArrayList<Estoque> lista = new ArrayList<Estoque>();
			lista.addAll(BancoDados.listaEstoque(Conexao.conectar(), "estoque"));
			for (Estoque estoque : lista) {
				model.addElement("Id: " + estoque.getId() + " | Id do Produto: " + estoque.getIdProduto()
						+ " | Quantidade: " + estoque.getQuantidade() + " | Lucro Aplicado: " + estoque.getPercLucro()
						+ " | Valor de Entrada (unidade): R$" + estoque.getValorEntrada()
						+ " | Valor de Saída(unidade): R$" + estoque.getValorSaida() + " | Data da Atualização: "
						+ estoque.getDataAtualização());
			}
			listEstoque.setModel(model);
			Conexao.desconectar(Conexao.conectar());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	protected void do_btnSalvar_actionPerformed(ActionEvent e) {

		try {
			Entrada entrada = new Entrada(null, txtIdProduto.getText(), txtQuantidade.getText(), txtEntrada.getText(),
					txtData.getText());
			String sql = "estoque_entrada(id_produto,quantidade,valor,data)";
			String data = "('" + entrada.getIdProduto() + "','" + entrada.getQuantidade() + "','" + entrada.getValor()
					+ "','" + entrada.getData() + "')";
			BancoDados.insereDados(Conexao.conectar(), sql, data);
			Conexao.desconectar(Conexao.conectar());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}

		String res = JOptionPane.showInputDialog(
				"Escreva -atualizar- para atualizar o estoque, ou deixe em branco para adicionar ao estoque");
		if (res.equalsIgnoreCase("atualizar")) {
			try {
				BancoDados bd = new BancoDados();
				String sql = "estoque_entrada(id_produto,quantidade,valor,data)";
				String data = "('" + txtIdProduto.getText() + "','" + txtQuantidade.getText() + "','"
						+ txtEntrada.getText() + "','" + txtData.getText() + "')";
				BancoDados.insereDados(Conexao.conectar(), sql, data);
				int quantidade = Integer.parseInt(txtQuantidade.getText());
				bd.atualizaCompraEstoque(Conexao.conectar(), quantidade, txtIdProduto.getText());
				Conexao.desconectar(Conexao.conectar());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

		} else {
			try {
				double lucro = Double.parseDouble(txtPercLucro.getText());
				double valor = Double.parseDouble(txtEntrada.getText());
				double result = lucro * valor;
				double total = valor + result;
				String valorSaida = Double.toString(total);
				Estoque estoque = new Estoque(null, txtIdProduto.getText(), txtQuantidade.getText(),
						txtPercLucro.getText(), txtEntrada.getText(), valorSaida, txtData.getText());
				String sql = "estoque(id_produto,quantidade,perc_lucro,valor_entrada,valor_saida,data_atualizacao)";
				String data = "('" + estoque.getIdProduto() + "','" + estoque.getQuantidade() + "','"
						+ estoque.getPercLucro() + "','" + estoque.getValorEntrada() + "','" + estoque.getValorSaida()
						+ "','" + estoque.getDataAtualização() + "')";
				BancoDados.insereDados(Conexao.conectar(), sql, data);
				Conexao.desconectar(Conexao.conectar());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

		}
		txtIdProduto.setText(" ");
		txtData.setText(" ");
		txtEntrada.setText(" ");
		txtPercLucro.setText(" ");
		txtQuantidade.setText(" ");

	}

	protected void do_btnFornecedor_actionPerformed(ActionEvent e) {
		TelaFornecedor telaFornecedor = new TelaFornecedor();
		telaFornecedor.setVisible(true);
		dispose();
	}

	protected void do_btnSalvarSaida_actionPerformed(ActionEvent e) {

		try {
			BancoDados bd = new BancoDados();
			String sql = "estoque_saida(id_produto,quantidade,valor,data)";
			String data = "('" + txtIdProdutoSaida.getText() + "','" + txtQuantidadeSaida.getText() + "','"
					+ txtValorSaida.getText() + "','" + txtDataAttSaida.getText() + "')";
			BancoDados.insereDados(Conexao.conectar(), sql, data);
			int quantidade = Integer.parseInt(txtQuantidadeSaida.getText());
			bd.atualizaVendaEstoque(Conexao.conectar(), quantidade, txtIdProdutoSaida.getText());
			Conexao.desconectar(Conexao.conectar());
			txtDataAttSaida.setText(" ");
			txtEstoqueSaida.setText(" ");
			txtIdProdutoSaida.setText(" ");
			txtQuantidadeSaida.setText(" ");
			txtValorSaida.setText(" ");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	protected void do_btnRegistroEntrada_actionPerformed(ActionEvent e) {

		try {
			modelEntrada.clear();
			ArrayList<Entrada> lista = new ArrayList<Entrada>();
			lista.addAll(BancoDados.listaEntrada(Conexao.conectar(), "estoque_entrada"));
			for (Entrada entrada : lista) {
				double valorEntrada = Double.parseDouble(entrada.getValor());
				int quantidade = Integer.parseInt(entrada.getQuantidade());
				valorEntrada *= quantidade;
				String total = Double.toString(valorEntrada);
				modelEntrada.addElement("Id: " + entrada.getId() + " | Id do Produto: " + entrada.getIdProduto()
						+ " | Quantidade: " + entrada.getQuantidade() + " | Valor pago no total: R$" + total
						+ " | Data da aquisição: " + entrada.getData());
			}
			listEntrada.setModel(modelEntrada);
			Conexao.desconectar(Conexao.conectar());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	protected void do_btnRegistroSaida_actionPerformed(ActionEvent e) {
		try {
			modelSaida.clear();
			ArrayList<Saida> lista = new ArrayList<Saida>();
			lista.addAll(BancoDados.listaSaida(Conexao.conectar(), "estoque_saida"));
			for (Saida saida : lista) {
				modelSaida.addElement(
						"Id: " + saida.getId() + " | Id do Produto: " + saida.getProdutoId() + " | Quantidade: "
								+ saida.getQuantidade() + " | Lucro total (valor de venda - valor de compra): R$"
								+ saida.getValor() + " | Data da aquisição: " + saida.getData());
			}
			listSaida.setModel(modelSaida);
			Conexao.desconectar(Conexao.conectar());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	protected void do_btnProduto_actionPerformed(ActionEvent e) {
		TelaProduto telaProduto = new TelaProduto();
		telaProduto.setVisible(true);
		dispose();
	}
}