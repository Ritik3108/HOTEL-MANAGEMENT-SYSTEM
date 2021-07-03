package mypack;


//import com.toedter.calendar.JDateChooser;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Del_Acc extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3,b4;
	JPanel p,p1;
	
	
	Del_Acc()
	{
		super("Delete Account");
		setSize(600,250);
		setLocationRelativeTo(null);
		setResizable(false);
		
//		p=new JPanel();
//		p.setLayout(null);
//		p.setBackground(Color.WHITE);
//		add(p);
//		
		 ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Del_A.jpg"));
         Image i3 = i1.getImage().getScaledInstance(600, 250,Image.SCALE_DEFAULT);
         ImageIcon i2 = new ImageIcon(i3);
         JLabel l1 = new JLabel(i2);
         l1.setBounds(0,-0,600,250);
         add(l1);
         
         
		
		p1=new JPanel();
//		p1.setBorder(new TitledBorder(new LineBorder(new Color(34,89,134),2),
//				             "Delete_Room",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(110,218,128)));
		p1.setBounds(20,40,525,150);
		p1.setLayout(null);
		l1.add(p1);
		
		ImageIcon s1  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Del_A.jpg"));
        Image s3 = s1.getImage().getScaledInstance(525, 150,Image.SCALE_DEFAULT);
        ImageIcon s2 = new ImageIcon(s3);
        JLabel q1 = new JLabel(s2);
        q1.setBounds(0,-0,525,150);
        p1.add(q1);
		
		
		
		l1=new JLabel("Username");
		l1.setBounds(40,27,100,30);
		l1.setFont(new Font("Trebuchet MS",Font.BOLD,18));
		l1.setForeground(Color.WHITE);
		q1.add(l1);
		
		l2=new JLabel("Password");
		l2.setBounds(40,89,100,30);
		l2.setFont(new Font("Trebuchet MS",Font.BOLD,18));
		l2.setForeground(Color.WHITE);


		q1.add(l2);
		
		l3=new JLabel("Back");
		l3.setBounds(450,120,90,30);
		l3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		l3.setForeground(Color.WHITE);
		l3.setToolTipText("GO BACK TO HOME");


		
		q1.add(l3);
		
		ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/tenth.png"));
		Image im1=i11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i211=new ImageIcon(im1);
        l3.setIcon(i211);		
		
		l3.addMouseListener(new MouseAdapter()
		{
	       public void mouseClicked(MouseEvent et)
	       {
	    	   setVisible(false);
	    	  new Dashboard("").setVisible(true);
	       }
		});
	
		
		t1=new JTextField();
		t1.setBounds(140,27,190,25);
		t1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		t1.setForeground(Color.BLUE);
		q1.add(t1);
		
		
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
		
		t2=new JTextField();
		t2.setBounds(140,92,190,25);
		t2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t2);
		
//		ImageIcon i21=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Check.png"));
//		Image im2=i21.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
//		ImageIcon i22=new ImageIcon(im2);
//		JLabel il1=new JLabel(i22);
//		il1.setLayout(null);
//		il1.setToolTipText("CLICK HERE TO CHECK PASSWORD");
//		il1.setBounds(335,29,20,20);
//		q1.add(il1);
//		
//		il1.addMouseListener(new MouseAdapter()
//		{
//	      public void mouseClicked(MouseEvent er)
//	      {
//	    	  
//				Conn cc1=new Conn();
//				String sq="select * from signup where username='"+t1.getSelectedItem()+"'";
//				try {
//					ResultSet rs=cc1.s.executeQuery(sq);
//					while(rs.next())
//					{
//					t2.setText(rs.getString("password"));}
//				} catch (SQLException e) {
//					
//					e.printStackTrace();
//				}
//				
//			
//			}
//	      });
	
		
		
		b1=new JButton("Delete");
		b1.setBounds(350,57,140,30);
//		b1.setBackground(Color.BLACK);
//		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		q1.add(b1);
		b1.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ee)
	{
		Conn cc=new Conn();
		try
		{
			if(ee.getSource()==b1)
			{
				String sql="delete from signup where username = '"+t1.getText()+"' and password = '"+t2.getText()+"'";
						                                
				
				int i=cc.s.executeUpdate(sql);
				
			    if(i>0)
				{
					JOptionPane.showMessageDialog(null,"Account Deleted Successfully");
					this.setVisible(false);
					new Login().setVisible(true);
				}
			    else
			    {
					JOptionPane.showMessageDialog(null,"Failed!");

			    }
			}
			
		}
		catch(Exception ev)
		{
			ev.printStackTrace();
		}
	}
	
  public static void main(String[] args)
  {
	  new Del_Acc().setVisible(true);
  }
}