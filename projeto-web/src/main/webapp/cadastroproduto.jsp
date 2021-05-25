<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro de produtos</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
	<h1>Cadastrar novo produto</h1>
	<form name=frmProduto action="cadastrarProduto">
		<table>
			<tr>
				<td><input type="number" name="codigo" placeholder="Código"
					min="1" class=Caixa1></td>
			</tr>
			<tr>
				<td><input type="number" name="preco" placeholder="Preço"
					step="0.01" min="0.01" class=Caixa1></td>
			</tr>
			<tr>
				<td><textarea name="descricao" placeholder="Descrição"
						maxlength="100" class=Caixa2></textarea></td>
			</tr>
		</table>
		<input type="button" value="Cadastrar" onclick="validarProduto()"
			class=Botao>
	</form>
	<script src="scripts/validacao.js"></script>
</body>
</html>