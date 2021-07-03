/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

//import hotel.management.system.Reception;
import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.util.Date;


public class CheckOut extends JFrame{
	
	private JPanel contentPane;
	private JTextField t1,t2,t11;
    Choice c1;

	public static void main(String[] args) {
		
					CheckOut frame = new CheckOut();
					frame.setVisible(true);
	}
	//public void close(){
	//	this.dispose();
	//}

	
	public CheckOut()
	{
		//conn = Javaconnect.getDBConnection();
		super("CheckOut");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,294);
        setLocationRelativeTo(null);
		setResizable(false);
     //   setUndecorated(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/sixth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(450, 294,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(0,0,450,294);
                add(l1);
		
//		JLabel lblCheckOut = new JLabel("CHECK OUT");
//		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblCheckOut.setBounds(75, 7, 140, 35);
//		contentPane.add(lblCheckOut);
		
		JLabel ID = new JLabel("ID No.");
		ID.setBounds(80, 20, 80, 14);
		ID.setForeground(Color.WHITE);
		l1.add(ID);
		
		 c1=new Choice();
         c1.setBounds(190, 20, 150, 20);
	l1.add(c1);
	
	JLabel lblName = new JLabel("Name :-");
	lblName.setBounds(80, 65, 80, 14);
	lblName.setForeground(Color.WHITE);

	l1.add(lblName);
	
	t11 = new JTextField();
    t11.setBounds(190, 65, 150, 20);
    t11.setFont(new Font("Trebuchet MS",Font.BOLD,16));

l1.add(t11);
	
	        try
	        {
	          Conn cc=new Conn();
	          String sql="select * from guest";
	          ResultSet rs=cc.s.executeQuery(sql);
	          while(rs.next())
	          {
	          c1.add(rs.getString("id_no"));
	          }
	        }
	        catch(Exception et)
	        {
	        	et.printStackTrace();
	        }
	        
	        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/tick.png"));
            Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);
            JButton l2 = new JButton(i6);
            l2.setBounds(350,20,20,20);
            l2.setToolTipText("CHECK CORRESPONDING DETAILS");
            l1.add(l2);
            
            l2.addActionListener(new ActionListener(){
                
                public void actionPerformed(ActionEvent ae)
                {
                  try
                  {
                	Conn ct=new Conn();
                	String sq="select * from guest where id_no = '"+c1.getSelectedItem()+"'";
                	ResultSet rs=ct.s.executeQuery(sq);
                	if(rs.next())
                	{
                		t11.setText(rs.getString("name"));
                		t1.setText(rs.getString("room_no"));
                		
                		String a=rs.getString("amount");
                		String b=rs.getString("deposit");
                		
                		int c=Integer.parseInt(a)-Integer.parseInt(b);
                		
                		String res=Integer.toString(c);
                		
                		t2.setText(res);
                	}
                	
                  }
                  catch(Exception er)
                  {
                	  er.printStackTrace();
                  }
                }
            });
		
		

		
		
                
               
                
               

		
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(80, 112, 86, 20);
		lblRoomNumber.setForeground(Color.WHITE);

		l1.add(lblRoomNumber);
		
		t1 = new JTextField();
                t1.setBounds(190, 112, 150, 20);
                t1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		l1.add(t1);
		
		JLabel Bal = new JLabel("Pending Bal:-");
		Bal.setBounds(80, 162, 88, 20);
		Bal.setForeground(Color.WHITE);

		l1.add(Bal);
		
		t2 = new JTextField();
                t2.setBounds(190, 162, 150, 20);
                t2.setFont(new Font("Trebuchet MS",Font.BOLD,16));

		l1.add(t2);
                
                
                
                
                
		
                
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
                Conn pc=new Conn();

				
				String aa=(String)c1.getSelectedItem();
				String bb=t11.getText();
				String cc=t1.getText();
				String dd=new Date().toString();
                String ins="insert into check_out values('"+aa+"','"+bb+"','"+cc+"','"+dd+"')";
            	try {
					pc.s.executeUpdate(ins);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}




				
				
				String a=(String)c1.getSelectedItem();
                String b=t1.getText();
                
                String del="delete from guest where id_no = '"+a+"'";
                
            	String up="update room set availability = 'Available',clean_status ='Dirty' where room_no = '"+b+"'";
				try
                {

                	pc.s.executeUpdate(del);
                	pc.s.executeUpdate(up);
                	
                	JDialog.setDefaultLookAndFeelDecorated(true);
                	JOptionPane.showMessageDialog(null, "Check Out Successful");
	    			new Reception().setVisible(true);
                                setVisible(false);

                	
                }
                catch(Exception ew)
                {
                	ew.printStackTrace();
                }
	    		
			}
		});
		btnCheckOut.setBounds(110, 220, 100, 25);
                btnCheckOut.setBackground(Color.BLACK);
                btnCheckOut.setForeground(Color.WHITE);
		l1.add(btnCheckOut);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(220, 220, 100, 25);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		l1.add(btnExit);
                
                
                getContentPane().setBackground(Color.WHITE);
	}

}