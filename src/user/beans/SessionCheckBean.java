/**
 * SessionCheckBean.java
 * Joshua Dickson, for ASSISTments and InBloom
 */
package user.beans;

/**
 * A data structure that holds information from a user's session system
 * @author Joshua Dickson
 * @version March 23, 2013
 */
public class SessionCheckBean {

	private String edOrg;
	private String edOrgId;
	private String email;
	private String external_id;
	private String full_name;
	private String[] granted_authorities;
	private boolean isAdminUser;
	private String userType;
	private String user_id;
	
	/**
	 * Construct a blank SessionCheckBean
	 */
	public SessionCheckBean() {
		edOrg = "";
		edOrgId = "";
		email = "";
	}

	/**
	 * @return the edOrg
	 */
	public synchronized String getEdOrg() {
		return edOrg;
	}

	/**
	 * @param edOrg the edOrg to set
	 */
	public synchronized void setEdOrg(String edOrg) {
		this.edOrg = edOrg;
	}

	/**
	 * @return the edOrgId
	 */
	public synchronized String getEdOrgId() {
		return edOrgId;
	}

	/**
	 * @param edOrgId the edOrgId to set
	 */
	public synchronized void setEdOrgId(String edOrgId) {
		this.edOrgId = edOrgId;
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
	 * @return the external_id
	 */
	public synchronized String getExternal_id() {
		return external_id;
	}

	/**
	 * @param external_id the external_id to set
	 */
	public synchronized void setExternal_id(String external_id) {
		this.external_id = external_id;
	}

	/**
	 * @return the full_name
	 */
	public synchronized String getFull_name() {
		return full_name;
	}

	/**
	 * @param full_name the full_name to set
	 */
	public synchronized void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	/**
	 * @return the granted_authorities
	 */
	public synchronized String[] getGranted_authorities() {
		return granted_authorities;
	}

	/**
	 * @param granted_authorities the granted_authorities to set
	 */
	public synchronized void setGranted_authorities(String[] granted_authorities) {
		this.granted_authorities = granted_authorities;
	}

	/**
	 * @return the isAdminUser
	 */
	public synchronized boolean isAdminUser() {
		return isAdminUser;
	}

	/**
	 * @param isAdminUser the isAdminUser to set
	 */
	public synchronized void setAdminUser(boolean isAdminUser) {
		this.isAdminUser = isAdminUser;
	}

	/**
	 * @return the userType
	 */
	public synchronized String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public synchronized void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the user_id
	 */
	public synchronized String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public synchronized void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
