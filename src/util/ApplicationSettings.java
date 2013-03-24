/**
 * ApplicationSettings.java
 * Joshua Dickson, for ASSISTments and InBloom
 */
package util;

/**
 * A utility data class that provides application wide availability of application codes
 * @author Josh
 *
 */
public class ApplicationSettings {
	
	private static String client_id = "9xruFuZ7aD";
	private static String client_secret = "mvonCkzfal68C6DF650JdnlV9L2dPGYZ9X5Lr5SxzoHS7SAz";
	private static String applicationBasePath = "http://localhost:8080/InBloom";
	private static String inBloomBasePath = "https://api.sandbox.inbloom.org";
	private static String assistmentsUserID = "209976";
	private static String assistmentsUserPassword = "1234";
	private static String assistmentsTeacherID = "200050";
	
	
	/**
	 * @return the assistmentsUserID
	 */
	public static synchronized String getAssistmentsUserID() {
		return assistmentsUserID;
	}
	/**
	 * @return the assistmentsUserPassword
	 */
	public static synchronized String getAssistmentsUserPassword() {
		return assistmentsUserPassword;
	}
	
	
	/**
	 * @return the client_id
	 */
	public static synchronized String getClient_id() {
		return client_id;
	}
	/**
	 * @return the client_secret
	 */
	public static synchronized String getClient_secret() {
		return client_secret;
	}
	/**
	 * @return the applicationBasePath
	 */
	public static synchronized String getApplicationBasePath() {
		return applicationBasePath;
	}
	/**
	 * @return the inBloomBasePath
	 */
	public static synchronized String getInBloomBasePath() {
		return inBloomBasePath;
	}
	/**
	 * @return the assistmentsTeacherID
	 */
	public static synchronized String getAssistmentsTeacherID() {
		return assistmentsTeacherID;
	}
	
	

}
