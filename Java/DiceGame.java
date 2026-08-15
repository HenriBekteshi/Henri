import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class LojeZarash extends JFrame implements ActionListener{
	 Random r=new Random();
	   int an=r.nextInt(5)+1;
	   int bn=r.nextInt(5)+1;
	   String as=Integer.toString(an);
	      String bs=Integer.toString(bn);
	      
	      
	      JLabel a=new JLabel( new ImageIcon(as.concat(".png")));
	      JLabel b=new JLabel( new ImageIcon(bs.concat(".png")));
	      JButton z= new JButton("Ndrysho Zarat");
	      
	      public LojeZarash(){
	    	  setLayout( new FlowLayout());
	    	  setSize(800,200);
	    	  add(a);
	    	  add(b);
	    	  add(z);
	    	  setVisible(true);
	      }
		public void actionPerformed(ActionEvent arg0) {
			LojeZarash z	=new LojeZarash();
			dispose();
		}
		public static void main(String[]args){
			LojeZarash z	=new LojeZarash();		}
}
