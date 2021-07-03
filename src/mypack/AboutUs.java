package mypack;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class AboutUs extends JFrame{

	private JPanel contentPane;

        public static void main(String[] args) {
            new AboutUs().setVisible(true);			
	}
    
        public AboutUs() {
            
            super("About Us - GARG's HOTEL");
            setBackground(new Color(173, 216, 230));
            setSize(700, 500);
            setLocationRelativeTo(null);
    		setResizable(false);
        //    setUndecorated(true);

		
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel l1 = new JLabel("New label");
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/About.jpg"));
            Image i2 = i1.getImage().getScaledInstance(250, 150,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            l1 = new JLabel(i3);
            l1.setBounds(400, 40, 250, 150);
            contentPane.add(l1);


            JLabel l3 = new JLabel("HOTEL");
            l3.setForeground(new Color(0, 250, 154));
            l3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            l3.setBounds(140, 40, 200, 55);
            contentPane.add(l3);

            JLabel l4 = new JLabel("MANAGEMENT SYSTEM");
            l4.setForeground(new Color(127, 255, 0));
            l4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            l4.setBounds(20, 90, 405, 40);
            contentPane.add(l4);

//            JLabel l5 = new JLabel("v5.1");
//            l5.setForeground(new Color(30, 144, 255));
//            l5.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
//            l5.setBounds(185, 140, 100, 21);
//            contentPane.add(l5);


            JLabel l6 = new JLabel("Developed By : RITIK GARG");
            l6.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
            l6.setBounds(70, 198, 600, 35);
            contentPane.add(l6);

            JLabel l7 = new JLabel("Roll Number - 1778310047");
            l7.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            l7.setBounds(70, 260, 600, 34);
            contentPane.add(l7);

            JLabel l8 = new JLabel("Contact : ritikrg007@gmail.com");
            l8.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            l8.setBounds(70, 290, 600, 34);
            contentPane.add(l8);

            JLabel l9 = new JLabel("Education - B.TECH (Computer Science & Engineering)");
            l9.setFont(new Font("Trebuchet MS", Font.BOLD , 20));
            l9.setBounds(70, 320, 600, 34);
            contentPane.add(l9);


            JLabel l10 = new JLabel("Phone - +91 8077849802");
            l10.setForeground(new Color(47, 79, 79));
            l10.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
            l10.setBounds(70, 400, 600, 34);
            contentPane.add(l10);
            
            JLabel l11=new JLabel("Back");
            l11.setBounds(600,370,100,20);
            l11.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
    		l11.setToolTipText("GO BACK TO HOME");


            contentPane.add(l11);
            
            ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/tenth.png"));
    		Image im2=i11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    		ImageIcon i12=new ImageIcon(im2);
            l11.setIcon(i12);
            
            l11.addMouseListener(new MouseAdapter()
			{
		      public void mouseClicked(MouseEvent er)
		      {
		    	  setVisible(false);
		    	  new Dashboard("").setVisible(true);
		      }
			});
                
                
            setVisible(true);
    
            contentPane.setBackground(Color.WHITE);
	}
        

}
