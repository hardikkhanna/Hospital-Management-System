import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class doctor extends JFrame implements ActionListener
{
	doctor()
	{
		setLayout(new FlowLayout());
		JMenuBar mb=new JMenuBar();
		setMenuBar(mb);
		Menu file=new Menu();
		MenuItem i1=new MenuItem("Open");
		MenuItem i2=new MwnuItem("Delete");
		MenuItem i3=new MenuItem("Save");
		file.add(i1);
		file.add(i2);
		file.add(i3);
		gb
	}
	public static void main(String[] arg)
	{	
		doctor d=new doctor();
		d.setVissible(true);
		d.setSize(500,500);
	}
}