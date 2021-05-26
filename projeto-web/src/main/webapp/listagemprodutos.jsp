<%@ page import="javax.servlet.annotation.WebServlet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.classes.Produto" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Lista de produtos</title>
<link rel="stylesheet" href="style.css">
</head>
<%ArrayList<Produto> lista = (ArrayList<Produto>)request.getAttribute("produtos"); %>
<body>
	<form action="listarProdutos" method="get">
		<h1 align="center">Produtos cadastrados</h1>	
		<div align="center">
		<a href="cadastroproduto.jsp" class=Botao>Novo produto</a>
		</div>
		<table class="tabela">
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
				<%for (int i = 0; i < lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getCodigo() %></td>
					<td><%=lista.get(i).getDescricao() %></td>
					<td><%=lista.get(i).getPreco() %></td>
					<td><a href="editar?codigo=<%=lista.get(i).getCodigo()%>" class=BotaoEd>Editar</a></td>
					<td><a href="javascript: confirmar(<%=lista.get(i).getCodigo()%>)" class=BotaoEx>Excluir</a></td>
				<tr/>
				<%} %>
			</tbody>
		</table>
	</form>
</body>
<script src="scripts/confirmacao.js"></script>
</html>