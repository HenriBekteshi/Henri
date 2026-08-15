

import javax.swing.*;    
import java.awt.event.*;    
public class ComboBoxExample {    
JFrame f;    
ComboBoxExample(){    
    f=new JFrame("ComboBox Example");   
    final JLabel label = new JLabel();    
    int paga=0;
  label.setHorizontalAlignment(JLabel.CENTER);  
  label.setSize(400,100);  
  final JLabel total = new JLabel();          
  //label.setHorizontalAlignment(JLabel.SOUTH);  
  label.setSize(400,100);
    JButton b=new JButton("Show");  
    b.setBounds(200,100,75,20);  
    String pije[]={"Birre","Vodka","Uiski","Pije te Gazuara","Tjeter"};      
    String ushqimi[]={"Mengjes","Dreke","Darke","Snack",};
    String kafe[]={"Kafe","Caj","Serbete","Asgje"};
    String tavolina[]={"1","2","3","4","5","6","7","8","9","10"};
    
    
final JComboBox cp=new JComboBox(pije);    
final JComboBox cu=new JComboBox(ushqimi);
final JComboBox ck=new JComboBox(kafe);
final JComboBox ct=new JComboBox(tavolina);

    cp.setBounds(50, 70,90,20);   
    cu.setBounds(50, 100,90,20);
    ck.setBounds(50, 130,90,20);   
    ct.setBounds(50, 160,90,20);
    f.add(cp); 
    f.add(cu);
    f.add(ck); 
    f.add(ct);
    f.add(label); 
    f.add(b);  
    f.add(total);
    
    f.setLayout(null);    
    f.setSize(400,400);    
    f.setVisible(true);       
    b.addActionListener(new ActionListener() {  
     public void actionPerformed(ActionEvent e) {       
        Object cus=cu.getItemAt(cu.getSelectedIndex());
        Object cps=cp.getItemAt(cp.getSelectedIndex());
        Object cks=ck.getItemAt(ck.getSelectedIndex());
        Object cts=ct.getItemAt(ct.getSelectedIndex());
        
        String data = "Porosia: " + cus + " + " + cps + " + " + cks +" =ne tavolinen " + cts;
        label.setText(data);
        
     
        }  
       });           
       }    
public static void main(String[] args) {    
    new ComboBoxExample();         
}    
}    
