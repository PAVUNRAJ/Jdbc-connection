package JDBCCONNECTION;

import java.rmi.MarshalException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Telegram implements Interfacefunction {
	// using static keyword
	static String email, studentname, studentidnumber, Place, date, address, sex, nationality, mobile;
	static Scanner sc = new Scanner(System.in);
	Connectiondatabases call = new Connectiondatabases();
	public Customer findByName(String name) throws NameNotFoundException {

        if ("".equals(name)) {
            throw new NameNotFoundException("Name is empty!");
        }

        return new Customer(name);

    }
	
	/*
	static String name;
	static boolean flag = false;

	void validate() {

		ArrayList<String> obj = new ArrayList<String>();
		obj.add("Ayman");
		obj.add("MoktarBelmokta");

		// System.out.println(obj.size());
		System.out.println("Enter the Student Name");
		String name = sc.next();
		for (int i = 0; i < obj.size(); i++) {

			if (obj.get(i).equalsIgnoreCase(name)) {
				System.out.println("-------------------");
				flag = true;
				System.out.println("Warning Message this name not acceptable kindly Enter  another Name");
				break;
			}
		}

		if (flag == false) {
			create();
		}
		*/
	//}

	

	public void create() {
		System.out.println("In create");
		try{
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Telegram", "root", "root");
			PreparedStatement create = con.prepareStatement("insert into college values (?,?,?,?,?,?,?,?,?,?)");
			Scanner sc = new Scanner(System.in);
			create.setString(1,sc.next());
			System.out.println("Enter the Student SurName");
			create.setString(2, sc.next());
			System.out.println("Enter the Student ID Number Name");
			create.setString(3, sc.next());
			System.out.println("Enter the Place Name");
			create.setString(4, sc.next());
			System.out.println("Enter the Date of  Birth");
			create.setString(5, sc.next());
			System.out.println("Enter the Address");
			create.setString(6, sc.next());
			System.out.println("Enter the Sex");
			create.setString(7, sc.next());
			System.out.println("Enter the Nationality");
			create.setString(8, sc.next());
			System.out.println("Enter the Mobile Number");
			create.setString(9, sc.next());
			System.out.println("Enter the Email");
			create.setString(10, sc.next());
			create.executeUpdate();
			System.out.println("sucessfully inserted data");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void view() {
		call.view();
	}

	public void update() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Telegram", "root", "root");
			PreparedStatement updates = con.prepareStatement("update college set email=? where studentidnumber=? ");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Student Id Number");
			studentidnumber = sc.next();
			email = sc.next();

			updates.setString(2, studentidnumber);
			updates.setString(1, email);
			updates.executeUpdate();

			System.out.println("sucessfully updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Telegram", "root", "root");
			PreparedStatement deletes = con.prepareStatement("delete from college where studentname =?");
			Scanner sc = new Scanner(System.in);
			System.out.println("name");
			deletes.setString(1, sc.next());
			deletes.executeUpdate();
			System.out.println("The Data is Deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// call the s() method without any object creation.
		for (int i = 1; i <= 4; i++) {
			Telegram obj = new Telegram();			
			System.out.println("welcome to Knowledge Institute ");
			System.out.println("Following operation you doing your admission form ");
			System.out.println("-----------------------------");
			System.out.println("Inserting press one");
			System.out.println("View      press two");
			System.out.println("Updating  press three");
			System.out.println("Deleting  press four");
		/*	
			try {
				throw new Exception("welcome ");
			  } 
	        catch (MarshalException ex) 
	        { 
	            System.out.println("Warning Message this name not acceptable kindly Enter  another Name"); 
	  
	            // Print the message from MyException object 
	            System.out.println(ex.getMessage()); 
	        } 
	        */
			int options = sc.nextInt();
			switch (options) {
			case 1:
				 obj.create();
				//obj.validate();
				break;
			case 2:
				obj.view();
				break;
			case 3:
				obj.update();
				break;
			case 4:
				obj.delete();
				break;
			default:
				System.exit(0);
			}
		}

	}
}
