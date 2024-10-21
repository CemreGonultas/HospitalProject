
package evavakifhastanesi;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class Database {
   public static final String kullanici_adi = "root";
    public static final String parola = "";
    
    public static final String db_ismi = "evavakifhastanesi";
    
    public static final String host =  "localhost";
    
    public static final int port = 3306;
    Connection con = null;
    
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    
    public Database(){
     String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }
        
        
        try {
            con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Bağlantı Başarılı...");
            statement = con.createStatement();
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
            //ex.printStackTrace();
        }
        
        
    }
}

