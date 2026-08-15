import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JFrameWithPanel extends JFrame implements ActionListener
{

private final int WIDTH = 250;
private final int HEIGHT = 120;
private JButton button1 = new JButton("One");
private JButton button2 = new JButton("Two");
private JButton button3 = new JButton("Three");
private JButton button4 = new JButton("Four");
JPanel panel1 = new JPanel();
JPanel panel2 = new JPanel();
JPanel panel3 = new JPanel();

public JFrameWithPanel()
{
super("JFrame with Panel");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Container con = getContentPane();
con.setLayout(new FlowLayout());
con.add(panel1);
con.add(panel2);
con.add(panel2);
con.add(panel3);
panel1.add(button1);
panel1.setBackground(Color.BLUE);
button1.addActionListener(this); 
button2.addActionListener(this); 
button3.addActionListener(this); 
button4.addActionListener(this); 
panel2.add(button2);
panel2.add(button3);
panel3.add(button4);
panel2.setBackground(Color.BLUE);
panel3.setBackground(Color.yellow);
setSize(WIDTH, HEIGHT);
}
public void actionPerformed(ActionEvent e)
{
	Object bur=e.getSource();
	if(bur==button1){
		panel1.setBackground(Color.BLUE);
		panel2.setBackground(Color.BLACK);
		panel3.setBackground(Color.yellow);
	}
if(bur==button2){
	panel1.setBackground(Color.RED);
	panel2.setBackground(Color.GREEN);
	panel3.setBackground(Color.yellow);
	}
if(bur==button3){
	panel1.setBackground(Color.YELLOW);
	panel2.setBackground(Color.WHITE);
	panel3.setBackground(Color.ORANGE);
}
if(bur==button4){
	panel1.setBackground(Color.CYAN);
	panel2.setBackground(Color.PINK);
	panel3.setBackground(Color.LIGHT_GRAY);
}
}
public static void main(String[]ards)
{
	JFrameWithPanel frame = new JFrameWithPanel();
	frame.setVisible(true);
	}


}
