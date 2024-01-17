package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class View_phụ_chuyenkhoang extends JFrame {

	private JPanel contentPane;
	private JTextField txtamountField;
	private JTextField txtcartID;
	private JTextField txtDescription;
	private JPasswordField txtpasss;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_phụ_chuyenkhoang frame = new View_phụ_chuyenkhoang();
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

	public String generateRandomReferenceCode() {
		// Generate a random alphanumeric reference code
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int length = 8;
		StringBuilder randomCode = new StringBuilder();

		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			randomCode.append(characters.charAt(randomIndex));
		}

		return randomCode.toString();
	}

	public View_phụ_chuyenkhoang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 508, 307);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("New label");
		label.setBounds(69, 61, 74, -3);
		panel.add(label);

		JLabel amount = new JLabel("Amount");
		amount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		amount.setBounds(32, 61, 83, 16);
		panel.add(amount);

		txtamountField = new JTextField();
		txtamountField.setBounds(168, 61, 215, 26);
		panel.add(txtamountField);
		txtamountField.setColumns(10);

		JButton transferButton = new JButton("Transfer ");
		transferButton.setBackground(new Color(244, 244, 244));
		transferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Retrieve values from input fields
					String password = txtpasss.getText();
					String soTienStr = txtamountField.getText();
					String soTaiKhoan = txtcartID.getText();
					String mota = txtDescription.getText();
					String referenceCode = generateRandomReferenceCode();
					// Connect to the database
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/ACCOUNT";
					String username = "baobeo";
					String passwordDB = "vanbaoub123";

					try (Connection connection = DriverManager.getConnection(url, username, passwordDB)) {
						// Prepare and execute the query
						String sql = "SELECT * FROM DANGKY WHERE PassWord=?";
						try (PreparedStatement ps = connection.prepareStatement(sql)) {
							ps.setString(1, password);
							ResultSet rs = ps.executeQuery();

							if (rs.next()) {
								// Valid password, perform money transfer logic here
								double soTien = Double.parseDouble(soTienStr);
								JOptionPane.showMessageDialog(transferButton,
										"Đã chuyển " + soTien + " đến tài khoản " + soTaiKhoan + ".  " + mota);
							}
							// Add any additional steps after money transfer
							else if (txtcartID.getText().isEmpty()) {
								JOptionPane.showMessageDialog(transferButton, "Vui lòng không để trống số thẻ ! ",
										"Error", JOptionPane.ERROR_MESSAGE);

							} else if (txtpasss.getText().isEmpty()) {
								JOptionPane.showMessageDialog(transferButton, "Vui lòng nhập mật khẩu ! ", "Error",
										JOptionPane.ERROR_MESSAGE);

							} else if (txtamountField.getText().isEmpty()) {
								JOptionPane.showMessageDialog(transferButton, "Vui lòng nhập số tiền hợp lệ !");
							} else {
								JOptionPane.showMessageDialog(transferButton,
										"Bạn chưa nhập hoặc nhập không chính xác ! ", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						} // Lấy ngày và giờ thời gian hiện tại
						LocalDateTime currentDateTime = LocalDateTime.now();
						Timestamp transferDateTime = Timestamp.valueOf(currentDateTime);
						BigDecimal transferAmount = new BigDecimal("100.50");

						// Thực hiện truy vấn để lưu vào bảng chuyển tiền

						// Thực hiện truy vấn để lưu vào bảng lịch sử
						String historyQuery = "INSERT INTO HISTORY_ (Id, AccountNumber, Amount, Description, History_datetime, reference_code) VALUES (DEFAULT, ?, ?, ?, ?, ?)";
						try (PreparedStatement historyStatement = connection.prepareStatement(historyQuery)) {
							historyStatement.setString(1, txtcartID.getText());
							historyStatement.setString(2, txtamountField.getText());
							historyStatement.setString(3, txtDescription.getText());
							historyStatement.setTimestamp(4, transferDateTime);
							historyStatement.setString(5, referenceCode);
							historyStatement.executeUpdate();

						}

					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(transferButton, "Vui lòng nhập số tiền hợp lệ !");
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(transferButton, "Vui lòng nhập lại mật khẩu !", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (ClassNotFoundException e3) {
					JOptionPane.showMessageDialog(transferButton, "Bạn chưa nhập hoặc nhập không chính xác ! ", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		transferButton.setBounds(351, 255, 146, 29);
		panel.add(transferButton);

		JLabel tlaybleransfer = new JLabel("Transfer");
		tlaybleransfer.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tlaybleransfer.setBounds(192, 20, 123, 29);
		panel.add(tlaybleransfer);

		JButton Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Cancel.setBounds(220, 256, 117, 29);
		panel.add(Cancel);

		txtcartID = new JTextField();
		txtcartID.setBounds(168, 95, 215, 26);
		panel.add(txtcartID);
		txtcartID.setColumns(10);

		JLabel sốthẻ = new JLabel("Cart ID");
		sốthẻ.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		sốthẻ.setBounds(32, 99, 125, 16);
		panel.add(sốthẻ);

		txtDescription = new JTextField();
		txtDescription.setBackground(Color.LIGHT_GRAY);
		txtDescription.setText("Description :");
		txtDescription.setBounds(21, 127, 403, 80);
		panel.add(txtDescription);
		txtDescription.setColumns(10);

		txtpasss = new JPasswordField();
		txtpasss.setBounds(167, 209, 190, 26);
		panel.add(txtpasss);

		JLabel lbpass = new JLabel("PassWord");
		lbpass.setBounds(51, 216, 61, 16);
		panel.add(lbpass);
		this.setLocationRelativeTo(null);
	}
}
