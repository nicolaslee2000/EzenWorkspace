package java0331.part02;

public class SalesGrade {
	int hisal;
	int losal;
	char grade;

	SalesGrade(int losal, int hisal, char grade) {
		this.losal = losal;
		this.hisal = hisal;
		this.grade = grade;
	}

	public String toString() {
		return losal + " " + hisal + " " + grade;
	}

	public int getHisal() {
		return hisal;
	}

	public void setHisal(int hisal) {
		this.hisal = hisal;
	}

	public int getLosal() {
		return losal;
	}

	public void setLosal(int losal) {
		this.losal = losal;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	
	
}// end class
