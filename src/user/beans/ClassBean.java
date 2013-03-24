package user.beans;

public class ClassBean {
	
	private String className;
	private boolean isInAssistments;
	
	public ClassBean() {
		className = "";
		isInAssistments = false;
	}

	/**
	 * @return the className
	 */
	public synchronized String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public synchronized void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the isInAssistments
	 */
	public synchronized boolean isInAssistments() {
		return isInAssistments;
	}

	/**
	 * @param isInAssistments the isInAssistments to set
	 */
	public synchronized void setInAssistments(boolean isInAssistments) {
		this.isInAssistments = isInAssistments;
	}
	
	
	
	
	
	
}
