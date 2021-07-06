package inheritances;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;




class employ extends newproject
{
	Add address;
	Projects project;
	double salary;
	public String city;
	public employ(newproject u3,Add address,Projects project,double salary) {
		super(u3.id, u3.name);
		this.address = address;
		this.project = project;
		this.salary = salary;
	}
	
		
}
class Add
{
	
	String City;
	String zipcode;
	public Add(String City,String zipcode)
	{
		this.City = City;
		this.zipcode = zipcode;
		
	}
}
class Projects
{
	int projectid;
	String name;
	int budget;
	public Projects(int projectid,String name,int budget)
	{
		this.budget = budget;
		this.name = name;
		this.projectid = projectid;
	}
	
}

public class newproject {
	
	static String name=null;
	String id=null;
	public newproject(String name,String id)
	{
		this.name = name;
		this.id = id;
	}

static class salarysort implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		employee1 e1 = (employee1) o1;
		employee1  e2 = (employee1) o2;
		if(e1.salary>e2.salary)
			return -1;
		else if(e1.salary<e2.salary)
			return 1;
		else
			return 0;
			
		
		
	}
	
}
	


	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<employ> Emp = new ArrayList<>();
		List<newproject> User = new ArrayList<>();
		
		newproject u1 = new newproject("Shifa","101");
		newproject u2 = new newproject("zahera","102");
		newproject u3 = new newproject("zah","103");

		
		Add a1 = new Add("Bangalore","50001");
		Projects p1 = new Projects(1,"p1",2000);
		Add a2 = new Add("Mumbai","50902");
		
		User.add(new newproject("shifa","100"));
		User.add(new newproject("Zahera","101"));
		User.add(new employ(u1, a1, p1, 400.0D));
		User.add(new employ(u2, a2, p1, 500.0D));
		User.add(new employ(u3, a2, p1, 500.0D));

		

		
		
		for (newproject np : User) {
			if(np instanceof employ)
				Emp.add((employ)np);
		}
		List<employ> finalemp = new ArrayList<>();
		Collections.sort(Emp, new salarysort());
		double  budget= finalemp.get(0).project.budget;
		for (employ e:Emp)
		{
			
			if(e.salary <budget && budget>0)
			{
				finalemp.add(e);
				budget = (int)budget-e.salary;
				
			}
			
		}
		for (employ fe:finalemp)
		{
			System.out.println(fe.id+" "+fe.salary);

	}}

}
