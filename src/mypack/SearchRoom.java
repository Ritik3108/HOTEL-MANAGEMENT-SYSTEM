/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class SearchRoom extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField txt_Type;
	private JTable t;
    Choice c1;
    JCheckBox cb;
    boolean isModified=false;

	
	public static void main(String[] args) {
		
					SearchRoom frame = new SearchRoom();
					frame.setVisible(true);
				} 
	
	public void close()
	{
		this.dispose();
	}
	
	public void Show()
	{
		JScrollPane sp=new JScrollPane();
		sp.setBounds(0,182,700,180);
		add(sp);
		
		t=new JTable();
		//t.setBounds(0,182,680,140);
		add(t);
		sp.setViewportView(t);
	}

	public void Run()
	{
			
		
		
		
		try
			{
				Conn cc=new Conn();
				String sql="select * from room where bed_type = '"+c1.getSelectedItem()+"'";
				String sql2="select * from room where bed_type = '"+c1.getSelectedItem()+"' "
						   + "and availability = 'Available'";
				ResultSet rs=cc.s.executeQuery(sql);
				t.setModel(DbUtils.resultSetToTableModel(rs));
				
				if(cb.isSelected())
				{
					ResultSet rs1=cc.s.executeQuery(sql2);
					t.setModel(DbUtils.resultSetToTableModel(rs1));
				}
				
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
			
	}
	public SearchRoom() {
		super("Search For Rooms");
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 550);
		setLocationRelativeTo(null);
		setResizable(false);
     //   setUndecorated(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Room.jpg"));
		Image im=i1.getImage().getScaledInstance(700, 550, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(im);
		JLabel il1=new JLabel(i2);
		il1.setLayout(null);
		il1.setBounds(0,0,700,550);
		contentPane.add(il1);
		
		
		
		ImageIcon iw1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Refresh.jpg"));
		Image im1=iw1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon iw2=new ImageIcon(im1);
		JLabel il2=new JLabel(iw2);
		il2.setLayout(null);
		il2.setBounds(335,390,30,30);
		il2.setToolTipText("LOAD");
		il1.add(il2);
		
		il2.addMouseListener(new MouseAdapter()
		{
	      public void mouseClicked(MouseEvent er)
	      {
           
	    	  if(!isModified)
	    	  {
	    		  Show();
	    		  isModified=true;
	    		  
	    	  }
	    	  Run();
			
			}
	      });
		
		JLabel lblSearchForRoom = new JLabel("Search For Room");
		lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchForRoom.setBounds(250, 11, 186, 31);
		lblSearchForRoom.setForeground(Color.WHITE);
		il1.add(lblSearchForRoom);
		
		JLabel lblRoomAvailable = new JLabel("Room Bed Type:");
		lblRoomAvailable.setBounds(50, 73, 96, 14);
		lblRoomAvailable.setForeground(Color.WHITE);

		il1.add(lblRoomAvailable);
		
		c1=new Choice();
		c1.setBounds(166,70,150,23);
		c1.add("Single Bed");
		c1.add("Double Bed");
		il1.add(c1);
		
	    cb=new JCheckBox("Show Only Available Rooms");
	    cb.setBounds(360,70,200,23);
	    il1.add(cb);
		
		JLabel lblRoomType = new JLabel("Room Number");
		lblRoomType.setBounds(23, 162, 96, 14);
		lblRoomType.setForeground(Color.WHITE);

		il1.add(lblRoomType);
		
		JLabel lblRoomAvailable_1 = new JLabel("Availability");
		lblRoomAvailable_1.setBounds(165, 162, 120, 14);
		lblRoomAvailable_1.setForeground(Color.WHITE);

		il1.add(lblRoomAvailable_1);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(438, 162, 46, 14);
		lblPrice_1.setForeground(Color.WHITE);

		il1.add(lblPrice_1);
                
                JLabel l1 = new JLabel("Bed Type");
		l1.setBounds(560, 162, 96, 14);
		l1.setForeground(Color.WHITE);

		il1.add(l1);
		
		
		
		
		
		
				JButton btnSearch = new JButton("ADD ROOM");
				btnSearch.addActionListener(new ActionListener()
						{
					       public void actionPerformed(ActionEvent er)
					       {
					    	   new AddRooms().setVisible(true);
					       }
						});

		
		btnSearch.setBounds(140, 450, 120, 30);
                btnSearch.setBackground(Color.BLACK);
                btnSearch.setForeground(Color.WHITE);
                il1.add(btnSearch);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(300, 450, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
                il1.add(btnExit);
                
                JButton Search = new JButton("View Rooms");
                Search.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				new Room().setVisible(true);
                                        setVisible(false);
        			}
        		});
                Search.setBounds(475, 450, 120, 30);
                Search.setBackground(Color.BLACK);
                Search.setForeground(Color.WHITE);
                        il1.add(Search);
        		
		
		
		JLabel lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(296, 162, 96, 14);
		lblCleanStatus.setForeground(Color.WHITE);

		il1.add(lblCleanStatus);
		//Run();
                
                getContentPane().setBackground(Color.WHITE);
	}
}