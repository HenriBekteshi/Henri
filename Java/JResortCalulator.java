import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JResortCalulator  extends JFrame implements ItemListener
{
	final int BASE_PRICE=200;
	final int WEEKEND_PREMIUM=100;
	final int BREAKFAST_PREMIUM=20;
	final int GOLF_PERMIUM=75;
	final int BOAT_TRAVEL=30;	
	int totalPrice=BASE_PRICE;
	 JCheckBox weekendBox= new JCheckBox
			 ("Weekend premium $"+WEEKEND_PREMIUM,false);
	 JCheckBox breakfastBox=new  JCheckBox
			 ("Breakfast premium $"+BREAKFAST_PREMIUM,false);
	 JCheckBox golfBox=new JCheckBox
			 ("Boat $"+BOAT_TRAVEL,false);
	 JCheckBox boatBox=new JCheckBox
			 ("Boat $"+BOAT_TRAVEL,false);
	 
	 
	 JLabel resotLabel=new JLabel
			 ("Resort Price Calulator");
	 JLabel ePrice= new JLabel("The price for your stay is");
	 JTextField totPrice=new JTextField(4);
	 JLabel optionExplainLabel2= new JLabel
			 ("Check the options you want");
	 public JResortCalulator()
	 {
		 super("Resort Price Estimator");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setLayout(new FlowLayout());
		add(resotLabel);
		 add(optionExplainLabel2);
		 add(optionExplainLabel2);
		 add(weekendBox);
		 add(breakfastBox);
		 add(golfBox);
		 add(boatBox);
		 add(totPrice);
		 totPrice.setText("$"+totalPrice);
		 weekendBox.addItemListener(this);
		 breakfastBox.addItemListener(this);
		 golfBox.addItemListener(this);
	 }
	public void itemStateChanged(ItemEvent event) 
	{
	Object source=event.getSource();
	int select=event.getStateChange();
	if(source== weekendBox)
		if(select==ItemEvent.SELECTED)
			totalPrice+=WEEKEND_PREMIUM;
		else
			totalPrice-=WEEKEND_PREMIUM;
	if(source== breakfastBox)
      	{
		if(select==ItemEvent.SELECTED)
			totalPrice+=BREAKFAST_PREMIUM;
		else
			totalPrice-=BREAKFAST_PREMIUM;
     	}
	else // if(source== golfBox) by default
		if(select==ItemEvent.SELECTED)
			totalPrice+=GOLF_PERMIUM;
		else
			totalPrice-=GOLF_PERMIUM;
	 totPrice.setText("$"+totalPrice);
	 if(source== boatBox)
   	   {
		if(select==ItemEvent.SELECTED)
			totalPrice+=BOAT_TRAVEL;
		else
			totalPrice-=BOAT_TRAVEL;
   	    }
	}	 
	public static void main(String[] args)
	{
		JResortCalulator aFrame=
				new JResortCalulator();
		final int WIDTH=300;
		final int HEIGHT=200;
		aFrame.setSize(WIDTH,HEIGHT);
		aFrame.setVisible(true);
		
		
	}
			 
}
