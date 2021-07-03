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
import java.util.Date;


public class AddDrivers extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4, t5,td1,t6;
    private JComboBox comboBox;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
        new AddDrivers().setVisible(true);
    }
    
    public void random()
	{
		Random rd=new Random();
		td1.setText("" + rd.nextInt(1000+1));
	//	t3.setText(rd.nextInt(1000000000+1)+"1234");
	}


    public AddDrivers() {
    	super("ADD DRIVER");
        setSize(1000, 500);
		setLocationRelativeTo(null);
		setResizable(false);
       // setUndecorated(true);


//	contentPane = new JPanel();
//	setContentPane(contentPane);
//	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Driver.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1000, 500,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(0,0,1000,500);
                add(l15);
        
        JLabel l10 = new JLabel("ADD DRIVERS");
        l10.setFont(new Font("Tahoma", Font.BOLD|Font.ITALIC, 24));
	l10.setBounds(594, 170, 210, 22);
	l15.add(l10);
        
	JLabel ld1 = new JLabel("ID No.");
	ld1.setForeground(new Color(25, 25, 112));
	ld1.setFont(new Font("Tahoma", Font.BOLD, 14));
	ld1.setBounds(64, 30, 102, 22);
	l15.add(ld1);
	
	
	td1 = new JTextField();
	td1.setBounds(174, 30, 156, 20);
    td1.setFont(new Font("Tahoma", Font.BOLD, 16));

	l15.add(td1);
        
	JLabel l1 = new JLabel("Name");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(64, 70, 102, 22);
	l15.add(l1);
        
        
        t1 = new JTextField();
	t1.setBounds(174, 70, 156, 20);
    t1.setFont(new Font("Tahoma", Font.BOLD, 16));
    t1.setForeground(Color.BLUE);

	l15.add(t1);
        

	JLabel l2 = new JLabel("Age");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 110, 102, 22);
	l15.add(l2);
        
        t2 = new JTextField();
	t2.setBounds(174, 110, 156, 20);
    t2.setFont(new Font("Tahoma", Font.BOLD, 16));

	l15.add(t2);


	JLabel l3 = new JLabel("Gender");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 150, 102, 22);
	l15.add(l3);
        
        comboBox = new JComboBox(new String[] { "Male", "Female" });
	comboBox.setBounds(176, 150, 154, 20);
	l15.add(comboBox);

//	JLabel l4 = new JLabel("Car Company");
//	l4.setForeground(new Color(25, 25, 112));
//	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
//	l4.setBounds(64, 190, 102, 22);
//	l15.add(l4);
        
//        t3 = new JTextField();
//	t3.setBounds(174, 190, 156, 20);
	//l15.add(t3);

        JLabel l5 = new JLabel("Car Brand");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 190, 102, 22);
	l15.add(l5);


        t4 = new JTextField();
	t4.setBounds(174, 190, 156, 20);
    t4.setFont(new Font("Tahoma", Font.BOLD|Font.ITALIC, 16));
    t4.setForeground(Color.RED);

	l15.add(t4);

	
        JLabel l6 = new JLabel("Mobile No.");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(64, 230, 102, 22);
	l15.add(l6);


        t6 = new JTextField();
	t6.setBounds(176, 230, 154, 20);
    t6.setFont(new Font("Tahoma", Font.BOLD, 16));

	l15.add(t6);

        
        JLabel l7 = new JLabel("Location");
	l7.setForeground(new Color(25, 25, 112));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(64, 270, 102, 22);
	l15.add(l7);


        t5 = new JTextField();
	t5.setBounds(174, 270, 156, 20);
    t5.setFont(new Font("Tahoma", Font.BOLD, 16));

	l15.add(t5);
        
	

	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(64, 340, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        l15.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(198, 340, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        l15.add(b2);
        random();

	
       // l15.setBackground(Color.WHITE);
    
    }
    
    public void actionPerformed(ActionEvent ae){
       
    	Conn cc=new Conn();
    	
    	
    	String ab=td1.getText();

    	String a=t1.getText();
    	String b=t2.getText();
    	String c=(String)comboBox.getSelectedItem();
    	
    	String e=t4.getText();
    	String f=t6.getText();
    	String g=t5.getText();

    	String date=new Date().toString();


    	try
    	{
    		if(ae.getSource()==b1)
    		{
    			String sql="insert into driver values('"+ab+"','"+a+"','"+b+"','"+c+"','"+e+"','"+f+"','"+g+"','"+date+"')";
    			int i=cc.s.executeUpdate(sql);
    			if(i>0)
    			{
    			JOptionPane.showMessageDialog(null,"Driver Added Successfully");
    			setVisible(false);
    			new Dashboard("").setVisible(true);

    			}
    			else
    			{

    			}
    			
    		}
    		else if(ae.getSource()==b2)
    		{
    			this.setVisible(false);
    			new Dashboard("").setVisible(true);
    		}
    		{
    			
    		}
    	}
    	catch(Exception er)
    	{
			JOptionPane.showMessageDialog(null,"Error! Driver_id already exists");
    	}
    }
}
