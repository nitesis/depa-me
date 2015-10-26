package patterns.clone.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Company implements Cloneable{
	private String name;
	private ArrayList<Person> employees;

	public Company(String name, ArrayList<Person> employees) {
		this.name = name;
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}
	
	public int getSize() {
		return employees.size();
	}
	
	public void addEmployee(Person p) {
		this.employees.add(p);
	}

	public boolean equals(Object o) {
		if (o instanceof Company) {
			Company c = (Company) o;
			return name.equals(c.name) 
					&& employees.equals(c.employees);
		} else {
			return false;
		}
	}

	public Company clone() {
		Company comp = null;
		try {
			comp = (Company) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Deep Copy
		Iterator<Person> it = employees.iterator();
		ArrayList<Person> employeesClone = new ArrayList<Person>();
		for (Person p : employees) {
			if(it.hasNext()) {
				// Hier wird nur eine neue Liste mit den selben Personen erstellt -> testDeep1
				//employeesClone.add(it.next()); 
				// Hier wird nur eine neue Liste neuen Personen erstellt -> testDeep2
				employeesClone.add(it.next().clone()); 
			}
		}
		return new Company(name, employeesClone);
		//return comp;
	}
}
