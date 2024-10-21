
package evavakifhastanesi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class KontrolPaneli extends JFrame implements ActionListener {
    JButton newpatient,room,logout,department,employeeinfo,patientinfo
            ,patientdischarge,searchroom,patientdetails,hospitalambulance;
    
    KontrolPaneli(){
        
        
        
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/evaarka.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(310,30,600,600);
        add(label);
        
        
        
        newpatient = new JButton("Yeni Hasta Kayıt");
        newpatient.setBounds(60,200,200,30);
        newpatient.setBackground(Color.WHITE);
        newpatient.setForeground(Color.BLACK);
        newpatient.setFocusable(false);
        newpatient.setFont(new Font("Arial", Font.BOLD, 15));
        newpatient.addActionListener(this);
        add(newpatient);

        room = new JButton("Oda Bilgisi");
        room.setBounds(60,230,200,30);
        room.setBackground(Color.WHITE);
        room.setForeground(Color.BLACK);
        room.setFocusable(false);
        room.setFont(new Font("Arial", Font.BOLD, 15));
        room.addActionListener(this);
        add(room);

        department = new JButton("Bölümler");
        department.setBounds(60,260,200,30);
        department.setBackground(Color.WHITE);
        department.setForeground(Color.BLACK);
        department.setFocusable(false);
        department.setFont(new Font("Arial", Font.BOLD, 15));
        department.addActionListener(this);
        add(department);
        
        employeeinfo = new JButton("Doktor Bilgisi");
        employeeinfo.setBounds(60,290,200,30);
        employeeinfo.setBackground(Color.WHITE);
        employeeinfo.setForeground(Color.BLACK);
        employeeinfo.setFocusable(false);
        employeeinfo.setFont(new Font("Arial", Font.BOLD, 15));
        employeeinfo.addActionListener(this);
        add(employeeinfo);
        
        patientinfo = new JButton("Hasta Bilgisi");
        patientinfo.setBounds(60,320,200,30);
        patientinfo.setBackground(Color.WHITE);
        patientinfo.setForeground(Color.BLACK);
        patientinfo.setFocusable(false);
        patientinfo.setFont(new Font("Arial", Font.BOLD, 15));
        patientinfo.addActionListener(this);
        add(patientinfo);
        
        patientdischarge = new JButton("Hasta Tahliye");
        patientdischarge.setBounds(60,350,200,30);
        patientdischarge.setBackground(Color.WHITE);
        patientdischarge.setForeground(Color.BLACK);
        patientdischarge.setFocusable(false);
        patientdischarge.setFont(new Font("Arial", Font.BOLD, 15));
        patientdischarge.addActionListener(this);
        add(patientdischarge);
        
        searchroom = new JButton("Oda Arama");
        searchroom.setBounds(60,380,200,30);
        searchroom.setBackground(Color.WHITE);
        searchroom.setForeground(Color.BLACK);
        searchroom.setFocusable(false);
        searchroom.setFont(new Font("Arial", Font.BOLD, 15));
        searchroom.addActionListener(this);
        add(searchroom);
        
        patientdetails = new JButton("Bilgi Güncelleme");
        patientdetails.setBounds(60,410,200,30);
        patientdetails.setBackground(Color.WHITE);
        patientdetails.setForeground(Color.BLACK);
        patientdetails.setFocusable(false);
        patientdetails.setFont(new Font("Arial", Font.BOLD, 15));
        patientdetails.addActionListener(this);
        add(patientdetails);
        
        

        logout = new JButton("Çıkış");
        logout.setBounds(60,470,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFocusable(false);
        logout.setFont(new Font("Arial", Font.BOLD, 15));
        logout.addActionListener(this);
        add(logout);
        
        JPanel panel = new JPanel();
        panel.setBounds(0,0,310,1000);
        panel.setLayout(null);
        panel.setBackground(new Color(120,218,232));
        add(panel);
        
        
        
        
        
        setUndecorated(true);
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);
        setLocation(280,70);
        setSize(1000,700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newpatient){
            new YeniHasta();
        } else if (e.getSource() == room) {
            new OdaBilgisi();
        } else if (e.getSource() ==  department) {
            new Bölümler();
        } else if (e.getSource() ==  employeeinfo) {
            new MüsteriBilgisi();
        }
        else if (e.getSource() ==  patientinfo) {
            new HastaBilgisi();
        } else if (e.getSource() ==  patientdischarge) {
            new HastaTahliye();
        }
        else if (e.getSource() ==  searchroom) {
            new OdaArama();
        }else if (e.getSource() ==  patientdetails) {
            new BilgiGüncelleme();
        }
        else if (e.getSource() == logout){
            System.exit(0);
        } else {
            setVisible(false);
        }

    }
    
    
    public static void main(String[] args){
        new KontrolPaneli();
    }
}
