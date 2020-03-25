import com.toedter.calendar.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.xdevapi.Statement;


public class Connect {

	public static Connection getConnection() {
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketlelo","root","root");
	} 	  
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}

		public static boolean login(String login_id, String pass,boolean reg_check){
			boolean flag = false;
					
				try {
						
					
					Connection con2=getConnection();
				
					String query1 ="select * from customers where id=? and pass=?";
					PreparedStatement pst =  con2.prepareStatement(query1);
					pst.setString(1, login_id);
					pst.setString(2, pass);
					ResultSet rs = pst.executeQuery();
					
					if(reg_check==true) {
						
						while(rs.next()) 
						{
							flag = true;
							break;
							
						}
					}
					
					else if(reg_check==false) {
						while(rs.next()) 
						{
							flag = true;
							break;
							
						}
						
						if (flag==true) {
						
							JOptionPane.showMessageDialog(null, "Login Successful");
							places p=new places();
							p.mainframe(login_id);
						//	f1.dispose();
							
							
						}
						if (flag==false) {
							JOptionPane.showMessageDialog(null, "Please Register with Us");
							User u = new User();
						}
						
						}	
					}
					
					
		
				catch(Exception e) {
					e.printStackTrace();
				}
				return flag;
			}
		
	
		public void register(String login,String name,String pass) {
			try {
				boolean flag=login(login,pass,true);
				if(flag==false) {
					
					if(name.equalsIgnoreCase("")|| login.equalsIgnoreCase("") || pass.equalsIgnoreCase("")) {
						
						
						JOptionPane.showMessageDialog(null, "None of the fields can be blank. Please Register Again");
					

					}
					
					else {
						Connect c2=new Connect();
						Connection con2=getConnection();
						String query2 = "insert into customers values(?,?,?)";
						PreparedStatement pst =  con2.prepareStatement(query2);
						pst.setString(1, login);
						pst.setString(2,name);
						pst.setString(3,pass);
						pst.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "User Registered");
					
					}
				}
				
				else {JOptionPane.showMessageDialog(null, "User already registered. Please Login To Continue");}
				
				
				
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

		public ArrayList<String> ret_places(String s, String a) {
			
			ArrayList<String> place=new ArrayList<String>();
			ArrayList<String> theatre=new ArrayList<String>();
			ArrayList<String> mov=new ArrayList<String>();

			try {
			Connect c2=new Connect();
			Connection con2=(Connection)c2.getConnection();
			
			
			if(s=="places") {
				String query="select place_name from places";
				PreparedStatement  pst= con2.prepareStatement(query); 
				ResultSet rs =pst.executeQuery();
				while(rs.next()) {
					
					place.add(rs.getString(1));
					}
				return place;
				
			}
			else if(s=="theatre") {
						
						theatre.clear();
						String query="select theatre_name from theatre where place=(select place_id from places where place_name=?)";
						PreparedStatement  pst= con2.prepareStatement(query);
						pst.setString(1,a);
						ResultSet rs =pst.executeQuery();
						while(rs.next()) {
								theatre.add(rs.getString(1));
						}
				return theatre;
				
			}
			
			else if(s=="movie") {
				
				String query="select movie_name from movies";
				PreparedStatement  pst= con2.prepareStatement(query); 
				ResultSet rs =pst.executeQuery();
				while(rs.next()) {
					mov.add(rs.getString(1));
				System.out.println();
				}
	
			}
			
			
	 	}
			catch (Exception e) {
			e.printStackTrace();
			}
			return mov;
		
			
			
	}

		public void book_ticket(String place, String theatre, String movie, int timing, String qty, String name, java.util.Date dt, String no) {
			 java.sql.CallableStatement pst=null;
			
			try{
				
				java.sql.Date sqldate;
				sqldate= new java.sql.Date(dt.getTime());
				String query="{call b_show (?,?,?,?,?,?,?,?)}";
				Connection con2=getConnection();
			    pst = con2.prepareCall(query);
				pst.setString(1,name);
				pst.setString(2,place);
				pst.setString(3,theatre);
				pst.setString(4,movie);
				pst.setInt(5,timing);
				pst.setString(6,qty);
				pst.setDate(7, sqldate);
				pst.setString(8,no);
				pst.executeUpdate();
				finaltic f =new finaltic();
				f.createtic(name,theatre,movie,dt,timing,qty);
				JOptionPane.showMessageDialog(null, "TICKET BOOKED");
			
	
					
			

				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		}

		public void create_shows(String mov, String thea, String time,int noTic,java.util.Date dats) {
			
			try {
				
				
				java.sql.Date sqldate;
				sqldate=new java.sql.Date(dats.getTime());
				
				System.out.println(sqldate);
				System.out.println(mov);
				System.out.println(thea);
				System.out.println(time);
				System.out.println(noTic);
				String query="{call create_shows(?,?,?,?,?)}";
				java.sql.CallableStatement pst=null;
				Connection con2=getConnection();
			    pst = con2.prepareCall(query);
			    pst.setString(1,mov);
			    pst.setString(2,thea);
			    pst.setString(3,time);
			    pst.setInt(4,noTic);
			    pst.setDate(5,sqldate);
				pst.executeUpdate();
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}

		public void login_admin(String admin_id, String admin_pass) {
			System.out.println(admin_id+admin_pass);
		try {
			Connection con2=getConnection();
			String query1 ="select * from admins where admin_id=? and admin_pass=?";
			PreparedStatement pst = con2.prepareStatement(query1);
			pst.setString(1,admin_id);
			pst.setString(2,admin_pass);
			ResultSet rs = pst.executeQuery();
			boolean flag=false;
			while(rs.next()){
				System.out.println(admin_id+admin_pass);
				flag=true;
			}
			if(flag==true){
				System.out.println(admin_id+admin_pass);
				new adminup();
			}
			else {
				JOptionPane.showMessageDialog(null, "Enter the correct fields");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
		}

		public boolean check(int qt, java.util.Date dat, String movi, String theat) {
			boolean flag=false;
			int check=0;
			java.sql.Date sqldate;
			sqldate=new java.sql.Date(dat.getTime());
			try{
				Connection con2 = getConnection();
				
				String query="select quantity from shows where movie=? and theatre=? and showdate=?";
				PreparedStatement pst= con2.prepareStatement(query);
				pst.setString(1, movi);
				pst.setString(2, theat);
				pst.setDate(3, sqldate);
				
				ResultSet rs = pst.executeQuery();
				System.out.println("in check");
				
				while(rs.next()) { check=rs.getInt(1); System.out.println(rs.getInt(1));}
				
				if(qt<=check) {
					flag=true;
				}
				else {
					flag=false;
				}
			
			}
			catch(Exception e) {
				
			}
			return flag;
			
			
			
		}

	
		
}




				