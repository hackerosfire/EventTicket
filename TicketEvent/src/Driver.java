
import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventticket","root","root");
			Statement stmt=con.createStatement();  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
