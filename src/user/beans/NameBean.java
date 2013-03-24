package user.beans;

public class NameBean {

	private String middleName;
	private String lastSurname;
	private String firstName;
	
	public NameBean() {
		middleName = "";
		lastSurname = "";
		firstName = "";
	}

	/**
	 * @return the middleName
	 */
	public synchronized String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public synchronized void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastSurname
	 */
	public synchronized String getLastSurname() {
		return lastSurname;
	}

	/**
	 * @param lastSurname the lastSurname to set
	 */
	public synchronized void setLastSurname(String lastSurname) {
		this.lastSurname = lastSurname;
	}

	/**
	 * @return the firstName
	 */
	public synchronized String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public synchronized void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	
	
}
