import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class delete extends JFrame implements ActionListener,ItemListener
{
	JButton b1,b2;
	JLabel background;
	Choice c;
	delete()
	{
		setLayout(new BorderLayout());
		background=new JLabel(new ImageIcon("C:\\Users\\khann\\Desktop\\java\\newwindows.png"));
		add(background);
		background.setLayout(new FlowLayout());
		c=new Choice();
		b1=new JButton("Delete");
		b2=new JButton("Cancel");
		background.add(c);
		background.add(b1);	
		background.add(b2);
		background.add(b2);
		try{
			conn k=new conn();
			ResultSet rs=k.execute("select * from doctor");
			while(rs.next())
			{
				c.add(rs.getString("username"));
			}
		}catch(Exception e){}
		c.addItemListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);		
	}
	public void actionPerformed(ActionEvent ae)
	{
		//System.out.println("heelo");

		if(ae.getSource()==b1)
		{
			String t=c.getSelectedItem();
			//System.out.println(t);
			String q="delete from doctor where username='"+t+"'";
			try{
				conn c=new conn();
				c.update(q);
				
			}catch(Exception e){e.printStackTrace();}
			JOptionPane.showMessageDialog(null, "Account deleted");
		}
		else
		{
			this.dispose();
		}
	}
	public void itemStateChanged(ItemEvent ae)
	{
		
	}
	public static void main(String arg[])
	{
		delete d=new delete();
		d.setSize(500,500);
		d.setVisible(true); 	
	}

}
