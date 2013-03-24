/**
 * SchoolsBean.java
 * Joshua Dickson, for ASSISTments and InBloom
 */
package user.beans;

/**
 * A data structure that holds information from a user's school information
 * @author Joshua Dickson
 * @version March 23, 2013
 */
public class SchoolsBean {
	
	private EducationOrgIdentificationCodeBean[] educationOrgIdentificationCode;
	
	public SchoolsBean() {
		educationOrgIdentificationCode = new EducationOrgIdentificationCodeBean[0];
	}

	/**
	 * @return the educationOrgIdentificationCode
	 */
	public synchronized EducationOrgIdentificationCodeBean[] getEducationOrgIdentificationCode() {
		return educationOrgIdentificationCode;
	}

	/**
	 * @param educationOrgIdentificationCode the educationOrgIdentificationCode to set
	 */
	public synchronized void setEducationOrgIdentificationCode(
			EducationOrgIdentificationCodeBean[] educationOrgIdentificationCode) {
		this.educationOrgIdentificationCode = educationOrgIdentificationCode;
	}
	
	

}
