import java.applet.*;
import java.awt.*;
public class Bullseye extends Applet
{
public void paint(Graphics g)
  {
int appletHeight=this.getSize().height;
int appletWidth=this.getSize().width;

Graphics2D g2=(Graphics2D)g;
for(int i=8;i>=0;i--)
       {
if((i%2)==0)
	g2.setColor(Color.green);
    else 
    	g2.setColor(Color.red);
  int rectHeight=appletHeight*i/8;
  int rectWidth=appletWidth*i/8;
  int rectLeft=appletWidth/2-i*appletWidth/16;
  int rectTop=appletHeight/2-i*appletHeight/16;
  g2.fillOval(rectLeft,rectTop,rectWidth,rectHeight);
       }
   }

}
