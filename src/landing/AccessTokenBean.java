/**
 * AccessTokenBean.java
 * Joshua Dickson, for ASSISTments and InBloom
 */
package landing;

/**
 * A data structure class that provides a structure for working with access tokens
 * @author Joshua Dickson
 * @version March 23, 2013
 *
 */
public class AccessTokenBean {
	
	private String access_token;
	
	/**
	 * Construct an AccessTokenBean
	 */
	public AccessTokenBean() {
		access_token = "";
	}

	/**
	 * @return the access_token
	 */
	public synchronized String getAccess_token() {
		return access_token;
	}

	/**
	 * @param access_token the access_token to set
	 */
	public synchronized void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
	

}
