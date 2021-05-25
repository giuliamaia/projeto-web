package model.repositorios;

import java.util.ArrayList;

import model.classes.Produto;

public class RepositorioProdutos {

	private ArrayList<Produto> produtos = new ArrayList<>();
	
	public RepositorioProdutos() {
		super();
		
	}

	public void adicionarProduto(Produto prod) {
		produtos.add(prod);
	}
	
	public void removerProduto(Produto prod) {
		produtos.remove(prod);
	}
	
	public ArrayList<Produto> listarProdutos(){
		return produtos;
	}
	
	public boolean buscarCodigo(String cod) {
		for(int i = 0; i < produtos.size(); i++) {
			if(produtos.get(i).getCodigo().equals(cod)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "RepositorioProdutos [produtos=" + produtos + "]";
	}
	
	

}
