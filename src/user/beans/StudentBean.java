/**
 * StudentBean.java
 * Joshua Dickson, for ASSISTments and InBloom
 */
package user.beans;


/**
 * A data class that holds information about a student
 * @author Josh
 *
 */
public class StudentBean {
	
	private String sex;
	private String id;
	private String studentUniqueStateId;
	private NameBean name;
	private BirthDateBean birthData;

	public StudentBean() {
		sex = "";
		id = "";
		studentUniqueStateId = "";
		name = new NameBean();
		birthData = new BirthDateBean();
	}

	/**
	 * @return the sex
	 */
	public synchronized String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public synchronized void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the id
	 */
	public synchronized String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public synchronized void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the studentUniqueStateId
	 */
	public synchronized String getStudentUniqueStateId() {
		return studentUniqueStateId;
	}

	/**
	 * @param studentUniqueStateId the studentUniqueStateId to set
	 */
	public synchronized void setStudentUniqueStateId(String studentUniqueStateId) {
		this.studentUniqueStateId = studentUniqueStateId;
	}

	/**
	 * @return the name
	 */
	public synchronized NameBean getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public synchronized void setName(NameBean name) {
		this.name = name;
	}

	/**
	 * @return the birthData
	 */
	public synchronized BirthDateBean getBirthData() {
		return birthData;
	}

	/**
	 * @param birthData the birthData to set
	 */
	public synchronized void setBirthData(BirthDateBean birthData) {
		this.birthData = birthData;
	}
	
	













}
