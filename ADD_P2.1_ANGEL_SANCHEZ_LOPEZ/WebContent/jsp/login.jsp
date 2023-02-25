<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="dam2.add.p21.resourcebundle.MiResourceBundle"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./meta.jsp"%>
<title>LOGIN</title>
</head>
<body>

	<%
		String texto;
		// El título del formulario será "Inicio de sesión" a menos que recibamos otro texto de form.
		if (request.getAttribute("texto") != null)
			texto = (String) request.getAttribute("texto");
		else
			texto = "";
	%>

	<%@include file="./header.jsp"%>

	<div id='main'>

		<%@include file="./nav.jsp"%>

		<div class="panel">
			<div class="caja">

				<div class="contenedor">
					<div class="separador"></div>
					<div class="titulo">
						<%
							out.println(MiResourceBundle.traductor("acceso"));
						%>
					</div>
					<div class="subtitulo">
						<%
							out.println(texto);
						%>
					</div>
					<div class="login-item">
						<form action="<%=request.getContextPath()%>/login" method="post"
							class="form form-login">
							<div class="form-field">

								<label for="email">
									<%
										out.println(MiResourceBundle.traductor("email"));
									%>
								</label> <input name="email" id="email" type="email" class="form-input"
									placeholder="Email" required>
							</div>

							<div class="form-field">
								<label for="password">
									<%
										out.println(MiResourceBundle.traductor("pass"));
									%>
								</label> <input name="pass" id="password" type="password"
									class="form-input" placeholder="Contraseña" required>
							</div>

							<div class="form-field">
								<input type="submit" name="boton" value="Acceder">
							</div>
						</form>
						<form action="<%=request.getContextPath()%>/jsp/registro.jsp"
							method="post" class="form form-login">

							<div class="form-field">
								<input type="submit" name="boton" value="Darse de alta">
							</div>
						</form>
					</div>
					<div class="separador"></div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="./pie.jsp"%>

</body>
</html>