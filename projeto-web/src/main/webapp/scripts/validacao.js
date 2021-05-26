/**
 * Validação dos formulários
 * @author Giulia
 */

function validarUsuario() {
	let nome = frmUsuario.nome.value
	let email = frmUsuario.email.value
	let senha = frmUsuario.senha.value

	if (nome === "") {
		alert('Preencha o campo Nome')
		frmUsuario.nome.focus()
		return false
	} else if (email === "") {
		alert('Preencha o campo E-mail')
		frmUsuario.email.focus()
		return false
	} else if (senha === "") {
		alert('Preencha o campo Senha')
		frmUsuario.senha.focus()
		return false
	} else {
		document.forms["frmUsuario"].submit()
	}
}

function validarProduto() {
	let codigo = frmProduto.codigo.value
	let descricao = frmProduto.descricao.value
	let preco = frmProduto.preco.value

	if (codigo === "") {
		alert('Preencha o campo Código')
		frmProduto.nome.focus()
		return false
	} else if (codigo <= 0) {
		alert('Preencha o campo Código com um valor maior que 0')
		frmProduto.nome.focus()
		return false
	} else if (descricao === "") {
		alert('Preencha o campo Descrição')
		frmProduto.email.focus()
		return false
	} else if (preco === "") {
		alert('Preencha o campo Preço')
		frmProduto.senha.focus()
		return false
	} else if (preco <= 0.00) {
		alert('Preencha o campo Preço com um valor maior que R$0')
		frmProduto.senha.focus()
		return false
	} else {
		document.forms["frmProduto"].submit()
	}
}

function validarEdicao() {

	let descricao = frmEdicao.descricao.value
	let preco = frmEdicao.preco.value

	if (descricao === "") {
		alert('Preencha o campo Descrição')
		frmEdicao.email.focus()
		return false
	} else if (preco === "") {
		alert('Preencha o campo Preço')
		frmEdicao.senha.focus()
		return false
	} else if (preco <= 0.00) {
		alert('Preencha o campo Preço com um valor maior que R$0')
		frmEdicao.senha.focus()
		return false
	} else {
		document.forms["frmEdicao"].submit()
	}
}

function validarLogon() {
	let email = frmLogon.email.value
	let senha = frmLogon.senha.value
	if(email === "") {
		alert('Digite seu email')
		frmLogon.email.focus()
		return false
	} else if(senha === "") {
		alert('Digite sua senha')
		frmLogon.senha.focus()
		return false
	} else {
		document.forms["frmLogon"].submit()
	} 
}