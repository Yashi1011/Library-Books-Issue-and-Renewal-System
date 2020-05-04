package library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

//Admin login page class.

public class Admin_login extends JFrame {

	private static final long serialVersionUID = 1909102238717049914L;
	private JPanel contentPane;
	private JTextField Username_text;
	private JPasswordField Password_text;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_login frame = new Admin_login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the frame.
	
	public Admin_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login");
		setBounds(100, 100, 561, 490);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
		
		JLabel image = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/b4.jfif")).getImage();
		image.setIcon(new ImageIcon(img));
		image.setBounds(0, 0, 950, 72);
		contentPane.add(image);
		
		JPanel right_color = new JPanel();
		right_color.setBackground(new Color(255, 140, 0));
		right_color.setBounds(448, 0, 98, 469);
		contentPane.add(right_color);
		
		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Username.setBackground(Color.WHITE);
		Username.setEnabled(false);
		Username.setBounds(68, 168, 113, 23);
		contentPane.add(Username);
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Password.setEnabled(false);
		Password.setBackground(Color.WHITE);
		Password.setBounds(68, 221, 89, 23);
		contentPane.add(Password);
		
		Username_text = new JTextField();
		Username_text.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Username_text.setBackground(Color.WHITE);
		Username_text.setBounds(211, 169, 153, 23);
		contentPane.add(Username_text);
		Username_text.setColumns(10);
		
		Password_text = new JPasswordField();
		Password_text.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Password_text.setBounds(211, 222, 153, 23);
		contentPane.add(Password_text);
		Password_text.setColumns(10);
		
		//Login button with ActionEvent.
		JButton Login_button = new JButton("Login");
		Login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userText = Username_text.getText();
	            @SuppressWarnings("deprecation")
				String pwdText = Password_text.getText();
	            if(pwdText.isEmpty() || userText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "All the fields are mandatory", "Login", JOptionPane.ERROR_MESSAGE);
					
				}
				else {
					if(userText.equals("Admin") && pwdText.equals("passwd123")) {
						JOptionPane.showMessageDialog(null, "Login successful", "Login", JOptionPane.INFORMATION_MESSAGE);
						Admin_page admin = new Admin_page();
						admin.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Login Failed", "Login", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		Login_button.setBackground(new Color(255, 222, 173));
		Login_button.setBounds(92, 294, 104, 29);
		contentPane.add(Login_button);
		
		//Reset button with Actionevent.
		JButton Reset_button = new JButton("Reset");
		Reset_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Username_text.setText("");
				Password_text.setText("");
				
			}
		});
		Reset_button.setBackground(new Color(255, 222, 173));
		Reset_button.setBounds(247, 294, 98, 29);
		contentPane.add(Reset_button);
		
		//Home button with ActionEvent.
		JButton Homebtn = new JButton("Home");
		Homebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome w = new Welcome();
				w.setVisible(true);
				dispose();
			}
		});
		Homebtn.setBackground(new Color(255, 222, 173));
		Homebtn.setBounds(335, 405, 98, 29);
		contentPane.add(Homebtn);
		
		//Show password check box.
		JCheckBox Showpasswd = new JCheckBox("Show Password");
		Showpasswd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Showpasswd.isSelected()) {
	                Password_text.setEchoChar((char) 0);
	            } else {
	                Password_text.setEchoChar('*');
	            }
			}
		});
		Showpasswd.setBackground(Color.WHITE);
		Showpasswd.setBounds(211, 257, 153, 13);
		contentPane.add(Showpasswd);
		
	}
}
