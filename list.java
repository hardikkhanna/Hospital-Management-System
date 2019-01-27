import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class list extends JFrame implements ActionListener
{
	JTable t1;
	JButton b1;
	list()
	{
		setLayout(new BorderLayout());
		String h[]={"username","password","type","salary","address"};
       		String d[][]=new String [10][5];
		//b1=new JButton("Print");
		try{
		int i=0,j=0;
           	conn c=new conn();
            	ResultSet rs=c.execute("select * from doctor");
            	while(rs.next())
            	{
                d[i][j++]=rs.getString("username");
                d[i][j++]=rs.getString("password");
                d[i][j++]=rs.getString("type");
		d[i][j++]=rs.getString("salary");
		d[i][j++]=rs.getString("address");
                i++;
                j=0;
           	}
		t1=new JTable(d,h);
		JScrollPane js=new JScrollPane(t1,20,30);
            	add(js,BorderLayout.CENTER);
            	b1=new JButton("Print");
            	add(b1,BorderLayout.NORTH);
            	b1.addActionListener(this);
		}catch(Exception e){e.printStackTrace();}
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		try{t1.print();}catch(Exception e){}
	}
	/*public static void main(String arg[])
	{	
		list l=new list();
		l.setVisible(true);
		l.setSize(600,600);
	}*/
}