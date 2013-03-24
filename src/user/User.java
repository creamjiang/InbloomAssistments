/**
 * User.java
 * Joshua Dickson, for ASSISTments and InBloom
 */
package user;

import java.util.ArrayList;
import java.util.List;

import user.beans.AssistmentsTeacherClassBean;
import user.beans.ClassBean;
import user.beans.SchoolsBean;
import user.beans.SectionsBean;
import user.beans.SessionCheckBean;
import user.beans.StudentBean;
import landing.AccessTokenBean;

/**
 * A data class that holds information about a user
 * @author Joshua Dickson
 * @version March 23, 2013
 */
public class User {
	
	private AccessTokenBean accessToken;
	private SessionCheckBean sessionCheck;
	private SchoolsBean[] schools;
	private SectionsBean[] sections;
	private StudentBean[] students;
	private AssistmentsTeacherClassBean[] teacherClass;
	private List<ClassBean> classList;
	
	/**
	 * Construct a User
	 */
	public User() {
		accessToken = new AccessTokenBean();
		sessionCheck = new SessionCheckBean();
		schools = new SchoolsBean[0];
		sections = new SectionsBean[0];
		students = new StudentBean[0];
		teacherClass = new AssistmentsTeacherClassBean[0];
		classList = new ArrayList<ClassBean>();
	}
	
	/**
	 * @return the classList
	 */
	public synchronized List<ClassBean> getClassList() {
		return classList;
	}

	/**
	 * @param classList the classList to set
	 */
	public synchronized void setClassList(List<ClassBean> classList) {
		this.classList = classList;
	}

	public void setClassList() {
		
		for(int i = 0; i < sections.length; i++) {
			ClassBean newClass = new ClassBean();
			newClass.setClassName(sections[i].getUniqueSectionCode().trim());
			newClass.setInAssistments(false);
			classList.add(newClass);
		}
		
		for(int i = 0; i < classList.size(); i++) {
			
			//Check if this class name (pulled from InBloom) is already in Assistments
			for(int j = 0; j < teacherClass.length; j++) {
				if(classList.get(i).getClassName() == teacherClass[j].getStudentClass().getName()) {
					classList.get(i).setInAssistments(true);
					
					
				}
			}
			
			
			
		}
		
		
		
	}
	

	/**
	 * @return the accessToken
	 */
	public synchronized AccessTokenBean getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public synchronized void setAccessToken(AccessTokenBean accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the sessionCheck
	 */
	public synchronized SessionCheckBean getSessionCheck() {
		return sessionCheck;
	}

	/**
	 * @param sessionCheck the sessionCheck to set
	 */
	public synchronized void setSessionCheck(SessionCheckBean sessionCheck) {
		this.sessionCheck = sessionCheck;
	}

	/**
	 * @return the schools
	 */
	public synchronized SchoolsBean[] getSchools() {
		return schools;
	}

	/**
	 * @param schools the schools to set
	 */
	public synchronized void setSchools(SchoolsBean[] schools) {
		this.schools = schools;
	}

	/**
	 * @return the sections
	 */
	public synchronized SectionsBean[] getSections() {
		return sections;
	}

	/**
	 * @param sections the sections to set
	 */
	public synchronized void setSections(SectionsBean[] sections) {
		this.sections = sections;
	}

	/**
	 * @return the students
	 */
	public synchronized StudentBean[] getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public synchronized void setStudents(StudentBean[] students) {
		this.students = students;
	}

	/**
	 * @return the teacherClass
	 */
	public synchronized AssistmentsTeacherClassBean[] getTeacherClass() {
		return teacherClass;
	}

	/**
	 * @param teacherClass the teacherClass to set
	 */
	public synchronized void setTeacherClass(
			AssistmentsTeacherClassBean[] teacherClass) {
		this.teacherClass = teacherClass;
	}
	
	
}
