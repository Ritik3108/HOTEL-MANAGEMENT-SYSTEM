package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Loading extends JFrame implements Runnable{
	
	JPanel p;
	JLabel l2,l3,il1;
	JProgressBar pb;
	Thread th;
	JFrame fr;
	
	
	
	Loading()
	{
		super("Loading");
   		setSize(500,400);
		setLocationRelativeTo(null);
		setResizable(false);
	    
		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Loading.jpg"));
		Image im=i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(im);
		il1=new JLabel(i2);
		il1.setLayout(null);
		il1.setBounds(0,0,500,400);
		p.add(il1);
		
		l2=new JLabel("HOTEL MANAGEMENT SYSTEM");
		l2.setFont(new Font("serif",Font.BOLD,25));
		l2.setForeground(Color.CYAN);
		l2.setBounds(39,50,400,30);
		il1.add(l2);
		
		
		pb=new JProgressBar();
		pb.setStringPainted(true);
		pb.setBounds(90,200,270,30);
		il1.add(pb);
		
		
		l3=new JLabel("PLEASE WAIT....");
		l3.setFont(new Font("Tahoma",Font.BOLD,25));
		l3.setForeground(Color.BLACK);
		l3.setBounds(110,260,400,30);
		il1.add(l3);
		
		
		

		
		th=new Thread(this);
		th.start();
				
	}
	public void run()
	{
		try
		{
			for(int i=0;i<200;i++)
			{
				int m=pb.getMaximum();
				int v=pb.getValue();
				if(v<m)
				{
					pb.setValue(pb.getValue()+1);
				}
				else
				{
					i=201;
					this.setVisible(false);
					new Dashboard("").setVisible(true);

					
				}
				th.sleep(50);
			}
		}
		
		catch(Exception ee)
		{
			
		}
		
		
	}
	
	public static void main(String[] args)
	{
		new Loading().setVisible(true);
	}
	
}
