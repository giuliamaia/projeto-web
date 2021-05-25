package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Produto;
import dominio.Usuario;

@WebServlet(urlPatterns = {"/Controller", "/login", "/logon","/cadastrarUsuario", "/cadastrarProduto"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Produto produto = new Produto();
	Usuario usuario = new Usuario();
	
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/login")) {
			login(request, response);
		} else if(action.equals("/logon")) {
			logon(request, response);
		} else if (action.equals("/cadastrarUsuario")) {
			cadastrarUsuario(request, response);
		} else if (action.equals("/cadastrarProduto")) {
				cadastrarProduto(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}
	
	protected void logon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("logon.jsp");
	}
	
	protected void cadastrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		System.out.println(usuario.toString());
	}
	
	protected void cadastrarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		produto.setCodigo(request.getParameter("codigo"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setPreco(request.getParameter("preco"));
		System.out.println(produto.toString());
	}
}
