package model.repositorios;

import java.util.ArrayList;

import model.classes.Usuario;

public class RepositorioUsuarios {
	private ArrayList<Usuario> usuarios = new ArrayList<>();

	public RepositorioUsuarios() {
		super();
	}
	
	public void adicionarUsuario(Usuario user) {
		usuarios.add(user);
	}
	
	public boolean buscarEmail(String email) {
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean buscarEmailESenha(String email, String senha) {
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getEmail().equals(email) && usuarios.get(i).getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "RepositorioUsuarios [usuarios=" + usuarios + "]";
	}
	
	
	
}
