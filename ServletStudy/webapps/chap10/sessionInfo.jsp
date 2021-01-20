<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page session = "true" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<%
	Date time = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<html>
<head><title>세션 정보</title></head>
<body>
	세션 ID : <%= session.getId() %> <br>
	<%
		time.setTime(session.getCreationTime());
	%>
	세션 생성 시간 : <%= formatter.format(time) %> <br>
	<%
		time.setTime(session.getLastAccessedTime());
	%>
	최근 접근 시간 : <%= formatter.format(time) %> <br>

	User Id : <%= session.getAttribute("MEMBERID") %> <br>

	User name : <%= session.getAttribute("NAME") %> <br>

</body>
</html>
