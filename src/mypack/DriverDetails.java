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

public class DriverDetails extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTable table;
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					DriverDetails frame = new DriverDetails();
					frame.setVisible(true);
				}
				
	public void close()
	{
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public void Run()
	{
		JScrollPane sp=new JScrollPane();
		sp.setBounds(0,203,1300,130);
		add(sp);
		
		table = new JTable();
		//table.setBounds(0, 233, 750, 130);
		add(table);
		sp.setViewportView(table);
		String SQL = "select * from driver where brand = '"+c1.getSelectedItem()+"'";
		try{
		
			Conn c = new Conn();
			rs = c.s.executeQuery(SQL);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
		}catch (SQLException ss)
		{
			ss.printStackTrace();
		}	
	}
	public DriverDetails() {
		super("Pick Up");
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300, 600);
		setLocationRelativeTo(null);
		setResizable(false);
      //  setUndecorated(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPickUpService = new JLabel("Pick Up Service");
		lblPickUpService.setFont(new Font("Tahoma", Font.PLAIN|Font.ITALIC, 30));
		lblPickUpService.setBounds(570, 31, 258, 35);
		lblPickUpService.setForeground(Color.WHITE);
		contentPane.add(lblPickUpService);
		
		JLabel lblTypeOfCar = new JLabel("Type of Car :-");
		lblTypeOfCar.setFont(new Font("Tahoma", Font.BOLD|Font.ITALIC, 20));

		lblTypeOfCar.setBounds(552, 97, 155, 34);
		lblTypeOfCar.setForeground(Color.WHITE);

		contentPane.add(lblTypeOfCar);

		
                c1 = new Choice();
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from driver");
                    while(rs.next()){
                        c1.add(rs.getString("brand"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(723, 103, 160, 40);
		contentPane.add(c1);

                
		
//		JLabel lblInfo = new JLabel("Name");
//		lblInfo.setBounds(24, 208, 46, 14);
//		lblInfo.setForeground(Color.WHITE);
//
//		contentPane.add(lblInfo);
		
		JButton btnRegister = new JButton("ADD DRIVER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddDrivers().setVisible(true);
                                setVisible(false);
			}
		});
		
				
				
				
		
		btnRegister.setBounds(450, 500, 120, 30);
                btnRegister.setBackground(Color.BLACK);
                btnRegister.setForeground(Color.WHITE);
		contentPane.add(btnRegister);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(600, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		JButton del = new JButton("Delete Driver");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Delete_Driver().setVisible(true);
                                setVisible(false);
			}
		});
		del.setBounds(750, 500, 120, 30);
                del.setBackground(Color.BLACK);
                del.setForeground(Color.WHITE);
		contentPane.add(del);
		
		
		
//		JLabel lblNewLabel = new JLabel("Age");
//		lblNewLabel.setBounds(165, 208, 46, 14);
//		lblNewLabel.setForeground(Color.WHITE);
//		contentPane.add(lblNewLabel);
//		
//		JLabel lblGender = new JLabel("Gender");
//		lblGender.setBounds(264, 208, 46, 14);
//		lblGender.setForeground(Color.WHITE);
//
//		contentPane.add(lblGender);
//
//		
//		JLabel lblDateOfThe = new JLabel("Car Brand");
//		lblDateOfThe.setBounds(376, 208, 105, 14);
//		lblDateOfThe.setForeground(Color.WHITE);
//
//		contentPane.add(lblDateOfThe);
//	
//		JLabel lblAirport = new JLabel("Available");
//		lblAirport.setBounds(505, 208, 86, 14);
//		lblAirport.setForeground(Color.WHITE);
//
//		contentPane.add(lblAirport);
//		
//		JLabel lblAvailable = new JLabel("Location");
//		lblAvailable.setBounds(600, 208, 73, 14);
//		lblAvailable.setForeground(Color.WHITE);

	//	contentPane.add(lblAvailable);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Pick.jpg"));
		Image im=i1.getImage().getScaledInstance(1300, 600, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(im);
		JLabel il1=new JLabel(i2);
		il1.setLayout(null);
		il1.setBounds(0,0,1300,600);
		contentPane.add(il1);
		
		ImageIcon iw1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/Refresh.jpg"));
		Image im1=iw1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon iw2=new ImageIcon(im1);
		JLabel il2=new JLabel(iw2);
		il2.setLayout(null);
		il2.setBounds(645,430,30,30);
		il2.setToolTipText("SEARCH DRIVER");
		il1.add(il2);
		
		il2.addMouseListener(new MouseAdapter()
		{
	      public void mouseClicked(MouseEvent er)
	      {
	    	  
				Run();
			
			}
	      });
		
		
		
                
                
                
                getContentPane().setBackground(Color.WHITE);
	}
}