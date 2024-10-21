
package evavakifhastanesi;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class HastaTahliye extends JFrame implements ActionListener {
    JLabel id,giris,cikis,numara,date;
    Choice c1;
    JButton checkout,check;
    JLabel numaraLabel,girisLabel;
    Date date1;
    HastaTahliye(){
        JLabel label1 = new JLabel("CHECK-OUT");
        label1.setBounds(200,120,200,20);
        label1.setFont(new Font("Arial",Font.BOLD,20));
        add(label1);
        
        id = new JLabel("Hasta Id");
        id.setBounds(40,230,120,30);
        id.setFont(new Font("Arial",Font.BOLD,16));
        id.setForeground(Color.BLACK);
        add(id);
        
        c1 = new Choice();
        try{
            Database data = new Database();
            ResultSet rs = data.statement.executeQuery("select*from Patient_info");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        c1.setBounds(250,230,120,30);
        c1.setFont(new Font("Arial",Font.BOLD,16));
        c1.setForeground(Color.BLACK);
        add(c1);
        
        numara = new JLabel("Oda No");
        numara.setBounds(40,270,120,30);
        numara.setFont(new Font("Arial",Font.BOLD,16));
        numara.setForeground(Color.BLACK);
        add(numara);
        
        numaraLabel = new JLabel("");
        numaraLabel.setBounds(250,270,120,30);
        numaraLabel.setFont(new Font("Arial",Font.BOLD,16));
        numaraLabel.setForeground(Color.BLACK);
        add(numaraLabel);

        
        giris = new JLabel("Giriş Tarihi");
        giris.setBounds(40,310,120,30);
        giris.setFont(new Font("Arial",Font.BOLD,16));
        giris.setForeground(Color.BLACK);
        add(giris);
        
        girisLabel = new JLabel("");
        girisLabel.setBounds(250,310,400,30);
        girisLabel.setFont(new Font("Arial",Font.BOLD,16));
        girisLabel.setForeground(Color.BLACK);
        add(girisLabel);
        
        
        cikis = new JLabel("Çıkış Tarihi");
        cikis.setBounds(40,350,120,30);
        cikis.setFont(new Font("Arial",Font.BOLD,16));
        cikis.setForeground(Color.BLACK);
        add(cikis);
        
        Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setBounds(250,350,400,30);
        date.setFont(new Font("Arial",Font.BOLD,16));
        date.setForeground(Color.BLACK);
        add(date);
        
        
        check = new JButton("Kontrol");
        check.setBounds(230,500,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFocusable(false);
        check.setFont(new Font("Arial", Font.BOLD, 15));
        check.addActionListener(this);
        add(check);
        
        checkout = new JButton("Check-out");
        checkout.setBounds(60,500,120,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFocusable(false);
        checkout.setFont(new Font("Arial", Font.BOLD, 15));
        checkout.addActionListener(this);
        add(checkout);
        
        
        
        
        setUndecorated(true);
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);
        setBounds(650, 140, 600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == checkout){
               Database data = new Database();
        try{
            data.statement.executeUpdate("delete from Patient_Info where number='"+c1.getSelectedItem()+"'");
            data.statement.executeUpdate("update room set Availability = 'Available' where room_no ='"+numara.getText()+"'");
            JOptionPane.showMessageDialog(null,"Hasta tahliye edildi!");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        }else if(e.getSource() == check){
            Database data = new Database();
        try{
            ResultSet rs = data.statement.executeQuery("select*from Patient_Info where number='"+c1.getSelectedItem()+"'");
            while(rs.next()){
                numaraLabel.setText(rs.getString("Room_Number"));
                girisLabel.setText(rs.getString("Time"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        }
    }   
    
    
    
    
    
    
    public static void main(String[] args){
        new HastaTahliye();
    }
    
}
