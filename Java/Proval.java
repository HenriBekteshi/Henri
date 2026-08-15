
import java.awt.*;
public class Proval
{
public static void main(String[]args)
{
	Frame f=new Frame();
	f.setLayout(new FlowLayout());
	f.setLocation(100,100);
	
	f.add(new Button("po shtype ket button bohesh pro ne fortnite"));
	f.add(new Button("po shtype ket button bohesh milioner"));
	f.add(new TextField("po shtype ket textfield bohesh shoku  i rames"));
	f.add(new TextField("po shtype ket textfield rrezohet qeveria rama"));
	
	f.pack();
	f.show();
	
}
}
