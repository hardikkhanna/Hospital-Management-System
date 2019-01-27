import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;	
import java.awt.event.*;
class login extends JFrame implements ActionListener
{
	JLabel u,p,background,t;
	JTextField t1,t2;
	Choice c;
	JButton b1,b2;
	login()
	{
		setLayout(new BorderLayout());
		background=new JLabel(new ImageIcon("C:\\Users\\khann\\Desktop\\java\\newwindows.png"));
		add(background);
		background.setLayout(null);
		u=new JLabel("Username");
		p=new JLabel("Password");
		t1=new JTextField(20);
		t2=new JPasswordField(20);
		b1=new JButton("Login");
		b2=new JButton("Cancel");
		//t=new JLabel("Type");
		//c=new Choice();
		//c.add("Patient");
		//c.add("Doctor");
		background.add(u);
		background.add(t1);
		background.add(p);
		background.add(t2);
		//background.add(t);
		//background.add(c);
		background.add(b1);	
		background.add(b2);
		//c.addItemListener(this);
		t1.addActionListener(this);
		t2.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		u.setBounds(new Rectangle(20,40,150,20));
		p.setBounds(new Rectangle(20,80,150,20));
		t1.setBounds(new Rectangle(80,40,150,20));
		t2.setBounds(new Rectangle(80,80,150,20));
		//t.setBounds(new Rectangle(80,120,30,30));
		//c.setBounds(new Rectangle(120,120,100,20));
		b1.setBounds(new Rectangle(40,120,80,30));
		b2.setBounds(new Rectangle(160,120,80,30));
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String s1="admin";
			String s2="admin";
			conn g1 = new conn();

      			String qry = "select  type  from  doctor where username='"+t1.getText()+"' and password='"+t2.getText()+"' ";
    			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql:///doctor", "root", "");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(qry);
				String sw=rs.getString("type");		
				
				if(s1.equals(t1.getText()) && s1.equals(t2.getText()))
				{
					System.out.println(sw);
					admin d=new admin();
					d.setVisible(true);
					d.setSize(500,500);	
				}
				if(qry.equals("patient"))
				{
					System.out.println("patient");
				}	
				
			}catch(Exception e){}
		}
		else
		{
			this.dispose();
		}
	}
	/*public static void main(String arg[])
	{
		login gg=new login();
		gg.setVisible(true);
		gg.setSize(400,400);		
	}*/
	
}