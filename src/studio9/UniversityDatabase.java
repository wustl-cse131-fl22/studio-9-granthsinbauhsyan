package studio9;

import assignment7.Student;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class UniversityDatabase {
	private final Map<String, Student> a;
	public UniversityDatabase() {
		this.a = new HashMap<>();
	}
	public void addStudent(String accountName, Student student) {
		a.put(accountName, student);
	}
	

	public int getStudentCount() {
		return this.a.size();
	}

	public String lookupFullName(String accountName) {
		if(!this.a.containsKey(accountName)) {
			return null;
		}
		return this.a.get(accountName).getFullName();
	}

	public double getTotalBearBucks() {
		double total = 0;
		for(String name : a.keySet()) {
			total+=a.get(name).getBearBucksBalance();
		}
		return total;
	}
}
