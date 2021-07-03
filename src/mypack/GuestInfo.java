/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import java.awt.*;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GuestInfo extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblJob;
	private JLabel lblName;
	private JLabel lblDepartment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new GuestInfo().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public GuestInfo() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		super("GuestInfo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1160, 600);
		 setLocationRelativeTo(null);
			setResizable(false);
         //   setUndecorated(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Guest.jpg"));
		Image im=i1.getImage().getScaledInstance(1160, 600, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(im);
		final JLabel il1=new JLabel(i2);
		il1.setLayout(null);
		il1.setBounds(0,0,1160,600);
		add(il1);
        
		
		JButton guest = new JButton("ADD GUEST");
		guest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new NewGuest().setVisible(true);
			
			}
				
		});
		guest.setBounds(355, 500, 120, 30);
		guest.setBackground(Color.BLACK);
		guest.setForeground(Color.WHITE);
il1.add(guest);
		
		JButton btnLoadData = new JButton("Show Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JScrollPane sp=new JScrollPane();
				sp.setBounds(0,0,1160,200);
				il1.add(sp);
				
				table = new JTable();
				sp.setViewportView(table);
				
				try{
                                    Conn c = new Conn();
				String displayCustomersql = "select * from guest";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
		});
		btnLoadData.setBounds(515, 500, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		il1.add(btnLoadData);
		
		JButton btnExit = new JButton("Back To Home");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(675, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		il1.add(btnExit);
		
//		lblNewLabel = new JLabel("ID");
//		lblNewLabel.setBounds(51, 11, 46, 14);
//		contentPane.add(lblNewLabel);
//		
//		lblJob = new JLabel("Number");
//		lblJob.setBounds(169, 11, 46, 14);
//		contentPane.add(lblJob);
//		
//		lblName = new JLabel("Name");
//		lblName.setBounds(303, 11, 46, 14);
//		contentPane.add(lblName);
//		
//		lblDepartment = new JLabel("Gender");
//		lblDepartment.setBounds(436, 11, 86, 14);
//		contentPane.add(lblDepartment);
//                
//                JLabel l1 = new JLabel("Country");
//		l1.setBounds(586, 11, 86, 14);
//		contentPane.add(l1);
//                
//                JLabel l2 = new JLabel("Room");
//		l2.setBounds(706, 11, 86, 14);
//		contentPane.add(l2);
//                
//                JLabel l3 = new JLabel("Total Amount");
//		l3.setBounds(806, 11, 106, 14);
//		contentPane.add(l3);
//                
//                JLabel l4 = new JLabel("Deposit");
//		l4.setBounds(986, 11, 86, 14);
//		contentPane.add(l4);
                
                getContentPane().setBackground(Color.WHITE);
	}
}