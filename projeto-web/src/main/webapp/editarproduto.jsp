<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar produtos</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
	<h1 align="center">Editar produto</h1>
	<form name=frmEdicao action="salvar">
		<table align="center">
			<tr>
				<td><input type="text" name="codigo" class="Caixa1" readonly
					value="<%out.print(request.getAttribute("codigo"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="preco" step="0.01" min="0.01"
					class="Caixa1"
					value="<%out.print(request.getAttribute("preco"));%>"></td>
			</tr>
			<tr>
				<td><input type="text"  name="descricao" maxlength="100" class="Caixa2"
						placeholder="Descrição"
						value="<%out.print(request.getAttribute("descricao"));%>"></td>
			</tr>
			<tr>
				<td><input type="button" value="Salvar"
					onclick="validarEdicao()" class="Botao"></td>
			</tr>
		</table>
	</form>
	<script src="scripts/validacao.js"></script>
</body>
</html>