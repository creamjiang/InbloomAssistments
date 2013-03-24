package user.beans;

public class StudentClassBean {

	private transient String created_at;
	private transient String end_date;
	private String grade;
	private int id;
	private String name;
	
	public StudentClassBean() {
		created_at = "";
		end_date = "";
		grade = "";
	}

	/**
	 * @return the name
	 */
	public synchronized String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public synchronized void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the grade
	 */
	public synchronized String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public synchronized void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the id
	 */
	public synchronized int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public synchronized void setId(int id) {
		this.id = id;
	}
	
	

}
