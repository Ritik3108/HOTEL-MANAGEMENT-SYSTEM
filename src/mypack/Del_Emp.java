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

public class Del_Emp extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3;
	JTextField t2,t3,t4,t5;
	Choice t1;
	JButton b1,b2,b3,b4;
	JPanel p,p1;
	
	
	Del_Emp()
	{
		super("Delete Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(600,250);
		setLocationRelativeTo(null);
		setResizable(false);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		 ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/del.jpg"));
         Image im1 = i1.getImage().getScaledInstance(600, 250,Image.SCALE_DEFAULT);
         ImageIcon i2 = new ImageIcon(im1);
         JLabel l4 = new JLabel(i2);
         l4.setBounds(0,0,600,250);
         p.add(l4);
         
 		p1=new JPanel();
//		p1.setBorder(new TitledBorder(new LineBorder(new Color(34,89,134),2),
//				             "Delete_Room",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(110,218,128)));
		p1.setBounds(20,40,525,150);
		p1.setLayout(null);
		l4.add(p1);
         
		
		ImageIcon i3  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/del.jpg"));
        Image im2 = i3.getImage().getScaledInstance(525, 150,Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(im2);
        JLabel l5 = new JLabel(i4);
        l5.setBounds(0,0,525,150);
        p1.add(l5);
		
		
		
		l1=new JLabel("EMP ID");
		l1.setBounds(40,27,100,30);
		l1.setFont(new Font("Trebuchet MS",Font.BOLD,18));
		l1.setForeground(Color.WHITE);
		l5.add(l1);
		
		t1=new Choice();
		t1.setBounds(140,27,190,25);
		t1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		l5.add(t1);
		
		
		try
		{
			Conn cc = new Conn();
			String sql="select * from employee";
			ResultSet rs=cc.s.executeQuery(sql);
			
			while(rs.next())
			{
				t1.add(rs.getString("emp_id"));
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		
		l2=new JLabel("Name :");
		l2.setBounds(40,89,100,30);
		l2.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		l2.setForeground(Color.WHITE);

		l5.add(l2);
		
		t2=new JTextField();
		t2.setBounds(140,92,190,25);
		t2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		l5.add(t2);
		
		l3=new JLabel("Back");
		l3.setBounds(450,120,90,30);
		l3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		l3.setForeground(Color.WHITE);
		l3.setToolTipText("GO BACK TO HOME");


		l5.add(l3);
		
		ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/tenth.png"));
		Image im3=i5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i6=new ImageIcon(im3);
        l3.setIcon(i6);		
		
		l3.addMouseListener(new MouseAdapter()
		{
	       public void mouseClicked(MouseEvent et)
	       {
	    	   setVisible(false);
	    	  new Dashboard("").setVisible(true);
	       }
		});
	
		
	
		
		
		ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/check.png"));
		Image im4=i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i8=new ImageIcon(im4);
		JLabel l6=new JLabel(i8);
		l6.setLayout(null);
		l6.setToolTipText("CLICK HERE TO CHECK NAME");
		l6.setBounds(335,29,20,20);
		l5.add(l6);
		
		l6.addMouseListener(new MouseAdapter()
		{
	      public void mouseClicked(MouseEvent er)
	      {
	    	  
				Conn cc1=new Conn();
				String sq="select * from employee where emp_id='"+t1.getSelectedItem()+"'";
				try {
					ResultSet rs=cc1.s.executeQuery(sq);
					while(rs.next())
					{
					t2.setText(rs.getString("name"));}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			
			}
	      });
	
		
		
		b1=new JButton("Remove");
		b1.setBounds(350,57,140,30);
//		b1.setBackground(Color.BLACK);
//		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		l5.add(b1);
		b1.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ee)
	{
		Conn cc=new Conn();
		try
		{
			if(ee.getSource()==b1)
			{
				String sql="delete from employee where emp_id = '"+t1.getSelectedItem()+"'";
						                                
				
				int i=cc.s.executeUpdate(sql);
				
			    if(i>0)
				{
					JOptionPane.showMessageDialog(null,"Employee Removed Successfully");
					this.setVisible(false);
					new Dashboard("").setVisible(true);
				}
			    else
			    {
			    }
			}
			
		}
		catch(Exception ev)
		{
			JOptionPane.showMessageDialog(null,"Failed!");
		}
	}
	
  public static void main(String[] args)
  {
	  new Del_Emp().setVisible(true);
  }
}