package mypack;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddManager extends JFrame{ //Third Frame

    
	JTextField t1,t2,t3,t4,t5,t6,c1,t7;
        JRadioButton rd,rd1;

        public AddManager(){
        	super("ADD Manager");
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
           // setTitle("ADD EMPLOYEE");
            setSize(400,590);
            setLocationRelativeTo(null);
    		setResizable(false);
          //  setUndecorated(true);

			
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            getContentPane().setLayout(null);
            
            ImageIcon iw1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Manage.jpg"));
    		Image im1=iw1.getImage().getScaledInstance(400, 590, Image.SCALE_DEFAULT);
    		ImageIcon iw2=new ImageIcon(im1);
    		JLabel il2=new JLabel(iw2);
    		il2.setLayout(null);
    		il2.setBounds(0,0,400,590);
    		//il2.setToolTipText("LOAD");
    		add(il2);
            
//            ImageIcon i5  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Tenth.png"));
//            Image i4 = i5.getImage().getScaledInstance(30, 25,Image.SCALE_DEFAULT);
//            ImageIcon i6 = new ImageIcon(i4);
//            JLabel l11 = new JLabel(i6);
//            l11.setBounds(5,10,30,25);
//            il2.add(l11);
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
            Passportno.setBounds(60, 30, 150, 27);
            il2.add(Passportno);
            
            t1 = new JTextField();
            t1.setBounds(200, 30, 150, 27);
            t1.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));
            t1.setForeground(Color.GREEN);

            il2.add(t1);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(50, 480, 120, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            il2.add(Next);
            
            JButton Info = new JButton("BACK");
            Info.setBounds(200, 480, 120, 30);
            Info.setBackground(Color.BLACK);
            Info.setForeground(Color.WHITE);
            il2.add(Info);
            
            Info.addMouseListener(new MouseAdapter()
    		{
    	      public void mouseClicked(MouseEvent er)
    	      {
    	    	  setVisible(false);
    	    	  new Dashboard("").setVisible(true);
    	      }
    		});
			
            JLabel Pnrno = new JLabel("AGE");
            Pnrno.setFont(new Font("Serif", Font.PLAIN, 17));
            Pnrno.setBounds(60, 80, 150, 27);
            il2.add(Pnrno);
			
            t2 = new JTextField();
            t2.setBounds(200, 80, 150, 27);
            t2.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));
      //      t2.setEditable(false);

            il2.add(t2);
            
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Serif", Font.PLAIN, 17));
            Gender.setBounds(60, 120, 150, 27);
            il2.add(Gender);
		
            rd = new JRadioButton("MALE");
            rd.setBackground(Color.WHITE);
            rd.setBounds(200, 120, 70, 27);
            il2.add(rd);
	
            rd1 = new JRadioButton("FEMALE");
            rd1.setBackground(Color.WHITE);
            rd1.setBounds(280, 120, 70, 27);
            il2.add(rd1);
            
            
            JLabel Address = new JLabel("JOB");
            Address.setFont(new Font("Serif", Font.PLAIN, 17));
            Address.setBounds(60, 170, 150, 27);
            il2.add(Address);
            
            c1 = new JTextField("MANAGER");
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,170,150,30);
            c1.setFont(new Font("Trebuchet MS",Font.BOLD,17));
         //   c1.setEditable(false);
            c1.setForeground(Color.BLUE);
            il2.add(c1);
            		
            JLabel Nationality = new JLabel("SALARY");
            Nationality.setFont(new Font("Serif", Font.PLAIN, 17));
            Nationality.setBounds(60, 220, 150, 27);
            il2.add(Nationality);
			
            t3 = new JTextField();
            t3.setBounds(200, 220, 150, 27);
            t3.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));

            il2.add(t3);
	
            JLabel Name = new JLabel("PHONE");
            Name.setFont(new Font("Serif", Font.PLAIN, 17));
            Name.setBounds(60, 270, 150, 27);
            il2.add(Name);
	
            t4 = new JTextField();
            t4.setBounds(200, 270, 150, 27);
            t4.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));

            il2.add(t4);
	
            JLabel Phno = new JLabel("AADHAR");
            Phno.setFont(new Font("Serif", Font.PLAIN, 17));
            Phno.setForeground(Color.WHITE);
            Phno.setBounds(60, 320, 150, 27);
            il2.add(Phno);
			
            t5 = new JTextField();
            t5.setBounds(200, 320, 150, 27);
            t5.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));

            il2.add(t5);
	
            
            JLabel email = new JLabel("EMAIL");
            email.setFont(new Font("Serif", Font.PLAIN, 17));
            email.setForeground(Color.WHITE);

            email.setBounds(60, 370, 150, 27);
            il2.add(email);
			
            t6 = new JTextField();
            t6.setBounds(200, 370, 150, 27);
            t6.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));

            il2.add(t6);
            
            JLabel id = new JLabel("ID No");
            id.setFont(new Font("Serif", Font.PLAIN, 17));
            id.setForeground(Color.WHITE);

            id.setBounds(60, 420, 150, 27);
            il2.add(id);
			
            t7 = new JTextField("8085");
            t7.setBounds(200, 420, 150, 27);
            t7.setFont(new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,16));
            t7.setEditable(false);
            t7.setForeground(Color.RED);

            t7.setToolTipText("The Manager ID will always FIXED");

            il2.add(t7);
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Serif", Font.PLAIN, 31));
            AddPassengers.setBounds(450, 24, 442, 35);
            il2.add(AddPassengers);
			
//     
//            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/tenth.jpg"));
//            Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
//            ImageIcon i2 = new ImageIcon(i3);
//            JLabel image = new JLabel(i2);
//            image.setBounds(410,80,480,410);
//            il2.add(image);

            
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
                  String d=(String)c1.getText();
                  String e=t3.getText();
                  String f=t4.getText();
                  String g=t5.getText();
                  String h=t6.getText();
                  String id=t7.getText();

                  

                  

                  try
                  {
                	
                	 String sql="insert into manager values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+id+"')";
                	 int i=cc.s.executeUpdate(sql);
                	 if(i>0)
                	 {
                		 JOptionPane.showMessageDialog(null, "Manager Added Successfully");
                    	 setVisible(false);
                	 }
                	 
                  }
                  catch(Exception er)
                  {
             		 JOptionPane.showMessageDialog(null, "Error! Manager already Exists");

                  }
		}
            });
			
            setLocationRelativeTo(null);
    		setResizable(false);
			
	}
        
    public static void main(String[] args){
        new AddManager().setVisible(true);;
    }   
}