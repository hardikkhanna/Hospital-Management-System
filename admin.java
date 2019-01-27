import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class admin extends JFrame implements ActionListener
{
	admin(){
	MenuBar mb=new MenuBar();   
   	setMenuBar(mb);
	Menu file=new Menu("UserMenu");
	mb.add(file);
	MenuItem u1=new MenuItem("update");
	MenuItem u2=new MenuItem("delete");
	MenuItem u3=new MenuItem("list");
	file.add(u1);
	file.add(u2);
	file.add(u3);
	Menu file1=new Menu("Doctor");
	mb.add(file1);	
	MenuItem d1=new MenuItem("clear");
	MenuItem d2=new MenuItem("modify");
	file1.add(d1);
	file1.add(d2);
	u1.addActionListener(this);
	u2.addActionListener(this);
	u3.addActionListener(this);
	d1.addActionListener(this);
	d2.addActionListener(this);
	
	//Menu file2=new Menu("");
	}
	

	public void actionPerformed(ActionEvent e)
	{	
		String msg=e.getActionCommand();
		//System.out.println(msg);
		if(msg.equals("update"))
		{
			update up=new update();
			up.setSize(600,600);
			up.setVisible(true);
			
			
		}
		if(msg.equals("delete"))
		{
			delete d=new delete();
			d.setVisible(true);
			d.setSize(500,500);
		}
		if(msg.equals("list"))
		{
			list l=new list();
			l.setSize(500,500);
			l.setVisible(true);
		}
		 if(msg.equals("clear"))
		{
			
		}	
		else 
		{
			
		}
	
	}
	


public static void main(String arg[])
{
	admin d=new admin();
		d.setVisible(true);
		d.setSize(500,500);
	
}}