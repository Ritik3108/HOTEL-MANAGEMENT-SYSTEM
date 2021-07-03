package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SignUp extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3,l4,l5,il1,il2;
	JButton b1,b2;
	JTextField t1,t2,t3;
	JPasswordField pf;
	JComboBox c1;
	JPanel p,p1;
	
	SignUp()
	{
		
		super("Sign Up");
		setSize(500,500);
		setLocationRelativeTo(null);
      //  setUndecorated(true);


		
		p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setLayout(null);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/SignUp.jpg"));
		Image im=i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(im);
		il1=new JLabel(i2);
		il1.setLayout(null);
		il1.setBounds(0,0,500,500);
		p1.add(il1);
        
        		
		p=new JPanel();
		p.setForeground(new Color(39,127,30));
	   
	    p.setBounds(35,40,400,400);
	    p.setBackground(Color.WHITE);
        il1.add(p);
        p.setLayout(null);
        
        ImageIcon iw1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/SignUp.jpg"));
		Image im1=iw1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
		ImageIcon iw2=new ImageIcon(im1);
		il2=new JLabel(iw2);
		il2.setLayout(null);
		il2.setBounds(0,0,400,400);
		p.add(il2);
        
        l1=new JLabel("Username :");
        l1.setBounds(55,60,100,30);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        il2.add(l1);
        
        /*l2=new JLabel("Name :");
        l2.setBounds(55,110,100,30);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));

        p.add(l2);*/
        
        l3=new JLabel("Password :");
        l3.setBounds(55,110,100,30);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));

        il2.add(l3);
        
        l4=new JLabel("Security Question :");
        l4.setBounds(55,160,150,30);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));

        il2.add(l4);
        
        l5=new JLabel("Answer :");
        l5.setBounds(55,210,100,30);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));

        il2.add(l5);
        
        /*t1=new JTextField();
        t1.setBounds(200,64,150,20);
        t1.setFont(new Font("Tahoma",Font.BOLD,12));
        p.add(t1);*/
        
        t2=new JTextField();
        t2.setBounds(200,64,150,20);
        t2.setFont(new Font("Tahoma",Font.BOLD,12));

        il2.add(t2);
        
        pf=new JPasswordField();
        pf.setBounds(200,114,150,20);
        il2.add(pf);
        
        String arr[]= {"Your Nickname?","Your Childhood Hero?","Your Favorite Movie?","Your Wish to Become?"};
        c1=new JComboBox(arr);
        c1.setBounds(200,164,150,20);
        il2.add(c1);
        
        t3=new JTextField();
        t3.setBounds(200,214,150,20);
        t3.setFont(new Font("Tahoma",Font.BOLD,12));

        il2.add(t3);
        
        b1=new JButton("Create");
        b1.setBounds(70,270,120,35);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        il2.add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Back");
        b2.setBounds(200,270,120,35);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        il2.add(b2);
        b2.addActionListener(this);
        
        
	}
	
	public void actionPerformed(ActionEvent ec)
	{
		
		String a=t2.getText();
		//String b=t2.getText();
		String c=pf.getText();
		String d=(String)c1.getSelectedItem();
		String e=t3.getText();
		
		if(ec.getSource()==b1)
		{
			try
			{
				
				Conn cc = new Conn();
				String st="insert into signup values('"+a+"','"+c+"','"+d+"','"+e+"')";
				
				int i=cc.s.executeUpdate(st);
				if(i>0)
				{
					JOptionPane.showMessageDialog(null, "Account Created Successfully");
					this.setVisible(false);
					//new Loading().setVisible(true);
					new Dashboard(t2.getText().toUpperCase()).setVisible(true);
	
				}
				else 
				{
				   


				}
				
			//	JOptionPane.showMessageDialog(null, "Account Created Successfully");
				
				
			}
			catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null, "Error! Username already Exists");

							}
		}
		else if(ec.getSource()==b2)
		{
			this.setVisible(false);
			new Login().setVisible(true);
		}
		
	}

	public static void main(String[] args) {

		new SignUp().setVisible(true);
	}

}
