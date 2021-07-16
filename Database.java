import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;
public class Database {
	static Map <Integer, My> mp= new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		My m1 = new My("100","shifa",2000.0);
		My m2 = new My("200","zara",2900.0);
		My m3 = new My("300","aadil",21000.0);
		mp.put(1, m1);
		mp.put(2, m2);
		mp.put(3, m3);
		System.out.println(mp.keySet());
		CRUD c1 = new CRUD();
		while(true)
		{
			System.out.println("1.insert the record\n2.removing the record\n3.updating\n4.display only active users\n5.Display all the records\ns6.exit");
			System.out.println("Enter the choice");
			int n = Database.sc.nextInt();
			switch(n)
			{
			case 1:c1.insert(mp);
			break;
			case 2: c1.remove(mp);
			break;
			case 3:c1.update(mp);
			break;
			case 4:c1.display(mp);
			break;
			case 5 : c1.displayAll(mp);
			break;
			case 6 : System.exit(1);
			}
		}
		
		
		
		
	}
	

}



class My 
{
	String accno;
	String name;
	Double bal;
	boolean flag;
	public My(String accno,String name,Double bal)
	{
		this.bal = bal;
		this.accno = accno;
		this.name = name;
		this.flag = true;
	}
	public String toString()
	{
		return " "+accno+" "+name+" "+bal+" ";
		
	}
}


class CRUD 
{
	int n=0;
	String name;
	int flag=0;
	
	Map<Integer,My> insert(Map<Integer,My> mp)
	{
		System.out.println("Enter the id");
		int id = Database.sc.nextInt();
		if(mp.containsKey(id))
		{
			System.out.println("User already exists");
			return mp;
		}
		else
		{
		Database.sc.nextLine();
		System.out.println("Enter accno");
	    String accno  = Database.sc.nextLine();
	    System.out.println("Enter the name");
	    String name = Database.sc.nextLine();
	    System.out.println("Enter the amount");
	    double d1 = Database.sc.nextDouble();
	    
		mp.put(id, new My(accno,name,d1));
		System.out.println("record succesfully created!!");
		}
		return mp;
		
	}
	
	
	Map<Integer,My> update(Map<Integer,My> mp) {
		 
	//Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id");
	n = Database.sc.nextInt();
	name = Database.sc.next();
	for(Map.Entry<Integer, My> me : mp.entrySet())
	{
		if(me.getKey()==n)
		{
			System.out.println("updating the name");
			me.getValue().name = name;
			flag=1;
			break;
		}
		
		
	}
	if(flag==0)
	{
		System.out.println("User not exists");
	}
	return mp;


	}
	Map<Integer,My>remove(Map<Integer,My> mp)
	{
		
		System.out.println("Enter the id");
		int n = Database.sc.nextInt();
		int flag=0;
		for(Map.Entry<Integer, My> me : mp.entrySet())
		{
			if(me.getKey()==n)
			{
				System.out.println("User is being deleted");
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("No user exists with that id");
		}
		else
		{
			mp.get(n).flag=false;
		}
		
		return mp;
	}
	void display(Map<Integer,My>mp)
	{
		for(Map.Entry<Integer, My> me : mp.entrySet())
		{
			if(me.getValue().flag==true)
			{
			System.out.println(me.getKey()+" "+me.getValue().accno+" "+me.getValue().name+" "+me.getValue().bal);
			}
		}
		
	}
	void displayAll(Map<Integer,My>mp)
	{
		for(Map.Entry<Integer, My> me : mp.entrySet())
		{
			
			System.out.println(me.getKey()+" "+me.getValue().accno+" "+me.getValue().name+" "+me.getValue().bal);
			
		}
		
	}
	

}
