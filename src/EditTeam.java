import java.awt.BorderLayout; 
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EditTeam extends StartUpMenu {

	private JPanel contentPane;
	private JTextField textField;

	public EditTeam(String choice, int size) {
		super(size);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 449, 251);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(128, 76, 177, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartUpMenu start = new StartUpMenu(0);
				start.setVisible(true);
				setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnCancel.setBounds(128, 175, 177, 31);
		contentPane.add(btnCancel);

		if (choice.equals("Add")) {
			JLabel lblNewLabel = new JLabel("Add New Team");
			lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 25));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(99, 11, 234, 54);
			contentPane.add(lblNewLabel);

			JButton btnAddNewTeam = new JButton("Add New Team");
			btnAddNewTeam.setFont(new Font("Cambria", Font.PLAIN, 18));
			btnAddNewTeam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String name = textField.getText();
					if(!(name.equals("")))
					{
						writeTeamToFile(name);
						createTeamFile(name);
						close();
					}
					else
					{
						ErrorMessage error = new ErrorMessage(2);
						error.setLocationRelativeTo(textField);
						error.setVisible(true);
					}
				}
			});
			btnAddNewTeam.setBounds(128, 107, 177, 62);
			contentPane.add(btnAddNewTeam);
		} else {
			JLabel lblNewLabel = new JLabel("Remove Team");
			lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 25));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(99, 11, 234, 54);
			contentPane.add(lblNewLabel);

			JButton btnAddNewTeam = new JButton("Remove Team");
			btnAddNewTeam.setFont(new Font("Cambria", Font.PLAIN, 18));
			btnAddNewTeam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (size == 0) {
						StartUpMenu start = new StartUpMenu(4);
						start.setVisible(true);
						setVisible(false);
					} else {
						String name = textField.getText();
						System.out.println("It went here");
						if(!(name.equals("")))
						{
							int num = removeTeamFromFile(name);
							StartUpMenu start = new StartUpMenu(num);
							start.setVisible(true);
							setVisible(false);
						}
						else
						{
							ErrorMessage error = new ErrorMessage(2);
							error.setLocationRelativeTo(textField);
							error.setVisible(true);
						}
					}
				}
			});
			btnAddNewTeam.setBounds(128, 107, 177, 62);
			contentPane.add(btnAddNewTeam);
		}
	}

	public void close() {
		StartUpMenu start = new StartUpMenu(1);
		start.setVisible(true);
		setVisible(false);
	}

	public void writeTeamToFile(String name) {
		BufferedWriter buff;
		try {
			buff = new BufferedWriter(new FileWriter("TeamsInDirectory.txt", true));
			buff.write(name);
			buff.newLine();
			buff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createTeamFile(String name) {
		File file = new File(name + ".txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int removeTeamFromFile(String name) {
		File inputFile = new File("TeamsInDirectory.txt");
		File tempFile = new File("temp.txt");
		int num = 3;
		try {
			BufferedReader reader1 = new BufferedReader(new FileReader(inputFile));
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			String line;
			if (reader1.readLine() == null)
				num = 4;
			else {
				while ((line = reader.readLine()) != null) {
					if (line.equals(name) == false)
						writer.write(line + System.getProperty("line.separator"));
					else {
						num = 2;
						File existingFile = new File(name + ".txt");
						existingFile.delete();
					}
				}
				writer.close();
				reader.close();
				reader1.close();
				inputFile.delete();
				tempFile.renameTo(inputFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}
}
