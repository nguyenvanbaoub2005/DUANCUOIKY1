package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class viewLogIn extends JFrame {

	// Kết nối đến cơ sở dữ liệu

	private JPanel contentPane;
	private JTextField txtsdt;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 * 
	 * @throws SQLException
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewLogIn frame = new viewLogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public viewLogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 244, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setBackground(Color.WHITE);
		txtsdt.setBounds(499, 184, 363, 26);
		contentPane.add(txtsdt);

		JLabel phonenumber = new JLabel("Phone Number");
		phonenumber.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		phonenumber.setBounds(482, 153, 131, 16);
		contentPane.add(phonenumber);

		JLabel lblPassWord = new JLabel("PassWord");
		lblPassWord.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPassWord.setBounds(486, 240, 98, 16);
		contentPane.add(lblPassWord);

		JButton login = new JButton("Log In");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/ACCOUNT";
					String username = "baobeo";
					String password = "vanbaoub123";
					ResultSet rs;

					// Kết nối đến cơ sở dữ liệu

					Connection connection = DriverManager.getConnection(url, username, password);
					String sql = "SELECT* FROM DANGKY WHERE PhoneNumber=? and PassWord=?";// truy vấn đến sql
					PreparedStatement ps = connection.prepareCall(sql);// cho phép chỉ định tham số đầu vào khi run
					ps.setString(1, txtsdt.getText());// nhận vào 1 tham số khi ai nhập vào
					ps.setString(2, txtpass.getText());// nhap apk mk
					rs = ps.executeQuery();// executeQuery tra về thằng ResultSet khi thực hiện câu lệnh sellec

					if (txtsdt.getText().isEmpty() | txtpass.getText().isEmpty()) {
						JOptionPane.showMessageDialog(login, "Please do not leave it blank ", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (rs.next())

					// có dữ liệu
					{
						JOptionPane.showMessageDialog(login, "Logged in successfully ");
						viewTrangChu vtc = new viewTrangChu();
						vtc.setVisible(true);
						dispose();

					} else {
						JOptionPane.showMessageDialog(login, "Login failed ! Incorrect account number or password",
								"Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception e2) {
					System.out.println(e2);

				}

			}
		});
		login.setBounds(701, 325, 161, 29);
		contentPane.add(login);

		txtpass = new JPasswordField();
		txtpass.setBounds(506, 265, 354, 26);
		contentPane.add(txtpass);

		JButton Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Cancel.setBounds(537, 325, 117, 29);
		contentPane.add(Cancel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(-24, 0, 902, 90);
		contentPane.add(panel_1);

		JLabel paywithundol = new JLabel("Pay with");
		paywithundol.setForeground(SystemColor.window);
		paywithundol.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
		paywithundol.setBounds(344, 29, 115, 29);
		panel_1.add(paywithundol);

		JLabel undo_1 = new JLabel("Un");
		undo_1.setForeground(new Color(253, 253, 253));
		undo_1.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 27));
		undo_1.setBounds(59, 5, 115, 53);
		panel_1.add(undo_1);

		JLabel dol = new JLabel("Dol");
		dol.setForeground(Color.WHITE);
		dol.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 27));
		dol.setBounds(90, 30, 61, 28);
		panel_1.add(dol);

		JButton signup = new JButton("Sign Up");
		signup.setBounds(764, 22, 117, 29);
		panel_1.add(signup);
		
		JLabel lblUndol = new JLabel("UnDol");
		lblUndol.setForeground(SystemColor.window);
		lblUndol.setFont(new Font("Lucida Grande", Font.ITALIC, 23));
		lblUndol.setBounds(438, 43, 96, 29);
		panel_1.add(lblUndol);
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSignUp bv = new ViewSignUp();
				bv.setVisible(true);
				dispose();

			}
		});

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 466, 902, 66);
		contentPane.add(panel);

		JLabel r = new JLabel("# Full wealth and good luck for you");
		r.setForeground(Color.LIGHT_GRAY);
		r.setBounds(30, 22, 244, 18);
		panel.add(r);
		r.setFont(new Font("Mali", Font.PLAIN, 13));

		JLabel lblNewLabel_1 = new JLabel(
				"With a UnDol account, you're eligible for free return shipping, Purchase Protection, and more.");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(320, 24, 613, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/Users/nguyenvan/Downloads/image001-8277-1651140699 copy.png"));
		lblNewLabel.setBounds(1, 90, 472, 375);
		contentPane.add(lblNewLabel);
		this.setLocationRelativeTo(null);
	}
}
