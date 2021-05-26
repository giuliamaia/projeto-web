/**
 * Confirmação de exclusão
 * @author Giulia
 */

function confirmar(codigo) {
	let resp = confirm('Deseja excluir o produto?')
	if(resp === true) {
		window.location.href = "deletar?codigo=" + codigo
	}
}