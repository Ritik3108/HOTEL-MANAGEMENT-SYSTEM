package mypack;

import java.awt.*;

import javax.swing.border.EmptyBorder;

import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.util.Date;

public class NewGuest extends JFrame {
	//Connection conn = null;
	//PreparedStatement pst = null;
	private JPanel p;
	private JTextField t1,t2,t3,t4,t5,t6;
        JComboBox c;
        JRadioButton r1,r2;
        Choice c1;
	
	public static void main(String[] args) {
		
					new NewGuest().setVisible(true);
				
			}


	public NewGuest(){
		super("ADD GUEST");
		
		setSize(475, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        
        
		p = new JPanel();
		setContentPane(p);
		p.setLayout(null);

                
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/fifth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(475, 550,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(0,0,475,550);
        add(l1);
		
		JLabel lblName = new JLabel("NEW CUSTOMER FORM");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		lblName.setForeground(Color.WHITE);
		l1.add(lblName);
                
        JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 76, 200, 14);
		lblId.setForeground(Color.WHITE);

		l1.add(lblId);
                
        c = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
		c.setBounds(271, 73, 150, 20);
		l1.add(c);
                
                JLabel l2 = new JLabel("ID Number :");
		l2.setBounds(35, 111, 200, 14);
		l2.setForeground(Color.WHITE);

		l1.add(l2);
                
                t1 = new JTextField();
		t1.setBounds(271, 111, 150, 20);
		t1.setFont(new Font("Trebuchet MS",Font.BOLD,17));
		l1.add(t1);
		t1.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 151, 200, 14);
		lblName_1.setForeground(Color.WHITE);

		l1.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);
		t2.setFont(new Font("Trebuchet MS",Font.PLAIN,17));
        t2.setForeground(Color.BLUE);


		l1.add(t2);
	//	t2.setColumns(10);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 191, 200, 14);
		lblGender.setForeground(Color.WHITE);

		l1.add(lblGender);
                
                r1 = new JRadioButton("Male");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(271, 191, 80, 16);
                l1.add(r1);
                
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(350, 191, 80, 16);
		l1.add(r2);
                
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 231, 200, 14);
		lblCountry.setForeground(Color.WHITE);

		l1.add(lblCountry);
		
		t3 = new JTextField();
		t3.setBounds(271, 231, 150, 20);
		t3.setFont(new Font("Trebuchet MS",Font.BOLD,17));

		l1.add(t3);
	//	t3.setColumns(10);
		
		JLabel lblReserveRoomNumber = new JLabel("Rooms Available :");
		lblReserveRoomNumber.setBounds(35, 274, 200, 14);
		lblReserveRoomNumber.setForeground(Color.WHITE);

		l1.add(lblReserveRoomNumber);
                
                c1 = new Choice();
                c1.setBounds(271, 274, 150, 20);
		        l1.add(c1);
		        
		        try
		        {
		        	Conn cr=new Conn();
		        	String sw="select * from room where availability = 'Available'";
		        	ResultSet rs=cr.s.executeQuery(sw);
		        	while(rs.next())
		        	{
		        	c1.add(rs.getString("room_no"));
		        	}
		        	
		        }
		        catch(Exception ef)
		        {
		        	ef.printStackTrace();
		        }
		
		JLabel lblCheckInStatus = new JLabel("Check Price :");
		lblCheckInStatus.setBounds(35, 316, 200, 14);
		lblCheckInStatus.setForeground(Color.WHITE);

		l1.add(lblCheckInStatus);
		
		t5 = new JTextField();
		t5.setBounds(271, 316, 150, 20);
		t5.setFont(new Font("Trebuchet MS",Font.PLAIN,17));
        t5.setForeground(Color.RED);


		l1.add(t5);
	//	t5.setColumns(10);
	
		ImageIcon i21=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/check.png"));
		Image im2=i21.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i22=new ImageIcon(im2);
		JLabel il1=new JLabel(i22);
		il1.setLayout(null);
		il1.setToolTipText("CLICK HERE TO CHECK PRICE");
		il1.setBounds(240,315,20,20);
		l1.add(il1);
		
		il1.addMouseListener(new MouseAdapter()
		{
	      public void mouseClicked(MouseEvent er)
	      {
	    	  
				Conn cc1=new Conn();
				String sq="select * from room where room_no='"+c1.getSelectedItem()+"'";
				try {
					ResultSet rs=cc1.s.executeQuery(sq);
					while(rs.next())
					{
					t5.setText(rs.getString("price"));}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			
			}
	      });
		
		
        
		
		JLabel lblDeposite = new JLabel("Deposit Amount :");
		lblDeposite.setBounds(35, 359, 200, 14);
		lblDeposite.setForeground(Color.WHITE);

		l1.add(lblDeposite);
		
		
		t6 = new JTextField();
		t6.setBounds(271, 359, 150, 20);
		t6.setFont(new Font("Trebuchet MS",Font.BOLD,17));

		l1.add(t6);
	//	t6.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent et)
			{
             Conn cc=new Conn();
             
             String a=(String)c.getSelectedItem();
             String b=t1.getText();
             String c=t2.getText();
             String d=null;
             if(r1.isSelected())
             {
            	 d="Male";
             }
             else if(r2.isSelected())
             {
            	 d="Female";
             }
             String e=t3.getText();
             String f=c1.getSelectedItem();
             String g=t5.getText();
             String h=t6.getText();
             String date=new Date().toString();



             try
             {
            	String sql="insert into guest values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+date+"')";
                String q2 = "update room set availability = 'Occupied' where room_no = '"+c1.getSelectedItem()+"'";

            	int i=cc.s.executeUpdate(sql);
            	int j=cc.s.executeUpdate(q2);

            	if(i>0 && j>0)
            	{
            		JOptionPane.showMessageDialog(null, "Guest Added Successfully");
	    			
            	
            	setVisible(false);
            	new Reception().setVisible(true);
            	}
            	else 
            	{
                	JOptionPane.showMessageDialog(null,"Error");

            	}
            	
             }
             catch(Exception er)
             {
            	 er.printStackTrace();
             }
			}
		});
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		l1.add(btnNewButton);
		
		JButton btnExit = new JButton("Back To Home");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            new Reception().setVisible(true);
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		l1.add(btnExit);
                
              //  getContentPane().setBackground(Color.WHITE);
	}
}