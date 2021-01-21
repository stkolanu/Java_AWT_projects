
package src;

import java.io.Serializable;

public class User implements Serializable
    {
    	String userid,PASSWORD;int rupees;int paise;
    	int hr,min,sec;
    	int rollhr,rollmin,rollsec;
    	Mydate d,rd;
    	
    	User()
    	{
    		
    	}
    	User(String userid,String PASSWORD)
    	{
    		d=new Mydate();
        	rd=new Mydate();
    		
        	this.d.year=900;this.d.day=1;this.d.month=1;this.rd.day=1;this.rd.month=1;this.rd.year=900;
    		this.userid=userid;this.PASSWORD=PASSWORD;this.paise=20;this.rupees=0;
    	}
    	public void lastLogin(int hr,int min,int sec,Mydate today)
    	{
    		this.hr=hr;this.min=min;this.sec=sec;this.d=today;
    	}
    	public void lastRolled(int hr,int min,int sec,Mydate d)
    	{
    		this.rollhr=hr;this.rollmin=min;this.rollsec=sec;this.rd=d;
    	}
    	public boolean isRollable(int hour,int minute,int second,Mydate today)
    	{
    		if(rd.calculateDifference(today,rd)>=1)return true;
    		else if(rd.calculateDifference(today,rd)==0)
    		{
    		if(hour-rollhr>1)
    		{
    			return true;
    		}
    		else if(hour-rollhr==1&&minute>rollmin)
    		{
    			return true;
    		}
    		return false;
    		}
    		return false;
    	}
    	public void addForLogin(int hour,int minute,int second,Mydate today)
    	{
    		int total=MainClass.current.rupees*100+MainClass.current.paise;
			total+=20;
			
    		if(d.calculateDifference(today,d)>=1)
    			{
    			MainClass.current.rupees=total/100;
    			MainClass.current.paise=total%100;
    			}
    		else if(d.calculateDifference(today,d)==0)
    		{
    	
    		if(hour-hr>1)
    		{
    			MainClass.current.rupees=total/100;
    			MainClass.current.paise=total%100;
    		}
    		else if(hour-hr==1&&minute>min)
    		{
    			MainClass.current.rupees=total/100;
    			MainClass.current.paise=total%100;
    		}
    	}
    	}
    }
  