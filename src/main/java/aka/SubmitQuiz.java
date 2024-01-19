package aka;

import java.sql.*;


public class SubmitQuiz
{
	
	public static boolean saveData(int idCat,String question,String a,String b,String c,String d,int ans)
	{
		try(Connection conn=Connect.createConnection())
		{
			Statement  stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO question values(null,'"+question+"','"+a+"','"+b+"','"+c+"','"+d+"',"+ans+","+idCat+")");
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	/*public static int getMaxSrNo()
	{
		try(Connection conn=Connect.createConnection())
		{
			Statement  stmt = conn.createStatement( );
		    ResultSet  rs =stmt.executeQuery("select max(srno) from maths_ques");
		    if(rs.next())
			{	
				return rs.getInt(1);
			}
			else
			{	
				return 0;
			}
		}
		catch(Exception e)
		{
			return 0;
		}
	}*/
	
}
