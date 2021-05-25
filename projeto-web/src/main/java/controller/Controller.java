package controller;

import java.awt.HeadlessException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.classes.Produto;
import model.classes.Usuario;
import model.repositorios.RepositorioProdutos;
import model.repositorios.RepositorioUsuarios;

@WebServlet(urlPatterns = { "/Controller", 
							"/login", 
							"/logon", 
							"/cadastrarUsuario", 
							"/cadastrarProduto",
							"/entrarNaConta"})

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RepositorioProdutos listaProdutos = new RepositorioProdutos();
	RepositorioUsuarios listaUsuarios = new RepositorioUsuarios();

	
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
		if (action.equals("/login")) {
			login(request, response);
		} else if(action.equals("/logon")) {
			logon(request, response);
		}  else if (action.equals("/cadastrarUsuario")) {
			cadastrarUsuario(request, response);
		} else if (action.equals("/cadastrarProduto")) {
			cadastrarProduto(request, response);
		}else if (action.equals("/entrarNaConta")) {
			entrarNaConta(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	private void entrarNaConta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(listaUsuarios.buscarEmailESenha(request.getParameter("email"), request.getParameter("senha"))) {
			response.sendRedirect("listagemprodutos.jsp");
			System.out.println("entrou!");
		} else if(listaUsuarios.buscarEmail(request.getParameter("email"))) {
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Senha errada!');"); 
			out.println("location='logon.jsp';");
			out.println("</script>");
			System.out.println("senha errada!");
		} else {
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Você ainda não é cadastrado!');"); 
			out.println("location='index.jsp';");
			out.println("</script>");
			System.out.println("cadastre-se!");
		}
		
	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}
	
	protected void logon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("logon.jsp");
	}
	
	protected void cadastrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		listaUsuarios.adicionarUsuario(usuario);
		System.out.println(listaUsuarios.toString());
		logon(request, response);
	}
	
	protected void cadastrarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, HeadlessException {
		if(listaProdutos.buscarCodigo(request.getParameter("codigo"))) {
			Produto produto = new Produto();
			produto.setCodigo(request.getParameter("codigo"));
			produto.setDescricao(request.getParameter("descricao"));
			produto.setPreco(request.getParameter("preco"));
			listaProdutos.adicionarProduto(produto);
			System.out.println(listaProdutos.toString());
			response.sendRedirect("listagemprodutos.jsp");
		} else {
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Código já cadastrado!');"); 
			out.println("location='cadastroproduto.jsp';");
			out.println("</script>");
		}
	}

	protected void popularLista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listaProdutos.adicionarProduto(new Produto("001", "torta de abacaxi", "10.00"));
		listaProdutos.adicionarProduto(new Produto("002", "torta de maça", "15.00"));
		listaProdutos.adicionarProduto(new Produto("003", "torta de abacate", "20.00"));
		listaProdutos.adicionarProduto(new Produto("004", "torta de chuchu", "5.00"));
	}
	protected void listarProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		popularLista(request, response);
		System.out.println(listaProdutos.toString());
		RequestDispatcher rd = request.getRequestDispatcher("/listagemprodutos.jsp");
		request.setAttribute("produtos", listaProdutos.listarProdutos());
		rd.forward(request, response);
	}
}
