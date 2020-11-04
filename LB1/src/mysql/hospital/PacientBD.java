package mysql.hospital;
import java.sql.*;

import java.util.ArrayList;

public class PacientBD {
	private static String url = "jdbc:mysql://localhost/hospitalbd?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "";
    public static ArrayList<Pacient> select() {
    	 ArrayList<Pacient> pacients = new ArrayList<Pacient>();
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    		 try (Connection conn = DriverManager.getConnection(url, username, password)){
    			 Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM pacient");
                 while(resultSet.next()){
                	 int id = resultSet.getInt(1);
                	 String name = resultSet.getString(2);
                	 String skarga = resultSet.getString(3);
                	 Pacient pacient = new Pacient(id,name,skarga);
                	 pacients.add(pacient);
    		 }
    	 }
     }
    	 catch(Exception ex){
    		 System.out.println(ex);
    	 }
    	 return pacients;
}
    public static Pacient selectOne(int id) {
    	Pacient pacient = null;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
            	String sql = "SELECT * FROM pacient WHERE id=?";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                    	 int prodId = resultSet.getInt(1);
                    	 String name = resultSet.getString(2);
                    	 String skarga = resultSet.getString(3);
                    	 pacient = new Pacient(prodId, name , skarga);
                    }
            }
    	}
    }
    	catch(Exception ex) {
    		System.out.println(ex);
    	}
    	return pacient;
    }
    public static int insert(Pacient pacient) {
    	  try{
              Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
              try (Connection conn = DriverManager.getConnection(url, username, password)){
                    
                  String sql = "INSERT INTO pacient (name, skarga) Values (?, ?)";
                  try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                      preparedStatement.setString(1, pacient.getName());
                      preparedStatement.setString(2, pacient.getSkarga());
                    
                      return  preparedStatement.executeUpdate();
                  }
              }
    }
    	  catch(Exception ex) {
      		System.out.println(ex);
      	}
    	  return 0;
 }

    public static int update(Pacient pacient) {
    	try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE pacient SET name = ?, skarga = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, pacient.getName());
                    preparedStatement.setString(2, pacient.getSkarga());
                    preparedStatement.setInt(3, pacient.getId());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
            	 String sql = "DELETE FROM pacient WHERE id = ?";
                 try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                     preparedStatement.setInt(1, id);
                       
                     return  preparedStatement.executeUpdate();
                 }
             }
         }
         catch(Exception ex){
             System.out.println(ex);
         }
         return 0;
     }
 // Find pacient
//  public static int search(Pacient pacient) {
//  	try{
//          Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//          try (Connection conn = DriverManager.getConnection(url, username, password)){
//                
//              String sql = "SELECT * FROM pacient where name = ?";
//              try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
//                  preparedStatement.setString(1, pacient.getName());
//    				preparedStatement.setString(2, pacient.getSkarga());
//    				preparedStatement.setInt(3, pacient.getId());
//                    
//                  return  preparedStatement.executeUpdate();
//              }
//          }
//      }
//      catch(Exception ex){
//          System.out.println(ex);
//      }
//      return 0;
//  }
            
}


