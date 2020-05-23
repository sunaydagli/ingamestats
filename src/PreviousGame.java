import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PreviousGame extends JFrame {

	private JPanel contentPane;
	private Team myTeam;
	private String myName;
	private JTable table;
	private JTable table_2;
	private JTextField txtStatisticsSheet;

	public PreviousGame(Team team, String identifier) {
		myTeam = team;
		myName = identifier;
		myTeam.selectPreviousGame(identifier);
		Player[] players = new Player[myTeam.getCurrentGame().getSize()];
		for (int i = 0; i < players.length; i++) {
			players[i] = myTeam.getCurrentGame().getPlayer(i);
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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setBounds(100, 100, 1493, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(176, 224, 230));
		setContentPane(contentPane);

		txtStatisticsSheet = new JTextField();
		txtStatisticsSheet.setBounds(10, 16, 1461, 43);
		txtStatisticsSheet.setEditable(false);
		txtStatisticsSheet.setHorizontalAlignment(SwingConstants.CENTER);
		txtStatisticsSheet.setFont(new Font("Cambria", Font.PLAIN, 30));
		txtStatisticsSheet.setText(team.getName() + " Statistics Sheet");
		txtStatisticsSheet.setColumns(10);
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Cambria", Font.PLAIN, 12));
		table.setBounds(10, 70, 1461, 176);
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
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.add(table);
		contentPane.add(txtStatisticsSheet);

		table_2 = new JTable();
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_2.setFont(new Font("Cambria", Font.PLAIN, 12));
		table_2.setModel(new DefaultTableModel(new Object[][] { myTeam.getCurrentGame().getGameArr() },
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
		table_2.setBounds(10, 245, 1461, 16);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		table_2.setDefaultRenderer(String.class, centerRenderer);
		table.setEnabled(false);
		table_2.setEnabled(false);
		contentPane.add(table_2);

		JButton button = new JButton("Percentages");
		button.setFont(new Font("Cambria", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Percentages per = new Percentages(myTeam.getCurrentGame());
				per.setVisible(true);
			}
		});
		button.setBounds(1006, 272, 211, 32);
		contentPane.add(button);

		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myTeam.setCurrentGame();
				setVisible(false);
			}
		});
		btnContinue.setBounds(1245, 272, 211, 32);
		contentPane.add(btnContinue);
	}
}
