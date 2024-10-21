
package evavakifhastanesi;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Bölümler extends JFrame{
    JTable table;
    
    Bölümler(){
        table = new JTable();
        table.setBounds(50,60,500,500);
        table.setBackground(new Color(255,255,255));
        table.setFont(new Font("Arial",Font.BOLD,15));
        
        add(table);
        
        
        try{
            Database data = new Database();
            String sorgu = "select*from department";
            ResultSet rs = data.statement.executeQuery(sorgu);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        JLabel label1 = new JLabel("Bölümler");
        label1.setBounds(50,30,100,15);
        label1.setFont(new Font("Arial",Font.BOLD,15));
        add(label1);
        
        JLabel label2 = new JLabel("Telefon No");
        label2.setBounds(300,30,100,15);
        label2.setFont(new Font("Arial",Font.BOLD,15));
        add(label2);
        
        
        setUndecorated(true);
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);
        setBounds(650, 140, 600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
    
    public static void main(String[] args){
        new Bölümler();
    }
    
}
