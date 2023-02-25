<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="dam2.add.p21.resourcebundle.MiResourceBundle"%>

<div>
	<a href="${pageContext.request.contextPath}/perfil"><button
			class="login">
			<i class="fa fa-user-o"></i> ${nombresesion}
		</button></a>
</div>
<div>
	<a href="${pageContext.request.contextPath}/cerrarsesion"><button
			class="login">
			<i class="fa fa-sign-out"></i> <%
				out.println(MiResourceBundle.traductor("cerrarSesion"));
			%>
		</button></a>
</div>

