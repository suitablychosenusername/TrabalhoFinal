package br.com.hotel.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import br.com.hotel.controller.ChaleController;
import br.com.hotel.controller.ClienteController;
import br.com.hotel.controller.HospedagemController;
import br.com.hotel.model.Chale;
import br.com.hotel.model.Cliente;
import br.com.hotel.model.Hospedagem;
import java.util.List;
import javax.swing.JCheckBox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JComboBox;

public class GUIConsulta {

	private JFrame frmGerenciamentoHotel;
	private JTable clienteTBL;
	private JTextField txtCodCliente;
	private JTextField txtRgCliente;
	private JTextField txtNome;
	private JTextField txtNascimentoCliente;
	private JTextField txtEnderecoCliente;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstadoCliente;
	private JTextField txtCep;
	private JTable hospedagemTBL;
	private JTextField txtCodHosp;
	private JTextField txtCodChaleHosp;
	private JTextField txtDataInicio;
	private JTextField txtDataFim;
	private JTextField txtQtdPessoas;
	private JTextField txtDesconto;
	private JTextField txtVFinal;
	private JTable chaleTBL;
	private JTextField txtCodChale;
	private JTextField txtLocalizacao;
	private JTextField txtVAE;
	private JTextField txtVBE;
	private JTextField txtCapacidade;
	private JTextField txtEstado;
	private ChaleController chaleControl;
	private HospedagemController hospControl;
	private ClienteController clienteControl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConsulta window = new GUIConsulta();
					window.frmGerenciamentoHotel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIConsulta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		clienteControl = new ClienteController();
		hospControl = new HospedagemController();
		chaleControl = new ChaleController();
		
