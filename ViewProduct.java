package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewProduct extends JFrame {

	private JFrame frame;
	private JTable table;
	private JTextField pid;
	private JTextField pname;
	private JTextField ptype;
	private JTextField brand;
	private JTextField rate;
	private JTextField tqty;
	private final JButton btnNewButton = new JButton("Edit");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProduct window = new ViewProduct();
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
	public ViewProduct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 18));
		frame.getContentPane().setBackground(new Color(64, 128, 128));
		frame.setBounds(100, 100, 976, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setBounds(24, 78, 519, 369);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				DefaultTableModel dtm =(DefaultTableModel) table.getModel();
				String PrID = (String)dtm.getValueAt(table.getSelectedRow(),0);
				String PrName = (String)dtm.getValueAt(table.getSelectedRow(),1);
				String PrTy = (String)dtm.getValueAt(table.getSelectedRow(),2);
				String Br = (String)dtm.getValueAt(table.getSelectedRow(),3);
				String Rate = (String)dtm.getValueAt(table.getSelectedRow(),4);
				String qty = (String)dtm.getValueAt(table.getSelectedRow(),5);
				pid.setText(PrID);
				pname.setText(PrName);
				ptype.setText(PrTy);
				brand.setText(Br);
				rate.setText(Rate);
				tqty.setText(qty);
			
				}catch(Exception pe) {
					System.out.println(pe);
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product ID", "Product Name", "Product Type", "Brand", "Rate", "Total Qty"
			}
		));
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(595, 79, 122, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product Type");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(595, 132, 122, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Brand");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_3.setBounds(595, 173, 104, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Rate");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_4.setBounds(595, 228, 97, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Total Quantity");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_5.setBounds(595, 276, 122, 31);
		frame.getContentPane().add(lblNewLabel_5);
		
		pid = new JTextField();
		pid.setBounds(734, 30, 196, 22);
		frame.getContentPane().add(pid);
		pid.setColumns(10);
		
		pname = new JTextField();
		pname.setColumns(10);
		pname.setBounds(734, 81, 196, 22);
		frame.getContentPane().add(pname);
		
		ptype = new JTextField();
		ptype.setColumns(10);
		ptype.setBounds(734, 134, 196, 22);
		frame.getContentPane().add(ptype);
		
		brand = new JTextField();
		brand.setColumns(10);
		brand.setBounds(734, 178, 196, 22);
		frame.getContentPane().add(brand);
		
		rate = new JTextField();
		rate.setColumns(10);
		rate.setBounds(734, 228, 196, 22);
		frame.getContentPane().add(rate);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
			Statement stmt1=con.createStatement();
			ResultSet rs1=stmt1.executeQuery("select * from product");
			table.setModel(DbUtils.resultSetToTableModel(rs1));
		
		}
		catch(Exception ep) {System.out.println(ep);
		}

		
		tqty = new JTextField();
		tqty.setColumns(10);
		tqty.setBounds(734, 284, 196, 22);
		frame.getContentPane().add(tqty);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
					Statement stmt1=con.createStatement();
					String ProdId = pid.getText();
					String ProdName = pname.getText();
					String ProdType = ptype.getText();
					String ProdBrand = brand.getText();
					String ProdRate = rate.getText();
					String ProdQty = tqty.getText();
					String QEdit = "update product set pname = '"+ProdName+"',ptype= '"+ProdType+"',bname = '"+ProdBrand+"',rate = '"+ProdRate+"',qty = '"+ProdQty+"' where pid = '"+ProdId+"'";
					stmt1.executeUpdate(QEdit);
					ResultSet rs1=stmt1.executeQuery("select * from product");
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					JOptionPane.showMessageDialog(null,"Updation Successful");
				}
				catch(Exception ep) {System.out.println(ep);
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnNewButton.setBounds(560, 395, 148, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
					Statement stmt1=con.createStatement();
					int row = table.getSelectedRow();
					String ProdId = (String)table.getValueAt(row,0);
					
					String QDel = "delete from product where pid = '"+ProdId+"'";
					stmt1.executeUpdate(QDel);
					ResultSet rs1=stmt1.executeQuery("select * from product");
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					JOptionPane.showMessageDialog(null,"Deletion Successful");
				}
				catch(Exception ep) {System.out.println(ep);
				}
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnNewButton_1.setBounds(718, 395, 148, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage Mp = new MainPage();
				Mp.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnNewButton_2.setBounds(629, 441, 148, 36);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblProductId.setBounds(595, 25, 103, 25);
		frame.getContentPane().add(lblProductId);
		
		JLabel lblNewLabel = new JLabel("VIEW PRODUCT");
		lblNewLabel.setForeground(new Color(118, 7, 80));
		lblNewLabel.setBackground(new Color(64, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(20, 25, 236, 27);
		frame.getContentPane().add(lblNewLabel);
	}

}
