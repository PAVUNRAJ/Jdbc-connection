package JDBCCONNECTION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Connectiondatabases {

	public static void main(String[] args) {
		Connectiondatabases call = new Connectiondatabases();
		call.view();

	}

	Scanner sc = new Scanner(System.in);

	public void view() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Telegram", "root", "root");
			PreparedStatement views = con.prepareStatement("select * from college where studentname=?");
			System.out.println("name");
			views.setString(1, sc.next());
			ResultSet rs = views.executeQuery();

			while (rs.next()) {
				// System.out.println(rs.getString(1));
				System.out.println("studentname        " + rs.getString(1));
				System.out.println("studentidnumber    " + rs.getString(2));
				System.out.println("Place              " + rs.getString(3));
				System.out.println("date of birth      " + rs.getString(4));
				System.out.println("address 		" + rs.getString(5));
				System.out.println("Sex  			" + rs.getString(6));
				System.out.println("Nationality 	" + rs.getString(7));
				System.out.println("Mobile Number 	" + rs.getString(8));
				System.out.println("Email 			" + rs.getString(9));
				System.out.println("-------------------------");
				System.out.println("This is available Data in section");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
