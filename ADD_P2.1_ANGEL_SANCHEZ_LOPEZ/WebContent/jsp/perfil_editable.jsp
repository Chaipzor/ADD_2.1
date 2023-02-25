<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

		String nom = "";
		if (request.getAttribute("nombre") != null)
			nom = (String) request.getAttribute("nombre");

		String apellidos = "";
		if (request.getAttribute("apellidos") != null)
			apellidos = (String) request.getAttribute("apellidos");

		String email = "";
		if (request.getAttribute("email") != null)
			email = (String) request.getAttribute("email");

		String telefono = "";
		if (request.getAttribute("telefono") != null)
			telefono = (String) request.getAttribute("telefono");

		String emailsesion = "";
		if (request.getSession().getAttribute("emailsesion") != null) {
			emailsesion = (String) request.getSession().getAttribute("emailsesion");
		}

		int editId = 0;
		String editIdText = "PERFIL";
		boolean showmenu = true;
		if (request.getSession().getAttribute("editid") != null) {
			editId = (Integer) request.getSession().getAttribute("editid");
			showmenu = false;
			editIdText = "Editando el perfil de " + emailsesion;
		}
	%>

	<%@include file="./header.jsp"%>

	<div id='main'>

		<%@include file="./nav.jsp"%>

		<div class="panel">
			<div class="caja">
				<div class="contenedor-perfil">
					<div class="contenedor-perfil">
						<div class="menu-perfil">
							<%
								if (showmenu) {
							%>
							<%@include file="./cabecera_edit.jsp"%>
							<%
								}
							%>
						</div>
					</div>
					<div class="contenedor">
						<div class="separador"></div>
						<div class="titulo">
							<%
								out.println(editIdText);
							%>
						</div>
						<div class="subtitulo">
							<%
								out.println(texto);
							%>
						</div>
						<div class="login-item">
							<form action="<%=request.getContextPath()%>/editar" method="post"
								class="form form-login">
								<div class="form-field">

									<label for="nombre">
										<%
											out.println(MiResourceBundle.traductor("nombre"));
										%>
									</label> <input name="nombre" id="username" type="text"
										class="form-input" value="<%out.println(nom);%>">
								</div>
								<div class="form-field">

									<label for="apellidos">
										<%
											out.println(MiResourceBundle.traductor("apellidos"));
										%>
									</label> <input name="apellidos" id="apellidos" type="text"
										class="form-input" value="<%out.println(apellidos);%>">
								</div>
								<div class="form-field">

									<label for="email">
										<%
											out.println(MiResourceBundle.traductor("email"));
										%>
									</label> <input name="email" id="email" type="text" class="form-input"
										value="<%out.println(email);%>">
								</div>
								<div class="form-field">

									<label for="telefono">
										<%
											out.println(MiResourceBundle.traductor("telefono"));
										%>
									</label> <input name="telefono" maxlength="9" id="telefono" type="text"
										class="form-input" value="<%out.println(telefono);%>">
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