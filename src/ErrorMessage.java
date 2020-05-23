import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrorMessage extends JFrame {

	private JPanel contentPane;

	public ErrorMessage(int num) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 778, 161);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblError = new JLabel("");
		if (num == 1)
			lblError.setText("Team already full");
		else if (num == 2)
			lblError.setText("Incorrect Input format. Please input in all fields correctly");
		else if (num == 3)
			lblError.setText("Player not found in the game. Please check inputs for player name and number accuracy");
		else if (num == 4)
			lblError.setText("Player number already found in game.");
		else if (num == 5)
			lblError.setText("Team is empty");
		else if (num == 6)
			lblError.setText("Please input game identifier");
		else if (num == 7)
			lblError.setText("No previous games found");
		else if (num == 8)
			lblError.setText("Please select before attempting to continue");
		else if (num == 9)
			lblError.setText("Statistic is already at 0");
		else if (num == 0)
			lblError.setText("Game identifier already exists, please choose another");
		lblError.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 11, 742, 59);
		contentPane.add(lblError);

		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnContinue.setBounds(322, 89, 122, 23);
		contentPane.add(btnContinue);
	}

	public ErrorMessage(String name, int num) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 778, 161);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblError = new JLabel("");
		if (num == 4)
			lblError.setText("Warning: " + name + " has 4 fouls.");
		else if (num == 5)
			lblError.setText(name + " has 5 fouls, he is fouled out.");

		lblError.setFont(new Font("Cambria", Font.PLAIN, 25));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 11, 742, 59);
		contentPane.add(lblError);

		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnContinue.setBounds(322, 89, 122, 23);
		contentPane.add(btnContinue);
	}
}
