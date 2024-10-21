
package evavakifhastanesi;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class YeniHasta extends JFrame implements ActionListener{
    JButton ekle,geri;
    JTextField idText,numaraText,isimText,soyadText,hastalıkText,ücretText;
    JRadioButton radioButtonM, radioButtonF;
    JComboBox comboBox;
    JLabel date,cinsiyet,isim,id,numara,soyad,hastalık,odası;
    Choice c1;
    
    YeniHasta(){
        
        id = new JLabel("ID");
        id.setBounds(40,130,120,30);
        id.setFont(new Font("Arial",Font.BOLD,16));
        id.setForeground(Color.BLACK);
        add(id);
        
        comboBox = new JComboBox(new String[]{"Kimlik Kartı","Sürücü Belgesi"});
        comboBox.setBounds(250,130,150,30);
        comboBox.setForeground(Color.black);
        comboBox.setFont(new Font("Arial", Font.PLAIN,15));
        comboBox.setBackground(Color.white);
        add(comboBox);
        
        numara = new JLabel("Numara");
        numara.setBounds(40,170,120,30);
        numara.setFont(new Font("Arial",Font.BOLD,16));
        numara.setForeground(Color.BLACK);
        add(numara);
        
        numaraText = new JTextField();
        numaraText.setBounds(250,170,150,30);
        numaraText.setForeground(Color.black);
        numaraText.setFont(new Font("Arial", Font.PLAIN,15));
        numaraText.setBackground(Color.white);
        add(numaraText);
        
        isim = new JLabel("Hasta Ad");
        isim.setBounds(40,210,120,30);
        isim.setFont(new Font("Arial",Font.BOLD,16));
        isim.setForeground(Color.BLACK);
        add(isim);
        
        isimText = new JTextField();
        isimText.setBounds(250,210,150,30);
        isimText.setForeground(Color.black);
        isimText.setFont(new Font("Arial", Font.PLAIN,15));
        isimText.setBackground(Color.white);
        add(isimText);
        
        
        soyad = new JLabel("Hasta Soyad");
        soyad.setBounds(40,250,120,30);
        soyad.setFont(new Font("Arial",Font.BOLD,16));
        soyad.setForeground(Color.BLACK);
        add(soyad);
        
        soyadText = new JTextField();
        soyadText.setBounds(250,250,150,30);
        soyadText.setForeground(Color.black);
        soyadText.setFont(new Font("Tahoma", Font.PLAIN,15));
        soyadText.setBackground(Color.white);
        add(soyadText);
        
        cinsiyet = new JLabel("Cinsiyet");
        cinsiyet.setBounds(40,290,120,30);
        cinsiyet.setFont(new Font("Arial",Font.BOLD,16));
        cinsiyet.setForeground(Color.BLACK);
        add(cinsiyet);

        radioButtonF = new JRadioButton("Kadın");
        radioButtonF.setBounds(250,290,70,27);
        radioButtonF.setBackground(new Color(255,255,255));
        radioButtonF.setFont(new Font("Arial", Font.BOLD,14));
        radioButtonF.setForeground(Color.black);
        add(radioButtonF);

        radioButtonM = new JRadioButton("Erkek");
        radioButtonM.setBounds(330,290,100,27);
        radioButtonM.setBackground(new Color(255,255,255));
        radioButtonM.setFont(new Font("Arial", Font.BOLD,14));
        radioButtonM.setForeground(Color.black);
        add(radioButtonM);
        
        
        hastalık = new JLabel("Şikayet");
        hastalık.setBounds(40,330,120,30);
        hastalık.setFont(new Font("Arial",Font.BOLD,16));
        hastalık.setForeground(Color.BLACK);
        add(hastalık);
        
        hastalıkText = new JTextField();
        hastalıkText.setBounds(250,330,150,30);
        hastalıkText.setForeground(Color.black);
        hastalıkText.setFont(new Font("Tahoma", Font.PLAIN,15));
        hastalıkText.setBackground(Color.white);
        add(hastalıkText);
        
        odası = new JLabel("Oda Numarası");
        odası.setBounds(40,370,120,30);
        odası.setFont(new Font("Arial",Font.BOLD,16));
        odası.setForeground(Color.BLACK);
        add(odası);
        
        c1 = new Choice();
        try{
            Database data = new Database();
            ResultSet rs = data.statement.executeQuery("select*from Room");
            while(rs.next()){
                c1.add(rs.getString("room_no"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        c1.setBounds(250,370,120,30);
        c1.setFont(new Font("Arial",Font.BOLD,16));
        c1.setForeground(Color.BLACK);
        add(c1);
        
        
        JLabel tarih = new JLabel("Tarih");
        tarih.setBounds(40,410,120,30);
        tarih.setFont(new Font("Arial",Font.BOLD,16));
        tarih.setForeground(Color.BLACK);
        add(tarih);
        
        Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setBounds(250,410,400,30);
        date.setFont(new Font("Arial",Font.BOLD,16));
        date.setForeground(Color.BLACK);
        add(date);
        
        JLabel ücret = new JLabel("Ücret");
        ücret.setBounds(40,450,120,30);
        ücret.setFont(new Font("Arial",Font.BOLD,16));
        ücret.setForeground(Color.BLACK);
        add(ücret);
        
        ücretText = new JTextField();
        ücretText.setBounds(250,450,150,30);
        ücretText.setForeground(Color.black);
        ücretText.setFont(new Font("Tahoma", Font.PLAIN,15));
        ücretText.setBackground(Color.white);
        add(ücretText);
        
        ekle = new JButton("Hasta Kayıt");
        ekle.setBounds(60,500,120,30);
        ekle.setBackground(Color.BLACK);
        ekle.setForeground(Color.WHITE);
        ekle.setFocusable(false);
        ekle.setFont(new Font("Arial", Font.BOLD, 15));
        ekle.addActionListener(this);
        add(ekle);
        
        geri = new JButton("Çıkış");
        geri.setBounds(230,500,120,30);
        geri.setBackground(Color.BLACK);
        geri.setForeground(Color.WHITE);
        geri.setFocusable(false);
        geri.setFont(new Font("Arial", Font.BOLD, 15));
        geri.addActionListener(this);
        add(geri);
        
        
        
        
        
        
        setUndecorated(true);
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);
        setBounds(650, 140, 600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Database data = new Database();
        if (e.getSource() == ekle){
            
            String radioBTN = null;
            if(radioButtonF.isSelected()){
                radioBTN = "Kadın";
            }else if (radioButtonM.isSelected()){
                radioBTN = "Erkek";
            }
            String s1 = (String) comboBox.getSelectedItem();
            String s2 = numaraText.getText() ;
            String s3 = isimText.getText();
            String s4 = soyadText.getText();
            String s5 = radioBTN;
            String s6 = hastalıkText.getText();
            String s7 = c1.getSelectedItem();
            String s8 = date.getText();
            String s9 = ücretText.getText();
            
            try{
                String sorgu = "insert into Patient_Info values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"')";
                String sorgu2 = "update room set Availability = 'Occupied' where room_no"+s6;
                data.statement.executeUpdate(sorgu);
                data.statement.executeUpdate(sorgu2);
                JOptionPane.showMessageDialog(null,"Ekleme başarılı!");
                setVisible(false);
            }catch(HeadlessException | SQLException ex){
            }
        } else if (e.getSource() == geri) {
            setVisible(false);
        }

    }
    
    public static void main(String[] args){
        YeniHasta yeniHasta = new YeniHasta();
    }
}
