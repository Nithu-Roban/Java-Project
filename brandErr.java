package Project;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class brandErr {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					brandErr window = new brandErr();
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
	public brandErr() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JComboBox bname = new JComboBox();
		bname.setBounds(152, 69, 29, 21);
		frame.getContentPane().add(bname);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
			Statement sm = con.createStatement();
			ResultSet rs1 = sm.executeQuery("select bname from Brand");
			while(rs1.next()) {
				bname.addItem(rs1.getString(1));
			}
		}catch(Exception Eq) {
			System.out.println(Eq);
		}
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
					PreparedStatement sm = con.prepareStatement("insert into b1 values(?)");
					//int i = 
					String BrNa = bname.getSelectedItem().toString();
					sm.setString(1,BrNa);
					sm.executeUpdate();
					System.out.print("success");
				}
				catch(Exception Eq) {
					System.out.println(Eq);
				}
			}
		});
		btnNewButton.setBounds(121, 116, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}

}
