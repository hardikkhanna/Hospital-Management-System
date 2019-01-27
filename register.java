import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class register extends JFrame implements ActionListener,ItemListener
{
	JLabel l1,l2,l3,l4,l5,background;
	JTextField t1,t2,t3,t4,t5;
	Choice c;
	JButton b1,b2;
	JRadioButton r1,r2;
	JLabel l6;
	
	register()
	{
		setLayout(new BorderLayout());
		background=new JLabel(new ImageIcon("C:\\Users\\khann\\Desktop\\java\\newwindows.png"));
		add(background);
		background.setLayout(null);
		l6=new JLabel("Salary");
		r1=new JRadioButton("Male");
		r2=new JRadioButton("Female");
		b1=new JButton("Register");
		b2=new JButton("Cancel");
		l1=new JLabel("Username");
		l2=new JLabel("Password");
		l3=new JLabel("Address");
		l4=new JLabel("Type");
		l5=new JLabel("Confirm Password");
		t4=new JPasswordField(20);
		t5=new JTextField(20);
		t1=new JTextField(20);
		t2=new JPasswordField(20);
		t3=new JTextField(20);
		//bg = new ButtonGroup();
		c=new Choice();
		c.add("Patient");
		c.add("Doctor");
		background.add(l1);
		background.add(t1);
		background.add(l2);
		background.add(t2);
		background.add(l5);
		background.add(t4);
		background.add(l3);
		background.add(t3);
		background.add(l4);
		background.add(c);
		background.add(l6);
		background.add(t5);
		background.add(b1);
		background.add(b2);
		l1.setBounds(new Rectangle(30,50,150,50));
		t1.setBounds(new Rectangle(140,65,150,20));
		l2.setBounds(new Rectangle(30,80,150,50));
		t2.setBounds(new Rectangle(140,95,150,20));
		l5.setBounds(new Rectangle(30,110,150,50));
		t4.setBounds(new Rectangle(140,125,150,20));
		l3.setBounds(new Rectangle(30,140,150,50));
		t3.setBounds(new Rectangle(140,155,150,20));
		l4.setBounds(new Rectangle(30,180,40,40));
		c.setBounds(new Rectangle(140,190,75,20));
		l6.setBounds(new Rectangle(30,210,55,55));
		t5.setBounds(new Rectangle(140,230,150,20));
		//r2.setBounds(new Rectangle());
		b1.setBounds(new Rectangle(70,280,100,30));
		b2.setBounds(new Rectangle(200,280,100,30));
		t1.addActionListener(this);
		t2.addActionListener(this);
		t3.addActionListener(this);
		r1.addActionListener(this);
		r2.addActionListener(this);
		c.addItemListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s3=c.getItem(c.getSelectedIndex());
		String s1=t2.getText();
		String s2=t4.getText();
		String s4=t5.getText();
		float num1;
		if(ae.getSource()==b1 && s1.equals(s2))
		{
			try {
       num1=Float.parseFloat(s4);

    } catch (NumberFormatException e) {
        JOptionPane.showConfirmDialog(null, "Please enter numbers only", "naughty", JOptionPane.CANCEL_OPTION);
    }
			try

   			{

			  String username=t1.getText();
			  if(username==""){JOptionPane.showMessageDialog(null,"username cant be left empty");
			}
			   
			   else{
			   
   	int r=JOptionPane.showConfirmDialog(this,"Are you sure?");  
				if(r==JOptionPane.YES_OPTION){
				conn g1 = new conn();

      				String qry = "insert into doctor(username,password,type,salary,address) values('"+t1.getText()+"' ,'"+t2.getText()+"','"+s3+"','"+t5.getText()+"','"+ t3.getText() +"' ) ";
 
    				g1.update(qry);

				JOptionPane.showMessageDialog(this,"Signup successfull");}

    				t1.setText("");

    				t2.setText("");

    				t3.setText("");

    				t4.setText("");

   				t1.requestFocus();}


			}catch(Exception e) {
 				t1.setText(""+e);
			}
		}
		else if(ae.getSource()==b2)
		{
			this.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Incorrect Password.Retry Again!","WARNING",JOptionPane.WARNING_MESSAGE);
		}
	}
	public void itemStateChanged(ItemEvent ae)
	{
		String value=c.getSelectedItem().toString();
		//System.out.println("Gello");
		conn g1 = new conn();

      		String qry = "insert into doctor(type) values('"+value+"' ) ";
 
    		g1.update(qry);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public  static  void  main(String sp[])
	{
		
		
		 register kk=new  register();
		 
		 kk.setVisible(true);
	}
	
	
	
	
	
	
	
	
}