package mypack;

import java.awt.*;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;


public class Room extends JFrame {
	//Connection conn = null;
	private JPanel p;
	private JTable t;
	private JLabel lblAvailability;
	private JLabel lblCleanStatus;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblRoomNumber;
	private JLabel lblId;

	
	public static void main(String[] args) {
		
					Room frame = new Room();
					frame.setVisible(true);
				} 
	
	public void Show()
	{
		
		try
		{
			Conn cc=new Conn();
			String sql="select * from room";
			ResultSet rs=cc.s.executeQuery(sql);
			t.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception ey)
		{
			ey.printStackTrace();
		}
	}

        
	public Room() {
		super("Room Details");
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		 setLocationRelativeTo(null);
			setResizable(false);
        //    setUndecorated(true);

		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		JScrollPane sp=new JScrollPane();
		sp.setBounds(0,40,500,200);
		add(sp);
		
		 t=new JTable();
       //  t.setBounds(0,40,500,200);
         add(t);
		sp.setViewportView(t);
		
		Show();
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/eight.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 600,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(0,-0,500,600);
                add(l1);
                
                final JCheckBox cb=new JCheckBox("Show Dirty Rooms");
        	    cb.setBounds(350,255,130,23);
        	    l1.add(cb);
                
               
                
                ImageIcon iw1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Refresh.jpg"));
        		Image im1=iw1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        		ImageIcon iw2=new ImageIcon(im1);
        		JLabel il2=new JLabel(iw2);
        		il2.setLayout(null);
        		il2.setBounds(235,400,30,30);
        		il2.setToolTipText("REFRESH");
        		l1.add(il2);
        		
        		il2.addMouseListener(new MouseAdapter()
        		{
        	      public void mouseClicked(MouseEvent er)
        	      {
        	    	  
        				Show();
        				 try
        					{
        						Conn cc2=new Conn();
        						String sql2="select * from room where clean_status = 'Dirty'";
        						
        						if(cb.isSelected())
        						{
        							ResultSet rs1=cc2.s.executeQuery(sql2);
        							t.setModel(DbUtils.resultSetToTableModel(rs1));
        						}
        						
        					}
        					catch(Exception ee)
        					{
        						ee.printStackTrace();
        					}
        			
        			}
        	      });
        		
                
                
        JButton btnLoadData = new JButton("ADD ROOM");
        btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddRooms().setVisible(true);
                               
			}
		});
				
		
		btnLoadData.setBounds(40, 470, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
                l1.add(btnLoadData);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnNewButton.setBounds(190, 470, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		l1.add(btnNewButton);
		
		JButton Search = new JButton("Search Room");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchRoom().setVisible(true);
                                setVisible(false);
			}
		});
		Search.setBounds(340, 470, 120, 30);
		Search.setBackground(Color.BLACK);
		Search.setForeground(Color.WHITE);
		l1.add(Search);
		
		lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(119, 15, 69, 14);
		l1.add(lblAvailability);
		
		lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(216, 15, 76, 14);
		l1.add(lblCleanStatus);
		
		lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(330, 15, 46, 14);
		l1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Bed Type");
		lblNewLabel_1.setBounds(417, 15, 76, 14);
		l1.add(lblNewLabel_1);
		

		ImageIcon iw11=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Clean.jpg"));
		Image im11=iw11.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		ImageIcon iw22=new ImageIcon(im11);
		JLabel il21=new JLabel(iw22);
		il21.setLayout(null);
		il21.setBounds(425,290,40,40);
		il21.setToolTipText("CLEAN ALL DIRTY ROOMS");
		l1.add(il21);
		
		il21.addMouseListener(new MouseAdapter()
		{
	      public void mouseClicked(MouseEvent er)
	      {
	    	    Show();
				JOptionPane.showMessageDialog(null, "ROOM CLEANING SUCCESSFUL");
				Conn ct=new Conn();
				String sq="update room set clean_status='Cleaned' where clean_status='dirty'";
				try {
					ct.s.executeUpdate(sq);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			}
	      });
		
		
	    
	   

		
		lblId = new JLabel("Room Number");
		lblId.setBounds(12, 15, 90, 14);
		l1.add(lblId);
		
		
		
                
                getContentPane().setBackground(Color.WHITE);
	}}