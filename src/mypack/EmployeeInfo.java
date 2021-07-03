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
public class EmployeeInfo extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblJob;
	private JLabel lblName;
	private JLabel lblDepartment;
    boolean isModified=false;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new EmployeeInfo().setVisible(true);
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
	public void Show()
	{
		JScrollPane sp=new JScrollPane();
		sp.setBounds(0, 0, 1100, 150);
		add(sp);
		
		table = new JTable();
		//table.setBounds(0, 0, 1100, 150);
		add(table);
		sp.setViewportView(table);
		
	}
	
	public void Run()
	{
		try{
            Conn c = new Conn();
String displayCustomersql = "select * from Employee";
ResultSet rs = c.s.executeQuery(displayCustomersql);
table.setModel(DbUtils.resultSetToTableModel(rs));
}
catch(Exception e1){
e1.printStackTrace();
}
	}
	public EmployeeInfo() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		super("EmployeeInfo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 600);
		 setLocationRelativeTo(null);
			setResizable(false);
        //    setUndecorated(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon iw1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Emp.jpg"));
		Image im1=iw1.getImage().getScaledInstance(1100, 600, Image.SCALE_DEFAULT);
		ImageIcon iw2=new ImageIcon(im1);
		JLabel il2=new JLabel(iw2);
		il2.setLayout(null);
		il2.setBounds(0,0,1100,600);
	//	il2.setToolTipText("LOAD");
		add(il2);
		
		
		JButton btnLoadData = new JButton("SHOW DATA");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(!isModified)
		    	  {
		    		  Show();
		    		  isModified=true;
		    		  
		    	  }
		    	  Run();
				
			}
			
		});
		btnLoadData.setBounds(490, 500, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		il2.add(btnLoadData);
		
		JButton btnExit = new JButton("BACK");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(650, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		il2.add(btnExit);
		
		JButton add = new JButton("ADD EMP");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddEmployee().setVisible(true);
				
			}
		});
		add.setBounds(330, 500, 120, 30);
                add.setBackground(Color.BLACK);
                add.setForeground(Color.WHITE);
		il2.add(add);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(51, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblJob = new JLabel("Age");
		lblJob.setBounds(179, 11, 46, 14);
		contentPane.add(lblJob);
		
		lblName = new JLabel("Gender");
		lblName.setBounds(293, 11, 46, 14);
		contentPane.add(lblName);
		
		lblDepartment = new JLabel("Job");
		lblDepartment.setBounds(446, 11, 86, 14);
		contentPane.add(lblDepartment);
                
                JLabel l1 = new JLabel("Salary");
		l1.setBounds(566, 11, 86, 14);
		contentPane.add(l1);
                
                JLabel l2 = new JLabel("Phone");
		l2.setBounds(706, 11, 86, 14);
		contentPane.add(l2);
                
                JLabel l3 = new JLabel("Aadhar");
		l3.setBounds(846, 11, 86, 14);
		contentPane.add(l3);
                
                JLabel l4 = new JLabel("Gmail");
		l4.setBounds(976, 11, 86, 14);
		contentPane.add(l4);
                
                getContentPane().setBackground(Color.WHITE);
	}
}