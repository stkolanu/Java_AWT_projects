import java.awt.*;
import java.awt.event.*;
public class ScientificCalci extends Frame implements ActionListener{
	
	Button b[];
	TextArea res;
	ScientificCalci()
	{
		b=new Button[30];
		res=new TextArea();
		int i=0;
		for(i=0;i<10;i++)
		{
			b[i]=new Button(Integer.toString(i));
		}
		b[10]=new Button("+");
		b[11]=new Button("-");
		b[12]=new Button("*");
		b[13]=new Button("/");
		b[14]=new Button(".");
		b[15]=new Button("(");
		b[16]=new Button(")");
		b[17]=new Button("=");
		b[18]=new Button("pi");
		b[19]=new Button("n!");
		b[20]=new Button("+/-");
		b[21]=new Button("Sin");
		b[22]=new Button("Cos");
		b[23]=new Button("Tan");
		b[24]=new Button("Log");
		b[25]=new Button("Bin");
		b[26]=new Button("Hex");
		b[27]=new Button("Oct");
		b[28]=new Button("CHNG");
		b[29]=new Button("<-");
		setLayout(new GridBagLayout());
		
		add(res);
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=5;
		gbc.gridwidth=2;
		gbc.gridheight=2;
		add(b[0],gbc);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	public void actionPerformed(){
		
	}
	public static void main(String args[]){
		ScientificCalci sc=new ScientificCalci();
		sc.setTitle("ScientificCalculator");
		sc.setSize(500, 900);
		sc.setVisible(true);
	}
}