		frmGerenciamentoHotel = new JFrame();
		frmGerenciamentoHotel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmGerenciamentoHotel.setVisible(true);
		frmGerenciamentoHotel.setTitle("Gerenciamento Hotel");
		frmGerenciamentoHotel.setBounds(100, 100, 1110, 444);
		frmGerenciamentoHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane Consutas = new JTabbedPane(JTabbedPane.TOP);
		Consutas.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		GroupLayout groupLayout = new GroupLayout(frmGerenciamentoHotel.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(Consutas)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(Consutas, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
		);
		
		JPanel clienteTAB = new JPanel();
		Consutas.addTab("Clientes", null, clienteTAB, null);
		
		JScrollPane abaCliente = new JScrollPane();
		abaCliente.setAutoscrolls(true);
		abaCliente.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		abaCliente.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		abaCliente.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		clienteTBL = new JTable();
		
		clienteTBL.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		clienteTBL.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "RG", "Endere\u00E7o", "Bairro", "Cidade", "Estado", "CEP", "Data Nascimento"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		clienteTBL.getColumnModel().getColumn(0).setMinWidth(70);
		clienteTBL.getColumnModel().getColumn(1).setMinWidth(200);
		clienteTBL.getColumnModel().getColumn(2).setMinWidth(100);
		clienteTBL.getColumnModel().getColumn(3).setMinWidth(200);
		clienteTBL.getColumnModel().getColumn(4).setMinWidth(70);
		clienteTBL.getColumnModel().getColumn(5).setMinWidth(70);
		clienteTBL.getColumnModel().getColumn(6).setPreferredWidth(43);
		clienteTBL.getColumnModel().getColumn(6).setMinWidth(43);
		clienteTBL.getColumnModel().getColumn(7).setMinWidth(70);
		clienteTBL.getColumnModel().getColumn(8).setPreferredWidth(95);
		clienteTBL.getColumnModel().getColumn(8).setMinWidth(95);
		abaCliente.setViewportView(clienteTBL);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		
		txtCodCliente = new JTextField();
		txtCodCliente.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("RG");
		
		txtRgCliente = new JTextField();
		txtRgCliente.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data Nasc.");
		
		txtNascimentoCliente = new JTextField();
		txtNascimentoCliente.setColumns(10);
		
		txtEnderecoCliente = new JTextField();
		txtEnderecoCliente.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Endere\u00E7o");
		
		JLabel lblNewLabel_5 = new JLabel("Bairro");
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Cidade");
		
		JLabel lblNewLabel_7 = new JLabel("Estado");
		
		txtEstadoCliente = new JTextField();
		txtEstadoCliente.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("CEP");
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search(clienteControl);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Listar todos");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listAll(clienteControl);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Limpar");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearTable(clienteTBL);
			}
		});
		
		JButton btnNewButton_12 = new JButton("Deletar");
		btnNewButton_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delete(clienteControl);
			}
		});
		
		JButton btnNewButton_13 = new JButton("Inserir");
		btnNewButton_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert(clienteControl);
			}
		});
		
		JButton btnNewButton_15 = new JButton("Alterar");
		btnNewButton_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alt(clienteControl);
			}
		});
		GroupLayout gl_clienteTAB = new GroupLayout(clienteTAB);
		gl_clienteTAB.setHorizontalGroup(
			gl_clienteTAB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_clienteTAB.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_clienteTAB.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_clienteTAB.createSequentialGroup()
							.addComponent(abaCliente, GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_clienteTAB.createSequentialGroup()
							.addGroup(gl_clienteTAB.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_clienteTAB.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_clienteTAB.createSequentialGroup()
									.addComponent(txtNascimentoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
									.addGap(27))
								.addGroup(gl_clienteTAB.createSequentialGroup()
									.addComponent(txtCodCliente, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtRgCliente, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_clienteTAB.createSequentialGroup()
									.addGroup(gl_clienteTAB.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_clienteTAB.createSequentialGroup()
											.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel_6)
											.addGap(18)
											.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel_7)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtEstadoCliente, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_clienteTAB.createSequentialGroup()
											.addComponent(txtEnderecoCliente, GroupLayout.PREFERRED_SIZE, 696, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel_8)
											.addGap(12)
											.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
									.addGap(26)))
							.addGap(37))
						.addGroup(gl_clienteTAB.createSequentialGroup()
							.addGroup(gl_clienteTAB.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_clienteTAB.createSequentialGroup()
									.addComponent(btnNewButton_13, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_clienteTAB.createSequentialGroup()
									.addComponent(btnNewButton_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_15)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_12)
							.addContainerGap())))
		);
		gl_clienteTAB.setVerticalGroup(
			gl_clienteTAB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_clienteTAB.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_clienteTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtCodCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtRgCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_clienteTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtNascimentoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_clienteTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEnderecoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_clienteTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEstadoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_5)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_clienteTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_13)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_clienteTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_15)
						.addComponent(btnNewButton_12))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(abaCliente, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addContainerGap())
		);
		clienteTAB.setLayout(gl_clienteTAB);
		
		JPanel hospedagemTAB = new JPanel();
		Consutas.addTab("Hospedagem", null, hospedagemTAB, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setAutoscrolls(true);
		
		txtCodHosp = new JTextField();
		txtCodHosp.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("C\u00F3digo");
		
		JLabel lblNewLabel_10 = new JLabel("C\u00F3d. Chal\u00E9");
		
		txtCodChaleHosp = new JTextField();
		txtCodChaleHosp.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Estado");
		
		txtDataInicio = new JTextField();
		txtDataInicio.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Data Fim");
		
		txtDataFim = new JTextField();
		txtDataFim.setColumns(10);
		
		txtQtdPessoas = new JTextField();
		txtQtdPessoas.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Qtd. Pessoas");
		
		JLabel lblNewLabel_15 = new JLabel("Desconto (%)");
		
		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		
		JCheckBox altaEstacao = new JCheckBox("Alta Esta\u00E7\u00E3o");
		
		JLabel lblNewLabel_16 = new JLabel("Valor Final (R$)");
		
		txtVFinal = new JTextField();
		txtVFinal.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Pesquisar");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search(hospControl);
			}
		});
		
		JButton btnNewButton_4 = new JButton("Listar todos");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listAll(hospControl);
			}
		});
		
		JButton btnNewButton_5 = new JButton("Limpar");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearTable(hospedagemTBL);
			}
		});
		
		JButton btnNewButton_11 = new JButton("Deletar");
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delete(hospControl);
			}
		});
		
		JButton btnNewButton_14 = new JButton("Inserir");
		btnNewButton_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert(hospControl, chaleControl, altaEstacao);
			}
		});
		
		JLabel lblNewLabel_12 = new JLabel("Data Inicio");
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		
		JButton btnNewButton_17 = new JButton("Alterar");
		
		btnNewButton_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alt(hospControl, chaleControl, altaEstacao);
			}
		});
		
		GroupLayout gl_hospedagemTAB = new GroupLayout(hospedagemTAB);
		gl_hospedagemTAB.setHorizontalGroup(
			gl_hospedagemTAB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hospedagemTAB.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1079, Short.MAX_VALUE)
						.addGroup(gl_hospedagemTAB.createSequentialGroup()
							.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_9)
								.addComponent(lblNewLabel_14)
								.addComponent(lblNewLabel_15)
								.addComponent(lblNewLabel_11))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.LEADING)
								.addComponent(txtQtdPessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_hospedagemTAB.createSequentialGroup()
										.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(altaEstacao)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_16)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtVFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_hospedagemTAB.createSequentialGroup()
										.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_hospedagemTAB.createSequentialGroup()
												.addGap(1)
												.addComponent(txtCodHosp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_12)
											.addComponent(lblNewLabel_10))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txtCodChaleHosp, 0, 0, Short.MAX_VALUE)
											.addComponent(txtDataInicio, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblNewLabel_13)
										.addGap(4)
										.addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, 616, Short.MAX_VALUE))
						.addGroup(gl_hospedagemTAB.createSequentialGroup()
							.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_hospedagemTAB.createSequentialGroup()
									.addComponent(btnNewButton_14, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_hospedagemTAB.createSequentialGroup()
									.addComponent(btnNewButton_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_5, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_17)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_11)))
					.addContainerGap())
		);
		gl_hospedagemTAB.setVerticalGroup(
			gl_hospedagemTAB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hospedagemTAB.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(txtCodHosp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_10)
						.addComponent(txtCodChaleHosp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_11)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_12)
						.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_13)
						.addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_14)
						.addComponent(txtQtdPessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_15)
						.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(altaEstacao)
						.addComponent(txtVFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_16))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_14)
						.addComponent(btnNewButton_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_hospedagemTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_17)
						.addComponent(btnNewButton_11))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		hospedagemTBL = new JTable();
		scrollPane.setViewportView(hospedagemTBL);
		hospedagemTBL.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "C\u00F3d. Chal\u00E9", "Estado", "Data In\u00EDcio", "Data Fim", "Qtd. Pessoas", "Desconto (%)", "Valor Final (R$)"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		hospedagemTBL.getColumnModel().getColumn(0).setMinWidth(70);
		hospedagemTBL.getColumnModel().getColumn(1).setMinWidth(75);
		hospedagemTBL.getColumnModel().getColumn(2).setMinWidth(75);
		hospedagemTBL.getColumnModel().getColumn(3).setMinWidth(75);
		hospedagemTBL.getColumnModel().getColumn(4).setMinWidth(75);
		hospedagemTBL.getColumnModel().getColumn(5).setMinWidth(70);
		hospedagemTBL.getColumnModel().getColumn(6).setMinWidth(80);
		hospedagemTBL.getColumnModel().getColumn(7).setMinWidth(85);
		hospedagemTAB.setLayout(gl_hospedagemTAB);

		JPanel chaleTAB = new JPanel();
		Consutas.addTab("Chal\u00E9s", null, chaleTAB, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		txtCodChale = new JTextField();
		txtCodChale.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("C\u00F3digo");
		
		txtLocalizacao = new JTextField();
		txtLocalizacao.setColumns(10);
		
		txtVAE = new JTextField();
		txtVAE.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("Localiza\u00E7\u00E3o");
		
		JLabel lblNewLabel_19 = new JLabel("Valor Alta Esta\u00E7ao (R$)");
		
		JLabel lblNewLabel_20 = new JLabel("Valor Baixa Esta\u00E7ao (R$)");
		
		txtVBE = new JTextField();
		txtVBE.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("Capacidade");
		
		txtCapacidade = new JTextField();
		txtCapacidade.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Pesquisar");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search(chaleControl);
			}
		});
		
		JButton btnNewButton_7 = new JButton("Listar todos");
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listAll(chaleControl);
			}
		});
		
		JButton btnNewButton_8 = new JButton("Limpar");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearTable(chaleTBL);
			}
		});
		
		JButton btnNewButton_9 = new JButton("Inserir");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert(chaleControl);
			}
		});
		
		JButton btnNewButton_10 = new JButton("Deletar");
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delete(chaleControl, hospControl);
			}
		});
		
		JButton btnNewButton_16 = new JButton("Alterar");
		btnNewButton_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alt(chaleControl);
			}
		});
		GroupLayout gl_chaleTAB = new GroupLayout(chaleTAB);
		gl_chaleTAB.setHorizontalGroup(
			gl_chaleTAB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_chaleTAB.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_chaleTAB.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE)
						.addGroup(gl_chaleTAB.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_chaleTAB.createSequentialGroup()
								.addGroup(gl_chaleTAB.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_17)
									.addComponent(lblNewLabel_18))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_chaleTAB.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_chaleTAB.createSequentialGroup()
										.addComponent(txtLocalizacao, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblNewLabel_21)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
									.addComponent(txtCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_chaleTAB.createSequentialGroup()
								.addGroup(gl_chaleTAB.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, gl_chaleTAB.createSequentialGroup()
										.addGroup(gl_chaleTAB.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_chaleTAB.createSequentialGroup()
												.addComponent(btnNewButton_9, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(btnNewButton_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGroup(gl_chaleTAB.createSequentialGroup()
												.addComponent(btnNewButton_7)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnNewButton_8, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnNewButton_16)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnNewButton_10))
									.addGroup(Alignment.LEADING, gl_chaleTAB.createSequentialGroup()
										.addComponent(lblNewLabel_19)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtVAE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblNewLabel_20)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtVBE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_chaleTAB.setVerticalGroup(
			gl_chaleTAB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_chaleTAB.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_chaleTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_17)
						.addComponent(txtCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_chaleTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtLocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_18)
						.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_21))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_chaleTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_19)
						.addComponent(txtVAE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_20)
						.addComponent(txtVBE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_chaleTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_9)
						.addComponent(btnNewButton_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_chaleTAB.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_7)
						.addComponent(btnNewButton_8)
						.addComponent(btnNewButton_16)
						.addComponent(btnNewButton_10))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		chaleTBL = new JTable();
		chaleTBL.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Localiza\u00E7\u00E3o", "Capacidade", "Valor Alta Esta\u00E7\u00E3o (R$)", "Valor Baixa Esta\u00E7\u00E3o (R$)"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		chaleTBL.getColumnModel().getColumn(0).setMinWidth(75);
		chaleTBL.getColumnModel().getColumn(1).setMinWidth(75);
		chaleTBL.getColumnModel().getColumn(2).setMinWidth(75);
		chaleTBL.getColumnModel().getColumn(3).setPreferredWidth(115);
		chaleTBL.getColumnModel().getColumn(3).setMinWidth(124);
		chaleTBL.getColumnModel().getColumn(4).setMinWidth(128);
		scrollPane_1.setViewportView(chaleTBL);
		chaleTAB.setLayout(gl_chaleTAB);
		frmGerenciamentoHotel.getContentPane().setLayout(groupLayout);
	}

	private void listAll(ClienteController clienteControl) {
		List<Cliente> lista = clienteControl.listAll();
		DefaultTableModel tableModel = (DefaultTableModel) clienteTBL.getModel();
		for(int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		int i = 0;
		for (Cliente x : lista) {
			tableModel.addRow(new String[1]);
			clienteTBL.setValueAt(x.getCodCliente(), i, 0);
			clienteTBL.setValueAt(x.getNomeCliente(), i, 1);
			clienteTBL.setValueAt(x.getRgCliente(), i, 2);
			clienteTBL.setValueAt(x.getEnderecoCliente(), i, 3);
			clienteTBL.setValueAt(x.getBairroCliente(), i, 4);
			clienteTBL.setValueAt(x.getCidadeCliente(), i, 5);
			clienteTBL.setValueAt(x.getEstadoCliente(), i, 6);
			clienteTBL.setValueAt(x.getCepCliente(), i, 7);
			clienteTBL.setValueAt(x.getNascimentoCliente(), i, 8);
			i++;
		}
		clearFieldsCli();
	}
	private void listAll(ChaleController chaleControl) {
		List<Chale> lista = chaleControl.listAll();
		DefaultTableModel tableModel = (DefaultTableModel) chaleTBL.getModel();
		for(int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		int i = 0;
		for (Chale x : lista) {
			tableModel.addRow(new String[1]);
			chaleTBL.setValueAt(x.getCodChale(), i, 0);
			chaleTBL.setValueAt(x.getLocalizacao(), i, 1);
			chaleTBL.setValueAt(x.getCapacidade(), i, 2);
			chaleTBL.setValueAt(x.getValorAltaEstacao(), i, 3);
			chaleTBL.setValueAt(x.getValorBaixaEstacao(), i, 4);
			i++;
		}
		clearFieldsChal();
	}
	private void listAll(HospedagemController hospControl) {
		List<Hospedagem> lista = hospControl.listAll();
		DefaultTableModel tableModel = (DefaultTableModel) hospedagemTBL.getModel();
		for(int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		int i = 0;
		for (Hospedagem x : lista) {
			tableModel.addRow(new String[1]);
			hospedagemTBL.setValueAt(x.getCodHospedagem(), i, 0);
			hospedagemTBL.setValueAt(x.getCodChale(), i, 1);
			hospedagemTBL.setValueAt(x.getEstado(), i, 2);
			hospedagemTBL.setValueAt(x.getDataInicio(), i, 3);
			hospedagemTBL.setValueAt(x.getDataFim(), i, 4);
			hospedagemTBL.setValueAt(x.getQtdPessoas(), i, 5);
			hospedagemTBL.setValueAt(x.getDesconto(), i, 6);
			hospedagemTBL.setValueAt(x.getValorFinal(), i, 7);
			i++;
		}
		clearFieldsHosp();
	}
	private void clearTable(JTable tbl) {
		DefaultTableModel tableModel = (DefaultTableModel) tbl.getModel();
		for(int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}
	private void clearFieldsCli() {
		txtCodCliente.setText("");
		txtNome.setText("");
		txtRgCliente.setText("");
		txtEnderecoCliente.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtEstadoCliente.setText("");
		txtCep.setText("");
		txtNascimentoCliente.setText("");
	}
	private void clearFieldsHosp() {
		txtCodChaleHosp.setText("");
		txtCodHosp.setText("");
		txtEstado.setText("");
		txtDataInicio.setText("");
		txtDataFim.setText("");
		txtQtdPessoas.setText("");
		txtDesconto.setText("");
		txtVFinal.setText("");
	}
	private void clearFieldsChal() {
		txtCodChale.setText("");
		txtLocalizacao.setText("");
		txtCapacidade.setText("");
		txtVAE.setText("");
		txtVBE.setText("");
	}
	private void insert(ClienteController clienteControl) {
		Cliente cliente = new Cliente();
		cliente.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
		cliente.setNomeCliente(txtNome.getText());
		cliente.setRgCliente(txtRgCliente.getText());
		cliente.setEnderecoCliente(txtEnderecoCliente.getText());
		cliente.setBairroCliente(txtBairro.getText());
		cliente.setCidadeCliente(txtCidade.getText());
		cliente.setEstadoCliente(txtEstadoCliente.getText());
		cliente.setCepCliente(txtCep.getText());
		cliente.setNascimentoCliente(txtNascimentoCliente.getText());
		clienteControl.insert(cliente);
		listAll(clienteControl);
		clearFieldsCli();
	}
	private void insert(HospedagemController hospControl, ChaleController chaleControl, JCheckBox altaEstacao) {
		Hospedagem hospedagem = new Hospedagem();
		Chale chale = new Chale();
		chale = chaleControl.search(txtCodChaleHosp.getText());
		hospedagem.setCodHospedagem(Integer.parseInt(txtCodHosp.getText()));
		hospedagem.setCodChale(chale.getCodChale());
		hospedagem.setEstado(txtEstado.getText());
		hospedagem.setDataInicio(txtDataInicio.getText());
		hospedagem.setDataFim(txtDataFim.getText());
		hospedagem.setQtdPessoas(Integer.parseInt(txtQtdPessoas.getText()));
		hospedagem.setDesconto(Integer.parseInt(txtDesconto.getText()));
		Double total;
		if(altaEstacao.isSelected()) {
			total = chale.getValorAltaEstacao() * (1 - hospedagem.getDesconto() / 100.0);
		}
		else {
			total = chale.getValorBaixaEstacao() * (1 - hospedagem.getDesconto() / 100.0);
		}
		hospedagem.setValorFinal(total);
		hospControl.insert(hospedagem);
		listAll(hospControl);
		clearFieldsHosp();
	}
	private void insert(ChaleController chaleControl) {
		Chale chale = new Chale();
		chale.setCodChale(txtCodChale.getText());
		chale.setLocalizacao(txtLocalizacao.getText());
		chale.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
		chale.setValorAltaEstacao(Double.parseDouble(txtVAE.getText()));
		chale.setValorBaixaEstacao(Double.parseDouble(txtVBE.getText()));
		chaleControl.insert(chale);
		listAll(chaleControl);
		clearFieldsChal();
	}
	private void delete(ClienteController clienteControl) {
		Cliente cliente = new Cliente();
		cliente.setCodCliente(Integer.parseInt(String.valueOf(clienteTBL.getValueAt(clienteTBL.getSelectedRow(), 0))));
		clienteControl.delete(cliente);
		listAll(clienteControl);
		clearFieldsCli();
	}
	private void delete(HospedagemController hospControl) {
		Hospedagem hospedagem = new Hospedagem();
		hospedagem.setCodHospedagem(Integer.parseInt(String.valueOf(hospedagemTBL.getValueAt(hospedagemTBL.getSelectedRow(), 0))));
		hospControl.delete(hospedagem);
		listAll(hospControl);
		clearFieldsHosp();
	}
	private void delete(ChaleController chaleControl, HospedagemController hospControl) {
		Chale chale = new Chale();
		chale.setCodChale(String.valueOf(chaleTBL.getValueAt(chaleTBL.getSelectedRow(), 0)));
		hospControl.delete(chale);
		chaleControl.delete(chale);
		listAll(chaleControl);
		listAll(hospControl);
		clearFieldsChal();
	}
	private void alt(ClienteController clienteControl) {
		Cliente cliente = new Cliente();
		int row = clienteTBL.getSelectedRow();
		if(txtCodCliente.getText().isEmpty()) {
			cliente.setCodCliente(Integer.parseInt(String.valueOf(clienteTBL.getValueAt(row, 0))));
		}else {
			cliente.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
		}
		if(txtNome.getText().isEmpty()) {
			cliente.setNomeCliente(String.valueOf(clienteTBL.getValueAt(row, 1)));
		}else{
			cliente.setNomeCliente(txtNome.getText());
		}
		if(txtRgCliente.getText().isEmpty()){
			cliente.setRgCliente(String.valueOf(clienteTBL.getValueAt(row, 2)));
		}else{
			cliente.setRgCliente(txtRgCliente.getText());
		}
		if(txtEnderecoCliente.getText().isEmpty()){
			cliente.setEnderecoCliente(String.valueOf(clienteTBL.getValueAt(row, 3)));
		}else {
			cliente.setEnderecoCliente(txtEnderecoCliente.getText());
		}
		if(txtBairro.getText().isEmpty()){
			cliente.setBairroCliente(String.valueOf(clienteTBL.getValueAt(row, 4)));
		}else {
			cliente.setBairroCliente(txtBairro.getText());
		}
		if(txtCidade.getText().isEmpty()) {
			cliente.setCidadeCliente(String.valueOf(clienteTBL.getValueAt(row, 5))); 
		}else {
			cliente.setCidadeCliente(txtCidade.getText());
		}
		if(txtEstadoCliente.getText().isEmpty()){
			cliente.setEstadoCliente(String.valueOf(clienteTBL.getValueAt(row, 6)));
		}else {
			cliente.setEstadoCliente(txtEstadoCliente.getText());
		}
		if(txtCep.getText().isEmpty()) {
			cliente.setCepCliente(String.valueOf(clienteTBL.getValueAt(row, 7)));
		}else {
			cliente.setCepCliente(txtCep.getText());
		}
		if(txtNascimentoCliente.getText().isEmpty()){
			cliente.setNascimentoCliente(String.valueOf(clienteTBL.getValueAt(row, 8)));
		}else {
			cliente.setNascimentoCliente(txtNascimentoCliente.getText());
		}
		clienteControl.alt(cliente);
		listAll(clienteControl);
		clearFieldsCli();
	}
	private void alt(HospedagemController hospControl, ChaleController chaleControl, JCheckBox altaEstacao) {
		Hospedagem hospedagem = new Hospedagem();
		int row = hospedagemTBL.getSelectedRow();
		Double total;
		Chale chale = new Chale();
		if(txtCodHosp.getText().isEmpty()) {
			hospedagem.setCodHospedagem(Integer.parseInt(String.valueOf(hospedagemTBL.getValueAt(row, 0))));
		}else {
			hospedagem.setCodHospedagem(Integer.parseInt(txtCodHosp.getText()));
		}
		chale = chaleControl.search(String.valueOf(hospedagemTBL.getValueAt(row, 1)));
		hospedagem.setCodChale(chale.getCodChale());
		if(txtEstado.getText().isEmpty()){
			hospedagem.setEstado(String.valueOf(hospedagemTBL.getValueAt(row, 2)));
		}else{
			hospedagem.setEstado(txtEstado.getText());
		}
		if(txtDataInicio.getText().isEmpty()){
			hospedagem.setDataInicio(String.valueOf(hospedagemTBL.getValueAt(row, 3)));
		}else {
			hospedagem.setDataInicio(txtDataInicio.getText());
		}
		if(txtDataFim.getText().isEmpty()){
			hospedagem.setDataFim(String.valueOf(hospedagemTBL.getValueAt(row, 4)));
		}else {
			hospedagem.setDataFim(txtDataFim.getText());
		}
		if(txtQtdPessoas.getText().isEmpty()) {
			hospedagem.setQtdPessoas(Integer.parseInt(String.valueOf(hospedagemTBL.getValueAt(row, 5)))); 
		}else {
			hospedagem.setQtdPessoas(Integer.parseInt(txtCidade.getText()));
		}
		if(txtDesconto.getText().isEmpty()){
			hospedagem.setDesconto(Integer.parseInt(String.valueOf(hospedagemTBL.getValueAt(row, 6))));
			hospedagem.setValorFinal(Double.parseDouble(String.valueOf(hospedagemTBL.getValueAt(row, 7))));
		}else {
			hospedagem.setDesconto(Integer.parseInt(txtDesconto.getText()));
			if(altaEstacao.isSelected()) {				
				total = chale.getValorAltaEstacao() * (1  - hospedagem.getDesconto() / 100.0);
			}
			else{
				total = chale.getValorBaixaEstacao() * (1  - hospedagem.getDesconto() / 100.0);
			}
			hospedagem.setValorFinal(total);
		}
		hospControl.alt(hospedagem);
		listAll(hospControl);
		clearFieldsHosp();
	}
	private void alt(ChaleController chaleControl) {
		Chale chale = new Chale();
		int row = chaleTBL.getSelectedRow();
		if(txtCodChale.getText().isEmpty()) {
			chale.setCodChale(String.valueOf(chaleTBL.getValueAt(row, 0)));
		}else {
			chale.setCodChale(txtCodChale.getText());
		}
		if(txtLocalizacao.getText().isEmpty()) {
			chale.setLocalizacao(String.valueOf(chaleTBL.getValueAt(row, 1)));
		}else {
			chale.setLocalizacao(txtLocalizacao.getText());
		}
		if(txtCapacidade.getText().isEmpty()){
			chale.setCapacidade(Integer.parseInt(String.valueOf(chaleTBL.getValueAt(row, 2))));
		}else{
			chale.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
		}
		if(txtVAE.getText().isEmpty()){
			chale.setValorAltaEstacao(Double.parseDouble(String.valueOf(chaleTBL.getValueAt(row, 3))));
		}else {
			chale.setValorAltaEstacao(Double.parseDouble(txtVAE.getText()));
		}
		if(txtVBE.getText().isEmpty()){
			chale.setValorBaixaEstacao(Double.parseDouble(String.valueOf(chaleTBL.getValueAt(row, 4))));
		}else {
			chale.setValorBaixaEstacao(Double.parseDouble(txtVBE.getText()));
		}
		chaleControl.alt(chale);
		listAll(chaleControl);
		clearFieldsChal();
	}
	private void search(ClienteController clienteControl) {
		Cliente cliente = new Cliente();
		if(txtCodCliente.getText().isEmpty()) {
			cliente.setCodCliente(null);
		}else {
			cliente.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
		}
		if(txtNome.getText().isEmpty()) {
			cliente.setNomeCliente(null);
		}else{
			cliente.setNomeCliente(txtNome.getText());
		}
		if(txtRgCliente.getText().isEmpty()){
			cliente.setRgCliente(null);
		}else{
			cliente.setRgCliente(txtRgCliente.getText());
		}
		if(txtEnderecoCliente.getText().isEmpty()){
			cliente.setEnderecoCliente(null);
		}else {
			cliente.setEnderecoCliente(txtEnderecoCliente.getText());
		}
		if(txtBairro.getText().isEmpty()){
			cliente.setBairroCliente(null);
		}else {
			cliente.setBairroCliente(txtBairro.getText());
		}
		if(txtCidade.getText().isEmpty()) {
			cliente.setCidadeCliente(null); 
		}else {
			cliente.setCidadeCliente(txtCidade.getText());
		}
		if(txtEstadoCliente.getText().isEmpty()){
			cliente.setEstadoCliente(null);
		}else {
			cliente.setEstadoCliente(txtEstadoCliente.getText());
		}
		if(txtCep.getText().isEmpty()) {
			cliente.setCepCliente(null);
		}else {
			cliente.setCepCliente(txtCep.getText());
		}
		if(txtNascimentoCliente.getText().isEmpty()){
			cliente.setNascimentoCliente(null);
		}else {
			cliente.setNascimentoCliente(txtNascimentoCliente.getText());
		}
		List<Cliente> lista = clienteControl.search(cliente);
		DefaultTableModel tableModel = (DefaultTableModel) clienteTBL.getModel();
		for(int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		int i = 0;
		for (Cliente x : lista) {
			tableModel.addRow(new String[1]);
			clienteTBL.setValueAt(x.getCodCliente(), i, 0);
			clienteTBL.setValueAt(x.getNomeCliente(), i, 1);
			clienteTBL.setValueAt(x.getRgCliente(), i, 2);
			clienteTBL.setValueAt(x.getEnderecoCliente(), i, 3);
			clienteTBL.setValueAt(x.getBairroCliente(), i, 4);
			clienteTBL.setValueAt(x.getCidadeCliente(), i, 5);
			clienteTBL.setValueAt(x.getEstadoCliente(), i, 6);
			clienteTBL.setValueAt(x.getCepCliente(), i, 7);
			clienteTBL.setValueAt(x.getNascimentoCliente(), i, 8);
			i++;
		}
	}
	private void search(HospedagemController hospControl) {
		Hospedagem hospedagem = new Hospedagem();
		if(txtCodHosp.getText().isEmpty()) {
			hospedagem.setCodHospedagem(null);
		}else {
			hospedagem.setCodHospedagem(Integer.parseInt(txtCodHosp.getText()));
		}
		if(txtCodChaleHosp.getText().isEmpty()) {
			hospedagem.setCodChale(null);
		}else {
			hospedagem.setCodChale(txtCodChaleHosp.getText());
		}
		if(txtEstado.getText().isEmpty()){
			hospedagem.setEstado(null);
		}else{
			hospedagem.setEstado(txtEstado.getText());
		}
		if(txtDataInicio.getText().isEmpty()){
			hospedagem.setDataInicio(null);
		}else {
			hospedagem.setDataInicio(txtDataInicio.getText());
		}
		if(txtDataFim.getText().isEmpty()){
			hospedagem.setDataFim(null);
		}else {
			hospedagem.setDataFim(txtDataFim.getText());
		}
		if(txtQtdPessoas.getText().isEmpty()) {
			hospedagem.setQtdPessoas(null); 
		}else {
			hospedagem.setQtdPessoas(Integer.parseInt(txtCidade.getText()));
		}
		if(txtDesconto.getText().isEmpty()){
			hospedagem.setDesconto(null);
		}else {
			hospedagem.setDesconto(Integer.parseInt(txtDesconto.getText()));
		}
		if(txtVFinal.getText().isEmpty()){
			hospedagem.setValorFinal(null);
		}else {
			hospedagem.setValorFinal(Double.parseDouble(txtVFinal.getText()));
		}
		List<Hospedagem> lista = hospControl.search(hospedagem);
		DefaultTableModel tableModel = (DefaultTableModel) hospedagemTBL.getModel();
		for(int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		int i = 0;
		for (Hospedagem x : lista) {
			tableModel.addRow(new String[1]);
			hospedagemTBL.setValueAt(x.getCodHospedagem(), i, 0);
			hospedagemTBL.setValueAt(x.getCodChale(), i, 1);
			hospedagemTBL.setValueAt(x.getEstado(), i, 2);
			hospedagemTBL.setValueAt(x.getDataInicio(), i, 3);
			hospedagemTBL.setValueAt(x.getDataFim(), i, 4);
			hospedagemTBL.setValueAt(x.getQtdPessoas(), i, 5);
			hospedagemTBL.setValueAt(x.getDesconto(), i, 6);
			hospedagemTBL.setValueAt(x.getValorFinal(), i, 7);
			i++;
		}
	}
	private void search(ChaleController chaleControl) {
		Chale chale = new Chale();
		if(txtCodChale.getText().isEmpty()) {
			chale.setCodChale(null);
		}else {
			chale.setCodChale(txtCodChale.getText());
		}
		if(txtLocalizacao.getText().isEmpty()) {
			chale.setLocalizacao(null);
		}else {
			chale.setLocalizacao(txtLocalizacao.getText());
		}
		if(txtCapacidade.getText().isEmpty()){
			chale.setCapacidade(null);
		}else{
			chale.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
		}
		if(txtVAE.getText().isEmpty()){
			chale.setValorAltaEstacao(null);
		}else {
			chale.setValorAltaEstacao(Double.parseDouble(txtVAE.getText()));
		}
		if(txtVBE.getText().isEmpty()){
			chale.setValorBaixaEstacao(null);
		}else {
			chale.setValorBaixaEstacao(Double.parseDouble(txtVBE.getText()));
		}
		List<Chale> lista = chaleControl.search(chale);
		DefaultTableModel tableModel = (DefaultTableModel) chaleTBL.getModel();
		for(int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		int i = 0;
		for (Chale x : lista) {
			tableModel.addRow(new String[1]);
			chaleTBL.setValueAt(x.getCodChale(), i, 0);
			chaleTBL.setValueAt(x.getLocalizacao(), i, 1);
			chaleTBL.setValueAt(x.getCapacidade(), i, 2);
			chaleTBL.setValueAt(x.getValorAltaEstacao(), i, 3);
			chaleTBL.setValueAt(x.getValorBaixaEstacao(), i, 4);
			i++;
		}
	}
}


