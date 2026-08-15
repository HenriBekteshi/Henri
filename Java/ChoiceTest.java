import java.awt.*;

import javax.swing.JFrame;
public class ChoiceTest extends Frame 
{
	public static void main(String[] args)
	{
		ChoiceTest x= new ChoiceTest();
		ChoiceTest y= new ChoiceTest();
	}
	ChoiceTest()
	{
		super("ChoiceTest");
		setSize(200,200);
		setLayout(new FlowLayout());
		Choice c1=new Choice();
		Choice c2=new Choice();
		c2.add("Kimi");
		c2.add("Fizik");
		c2.add("Gjuhe");
		c1.add("ChoiceA");
		c1.add("ChoiceB");
		c1.add("ChoiceC");
	add(c1);
	add(c2);
	show();
		
	}
}
