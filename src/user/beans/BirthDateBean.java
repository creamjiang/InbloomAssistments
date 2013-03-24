package user.beans;

public class BirthDateBean {

	private String birthDate;
	
	public BirthDateBean() {
		birthDate = "";
	}

	/**
	 * @return the birthDate
	 */
	public synchronized String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public synchronized void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	
	
	
	
}
