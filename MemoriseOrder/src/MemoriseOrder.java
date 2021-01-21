import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class MemoriseOrder extends Frame implements ActionListener,Runnable {
	
	Button b[];
	
	MemoriseOrder()
	{
		setLayout(null);
		b=new Button[30];
		for(int i=0;i<30;i++)
			b[i]=new Button();
		for(int i=0;i<30;i++)
			b[i].setBackground(Color.cyan);
		
		b[0].setBounds(40, 100, 50, 50);
		b[1].setBounds(90, 100, 50, 50);
		b[2].setBounds(140, 100, 50, 50);
		b[3].setBounds(190, 100, 50, 50);
		b[4].setBounds(240, 100, 50, 50);
		b[5].setBounds(40, 150, 50, 50);
		b[6].setBounds(90, 150, 50, 50);
		b[7].setBounds(140, 150, 50, 50);
		b[8].setBounds(190, 150, 50, 50);
		b[9].setBounds(240, 150, 50, 50);
		b[10].setBounds(40, 200, 50, 50);
		b[11].setBounds(90, 200, 50, 50);
		b[12].setBounds(140, 200, 50, 50);
		b[13].setBounds(190, 200, 50, 50);
		b[14].setBounds(240, 200, 50, 50);
		b[15].setBounds(40, 250, 50, 50);
		b[16].setBounds(90, 250, 50, 50);
		b[17].setBounds(140, 250, 50, 50);
		b[18].setBounds(190, 250, 50, 50);
		b[19].setBounds(240, 250, 50, 50);
		b[20].setBounds(40, 300, 50, 50);
		b[21].setBounds(90, 300, 50, 50);
		b[22].setBounds(140, 300, 50, 50);
		b[23].setBounds(190, 300, 50, 50);
		b[24].setBounds(240, 300, 50, 50);
		b[25].setBounds(40, 350, 50, 50);
		b[26].setBounds(90, 350, 50, 50);
		b[27].setBounds(140, 350, 50, 50);
		b[28].setBounds(190, 350, 50, 50);
		b[29].setBounds(240, 350, 50, 50);
		for(int i=0;i<30;i++)
			add(b[i]);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	
	}
	
	public void run(){
		firstFrame();
		randomColor();
		introductionFrame();
		this.setVisible(false);
		//goNextFrame();
	}
	void firstFrame(){
	firstFrame ff=new firstFrame();
	
	}	
	void introductionFrame(){
		introFrame iff=new introFrame();
		iff.setTitle("Introduction Frame");
		iff.setSize(500, 500);
		iff.setVisible(true);
		
		
	}
	void goNextFrame()
	{
		nextFrame nf=new nextFrame();
		nf.setTitle("Answer Frame");
		nf.setSize(500, 500);
		nf.setVisible(true);
		this.setVisible(false);
	}
	
	void randomColor()
	{
		Random r=new Random();
		for(int i=0;i<5;i++)
		{
		int k=r.nextInt(30);
		try{
		Thread.sleep(500);
		}
		catch(Exception er){
			
		}
		b[k].setBackground(Color.red);
		}
		try{
			Thread.sleep(250);
		}
		catch(Exception e){
			
		}
	}
	
	
	public void actionPerformed(ActionEvent e){}
	public static void main(String args[])
	{
		
		MemoriseOrder mo=new MemoriseOrder();
		mo.setTitle("Memorise Order");
		mo.setSize(500, 500);
		mo.setVisible(true);
		mo.setBackground(Color.white);
		Thread t1=new Thread(mo);
		t1.start();
	}

}
class firstFrame extends Frame implements ActionListener{
	Label l,itro;Button b;
	firstFrame(){
		itro=new Label("THIS IS A GAME ON MEMORISING THE ORDER");
		l=new Label("Press Start when ready");
		b=new Button("Start:");
		itro.setBounds(200, 200, 200, 50);
		l.setBounds(200, 350, 200, 50);
		b.setBounds(200, 500, 60, 60);
		add(itro);add(l);add(b);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e){
}
class introFrame extends Frame implements ActionListener{
	Label l;
	Button b;
	introFrame(){
		setLayout(null);
		l=new Label("Now press ready button to play");
		b=new Button("READY");
		l.setBounds(200, 200, 150, 50);
		b.setBounds(200, 250, 100, 50);
		add(l);add(b);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(){
				System.exit(0);
			}
		});
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		new MemoriseOrder().goNextFrame();
		this.setVisible(false);
	}
	
}
class nextFrame extends Frame{
	Button b[];
	nextFrame(){
		setLayout(null);
		b=new Button[30];
		for(int i=0;i<30;i++)
			b[i]=new Button();
		for(int i=0;i<30;i++)
			b[i].setBackground(Color.cyan);
		
		b[0].setBounds(40, 100, 50, 50);
		b[1].setBounds(90, 100, 50, 50);
		b[2].setBounds(140, 100, 50, 50);
		b[3].setBounds(190, 100, 50, 50);
		b[4].setBounds(240, 100, 50, 50);
		b[5].setBounds(40, 150, 50, 50);
		b[6].setBounds(90, 150, 50, 50);
		b[7].setBounds(140, 150, 50, 50);
		b[8].setBounds(190, 150, 50, 50);
		b[9].setBounds(240, 150, 50, 50);
		b[10].setBounds(40, 200, 50, 50);
		b[11].setBounds(90, 200, 50, 50);
		b[12].setBounds(140, 200, 50, 50);
		b[13].setBounds(190, 200, 50, 50);
		b[14].setBounds(240, 200, 50, 50);
		b[15].setBounds(40, 250, 50, 50);
		b[16].setBounds(90, 250, 50, 50);
		b[17].setBounds(140, 250, 50, 50);
		b[18].setBounds(190, 250, 50, 50);
		b[19].setBounds(240, 250, 50, 50);
		b[20].setBounds(40, 300, 50, 50);
		b[21].setBounds(90, 300, 50, 50);
		b[22].setBounds(140, 300, 50, 50);
		b[23].setBounds(190, 300, 50, 50);
		b[24].setBounds(240, 300, 50, 50);
		b[25].setBounds(40, 350, 50, 50);
		b[26].setBounds(90, 350, 50, 50);
		b[27].setBounds(140, 350, 50, 50);
		b[28].setBounds(190, 350, 50, 50);
		b[29].setBounds(240, 350, 50, 50);
		for(int i=0;i<30;i++)
			add(b[i]);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}
