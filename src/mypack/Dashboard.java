package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
	
	JPanel p;
	JMenuBar mb;
	JLabel l1;
	JMenu m1,m2,m3,m4,m5,m6;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12,mi13,mi14,mi15;
	JLabel l2;
	
	
	

	
	Dashboard(String res)
	{
		super("Hotel Management System");
		setBounds(-5,-1,1500,730);
		setResizable(false);
      //  setUndecorated(true);

		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/third.jpg"));
		Image im=i1.getImage().getScaledInstance(1400, 690, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(im);
		l1=new JLabel(i2);
		l1.setLayout(null);
		l1.setBounds(0,-5,1400,690);
		p.add(l1);
		
		mb=new JMenuBar();
        setJMenuBar(mb);	
        
        m1=new JMenu("Management");
        m1.setFont(new Font("serif",Font.PLAIN,16));
        m1.setForeground(Color.BLACK);
        mb.add(m1);
        
        m2=new JMenu("Add");
        m2.setFont(new Font("serif",Font.PLAIN,16));
        m2.setForeground(Color.BLUE);
        mb.add(m2);
        
        m6=new JMenu("Delete");
        m6.setFont(new Font("serif",Font.PLAIN,16));
        m6.setForeground(Color.RED);
        mb.add(m6);
        
        m5=new JMenu("Utility");
        m5.setFont(new Font("serif",Font.PLAIN,16));
        m5.setForeground(Color.BLUE);
        mb.add(m5);
        
               
        m4=new JMenu("Logout");
        m4.setFont(new Font("serif",Font.PLAIN,16));
        m4.setForeground(Color.CYAN);
        mb.add(m4);
        
        
        m3=new JMenu("About Us");
        m3.setFont(new Font("serif",Font.PLAIN,16));
        m3.setForeground(Color.RED);
        mb.add(m3);
        
        mi1=new JMenuItem("Reception");
        mi1.setFont(new Font("serif",Font.PLAIN,16));
        mi1.setForeground(Color.DARK_GRAY);
        mi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));

        m1.add(mi1);
        mi1.addActionListener(this);
        
        mi2=new JMenuItem("Add Manager");
        mi2.setFont(new Font("serif",Font.PLAIN,16));
        mi2.setForeground(Color.BLUE);
        mi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));

        m1.add(mi2);
        mi2.addActionListener(this);

        
          
        mi3=new JMenuItem("Add Employee");
        mi3.setFont(new Font("serif",Font.PLAIN,16));
        mi3.setForeground(Color.BLACK);
        mi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));

        m2.add(mi3);
        mi3.addActionListener(this);

        
        mi4=new JMenuItem("Add Rooms");
        mi4.setFont(new Font("serif",Font.PLAIN,16));
        mi4.setForeground(Color.RED);
        mi4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));

        m2.add(mi4);
        mi4.addActionListener(this);

        
        mi5=new JMenuItem("Add Drivers");
        mi5.setFont(new Font("serif",Font.PLAIN,16));
        mi5.setForeground(Color.BLUE);
        mi5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));

        m2.add(mi5);
        mi5.addActionListener(this);
        
        
        
        mi6=new JMenuItem("About US");
        mi6.setFont(new Font("serif",Font.PLAIN,16));
        mi6.setForeground(Color.BLUE);
        mi6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));

        m3.add(mi6);
        mi6.addActionListener(this);
        
        
        
        mi7=new JMenuItem("Logout");
        mi7.setFont(new Font("serif",Font.PLAIN,16));
        mi7.setForeground(Color.BLUE);
        mi7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));

        m4.add(mi7);
        mi7.addActionListener(this);
        
        mi8=new JMenuItem("Exit");
        mi8.setFont(new Font("serif",Font.PLAIN,16));
        mi8.setForeground(Color.BLACK);
        mi8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));

        m4.add(mi8);
        mi8.addActionListener(this);
        
        mi9=new JMenuItem("DELETE ACCOUNT");
        mi9.setFont(new Font("serif",Font.PLAIN,16));
        mi9.setForeground(Color.RED);
        mi9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));

        m4.add(mi9);
        mi9.addActionListener(this);
        
        
        
        mi10=new JMenuItem("Notepad");
        mi10.setFont(new Font("serif",Font.PLAIN,16));
        mi10.setForeground(Color.BLUE);
        mi10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        
        m5.add(mi10);
        mi10.addActionListener(this);
        
        mi11=new JMenuItem("Calculator");
        mi11.setFont(new Font("serif",Font.PLAIN,16));
        mi11.setForeground(Color.RED);
        mi11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        
        m5.add(mi11);
        mi11.addActionListener(this);
        
        mi12=new JMenuItem("Web Browser");
        mi12.setFont(new Font("serif",Font.PLAIN,16));
        mi12.setForeground(Color.BLACK);
        mi12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        
        m5.add(mi12);
        mi12.addActionListener(this);
        
        
        
        mi13=new JMenuItem("Delete Room");
        mi13.setFont(new Font("serif",Font.PLAIN,16));
        mi13.setForeground(Color.BLUE);
        mi13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));

        m6.add(mi13);
        mi13.addActionListener(this);
        
        mi14=new JMenuItem("Remove Driver");
        mi14.setFont(new Font("serif",Font.PLAIN,16));
        mi14.setForeground(Color.RED);
        mi14.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));

        m6.add(mi14);
        mi14.addActionListener(this);
        
        mi15=new JMenuItem("Remove Employee");
        mi15.setFont(new Font("serif",Font.PLAIN,16));
        mi15.setForeground(Color.BLACK);
        mi15.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));

        m6.add(mi15);
        mi15.addActionListener(this);
        
        
           
        
        l2=new JLabel("WELCOME !");
		l2.setFont(new Font("serif",Font.PLAIN,70));
		l2.setForeground(new Color(128,18,28));
		l2.setBounds(500,300,400,70);
		l1.add(l2);
		
		JLabel l12=new JLabel(res);
		l12.setFont(new Font("serif",Font.PLAIN,70));
		l12.setForeground(Color.BLUE);
		if(res.length()<=5)
		{
		l12.setBounds(600,380,600,80);}
		
		else if(res.length()>5 & res.length()<=11)
		{
		l12.setBounds(495,380,600,80);}
		
		else if(res.length()>11 & res.length()<=12)
		{
		l12.setBounds(475,380,600,80);}
		
		else if(res.length()>12 & res.length()<=21)
		{
		l12.setBounds(425,380,900,80);}
		l1.add(l12);	
		
		
		
		
		
		 
		
		 
		
	}
	
			
	
	public void actionPerformed(ActionEvent ee)
	{
		
		if(ee.getSource()==mi1) 
		{
			this.setVisible(false);
			new Reception().setVisible(true);
		}
		else if(ee.getSource()==mi2) 
		{
			this.setVisible(false);
			new AddManager().setVisible(true);
		}
		
		else if(ee.getSource()==mi3) 
		{
			this.setVisible(false);

			new AddEmployee().setVisible(true);
		}
		
		else if(ee.getSource()==mi4) 
		{
			this.setVisible(false);

			new AddRooms().setVisible(true);
		}
		else if(ee.getSource()==mi5) 
		{
			this.setVisible(false);

			new AddDrivers().setVisible(true);
		}
		
		else if(ee.getSource()==mi6) 
		{
			this.setVisible(false);

			new AboutUs().setVisible(true);
		}
		
		else if(ee.getSource()==mi7) 
		{
			JDialog.setDefaultLookAndFeelDecorated(true);
			int rs=JOptionPane.showConfirmDialog(null, "Do You Confirm?",
					             "Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			if(rs==JOptionPane.YES_OPTION)
			{
				Conn cc=new Conn();
				String sql="delete from login";
				try {
					cc.s.executeUpdate(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.setVisible(false);
				new Login().setVisible(true);
			}
			
			else if(rs==JOptionPane.NO_OPTION)
			{
				
			}
			
		}
		else if(ee.getSource()==mi8) 
		{
			JDialog.setDefaultLookAndFeelDecorated(true);
			int rs=JOptionPane.showConfirmDialog(null, "Do You Confirm?",
					             "Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			if(rs==JOptionPane.YES_OPTION)
			{
				Conn cc=new Conn();
				String sql="delete from login";
				try {
					cc.s.executeUpdate(sql);
					System.exit(0);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
			
			else if(rs==JOptionPane.NO_OPTION)
			{
				
			}
			
		}
		else if(ee.getSource()==mi9) 
		{
			setVisible(false);
			new Del_Acc().setVisible(true); 
			
		}
		
		else if(ee.getSource()==mi10)
		{
			try
			{
				Runtime.getRuntime().exec("notepad.exe");
			}
			catch(Exception ea) {
			}
			
		}
		else if(ee.getSource()==mi11) {
			try
		{
			Runtime.getRuntime().exec("calc.exe");
		}
		catch(Exception ea) {
		}
		}			
		else if(ee.getSource()==mi12)
		{
			try
			{
				Runtime.getRuntime().exec("\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\"");
			}
			catch(Exception ea) {
			}
		}
		
		else if(ee.getSource()==mi13) 
		{
			this.setVisible(false);

			new Delete_Room().setVisible(true);
		}
		else if(ee.getSource()==mi14) 
		{
			this.setVisible(false);

			new Delete_Driver().setVisible(true);
		}
		else if(ee.getSource()==mi15) 
		{
			this.setVisible(false);

			new Del_Emp().setVisible(true);
		}
	}
	public static void main(String[] args) {

		new Dashboard("1").setVisible(true);
	}

}
