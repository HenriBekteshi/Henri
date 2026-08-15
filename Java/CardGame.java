import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class LojeLetra extends JFrame implements ActionListener{
   Random r=new Random();
   int an=r.nextInt(58);
   int bn=r.nextInt(58);
   int cn=r.nextInt(58);
   int dn=r.nextInt(58);
   int en=r.nextInt(58);
      String as=Integer.toString(an);
      String bs=Integer.toString(bn);
      String cs=Integer.toString(cn);
      String ds=Integer.toString(dn);
      String es=Integer.toString(en);
      
      JLabel a=new JLabel( new ImageIcon(as.concat(".png")));
      JLabel b=new JLabel( new ImageIcon(bs.concat(".png")));
      JLabel c=new JLabel( new ImageIcon(cs.concat(".png")));
      JLabel d=new JLabel( new ImageIcon(ds.concat(".png")));
      JLabel e=new JLabel( new ImageIcon(es.concat(".png")));
	
      public LojeLetra(){
    	  setLayout( new FlowLayout());
    	  setSize(800,200);
    	  add(a);
    	  add(b);
    	  add(c);
    	  add(d);
    	  add(e);
    	  setVisible(true);
      }
      
	public void actionPerformed(ActionEvent e) {
			
	}
	public static void main(String[]args){
		LojeLetra z = new LojeLetra();
	}




}
	
