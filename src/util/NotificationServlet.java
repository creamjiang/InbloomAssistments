package util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NotificationServlet
 */
@WebServlet("/sendnotifications")
public class NotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recipientAddress = "joshdickson40@gmail.com";
		String subject = "Notification from InBloom and ASSISTments";
		String message = "Dear Parent,\n" +
				"\n" +
				"When completing the assigned homework this evening, Bob needed considerable " +
				"assistence with geometry. ASSISTments reports he was frustrated and got both" +
				" questions wrong in the problem set.\n" +
				"\n" +
				"InBloom indicates that Bob was absent last week for the lesson, and follow up lessons " +
				"should be given. Bob's absense rate is also high, in the 90th percentile for Linda " +
				"Kim's Math and Science class.\n" +
				"\n" +
				"ASSISTments has reccomended that Bob complete Lesson Plan 5970. The special" +
				"educator for this class, Ms. Eileen Smith, has been notified, and she can be" +
				"reached at eileen.smith@daybreakmiddleschool.org.\n" +
				"\n\n" +
				"InBloom and ASSISTments";
		
		SendMail.sendMessage(recipientAddress, subject, message);
		
		recipientAddress = "5088435827@mms.att.net";
		
		message = "Parent - Susan performed in the 90th percentile for Homework 4. " +
				"Congratulate her. We reccomend enrichment activity 43. -InBloom and ASSISTments";
		
		SendMail.sendMessage(recipientAddress, subject, message);
		
		
	}

}
