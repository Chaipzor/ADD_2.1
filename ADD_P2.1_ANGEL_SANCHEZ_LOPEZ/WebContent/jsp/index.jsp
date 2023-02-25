<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./meta.jsp"%>
<title>Practica 2.1 ADD 2 Curso</title>
</head>
<body>
	<%@include file="./header.jsp"%>
	<div id='main'>

		<%@include file="./nav.jsp"%>

		<div class="panel">

			<%
				String admin = "";
				if (request.getSession().getAttribute("admin") != null) {
					admin = (String) request.getSession().getAttribute("admin");
					if (admin.equals("true")) {
			%>
			<%@include file="./lista_usuarios.jsp"%>
			<%
				}
			%>
			<%
				}
			%>
		</div>
	</div>

	<%@include file="./pie.jsp"%>

</body>
</html>