package studio9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import assignment7.Student;

public class UniversityDatabase {
	private final Map<String, Student> x;

	public UniversityDatabase() {
		x = new HashMap<>();
	}

	public void addStudent(String accountName, Student student) {
		x.put(accountName, student);
		//x.putIfAbsent(accountName, student);
	}

	public int getStudentCount() {
		return x.size();
	}

	public String lookupFullName(String accountName) {
		if (x.get(accountName) == null)
			return null;
		return x.get(accountName).getFullName();
	}

	public double getTotalBearBucks() {
		Set<String> i = x.keySet();
		double ret = 0;
		for (String k : i) {
			ret += x.get(k).getBearBucksBalance();
		}
		return ret;
	}
}
