<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="dam2.add.p21.resourcebundle.MiResourceBundle"%>

<header class="header">
	<div class="barra-navegacion">
		<div class="logo">
			<a href="#"><img
				src="${pageContext.request.contextPath}/img/LOGO-WIPPI.png"></a>
		</div>
		<div class="menu">
			<div>
				<a href="#"> <%
 	out.println(MiResourceBundle.traductor("ofertas"));
 %>
				</a>
			</div>
			<div>
				<a href="#"> <%
 	out.println(MiResourceBundle.traductor("conocenos"));
 %>
				</a>
			</div>
			<div>
				<a href="#"> <%
 	out.println(MiResourceBundle.traductor("servicios"));
 %>
				</a>
			</div>
		</div>
		<div class="buscar">
			<input type="search" name="" class="search" placeholder="Buscar...">
			<a href="#"><button class="boton-busqueda">
					<%
						out.println(MiResourceBundle.traductor("buscar"));
					%>
				</button></a>
		</div>
		<div class="menu-botones">
			<%
				String sesion = (String) request.getSession().getAttribute("nombresesion");
				if (sesion != null) {
			%>
			<%@include file="./headersesion.jsp"%>
			<%
				} else {
			%>
			<%@include file="./headernosesion.jsp"%>
			<%
				}
			%>

			<div>
				<button class="login">
					<i class="fa fa-shopping-cart"></i>
					<%
						out.println(MiResourceBundle.traductor("cesta"));
					%>
				</button>
			</div>
			<div class="bandera">
				<a href="${pageContext.request.contextPath}/lang?lang=es"><img
					src="${pageContext.request.contextPath}/img/banderas/es.svg"></a>
			</div>
			<div class="bandera">
				<a href="${pageContext.request.contextPath}/lang?lang=en"><img
					src="${pageContext.request.contextPath}/img/banderas/gb.svg"></a>
			</div>
		</div>
	</div>

</header>