package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.security.auth.spi.LoginModule;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class ViewSignUp extends JFrame {
	StringBuilder stb = new StringBuilder();
	private JTextField txtUserName;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	private JTextField nation;
	private JTextField txtphone;
	private JTextField gmail;

	public static void main(String[] args) {
		// Thay thế thông tin kết nối của bạn

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSignUp frame = new ViewSignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewSignUp() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);

		txtUserName = new JTextField();
		txtUserName.setBackground(Color.WHITE);
		txtUserName.setBounds(63, 130, 764, 26);
		getContentPane().add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(50, 108, 61, 16);
		getContentPane().add(lblNewLabel);

		JLabel UserName = new JLabel("User Name");
		UserName.setBounds(35, 102, 105, 16);
		getContentPane().add(UserName);

		JLabel lblNewLabel_2 = new JLabel("Gmail");
		lblNewLabel_2.setBounds(30, 168, 61, 16);
		getContentPane().add(lblNewLabel_2);

		JLabel NationID = new JLabel("Nation ID");
		NationID.setBounds(29, 224, 134, 16);
		getContentPane().add(NationID);

		JLabel Password = new JLabel("Password");
		Password.setBounds(30, 356, 100, 16);
		getContentPane().add(Password);

		passwordField_2 = new JPasswordField(null);
		passwordField_2.setBackground(Color.WHITE);
		passwordField_2.setBounds(63, 374, 764, 26);
		getContentPane().add(passwordField_2);

		passwordField_3 = new JPasswordField(null);
		passwordField_3.setBackground(Color.WHITE);
		passwordField_3.setBounds(63, 428, 764, 26);
		getContentPane().add(passwordField_3);

		JLabel confirmpassss = new JLabel("confirmpassss");
		confirmpassss.setBounds(29, 412, 105, 14);
		getContentPane().add(confirmpassss);

		nation = new JTextField();
		nation.setBounds(63, 252, 764, 29);
		getContentPane().add(nation);
		nation.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setBounds(30, 293, 105, 16);
		getContentPane().add(lblNewLabel_4);

		txtphone = new JTextField();
		txtphone.setBounds(63, 318, 764, 26);
		getContentPane().add(txtphone);
		txtphone.setColumns(10);

		gmail = new JTextField();
		gmail.setColumns(10);
		gmail.setBounds(63, 183, 764, 29);
		getContentPane().add(gmail);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(-11, 466, 902, 66);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton thoát = new JButton("Cancel");
		thoát.setBounds(588, 18, 97, 29);
		panel.add(thoát);

		JButton đăngkys = new JButton("Sign Up");
		đăngkys.setBounds(723, 18, 117, 29);
		panel.add(đăngkys);

		JCheckBox Stayloggedinforfaster = new JCheckBox("Stay logged in for faster purchases");
		Stayloggedinforfaster.setForeground(Color.LIGHT_GRAY);
		Stayloggedinforfaster.setBounds(72, 17, 230, 29);
		panel.add(Stayloggedinforfaster);
		Stayloggedinforfaster.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(-11, 0, 902, 90);
		getContentPane().add(panel_1);

		JLabel paywithundol = new JLabel("Pay with UnDol");
		paywithundol.setForeground(SystemColor.window);
		paywithundol.setBounds(344, 18, 230, 29);
		panel_1.add(paywithundol);
		paywithundol.setFont(new Font("Lucida Grande", Font.ITALIC, 22));

		JLabel undo_1 = new JLabel("Un");
		undo_1.setBounds(46, 5, 115, 53);
		panel_1.add(undo_1);
		undo_1.setForeground(new Color(253, 253, 253));
		undo_1.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 27));

		JLabel dol = new JLabel("Dol");
		dol.setBounds(78, 30, 61, 28);
		panel_1.add(dol);
		dol.setForeground(new Color(27, 39, 157));
		dol.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 27));

		JLabel lblNewLabel_1 = new JLabel(
				"With a UnDol account, you're eligible for free return shipping, Purchase Protection, and more.");
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(184, 68, 613, 16);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));

		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setForeground(SystemColor.activeCaptionBorder);
		btnNewButton.setBounds(753, 12, 117, 29);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				viewLogIn vlg = new viewLogIn();
				vlg.setVisible(true);// hieen thi man hinh log in
				dispose();

			}
		});
		//////////// controller
		đăngkys.addActionListener(new ActionListener() {
			StringBuilder stb = new StringBuilder();

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				/////////////////

				if (gmail.getText().equals("")) {
					stb.append("Vui long nhap thong tin !\n");
					gmail.setBackground(Color.RED);
				} else {
					gmail.setBackground(Color.WHITE);
				}
				if (nation.getText().equals("")) {
					stb.append("Vui long nhap thong tin !\n");
					nation.setBackground(Color.RED);
				} else {
					nation.setBackground(Color.WHITE);
				}
				if (txtphone.getText().equals("")) {
					stb.append("Vui long nhap thong tin !\n");
					txtphone.setBackground(Color.RED);
				} else {
					txtphone.setBackground(Color.WHITE);
				}
				if (txtUserName.getText().equals("")) {
					stb.append("Vui long nhap thong tin !\n");
					txtUserName.setBackground(Color.RED);
				} else {
					txtUserName.setBackground(Color.WHITE);
				}
				if (passwordField_2.getText().equals("")) {
					stb.append("Vui long nhap thong tin !\n");
					passwordField_2.setBackground(Color.RED);
				} else {
					passwordField_2.setBackground(Color.WHITE);
				}
				if (passwordField_3.getText().equals("")) {
					stb.append("Vui long nhap thong tin !\n");
					passwordField_3.setBackground(Color.RED);
				} else {
					passwordField_3.setBackground(Color.WHITE);
				}

				// kiem tra co chuoi nhap vao hay khong
// hien thi thong bao khi an vao nut dang ky
				int Dk = JOptionPane.showConfirmDialog(đăngkys, "Would you like to register?", "",
						JOptionPane.YES_NO_OPTION);
				if (Dk != JOptionPane.YES_OPTION) {
					return;
				}

// kết nối cơ sở dữ liệu

				try {
					// Load JDBC driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/ACCOUNT";
					String username = "baobeo";
					String password = "vanbaoub123";

					// Connect to the database
					Connection connection = DriverManager.getConnection(url, username, password);

					String sql = "INSERT INTO DANGKY(UserName, Gmail, NationID, PhoneNumber, PassWord, ConfirmPassword) VALUES (?, ?, ?, ?, ?, ?)";
					// Prepare the statement
					PreparedStatement ps = connection.prepareStatement(sql);

					// Set parameters for the statement
					ps.setString(1, txtUserName.getText());
					ps.setString(2, gmail.getText());
					ps.setString(3, nation.getText());
					ps.setString(4, txtphone.getText());
					ps.setString(5, new String(passwordField_2.getPassword()));
					ps.setString(6, new String(passwordField_3.getPassword()));

					// Execute the query
					int n = ps.executeUpdate();

					try {
						char[] password2 = passwordField_2.getPassword();
						char[] password3 = passwordField_3.getPassword();

						if (txtUserName.getText().isEmpty()) {
							JOptionPane.showMessageDialog(đăngkys, "Please enter a username", "Error",
									JOptionPane.ERROR_MESSAGE);
						}

						if (n != 0) {
							if (Arrays.equals(password2, password3)) {

								JOptionPane.showMessageDialog(đăngkys, "You have successfully registered", "Success",
										JOptionPane.INFORMATION_MESSAGE);
								viewLogIn vlgg = new viewLogIn();
								vlgg.setVisible(true);
								dispose();
							}
						} else {
							JOptionPane.showMessageDialog(đăngkys,
									"Registration failed due to invalid data or passwords do not match", "Error",
									JOptionPane.ERROR_MESSAGE);
						}

					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(đăngkys, "  ", "Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (ClassNotFoundException | SQLException e) {

					JOptionPane.showMessageDialog(đăngkys,
							"Please check the text and number field types or check that the spaces are empty" + "",
							"An error occurred during registration", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		thoát.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewLogIn vlg = new viewLogIn();
				vlg.setVisible(true);
				dispose();

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 560);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
