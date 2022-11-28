package assignment7;

/**
 * Creates a Student with a Name and ID number. 
 * Calculates attempted and passing credits, Bear Bucks, GPA, and creates a child legacy
 * @author steph
 *
 */
public class Student {
	
	private String firstName = " ";
	private String lastName = " ";
	private int studentID = 0;
	private int attemptedCredits = 0;
	private int passingCredits = 0;
	private double bearBucksBalance = 0;
	private double qualityPoints = 0;

	/**
	 * Creates a student
	 * @param firstName String- Student's first name
	 * @param lastName  String- Student's last name
	 * @param studentID	int- Student's ID number
	 */
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		this.attemptedCredits = attemptedCredits;
		this.passingCredits = passingCredits;
		this.bearBucksBalance = bearBucksBalance;
		this.qualityPoints = qualityPoints;
	}
	/**
	 *
	 * @return Full name as String.
	 */
	public String getFullName() {
		return this.firstName+" "+this.lastName;
	}
	/**
	 * 
	 * @return ID number as int.
	 */
	public int getId() {
		return this.studentID;
	}
	
	/**
	 * Allows you to submit a grade and credits
	 * @param grade double- Grade in class
	 * @param credits int- Number of credits for class
	 */
	public void submitGrade(double grade, int credits){	
		this.qualityPoints +=grade*credits;
		this.attemptedCredits += credits;
		if (grade>=1.7) {
			this.passingCredits+=credits;	
			}
	}
	/**
	 * 
	 * @return int- Attempted Credits
	 */
	public int getTotalAttemptedCredits() {	
		return this.attemptedCredits;
	}
	/** 
	 * 
	 * @return int- Passing Credits
	 */
	public int getTotalPassingCredits() {
		return this.passingCredits;
	}
	/** 
	 * 
	 * @return double- Calculates GPA
	 */
	public double calculateGradePointAverage() {
		double gpa = qualityPoints/getTotalAttemptedCredits();
		return gpa;
	}
	/** 
	 * 
	 * @return String- Class standing
	 */
	public String getClassStanding() {
		if (this.passingCredits<30) {
			return "First Year";
		}
		else if (this.passingCredits<60) {
			return "Sophomore";
		}
		else if (this.passingCredits<90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}
	/**
	 * 
	 * @return boolean- If student is eligible for Phi Beta Kappa
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (this.passingCredits>=98 && calculateGradePointAverage()>=3.60) {
			return true;
		}
		else if (this.passingCredits>=75 && calculateGradePointAverage()>=3.80) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Deposits amount into bear bucks
	 * @param amount double
	 */
	public void depositBearBucks(double amount) {
		this.bearBucksBalance += amount;
	}
	/**
	 * Deducts amount into bear bucks
	 * @param amount double
	 */
	public void deductBearBucks(double amount) {
		this.bearBucksBalance -= amount;
	}
	/**
	 *Gives bear bucks balance
	 * @return double
	 */
	public double getBearBucksBalance() {
		return this.bearBucksBalance;
	}
	/**
	 * Cashes out bear bucks and returns remaining balance
	 * @return double
	 */
	public double cashOutBearBucks() {
		if (this.bearBucksBalance > 10) {
			double tempBucks = this.bearBucksBalance;
			this.bearBucksBalance = 0;
			return tempBucks - 10;
		}
		else {
			this.bearBucksBalance = 0;
			return 0;
		}
	}
	/**
	 * Gives last name
	 * @return String
	 */
	public String getLastName() {
		return this.lastName;
	}
	/**
	 * Creates child of two Students
	 * @param firstName String- student's first name
	 * @param other Student-  other student in the couple
	 * @param isHyphenated boolean- whether or not the last name should be hyphenated
	 * @param id int- student ID number
	 * @return Student
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String lastName =" ";
		if (isHyphenated == true) {
			lastName = this.lastName + "-" + other.getLastName();
		}
		else {
			lastName=this.lastName;
		}
		Student child = new Student(firstName,lastName,id);
		child.depositBearBucks(other.cashOutBearBucks()+this.cashOutBearBucks());
		return child;

	}
	/**
	 * @return Returns First name, last name, and student ID. 
	 */
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.studentID;
	}
}
