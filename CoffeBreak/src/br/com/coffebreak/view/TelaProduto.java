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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.coffebreak.classes.Produto;
import br.com.coffebreak.connection.BancoDados;
import br.com.coffebreak.connection.Conexao;

public class TelaProduto extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JPanel painelCadastro;
	private JPanel painelProduto;
	private JLabel lblIdFornecedor;
	private JLabel lblNome;
	private JLabel lblDescricao;
	private JLabel lblTipo;
	private JLabel lblUnidade;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JTextField txtIdFornecedor;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtTipo;
	private JTextField txtUnidade;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JList listProduto;
	private JButton btnAtualizar;
	@SuppressWarnings("rawtypes")
	private DefaultListModel model = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProduto frame = new TelaProduto();
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
	public TelaProduto() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 444);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(0, 0, 544, 421);
		contentPane.add(tabbedPane);

		painelCadastro = new JPanel();
		painelCadastro.setForeground(Color.BLACK);
		tabbedPane.addTab("Cadastro", null, painelCadastro, null);
		painelCadastro.setLayout(null);

		lblIdFornecedor = new JLabel("Id do Fornecedor :");
		lblIdFornecedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdFornecedor.setForeground(Color.BLACK);
		lblIdFornecedor.setBounds(10, 50, 150, 25);
		painelCadastro.add(lblIdFornecedor);

		lblNome = new JLabel("Nome do Produto : ");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setForeground(Color.BLACK);
		lblNome.setBounds(10, 110, 150, 25);
		painelCadastro.add(lblNome);

		lblDescricao = new JLabel("Descrição do Produto : ");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescricao.setForeground(Color.BLACK);
		lblDescricao.setBounds(10, 170, 150, 25);
		painelCadastro.add(lblDescricao);

		lblTipo = new JLabel("Tipo do Produto : ");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipo.setForeground(Color.BLACK);
		lblTipo.setBounds(10, 230, 150, 25);
		painelCadastro.add(lblTipo);

		lblUnidade = new JLabel("Unidade de Medida : ");
		lblUnidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUnidade.setForeground(Color.BLACK);
		lblUnidade.setBounds(10, 290, 150, 25);
		painelCadastro.add(lblUnidade);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		btnSalvar.setBackground(Color.GREEN);
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setBounds(120, 340, 100, 23);
		painelCadastro.add(btnSalvar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(this);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setBackground(Color.LIGHT_GRAY);
		btnLimpar.setForeground(Color.BLACK);
		btnLimpar.setBounds(240, 340, 100, 23);
		painelCadastro.add(btnLimpar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setBackground(Color.RED);
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBounds(360, 340, 100, 23);
		painelCadastro.add(btnVoltar);

		txtIdFornecedor = new JTextField();
		txtIdFornecedor.setBounds(170, 52, 268, 20);
		painelCadastro.add(txtIdFornecedor);
		txtIdFornecedor.setColumns(10);

		txtNome = new JTextField();
		txtNome.setBounds(170, 112, 268, 20);
		painelCadastro.add(txtNome);
		txtNome.setColumns(10);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(170, 172, 268, 20);
		painelCadastro.add(txtDescricao);
		txtDescricao.setColumns(10);

		txtTipo = new JTextField();
		txtTipo.setBounds(170, 232, 268, 20);
		painelCadastro.add(txtTipo);
		txtTipo.setColumns(10);

		txtUnidade = new JTextField();
		txtUnidade.setBounds(170, 292, 268, 20);
		painelCadastro.add(txtUnidade);
		txtUnidade.setColumns(10);

		painelProduto = new JPanel();
		tabbedPane.addTab("Produtos", null, painelProduto, null);
		painelProduto.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 538, 325);
		painelProduto.add(scrollPane);

		listProduto = new JList();
		listProduto.setBounds(242, 166, 37, -39);
		scrollPane.setViewportView(listProduto);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(this);
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtualizar.setBackground(Color.GREEN);
		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setBounds(200, 340, 120, 23);
		painelProduto.add(btnAtualizar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVoltar) {
			do_btnVoltar_actionPerformed(e);
		}
		if (e.getSource() == btnAtualizar) {
			do_btnAtualizar_actionPerformed(e);
		}
		if (e.getSource() == btnSalvar) {
			do_btnSalvar_actionPerformed(e);
		}
		if (e.getSource() == btnLimpar) {
			do_btnLimpar_actionPerformed(e);
		}
	}

	protected void do_btnLimpar_actionPerformed(ActionEvent e) {
		txtNome.setText(" ");
		txtIdFornecedor.setText(" ");
		txtDescricao.setText(" ");
		txtTipo.setText(" ");
		txtUnidade.setText(" ");
	}

	protected void do_btnSalvar_actionPerformed(ActionEvent e) {
		try {
			Produto produto = new Produto(null, txtIdFornecedor.getText(), txtNome.getText(), txtDescricao.getText(),
					txtTipo.getText(), txtUnidade.getText());
			String sql = "produto(id_fornecedor,nome,descricao,tipo,unidade_medida)";
			String data = "('" + produto.getIdFornecedor() + "','" + produto.getNome() + "','" + produto.getDescricao()
					+ "','" + produto.getTipo() + "','" + produto.getUnidadeMedida() + "')";
			BancoDados.insereDados(Conexao.conectar(), sql, data);
			Conexao.desconectar(Conexao.conectar());
			txtNome.setText(" ");
			txtIdFornecedor.setText(" ");
			txtDescricao.setText(" ");
			txtTipo.setText(" ");
			txtUnidade.setText(" ");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	protected void do_btnAtualizar_actionPerformed(ActionEvent e) {
		try {
			model.clear();
			ArrayList<Produto> lista = new ArrayList<Produto>();
			lista.addAll(BancoDados.listaProduto(Conexao.conectar(), "produto"));
			for (Produto produto : lista) {
				model.addElement("Id: " + produto.getId() + " | Id Fornecedor: " + produto.getIdFornecedor()
						+ " | Nome Produto: " + produto.getNome() + " | Descrição do Produto: " + produto.getDescricao()
						+ " | Tipo: " + produto.getTipo() + " | Unidade de Medida: " + produto.getUnidadeMedida());
			}
			listProduto.setModel(model);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}
	protected void do_btnVoltar_actionPerformed(ActionEvent e) {
		MainMenu menu = new MainMenu();
		menu.setVisible(true);
		dispose();
	}
}
