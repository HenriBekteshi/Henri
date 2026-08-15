
import javax.swing.*;
public class Calculator
{
public static void main(String[]args)
{
	String x;
	String y;
	 String v;
	 int r=0;
	x=JOptionPane.showInputDialog("sa eshte x");
	v=JOptionPane.showInputDialog("cili eshte veprimi");
	y=JOptionPane.showInputDialog("sa eshte y");
	int xi=Integer.parseInt(x);
	int yi=Integer.parseInt(y);
	if(v.equals("+"))
		r=xi+yi;
	else
		if(v.equals("*"))
			r=xi*yi;
		else
			if(v.equals("-"))
				r=xi-yi;
			else
				if(v.equals("/"))
					r=xi/yi;
	JOptionPane.showMessageDialog(null,""+r);
			
}
}
