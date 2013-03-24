<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ page import="user.*, util.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<title>ASSISTments - Dashboard - <%= ActiveUser.getActiveUser().getSessionCheck().getFull_name() %></title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<!-- Stylesheets -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css"/>
	
<!-- Javascript -->
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>

<script>

$(document).ready(function() {

$('.sendReports').click(function() { 
		$.post('sendnotifications', function(responseObject) {	
			alert("Sent Notifications");
		});
	
		
});
	

$('.uploadToAssistments').click(function() { 
	
	$.post('assistmentscreateservlet', function(responseObject) {	
		alert("Added Class to Assistments...");
	});
	
});

});






</script>




</head>
<body>
<%
	User currentUser = (User) request.getAttribute("activeUser");
%>
<h3>Hello, <%= ActiveUser.getActiveUser().getSessionCheck().getFull_name() %></h3>
<p><%= currentUser.getSessionCheck().getUser_id() %></p>
<a href="http://192.168.1.118:3000/teacher">Go to ASSISTments</a>


<h2>These are all your classes:</h2>
<%
	for(int i = 0; i < ActiveUser.getActiveUser().getClassList().size(); i++) {
%> 
	<p><%= ActiveUser.getActiveUser().getClassList().get(i).getClassName() %></p>
<% 
	if( !ActiveUser.getActiveUser().getClassList().get(i).isInAssistments() ) {
%>
		<button class="uploadToAssistments">Upload to Assistments</button>
<%
	} else {
%>
		<button class="uploadToAssistments">Refresh Assistments</button>
<%
	}
%>
	<button class="inBloomUpload">Upload to InBloom</button>
	<button class="sendReports">Generate Reports and Notifications</button>
	
		
<%
	}
%>
</body>
</html>