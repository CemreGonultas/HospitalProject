/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evavakifhastanesi;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class OdaArama extends JFrame implements ActionListener{
    JLabel statu,label1,label2,label3,label4;
    Choice c1;
    JTable table;
    JButton arama;
    OdaArama(){
        JLabel label1 = new JLabel("Oda Arama");
        label1.setBounds(200,120,200,20);
        label1.setFont(new Font("Arial",Font.BOLD,20));
        add(label1);
        
        statu = new JLabel("Müsaitlik");
        statu.setBounds(40,230,120,30);
        statu.setFont(new Font("Arial",Font.BOLD,16));
        statu.setForeground(Color.BLACK);
        add(statu);
        c1 = new Choice();
        c1.add("Available");
        c1.add("Occupied");
        c1.setBounds(180,230,120,30);
        c1.setFont(new Font("Arial",Font.BOLD,16));
        c1.setForeground(Color.BLACK);
        add(c1);
        
        
        table = new JTable();
        table.setBounds(0,320,600,600);
        table.setBackground(new Color(255,255,255));
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setFont(new Font("Arial",Font.BOLD,15));
        add(table);
        
        try{
            Database data = new Database();
            String sorgu = "select*from Room";
            ResultSet rs = data.statement.executeQuery(sorgu);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        label1 = new JLabel("Oda No");
        label1.setBounds(40,270,120,30);
        label1.setFont(new Font("Arial",Font.BOLD,16));
        label1.setForeground(Color.BLACK);
        add(label1);
        
        label2 = new JLabel("Müsaitlik");
        label2.setBounds(160,270,120,30);
        label2.setFont(new Font("Arial",Font.BOLD,16));
        label2.setForeground(Color.BLACK);
        add(label2);
        
        label3 = new JLabel("Ücret");
        label3.setBounds(330,270,120,30);
        label3.setFont(new Font("Arial",Font.BOLD,16));
        label3.setForeground(Color.BLACK);
        add(label3);
        
        label4 = new JLabel("Oda Tipi");
        label4.setBounds(450,270,120,30);
        label4.setFont(new Font("Arial",Font.BOLD,16));
        label4.setForeground(Color.BLACK);
        add(label4);
        
        arama = new JButton("Ara");
        arama.setBounds(350,230,120,25);
        arama.setBackground(Color.BLACK);
        arama.setForeground(Color.WHITE);
        arama.setFocusable(false);
        arama.setFont(new Font("Arial", Font.BOLD, 15));
        arama.addActionListener(this);
        add(arama);
        
        
        setUndecorated(true);
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);
        setBounds(650, 140, 600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == arama){
       
            String sorgu = "select*from Room where Availability = '"+c1.getSelectedItem()+"'";
            try{
                Database data = new Database();
                ResultSet rs = data.statement.executeQuery(sorgu);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    
    
    public static void main(String[] args){
        new OdaArama();
    }
    
}
