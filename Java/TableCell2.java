import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TableCell2 extends JFrame implements ActionListener{
	
    JTable table;
   JPanel   PANEL =new JPanel();
int a,c,e;
double b,d,f,gi,hi,hihi;

    JLabel lx = new JLabel("Alvin        ");
    
    JLabel ly= new JLabel("nota 1");
    JTextField aaa= new JTextField("",10);
    JLabel oo= new JLabel("nota 2");
    JTextField bbb= new JTextField("",10);
    JLabel mm = new JLabel("Ariola    ");
    JLabel rrr= new JLabel("nota 1");
    JTextField ccc= new JTextField("",10);
    JLabel r= new JLabel("nota 2");
    JTextField ddd= new JTextField("",10);
    JLabel mmm = new JLabel("Andrea");
    JLabel k= new JLabel("nota 1");
    JTextField eee= new JTextField("",10);
    JLabel u= new JLabel("nota 2");
    JTextField fff= new JTextField("",10);
    JButton b1=new JButton("llogarit");
    public TableCell2(){
    	 
{  	
    	setLayout(new FlowLayout());
        setSize(100,350);
        add(lx);
        
        add(ly);
        //add(y);
        add(aaa);
        add(oo);
        add(bbb);
        add(mm);
        add(rrr);
        add(ccc);
        add(r);
        add(ddd);
        add(mmm);
        add(k);
        add(eee);
        add(u);
        add(fff);
        add(b1);

        b1.addActionListener(this);
        setVisible(true);
  }
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	Vector<String> rowOne = new Vector<String>();
    	rowOne.addElement("Alvin");
        rowOne.addElement("");
        rowOne.addElement("");
        rowOne.addElement("mesatarja");
        
        Vector<String> rowTwo = new Vector<String>();
        rowTwo.addElement("Ariola");
        rowTwo.addElement("");
        rowTwo.addElement("");
        rowTwo.addElement("mesatarja");
        
        Vector<String> rowThree = new Vector<String>();
        rowThree.addElement("Andrea");
        rowThree.addElement("");
        rowThree.addElement("");
        rowThree.addElement("mesatarja");
        
        Vector<Vector> rowData = new Vector<Vector>();
        rowData.addElement(rowOne);
   	 rowData.addElement(rowTwo);
   	 rowData.addElement(rowThree);
        
        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("nxensi");
        columnNames.addElement("nota 1");
        columnNames.addElement("nota 2");
        columnNames.addElement("mesatarja");
        table = new JTable(rowData,columnNames );
     
        




        JScrollPane scrollPane = new JScrollPane(table);
       PANEL.add(scrollPane);
        add(PANEL, BorderLayout.SOUTH);
        setSize(400, 150);
        setVisible(true);
        
	}
	
	public void actionPerformed(ActionEvent arg0) {

		String as= aaa.getText();
		String bs= bbb.getText();
		int ai=Integer.parseInt(as);
		double bi=Double.valueOf(bs);
		String cs= ccc.getText();
		String ds= ddd.getText();
		int ci=Integer.parseInt(cs);
		double di=Double.valueOf(ds);
		String es= eee.getText();
		String fs= fff.getText();
		int ei=Integer.parseInt(es);
		double fi=Double.valueOf(fs);
		double gi =(ai+bi)/2;
		double hi =(ci+di)/2;
		double hihi =(ei+fi)/2;
		
		int bii=(int)bi;
        int dii=(int)di;
        int fii=(int)fi;
		
		table.setValueAt(""+ai, 0, 1); 
		table.setValueAt(""+bii, 0, 2); 
		table.setValueAt(""+ci, 1, 1);
		table.setValueAt(""+dii, 1, 2); 
		table.setValueAt(""+ei, 2, 1); 
		table.setValueAt(""+fii, 2, 2);
		
		
		table.setValueAt(""+gi, 0, 3); 
		table.setValueAt(""+hi, 1, 3); 
		table.setValueAt(""+hihi, 2, 3);
		
	}
	
	
	  public static void main(String []args){
		  TableCell2 vvvvv= new  TableCell2();
	    }
}
