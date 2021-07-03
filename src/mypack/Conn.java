package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	
	Connection c;
	Statement s;
	
	public Conn()
	{
		try
		{
			
		Class.forName("com.mysql.jdbc.Driver");		
		c=DriverManager.getConnection("jdbc:mysql:///hms","root","");		
		s=c.createStatement();
		
		}
		catch(Exception ev)
		{
			System.out.println(ev);
		}
				
		
	}

}
