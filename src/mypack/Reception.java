/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import javax.swing.*;

import java.sql.*;	
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		new Reception();
	}
	
	public Reception(){
		
		        super("Hotel Reception");
                setSize(850, 590);
                setLocationRelativeTo(null);
        		setResizable(false);
            //    setUndecorated(true);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon i11  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Rec.jpg"));
        Image i31 = i11.getImage().getScaledInstance(230, 570,Image.SCALE_DEFAULT);
        ImageIcon i21 = new ImageIcon(i31);
        JLabel l11 = new JLabel(i21);
        l11.setBounds(0,0,230,570);
        add(l11);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/fourth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(620, 570,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(230,0,620,570);
                add(l1);
		
		JButton btnNewCustomerForm = new JButton("New Guest");
		btnNewCustomerForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new NewGuest().setVisible(true);
                                setVisible(false);
			
			
			}
		});
		btnNewCustomerForm.setBounds(10, 30, 200, 30);
                btnNewCustomerForm.setBackground(Color.BLACK);
                btnNewCustomerForm.setForeground(Color.WHITE);
		l11.add(btnNewCustomerForm);
		
		JButton btnNewButton = new JButton("View Rooms");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Room room = new Room();
				room.setVisible(true);
                                setVisible(false);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(10, 70, 200, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);

		l11.add(btnNewButton);
		
        ImageIcon i5  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Back.png"));
        Image i4 = i5.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i4);
        JLabel w11 = new JLabel(i6);
        w11.setBounds(75,500,50,50);
        w11.setForeground(Color.WHITE);
        w11.setToolTipText("GO TO HOME");
        l11.add(w11);
        
        w11.addMouseListener(new MouseAdapter()
		{
	      public void mouseClicked(MouseEvent er)
	      {
	    	  setVisible(false);
	    	  new Dashboard("").setVisible(true);
	      }
		});
		
//		JButton btnNewButton_1 = new JButton("Department");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try{
//					//Department dept = new Department();
//					//dept.setVisible(true);
//					setVisible(false);
//					
//				}
//				catch (Exception e1){
//					e1.printStackTrace();
//				}
//			
//			}
//		});
//		btnNewButton_1.setBounds(10, 110, 200, 30);
//                btnNewButton_1.setBackground(Color.BLACK);
//                btnNewButton_1.setForeground(Color.WHITE);
//
//		l11.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("All Employee Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				
					new EmployeeInfo().setVisible(true);
					setVisible(false);
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_2.setBounds(10, 190, 200, 30);                
                btnNewButton_2.setBackground(Color.BLACK);
                btnNewButton_2.setForeground(Color.WHITE);

		l11.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Guest Info");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//error ---------------------
					new GuestInfo().setVisible(true);				
					setVisible(false);
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(10, 110, 200, 30);
                btnNewButton_3.setBackground(Color.BLACK);
                btnNewButton_3.setForeground(Color.WHITE);

		l11.add(btnNewButton_3);
		
		JButton btnManagerInfo = new JButton("Manager Info");
		btnManagerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				new ManagerInfo().setVisible(true);
                                setVisible(false);
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnManagerInfo.setBounds(10, 230, 200, 30);
                btnManagerInfo.setBackground(Color.BLACK);
                btnManagerInfo.setForeground(Color.WHITE);

		l11.add(btnManagerInfo);
		
		JButton btnNewButton_4 = new JButton("Check Out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOut check;
				try {
					check = new CheckOut();
					check.setVisible(true);
                                        setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(10, 270, 200, 30);
                btnNewButton_4.setBackground(Color.BLACK);
                btnNewButton_4.setForeground(Color.WHITE);

		l11.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Check-Out History");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			new History().setVisible(true);
                                setVisible(false);
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(10, 310, 200, 30);
                btnNewButton_5.setBackground(Color.BLACK);
                btnNewButton_5.setForeground(Color.WHITE);

		l11.add(btnNewButton_5);
		
//		JButton btnNewButton_6 = new JButton("Update Room Status");
//		btnNewButton_6.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try{
//					//UpdateRoom room = new UpdateRoom();
//					//room.setVisible(true);
//                                        setVisible(false);
//				}catch(Exception s)
//				{
//					s.printStackTrace();
//				}
//			}
//		});
//		btnNewButton_6.setBounds(10, 350, 200, 30);
//                btnNewButton_6.setBackground(Color.BLACK);
//                btnNewButton_6.setForeground(Color.WHITE);
//
//		l11.add(btnNewButton_6);
		
		JButton btnPickUpSerice = new JButton("Pick up Service");
		btnPickUpSerice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				DriverDetails pick = new DriverDetails();
				pick.setVisible(true);
                                setVisible(false);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnPickUpSerice.setBounds(10, 390, 200, 30);
                btnPickUpSerice.setBackground(Color.BLACK);
                btnPickUpSerice.setForeground(Color.WHITE);

		l11.add(btnPickUpSerice);
		
		JButton btnSearchRoom = new JButton("Search Room");
		btnSearchRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				SearchRoom search = new SearchRoom();
				search.setVisible(true);
                                setVisible(false);
				}
				catch (Exception ss){
					ss.printStackTrace();
				}
			}
		});
		btnSearchRoom.setBounds(10, 430, 200, 30);
                btnSearchRoom.setBackground(Color.BLACK);
                btnSearchRoom.setForeground(Color.WHITE);

		l11.add(btnSearchRoom);

		JButton btnNewButton_7 = new JButton("Log Out");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					
					JDialog.setDefaultLookAndFeelDecorated(true);
					int rs=JOptionPane.showConfirmDialog(null, "Do You Confirm?",
							             "Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					
					if(rs==JOptionPane.YES_OPTION)
					{
						 new Login().setVisible(true);
                         setVisible(false);
					}
					
					else if(rs==JOptionPane.NO_OPTION)
					{
						
					}
                                   
                                    
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_7.setBounds(10, 470, 200, 30);
                btnNewButton_7.setBackground(Color.BLACK);
                btnNewButton_7.setForeground(Color.WHITE);

		l11.add(btnNewButton_7);
                getContentPane().setBackground(Color.WHITE);
                
                setVisible(true);
	}
}
