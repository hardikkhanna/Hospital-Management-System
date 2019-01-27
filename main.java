import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class doctor extends JFrame implements ActionListener
{
	JButton b1,b2;
	JLabel l1,background;
	doctor()
	{
		setLayout(new BorderLayout());
		background=new JLabel(new ImageIcon("C:\\Users\\khann\\Desktop\\java\\core\\newwindows.png"));
		add(background);
		background.setLayout(null);
		
		//setLayout(null);
		b1=new JButton("Login");
		b2=new JButton("Register");
		l1=new JLabel("Registration Page");
		background.add(l1);
		background.add(b1);
		background.add(b2);
		l1.setBounds(new Rectangle(135,0,250,30));
		b1.setBounds(new Rectangle(70,50,100,30));
		b2.setBounds(new Rectangle(190,50,100,30));
		//l1.setOpaque(true);
		l1.setFont(new Font("Serif", Font.BOLD, 20));
		l1.setForeground(Color.BLUE);	 
		b1.addActionListener(this);
		b2.addActionListener(this);
		//l1.addActionListener(this);
			
	}	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			login l= new login();
			l.setVisible(true);
			l.setSize(400,400);
		}
		else
		{
			register r=new register();
			r.setVisible(true);
			r.setSize(500,500);
		}
	}
public static void main(String[] arg)
{
	doctor d=new doctor();
	d.setVisible(true);
	d.setSize(400,400);
	d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}