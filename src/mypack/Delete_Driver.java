package mypack;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Delete_Driver extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3;
	JTextField t2,t3,t4,t5;
	Choice t1;
	JButton b1,b2,b3,b4;
	JPanel p,p1;
	
	
	Delete_Driver()
	{
		super("Delete_Driver");
		setSize(600,250);
		setLocationRelativeTo(null);
		setResizable(false);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		 ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/dele.jpg"));
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
		
		ImageIcon s1  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/dele.jpg"));
        Image s3 = s1.getImage().getScaledInstance(525, 150,Image.SCALE_DEFAULT);
        ImageIcon s2 = new ImageIcon(s3);
        JLabel q1 = new JLabel(s2);
        q1.setBounds(0,-0,525,150);
        p1.add(q1);
		
		
		
		l1=new JLabel("Driver ID");
		l1.setBounds(40,27,100,30);
		l1.setFont(new Font("Trebuchet MS",Font.BOLD,18));
		l1.setForeground(Color.WHITE);
		q1.add(l1);
		
		l2=new JLabel("Name :");
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
	
		
		t1=new Choice();
		t1.setBounds(140,27,190,25);
		t1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		q1.add(t1);
		
		
		try
		{
			Conn cc = new Conn();
			String sql="select * from driver";
			ResultSet rs=cc.s.executeQuery(sql);
			
			while(rs.next())
			{
				t1.add(rs.getString("id_no"));
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		t2=new JTextField();
		t2.setBounds(140,92,190,25);
		t2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t2);
		
		ImageIcon i21=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/check.png"));
		Image im2=i21.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i22=new ImageIcon(im2);
		JLabel il1=new JLabel(i22);
		il1.setLayout(null);
		il1.setToolTipText("CLICK HERE TO CHECK NAME");
		il1.setBounds(335,29,20,20);
		q1.add(il1);
		
		il1.addMouseListener(new MouseAdapter()
		{
	      public void mouseClicked(MouseEvent er)
	      {
	    	  
				Conn cc1=new Conn();
				String sq="select * from driver where id_no='"+t1.getSelectedItem()+"'";
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
				String sql="delete from driver where id_no = '"+t1.getSelectedItem()+"'";
						                                
				
				int i=cc.s.executeUpdate(sql);
				
			    if(i>0)
				{
					JOptionPane.showMessageDialog(null,"Driver Removed Successfully");
					this.setVisible(false);
					new Dashboard("").setVisible(true);
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
	  new Delete_Driver().setVisible(true);
  }
}