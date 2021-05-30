package br.com.coffebreak.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TelaDeInicio extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnEntrar;
	private JLabel lblTitulo;
	private JLabel lblInfo1;
	private JLabel lblInfo2;
	private JLabel lblInfo3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeInicio frame = new TelaDeInicio();
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
	public TelaDeInicio() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(this);
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrar.setBackground(Color.GREEN);
		btnEntrar.setBounds(173, 211, 89, 23);
		contentPane.add(btnEntrar);
		
		lblTitulo = new JLabel("Coffe Break Bar");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 11, 444, 23);
		contentPane.add(lblTitulo);
		
		lblInfo1 = new JLabel("Esse sistema está em ");
		lblInfo1.setBounds(10, 109, 136, 14);
		contentPane.add(lblInfo1);
		
		lblInfo2 = new JLabel("Fase de teste");
		lblInfo2.setBounds(10, 123, 115, 14);
		contentPane.add(lblInfo2);
		
		lblInfo3 = new JLabel("Por favor seja paciente");
		lblInfo3.setBounds(10, 138, 143, 14);
		contentPane.add(lblInfo3);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEntrar) {
			do_btnEntrar_actionPerformed(e);
		}
	}
	protected void do_btnEntrar_actionPerformed(ActionEvent e) {
		MainMenu menu = new MainMenu();
		menu.setVisible(true);
		dispose();
	}
}
