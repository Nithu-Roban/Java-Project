package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ProductDemo extends JFrame {

	private JFrame frame;
	private JTextField pid;
	private JTextField pname;
	private JTextField rate;
	private JTextField qty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductDemo window = new ProductDemo();
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
	public ProductDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 974, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Id");
		lblNewLabel.setForeground(new Color(249, 6, 6));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(503, 49, 116, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(249, 6, 6));
		lblNewLabel_1.setBounds(503, 121, 154, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product Type");
		lblNewLabel_2.setForeground(new Color(249, 6, 6));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(503, 182, 154, 42);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rate Per Unit");
		lblNewLabel_3.setForeground(new Color(249, 6, 6));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(503, 374, 154, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" Quantity ");
		lblNewLabel_4.setForeground(new Color(249, 6, 6));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(503, 435, 154, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		pid = new JTextField();
		pid.setBounds(717, 55, 215, 42);
		frame.getContentPane().add(pid);
		pid.setColumns(10);
		
		pname = new JTextField();
		pname.setBounds(717, 118, 215, 34);
		frame.getContentPane().add(pname);
		pname.setColumns(10);
		
		 final JComboBox prodType = new JComboBox();
		prodType.setForeground(new Color(64, 0, 0));
		prodType.setFont(new Font("Tahoma", Font.ITALIC, 18));
		prodType.setModel(new DefaultComboBoxModel(new String[] {"--SELECT--", "Input Device", "Output Device", "Desktop", "Laptop"}));
		prodType.setBounds(717, 188, 215, 36);
		frame.getContentPane().add(prodType);
		
		final JComboBox bname = new JComboBox();
		bname.setBounds(717, 269, 215, 30);
		frame.getContentPane().add(bname);
		
		rate = new JTextField();
		rate.setBounds(717, 379, 215, 26);
		frame.getContentPane().add(rate);
		rate.setColumns(10);
		
		qty = new JTextField();
		qty.setBounds(717, 438, 215, 28);
		frame.getContentPane().add(qty);
		qty.setColumns(10);
		
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
		
		JLabel lblNewLabel_5 = new JLabel("ADD PRODUCT");
		lblNewLabel_5.setForeground(new Color(128, 0, 64));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_5.setBounds(212, 27, 188, 46);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Add Product");
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
					PreparedStatement pstmt = con.prepareStatement("insert into product values(?,?,?,?,?,?)");
					pstmt.setString(1,pid.getText());
					pstmt.setString(2,pname.getText());
					String PrType = (String)prodType.getItemAt(prodType.getSelectedIndex());
					pstmt.setString(3,PrType);
					String BrName = (String)bname.getItemAt(bname.getSelectedIndex());
					pstmt.setString(4,BrName);
					
					pstmt.setString(5,rate.getText());
					pstmt.setString(6,qty.getText());
					pstmt.executeUpdate();
//					ResultSet rs = pstmt.executeQuery();
//					if(rs.next()) {
						System.out.println("correct");
						JOptionPane.showMessageDialog(null," Successful");
//						Statement stmt1=con.createStatement();
//						ResultSet rs1=stmt1.executeQuery("select * from brand");
//						table.setModel(DbUtils.resultSetToTableModel(rs1));
						//new MainPage().setVisible(true);
						//MainPage MP = new MainPage();
						//MP.setVisible(true);
						//setVisible(false);
						
					//	MP.se
						
//					}
//					else {
//						System.out.println("wrong");
//						JOptionPane.showMessageDialog(null," invalid entry!!");
//					}
				}
				catch(Exception ep) {
					System.out.println(ep);
				}
			}
		});
		btnNewButton.setBounds(503, 489, 188, 37);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Brand Name");
		lblNewLabel_7.setForeground(new Color(249, 6, 6));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setBounds(503, 263, 154, 36);
		frame.getContentPane().add(lblNewLabel_7);
		
		
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\NITHU\\Pictures\\product.png"));
		lblNewLabel_8.setBounds(0, 0, 547, 561);
		frame.getContentPane().add(lblNewLabel_8);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage Mp = new MainPage();
				Mp.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setForeground(new Color(0, 128, 0));
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnBack.setBounds(701, 489, 188, 37);
		frame.getContentPane().add(btnBack);
	}
}