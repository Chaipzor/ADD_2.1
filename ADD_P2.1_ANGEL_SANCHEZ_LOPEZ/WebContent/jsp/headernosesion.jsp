<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="dam2.add.p21.resourcebundle.MiResourceBundle"%>
<div>
	<a href="${pageContext.request.contextPath}/jsp/login.jsp"><button
			class="login">
			<i class="fa fa-user-o"></i>
			<%
				out.println(MiResourceBundle.traductor("acceso"));
			%>
		</button></a>
</div>
<div>
	<a href="${pageContext.request.contextPath}/jsp/registro.jsp"><button
			class="login">
			<i class="fa fa-user-o"></i>
			<%
				out.println(MiResourceBundle.traductor("registro"));
			%>
		</button></a>
</div>