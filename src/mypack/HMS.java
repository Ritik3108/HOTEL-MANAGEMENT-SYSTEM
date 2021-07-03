package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HMS extends JFrame implements Runnable,ActionListener {
	
	JPanel p;
	JLabel l1,l2;
	Thread th;
	JButton b;
	
	public void run()
	{
		while(true)
		{
			l2.setVisible(false);
		try
		{
			th.sleep(500);
		}
		catch(Exception ee)
		{
			
		}
		l2.setVisible(true);
		try
		{
			th.sleep(500);
		}
		catch(Exception ee)
		{
			
		}		
	}}
	
	HMS()
	{
		super("Hotel Management System");
		setBounds(0,40,1380,650);
		setResizable(false);
    //    setUndecorated(true);

		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/first.jpg"));
		Image im=i1.getImage().getScaledInstance(1400, 650, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(im);
		l1=new JLabel(i2);
		l1.setLayout(null);
		l1.setBounds(0,0,1350,650);
		p.add(l1);
		
		l2=new JLabel("HOTEL MANAGEMENT SYSTEM");
		l2.setFont(new Font("serif",Font.PLAIN,70));
		l2.setForeground(Color.RED);
		l2.setBounds(155,100,1300,70);
		l1.add(l2);
		
		b=new JButton("CLICK HERE TO CONTINUE");
		b.setBounds(530,300,300,40);
		b.setFont(new Font("Trebuchet MS",Font.BOLD,17));
		b.setBackground(Color.black);
		b.setForeground(Color.WHITE);
		l1.add(b);
		b.addActionListener(this);
		
		
		th=new Thread(this);
		th.start();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Login().setVisible(true);
	}
			

	public static void main(String[] args) {

		new HMS().setVisible(true);
	}

}
