package dashboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistments.AssistmentsUserBean;
import assistments.TeacherClassBean;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import user.beans.AssistmentsTeacherClassBean;
import user.beans.StudentClassBean;
import util.ActiveUser;
import util.ApplicationSettings;
import util.URLUtility;

/**
 * Servlet implementation class AssistmentsCreateServlet
 */
@WebServlet("/assistmentscreateservlet")
public class AssistmentsCreateServlet extends HttpServlet {
       
	private static final long serialVersionUID = -5395382679961943043L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public AssistmentsCreateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String className = "8th Grade English"; 
			
			String postRequest = "student_class[name]=" + className + 
					"&student_class[grade]=8&student_class[end_date]=2013-07-23";

			String xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/student_classes", postRequest);
			
//			System.out.println(xml);
			
			XStream xstream = new XStream(new StaxDriver());
			xstream.aliasField("created-at", StudentClassBean.class, "created_at");
			xstream.aliasField("end-date", StudentClassBean.class, "end_date");
			xstream.alias("student-class", StudentClassBean.class);
			xstream.alias("nil-class", StudentClassBean.class);
			
			StudentClassBean classToAdd = (StudentClassBean) xstream.fromXML(xml);
			
			System.out.println("Going to be using this ID next: " + classToAdd.getId());
			
			postRequest = "teacher_id=" + ApplicationSettings.getAssistmentsTeacherID() + "&student_class_id=" + classToAdd.getId();
		
			xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/teacher_classes", postRequest);
			
//			System.out.println(xml);
			
			xstream = new XStream(new StaxDriver());
			xstream.aliasField("student-class-id", TeacherClassBean.class, "student_class_id");
			xstream.aliasField("teacher-id", TeacherClassBean.class, "teacher_id");
			xstream.alias("teacher-class", TeacherClassBean.class);
			
			TeacherClassBean teacherClass = (TeacherClassBean) xstream.fromXML(xml);
			
//			System.out.println("TeacherID: " + teacherClass.getTeacher_id());
			System.out.println("StudentClassID: " + teacherClass.getStudent_class_id());
			
			
			
			
			for(int i = 0; i < ActiveUser.getActiveUser().getStudents().length; i++) {
				
				postRequest = "school_id=1&first_name=" + ActiveUser.getActiveUser().getStudents()[i].getName().getFirstName() + "&middle_name=" + ActiveUser.getActiveUser().getStudents()[i].getName().getMiddleName() + "&last_name=" + ActiveUser.getActiveUser().getStudents()[i].getName().getLastSurname() + "&grade=8&birthdate[year]=2000&birthdate[month]=1&birthdate[day]=1";
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/students", postRequest);
				
//				System.out.println("STUDENTRESPONSE");
//				System.out.println(xml);
				
				xstream.alias("user", AssistmentsUserBean.class);
				
				AssistmentsUserBean thisUser = (AssistmentsUserBean) xstream.fromXML(xml);
				
				System.out.println("StudentID: " + thisUser.getId());
				
				postRequest = "student_id=" + thisUser.getId() + "&student_class_id=" + teacherClass.getStudent_class_id();
				
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				xml = URLUtility.getXMLStringFromURLPost("http://192.168.2.125:3000/inbloom_api/enrollments", postRequest);
				
//				System.out.println(xml);
				
				
				
			}
			
			
			

			
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
