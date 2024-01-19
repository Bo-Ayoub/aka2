package aka;

import java.sql.*;


public class RegisterTable
{
	public static String authenticate(String univ,String degree,String name,String email,String password)
	{
		try(Connection conn=Connect.createConnection())
		{
			Statement  stmt = conn.createStatement( );
			
		   
		    ResultSet  rs2 =stmt.executeQuery("select * from student where Email='"+email+"'");
		    if(rs2.next())
			{	
				return "myemail";
			}
		    stmt.executeUpdate("INSERT INTO student VALUES (null, '"+name+"', '"+email+"', '"+password+"', '"+univ+"', '"+degree+"')");
		    return "true";
		}
		catch(SQLException e)
		{
			return "error";
		}
		
	}
}
