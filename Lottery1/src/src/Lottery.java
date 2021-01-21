
package src;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Random;
import java.io.*;
class setTime implements Runnable
{
	int z=0;
	public void run()
	{
	while(z<1000)
	{
		
		GregorianCalendar date=new GregorianCalendar();
	int hours=date.get(Calendar.HOUR);
	int minutes=date.get(Calendar.MINUTE);
	int seconds=date.get(Calendar.SECOND);
	int z=date.get(Calendar.AM_PM);
	if(z==1)hours+=12;
	hours=2-hours%3;
	minutes=59-minutes;
	seconds=60-seconds;
	
	if(seconds==59&&minutes==59&&hours==2)
	{
		
		//System.out.println("hi BSJ");
		draw ob=new draw();
		Thread t2=new Thread(ob);
		t2.run();
	}
	Lottery.lotta.setForeground(Color.BLACK);
	Lottery.lotta.setText(hours+":"+minutes+":"+seconds);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	run();
	}
	}

}
class draw implements Runnable
{
	static  String []winners={"saiteja","Chandu","phaneendar"};
	
static void read()throws IOException
{
	
	FileReader fos=new FileReader("winners.txt");
	BufferedReader oos=new BufferedReader(fos);
	
	try
	{
		String line=oos.readLine();
		int i=0;
		while(line!=null&&i<3)
		{
	//	winners[i]=line;
	//	System.out.println(line);
		i++;
		line=oos.readLine();
		}	
	}
	catch(EOFException e)
	{
		
	}
	
	finally
	{
		oos.close();
	}
}
static void write() throws IOException
{
	
	FileWriter fos=new FileWriter("winners.txt",false);
	BufferedWriter oos=new BufferedWriter(fos);
	
	try
	{
	
	for(int j=0;j<3;j++)
	{
	//	oos.write(winners[j]);
		oos.newLine();
	}
	oos.close();
	}
	catch(EOFException e)
	{
		
	}
	catch(Exception e)
	{
	}
	finally
	{
		oos.close();
	}
}

	public void run()
	{
		Random r=new Random();
		Object ia[]=Lottery.participants.toArray();
		Object ol[]=MainClass.ab.toArray();
		int []h=new int[3];
		if(ia.length>3)
		{
	
			ArrayList<Integer> list=new ArrayList<Integer>();
			for(int j=1;j<ia.length;j++)
			{
				list.add(new Integer(j));
			}
			Collections.shuffle(list);
		h[0]=list.get(0);
		h[1]=list.get(1);
		h[2]=list.get(2);;
			
	//	System.out.println(h[0]+" "+h[1]+" "+h[2] );
		
		for(int i=0;i<ia.length;i++)
		{
			User u=(User) ia[i];
			if(i==h[0])
			{
				winners[0]=u.userid;
				
				for(int j=0;j<ol.length;j++)
				{  User u1=(User)ol[j];
					if(u.userid.equals(u1.userid))
					{
						u1.rupees*=3;
						MainClass.ab.add(j, u1);
						break;
					}
				}
			    
			}
			if(i==h[1])
			{
				winners[1]=u.userid;
				for(int j=0;j<ol.length;j++)
				{  User u1=(User)ol[j];
					if(u.userid.equals(u1.userid))
					{
						u1.rupees*=2;
						MainClass.ab.add(j, u1);
						break;
					}
				}
			}
			if(i==h[2])
			{
				winners[2]=u.userid;
				for(int j=0;j<ol.length;j++)
				{  User u1=(User)ol[j];
					if(u.userid.equals(u1.userid))
					{
						u1.rupees*=1.5;
						MainClass.ab.add(j, u1);
						break;
					}
				}
			}
			Lottery.participants.clear();
		}
	}
	}
}
class Lottery extends Frame implements ActionListener
{
	Panel lot;
	static TextArea lotta;
	Button lotb1,lotb2;
	TextField lott1;
	  static ArrayList<User> participants=new ArrayList<User> ();

static void read()throws IOException
{
	FileInputStream fin=new FileInputStream("participate.txt");
	ObjectInputStream oin=new ObjectInputStream(fin);
	
	try
	{
		User e;
	while((e=(User)oin.readObject())!=null)
	{
		//System.out.println("hi2");
		Lottery.participants.add(e);
	}
	}
	catch(EOFException e)
	{
		
	} 
	catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	finally
	{
		oin.close();
	}
}
static void write() throws IOException
{
	
	Object ia[]=Lottery.participants.toArray();
	FileOutputStream fos=new FileOutputStream("participate.txt",false);
	ObjectOutputStream oos=new ObjectOutputStream(fos);
	
	try
	{
	
	for(int j=0;j<ia.length;j++)
	{
		//System.out.println("hi");
		User a=(User)ia[j];
		oos.writeObject(a);
		oos.flush();
	}
	oos.close();
	}
	catch(EOFException e)
	{
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	finally
	{
		oos.close();
	}
}

Lottery()
{
	setLayout(null);
	lot=new Panel();
	lot.setLayout(null);
	lotb1=new Button("REGISTER");
	lotb2=new Button("WINNERS");
	lotta=new TextArea("",5,150,3);
	lotta.setBounds(100,100,370,140);
	lott1=new TextField(50);
	lott1.setBackground(Color.red);
	lott1.setBounds(650,200,200,40);
	lott1.setVisible(false);
	lotb1.setBounds(650,250,200,60);
	lotb1.setBackground(Color.orange);
	lotb1.addActionListener(this);
	lotb2.setBounds(650,350,200,60);
	lotb2.setBackground(Color.orange);
	lotb2.addActionListener(this);
	Font fr=new Font(Font.DIALOG,Font.BOLD,20);
	lotb1.setFont(fr);
	lotb2.setFont(fr);
	fr=new Font(Font.DIALOG,Font.BOLD,18);
	lott1.setFont(fr);
	add(lotb1);add(lott1);add(lotb2);
	lot.add(lotb1);lot.add(lott1);lot.add(lotb2);
	lot.setBackground(Color.ORANGE);
	lotb1.setBackground(Color.cyan);
	lotb2.setBackground(Color.cyan);
	addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent e)
		{
			setVisible(false);
		}
	});
	lot.add(lotta);
	lotta.setFont(new Font(Font.DIALOG,Font.BOLD,100));
	setTime ob1=new setTime();
	Thread t1=new Thread(ob1);
	t1.start();
	
	
}
public void actionPerformed(ActionEvent e)
{
	boolean fine=true;
	if(lotb1==e.getSource())
	{
		Object ia[]=Lottery.participants.toArray();
		for(int i=0;i<ia.length;i++)
		{
			User u=(User) ia[i];
			if(MainClass.current.userid.equals(u.userid))
			{
				lott1.setText("Already Registered");
				lott1.setVisible(true);
				fine=false;
			}
				
		}
		if(fine)participants.add(MainClass.current);
	}
	if(lotb2==e.getSource())
	{
		winners ob=new winners();
		ob.setVisible(true);
	}
}
}
class winners extends Frame
{
	winners()
	{
		setLayout(null);
		setSize(400,400);
		setBackground(Color.LIGHT_GRAY);
		setTitle("WINNERS");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				setVisible(false);
			}
		});
		repaint();	
	}
	public void paint(Graphics g)
	{
		g.setFont(new Font(Font.DIALOG,Font.ITALIC,18));
		int i,j,k;
		Random r=new Random();
		
		g.drawString("1.  "+draw.winners[0], 100, 100);
		g.drawString("2.  "+draw.winners[1], 100, 200);
		g.drawString("3.  "+draw.winners[2], 100, 300);
	}
}