import java.sql.*;
import javax.sql.*;
class JDBCDemo2
{
	public static void main(String args[])
	{
		
		try
		{
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:sample");
			Statement st=con.createStatement();
			System.out.println("----------------------------------");
			System.out.println("ID\t\tName");			
			System.out.println("----------------------------------");
			ResultSet rs=st.executeQuery("select * from student");
			while(rs.next())
			{
				int rn=rs.getInt("rollno");
				System.out.println("rn"+rn);
			}
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?)");
			ps.setInt(1,115);
			ps.setString(2,"Shreya");
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("Record saved");
			}
			System.out.println("----------------------------------");
			System.out.println("ID\t\tName");			
			System.out.println("----------------------------------");
			ResultSet rs1=st.executeQuery("select * from student");
			while(rs1.next())
			{
				int rn=rs.getInt("roll no");
				String nam=rs.getString("sname");
				System.out.println(rn+"\t\t"+nam);	
			}
			
		}
		catch(SQLException se){System.out.println(""+se);}
		finally
		{
			//con.close();
		}
	}
}