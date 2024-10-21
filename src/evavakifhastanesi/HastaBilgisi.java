
package evavakifhastanesi;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class HastaBilgisi extends JFrame {
    JTable table;
    HastaBilgisi(){
        table = new JTable();
        table.setBounds(20,40,600,600);
        table.setBackground(new Color(255,255,255));
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setFont(new Font("Arial",Font.BOLD,15));
              
        add(table);
        
        try{
            Database data = new Database();
            String sorgu = "select number,name,surname,gender,patient_disease,room_number,deposite from Patient_info";
            ResultSet rs = data.statement.executeQuery(sorgu);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
              
        JLabel label2 = new JLabel("TC");
        label2.setBounds(20,0,100,15);
        label2.setFont(new Font("Arial",Font.BOLD,15));
        add(label2);
        
        JLabel label3 = new JLabel("Ad");
        label3.setBounds(120,0,100,15);
        label3.setFont(new Font("Arial",Font.BOLD,15));
        add(label3);
        
        JLabel label4 = new JLabel("Soyad");
        label4.setBounds(190,0,100,15);
        label4.setFont(new Font("Arial",Font.BOLD,15));
        add(label4); 
        
        JLabel label5 = new JLabel("Cinsiyet");
        label5.setBounds(275,0,100,15);
        label5.setFont(new Font("Arial",Font.BOLD,15));
        add(label5); 
        
        JLabel label6 = new JLabel("Şikayet");
        label6.setBounds(365,0,100,15);
        label6.setFont(new Font("Arial",Font.BOLD,15));
        add(label6); 
        
        JLabel label7 = new JLabel("Oda No");
        label7.setBounds(450,0,100,15);
        label7.setFont(new Font("Arial",Font.BOLD,15));
        add(label7); 
        
      
        
        JLabel label9 = new JLabel("Depozito");
        label9.setBounds(520,0,100,15);
        label9.setFont(new Font("Arial",Font.BOLD,15));
        add(label9); 
             
        
        setUndecorated(true);
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);
        setBounds(650, 140, 600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
    
    
    
    
    
    public static void main(String[] args){
        new HastaBilgisi();
    }
    
}
