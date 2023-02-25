<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="dam2.add.p21.resourcebundle.MiResourceBundle"%>
<footer>

	<div class="container-footer-top">

		<div class="columna1">
			<h1>
				<%
					out.println(MiResourceBundle.traductor("informacionAdicional"));
				%>
			</h1>

			<p>
				<%
					out.println(MiResourceBundle.traductor("textoEnvios"));
				%>
			</p>

		</div>

		<div class="columna2">

			<h1>
				<%
					out.println(MiResourceBundle.traductor("redes"));
				%>
			</h1>

			<div class="fila">
				<a href="https://www.facebook.com/" target="_blank"><img
					src="${pageContext.request.contextPath}/img/rrss/facebook.png"></a>
				<label>
					<%
						out.println(MiResourceBundle.traductor("facebook"));
					%>
				</label>
			</div>

			<div class="fila">
				<a href="https://twitter.com/home" target="_blank"><img
					src="${pageContext.request.contextPath}/img/rrss/gorjeo.png"></a>
				<label>
					<%
						out.println(MiResourceBundle.traductor("twitter"));
					%>
				</label>
			</div>

			<div class="fila">
				<a href="https://www.instagram.com/?hl=es" target="_blank"><img
					src="${pageContext.request.contextPath}/img/rrss/instagram.png"></a>
				<label>
					<%
						out.println(MiResourceBundle.traductor("instagram"));
					%>
				</label>
			</div>

			<div class="fila">
				<a href="https://www.youtube.com/" target="_blank"><img
					src="${pageContext.request.contextPath}/img/rrss/youtube.png"></a>
				<label>
					<%
						out.println(MiResourceBundle.traductor("youtube"));
					%>
				</label>
			</div>

		</div>

		<div class="columna3">

			<h1>
				<%
					out.println(MiResourceBundle.traductor("informacionContacto"));
				%>
			</h1>

			<div class="fila2">
				<a
					href="https://www.google.es/maps/place/C.+de+Alcal%C3%A1,+Madrid/@40.4202027,-3.6900634,17z/data=!3m1!4b1!4m5!3m4!1s0xd422f3f48cbf6a7:0xb7b3542e98264faf!8m2!3d40.4201986!4d-3.6878747?hl=es"
					target="_blank"><img
					src="${pageContext.request.contextPath}/img/Footer/casa.png"></a>
				<label>Calle Alcalá, 28008 Madrid</label>
			</div>

			<div class="fila2">
				<a href="tel:34-666-555-333"><img
					src="${pageContext.request.contextPath}/img/Footer/phone.png"></a>
				<label>+34 666 555 333</label>
			</div>

			<div class="fila2">
				<a href="mailto:Chaipzor@gmail.com"><img
					src="${pageContext.request.contextPath}/img/Footer/email.png"></a>
				<label>Chaipzor@gmail.com</label>
			</div>

		</div>

	</div>

	<div class="container-footer-bot">

		<div class="footer">

			<div class="copyright">
				<%
					out.println(MiResourceBundle.traductor("derechos"));
				%>
				| <a
					href="https://www.linkedin.com/in/%C3%A1ngel-s%C3%A1nchez-l%C3%B3pez-98238723/">Ángel
					Sánchez</a>
			</div>

			<div class="informacion">
				<a href="">
					<%
						out.println(MiResourceBundle.traductor("condicionesGenerales"));
					%>
				</a> | <a href="">
					<%
						out.println(MiResourceBundle.traductor("privacidad"));
					%>
				</a> | <a href="">
					<%
						out.println(MiResourceBundle.traductor("cookies"));
					%>
				</a>
			</div>

		</div>
	</div>
</footer>
