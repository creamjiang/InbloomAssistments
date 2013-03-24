/**
 * SectionsBean.java
 * Joshua Dickson, for ASSISTments and InBloom
 */
package user.beans;

/**
 * A data class that holds information about a section
 * @author Josh
 *
 */
public class SectionsBean {
	private String id;
	private String sessionID;
	private String courseOfferingId;
	private String populationServed;
	private String mediumOfInstruction;
	private String uniqueSectionCode;
	
	/**
	 * Construct a SectionsBean
	 */
	public SectionsBean() {
		id = "";
		sessionID = "";
		courseOfferingId = "";
		populationServed = "";
		mediumOfInstruction = "";
		uniqueSectionCode = "";
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
	 * @return the sessionID
	 */
	public synchronized String getSessionID() {
		return sessionID;
	}

	/**
	 * @param sessionID the sessionID to set
	 */
	public synchronized void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	/**
	 * @return the courseOfferingId
	 */
	public synchronized String getCourseOfferingId() {
		return courseOfferingId;
	}

	/**
	 * @param courseOfferingId the courseOfferingId to set
	 */
	public synchronized void setCourseOfferingId(String courseOfferingId) {
		this.courseOfferingId = courseOfferingId;
	}

	/**
	 * @return the populationServed
	 */
	public synchronized String getPopulationServed() {
		return populationServed;
	}

	/**
	 * @param populationServed the populationServed to set
	 */
	public synchronized void setPopulationServed(String populationServed) {
		this.populationServed = populationServed;
	}

	/**
	 * @return the mediumOfInstruction
	 */
	public synchronized String getMediumOfInstruction() {
		return mediumOfInstruction;
	}

	/**
	 * @param mediumOfInstruction the mediumOfInstruction to set
	 */
	public synchronized void setMediumOfInstruction(String mediumOfInstruction) {
		this.mediumOfInstruction = mediumOfInstruction;
	}

	/**
	 * @return the uniqueSectionCode
	 */
	public synchronized String getUniqueSectionCode() {
		return uniqueSectionCode;
	}

	/**
	 * @param uniqueSectionCode the uniqueSectionCode to set
	 */
	public synchronized void setUniqueSectionCode(String uniqueSectionCode) {
		this.uniqueSectionCode = uniqueSectionCode;
	}
	
	
	
}
