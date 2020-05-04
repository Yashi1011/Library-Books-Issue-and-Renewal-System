package library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

//Welcome frame class.

public class Welcome extends JFrame {

	private static final long serialVersionUID = -1231162967250404115L;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the frame.
	
	public Welcome() {
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
		
		//Admin button along with ActionEvent.
		JButton Admin = new JButton("Admin");
		Admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_login login = new Admin_login();
				login.setVisible(true);
				dispose();
			}
		});
		Admin.setBackground(new Color(255, 222, 173));
		Admin.setBounds(155, 220, 115, 30);
		contentPane.add(Admin);
		
		//Student button along with ActionEvent.
		JButton Student = new JButton("Student");
		Student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_page studentpg;
				try {
					studentpg = new Student_page();
					studentpg.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Student.setBackground(new Color(255, 222, 173));
		Student.setBounds(155, 298, 115, 30);
		contentPane.add(Student);
		
		JLabel welcome = new JLabel("Welcome to Library ");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("Times New Roman", Font.BOLD, 30));
		welcome.setForeground(new Color(255, 140, 0));
		welcome.setBackground(new Color(255, 255, 255));
		welcome.setBounds(62, 135, 306, 46);
		contentPane.add(welcome);
	}

}
