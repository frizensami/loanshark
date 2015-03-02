package sriram.loanshark;

public class Person {

	public String name;
	public double borrowed;
	
	
	public Person(String inName, double inBorrowed){
		name = inName;
		borrowed = inBorrowed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBorrowed(double borrowed) {
		this.borrowed = borrowed;
	}

	public double getBorrowed() {
		return borrowed;
	}
	
	
	
	
	
	
	
}
