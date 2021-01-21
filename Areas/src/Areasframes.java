import java.awt.*;
import java.awt.event.*;
public class Areasframes extends Frame implements ActionListener {
	Button b1,b2,b3;
	Areasframes(){
		setLayout(null);
		b1=new Button("Triangle");
		b2=new Button("Square");
		b3=new Button("Rectangle");
		b1.setBounds(100, 100, 100, 100);
		b2.setBounds(200, 100, 100, 100);
		b3.setBounds(150, 200, 100, 100);
		add(b1);add(b2);add(b3);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		b1.setBackground(Color.white);
		b2.setBackground(Color.white);
		b3.setBackground(Color.white);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e){
		if(b1==e.getSource()){
			TriangleFrame tf=new TriangleFrame();
			tf.setTitle("Triangle Area");
			tf.setSize(500,500);
			tf.setVisible(true);
			tf.setBackground(Color.red);
		}
		if(b2==e.getSource()){
			SquareFrame sf=new SquareFrame();
			sf.setTitle("Square Area");
			sf.setSize(500,500);
			sf.setVisible(true);
			sf.setBackground(Color.cyan);
		}
		if(b3==e.getSource()){
			RectangleFrame rf=new RectangleFrame();
			rf.setTitle("Rectangle Area");
			rf.setSize(500,500);
			rf.setVisible(true);
			rf.setBackground(Color.yellow);
		}
		
	}
	public static void main(String args[]){
		Areasframes af=new Areasframes();
		af.setTitle("Areas of figures");
		af.setVisible(true);
		af.setSize(500,500);
		af.setBackground(Color.GREEN);
	}

}
class TriangleFrame extends Frame implements ActionListener{
	TextField t1,t2,t3;
	Label l1,l2,l3;
	Button b1;
	void visible(){
		this.setVisible(false);
	}
	TriangleFrame(){
		setLayout(null);
		l1=new Label("Base of triangle:");
		l2=new Label("Height of triangle:");
		l3=new Label("Area is:");
		l1.setBackground(Color.red);
		l2.setBackground(Color.red);
		l3.setBackground(Color.red);
	t1=new TextField();
	t2=new TextField();
	t3=new TextField();
	b1=new Button("Find Area");
	l1.setBounds(40, 100, 100, 100);
	t1.setBounds(140, 100, 100, 100);
	l2.setBounds(40, 200, 100, 100);
	t2.setBounds(140, 200, 100, 100);
	b1.setBounds(90, 400, 100, 100);
	t3.setBounds(190,300,100,100);
	l3.setBounds(90, 300,100, 100);

	add(t1);add(t2);add(l1);add(l2);add(b1);add(l3);add(t3);
	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			visible();
		}
	});
	b1.addActionListener(this);
	
	}
	public void actionPerformed(ActionEvent e){
		
		double b=Double.parseDouble(t1.getText());
		double h=Double.parseDouble(t2.getText());
		double res=(b*h)/2;
		t3.setText(Double.toString(res));
	}
	
}
class RectangleFrame extends Frame implements ActionListener{
	Label l1,l2,l3;
	TextField t1,t2,t3;
	Button b1;
	void visible(){
		this.setVisible(false);
	}
	RectangleFrame(){
		setLayout(null);
		l1=new Label("Length of rectangle");
		l2=new Label("Height of rectangle");
		t1=new TextField();
		t2=new TextField();
		b1=new Button("Area");
		l3=new Label("Area is:");
		t3=new TextField();
		l1.setBackground(Color.cyan);
		l2.setBackground(Color.cyan);
		l3.setBackground(Color.cyan);
		l1.setBounds(30, 100, 105, 100);
		t1.setBounds(140, 100, 100, 100);
		l2.setBounds(30, 200, 105, 100);
		t2.setBounds(140, 200, 100, 100);
		b1.setBounds(190, 400, 100, 100);
		t3.setBounds(190,300,100,100);
		l3.setBounds(80, 300,105, 100);
		add(l1);add(l2);add(l3);add(t1);add(t2);add(t3);add(b1);
		b1.addActionListener(this);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				visible();
			}
		});
		
	}
	public void actionPerformed(ActionEvent e){
		double l=Double.parseDouble(t1.getText());
		double b=Double.parseDouble(t2.getText());
		double res=l*b;
		t3.setText(Double.toString(res));
	}
}

class SquareFrame extends Frame implements ActionListener{
	Button b1;
	TextField t1,t2;
	Label l1,l2;
	void visible(){
		this.setVisible(false);
	}
	SquareFrame(){
		setLayout(null);
		l1=new Label("side of square");
		l2=new Label("Area");
		t1=new TextField();
		t2=new TextField();
		b1=new Button("ARea");
		l1.setBackground(Color.green);
		l2.setBackground(Color.green);
		l1.setBounds(40, 100, 100, 100);
		t1.setBounds(140, 100, 100, 100);
		l2.setBounds(40, 200, 100, 100);
		t2.setBounds(140, 200, 100, 100);
		b1.setBounds(90, 300, 100, 100);
		add(b1);add(t1);add(t2);add(l1);add(l2);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				visible();
			}
		});
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		double s=Double.parseDouble(t1.getText());
		double res=s*s;
		t2.setText(Double.toString(res));
	}
}