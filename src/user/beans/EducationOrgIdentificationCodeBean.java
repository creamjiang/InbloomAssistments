package user.beans;

public class EducationOrgIdentificationCodeBean {

	private String identificationSystem;
	private String ID;
	
	public EducationOrgIdentificationCodeBean() {
		identificationSystem = "";
		ID = "";
	}

	/**
	 * @return the identificationSystem
	 */
	public synchronized String getIdentificationSystem() {
		return identificationSystem;
	}

	/**
	 * @param identificationSystem the identificationSystem to set
	 */
	public synchronized void setIdentificationSystem(String identificationSystem) {
		this.identificationSystem = identificationSystem;
	}

	/**
	 * @return the iD
	 */
	public synchronized String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public synchronized void setID(String iD) {
		ID = iD;
	}
	
	
	
	
	
}
