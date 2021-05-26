<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Logon</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
<h1 align="center">Entre na sua conta</h1>
<form name=frmLogon action="entrarNaConta">
		<table align="center">
			<tr>
				<td><input type="text" name="email" placeholder="E-mail" class=Caixa></td>
			</tr>
			<tr>
				<td><input type="password" name="senha" placeholder="Senha" class=Caixa></td>
			</tr>
			<tr>
				<td><input type="button" value="Acessar" onclick="validarLogon()" class=Botao></td>
			</tr>
		</table>
		
</form>
<script src="scripts/validacao.js"></script>
</body>
</html>