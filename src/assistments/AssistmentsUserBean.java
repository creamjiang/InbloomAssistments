package assistments;

public class AssistmentsUserBean {
	
	private String email;
	private int id;
	private String login;
	private String timezone;
	
	public AssistmentsUserBean() {
		email = "";
		id = 0;
		login = "";
		timezone = "";
	}

	/**
	 * @return the email
	 */
	public synchronized String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public synchronized void setEmail(String email) {
		this.email = email;
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
	 * @return the login
	 */
	public synchronized String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public synchronized void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the timezone
	 */
	public synchronized String getTimezone() {
		return timezone;
	}

	/**
	 * @param timezone the timezone to set
	 */
	public synchronized void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	
	

}
