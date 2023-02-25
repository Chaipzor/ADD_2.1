<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="dam2.add.p21.resourcebundle.MiResourceBundle"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./meta.jsp"%>
<title>PERFIL</title>
</head>
<body>

	<%
		String texto = "";
		if (request.getAttribute("texto") != null)
			texto = (String) request.getAttribute("texto");
	%>

	<%@include file="./header.jsp"%>

	<div id='main'>

		<%@include file="./nav.jsp"%>

		<div class="panel">
			<div class="caja">
				<div class="contenedor-perfil">
					<div class="contenedor-perfil">
						<div class="menu-perfil">
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
								<a href="${pageContext.request.contextPath}/editarpass"><button
										class="login">
										<i class="fa fa-sign-out"></i>
										<%
											out.println(MiResourceBundle.traductor("modificarPass"));
										%>
									</button></a>
							</div>
						</div>
					</div>
					<div class="contenedor">
						<div class="separador"></div>
						<div class="titulo">
							<%
								out.println(MiResourceBundle.traductor("perfil"));
							%>
						</div>
						<div class="subtitulo">
							<%
								out.println(texto);
							%>
						</div>
						<div class="login-item">
							<form action="<%=request.getContextPath()%>/editarpass"
								method="post" class="form form-login">
								<div class="form-field">

									<label for="password">
										<%
											out.println(MiResourceBundle.traductor("pass"));
										%>
									</label> <input name="oldPass" id="login-password" type="password"
										class="form-input" placeholder="Contraseña" required>
								</div>
								<div class="form-field">

									<label for="password">
										<%
											out.println(MiResourceBundle.traductor("newPass"));
										%>
									</label> <input name="newPass" id="login-password" type="password"
										class="form-input" placeholder="Comprobación contraseña"
										required>
								</div>
								<div class="form-field">

									<label for="password">
										<%
											out.println(MiResourceBundle.traductor("newPass"));
										%>
									</label> <input name="newPass2" id="login-password" type="password"
										class="form-input" placeholder="Comprobación contraseña"
										required>
								</div>
								<div class="form-field">
									<input type="submit" name="boton" value="Editar">
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="separador"></div>
			</div>
		</div>
	</div>

	<%@include file="./pie.jsp"%>

</body>
</html>