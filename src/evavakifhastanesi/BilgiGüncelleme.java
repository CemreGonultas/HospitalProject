
package evavakifhastanesi;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class BilgiGüncelleme extends JFrame implements ActionListener{
    JLabel id,numara,tarih,amountpaid,pedingamount;
    JTextField numaraText,tarihText,amountpaidText,pedingamountText;
    JButton check,güncelleme;
    Choice c1;
    BilgiGüncelleme(){
        JLabel label1 = new JLabel("Bilgi Güncelleme");
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
                c1.add(rs.getString("Number"));
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
        
        numaraText = new JTextField();
        numaraText.setBounds(250,270,150,30);
        numaraText.setForeground(Color.black);
        numaraText.setFont(new Font("Arial", Font.PLAIN,15));
        numaraText.setBackground(Color.white);
        add(numaraText);
        
        tarih = new JLabel("Tarih");
        tarih.setBounds(40,310,120,30);
        tarih.setFont(new Font("Arial",Font.BOLD,16));
        tarih.setForeground(Color.BLACK);
        add(tarih);
        
        tarihText = new JTextField();
        tarihText.setBounds(250,310,150,30);
        tarihText.setForeground(Color.black);
        tarihText.setFont(new Font("Arial", Font.PLAIN,15));
        tarihText.setBackground(Color.white);
        add(tarihText);
        
        amountpaid = new JLabel("Ödenen Miktar");
        amountpaid.setBounds(40,350,120,30);
        amountpaid.setFont(new Font("Arial",Font.BOLD,16));
        amountpaid.setForeground(Color.BLACK);
        add(amountpaid);
        
        amountpaidText = new JTextField();
        amountpaidText.setBounds(250,350,150,30);
        amountpaidText.setForeground(Color.black);
        amountpaidText.setFont(new Font("Arial", Font.PLAIN,15));
        amountpaidText.setBackground(Color.white);
        add(amountpaidText);
        
        pedingamount = new JLabel("Bekleyen Miktar");
        pedingamount.setBounds(40,390,150,30);
        pedingamount.setFont(new Font("Arial",Font.BOLD,16));
        pedingamount.setForeground(Color.BLACK);
        add(pedingamount);
        
        pedingamountText = new JTextField();
        pedingamountText.setBounds(250,390,150,30);
        pedingamountText.setForeground(Color.black);
        pedingamountText.setFont(new Font("Arial", Font.PLAIN,15));
        pedingamountText.setBackground(Color.white);
        add(pedingamountText);
        
        check = new JButton("Kontrol");
        check.setBounds(230,500,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFocusable(false);
        check.setFont(new Font("Arial", Font.BOLD, 15));
        check.addActionListener(this);
        add(check);
        
        güncelleme = new JButton("Güncelle");
        güncelleme.setBounds(60,500,120,30);
        güncelleme.setBackground(Color.BLACK);
        güncelleme.setForeground(Color.WHITE);
        güncelleme.setFocusable(false);
        güncelleme.setFont(new Font("Arial", Font.BOLD, 15));
        güncelleme.addActionListener(this);
        add(güncelleme);
        
        setUndecorated(true);
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);
        setBounds(650, 140, 600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == check){
               Database data = new Database();
               String id = c1.getSelectedItem();
               
               try{
                   ResultSet rs = data.statement.executeQuery("select*from Patient_Info where number='"+c1.getSelectedItem()+"'");
                   while(rs.next()){
                       numaraText.setText(rs.getString("Room_Number"));
                       tarihText.setText(rs.getString("Time"));
                       amountpaidText.setText(rs.getString("Deposite"));
                      
                   }
                   ResultSet rs1 = data.statement.executeQuery("select*from room where room_no='"+numara.getText()+"'");
                   while(rs1.next()){
                       String price = rs1.getString("Price");
                       int amountPaid = Integer.parseInt(price)-Integer.parseInt(amountpaid.getText());
                       pedingamountText.setText(""+amountPaid);
                   }
               }catch(Exception ex){
                   ex.printStackTrace();
               }
        }else if(e.getSource() == güncelleme){
            Database data = new Database();
               String sorgu = "select * from Patient_Info where id = '"+id+"'";
               try{
                   String q = c1.getSelectedItem();
                   String room = numara.getText();
                   String time = tarih.getText();
                   String amount = amountpaid.getText();
                   data.statement.executeUpdate("update Patient_Info set Room_Number='"+room+"',Time='"+time+"',Deposite ='"+amount+"' where id = '"+q+"'");
                   JOptionPane.showMessageDialog(null,"Güncelleme Başarılı");
                   setVisible(false);
               }catch(Exception ex){
                   ex.printStackTrace();
               }
        }
    }
    
    
    
    
    public static void main(String[] args){
        new BilgiGüncelleme();
    }
    
}
