package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class brandForm extends JFrame{

	private JFrame frame;
	private JTextField bid;
	private JTextField bname;
	private JTable table;
	private JLabel lblNewLabel_3;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_4;
	private JButton btnEdit;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					brandForm window = new brandForm();
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
	public brandForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 971, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Brand");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(262, 33, 127, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Brand ID");
		lblNewLabel_1.setBackground(new Color(64, 128, 128));
		lblNewLabel_1.setForeground(new Color(128, 0, 64));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(21, 97, 127, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		bid = new JTextField();
		bid.setForeground(new Color(255, 255, 255));
		bid.setBackground(new Color(64, 128, 128));
		bid.setBounds(223, 100, 247, 33);
		frame.getContentPane().add(bid);
		bid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(" Brand Name");
		lblNewLabel_2.setForeground(new Color(128, 0, 64));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 176, 127, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		bname = new JTextField();
		bname.setBackground(new Color(64, 128, 128));
		bname.setBounds(223, 179, 247, 33);
		frame.getContentPane().add(bname);
		bname.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setForeground(new Color(128, 0, 64));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
					PreparedStatement PS = con.prepareStatement("insert into brand values(?,?)");
					PS.setString(1,bid.getText());
					PS.setString(2,bname.getText());
					PS.executeUpdate();
					JOptionPane.showMessageDialog(null,"Insertion Successfull");
					Statement stmt1=con.createStatement();
					ResultSet rs1=stmt1.executeQuery("select * from brand");
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					JOptionPane.showMessageDialog(null,"Insertion Successful");
					
				}
				catch(Exception ep) {System.out.println(ep);}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(51, 304, 179, 43);
		frame.getContentPane().add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(564, 53, 380, 214);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					String BrId = (String)dtm.getValueAt(table.getSelectedRow(),0);
					String BrName = (String)dtm.getValueAt(table.getSelectedRow(),1);
					
					bid.setText(BrId);
					bname.setText(BrName);
					
				
					}catch(Exception pe) {
						System.out.println(pe);
					}
			}
		});
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(64, 128, 128));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Brand Id", "Brand Name"
			}
		));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from brand");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception en) {System.out.println(en);}
		
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(564, 158, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(64, 128, 128));
		btnNewButton_1.setForeground(new Color(128, 0, 64));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage Mp = new MainPage();
				Mp.setVisible(true);
			
			frame.dispose();
			//this.dispose();
			
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(240, 370, 184, 43);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\NITHU\\Pictures\\br1.png"));
		lblNewLabel_4.setBounds(663, 304, 271, 214);
		getContentPane().add(lblNewLabel_4);
		
		btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
					Statement stmt1=con.createStatement();
					String BrId = bid.getText();
					String BrName = bname.getText();
					
					String QEdit = "update brand set bname = '"+BrName+"' where bid = '"+BrId+"'";
					stmt1.executeUpdate(QEdit);
					ResultSet rs1=stmt1.executeQuery("select * from brand");
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					JOptionPane.showMessageDialog(null,"Updated Successfully");
				}
				catch(Exception ep) {System.out.println(ep);
				}
			}
		});
		btnEdit.setForeground(new Color(128, 0, 64));
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEdit.setBackground(new Color(64, 128, 128));
		btnEdit.setBounds(240, 304, 179, 43);
		getContentPane().add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","mca","mca");
					Statement stmt1=con.createStatement();
					int row = table.getSelectedRow();
					String BrId = (String)table.getValueAt(row,0);
					
					String QDel = "delete from brand where bid = '"+BrId+"'";
					stmt1.executeUpdate(QDel);
					ResultSet rs1=stmt1.executeQuery("select * from brand");
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					JOptionPane.showMessageDialog(null,"Deleted Successfully");
				}
				catch(Exception ep) {System.out.println(ep);
				}
			}
		});
		btnDelete.setForeground(new Color(128, 0, 64));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBackground(new Color(64, 128, 128));
		btnDelete.setBounds(51, 370, 179, 43);
		getContentPane().add(btnDelete);
	}
}
