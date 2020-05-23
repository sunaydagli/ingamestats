import java.awt.BorderLayout; 
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class StatisticsMenu extends JFrame {

	private JPanel contentPane;
	private JTextField txtStatisticsSheet;
	private JTable table;
	private JTextField txtAddStatistics;
	private Team team;
	private Game game;
	private JTextField txtWindow;
	private JTextField txtPleaseSelectThe;
	private JTextField name1;
	private JTextField name2;
	private JTextField playerNum;
	private JTextField gameName;
	private JTable table_2;

	public StatisticsMenu(Team current) {
		team = current;
		team.readFile();
		team.newGame();
		game = team.getCurrentGame();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1498, 756);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		txtStatisticsSheet = new JTextField();
		txtStatisticsSheet.setBounds(10, 22, 1461, 41);
		txtStatisticsSheet.setEditable(false);
		txtStatisticsSheet.setHorizontalAlignment(SwingConstants.CENTER);
		txtStatisticsSheet.setFont(new Font("Cambria", Font.PLAIN, 30));
		txtStatisticsSheet.setText(team.getName() + " Statistics Sheet");
		txtStatisticsSheet.setColumns(10);
		table = new JTable();
		table.setFont(new Font("Cambria", Font.PLAIN, 12));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(10, 92, 1461, 176);
		table.setBackground(Color.WHITE);
		table.setEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] { { "Name", "Number", "2 Point Made", "2 Point Attempts", "3 Point Made",
						"3 Point Attempts", "Freethrow Made", "Freethrow Attempts", "O Rebounds", "D Rebounds",
						"Total Rebounds", "Assists", "Steals", "Blocks", "Turnovers", "Fouls", "Total Points" }, },
				new String[] { "Name", "Number", "2 Point Made", "2 Point Attempts", "3 Point Made", "3 Point Attempts",
						"Freethrow Made", "Freethrow Attempts", "O Rebounds", "D Rebounds", "Total Rebounds", "Assists",
						"Steals", "Blocks", "Turnovers", "Fouls", "Total Points" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class, String.class, String.class };
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false };
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		table.getColumnModel().getColumn(1).setPreferredWidth(35);
		table.getColumnModel().getColumn(2).setPreferredWidth(53);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(65);
		table.getColumnModel().getColumn(6).setPreferredWidth(65);
		table.getColumnModel().getColumn(7).setPreferredWidth(85);
		table.getColumnModel().getColumn(8).setPreferredWidth(45);
		table.getColumnModel().getColumn(9).setPreferredWidth(45);
		table.getColumnModel().getColumn(10).setPreferredWidth(65);
		table.getColumnModel().getColumn(11).setPreferredWidth(35);
		table.getColumnModel().getColumn(12).setPreferredWidth(35);
		table.getColumnModel().getColumn(13).setPreferredWidth(35);
		table.getColumnModel().getColumn(14).setPreferredWidth(35);
		table.getColumnModel().getColumn(15).setPreferredWidth(35);
		table.getColumnModel().getColumn(16).setPreferredWidth(60);
		contentPane.setLayout(null);
		contentPane.add(table);
		contentPane.add(txtStatisticsSheet);

		txtAddStatistics = new JTextField();
		txtAddStatistics.setText("Add Statistics");
		txtAddStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddStatistics.setFont(new Font("Cambria", Font.PLAIN, 20));
		txtAddStatistics.setEditable(false);
		txtAddStatistics.setColumns(10);
		txtAddStatistics.setBounds(15, 291, 716, 24);
		contentPane.add(txtAddStatistics);

		table_2 = new JTable();
		table_2.setFont(new Font("Cambria", Font.PLAIN, 12));
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
						{ "Total", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }, },
				new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_2.getColumnModel().getColumn(0).setPreferredWidth(144);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(53);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(70);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(50);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(65);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(65);
		table_2.getColumnModel().getColumn(6).setPreferredWidth(85);
		table_2.getColumnModel().getColumn(7).setPreferredWidth(45);
		table_2.getColumnModel().getColumn(8).setPreferredWidth(45);
		table_2.getColumnModel().getColumn(9).setPreferredWidth(65);
		table_2.getColumnModel().getColumn(10).setPreferredWidth(35);
		table_2.getColumnModel().getColumn(11).setPreferredWidth(35);
		table_2.getColumnModel().getColumn(12).setPreferredWidth(35);
		table_2.getColumnModel().getColumn(13).setPreferredWidth(35);
		table_2.getColumnModel().getColumn(14).setPreferredWidth(35);
		table_2.getColumnModel().getColumn(15).setPreferredWidth(60);
		table_2.setBounds(10, 267, 1461, 16);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);

		table_2.setDefaultRenderer(String.class, centerRenderer);
		table_2.setEnabled(false);
		contentPane.add(table_2);

		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(755, 326, 716, 236);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("basketball.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 696, 214);
		panel.add(lblNewLabel);

		JButton newPlayer = new JButton("Create New Player");
		newPlayer.setBackground(new Color(255, 153, 51));
		newPlayer.setFont(new Font("Cambria", Font.PLAIN, 24));
		newPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				editPanelForAddingPlayer(panel);
				panel.repaint();
			}
		});
		newPlayer.setBounds(15, 326, 716, 52);
		contentPane.add(newPlayer);

		JButton freeThrow = new JButton("Free Throw");
		freeThrow.setBackground(new Color(255, 153, 51));
		freeThrow.setFont(new Font("Cambria", Font.PLAIN, 24));
		freeThrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				editPanelForAddingAShot(panel, "Free Throw");
				panel.repaint();
			}
		});
		freeThrow.setBounds(501, 389, 230, 84);
		contentPane.add(freeThrow);

		JButton twoPointShot = new JButton("Two Point Shot");
		twoPointShot.setBackground(new Color(255, 153, 51));
		twoPointShot.setFont(new Font("Cambria", Font.PLAIN, 24));
		twoPointShot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				editPanelForAddingAShot(panel, "Two Point Shot");
				panel.repaint();
			}
		});
		twoPointShot.setBounds(15, 389, 239, 84);
		contentPane.add(twoPointShot);

		JButton threePointShot = new JButton("Three Point Shot");
		threePointShot.setBackground(new Color(255, 153, 51));
		threePointShot.setFont(new Font("Cambria", Font.PLAIN, 24));
		threePointShot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				editPanelForAddingAShot(panel, "Three Point Shot");
				panel.repaint();
			}
		});
		threePointShot.setBounds(257, 389, 239, 84);
		contentPane.add(threePointShot);

		JButton btnRebound = new JButton("Rebound");
		btnRebound.setBackground(new Color(255, 153, 51));
		btnRebound.setFont(new Font("Cambria", Font.PLAIN, 24));
		btnRebound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				editPanelForRebounds(panel);
				panel.repaint();
			}
		});
		btnRebound.setBounds(15, 478, 239, 84);
		contentPane.add(btnRebound);

		JButton btnAssist = new JButton("Assist");
		btnAssist.setBackground(new Color(255, 153, 51));
		btnAssist.setFont(new Font("Cambria", Font.PLAIN, 24));
		btnAssist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				editPanelForAddingStat(panel, "Assist");
				panel.repaint();
			}
		});
		btnAssist.setBounds(257, 478, 239, 84);
		contentPane.add(btnAssist);

		JButton btnSteal = new JButton("Steal");
		btnSteal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				editPanelForAddingStat(panel, "Steal");
				panel.repaint();
			}
		});
		btnSteal.setFont(new Font("Cambria", Font.PLAIN, 24));
		btnSteal.setBackground(new Color(255, 153, 51));
		btnSteal.setBounds(501, 478, 230, 84);
		contentPane.add(btnSteal);

		JButton btnBlock = new JButton("Block");
		btnBlock.setBackground(new Color(255, 153, 51));
		btnBlock.setFont(new Font("Cambria", Font.PLAIN, 24));
		btnBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				editPanelForAddingStat(panel, "Block");
				panel.repaint();
			}
		});
		btnBlock.setBounds(15, 568, 239, 74);
		contentPane.add(btnBlock);

		JButton btnTurnover = new JButton("Turnover");
		btnTurnover.setBackground(new Color(255, 153, 51));
		btnTurnover.setFont(new Font("Cambria", Font.PLAIN, 24));
		btnTurnover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				editPanelForAddingStat(panel, "Turnover");
				panel.repaint();
			}
		});
		btnTurnover.setBounds(257, 568, 239, 74);
		contentPane.add(btnTurnover);

		JButton btnFoul = new JButton("Foul");
		btnFoul.setBackground(new Color(255, 153, 51));
		btnFoul.setFont(new Font("Cambria", Font.PLAIN, 24));
		btnFoul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				editPanelForAddingStat(panel, "Foul");
				panel.repaint();
			}
		});
		btnFoul.setBounds(501, 568, 230, 74);
		contentPane.add(btnFoul);

		JButton btnDeletePlayer = new JButton("Delete Player");
		btnDeletePlayer.setBackground(new Color(255, 153, 51));
		btnDeletePlayer.setFont(new Font("Cambria", Font.PLAIN, 24));
		btnDeletePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				editPanelForRemovingPlayer(panel);
				panel.repaint();
			}
		});
		btnDeletePlayer.setBounds(15, 654, 716, 52);
		contentPane.add(btnDeletePlayer);

		txtWindow = new JTextField();
		txtWindow.setText("Window");
		txtWindow.setHorizontalAlignment(SwingConstants.CENTER);
		txtWindow.setFont(new Font("Cambria", Font.PLAIN, 20));
		txtWindow.setEditable(false);
		txtWindow.setColumns(10);
		txtWindow.setBounds(755, 291, 716, 24);
		contentPane.add(txtWindow);

		txtPleaseSelectThe = new JTextField();
		txtPleaseSelectThe.setText(
				"Please select the row of the player first, continue with selection of statistics, and edit statistics in the Window.");
		txtPleaseSelectThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtPleaseSelectThe.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtPleaseSelectThe.setEditable(false);
		txtPleaseSelectThe.setColumns(10);
		txtPleaseSelectThe.setBounds(10, 65, 1461, 24);
		contentPane.add(txtPleaseSelectThe);

		JButton btnPercentages = new JButton("Percentages");
		btnPercentages.setBackground(new Color(255, 153, 51));
		btnPercentages.setFont(new Font("Cambria", Font.PLAIN, 24));
		btnPercentages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team.getCurrentGame().getSize() == 0)
					displayError(5);
				else {
					Percentages per = new Percentages(team.getCurrentGame());
					per.setVisible(true);
				}
			}
		});
		btnPercentages.setBounds(755, 578, 230, 128);
		contentPane.add(btnPercentages);

		JButton btnViewPreviousGames = new JButton("Previous Games");
		btnViewPreviousGames.setBackground(new Color(255, 153, 51));
		btnViewPreviousGames.setFont(new Font("Cambria", Font.PLAIN, 24));
		btnViewPreviousGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				editPanelForPreviousGame(panel);
				panel.repaint();
			}
		});
		btnViewPreviousGames.setBounds(995, 578, 236, 128);
		contentPane.add(btnViewPreviousGames);

		JButton btnEndGame = new JButton("Exit");
		btnEndGame.setBackground(new Color(255, 153, 51));
		btnEndGame.setFont(new Font("Cambria", Font.PLAIN, 24));
		btnEndGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				editPanelForExit(panel);
				panel.repaint();
			}
		});
		btnEndGame.setBounds(1241, 578, 230, 128);
		contentPane.add(btnEndGame);

	}

	public void updateTable(int num) {
		Player[] players = new Player[game.getSize()];
		for (int i = 0; i < players.length; i++) {
			players[i] = game.getPlayer(i);
		}
		Object[][] rows = new Object[players.length + 1][17];
		rows[0] = new String[] { "Name", "Number", "2 Point Made", "2 Point Attempts", "3 Point Made",
				"3 Point Attempts", "Freethrow Made", "Freethrow Attempts", "O Rebounds", "D Rebounds",
				"Total Rebounds", "Assists", "Steals", "Blocks", "Turnovers", "Fouls", "Total Points" };
		int index = 0;
		while (index < players.length) {
			rows[index + 1] = players[index].getPlayerArr();
			index++;
		}
		table.removeAll();
		table.setBounds(10, 92, 1461, 176);
		table.setBackground(Color.WHITE);
		table.setEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(rows,
				new String[] { "Name", "Number", "2 Point Made", "2 Point Attempts", "3 Point Made", "3 Point Attempts",
						"Freethrow Made", "Freethrow Attempts", "O Rebounds", "D Rebounds", "Total Rebounds", "Assists",
						"Steals", "Blocks", "Turnovers", "Fouls", "Total Points" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(35);
		table.getColumnModel().getColumn(2).setPreferredWidth(53);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(65);
		table.getColumnModel().getColumn(6).setPreferredWidth(65);
		table.getColumnModel().getColumn(7).setPreferredWidth(85);
		table.getColumnModel().getColumn(8).setPreferredWidth(45);
		table.getColumnModel().getColumn(9).setPreferredWidth(45);
		table.getColumnModel().getColumn(10).setPreferredWidth(65);
		table.getColumnModel().getColumn(11).setPreferredWidth(35);
		table.getColumnModel().getColumn(12).setPreferredWidth(35);
		table.getColumnModel().getColumn(13).setPreferredWidth(35);
		table.getColumnModel().getColumn(14).setPreferredWidth(35);
		table.getColumnModel().getColumn(15).setPreferredWidth(35);
		table.getColumnModel().getColumn(16).setPreferredWidth(60);
		if (!(num == -1))
			table.setRowSelectionInterval(num, num);
		contentPane.setLayout(null);
		table.validate();
		table.repaint();

		table_2.removeAll();
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_2.setModel(new DefaultTableModel(new Object[][] { game.getGameArr() },
				new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_2.getColumnModel().getColumn(0).setPreferredWidth(144);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(53);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(70);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(50);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(65);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(65);
		table_2.getColumnModel().getColumn(6).setPreferredWidth(85);
		table_2.getColumnModel().getColumn(7).setPreferredWidth(45);
		table_2.getColumnModel().getColumn(8).setPreferredWidth(45);
		table_2.getColumnModel().getColumn(9).setPreferredWidth(65);
		table_2.getColumnModel().getColumn(10).setPreferredWidth(35);
		table_2.getColumnModel().getColumn(11).setPreferredWidth(35);
		table_2.getColumnModel().getColumn(12).setPreferredWidth(35);
		table_2.getColumnModel().getColumn(13).setPreferredWidth(35);
		table_2.getColumnModel().getColumn(14).setPreferredWidth(35);
		table_2.getColumnModel().getColumn(15).setPreferredWidth(60);
		table_2.setBounds(10, 267, 1461, 16);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		table.setFont(new Font("Cambria", Font.PLAIN, 12));
		table_2.setDefaultRenderer(String.class, centerRenderer);
		table_2.setFont(new Font("Cambria", Font.PLAIN, 12));
		table_2.setEnabled(false);
		table_2.validate();
		table_2.repaint();
	}

	public void cancel(Panel panel) {
		panel.removeAll();
		panel.repaint();
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("basketball.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 696, 214);
		panel.add(lblNewLabel);
	}

	public void editPanelForAddingPlayer(Panel panel) {

		JLabel lblMadeOrMissed = new JLabel("Add New Player");
		lblMadeOrMissed.setFont(new Font("Cambria", Font.PLAIN, 19));
		lblMadeOrMissed.setBounds(267, 11, 191, 23);
		lblMadeOrMissed.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMadeOrMissed);

		JButton btnAddPlayer = new JButton("Add Player");
		btnAddPlayer.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getSize() == 10)
					displayError(1);
				else
				{
				try {
					String first = name1.getText();
					String last = name2.getText();
					String num = playerNum.getText();
					int playnum = Integer.parseInt(num);
					if (first.equals("") || last.equals(""))
						displayError(2);
					else {
						if (team.getSize() == 10)
							displayError(1);
						else {
							Player player = new Player(first, last, playnum);
							if (!(team.getCurrentGame().contains(player))) {
								if (game.addPlayer(first, last, playnum)) {
									updateTable(-1);
									panel.removeAll();
									editPanelForAddingPlayer(panel);
									panel.repaint();
								} else
									displayError(4);
							} else
								displayError(4);
						}
					}
				} catch (NumberFormatException f) {
					displayError(2);
				}
			}
		}
		});
		btnAddPlayer.setBounds(217, 168, 292, 31);
		panel.add(btnAddPlayer);

		name2 = new JTextField();
		name2.setColumns(10);
		name2.setBounds(267, 100, 191, 20);
		panel.add(name2);

		name1 = new JTextField();
		name1.setColumns(10);
		name1.setBounds(267, 58, 191, 20);
		panel.add(name1);

		JLabel lblInputPlayerFirst = new JLabel("Input Player First Name");
		lblInputPlayerFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputPlayerFirst.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblInputPlayerFirst.setBounds(267, 36, 191, 23);
		panel.add(lblInputPlayerFirst);

		JLabel lblInputPlayerLast = new JLabel("Input Player Last Name");
		lblInputPlayerLast.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputPlayerLast.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblInputPlayerLast.setBounds(267, 76, 191, 23);
		panel.add(lblInputPlayerLast);

		playerNum = new JTextField();
		playerNum.setColumns(10);
		playerNum.setBounds(300, 142, 119, 20);
		playerNum.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e)
			{
				if (playerNum.getText().length() > 1)
					e.consume();
		}
		});
		panel.add(playerNum);

		JLabel lblInputPlayerNumber = new JLabel("Input Player Number");
		lblInputPlayerNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputPlayerNumber.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblInputPlayerNumber.setBounds(267, 120, 191, 19);
		panel.add(lblInputPlayerNumber);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancel(panel);
			}
		});
		btnNewButton.setBounds(217, 202, 292, 23);
		panel.add(btnNewButton);
	}

	public void editPanelForRemovingPlayer(Panel panel) {
		JLabel lblMadeOrMissed = new JLabel("Delete Player");
		lblMadeOrMissed.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblMadeOrMissed.setBounds(300, 11, 119, 14);
		lblMadeOrMissed.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMadeOrMissed);

		JButton btnRemovePlayer = new JButton("Delete Player");
		btnRemovePlayer.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnRemovePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getSize() == 0)
					displayError(5);
				else {
					try {
						String num = playerNum.getText();
						int playnum = Integer.parseInt(num);
						if (game.removePlayer(playnum)) {
							updateTable(-1);
							panel.removeAll();
							editPanelForRemovingPlayer(panel);
							panel.repaint();
						} else {
							if (team.getCurrentGame().getSize() == 0)
								displayError(5);
							else
								displayError(3);
						}
					} catch (NumberFormatException f) {
						displayError(2);
					}
				}
			}
		});
		btnRemovePlayer.setBounds(215, 112, 292, 23);
		panel.add(btnRemovePlayer);

		playerNum = new JTextField();
		playerNum.setColumns(10);
		playerNum.setBounds(298, 81, 119, 20);
		playerNum.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e)
			{
				if (playerNum.getText().length() > 1)
					e.consume();
		}
		});
		panel.add(playerNum);

		JLabel lblInputPlayerNumber = new JLabel("Input Player Number");
		lblInputPlayerNumber.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblInputPlayerNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputPlayerNumber.setBounds(215, 55, 292, 23);
		panel.add(lblInputPlayerNumber);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancel(panel);
			}
		});
		btnNewButton.setBounds(215, 142, 292, 23);
		panel.add(btnNewButton);
	}

	public void editPanelForAddingStat(Panel panel, String stat) {
		JLabel lblMadeOrMissed = new JLabel("Edit " + stat + "s");
		lblMadeOrMissed.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblMadeOrMissed.setHorizontalAlignment(SwingConstants.CENTER);
		lblMadeOrMissed.setBounds(300, 11, 119, 14);
		panel.add(lblMadeOrMissed);

		JButton btnMade_1 = new JButton("+");
		btnMade_1.setFont(new Font("Cambria", Font.PLAIN, 60));
		btnMade_1.setBackground(Color.GREEN);
		btnMade_1.setBounds(209, 49, 141, 89);
		btnMade_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team.getCurrentGame().getSize() == 0)
					displayError(5);
				else {
					int num = table.getSelectedRow();
					if (num == 0 || num == -1)
						displayError(8);
					else {
						int index = num - 1;
						if (stat.equals("Assist")) {
							game.getPlayer(index).addAssist();
						} else if (stat.equals("Steal")) {
							game.getPlayer(index).addSteal();
						} else if (stat.equals("Block")) {
							game.getPlayer(index).addBlocks();
						} else if (stat.equals("Turnover")) {
							game.getPlayer(index).addTurnover();
						} else if (stat.equals("Foul")) {
							game.getPlayer(index).addFoul();
							if (game.getPlayer(index).getFouls() == 4) {
								ErrorMessage err = new ErrorMessage(game.getPlayer(index).getFirstName() + " "
										+ game.getPlayer(index).getLastName(), 4);
								err.setLocationRelativeTo(table);
								err.setVisible(true);
							} else if (game.getPlayer(index).getFouls() == 5) {
								ErrorMessage err = new ErrorMessage(game.getPlayer(index).getFirstName() + " "
										+ game.getPlayer(index).getLastName(), 5);
								err.setLocationRelativeTo(table);
								err.setVisible(true);
							}
						}
						updateTable(num);
					}
				}
			}
		});
		panel.add(btnMade_1);

		JButton btnMissed = new JButton("-");
		btnMissed.setFont(new Font("Cambria", Font.PLAIN, 60));
		btnMissed.setBackground(Color.RED);
		btnMissed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (team.getCurrentGame().getSize() == 0) {
					ErrorMessage error = new ErrorMessage(5);
					error.setLocationRelativeTo(table);
					error.setVisible(true);
				} else {
					int num = table.getSelectedRow();
					if (num == 0 || num == -1)
						displayError(8);
					else {
						int index = num - 1;
						if (stat.equals("Assist")) {
							if (game.getPlayer(index).subAssist()) {
								updateTable(num);
							} else
								displayError(9);
						} else if (stat.equals("Block")) {
							if (game.getPlayer(index).subBlocks()) {
								updateTable(num);
							} else
								displayError(9);
						} else if (stat.equals("Turnover")) {
							if (game.getPlayer(index).subTurnover()) {
								updateTable(num);
							} else
								displayError(9);
						} else {
							if (game.getPlayer(index).subFoul()) {
								updateTable(num);
							} else
								displayError(9);
						}
					}
				}
			}
		});
		btnMissed.setBounds(361, 49, 141, 89);
		panel.add(btnMissed);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel(panel);
			}
		});
		btnCancel.setBounds(209, 149, 292, 45);
		panel.add(btnCancel);
	}

	public void displayError(int num) {
		ErrorMessage error = new ErrorMessage(num);
		error.setLocationRelativeTo(table);
		error.setVisible(true);
	}

	public void editPanelForAddingAShot(Panel panel, String stat) {
		JButton btnMade = new JButton("Made");
		btnMade.setFont(new Font("Cambria", Font.PLAIN, 36));
		btnMade.setBackground(Color.GREEN);
		btnMade.setBounds(215, 36, 141, 89);
		btnMade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team.getCurrentGame().getSize() == 0)
					displayError(5);
				else {
					int num = table.getSelectedRow();
					if (num == 0 || num == -1)
						displayError(8);
					else {
						int index = num - 1;
						if (stat.equals("Two Point Shot")) {
							game.getPlayer(index).add2Point(1);
						} else if (stat.equals("Three Point Shot")) {
							game.getPlayer(index).add3Point(1);
						} else {
							game.getPlayer(index).addFreeThrow(1);
						}
						updateTable(num);
					}
				}
			}
		});
		panel.add(btnMade);

		JLabel lblMadeOrMissed = new JLabel("Edit " + stat + "s");
		lblMadeOrMissed.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblMadeOrMissed.setHorizontalAlignment(SwingConstants.CENTER);
		lblMadeOrMissed.setBounds(215, 11, 292, 22);
		panel.add(lblMadeOrMissed);

		JButton btnMissed = new JButton("Missed");
		btnMissed.setFont(new Font("Cambria", Font.PLAIN, 36));
		btnMissed.setBackground(Color.RED);
		btnMissed.setBounds(366, 36, 141, 89);
		panel.add(btnMissed);
		btnMissed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team.getCurrentGame().getSize() == 0)
					displayError(5);
				else {
					int num = table.getSelectedRow();
					if (num == 0 || num == -1)
						displayError(8);
					else {
						int index = num - 1;
						if (stat.equals("Two Point Shot")) {
							game.getPlayer(index).add2Point(0);
							updateTable(num);
						} else if (stat.equals("Three Point Shot")) {
							game.getPlayer(index).add3Point(0);
							updateTable(num);
						} else {
							game.getPlayer(index).addFreeThrow(0);
							updateTable(num);
						}
					}
				}
			}
		});
		JButton button_5 = new JButton("Cancel");
		button_5.setFont(new Font("Cambria", Font.PLAIN, 18));
		button_5.setBounds(215, 136, 292, 45);
		panel.add(button_5);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel(panel);
			}
		});
	}

	public void editPanelForSuccess(Panel panel) {
		panel.removeAll();
		JLabel lblMadeOrMissed = new JLabel("Success");
		lblMadeOrMissed.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblMadeOrMissed.setHorizontalAlignment(SwingConstants.CENTER);
		lblMadeOrMissed.setBounds(0, 0, 716, 236);
		panel.add(lblMadeOrMissed);
		panel.repaint();
	}

	public void editPanelForRebounds(Panel panel) {
		JLabel lblRebounds = new JLabel("Edit Rebounds");
		lblRebounds.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblRebounds.setHorizontalAlignment(SwingConstants.CENTER);
		lblRebounds.setBounds(215, 11, 292, 14);
		panel.add(lblRebounds);

		JButton offensiveAdd = new JButton("+");
		offensiveAdd.setFont(new Font("Cambria", Font.PLAIN, 42));
		offensiveAdd.setBackground(Color.GREEN);
		offensiveAdd.setBounds(209, 81, 65, 45);
		offensiveAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team.getCurrentGame().getSize() == 0)
					displayError(5);
				else {
					int num = table.getSelectedRow();
					if (num == 0 || num == -1)
						displayError(8);
					else {
						int index = num - 1;
						game.getPlayer(index).addRebound(0);
						updateTable(num);
					}
				}
			}
		});
		panel.add(offensiveAdd);

		JButton offensiveSub = new JButton("-");
		offensiveSub.setFont(new Font("Cambria", Font.PLAIN, 42));
		offensiveSub.setBackground(Color.RED);
		offensiveSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (team.getCurrentGame().getSize() == 0)
					displayError(5);
				else {
					int num = table.getSelectedRow();
					if (num == 0 || num == -1)
						displayError(8);
					else {
						int index = num - 1;
						if (game.getPlayer(index).subRebound(0)) {
							updateTable(num);
						} else
							displayError(9);
					}
				}
			}
		});
		offensiveSub.setBounds(289, 81, 65, 45);
		panel.add(offensiveSub);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel(panel);
			}
		});
		btnCancel.setBounds(209, 137, 292, 45);
		panel.add(btnCancel);

		JButton defensiveAdd = new JButton("+");
		defensiveAdd.setFont(new Font("Cambria", Font.PLAIN, 42));
		defensiveAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team.getCurrentGame().getSize() == 0)
					displayError(5);
				else {
					int num = table.getSelectedRow();
					if (num == 0 || num == -1)
						displayError(8);
					else {
						int index = num - 1;
						game.getPlayer(index).addRebound(1);
						updateTable(num);
					}
				}
			}
		});
		defensiveAdd.setBackground(Color.GREEN);
		defensiveAdd.setBounds(364, 81, 65, 45);
		panel.add(defensiveAdd);

		JButton defensiveSub = new JButton("-");
		defensiveSub.setFont(new Font("Cambria", Font.PLAIN, 42));
		defensiveSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team.getCurrentGame().getSize() == 0)
					displayError(5);
				else {
					int num = table.getSelectedRow();
					if (num == 0 || num == -1)
						displayError(8);
					else {
						int index = num - 1;
						if (game.getPlayer(index).subRebound(1)) {
							updateTable(num);
						} else
							displayError(9);
					}
				}
			}
		});
		defensiveSub.setBackground(Color.RED);
		defensiveSub.setBounds(436, 81, 65, 45);
		panel.add(defensiveSub);

		JLabel lblOffensiveRebound = new JLabel("Offensive Rebounds");
		lblOffensiveRebound.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblOffensiveRebound.setHorizontalAlignment(SwingConstants.CENTER);
		lblOffensiveRebound.setBounds(209, 53, 142, 29);
		panel.add(lblOffensiveRebound);

		JLabel lblDefensiveRebound = new JLabel("Defensive Rebounds");
		lblDefensiveRebound.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblDefensiveRebound.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefensiveRebound.setBounds(364, 53, 134, 29);
		panel.add(lblDefensiveRebound);
	}

	public void editPanelForExit(Panel panel) {
		JButton btnSaveGame = new JButton("Save Game");
		btnSaveGame.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String identifier = gameName.getText();
				if (identifier.equals(""))
					displayError(6);
				else {
					if (game.getSize() == 0)
						displayError(5);
					else {
						if (team.saveGame(identifier) == false)
							displayError(0);
						else {
							StartUpMenu menu = new StartUpMenu(0);
							menu.setVisible(true);
							setVisible(false);
						}
					}
				}
			}
		});
		btnSaveGame.setBounds(222, 77, 270, 37);
		panel.add(btnSaveGame);

		gameName = new JTextField();
		gameName.setBounds(222, 46, 270, 20);
		panel.add(gameName);
		gameName.setColumns(10);

		JLabel lblInsertName = new JLabel("Insert a game identifier to access game later:");
		lblInsertName.setFont(new Font("Cambria", Font.PLAIN, 13));
		lblInsertName.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertName.setBounds(222, 21, 270, 18);
		panel.add(lblInsertName);

		JButton btnExitWithoutSaving = new JButton("Exit Without Saving");
		btnExitWithoutSaving.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnExitWithoutSaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartUpMenu menu = new StartUpMenu(0);
				menu.setVisible(true);
				setVisible(false);
			}
		});
		btnExitWithoutSaving.setBounds(222, 125, 270, 37);
		panel.add(btnExitWithoutSaving);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel(panel);
			}
		});
		btnCancel.setBounds(222, 173, 270, 37);
		panel.add(btnCancel);
	}

	public void editPanelForPreviousGame(Panel panel) {
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(team.getAllGames()));
		comboBox.setFont(new Font("Cambria", Font.PLAIN, 14));
		comboBox.setBounds(221, 51, 270, 35);
		panel.add(comboBox);

		JButton btnViewGame = new JButton("View Game");
		btnViewGame.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnViewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team.getAllGames().length == 0)
					displayError(7);
				else if (comboBox.getSelectedIndex() == -1)
					displayError(8);
				else {
					PreviousGame game = new PreviousGame(team, (String) comboBox.getSelectedItem());
					game.setVisible(true);
				}
			}
		});
		btnViewGame.setBounds(222, 97, 270, 30);
		panel.add(btnViewGame);

		JLabel lblInsertName = new JLabel("Select Previous Game:");
		lblInsertName.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblInsertName.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertName.setBounds(222, 26, 270, 14);
		panel.add(lblInsertName);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel(panel);
			}
		});
		btnCancel.setBounds(222, 178, 270, 30);
		panel.add(btnCancel);

		JButton btnDeleteGame = new JButton("Delete Game");
		btnDeleteGame.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnDeleteGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (team.getSize() == 0)
					displayError(7);
				else if (comboBox.getSelectedIndex() == -1)
					displayError(8);
				else {
					team.deleteGame((String) comboBox.getSelectedItem());
					panel.removeAll();
					editPanelForPreviousGame(panel);
					panel.repaint();
				}
			}
		});
		btnDeleteGame.setBounds(222, 138, 270, 29);
		panel.add(btnDeleteGame);
	}
}
