import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class CopyExamp extends Frame implements ActionListener {
	Button b;
	Label l1,l2,intro;
	TextField t1,t2;
	CopyExamp(){
		intro=new Label("This AWT Frame is About Copying Text:");
		intro.setBackground(Color.cyan);
		b=new Button("Copy");
		t1=new TextField();
		t2=new TextField();
		t1.setFont(new Font("plain",Font.BOLD,18));
		t2.setFont(new Font("plain",Font.BOLD,18));
		l1=new Label("Text 1");
		l1.setBackground(Color.cyan);
		l2=new Label("Text 2");
		l2.setBackground(Color.cyan);
		intro.setFont(new Font("bold",Font.BOLD,20));
		intro.setBounds(10, 50, 500, 25);
		l1.setBounds(150, 100, 150, 50);
		t1.setBounds(300, 100, 150, 50);
		l2.setBounds(150, 170, 150, 50);
		t2.setBounds(300, 170, 150, 50);
		b.setBounds(225, 240, 150, 50);
		b.setBackground(Color.RED);
		add(intro);
		add(l1);add(l2);
		add(t1);
		add(t2);
		add(b);
		setLayout(null);
		b.addActionListener(this);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
	}
	public void actionPerformed(ActionEvent e){
		if(b==e.getSource()){
			String s=t1.getText();
			t2.setText(s);
		}
		
	}
	public static void main(String args[]){
	CopyExamp c=new CopyExamp();
	c.setTitle("COPY FRAME");
	c.setVisible(true);
	c.setSize(500, 500);
	c.setBackground(Color.cyan);
	}

}
