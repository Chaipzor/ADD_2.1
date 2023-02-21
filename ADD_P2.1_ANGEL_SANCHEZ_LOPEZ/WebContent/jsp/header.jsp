<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header class="header">
	<div class="barra-navegacion">
		<div class="logo">
			<a href="#"><img
				src="${pageContext.request.contextPath}/img/LOGO-WIPPI.png"></a>
		</div>
		<div class="menu">
			<div>
				<a href="#">OFERTAS</a>
			</div>
			<div>
				<a href="#">CONÓCENOS</a>
			</div>
			<div>
				<a href="#">SERVICIOS</a>
			</div>
		</div>
		<div class="buscar">
			<input type="search" name="" class="search" placeholder="Buscar...">
			<a href="#"><button class="boton-busqueda">Buscar</button></a>
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
					<i class="fa fa-shopping-cart"></i> CESTA
				</button>
			</div>
		</div>
	</div>

</header>