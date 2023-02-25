<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="dam2.add.p21.resourcebundle.MiResourceBundle"%>
<nav>
	<a href="smartphones.html"><button class="boton">
			<%
				out.println(MiResourceBundle.traductor("smartphones"));
			%>
		</button></a> <a href="ordenadores.html"><button class="boton">
			<%
				out.println(MiResourceBundle.traductor("ordenadores"));
			%>
		</button></a> <a href="portatiles.html"><button class="boton">
			<%
				out.println(MiResourceBundle.traductor("portatiles"));
			%>
		</button></a>
	<button class="boton">
		<%
			out.println(MiResourceBundle.traductor("componentes"));
		%>
	</button>
	<button class="boton">
		<%
			out.println(MiResourceBundle.traductor("audioFotoVideo"));
		%>
	</button>
	<button class="boton">
		<%
			out.println(MiResourceBundle.traductor("televisores"));
		%>
	</button>
	<button class="boton">
		<%
			out.println(MiResourceBundle.traductor("tablets"));
		%>
	</button>
</nav>