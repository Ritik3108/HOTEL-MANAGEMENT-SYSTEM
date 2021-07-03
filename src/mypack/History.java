package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class History extends JFrame {
	
	JPanel p,p1,p2;
	JTable t,t1;
	JLabel b,l1,l2;
	
	public void issueBook()
	{
		try
		{
		Conn cc=new Conn();
		String sql="select * from check_out";
		ResultSet rs=cc.s.executeQuery(sql);
		t.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception er)
		{
			er.printStackTrace();
		}
	}
	
	
	
	public void ReturnBook()
	{
		try
		{
		Conn cc=new Conn();
		String sql="select * from check_out";
		ResultSet rs=cc.s.executeQuery(sql);
		t1.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception er)
		{
			er.printStackTrace();
		}
	}
	
	History()
	{
		super("History");
		setSize(1000,430);
		setLocationRelativeTo(null);
		setResizable(false);
      //  setUndecorated(true);

		
		p=new JPanel();
		p.setLayout(null);
		add(p);
		
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/History.jpg"));
			Image im=i1.getImage().getScaledInstance(1000, 430, Image.SCALE_DEFAULT);
			ImageIcon i21=new ImageIcon(im);
			JLabel il1=new JLabel(i21);
			il1.setLayout(null);
			il1.setBounds(0,0,1000,430);
			p.add(il1);
			
			
		
		p1=new JPanel();
		p1.setBorder(new TitledBorder(new LineBorder(new Color(20,30,90),2),
				         "All Check-Out Details",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(32,128,116)));
		p1.setBounds(10,10,960,320);
		p1.setLayout(null);
		p1.setBackground(Color.WHITE);
	    il1.add(p1);
	    
	    ImageIcon w1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/History.jpg"));
		Image wm=w1.getImage().getScaledInstance(960, 320, Image.SCALE_DEFAULT);
		ImageIcon w21=new ImageIcon(wm);
		JLabel wl1=new JLabel(w21);
		wl1.setLayout(null);
		wl1.setBounds(0,0,960,355);
		p1.add(wl1);
	    
	   
	    
//	    p2=new JPanel();
//		p2.setBorder(new TitledBorder(new LineBorder(new Color(20,30,90),2),
//				 "Return-Book Details",TitledBorder.RIGHT,TitledBorder.TOP,null,new Color(82,18,116)));
//		p2.setBounds(10,370,960,270);
//		p2.setLayout(null);
//		p2.setBackground(Color.WHITE);
//
//	    p.add(p2);
	    
	    l1=new JLabel("Delete History >");
		l1.setBounds(390,285,150,30);
		l1.setFont(new Font("Trebuchet MS",Font.BOLD,18));
		l1.setForeground(Color.BLACK);
		wl1.add(l1);
		
		l1.addMouseListener(new MouseAdapter()
		{
	      public void mouseClicked(MouseEvent er)
	      {
	    	  try
	    	  {
	    		  Conn ccs=new Conn();
	    		  String sql="delete from check_out";
	    		  int i=ccs.s.executeUpdate(sql);
	    		  
	    		  if(i>0)
	    		  {
	    			  JOptionPane.showMessageDialog(null,"History Deleted Successfully");
	    		  }
	    		  
	    		  setVisible(false);
	    		  new Reception().setVisible(true);
	    		 
	    	  }
	    	  catch(Exception ee)
	    	  {
	    		  ee.printStackTrace();
	    	  }
	      }
		});
		
		
//		l2=new JLabel("Delete History >");
//		l2.setBounds(380,255,150,30);
//		l2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
//		p1.add(l2);
//		
//		l2.addMouseListener(new MouseAdapter()
//		{
//	      public void mouseClicked(MouseEvent er)
//	      {
//	    	  try
//	    	  {
//	    		  Conn ccr=new Conn();
//	    		  String sql="delete from issuebook";
//	    		  int i=ccr.s.executeUpdate(sql);
//	    		  
//	    		  if(i>0)
//	    		  {
//	    			  JOptionPane.showMessageDialog(null,"History Deleted Successfully");
//	    		  }
//	    		  
//	    		  setVisible(false);
//	    		  new Reception().setVisible(true);
//	    		 
//	    	  }
//	    	  catch(Exception ee)
//	    	  {
//	    		  ee.printStackTrace();
//	    	  }
//	      }
		//});
	    
	    
	    b=new JLabel("Back");
	    b.setBounds(870,350,90,30);
	    b.setFont(new Font("Trebuchet MS",Font.BOLD | Font.ITALIC,20));
	    b.setToolTipText("GO BACK TO RECEPTION");
	    il1.add(b);
	    
	    ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/tenth.png"));
	    Image i=i11.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
	    ImageIcon i2=new ImageIcon(i);
	    b.setIcon(i2);
	    
	    b.addMouseListener(new MouseAdapter()
	    		{
	    	       public void mouseClicked(MouseEvent ev)
	    	       {
	    	    	   setVisible(false);
	    	    	   new Reception().setVisible(true);
	    	       }
	    		});
	    
	    
	    JScrollPane sp=new JScrollPane();
	    sp.setBounds(8,17,940,272);
	    sp.setBackground(Color.WHITE);
	    wl1.add(sp);
	    
	    t=new JTable();
	    sp.setViewportView(t);
	    issueBook();
	    
	    
	    
//	    JScrollPane sp1=new JScrollPane();
//	    sp1.setBounds(8,17,940,222);
//	    sp1.setBackground(Color.WHITE);
//	    p2.add(sp1);
	    
//	    t1=new JTable();
//	    sp1.setViewportView(t1);
//	    ReturnBook();
	}

	public static void main(String[] args) {

		new History().setVisible(true);
	}

}
