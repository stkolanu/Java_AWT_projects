
import java.awt.*;
import java.awt.event.*;
class RupeetoDollar extends Frame implements ActionListener{
     TextField t1,t2,t3;
	Button b1;
	Label l1,l2,l3,b;
	RupeetoDollar()
	{
		t1=new TextField();
		t2=new TextField();
		t3=new TextField();
		b=new Label("In Dollars:");
                b1=new Button("Convert to Dollars");
		l1=new Label("one Dollar=");
		l2=new Label("Rupees:");
		l3=new Label("Rupees");
		l1.setBounds(10,45,80,30);
		b1.setBackground(Color.red);
                t1.setBounds(90,50,50,20);
                l3.setBounds(150,50,50,20);
                l2.setBounds(30,65,60,30);
                t2.setBounds(90,70,50,20);
                b.setBounds(15,90,70,20);
                b1.setBounds(100,130,120,20);
                t3.setBounds(90,90,50,20);
                l1.setBackground(Color.cyan);
                l2.setBackground(Color.cyan);
                l3.setBackground(Color.cyan);
                b.setBackground(Color.cyan);
                setLayout(null);
                add(l1);
                add(t1);
                add(l2);
                add(t2);
                add(b1);
                add(b);
                add(l3);
             add(t3);
                b1.addActionListener(this);
                addWindowListener(new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        System.exit(0);
                    }
                });   
	}
        public void actionPerformed(ActionEvent e)
        {
            
            if(b1==e.getSource())
            {
                if(t1.getText().length()>0)
                {
                	if(t2.getText().length()>0)
                	{
                		double d=Double.parseDouble(t1.getText());
                		double r=Double.parseDouble(t2.getText());
                		double dr=r/d;
                		t3.setText(String.valueOf(dr));
                	}
            }
            else
            {
            	t3.setText("0");
            	t2.setText("0");  
            }
        }
            }
    public static void main(String[] args) {  
         RupeetoDollar tv=new RupeetoDollar();
         tv.setTitle("RupeeToDollar");
            tv.setSize(300,300);
            tv.setVisible(true);
            tv.setBackground(Color.cyan);
    }
}
