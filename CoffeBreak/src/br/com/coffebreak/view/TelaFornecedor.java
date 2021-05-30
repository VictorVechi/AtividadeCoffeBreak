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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.coffebreak.classes.Fornecedor;
import br.com.coffebreak.connection.BancoDados;
import br.com.coffebreak.connection.Conexao;

public class TelaFornecedor extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JPanel painelFornecedores;
	private JPanel painelCadastro;
	@SuppressWarnings("rawtypes")
	private JList listFornecedor;
	@SuppressWarnings("rawtypes")
	private DefaultListModel model = new DefaultListModel();
	private JLabel lblCadastro;
	private JLabel lblNome;
	private JTextField txtNome;
	private JButton btnLimpar;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private JScrollPane scrollPane;
	private JButton btnAtualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFornecedor frame = new TelaFornecedor();
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
	public TelaFornecedor() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 440);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(0, 0, 414, 411);
		contentPane.add(tabbedPane);

		painelCadastro = new JPanel();
		tabbedPane.addTab("Cadastro", null, painelCadastro, null);
		painelCadastro.setLayout(null);

		lblCadastro = new JLabel("Cadastro de Fornecedores");
		lblCadastro.setForeground(Color.BLACK);
		lblCadastro.setBounds(128, 28, 148, 32);
		lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		painelCadastro.add(lblCadastro);

		lblNome = new JLabel("Nome do fornecedor:");
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(53, 130, 120, 24);
		painelCadastro.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(183, 133, 180, 20);
		painelCadastro.add(txtNome);
		txtNome.setColumns(10);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(Color.BLACK);
		btnLimpar.setBackground(Color.LIGHT_GRAY);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.addActionListener(this);
		btnLimpar.setBounds(170, 240, 89, 23);
		painelCadastro.add(btnLimpar);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.GREEN);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setBounds(53, 240, 89, 23);
		painelCadastro.add(btnSalvar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(Color.RED);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBounds(289, 240, 89, 23);
		painelCadastro.add(btnVoltar);

		painelFornecedores = new JPanel();
		tabbedPane.addTab("Fornecedores", null, painelFornecedores, null);
		painelFornecedores.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 409, 342);
		painelFornecedores.add(scrollPane);

		listFornecedor = new JList();
		scrollPane.setViewportView(listFornecedor);
		listFornecedor.setBounds(10, 0, 409, 376);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(Color.GREEN);
		btnAtualizar.addActionListener(this);
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setBounds(151, 349, 110, 23);
		painelFornecedores.add(btnAtualizar);
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
	}

	protected void do_btnSalvar_actionPerformed(ActionEvent e) {

		try {
			Fornecedor fornecedor = new Fornecedor(null, txtNome.getText());
			String sql = "fornecedor(nome_fornecedor)";
			String data = "('" + fornecedor.getNomeFornecedor() + "')";
			BancoDados.insereDados(Conexao.conectar(), sql, data);
			Conexao.desconectar(Conexao.conectar());
			txtNome.setText(" ");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	protected void do_btnAtualizar_actionPerformed(ActionEvent e) {
		try {
			model.clear();
			ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
			lista.addAll(BancoDados.listaFornecedor(Conexao.conectar(), "fornecedor"));
			for (Fornecedor fornecedor : lista) {
				model.addElement("Id: " + fornecedor.getId() + " | Nome Fornecedor: " + fornecedor.getNomeFornecedor());
			}
			listFornecedor.setModel(model);

			Conexao.desconectar(Conexao.conectar());

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
