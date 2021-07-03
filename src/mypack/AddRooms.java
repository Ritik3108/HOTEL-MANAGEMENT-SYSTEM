/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRooms extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2,b3;
    Choice c1;

    public static void main(String[] args) {
        new AddRooms().setVisible(true);
    }


    public AddRooms() {
    	super("ADD ROOMS");
        setSize(1000, 450);
        setLocationRelativeTo(null);
		setResizable(false);
       // setUndecorated(true);

	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/twelve.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1000, 450,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(0,0,1000,450);
                add(l15);
        
        JLabel l10 = new JLabel("ADD ROOMS");
        l10.setFont(new Font("Tahoma", Font.BOLD, 24));
	l10.setBounds(414, 27, 320, 22);
	l15.add(l10);
        
	
        
	JLabel l1 = new JLabel("Room Number");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(364, 70, 102, 22);
	l15.add(l1);
        
        
        t4 = new JTextField();
	t4.setBounds(500, 70, 156, 20);
    t4.setFont(new Font("Tahoma", Font.BOLD, 16));

	l15.add(t4);
        

	JLabel l2 = new JLabel("Availability");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(364, 110, 102, 22);
	l15.add(l2);
        
        comboBox = new JComboBox(new String[] { "Available", "Occupied" });
	comboBox.setBounds(500, 110, 154, 20);
	l15.add(comboBox);


	JLabel l3 = new JLabel("Cleaning Status");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(364, 150, 102, 22);
	l15.add(l3);
        
        comboBox_2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
	comboBox_2.setBounds(500, 150, 154, 20);
	l15.add(comboBox_2);

	JLabel l4 = new JLabel("Price");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(364, 190, 102, 22);
	l15.add(l4);
        
        t2 = new JTextField();
	t2.setBounds(500, 190, 156, 20);
    t2.setFont(new Font("Tahoma", Font.PLAIN, 16));
    t2.setForeground(Color.RED);


	l15.add(t2);

        JLabel l5 = new JLabel("Bed Type");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(364, 230, 102, 22);
	l15.add(l5);


        comboBox_3 = new JComboBox(new String[] { "Single Bed", "Double Bed"});
	comboBox_3.setBounds(500, 230, 154, 20);
	l15.add(comboBox_3);

	

	

	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(314, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        l15.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(448, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        l15.add(b2);
        
        b3 = new JButton("View Rooms");
    	b3.addActionListener(this);
    	b3.setBounds(582, 321, 111, 33);
            b3.setBackground(Color.BLACK);
            b3.setForeground(Color.WHITE);
            l15.add(b3);

	
        contentPane.setBackground(Color.WHITE);
    
    }
    
    public void actionPerformed(ActionEvent ae)
    {
       Conn cc=new Conn();
       
       String a=t4.getText();
       String b=(String)comboBox.getSelectedItem();
       String c=(String)comboBox_2.getSelectedItem();
       String d=t2.getText();
       String e=(String)comboBox_3.getSelectedItem();

       try
       {
    	   if(ae.getSource()==b1)
    	   {
    		   String sql="insert into room values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"')";
    		   try
    		   {
    		   int i=cc.s.executeUpdate(sql);
    		   
    		   if(i>0)
    		   {
    			   JOptionPane.showMessageDialog(null,"Room Added Successfully");
        		   setVisible(false);
                 	 new Dashboard("").setVisible(true);

    		   }}
    		   catch(Exception er)
    		   {
    			   JOptionPane.showMessageDialog(null,"Error! Room No. already exists");

    		   }
    		  
    	   }
    	   else if(ae.getSource()==b2)
    	   {
    		   this.setVisible(false);
    		   new Dashboard("").setVisible(true);
    	   }
    	   else if(ae.getSource()==b3)
    	   {
    		   this.setVisible(false);
    		   new Room().setVisible(true);
    	   }
       }
       catch(Exception er)
       {
    	   er.printStackTrace();
       }
    
    }
}
