
package evavakifhastanesi;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class MüsteriBilgisi extends JFrame{
    JTable table;
    MüsteriBilgisi(){
        table = new JTable();
        table.setBounds(50,60,500,500);
        table.setBackground(new Color(255,255,255));
        table.setFont(new Font("Arial",Font.BOLD,13));
        
        
        
        add(table);
        
        
        try{
            Database data = new Database();
            String sorgu = "select*from EMP_INFO";
            ResultSet rs = data.statement.executeQuery(sorgu);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        JLabel label1 = new JLabel("Ad-Soyad");
        label1.setBounds(50,30,100,15);
        label1.setFont(new Font("Arial",Font.BOLD,13));
        add(label1);
        
        JLabel label2 = new JLabel("Doğum Tarihi");
        label2.setBounds(150,30,100,15);
        label2.setFont(new Font("Arial",Font.BOLD,13));
        add(label2);
        
        JLabel label3 = new JLabel("Telefon No");
        label3.setBounds(260,30,100,15);
        label3.setFont(new Font("Arial",Font.BOLD,13));
        add(label3);
        
        JLabel label4 = new JLabel("E-Mail");
        label4.setBounds(350,30,100,15);
        label4.setFont(new Font("Arial",Font.BOLD,13));
        add(label4); 
        
        JLabel label5 = new JLabel("Kimlik No");
        label5.setBounds(450,30,100,15);
        label5.setFont(new Font("Arial",Font.BOLD,13));
        add(label5); 
        
        
        setUndecorated(true);
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);
        setBounds(650, 140, 600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
    
    
    
    
    public static void main(String[] args){
        new MüsteriBilgisi();
    }
    
}
