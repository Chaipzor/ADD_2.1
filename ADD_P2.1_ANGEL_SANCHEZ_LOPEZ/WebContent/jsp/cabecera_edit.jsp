<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="dam2.add.p21.resourcebundle.MiResourceBundle"%>

<div>
	<a href="${pageContext.request.contextPath}/modificardatos"><button
			class="login">
			<i class="fa fa-sign-out"></i>
			<%
				out.println(MiResourceBundle.traductor("modificarDatos"));
			%>
		</button></a>
</div>
<div>
	<a href="${pageContext.request.contextPath}/jsp/perfil_edit_pass.jsp"><button
			class="login">
			<i class="fa fa-sign-out"></i>
			<%
				out.println(MiResourceBundle.traductor("modificarPass"));
			%>
		</button></a>
</div>
