/**
 * UserInformationImportServlet.java
 * Joshua Dickson, for ASSISTments and InBloom
 */
package landing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import user.User;
import user.beans.AssistmentsTeacherClassBean;
import user.beans.SchoolsBean;
import user.beans.SectionsBean;
import user.beans.SessionCheckBean;
import user.beans.StudentBean;
import user.beans.StudentClassBean;
import util.ActiveUser;
import util.ApplicationSettings;
import util.URLUtility;

/**
 * A servlet that queries the InBloom database for user information and stores the information
 * locally in the current active user's data structure
 */
@WebServlet("/userinformationimportservlet")
public class UserInformationImportServlet extends HttpServlet {
       
	private static final long serialVersionUID = -4448826717759025643L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public UserInformationImportServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		ServletContext context = getServletContext();
		User currentUser = (User) context.getAttribute("[activeUser]");
		
		try {
			String json = URLUtility.getJSONStringFromURL("/api/rest/system/session/check");	
			System.out.println(json);
			currentUser.setSessionCheck(new Gson().fromJson(json, SessionCheckBean.class));
			
			json = URLUtility.getJSONStringFromURL("/api/rest/v1.1/schools");
						
			currentUser.setSchools(new Gson().fromJson(json, SchoolsBean[].class));
						
			json = URLUtility.getJSONStringFromURL("/api/rest/v1.1/sections");
			
			currentUser.setSections(new Gson().fromJson(json, SectionsBean[].class));			
			
			json = URLUtility.getJSONStringFromURL("/api/rest/v1.1/sections/" + ActiveUser
					.getActiveUser().getSections()[1].getId() + "/studentSectionAssociations/students");
		
			currentUser.setStudents(new Gson().fromJson(json, StudentBean[].class));
			
			//200050
			//164740
			
			String xml = URLUtility.getXMLStringFromURL("http://192.168.2.125:3000/inbloom_api/teachers/164740/teacher_classes.xml");
//			System.out.println(xml);
			
			XStream xstream = new XStream(new StaxDriver());
			xstream.aliasField("student-class-id", AssistmentsTeacherClassBean.class, "student_class_id");
			xstream.alias("teacher-class", AssistmentsTeacherClassBean.class);
			xstream.aliasField("teacher-id", AssistmentsTeacherClassBean.class, "teacher_id");
			xstream.alias("teacher-classes", AssistmentsTeacherClassBean[].class);
			xstream.alias("nil-classes", AssistmentsTeacherClassBean[].class);
//			
			AssistmentsTeacherClassBean[] teacherClass = (AssistmentsTeacherClassBean[]) xstream.fromXML(xml);
			
			currentUser.setTeacherClass(teacherClass);
			
			for(int i = 0; i < currentUser.getTeacherClass().length; i++) {
				System.out.println("NAME DUMP");
				xml = URLUtility.getXMLStringFromURL("http://192.168.2.125:3000/inbloom_api/student_classes/" + currentUser.getTeacherClass()[i].getStudent_class_id() + ".xml");
//				System.out.println(xml);
				
				xstream.aliasField("created-at", StudentClassBean.class, "created_at");
				xstream.aliasField("end-date", StudentClassBean.class, "end_date");
				xstream.alias("student-class", StudentClassBean.class);
				xstream.alias("nil-class", StudentClassBean.class);
				
				StudentClassBean thisClass = (StudentClassBean) xstream.fromXML(xml);
				
				currentUser.getTeacherClass()[i].setStudentClass(thisClass);
//				System.out.println("Test1");

			}
			
			
			currentUser.setClassList();
			

			
			ActiveUser.setActiveUser(currentUser);
//			context.setAttribute("[activeUser]", currentUser);
			request.setAttribute("activeUser", currentUser);
			
            RequestDispatcher dispatcher = context.getRequestDispatcher("/dashboard.jsp");
            dispatcher.forward(request, response);
			
//			response.sendRedirect(ApplicationSettings.getApplicationBasePath() + "/dashboard.jsp");	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect(ApplicationSettings.getApplicationBasePath() + "/failure_redirect.jsp");

		}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
