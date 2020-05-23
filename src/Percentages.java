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

public class Percentages extends JFrame {

	private Game myGame;
	private JPanel contentPane;
	private JTextField txtStatisticsSheet;
	private JTable table;
	private JTable table_2;
	private JTextField txtStatisticsLeaders;
	private JTable table_3;

	public Percentages(Game game) {
		myGame = game;
		Player[] players = new Player[myGame.getSize()];
		for (int i = 0; i < players.length; i++) {
			players[i] = myGame.getPlayer(i);
		}
		Object[][] rows = new Object[players.length + 1][6];
		rows[0] = new String[] { "Name", "Number", "3 Point %", "Free Throw %", "A/T Ratio", "Total FG %" };
		int index = 0;
		while (index < players.length) {
			rows[index + 1] = players[index].getPlayerPercents();
			index++;
		}
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 639, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtStatisticsSheet = new JTextField();
		txtStatisticsSheet.setBounds(10, 16, 600, 43);
		txtStatisticsSheet.setEditable(false);
		txtStatisticsSheet.setHorizontalAlignment(SwingConstants.CENTER);
		txtStatisticsSheet.setFont(new Font("Cambria", Font.PLAIN, 30));
		txtStatisticsSheet.setText("Statistics Sheet");
		txtStatisticsSheet.setColumns(10);
		table = new JTable();
		table.setBounds(10, 70, 600, 176);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Cambria", Font.PLAIN, 12));
		table.setBackground(Color.WHITE);
		table.setEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(rows,
				new String[] { "Name", "Number", "3 Point %", "Free Throw %", "A/T Ratio", "Total FG %" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(15);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(30);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.add(table);
		contentPane.add(txtStatisticsSheet);

		table_2 = new JTable();
		table_2.setBounds(10, 245, 600, 16);
		table_2.setFont(new Font("Cambria", Font.PLAIN, 12));
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_2.setModel(new DefaultTableModel(new Object[][] { myGame.getGamePercentages(), },
				new String[] { "New column", "New column", "New column", "New column", "New column" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(132);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(40);
		table_2.getColumnModel().getColumn(2).setResizable(false);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(30);
		table_2.getColumnModel().getColumn(3).setResizable(false);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(30);
		table_2.getColumnModel().getColumn(4).setResizable(false);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(30);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		table_2.setDefaultRenderer(String.class, centerRenderer);
		table.setEnabled(false);
		table_2.setEnabled(false);
		contentPane.add(table_2);

		JButton btnNewButton = new JButton("Continue");
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnNewButton.setBounds(157, 506, 300, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton);

		txtStatisticsLeaders = new JTextField();
		txtStatisticsLeaders.setBounds(10, 272, 600, 68);
		txtStatisticsLeaders.setText("Statistics Leaders \r\n(only shows one if players are tied)");
		txtStatisticsLeaders.setHorizontalAlignment(SwingConstants.CENTER);
		txtStatisticsLeaders.setFont(new Font("Cambria", Font.PLAIN, 20));
		txtStatisticsLeaders.setEditable(false);
		txtStatisticsLeaders.setColumns(10);
		contentPane.add(txtStatisticsLeaders);

		table_3 = new JTable();
		table_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_3.setFont(new Font("Cambria", Font.PLAIN, 12));
		table_3.setModel(new DefaultTableModel(getLeaders(), new String[] { "New column", "New column" }) {
			Class[] columnTypes = new Class[] { String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_3.setBounds(157, 351, 300, 144);
		table_3.setDefaultRenderer(String.class, centerRenderer);
		table_3.setEnabled(false);
		contentPane.add(table_3);
	}

	public String[][] getLeaders() {
		String[][] leaders = new String[9][2];
		leaders[0] = getStatLeader("FG %");
		leaders[1] = getStatLeader("3P %");
		leaders[2] = getStatLeader("FT %");
		leaders[3] = getStatLeader("Rebounds");
		leaders[4] = getStatLeader("Assists");
		leaders[5] = getStatLeader("Steals");
		leaders[6] = getStatLeader("Blocks");
		leaders[7] = getStatLeader("Turnovers");
		leaders[8] = getStatLeader("Total Points");
		return leaders;
	}

	public String[] getStatLeader(String identifier) {
		String[] terminal = new String[2];
		terminal[0] = identifier;
		terminal[1] = "NA";
		if (myGame.getSize() != 0) {
			Player[] initial = new Player[myGame.getSize()];
			for (int i = 0; i < initial.length; i++) {
				initial[i] = myGame.getPlayer(i);
			}
			mergeSort(initial, identifier);
			Player highest = initial[initial.length - 1];
			if (identifier.equals("FG %")) {
				if (!(highest.get2PointerAttempts() == 0) || !(highest.get3PointerAttempts() == 0))
					if (((highest.getMade2Pointer() + highest.getMade3Pointer()) * 100
							/ (highest.get2PointerAttempts() + highest.get3PointerAttempts())) == 0)
						terminal[1] = "NA";
					else
						terminal[1] = highest.getFirstName() + " " + highest.getLastName();
			} else if (identifier.equals("3P %")) {
				if (!(highest.get3PointerAttempts() == 0)) {
					if (!((highest.getMade3Pointer() * 100) / (highest.get3PointerAttempts()) == 0))
						terminal[1] = highest.getFirstName() + " " + highest.getLastName();
				}
			} else if (identifier.equals("FT %")) {
				if (!(highest.getFreeThrowAttempts() == 0))
					if (!((highest.getMadeFreeThrows() * 100) / highest.getFreeThrowAttempts() == 0))
						terminal[1] = highest.getFirstName() + " " + highest.getLastName();
			} else if (identifier.equals("Rebounds")) {
				if (!(highest.getTotalRebounds() == 0))
					terminal[1] = highest.getFirstName() + " " + highest.getLastName();
			} else if (identifier.equals("Assists")) {
				if (!(highest.getAssists() == 0))
					terminal[1] = highest.getFirstName() + " " + highest.getLastName();
			} else if (identifier.equals("Steals")) {
				if (!(highest.getSteals() == 0))
					terminal[1] = highest.getFirstName() + " " + highest.getLastName();
			} else if (identifier.equals("Blocks")) {
				if (!(highest.getBlocks() == 0))
					terminal[1] = highest.getFirstName() + " " + highest.getLastName();
			} else if (identifier.equals("Turnovers")) {
				if (!(highest.getTurnovers() == 0))
					terminal[1] = highest.getFirstName() + " " + highest.getLastName();
			} else if (identifier.equals("Total Points")) {
				if (!(highest.getTotalPoints() == 0))
					terminal[1] = highest.getFirstName() + " " + highest.getLastName();
			}
			return terminal;
		} else
			return terminal;
	}

	public void mergeSort(Player[] arr, String identifier) {
		int low = 0;
		int i;
		int high = arr.length;
		int mid = (high + low) / 2;
		if (arr.length < 2)
			return;
		else {
			Player[] lo = new Player[mid];
			Player[] hi = new Player[high - mid];
			for (i = 0; i < mid; i++)
				lo[i] = arr[i];
			for (int q = 0; q < high - mid; q++)
				hi[q] = arr[i];
			mergeSort(lo, identifier);
			mergeSort(hi, identifier);
			sort(arr, lo, hi, identifier);
		}
	}

	public void sort(Player[] arr, Player[] low, Player[] high, String identifier) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < low.length && j < high.length) {
			String num1 = "0";
			String num2 = "0";
			Player first = myGame.getPlayer(i);
			Player second = myGame.getPlayer(j);
			if (identifier.equals("FG %")) {
				if (!(first.get2PointerAttempts() == 0) || !(second.get3PointerAttempts() == 0))
					num1 = Double.toString((first.getMade2Pointer() + first.getMade3Pointer()) * 100
							/ (first.get2PointerAttempts() + first.get3PointerAttempts()));
				if (!(second.get2PointerAttempts() == 0) || !(second.get3PointerAttempts() == 0))
					num2 = Double.toString((second.getMade2Pointer() + second.getMade3Pointer()) * 100
							/ (second.get2PointerAttempts() + second.get3PointerAttempts()));
			} else if (identifier.equals("3P %")) {
				if (!(first.get3PointerAttempts() == 0))
					num1 = Double.toString(first.getMade3Pointer() * 100 / first.get3PointerAttempts());
				if (!(second.get3PointerAttempts() == 0))
					num2 = Double.toString(second.getMade3Pointer() * 100 / second.get3PointerAttempts());
			} else if (identifier.equals("FT %")) {
				if (!(first.getFreeThrowAttempts() == 0))
					num1 = Double.toString(first.getMadeFreeThrows() * 100 / first.getFreeThrowAttempts());
				if (!(second.getFreeThrowAttempts() == 0))
					num2 = Double.toString(second.getMadeFreeThrows() * 100 / second.getFreeThrowAttempts());
			} else if (identifier.equals("Rebounds")) {
				num1 = Integer.toString(first.getTotalRebounds());
				num2 = Integer.toString(second.getTotalRebounds());
			} else if (identifier.equals("Assists")) {
				num1 = Integer.toString(first.getAssists());
				num2 = Integer.toString(second.getAssists());
			} else if (identifier.equals("Steals")) {
				num1 = Integer.toString(first.getSteals());
				num2 = Integer.toString(second.getSteals());
			} else if (identifier.equals("Blocks")) {
				num1 = Integer.toString(first.getBlocks());
				num2 = Integer.toString(second.getBlocks());
			} else if (identifier.equals("Turnovers")) {
				num1 = Integer.toString(first.getTurnovers());
				num2 = Integer.toString(second.getTurnovers());
			} else if (identifier.equals("Total Points")) {
				num1 = Integer.toString(first.getTotalPoints());
				num2 = Integer.toString(second.getTotalPoints());
			}
			int numOne = (int) (Double.parseDouble(num1));
			int numTwo = (int) (Double.parseDouble(num2));
			if (numOne < numTwo) {
				arr[k] = low[i];
				i++;
				k++;
			} else {
				arr[k] = high[j];
				j++;
				k++;
			}
		}
		while (i < low.length) {
			arr[k] = low[i];
			i++;
			k++;
		}
		while (j < high.length) {
			arr[k] = high[j];
			j++;
			k++;
		}
	}
}
