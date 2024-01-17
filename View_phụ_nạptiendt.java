package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_phụ_nạptiendt extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_phụ_nạptiendt frame = new View_phụ_nạptiendt();
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
	public View_phụ_nạptiendt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EnterNumberPhone = new JLabel("Enter phone number");
		EnterNumberPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		EnterNumberPhone.setBounds(28, 103, 163, 22);
		contentPane.add(EnterNumberPhone);
		
		textField = new JTextField();
		textField.setBounds(203, 101, 184, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton butonnaptien = new JButton("Recharge");
		butonnaptien.setBounds(294, 223, 117, 29);
		contentPane.add(butonnaptien);
		
		JLabel undo = new JLabel("Un");
		undo.setBackground(new Color(10, 8, 11));
		undo.setForeground(new Color(253, 253, 253));
		undo.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 30));
		undo.setBounds(18, -3, 115, 53);
		contentPane.add(undo);
		JLabel dol = new JLabel("Dol");
		dol.setForeground(new Color(27, 39, 157));
		dol.setFont(new Font("Nanum Myeongjo", Font.PLAIN, 27));
		dol.setBounds(54, 30, 61, 28);
		contentPane.add(dol);
		
		JButton cancle = new JButton("Cancel");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
				
			}
		});
		cancle.setBounds(151, 223, 117, 29);
		contentPane.add(cancle);
		
		JLabel lblPhoneRecharge = new JLabel("Phone recharge");
		lblPhoneRecharge.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		lblPhoneRecharge.setBounds(174, 53, 177, 22);
		contentPane.add(lblPhoneRecharge);
		this.setLocationRelativeTo(null);
	}
}
