<%@page import="javax.security.auth.callback.TextOutputCallback"%>
<%@ page import="javax.servlet.annotation.WebServlet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.classes.Produto" %>
<% ArrayList<Produto> lista = (ArrayList<Produto>) request.getAttribute("produtos"); %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Lista de produtos</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
	<h1>Produtos cadastrados</h1>
	<a href="cadastroproduto.jsp" class=Botao>Novo produto</a>
	<table border="1">
		<thead>
			<tr>
				<th>Código</th>
				<th>Descrição</th>
				<th>Preço</th>
				<th>Editar</th>
				<th>Excluir</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
</body>
</html>