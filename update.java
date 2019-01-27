import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class update extends JFrame implements ActionListener,ItemListener
{
	Choice c1;
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5,background;
	JButton b1,b2;
	update()
	{
	setLayout(new BorderLayout());
	background=new JLabel(new ImageIcon("C:\\Users\\khann\\Desktop\\java\\newwindows.png"));
	add(background);
	background.setLayout(null);
	l1=new JLabel("Username");
	l2=new JLabel("Password");
	l3=new JLabel("type");	
	l4=new JLabel("salary");
	l5=new JLabel("address");
	c1=new Choice();
	t2=new JPasswordField(20);
	t3=new JTextField(15);
	t4=new JTextField(15);
	t5=new JTextField(15);
	b1=new JButton("Update");
	b2=new JButton("Cancel");
	background.add(l1);
	background.add(c1);
	background.add(l2);
	background.add(t2);
	background.add(l3);
	background.add(t3);
	background.add(l4);
	background.add(t4);
	background.add(l5);
	background.add(t5);	
	background.add(b1);
	background.add(b2);
	try
        {
            conn k1=new conn();
            ResultSet rs=k1.execute("select * from doctor");
            while(rs.next())
            {
                c1.add(rs.getString("username"));
            }
        }catch(Exception e){}	
	
	c1.addItemListener(this);
	t2.addActionListener(this);
	t3.addActionListener(this);
	t4.addActionListener(this);
	t5.addActionListener(this);
	b1.addActionListener(this);
	b2.addActionListener(this);
	l1.setBounds(new Rectangle(30,50,100,50));
	c1.setBounds(new Rectangle(140,65,100,20));
	l2.setBounds(new Rectangle(30,80,150,50));
	t2.setBounds(new Rectangle(140,95,150,20));
	l3.setBounds(new Rectangle(30,110,150,50));
	t3.setBounds(new Rectangle(140,125,150,20));
	l4.setBounds(new Rectangle(30,140,150,50));	
	t4.setBounds(new Rectangle(140,155,150,20));
	l5.setBounds(new Rectangle(30,180,80,40));
	t5.setBounds(new Rectangle(140,190,100,20));
	b1.setBounds(new Rectangle(70,280,100,30));
	b2.setBounds(new Rectangle(200,280,100,30));
	}
	public void actionPerformed(ActionEvent ae)
	{	
		if(ae.getSource()==b1){
		String t=c1.getSelectedItem();
		//System.out.println(t);
		String q="update doctor set password='"+t2.getText()+"',type='"+t3.getText()+"',salary='"+t4.getText()+"',address='"+t5.getText()+"' where username='"+t+"'";
		System.out.println(q);
		try{
        		conn c=new conn();
        		c.update(q);
       		 }catch(Exception e){}      
        
        JOptionPane.showMessageDialog(null, "Account updated");
	}
	else
	{
		this.dispose();
	}
	}
	
	public void itemStateChanged(ItemEvent ae)	
	{
		String t=c1.getSelectedItem();
		System.out.println(t);
        String q="select * from doctor where username='"+t+"'";
       
        try{
            conn c=new conn();
            ResultSet rs=c.execute(q);
            if(rs.next())
            {
                t1.setText(rs.getString("password"));
		t2.setText(rs.getString("type"));
		t3.setText(rs.getString("salary"));
		t4.setText(rs.getString("address"));
            }
        }catch(Exception  e){}
	}
	public static void main(String arg[])
	{
		update u=new update();
		u.setVisible(true);
		u.setSize(400,400);
	}

}