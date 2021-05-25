package model.classes;

import java.io.Serializable;



public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private String email;
	private String senha;
	
	public Usuario() {
		
	}
	
	public Usuario(int id, String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
	
	
	
}