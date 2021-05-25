<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Cadastro de Usuário</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
<h1>Cadastro de Usuário</h1>
<form name=frmUsuario action="cadastrarUsuario">
		<table>
			<tr>
				<td><input type="text" name="nome" placeholder="Nome" class=Caixa></td>
			</tr>
			<tr>
				<td><input type="text" name="email" placeholder="E-mail" class=Caixa></td>
			</tr>
			<tr>
				<td><input type="password" name="senha" placeholder="Senha" class=Caixa></td>
			</tr>
		</table>
		<input type="button" value="Cadastrar" onclick="validarUsuario()" class=Botao>
	</form>
<script src="scripts/validacao.js"></script>
</body>
</html>