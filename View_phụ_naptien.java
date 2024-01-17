package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
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

public class View_phụ_naptien extends JFrame {

	private JPanel contentPane;
	private JTextField txt_naptien;
	private JTextField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_phụ_naptien frame = new View_phụ_naptien();
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

	public View_phụ_naptien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.GRAY);
		contentPane_1.setBounds(0, 0, 450, 272);
		contentPane.add(contentPane_1);

		JLabel EnterNumberPhone = new JLabel("Amount");
		EnterNumberPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		EnterNumberPhone.setBounds(32, 90, 163, 22);
		contentPane_1.add(EnterNumberPhone);

		txt_naptien = new JTextField();
		txt_naptien.setColumns(10);
		txt_naptien.setBounds(151, 88, 223, 29);
		contentPane_1.add(txt_naptien);

		JButton button_naptien = new JButton("Recharge");
		button_naptien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Retrieve values from input fields
					String password = txtpass.getText();
					String soTienStr = txt_naptien.getText();

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
								LocalDateTime currentDateTime = LocalDateTime.now();
								Timestamp transferDateTime = Timestamp.valueOf(currentDateTime);
								BigDecimal transferAmount = new BigDecimal("100.50");
								String referenceCode = generateRandomReferenceCode();
								// Thực hiện truy vấn để lưu vào bảng chuyển tiền

								// Thực hiện truy vấn để lưu vào bảng lịch sử
								String historyQuery = "INSERT INTO DEPOSIT_ (id, amount, reference_code, deposit_date) VALUES (DEFAULT, ?, ?, ?)";
								try (PreparedStatement historyStatement = connection.prepareStatement(historyQuery)) {
									historyStatement.setString(1, txt_naptien.getText());
									historyStatement.setString(2, referenceCode);
									historyStatement.setTimestamp(3, transferDateTime);
									historyStatement.executeUpdate();
								}
								// Valid password, perform money transfer logic here
								double soTien = Double.parseDouble(soTienStr);
								JOptionPane.showMessageDialog(button_naptien,
										"Đã chuyển " + soTien + " đến tài khoản này  ");
							}
							// Add any additional steps after money transfer
							else if (txtpass.getText().isEmpty()) {
								JOptionPane.showMessageDialog(button_naptien, "Vui lòng nhập mật khẩu ! ", "Error",
										JOptionPane.ERROR_MESSAGE);

							} else if (txt_naptien.getText().isEmpty()) {
								JOptionPane.showMessageDialog(button_naptien, "Vui lòng nhập số tiền hợp lệ !");
							} else {
								JOptionPane.showMessageDialog(button_naptien,
										"Bạn chưa nhập hoặc nhập không chính xác ! ", "Error",
										JOptionPane.ERROR_MESSAGE);
							}

							// Lấy ngày và giờ thời gian hiện tại

						}
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(button_naptien, "Vui lòng nhập số tiền hợp lệ !");
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(button_naptien, "Vui lòng nhập lại !", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (ClassNotFoundException e3) {
					JOptionPane.showMessageDialog(button_naptien, "Bạn chưa nhập hoặc nhập không chính xác ! ", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				
				
			}
		});

		button_naptien.setBounds(294, 223, 117, 29);
		contentPane_1.add(button_naptien);

		JLabel undo = new JLabel("Un");
		undo.setForeground(new Color(253, 253, 253));
		undo.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 30));
		undo.setBackground(new Color(10, 8, 11));
		undo.setBounds(18, -3, 115, 53);
		contentPane_1.add(undo);

		JLabel dol = new JLabel("Dol");
		dol.setForeground(new Color(27, 39, 157));
		dol.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 27));
		dol.setBounds(54, 30, 61, 28);
		contentPane_1.add(dol);

		JButton cancle = new JButton("Cancel");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				
			}
		});
		cancle.setBounds(151, 223, 117, 29);
		contentPane_1.add(cancle);

		JLabel lblDepositMoneyInto = new JLabel("Deposit money into account");
		lblDepositMoneyInto.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 21));
		lblDepositMoneyInto.setBounds(127, 46, 309, 22);
		contentPane_1.add(lblDepositMoneyInto);

		txtpass = new JTextField();
		txtpass.setColumns(10);
		txtpass.setBounds(151, 144, 223, 29);
		contentPane_1.add(txtpass);

		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblPassword.setBounds(32, 150, 163, 22);
		contentPane_1.add(lblPassword);
		this.setLocationRelativeTo(null);
	}
}
