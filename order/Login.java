package order;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField account;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 40));
		lblNewLabel.setBounds(174, 10, 103, 59);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(85, 135, 70, 34);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("密碼:");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(85, 211, 70, 34);
		contentPane.add(lblNewLabel_2);

		account = new JTextField();
		account.setBounds(152, 135, 125, 29);
		contentPane.add(account);
		account.setColumns(10);

		password = new JTextField();
		password.setBounds(152, 211, 125, 29);
		contentPane.add(password);
		password.setColumns(10);

		JButton login = new JButton("登入");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (account.getText().equals("qwe") && password.getText().equals("qwe")) {
					dispose();
					AddOrder a = new AddOrder();
					a.setVisible(true);

				}
			}
		});
		login.setFont(new Font("新細明體", Font.BOLD, 20));
		login.setBounds(152, 277, 125, 43);
		contentPane.add(login);

		JLabel lblNewLabel_3 = new JLabel("預設:qwe");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_3.setBounds(303, 135, 80, 29);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("預設:qwe");
		lblNewLabel_3_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(303, 211, 80, 29);
		contentPane.add(lblNewLabel_3_1);

		JButton btnNewButton = new JButton("離開");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(387, 328, 87, 23);
		contentPane.add(btnNewButton);
	}
}
