package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JLabel;

public class MainPage extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
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
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.getContentPane().setBackground(new Color(64, 0, 64));
		frame.getContentPane().setForeground(new Color(64, 0, 64));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.setBounds(100, 100, 941, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setForeground(new Color(64, 0, 0));
		menuBar.setBounds(40, 25, 827, 37);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Brand");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			brandForm BF = new brandForm();
			BF.setVisible(true);
			frame.dispose();
			
			}
		});
		 
		mnNewMenu_1.setForeground(new Color(0, 128, 0));
		mnNewMenu_1.setBackground(new Color(64, 0, 0));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu = new JMenu("Product");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductDemo PD = new ProductDemo();
				PD.setVisible(true);
				frame.dispose();
			}
		});
		mnNewMenu.setForeground(new Color(0, 128, 0));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("Sales");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sales Sa = new Sales();
				Sa.setVisible(true);
				frame.dispose();
			}
		});
		mnNewMenu_2.setForeground(new Color(0, 128, 0));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_4 = new JMenu("View Product");
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewProduct VP = new ViewProduct();
				VP.setVisible(true);
				frame.dispose();
			}
		});
		mnNewMenu_4.setForeground(new Color(0, 128, 0));
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_4);
		
		JMenu mnNewMenu_3 = new JMenu("Logout");
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				frame.dispose();
			}
		});
		mnNewMenu_3.setForeground(new Color(0, 128, 0));
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NITHU\\Pictures\\dash1.png"));
		lblNewLabel.setBounds(0, 0, 927, 787);
		getContentPane().add(lblNewLabel);
	}


	
}
