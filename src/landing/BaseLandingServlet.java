/**
 * BaseLandingServlet.java
 * Joshua Dickson, for ASSISTments and InBloom
 */
package landing;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;
import util.ActiveUser;
import util.ApplicationSettings;
import util.URLUtility;

import com.google.gson.Gson;

/**
 * A base landing servlet class that performs the initial user authorization and setup for a 
 * user logging into the system via the ASSISTments link in InBloom
 */
@WebServlet("/baselanding")
public class BaseLandingServlet extends HttpServlet {

	private static final long serialVersionUID = -786873652364971021L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public BaseLandingServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
								
		if(request.getParameter("code") == null) {
			response.sendRedirect(
					"https://api.sandbox.inbloom.org/api/oauth/authorize?response_type=" +
					"code&client_id=" + ApplicationSettings.getClient_id() + "&redirect_uri=" + 
							ApplicationSettings.getApplicationBasePath() + "/baselanding");
			return;
		} else {		

			try {
				performAccessTokenQuery(request);			
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect(ApplicationSettings.getApplicationBasePath() + "/failure_redirect.jsp");
			}
		}

		response.sendRedirect(ApplicationSettings.getApplicationBasePath() + "/userinformationimportservlet");
		
	}

	/**
	 * Query the InBloom service for an access token
	 * @param request this object's request object
	 * @throws Exception
	 */
	private void performAccessTokenQuery(HttpServletRequest request)
			throws Exception {
		String json = URLUtility.readUrl("https://api.sandbox.inbloom.org/api/oauth/token?" +
				"redirect_uri=" + 
			ApplicationSettings.getApplicationBasePath() + "/baselanding&grant_type=" +
			"authorization_code&client_id=" + ApplicationSettings.getClient_id() + 
			"&code=" + request.getParameter("code") + "&client_secret=" + 
			ApplicationSettings.getClient_secret());

		AccessTokenBean accessToken = new Gson().fromJson(json, AccessTokenBean.class);   

//		System.out.println("Setting up a new current user with token: " + accessToken.getAccess_token());
		
		setNewUser(accessToken);
		
	}

	/**
	 * Set a new user with a given access token
	 * @param accessToken the access token to assign to the new user
	 */
	private void setNewUser(AccessTokenBean accessToken) {
		User newUser = new User();
		newUser.setAccessToken(accessToken);
		ActiveUser.setActiveUser(newUser);
		ServletContext context = getServletContext();
		context.setAttribute("[activeUser]", newUser);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
