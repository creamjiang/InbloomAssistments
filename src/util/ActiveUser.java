/**
 * ActiveUser.java
 * Joshua Dickson, for ASSISTments and InBloom
 */
package util;

import javax.servlet.ServletContext;

import user.User;

/**
 * A class that tracks an active user in system memory. This class is implemented for Hackathon
 * purposes only so more time can be spent in application usage development over explicitly
 * tracking possible separate users in our system. This is NOT intended as production code.
 * @author Josh Dickson
 * @version March 23, 2013
 */
public class ActiveUser {
	
	private static User activeUser;

	/**
	 * @return the activeUser
	 */
	public static synchronized User getActiveUser() {
		return activeUser;
	}

	/**
	 * @param activeUser the activeUser to set
	 */
	public static synchronized void setActiveUser(User activeUser) {
		ActiveUser.activeUser = activeUser;
	}
	
	

}
