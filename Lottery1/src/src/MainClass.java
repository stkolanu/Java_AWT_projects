package src;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
   class MainClass1 extends Frame implements ActionListener,ItemListener{
	Button b1,b2,rb1;
	TextField t1,pt1,pt2,jt1,rt1;
	Label l1,pl1,j1;
	Panel main,playi,lot;
	Button panelb1,panelb2,pb1,pb2;
	TextArea panelta;
	TextField panelt1;
	Label panell1,panell2,head;
	Lottery ob;
	Checkbox c1,c2,c3,c4,rc1,rc2,rc3,rc4;
	CheckboxGroup cbg,cbg1;
	
	int lucky;
	CardLayout cd;
	MainClass1()
	{
		setLayout(null);
		
		
		head=new Label("Lottery");
		head.setFont(new Font(Font.DIALOG,Font.BOLD,24));
		head.setBounds(450,20,300,60);
		cbg1=new CheckboxGroup();
		rc4=new Checkbox();
		rc1=new Checkbox("1 - 50 ",false,cbg1);
		rc2=new Checkbox("51 - 100",false,cbg1);
		rc3=new Checkbox("101 - 500",false,cbg1);
		rc4=new Checkbox("501 - 1000",false,cbg1);
		rb1=new Button("ROLL Die");
		cbg1.setSelectedCheckbox(null);
		rt1=new TextField(50);
		rt1.setVisible(false);
		rt1.setBounds(570,380,300,25);
		rt1.setBackground(Color.red);
		rc1.setBackground(Color.yellow);
		rc2.setBackground(Color.yellow);
		rc3.setBackground(Color.yellow);
		rc4.setBackground(Color.yellow);
		rb1.setBackground(Color.LIGHT_GRAY);
		
		rc1.setBounds(600,110,90,25);
		rc2.setBounds(600,150,90,25);
		rc3.setBounds(600,190,90,25);
		rc4.setBounds(600,230,90,25);
		rb1.setBounds(570,280,90,25);
		
		
		cbg=new CheckboxGroup();
		c4=new Checkbox();
		c1=new Checkbox("1000",false,cbg);
		c2=new Checkbox("100",false,cbg);
		c3=new Checkbox("10",false,cbg);
		cbg.setSelectedCheckbox(null);
		j1=new Label("JACKPOT");
		j1.setBackground(Color.pink);
		jt1=new TextField(50);
		jt1.setVisible(false);
		j1.setBounds(760,140,80,25);
		c1.setBackground(Color.pink);
		c2.setBackground(Color.pink);
		c3.setBackground(Color.pink);
		c4.setBackground(Color.pink);
		
		c1.setBounds(830,180,60,25);
		c2.setBounds(830,220,60,25);
		c3.setBounds(830,260,60,25);
		c4.setBounds(850,140,30,25);
		jt1.setBounds(830,360,180,25);
		
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		c4.addItemListener(this);
		
		cd=new CardLayout(10,10);
		main=new Panel(cd);
		playi=new Panel();
		lot=new Panel();
		playi.setLayout(null);
		playi.setBackground(Color.BLUE);
		lot.setLayout(null);
		main.setBounds(100,200,1100,500);
		panelb1=new Button("HIGH");
		panelb2=new Button("LOW");
		pb1=new Button("/ 2");
		pb2=new Button("* 2");
		pt1=new TextField(50);
		pt2=new TextField(50);
		pt2.setBackground(Color.red);
		pt1.setText("20");
		pl1=new Label("BET");
		pl1.setBackground(Color.orange);
		panelb1.setBounds(250,200,50,30);
		panelb2.setBounds(310,200,50,30);
		pb1.setBounds(50,100,50,30);
		pb2.setBounds(110,100,50,30);
		pb1.setBackground(Color.orange);
		pb2.setBackground(Color.orange);
		pt1.setBounds(90,150,100,30);
		pt2.setBounds(30,250,200,30);
		pt2.setVisible(false);
		pl1.setBounds(30,150,50,30);
		panelta=new TextArea("",5,100,3);
		panelta.setBounds(250,100,200,60);
		
		panelt1=new TextField();
		panelt1.setBounds(400,250,100,30);
		
		panell1= new Label("PROFIT");
		panell2= new Label("LOSS");
		
		
		panell1.setBackground(Color.magenta);
		panell2.setBackground(Color.magenta);
		panell1.setBackground(Color.LIGHT_GRAY);
		panell2.setBackground(Color.LIGHT_GRAY);
		panell1.setBounds(240,250,100,30);
		panell2.setBounds(240,250,80,30);
		panell1.setVisible(false);
		panell2.setVisible(false);
		panelb1.setBackground(Color.cyan);
		panelb2.setBackground(Color.CYAN);
		Font f=new Font(Font.DIALOG,Font.ITALIC,14);
		playi.setFont(f);
		playi.add(panelb1);playi.add(panelb2);playi.add(panelta);playi.add(panelt1);playi.add(pl1);
		playi.add(panell1);playi.add(panell2);playi.add(pb1);playi.add(pb2);playi.add(pt1);
		playi.add(pt2);playi.add(c2);playi.add(c1);playi.add(c3);playi.add(c4);playi.add(j1);playi.add(jt1);
		playi.add(rc1);playi.add(rc2);playi.add(rc2);playi.add(rc3);playi.add(rc4);playi.add(rb1);playi.add(rt1);playi.add(head);
		panelb1.addActionListener(this);
		panelb2.addActionListener(this);
		pb1.addActionListener(this);
		pb2.addActionListener(this);
		rb1.addActionListener(this);
		
		ob=new Lottery();
		
		main.add(playi,"player");
		main.add(ob.lot,"lottery");
		l1=new Label("BALANCE");
		t1=new TextField(50);
		t1.setText(Integer.toString(MainClass.current.rupees)+"."+Integer.toString(MainClass.current.paise));
		t1.setBounds(920,50,100,30);
		l1.setBounds(830,50,80,30);
		Font fr=new Font(Font.DIALOG,Font.BOLD,18);
		b1=new Button("PLAY");
		b2=new Button("LOTTERY");
		b1.setFont(fr);
		b2.setFont(fr);
		b1.setBackground(Color.cyan);
		b2.setBackground(Color.cyan);
		b1.setBounds(250,120,200,40);
		b2.setBounds(570, 120,200, 40);
		add(b1);
		add(b2);
		add(main);
		add(t1);add(l1);
		b1.addActionListener(this);
		b2.addActionListener(this);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				setVisible(false);
			}
		});
		
	}
	
	
	public void itemStateChanged(ItemEvent e)
	{
		rt1.setVisible(false);
		jt1.setVisible(false);
		if(c4==e.getItemSelectable())
		{
			cbg.setSelectedCheckbox(null);
		}
		if(!c4.getState())
		{
			if(cbg.getSelectedCheckbox()!=null)
			{
				jt1.setVisible(true);
				jt1.setBackground(Color.red);
				jt1.setText("Jackpot must be checked first");
				cbg.setSelectedCheckbox(null);
			}
		}
		else
		{
			if(cbg.getSelectedCheckbox()==null)
			{
				jt1.setVisible(true);
				jt1.setBackground(Color.green);
				jt1.setText("SELECT A CHECK BOX");
				
			}
			if(cbg.getSelectedCheckbox()==c1)
			{
				if(MainClass.current.rupees<1000)
				{
					jt1.setVisible(true);
					jt1.setBackground(Color.red);
					jt1.setText("INSUFFICIENT BALANCE");
						
				}
			}
			if(cbg.getSelectedCheckbox()==c2)
			{
				if(MainClass.current.rupees<100)
				{
					jt1.setVisible(true);
					jt1.setBackground(Color.red);
					jt1.setText("INSUFFICIENT BALANCE");
						
				}
			}
			if(cbg.getSelectedCheckbox()==c3)
			{
				if(MainClass.current.rupees<10)
				{
					jt1.setVisible(true);
					jt1.setBackground(Color.red);
					jt1.setText("INSUFFICIENT BALANCE");
						
				}
			}

		}
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e)
	{

		pt2.setVisible(false);
		pt2.setText("");
	
		if(rb1==e.getSource())
		{
			c4.setState(false);
			jt1.setVisible(false);
			cbg.setSelectedCheckbox(null);
			rt1.setVisible(false);
			GregorianCalendar date=new GregorianCalendar();
			int hours=date.get(Calendar.HOUR);
			int minutes=date.get(Calendar.MINUTE);
			int seconds=date.get(Calendar.SECOND);
			int z=date.get(Calendar.AM_PM);
			Mydate mydate=new Mydate();
			mydate.day=date.get(Calendar.DAY_OF_MONTH);
			mydate.month=date.get(Calendar.MONTH);
			mydate.year=date.get(Calendar.YEAR);
			if(z==1)hours+=12;
			if(!MainClass.current.isRollable(hours, minutes, seconds,mydate))
			{
				rt1.setVisible(true);
				rt1.setBackground(Color.red);
				rt1.setText("PLEASE WAIT FOR SOMETIME");
				cbg1.setSelectedCheckbox(null);
			}
			else
			{
			MainClass.current.lastRolled(hours, minutes, seconds,mydate);
			rt1.setVisible(false);
			if(cbg1.getSelectedCheckbox()==null)
			{
				rt1.setVisible(true);
				rt1.setText("NUMBER MUST BE GUESSED");
			}
			else
			{
				Random ob=new Random();
			int temp =ob.nextInt(9);	
			int temp1 =ob.nextInt(9);	
			int temp2=ob.nextInt(9);	
			int roller=temp*temp1*temp2+1;
			
			if(cbg1.getSelectedCheckbox()==rc1)
			{
				rt1.setVisible(true);
				
				if(0<roller&&roller<=50)
				{
					rt1.setBackground(Color.green);
					rt1.setText("HURRAY!!! THE NUMBER IS "+roller);
					int total=MainClass.current.rupees*100+MainClass.current.paise;
					total+=20;
					MainClass.current.rupees=total/100;
					MainClass.current.paise=total%100;
				
				}
				else
				{
					rt1.setBackground(Color.RED);
					rt1.setText("OOPS!!! THE NUMBER IS "+roller);
					
				}
			}
			if(cbg1.getSelectedCheckbox()==rc2)
			{
				if(50<roller&&roller<=100)
				{
					rt1.setVisible(true);
					rt1.setBackground(Color.green);
					rt1.setText("HURRAY!!! THE NUMBER IS "+roller);
					int total=MainClass.current.rupees*100+MainClass.current.paise;
					total+=30;
					MainClass.current.rupees=total/100;
					MainClass.current.paise=total%100;
				
				}
				else
				{
					rt1.setVisible(true);
					rt1.setBackground(Color.RED);
					rt1.setText("OOPS!!! THE NUMBER IS "+roller);
					int total=MainClass.current.rupees*100+MainClass.current.paise;
					total+=50;
					MainClass.current.rupees=total/100;
					MainClass.current.paise=total%100;
				
				}
			}
			if(cbg1.getSelectedCheckbox()==rc3)
			{
				if(100<roller&&roller<=500)
				{
					rt1.setVisible(true);
					rt1.setBackground(Color.green);
					rt1.setText("HURRAY!!! THE NUMBER IS "+roller);
					int total=MainClass.current.rupees*100+MainClass.current.paise;
					total+=100;
					MainClass.current.rupees=total/100;
					MainClass.current.paise=total%100;
				
				}
				else
				{
					rt1.setVisible(true);rt1.setBackground(Color.RED);
					rt1.setText("OOPS!!! THE NUMBER IS "+roller);
					
				}
			}
			if(cbg1.getSelectedCheckbox()==rc4)
			{
				if(500<roller&&roller<=1000)
				{
					rt1.setVisible(true);
					rt1.setBackground(Color.green);
					rt1.setText("HURRAY!!! THE NUMBER IS "+roller);
					MainClass.current.rupees+=1;
				}
				else
				{
					rt1.setVisible(true);
					rt1.setBackground(Color.RED);
					rt1.setText("OOPS!!! THE NUMBER IS "+roller);
					
				}
			}
			t1.setText(Integer.toString(MainClass.current.rupees)+"."+Integer.toString(MainClass.current.paise));
			}
		}
		}
		if(b1==e.getSource())
		{
			c4.setState(false);
			jt1.setVisible(false);
			cbg.setSelectedCheckbox(null);
			
			rt1.setVisible(false);
			ob.lott1.setVisible(false);
			cd.show(main, "player");
			/*Play p=new Play();
			p.setSize(400,400);
			p.setVisible(true);
			p.setTitle("444 $$$");
			p.setBackground(Color.CYAN);
	*/
		}
		if(b2==e.getSource())
		{
			c4.setState(false);
			jt1.setVisible(false);
			cbg.setSelectedCheckbox(null);
			
			rt1.setVisible(false);
			cd.show(main, "lottery");
		
		/*	Lottery p=new Lottery();
			p.setSize(400,400);
			p.setVisible(true);
			p.setTitle("444 $$$");
			p.setBackground(Color.CYAN);
		*/
		}
		if(pb1==e.getSource())
		{
			c4.setState(false);
			jt1.setVisible(false);
			cbg.setSelectedCheckbox(null);
			
			rt1.setVisible(false);
			pt2.setVisible(false);
			int amt=0;
			if(pt1.getText().equals(""))amt=0;
			else
			{
				try
			{
				amt=Integer.parseInt(pt1.getText());
				if(amt<20||amt/2<20)
				{
					pt2.setVisible(true);
					pt2.setText("minimum 20 paise ");
				}
				else
				{
				pt2.setText("");	
				pt1.setText(Integer.toString(amt/2));
				}
			}
				catch(InputMismatchException e1)
				{
					pt2.setText("Invalid Input");
				}
			}
			}
		
		if(pb2==e.getSource())
		{
			c4.setState(false);
			jt1.setVisible(false);
			cbg.setSelectedCheckbox(null);
			
			rt1.setVisible(false);
			pt2.setVisible(false);
			
			int amt=0;
			if(pt1.getText().equals(""))amt=0;
			else
			{
				try
			{
				amt=Integer.parseInt(pt1.getText());
				if(amt<20)
				{
					pt2.setVisible(true);
					pt2.setText("minimum 20 paise ");
				}
				else
				pt1.setText(Integer.toString(amt*2));
			}
				catch(InputMismatchException e1)
				{
					pt2.setText("Invalid Input");
				}
			}
		}
		
		
		try
		{
		if(e.getSource()==panelb1)
		{
			
			rt1.setVisible(false);
			if(pt2.getText().equals(""))
			{
			if(Integer.parseInt(pt1.getText())>MainClass.current.rupees*100+MainClass.current.paise)
			{
				panelta.setText("Insufficient Funds");
			}
			else
			{
			int m;
			Random r=new Random();
			lucky=r.nextInt(1000);
			
			int bet=Integer.parseInt(pt1.getText());
		
			 if(lucky > 444)
			 {
				 if(c4.getState()&&!jt1.isVisible())
					{

						if(cbg.getSelectedCheckbox()==c1)
						{
							MainClass.current.rupees-=1000;
						}
						if(cbg.getSelectedCheckbox()==c2)
						{
							MainClass.current.rupees-=100;
						}
						if(cbg.getSelectedCheckbox()==c3)
						{
							MainClass.current.rupees-=10;
						}
					}
				if((panelt1.getText()).equals(""))m=0;
				else 
					{
					m=Integer.parseInt(panelt1.getText());
					}
				int total=MainClass.current.rupees*100+MainClass.current.paise;
				total+=bet;
				MainClass.current.rupees=total/100;
				MainClass.current.paise=total%100;
				t1.setText(Integer.toString(MainClass.current.rupees)+"."+Integer.toString(MainClass.current.paise));
				panelt1.setText(Integer.toString(m+bet));
				if(m+bet>=0)
				{
					panell1.setVisible(true);
					panell2.setVisible(false);
					panelt1.setBackground(Color.GREEN);
					}
				else
				{
					panell1.setVisible(false);
					panell2.setVisible(true);
					panelt1.setBackground(Color.RED);	
					panelta.setBackground(Color.GREEN);
				}
				panelta.setBackground(Color.GREEN);
				panelta.setText("Hurray,you won!!!\n the number is  "+Integer.toString(lucky));
				
			}
			else if(lucky < 444)
			{
				 if(c4.getState()&&!jt1.isVisible())
					{

						if(cbg.getSelectedCheckbox()==c1)
						{
							MainClass.current.rupees-=1000;
						}
						if(cbg.getSelectedCheckbox()==c2)
						{
							MainClass.current.rupees-=100;
						}
						if(cbg.getSelectedCheckbox()==c3)
						{
							MainClass.current.rupees-=10;
						}
					}
				 if((panelt1.getText()).equals(""))m=0;
				else {
					m=Integer.parseInt(panelt1.getText());
					}
				int total=MainClass.current.rupees*100+MainClass.current.paise;
				total-=bet;
				MainClass.current.rupees=total/100;
				MainClass.current.paise=total%100;
				
				t1.setText(Integer.toString(MainClass.current.rupees)+"."+Integer.toString(MainClass.current.paise));
				panelt1.setText(Integer.toString(m-bet));
				if(m-bet>=0)
					{
					panell1.setVisible(true);
					panell2.setVisible(false);
					panelt1.setBackground(Color.GREEN);
					}
					else
					{
						panell1.setVisible(false);
						panell2.setVisible(true);
						panelt1.setBackground(Color.RED);
					}
				panelta.setBackground(Color.RED);
				panelta.setText("OOPS!!!better luck next time\n the number is  "+Integer.toString(lucky));	
			}
			else 
			{
				if(c4.getState()&&!jt1.isVisible())
				{
					panelta.setBackground(Color.PINK);
					panelta.setText("Hurray,you won the Jackpot!!!"+Integer.toString(lucky));
					
					if(cbg.getSelectedCheckbox()==c1)
					{
						MainClass.current.rupees+=1000;
					}
					if(cbg.getSelectedCheckbox()==c2)
					{
						MainClass.current.rupees+=100;
					}
					if(cbg.getSelectedCheckbox()==c3)
					{
						MainClass.current.rupees+=10;
					}

				}
			}
		}
		}
		}
		if(e.getSource()==panelb2)
		{
			
			rt1.setVisible(false);
			if(pt2.getText().equals(""))
			{
				//System.out.println("hi bsj");
			if(Integer.parseInt(pt1.getText())>MainClass.current.rupees*100+MainClass.current.paise)
			{
				//System.out.println("hi 2.0");
				panelta.setVisible(true);
				panelta.setText("Insufficient Funds");
			}
			else
			{
			int m;
			Random r=new Random();
			lucky=r.nextInt(1000);
			//System.out.println("hi gorle");
			int bet=Integer.parseInt(pt1.getText());
		
			if(lucky < 444)
			{
				 if(c4.getState()&&!jt1.isVisible())
					{

						if(cbg.getSelectedCheckbox()==c1)
						{
							MainClass.current.rupees-=1000;
						}
						if(cbg.getSelectedCheckbox()==c2)
						{
							MainClass.current.rupees-=100;
						}
						if(cbg.getSelectedCheckbox()==c3)
						{
							MainClass.current.rupees-=10;
						}
					}
				if((panelt1.getText()).equals(""))m=0;
				else 
					{
					m=Integer.parseInt(panelt1.getText());
					}
				int total=MainClass.current.rupees*100+MainClass.current.paise;
				total+=bet;
				MainClass.current.rupees=total/100;
				MainClass.current.paise=total%100;
			t1.setText(Integer.toString(MainClass.current.rupees)+"."+Integer.toString(MainClass.current.paise));
				panelt1.setText(Integer.toString(m+bet));
				if(m+bet>=0)
				{
					panell1.setVisible(true);
					panell2.setVisible(false);
					panelt1.setBackground(Color.GREEN);
				}
				else
				{
					panell1.setVisible(false);
					panell2.setVisible(true);
					panelt1.setBackground(Color.RED);
				}
				panelta.setBackground(Color.green);
				panelta.setText("Hurray,you won!!!\n the number is  "+Integer.toString(lucky));
			}
			else if(lucky > 444)		 
			{
				 if(c4.getState()&&!jt1.isVisible())
					{

						if(cbg.getSelectedCheckbox()==c1)
						{
							MainClass.current.rupees-=1000;
						}
						if(cbg.getSelectedCheckbox()==c2)
						{
							MainClass.current.rupees-=100;
						}
						if(cbg.getSelectedCheckbox()==c3)
						{
							MainClass.current.rupees-=10;
						}
					}
				if((panelt1.getText()).equals(""))m=0;
				else 
					{
					m=Integer.parseInt(panelt1.getText());
					}
				int total=MainClass.current.rupees*100+MainClass.current.paise;
				total-=bet;
				MainClass.current.rupees=total/100;
				MainClass.current.paise=total%100;
				t1.setText(Integer.toString(MainClass.current.rupees)+"."+Integer.toString(MainClass.current.paise));

				panelt1.setText(Integer.toString(m-bet));
				if(m-bet>=0)
					{
					panell1.setVisible(true);
					panell2.setVisible(false);
					panelt1.setBackground(Color.GREEN);
					}
					else
					{
						panell1.setVisible(false);
						panell2.setVisible(true);
						panelt1.setBackground(Color.RED);
					}
				panelta.setBackground(Color.RED);
					
				panelta.setText("OOPS!!!better luck next time\n the number is  "+Integer.toString(lucky));	
			}
			else 
			{
				if(c4.getState()&&!jt1.isVisible())
				{

					panelta.setBackground(Color.PINK);
					panelta.setText("Hurray,you won the Jackpot!!!"+Integer.toString(lucky));
				
					if(cbg.getSelectedCheckbox()==c1)
					{
						MainClass.current.rupees+=1000;
					}
					if(cbg.getSelectedCheckbox()==c2)
					{
						MainClass.current.rupees+=100;
					}
					if(cbg.getSelectedCheckbox()==c3)
					{
						MainClass.current.rupees+=10;
					}
					
				}
			}
		}
	
	}

	}

		}
		catch(NumberFormatException er)
		{
			pt2.setVisible(true);
			pt2.setText("Input should be in paise");
		}
	
  }
    
}  
    
    
    class MainClass extends Frame implements ActionListener
    {
    Label l1,l2;
    TextField t1,t2,t3;Button b1,b2,b3;
    MainClass()
    {
    	l1=new Label("USER ID");
    	l2=new Label("PASSWORD");
    	l1.setBackground(Color.CYAN);
    	l2.setBackground(Color.CYAN);
    	setLayout(null);
    	t1=new TextField(50);
    	t2=new TextField(50);
    	t3=new TextField(40);
    	t3.setBounds(50, 150,180, 30);
    	t3.setBackground(Color.RED);
    	t2.setEchoChar('*');t3.setVisible(false);
    	l1.setBounds(50,50,80,30);
    	l2.setBounds(50,100,80,30);
    	t1.setBounds(150,50,100,30);
    	t2.setBounds(150,100,100,30);
    	b1=new Button("LOG IN");b2=new Button("CANCEL");
    	b3=new Button("NEW USER REGISTER HERE");
    	b1.setBackground(Color.cyan);
    	b2.setBackground(Color.cyan);
    	b3.setBackground(Color.cyan);
    	b1.setBounds(50,200,80,30);
    	b2.setBounds(150,200,80,30);
    	b3.setBounds(100,300,180,30);
    	add(l1);add(t1);add(l2);add(t2);add(b1);add(b2);add(b3);add(t3);

    b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);
    addWindowListener(new WindowAdapter()
    {
    public void windowClosing(WindowEvent e)
    {
    	try {
			MainClass.write();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
		Lottery.write();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
    		draw.write();
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
        	
    	System.exit(0);
    }});
    }
    static ArrayList<User> ab=new ArrayList<User> ();

static void read()throws IOException
{
	FileInputStream fin=new FileInputStream("user.txt");
	ObjectInputStream oin=new ObjectInputStream(fin);
	
	try
	{
		User e;
	while((e=(User)oin.readObject())!=null)
	{
		MainClass.ab.add(e);
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
	
	Object ia[]=MainClass.ab.toArray();
	FileOutputStream fos=new FileOutputStream("user.txt",false);
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
	static User current=new User();
    public void actionPerformed(ActionEvent e)
    {
    if(b1==e.getSource())
    {
    	t3.setVisible(false);
    	t3.setText("");
    String s1=t1.getText();
    String s2=t2.getText();
    Object ia[]=ab.toArray();
	for(int i=0;i<ia.length;i++)
	{  User u=(User)ia[i];
		
		if(s1.equals(u.userid)&&s2.equals(u.PASSWORD))
		{
			t3.setBackground(Color.green);
			MainClass.current=u; 	
		t3.setText("Logged in Successfully");	
		GregorianCalendar date=new GregorianCalendar();
		int hours=date.get(Calendar.HOUR);
		int minutes=date.get(Calendar.MINUTE);
		int seconds=date.get(Calendar.SECOND);
		int z=date.get(Calendar.AM_PM);
		if(z==1)hours+=12;
		//System.out.println(current.hr);
		Mydate mydate=new Mydate();
		mydate.day=date.get(Calendar.DAY_OF_MONTH);
		mydate.month=date.get(Calendar.MONTH);
		mydate.year=date.get(Calendar.YEAR);
		
		current.addForLogin(hours, minutes, seconds,mydate);
		current.lastLogin(hours, minutes, seconds,mydate);
		MainClass1 c=new MainClass1();c.setVisible(true);c.setSize(1250,750);
	    c.setTitle("CASINO ROYALE");c.setBackground(Color.GREEN);
	    break;
		}
	}
    if((t3.getText()).equals("Logged in Successfully"));
    else 
    	{
    	t3.setBackground(Color.red);
    	t3.setText("invalid userid or PASSWORD");
    	}
    	t3.setVisible(true);
    	}
    if(b2==e.getSource()){System.exit(0);}
    
    if(b3==e.getSource())
    {
    	t3.setVisible(false);
    	Register c=new Register();c.setVisible(true);c.setSize(300,400);
        c.setTitle("REGISTER PORTAL");c.setBackground(Color.orange);
        	
    }
    }
    
    public static void main(String args[])
    {
    	try {
			MainClass.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
    	try {
			Lottery.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
    	try {
			draw.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
    MainClass c=new MainClass();c.setVisible(true);c.setSize(500,500);
    c.setTitle("LOGIN PaGe");c.setBackground(Color.cyan);
    }
    
    
    
    }
        