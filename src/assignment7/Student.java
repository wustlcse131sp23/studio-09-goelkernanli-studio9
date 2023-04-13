package assignment7;

public class Student {
	private String firstName, lastName;
	private int ID, ACredits, PCredits;
	private double QPoints, BearBucks = 0, GPA;

	/**
	 * Constructor
	 * 
	 * @param firstName of the student
	 * @param lastName  of the student
	 * @param ID        of the student
	 */
	public Student(String firstName, String lastName, int ID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ID = ID;
	}

	/**
	 * 
	 * @returns the full name of the student
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}

	/**
	 * sets the students first name
	 * 
	 * @param firstName is the new first name of the student
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * returns last name
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * sets last name to param lastName
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * returns ID
	 * 
	 * @return
	 */
	public int getId() {
		return ID;
	}

	/**
	 * returns passing credits
	 * 
	 * @return
	 */
	public int getTotalPassingCredits() {
		return PCredits;
	}

	/**
	 * returns the GPA of the student
	 * 
	 * @return
	 */
	public double calculateGradePointAverage() {
		return (double) QPoints / ACredits;
	}

	/**
	 * generates a grade for a student
	 * 
	 * @param grade
	 * @param credits
	 */
	public void submitGrade(double grade, int credits) {
		ACredits += credits;
		if (grade >= 1.7)
			PCredits += credits;
		QPoints += credits * grade;
		GPA = calculateGradePointAverage();
	}

	/**
	 * returns the year of the student
	 * 
	 * @return
	 */
	public String getClassStanding() {
		if (PCredits >= 90)
			return "Senior";
		else if (PCredits >= 60)
			return "Junior";
		else if (PCredits >= 30)
			return "Sophomore";
		return "First Year";
	}

	/**
	 * returns if the student is eligible for honors
	 * 
	 * @return
	 */
	public boolean isEligibleForPhiBetaKappa() {
		return (ACredits >= 98 && GPA >= 3.6) || (ACredits >= 75 && GPA >= 3.8);
	}

	/**
	 * adds amount to total BB balance
	 * 
	 * @param amount
	 */
	public void depositBearBucks(double amount) {
		BearBucks += amount;
	}

	/**
	 * deducts amount to total BB balance
	 * 
	 * @param amount
	 */
	public void deductBearBucks(double amount) {
		BearBucks -= amount;
	}

	/**
	 * returns total BB balance
	 * 
	 * @return
	 */
	public double getBearBucksBalance() {
		return BearBucks;
	}

	/**
	 * returns the amount of BB withdrawn plus sets balence to zero
	 * 
	 * @return
	 */
	public double cashOutBearBucks() {
		if (BearBucks <= 10) {
			BearBucks = 0;
			return 0;
		}
		double t = BearBucks - 10;
		BearBucks = 0;
		return t;
	}

	/**
	 * returns a new legacy student
	 * 
	 * @param firstName    of the student
	 * @param otherParent  is the students other parent
	 * @param isHyphenated if the last name is hyphenated
	 * @param id           of the student
	 * @return
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		Student k;
		if (isHyphenated)
			k = new Student(firstName, this.getLastName() + "-" + otherParent.getLastName(), id);
		else
			k = new Student(firstName, this.getLastName(), id);
		k.depositBearBucks(this.cashOutBearBucks() + otherParent.cashOutBearBucks());
		return k;
	}

	/**
	 * returns the students name and ID
	 */
	public String toString() {
		return getFullName() + " " + ID;
	}

}
