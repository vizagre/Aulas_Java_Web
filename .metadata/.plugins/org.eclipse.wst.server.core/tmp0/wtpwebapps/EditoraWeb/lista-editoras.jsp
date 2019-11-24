<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*,
			br.com.didata.servlets.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar editoras</title>
</head>
<body>
	<table>
		<%
			Editora editora = new Editora();
			EditoraDAO dao = new EditoraDAO();
			List<Editora> editoras = dao.listaEditora();
			for (Editora e : editoras) {
		%>
		<tr>
			<td><%=e.getIdEditora()%></td>
			<td><%=e.getNomeEditora()%></td>
			<td><%=e.getEmailEditora()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>