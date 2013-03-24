package user.beans;

public class AssistmentsTeacherClassBean {
	
	private int id;
	private int student_class_id;
	private int teacher_id;
	private StudentClassBean studentClass;
	
	public AssistmentsTeacherClassBean() {
		id = 0;
		student_class_id = 0;
		teacher_id = 0;
		studentClass = new StudentClassBean();
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

	/**
	 * @return the student_class_id
	 */
	public synchronized int getStudent_class_id() {
		return student_class_id;
	}

	/**
	 * @param student_class_id the student_class_id to set
	 */
	public synchronized void setStudent_class_id(int student_class_id) {
		this.student_class_id = student_class_id;
	}

	/**
	 * @return the teacher_id
	 */
	public synchronized int getTeacher_id() {
		return teacher_id;
	}

	/**
	 * @param teacher_id the teacher_id to set
	 */
	public synchronized void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	/**
	 * @return the studentClass
	 */
	public StudentClassBean getStudentClass() {
		return studentClass;
	}

	/**
	 * @param studentClass the studentClass to set
	 */
	public void setStudentClass(StudentClassBean studentClass) {
		this.studentClass = studentClass;
	}

	
}
