<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<a href="${pageContext.request.contextPath}/perfil"><button
			class="login">
			<i class="fa fa-user-o"></i>
			${nombresesion}
		</button></a>
</div>
<div>
	<a href="${pageContext.request.contextPath}/cerrarsesion"><button
			class="login">
			<i class="fa fa-sign-out"></i> CERRAR SESIÓN
		</button></a>
</div>

