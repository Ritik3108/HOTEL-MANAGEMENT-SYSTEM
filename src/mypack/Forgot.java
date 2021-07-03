package mypack;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

//import com.toedter.calendar.JDateChooser;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Forgot extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3,l4,l5,il1,il2;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3,b4;
	JPanel p,p1;
	
	
	Forgot(String des)
	{
		super("Forgot Password");
		setSize(600,450);
		setLocationRelativeTo(null);
     //   setUndecorated(true);


		
		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Forgot.jpg"));
			Image im=i1.getImage().getScaledInstance(600, 450, Image.SCALE_DEFAULT);
			ImageIcon i2=new ImageIcon(im);
			il1=new JLabel(i2);
			il1.setLayout(null);
			il1.setBounds(0,0,600,450);
			p.add(il1);
		
		p1=new JPanel();
		
		p1.setBounds(20,40,525,350);
		p1.setLayout(null);
		il1.add(p1);
		
		ImageIcon iw1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Forgot.jpg"));
		Image im1=iw1.getImage().getScaledInstance(525, 350, Image.SCALE_DEFAULT);
		ImageIcon iw2=new ImageIcon(im1);
		il2=new JLabel(iw2);
		il2.setLayout(null);
		il2.setBounds(0,0,525,350);
		p1.add(il2);
		
		l1=new JLabel("Username :");
		l1.setBounds(40,30,100,30);
		l1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		il2.add(l1);
		
		/*l2=new JLabel("Name :");
		l2.setBounds(40,90,100,30);
		l2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l2);*/
		
		l3=new JLabel("Your Security Question :");
		l3.setBounds(40,90,190,30);
		l3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		il2.add(l3);
		
		l4=new JLabel("Answer :");
		l4.setBounds(40,150,120,30);
		l4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		il2.add(l4);
		
		l5=new JLabel("Password :");
		l5.setBounds(40,210,150,30);
		l5.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		il2.add(l5);
		
		t1=new JTextField(des);
		t1.setBounds(140,32,190,25);
		t1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		t1.setForeground(Color.BLUE);
		il2.add(t1);
		
//		
//		try
//		{
//			Conn cc = new Conn();
//			String sql="select * from signup";
//			ResultSet rs=cc.s.executeQuery(sql);
//			
//			while(rs.next())
//			{
//				t1.add(rs.getString("username"));
//			}
//		}
//		catch(Exception ee)
//		{
//			ee.printStackTrace();
//		}
		
		/*t2=new JTextField();
		t2.setBounds(140,92,190,25);
		t2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t2);*/
		
		t3=new JTextField();
		t3.setBounds(240,92,220,25);
		t3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		il2.add(t3);
		
		t4=new JTextField();
		t4.setBounds(140,152,190,25);
		t4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		il2.add(t4);
		
		
		t5=new JTextField();
		t5.setBounds(140,212,190,25);
		t5.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		il2.add(t5);
		
		
		b1=new JButton("Search");
		b1.setBounds(350,30,140,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		il2.add(b1);
		b1.addActionListener(this);
		
		
		b2=new JButton("Retrieve");
		b2.setBounds(350,150,160,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		il2.add(b2);
		b2.addActionListener(this);

		
		b3=new JButton("Back");
		b3.setBounds(330,270,160,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		il2.add(b3);
		b3.addActionListener(this);
		
		
		b4=new JButton("SignIn");
		b4.setBounds(70,270,160,30);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		il2.add(b4);
		b4.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ee)
	{
		Conn cc=new Conn();
		try
		{
			if(ee.getSource()==b1)
			{
				String sql="select * from signup where username = '"+t1.getText()+"'";
				ResultSet rs=cc.s.executeQuery(sql);
				
				while(rs.next())
				{
					t3.setText(rs.getString("sec_q"));
				}
				
			}
			else if(ee.getSource()==b2)
			{
				String se="select * from signup where sec_ans = '"+t4.getText()+"' and username = '"+t1.getText()+"'";
				ResultSet rs=cc.s.executeQuery(se);
				
				if(rs.next())
				{
					t5.setText(rs.getString("password"));
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Incorrect Answer!");

				}
			}
			else if(ee.getSource()==b3)
			{
				this.setVisible(false);
				new Login().setVisible(true);
			}
			else if(ee.getSource()==b4)
			{
				String srt="select * from signup where username = '"+t1.getText()+"'"
					                 	+ " and password = '"+t5.getText()+"'";
				
				ResultSet rs=cc.s.executeQuery(srt);
				
				if(rs.next())
				{
					this.setVisible(false);
					//new Loading().setVisible(true);	
					new Dashboard(t1.getText().toUpperCase()).setVisible(true);

				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Login");
				}
			}
		}
		catch(Exception er)
		{
			er.printStackTrace();
		}
	}
	
  public static void main(String[] args)
  {
	  new Forgot(" ").setVisible(true);
  }
}