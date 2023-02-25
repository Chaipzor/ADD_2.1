<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="dam2.add.p21.resourcebundle.MiResourceBundle"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="contenedorTabla">
	<title>JavaScript confirmation box</title>
	<script>
		function confirmation(button) {

			var href = button.getAttribute("href");
			console.log(href);
			var result = confirm("Esto eliminará al usuario, ¿estás seguro?");

			if (result) {
				//Si clicas si, redirige al link de eliminación.
				window.location.href = href;
			} else {

				return false;
			}
		}
	</script>
	<table>
		<thead>
			<tr>
				<th>
					<%
						out.println(MiResourceBundle.traductor("nombre"));
					%>
				</th>
				<th>
					<%
						out.println(MiResourceBundle.traductor("apellidos"));
					%>
				</th>
				<th>
					<%
						out.println(MiResourceBundle.traductor("email"));
					%>
				</th>
				<th>
					<%
						out.println(MiResourceBundle.traductor("telefono"));
					%>
				</th>
				<th>
					<%
						out.println(MiResourceBundle.traductor("editar"));
					%>
				</th>
				<th>
					<%
						out.println(MiResourceBundle.traductor("borrar"));
					%>
				</th>
		</thead>
		<c:forEach items="${listaContactos}" var="item">
			<tr>
				<td><c:out value="${item.nombre}" /></td>
				<td><c:out value="${item.apellidos}" /></td>
				<td><c:out value="${item.email}" /></td>
				<td><c:out value="${item.telefono}" /></td>
				<td><a id="editar" href="edit_admin?edit=${item.id}"></a></td>
				<td><button id="eliminar" class="supprimer"
						href="edit_admin?del=${item.id}" onclick="confirmation(this)"></button></td>
			</tr>
		</c:forEach>
	</table>
</div>