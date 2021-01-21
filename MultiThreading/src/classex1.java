
class Producer extends Thread{
	StringBuilder sb;
	String s;
	consumer c;
	Producer()
	{
	}
	void Producer1(consumer co)
	{
		sb=new StringBuilder();
		this.c=co;
	}
	public void run()
	{
		for(int k=0;k<100;k++){
		System.out.println("Producer");	
		
		synchronized(sb)
		{
			for(int i=0;i<=10;i++){
				sb.append(i+":");
				try{
					Thread.sleep(100);
				}
				catch(Exception e){
				}
			}
			sb.notify();
		}
		
		synchronized(c.sbc){
			try{
				c.sbc.wait();
			}
			catch(Exception e){}
			System.out.println("Consumer consumed product\n"+c.sbc);
		}
		
	}
		
	}
}
class consumer extends Thread{
	Producer pr;
	StringBuilder sbc;
	consumer(Producer pr){
		this.pr=pr;
		sbc=new StringBuilder();
	}
	
	public void run()
	{	
		for(int k=0;k<100;k++){
			System.out.println("Consumer");
			
		synchronized(pr.sb)
		{
			try{
			pr.sb.wait();
			}
			catch(Exception e){}
			
			System.out.println("Producer produced product\n"+pr.sb);
		}
		
		synchronized(sbc)
		{
			for(int i=0;i<=10;i++){
			sbc.append(i+":");
			try
			{
				Thread.sleep(100);	
			}catch(Exception e){}
			}
			sbc.notify();
		}
	}
	}
}

public class classex1 
{
		public static void main(String args[])
		{
			Producer p=new Producer();
			consumer c=new consumer(p);
			p.Producer1(c);
			Thread t1=new Thread(p);
			Thread t2=new Thread(c);
			t1.start();
			t2.start();
		}
}