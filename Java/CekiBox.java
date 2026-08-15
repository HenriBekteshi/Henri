import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CekiBox extends JFrame implements ItemListener
{

	final int Birre=200;
	final int Raki=400;
	final int Cola=300;
	final int Frapucino=150;	
	int totalPrice=0;
	 JCheckBox birreBox= new JCheckBox
			 ("Mengjes"+Birre,false);
	 JCheckBox rakiBox=new  JCheckBox
			 ("Dreke"+Raki,false);
	 JCheckBox colaBox=new JCheckBox
			 ("Darke"+Cola,false);
	 JCheckBox frapucinoBox=new JCheckBox
			 ("Snack"+Frapucino,false);
	 
	 
	 JLabel resotLabel=new JLabel
			 ("Restoranti");
	 JLabel ePrice= new JLabel("The price for you are:");
	 JTextField totPrice=new JTextField(4);
	 JLabel optionExplainLabel2= new JLabel
			 ("Check the options you want");
	 public CekiBox()
	 {
		 super("Restoranti");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setLayout(new FlowLayout());
		add(resotLabel);
		 add(optionExplainLabel2);
		 add(optionExplainLabel2);
		 add(birreBox);
		 add(rakiBox);
		 add(colaBox);
		 add(frapucinoBox);
		 add(totPrice);
	
		 birreBox.addItemListener(this);
		 rakiBox.addItemListener(this);
		 colaBox.addItemListener(this);
		 
		 frapucinoBox.addItemListener(this);
		 show();
		 setSize(400,400);
	 }
	public void itemStateChanged(ItemEvent event) 
	{
	Object source=event.getSource();
	int select=event.getStateChange();
	if(source== birreBox)
		if(select==ItemEvent.SELECTED)
			totalPrice+=Birre;
		else
			totalPrice-=Birre;
	if(source== rakiBox)
      	{
		if(select==ItemEvent.SELECTED)
			totalPrice+=Raki;
		else
			totalPrice-=Raki;
     	}
	else  if(source== colaBox)
		if(select==ItemEvent.SELECTED)
			totalPrice+=Cola;
		else
			totalPrice-=Cola;

	 if(source== frapucinoBox)
   	   {
		if(select==ItemEvent.SELECTED)
			totalPrice+=Frapucino;
		else
			totalPrice-=Frapucino;
   	    }
	 totPrice.setText("$"+totalPrice);
	}	 
	
			 
}