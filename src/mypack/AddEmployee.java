package mypack;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

import javax.swing.*;
import java.util.Date;


public class AddEmployee extends JFrame{ //Third Frame

    
	JTextField t1,t2,t3,t4,t5,t6,t7;
        JComboBox c1;
        JRadioButton rd,rd1;
        
        public void random()
    	{
    		Random rd=new Random();
    		t7.setText("" + rd.nextInt(10000+1));
    	//	t3.setText(rd.nextInt(1000000000+1)+"1234");
    	}

        public AddEmployee(){
        	super("ADD EMPLOYEE");
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD EMPLOYEE");
            setSize(860,570);
            setLocationRelativeTo(null);
    		setResizable(false);
            //setUndecorated(true);

		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            getContentPane().setLayout(null);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Employee.jpg"));
            Image i3 = i1.getImage().getScaledInstance(860, 570,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(0,0,860,570);
            add(image);
            
//            ImageIcon i5  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/arrow.png"));
//            Image i4 = i5.getImage().getScaledInstance(30, 25,Image.SCALE_DEFAULT);
//            ImageIcon i6 = new ImageIcon(i4);
//            JLabel l11 = new JLabel(i6);
//            l11.setBounds(20,10,30,25);
//            image.add(l11);
//            
//            l11.addMouseListener(new MouseAdapter()
//    		{
//    	      public void mouseClicked(MouseEvent er)
//    	      {
//    	    	  setVisible(false);
//    	    	  new Dashboard("").setVisible(true);
//    	      }
//    		});
			
            JLabel Passportno = new JLabel("NAME");
            Passportno.setFont(new Font("Serif", Font.PLAIN, 17));
            Passportno.setForeground(Color.WHITE);
            Passportno.setBounds(260, 30, 150, 27);
            image.add(Passportno);
            
            t1 = new JTextField();
            t1.setBounds(400, 30, 150, 27);
            t1.setFont(new Font("Trebuchet MS",Font.BOLD|Font.PLAIN,16));
            t1.setForeground(Color.BLUE);
            image.add(t1);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(230, 480, 120, 30);
            Next.setForeground(Color.WHITE);

            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            image.add(Next);
            
            JButton b2 = new JButton("BACK");
            b2.setBounds(430, 480, 120, 30);
            b2.setForeground(Color.WHITE);

            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE);
            image.add(b2);
            b2.addMouseListener(new MouseAdapter()
    		{
    	      public void mouseClicked(MouseEvent er)
    	      {
    	    	  setVisible(false);
    	    	  new Dashboard("").setVisible(true);
    	      }
    		});
			
            JLabel Pnrno = new JLabel("AGE");
            Pnrno.setFont(new Font("Serif", Font.PLAIN, 17));
            Pnrno.setForeground(Color.WHITE);

            Pnrno.setBounds(260, 80, 150, 27);
            image.add(Pnrno);
			
            t2 = new JTextField();
            t2.setBounds(400, 80, 150, 27);
            t2.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));

            image.add(t2);
            
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Serif", Font.PLAIN, 17));
            Gender.setForeground(Color.WHITE);

            Gender.setBounds(260, 120, 150, 27);
            image.add(Gender);
		
            rd = new JRadioButton("MALE");
            rd.setBackground(Color.WHITE);
            rd.setBounds(400, 120, 70, 27);
            image.add(rd);
	
            rd1 = new JRadioButton("FEMALE");
            rd1.setBackground(Color.WHITE);
            rd1.setBounds(480, 120, 70, 27);
            image.add(rd1);
            
            
            JLabel Address = new JLabel("JOB");
            Address.setFont(new Font("Serif", Font.PLAIN, 17));
            Address.setBounds(260, 170, 150, 27);
            Address.setForeground(Color.WHITE);

            image.add(Address);
            
            String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Accountant","Chef"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE);
            c1.setBounds(400,170,150,30);
            image.add(c1);
            		
            JLabel Nationality = new JLabel("SALARY");
            Nationality.setFont(new Font("Serif", Font.PLAIN, 17));
            Nationality.setBounds(260, 220, 150, 27);
            Nationality.setForeground(Color.WHITE);


            image.add(Nationality);
			
            t3 = new JTextField();
            t3.setBounds(400, 220, 150, 27);
            t3.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));
            t3.setForeground(Color.RED);


            image.add(t3);
	
            JLabel Name = new JLabel("PHONE");
            Name.setFont(new Font("Serif", Font.PLAIN, 17));
            Name.setForeground(Color.WHITE);

            Name.setBounds(260, 270, 150, 27);
            image.add(Name);
	
            t4 = new JTextField();
            t4.setBounds(400, 270, 150, 27);
            t4.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));

            image.add(t4);
	
            JLabel Phno = new JLabel("AADHAR");
            Phno.setFont(new Font("Serif", Font.PLAIN, 17));
            Phno.setForeground(Color.WHITE);

            Phno.setBounds(260, 320, 150, 27);
            image.add(Phno);
			
            t5 = new JTextField();
            t5.setBounds(400, 320, 150, 27);
            t5.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));

            image.add(t5);
	
            
            JLabel email = new JLabel("EMAIL");
            email.setFont(new Font("Serif", Font.PLAIN, 17));
            email.setForeground(Color.WHITE);

            email.setBounds(260, 370, 150, 27);
            image.add(email);
			
            t6 = new JTextField();
            t6.setBounds(400, 370, 150, 27);
            t6.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));

            image.add(t6);
            
            JLabel id = new JLabel("ID No.");
            id.setFont(new Font("Serif", Font.PLAIN, 17));
            id.setForeground(Color.WHITE);

            id.setBounds(260, 420, 150, 27);
            image.add(id);
			
            t7 = new JTextField();
            t7.setBounds(400, 420, 150, 27);
            t7.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));

            image.add(t7);
            random();
	
            setVisible(true);
	
//            JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
//            AddPassengers.setForeground(Color.BLUE);
//            AddPassengers.setFont(new Font("Serif", Font.PLAIN, 31));
//            AddPassengers.setBounds(450, 24, 442, 35);
//            image.add(AddPassengers);
			
     
            

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                  Conn cc=new Conn();
                  
                  String a=t1.getText();
                  String b=t2.getText();
                  String c=null;
                  if(rd.isSelected())
                  {
                	  c="Male";
                  }
                  else if(rd1.isSelected())
                  {
                	  c="Female";
                  }
                  String d=(String)c1.getSelectedItem();
                  String e=t3.getText();
                  String f=t4.getText();
                  String g=t5.getText();
                  String h=t6.getText();
                  String lm=t7.getText();
                  String date=new Date().toString();

                  


                  try
                  {
                	
                	 String sql="insert into employee values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+lm+"','"+date+"')";
                	int i= cc.s.executeUpdate(sql);
                	if(i>0)
                	{
                		JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                   	 setVisible(false);
                   	 new Dashboard("").setVisible(true);
                	}
                	else
                	{
                		
                	}
                	 
                  }
                  catch(Exception er)
                  {
              		JOptionPane.showMessageDialog(null, "Error! Emp_id already Exists");

                  }
		}
            });
			
            setLocationRelativeTo(null);
    		setResizable(false);
			
	}
        
    public static void main(String[] args){
        new AddEmployee().setVisible(true);;
    }   
}