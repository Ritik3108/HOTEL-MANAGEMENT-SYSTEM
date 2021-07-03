package mypack;


import java.awt.*;

import javax.swing.border.EmptyBorder;

import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
public class ManagerInfo extends JFrame {
	private JPanel contentPane;
      
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerInfo frame = new ManagerInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ManagerInfo()  {
		super("Manager Info");
		 
		setSize(450, 460);
		setLocationRelativeTo(null);
 		setResizable(false);
     //   setUndecorated(true);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Manager.jpg"));
                Image i3 = i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel la1 = new JLabel(i2);
                la1.setBounds(0,0,450,450);
                add(la1);
		
		JLabel lblName = new JLabel("VIEW MANAGER DETAILS");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setForeground(Color.DARK_GRAY);
		lblName.setBounds(88, 5, 350, 53);
		la1.add(lblName);
		
		JLabel l9 = new JLabel();
		l9.setBounds(390, 5, 200, 14);
		l9.setFont(new Font("Trebuchet MS",Font.PLAIN|Font.ITALIC,17));
		l9.setForeground(Color.BLUE);
		la1.add(l9);
                
                JLabel lb3 = new JLabel("Name :-");
		lb3.setBounds(35, 70, 200, 14);
		la1.add(lb3);
                
                JLabel c1 = new JLabel();
		c1.setBounds(211, 70, 200, 14);
		c1.setFont(new Font("Trebuchet MS",Font.PLAIN|Font.ITALIC,19));
		c1.setForeground(Color.CYAN);

		la1.add(c1);
		
		ImageIcon i5  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/arrow.png"));
        Image i4 = i5.getImage().getScaledInstance(30, 25,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i4);
        JLabel l11 = new JLabel(i6);
        l11.setBounds(20,385,30,25);
        l11.setToolTipText("BACK TO RECEPTION");
        la1.add(l11);
        
        l11.addMouseListener(new MouseAdapter()
		{
	      public void mouseClicked(MouseEvent er)
	      {
	    	  setVisible(false);
	    	  new Reception().setVisible(true);
	      }
		});
        
                       
                
                JLabel lblId = new JLabel("Age :-");
		lblId.setBounds(35, 110, 200, 14);
		la1.add(lblId);
                
                JLabel l2 = new JLabel();
		l2.setBounds(211, 110, 200, 14);
		l2.setFont(new Font("Trebuchet MS",Font.PLAIN,19));
		l2.setForeground(Color.WHITE);
		la1.add(l2);
                
                JLabel lb2 = new JLabel("Gender :-");
		lb2.setBounds(35, 150, 200, 14);
		la1.add(lb2);
                
                JLabel l3 = new JLabel();
		l3.setBounds(211, 150, 200, 14);
		l3.setFont(new Font("Trebuchet MS",Font.PLAIN,19));
		l3.setForeground(Color.WHITE);
		la1.add(l3);
		
		JLabel lblName_1 = new JLabel("Job :-");
		lblName_1.setBounds(35, 190, 200, 14);
		la1.add(lblName_1);
		
		JLabel l4 = new JLabel();
		l4.setBounds(211, 190, 200, 14);
		l4.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,20));
		l4.setForeground(Color.BLACK);
		la1.add(l4);

                
		JLabel lblGender = new JLabel("Salary :-");
		lblGender.setBounds(35, 230, 200, 14);
		la1.add(lblGender);
                
                JLabel l5 = new JLabel();
		l5.setBounds(211, 230, 200, 14);
		l5.setFont(new Font("Trebuchet MS",Font.PLAIN,19));
		l5.setForeground(Color.WHITE);
		la1.add(l5);
                
		JLabel lblCountry = new JLabel("Phone :-");
		lblCountry.setBounds(35, 270, 200, 14);
		la1.add(lblCountry);
                
                JLabel l6 = new JLabel();
		l6.setBounds(211, 270, 200, 14);
		l6.setFont(new Font("Trebuchet MS",Font.PLAIN|Font.ITALIC,19));
		l6.setForeground(Color.RED);
		la1.add(l6);
		
		JLabel lblReserveRoomNumber = new JLabel("Aadhar :-");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		lblReserveRoomNumber.setForeground(Color.WHITE);

		la1.add(lblReserveRoomNumber);
		
		JLabel l7 = new JLabel();
		l7.setBounds(211, 310, 200, 14);
		l7.setFont(new Font("Trebuchet MS",Font.PLAIN,19));
		l7.setForeground(Color.WHITE);
		la1.add(l7);               

		
		JLabel gmail = new JLabel("Gmail :-");
		gmail.setBounds(35, 350, 200, 14);
		gmail.setForeground(Color.WHITE);

		la1.add(gmail);
		
		JLabel l8 = new JLabel();
		l8.setBounds(211, 350, 200, 25);
		l8.setFont(new Font("Trebuchet MS",Font.BOLD,19));
		l8.setForeground(Color.WHITE);
		la1.add(l8); 
		
		 try
		{
			Conn cy=new Conn();
			String sql="select * from manager where job = 'Manager'";
			ResultSet rs=cy.s.executeQuery(sql);
			while(rs.next())
			{
				c1.setText(rs.getString(1));
			 l2.setText(rs.getString(2));
         l3.setText(rs.getString(3));
         l4.setText(rs.getString(4));
         l5.setText(rs.getString(5));
          l6.setText(rs.getString(6));
          l7.setText(rs.getString(7));
          l8.setText(rs.getString(8));
          l9.setText(rs.getString(9));

          
			
			}
		}
		catch(Exception er)
		{
			er.printStackTrace();
		}
                
          		
		JButton btnExit = new JButton("CHANGE MANAGER");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rs=JOptionPane.showConfirmDialog(null, "Are you sure you want to Remove Current Manager?",
			             "Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	
	if(rs==JOptionPane.YES_OPTION)
	{
		Conn cc=new Conn();
		String sql="delete from manager where job = 'Manager'";
		try {
			cc.s.executeUpdate(sql);
            new AddManager().setVisible(true);
            setVisible(false);
		} catch (SQLException er) {
			// TODO Auto-generated catch block
			er.printStackTrace();
		}


	}
	
	else if(rs==JOptionPane.NO_OPTION)
	{
		
	}
			}
		}); 
		btnExit.setBounds(253, 380, 180, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));
                btnExit.setForeground(Color.WHITE);
                la1.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}