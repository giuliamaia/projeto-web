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
							"/cadastrarUsuario", 
							"/cadastrarProduto",
							"/entrarNaConta",
							"/listarProdutos",
							"/editar",
							"/salvar",
							"/deletar"})

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RepositorioProdutos listaProdutos = new RepositorioProdutos();
	public RepositorioUsuarios listaUsuarios = new RepositorioUsuarios();

	
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
		if (action.equals("/cadastrarUsuario")) {
			cadastrarUsuario(request, response);
		} else if (action.equals("/cadastrarProduto")) {
			cadastrarProduto(request, response);
		} else if (action.equals("/entrarNaConta")) {
			entrarNaConta(request, response);
		} else if (action.equals("/listarProdutos")) {
			listarProdutos(request, response);
		} else if (action.equals("/editar")) {
			editar(request, response);
		} else if (action.equals("/salvar")) {
			salvar(request, response);
		} else if (action.equals("/deletar")) {
			deletar(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	private void entrarNaConta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(listaUsuarios.buscarEmailESenha(request.getParameter("email"), request.getParameter("senha"))) {
			//direciono o usuario para a pagina de listagem de produtos
			response.sendRedirect("listarProdutos");
		} else if(listaUsuarios.buscarEmail(request.getParameter("email"))) {
			//informo ao usuario que a senha esta incorreta
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Senha errada!');"); 
			out.println("location='logon.jsp';");
			out.println("</script>");
		} else {
			//informo ao usuario que ele ainda não é cadastrado
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Você ainda não é cadastrado!');"); 
			out.println("location='index.jsp';");
			out.println("</script>");
		}
		
	}
	
	protected void cadastrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(listaUsuarios.buscarEmail(request.getParameter("email"))) {
			//informo ao usuario que o email que ele quer cadastrar já existe
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Esse email já é cadastrado');"); 
			out.println("location='index.jsp';");
			out.println("</script>");
		} else {
			//pego dados informados no form de cadastro, instancio e adiciono no repositorio de usuarios
			Usuario usuario = new Usuario(request.getParameter("nome"), request.getParameter("email"), request.getParameter("senha"));
			listaUsuarios.adicionarUsuario(usuario);
			//direciono o usuario para a pagina de logon
			response.sendRedirect("logon.jsp");
		}
	}
	
	protected void cadastrarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, HeadlessException {
		if(listaProdutos.buscarCodigo(request.getParameter("codigo"))) {
			//pego dados informados no form de cadastro, instancio e adiciono no repositorio de produtos
			Produto produto = new Produto(request.getParameter("codigo"), request.getParameter("descricao"), request.getParameter("preco"));
			listaProdutos.adicionarProduto(produto);
			//direciono o usuario para a pagina de listagem
			response.sendRedirect("listarProdutos");
		} else {
			//informa que o codigo já existe e retorna para cadastroproduto.jsp
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Código já cadastrado!');"); 
			out.println("location='cadastroproduto.jsp';");
			out.println("</script>");
		}
	}

	protected void listarProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setar lista de produtos salvos na memoria para listagemprodutos.jsp
		request.setAttribute("produtos", listaProdutos.listarProdutos());
		RequestDispatcher rd = request.getRequestDispatcher("listagemprodutos.jsp");
		rd.forward(request, response);
	}
	
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//seleciono o produto que vai ser editado
		Produto temp = listaProdutos.retornaProduto(request.getParameter("codigo"));
		System.out.println(temp.toString());
		//setar as informações do contado selecionado para editarproduto.jsp
		request.setAttribute("codigo", temp.getCodigo());
		request.setAttribute("descricao", temp.getDescricao());
		request.setAttribute("preco", temp.getPreco());
		RequestDispatcher rd = request.getRequestDispatcher("editarproduto.jsp");
		rd.forward(request, response);
	}
	
	protected void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//salvando dados editados na memoria
		listaProdutos.editarProduto(request.getParameter("codigo"), request.getParameter("descricao"), request.getParameter("preco"));
		//direcionando usuario para tela de listagem de produtos
		response.sendRedirect("listarProdutos");
	}
	
	protected void deletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//removo o produto do repositorio
		listaProdutos.removerProduto(request.getParameter("codigo"));
		//direciono para a pagina de listagem atualizada
		response.sendRedirect("listarProdutos");
	}
	
}
