package src;

import java.awt.*;
import java.awt.event.*;

public class Register extends Frame implements ActionListener{

Label l1,l2,l3;
TextField t1,t2,t3,t4;
Button b1,b2;
Register()
{
	l1=new Label("USER ID");
	l2=new Label("PASSWORD");
	l3=new Label("CONFIRM");
	l1.setBackground(Color.CYAN);
	l2.setBackground(Color.CYAN);
	l3.setBackground(Color.CYAN);
	
	setLayout(null);
	t1=new TextField(50);
	t2=new TextField(50);
	t3=new TextField(40);
	t4=new TextField(40);
	t4.setBounds(150, 190,100, 30);
	t3.setBounds(50, 250,180, 30);
	t3.setBackground(Color.RED);
	t2.setEchoChar('*');t4.setEchoChar('*');t3.setVisible(false);
	l1.setBounds(50,50,80,30);
	l2.setBounds(50,120,80,30);
	l3.setBounds(50,190,80,30);
	
	t1.setBounds(150,50,100,30);
	t2.setBounds(150,120,100,30);
	b1=new Button("REGISTER");b2=new Button("CANCEL");
	b1.setBackground(Color.CYAN);
	b2.setBackground(Color.cyan);
	b1.setBounds(50,300,80,30);
	b2.setBounds(150,300,80,30);
	add(l1);add(t1);add(l2);add(t2);add(b1);add(b2);add(t3);add(t4);add(l3);

b1.addActionListener(this);b2.addActionListener(this);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e)
{
	setVisible(false);
}});
}
static String[] userid={"JAGADEESH","VENU","VARMA","VIJAY","PRABHAKAR"};
static String[] PASSWORD={"14INDIA","GOPAL07","DHONI4EVER","ARPSTEN","JAGANNATH"};
public void actionPerformed(ActionEvent e)
{
if(b1==e.getSource())
{
	t3.setVisible(false);
String s1=t1.getText();
String s2=t2.getText();
String s3=t4.getText();
User u=null;
if(t1.getText().equals("")||t2.getText().equals("")||t4.getText().equals(""))
{
	t3.setText("Fields Cannot Be empty");
	t3.setVisible(true);
}
else if(!t2.getText().equals(t4.getText()))
{
	t3.setText("PASSWORDS DIDN'T MATCH");
	t3.setVisible(true);
}
else
{
u=new User(s1,s2);
boolean fine =true;
Object ia[]=MainClass.ab.toArray();
for(int i=0;i<ia.length;i++)
{
	User u1=(User) ia[i];
	if(u.userid.equals(u1.userid)&&u.PASSWORD.equals(u1.PASSWORD))
	{
		t3.setBackground(Color.red);
		t3.setText("Already Registered");
		t3.setVisible(true);
		fine=false;
		break;
	}
		
}
if(fine)
{
MainClass.ab.add(u);
t3.setBackground(Color.green);
t3.setText("REGISTERED SUCCESSFULLY");
t3.setVisible(true);
}
}
}
if(b2==e.getSource())
{
	this.setVisible(false);
}
}
}
