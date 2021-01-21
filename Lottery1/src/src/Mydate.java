package src;

import java.io.Serializable;
import java.util.*;
public class Mydate implements Serializable{
int day,month,year;
static int month_days[]={31,28,31,30,31,30,31,31,30,31,30,31};
public String toString()
{
	return (Integer.toString(day)+"/"+Integer.toString(month)+"/"+Integer.toString(year));
}
void create()
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter day month year");
	this.day=sc.nextInt();this.month=sc.nextInt();
	this.year=sc.nextInt();
}
int find(Mydate ob)
{
	if(ob.year<=3)return 0;
	else return (ob.year/4)-(ob.year/100)+(ob.year/400);
}
int finddays(Mydate ob)
{
	int days=0;
	days=ob.day;
	for(int i=0;i<ob.month;i++)
	{
		days+=month_days[i];
	}
	return days+find(ob)+365*ob.year;
}

int calculateDifference(Mydate d1,Mydate d2)
{
	return (finddays(d1)-finddays(d2));
}
}

