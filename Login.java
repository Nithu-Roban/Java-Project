package Project;

import java.awt.EventQueue;
import java.sql.*;



import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {

	private JFrame frame;
	private JTextField uid;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.getContentPane().setBackground(new Color(64, 128, 128));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\NITHU\\Pictures\\logo.png"));
		frame.setBounds(100, 100, 966, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		uid = new JTextField();
		uid.setBounds(155, 121, 282, 28);
		frame.getContentPane().add(uid);
		uid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(83, 49, 234, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 112, 157, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 182, 157, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(64, 0, 64));
		btnNewButton.setBackground(new Color(2, 107, 125));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
				PreparedStatement pstmt = con.prepareStatement("select * from login where Login_id = ? and pass =?");
				pstmt.setString(1,uid.getText());
				pstmt.setString(2,pass.getText());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					//System.out.println("correct");
					JOptionPane.showMessageDialog(null,"Login Successfull");
					//new MainPage().setVisible(true);
					MainPage MP = new MainPage();
					MP.setVisible(true);
					//setVisible(false);
					
				//	MP.se
					
				}
				else {
					System.out.println("wrong");
					JOptionPane.showMessageDialog(null," invalid entry!!");
				}
			}
			catch(Exception ep) {
				System.out.println(ep);
			}
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setBounds(108, 268, 151, 42);
		frame.getContentPane().add(btnNewButton);
		
		pass = new JPasswordField();
		pass.setBounds(155, 191, 282, 28);
		frame.getContentPane().add(pass);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\NITHU\\Pictures\\lg2.png"));
		lblNewLabel_3.setBounds(531, 0, 421, 369);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
