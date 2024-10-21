
package evavakifhastanesi;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class OdaBilgisi extends JFrame {
    JTable table;
     OdaBilgisi() {
        table = new JTable();
        table.setBounds(50,60,500,500);
        table.setBackground(new Color(255,255,255));
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setFont(new Font("Arial",Font.BOLD,15));
        add(table);
        
        try{
            Database data = new Database();
            String sorgu = "select*from room";
            ResultSet rs = data.statement.executeQuery(sorgu);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        JLabel label1 = new JLabel("Oda No");
        label1.setBounds(50,30,100,15);
        label1.setFont(new Font("Arial",Font.BOLD,15));
        add(label1);
        
        JLabel label2 = new JLabel("Müsaitlik");
        label2.setBounds(175,30,100,15);
        label2.setFont(new Font("Arial",Font.BOLD,15));
        add(label2);
        
        JLabel label3 = new JLabel("Ücret");
        label3.setBounds(300,30,100,15);
        label3.setFont(new Font("Arial",Font.BOLD,15));
        add(label3);
        
        JLabel label4 = new JLabel("Oda Tipi");
        label4.setBounds(425,30,100,15);
        label4.setFont(new Font("Arial",Font.BOLD,15));
        add(label4);       
        
        
        
        setUndecorated(true);
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);
        setBounds(650, 140, 600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
   
    public static void main(String[] args){
        new OdaBilgisi();
    }
    
}

