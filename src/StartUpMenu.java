import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.events.Namespace;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class StartUpMenu extends JFrame {

	private JPanel contentPane;
	private List<String> names;
	private int num;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartUpMenu frame = new StartUpMenu(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StartUpMenu(int number) {
		setBackground(new Color(240, 240, 240));
		num = number;
		names = new ArrayList<String>();
		readData();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 302);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblSelectTeam = new JLabel("Select Team:");
		lblSelectTeam.setFont(new Font("Cambria", Font.PLAIN, 25));
		lblSelectTeam.setBounds(10, 11, 414, 41);
		lblSelectTeam.setHorizontalAlignment(SwingConstants.CENTER);

		JList list = new JList();
		list.setBounds(111, 63, 1, 1);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Cambria", Font.PLAIN, 14));
		comboBox.setBounds(130, 61, 177, 28);
		comboBox.setModel(new DefaultComboBoxModel(arraylistToArray()));

		JButton btnAddNewTeam = new JButton("Add New Team");
		btnAddNewTeam.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAddNewTeam.setBounds(130, 176, 177, 35);
		btnAddNewTeam.setHorizontalAlignment(SwingConstants.CENTER);
		btnAddNewTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditTeam edit = new EditTeam("Add", 0);
				setVisible(false);
				edit.setVisible(true);
			}
		});

		JButton btnOpenStatisticsSheet = new JButton("Open Statistics Sheet");
		btnOpenStatisticsSheet.setFont(new Font("Cambria", Font.PLAIN, 19));
		btnOpenStatisticsSheet.setBounds(111, 118, 213, 47);
		btnOpenStatisticsSheet.setHorizontalAlignment(SwingConstants.CENTER);
		btnOpenStatisticsSheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == -1) {
					StartUpMenu start = new StartUpMenu(6);
					start.setVisible(true);
					setVisible(false);
				} else {
					String selectedTeam = (String) comboBox.getSelectedItem();
					if (selectedTeam.equals(null)) {
						StartUpMenu start = new StartUpMenu(5);
						start.setVisible(true);
						setVisible(false);
					} else {
						Team current = new Team(selectedTeam);
						StatisticsMenu menu = new StatisticsMenu(current);
						menu.setVisible(true);
						setVisible(false);
					}
				}
			}
		});

		JButton btnRemoveTeam = new JButton("Remove Team");
		btnRemoveTeam.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnRemoveTeam.setBounds(130, 215, 177, 35);
		btnRemoveTeam.setHorizontalAlignment(SwingConstants.CENTER);
		btnRemoveTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditTeam edit = new EditTeam("Remove", names.size());
				setVisible(false);
				edit.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(list);
		contentPane.add(comboBox);
		contentPane.add(lblSelectTeam);
		contentPane.add(btnAddNewTeam);
		contentPane.add(btnRemoveTeam);
		contentPane.add(btnOpenStatisticsSheet);

		JLabel lblNewLabel;
		if (num == 1) {
			lblNewLabel = new JLabel("Team Successfully Added");
		} else if (num == 2) {
			lblNewLabel = new JLabel("Team Successfully Removed");
		} else if (num == 3) {
			lblNewLabel = new JLabel("Team does not exist");
		} else if (num == 4) {
			lblNewLabel = new JLabel("No teams have been inputted");
		} else if (num == 5) {
			lblNewLabel = new JLabel("Please input a team before opening sheet");
		} else if (num == 6) {
			lblNewLabel = new JLabel("Please input and/or select a team before opening sheet");
		} else {
			lblNewLabel = new JLabel("");
		}
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 92, 414, 14);
		contentPane.add(lblNewLabel);
	}

	public void readData() {
		try {
			String file = "TeamsInDirectory.txt";
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				names.add(line);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] arraylistToArray() {
		String[] namesArr = new String[names.size()];
		for (int i = 0; i < names.size(); i++) {
			namesArr[i] = names.get(i);
		}
		return namesArr;
	}

	public int numOfTeams() {
		return names.size();
	}
}
