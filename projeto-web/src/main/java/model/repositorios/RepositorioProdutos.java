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
	
	public ArrayList<Produto> listarProdutos(){
		return produtos;
	}
	
	//verifica a existencia do produto pelo codigo
	public boolean buscarCodigo(String cod) {
		for(int i = 0; i < produtos.size(); i++) {
			if(produtos.get(i).getCodigo().equals(cod)) {
				return false;
			}
		}
		return true;
	}
	
	//pesquisa produto pelo codigo e retorna index dele
	public int retornaIndex(String cod) {
		int ret = 0;
		for(int i = 0; i < produtos.size(); i++) {
			if(produtos.get(i).getCodigo().equals(cod)) {
				ret = i;
			}
		}
		return ret;
	}
	
	//pesquisa produto pelo codigo e retorna ele
	public Produto retornaProduto(String cod) {
		Produto ret = new Produto();
		for(int i = 0; i < produtos.size(); i++) {
			if(produtos.get(i).getCodigo().equals(cod)) {
				ret = produtos.get(i);
			}
		}
		return ret;
	}
	
	public void editarProduto(String codigo, String descricao, String preco) {
		Produto editado = new Produto(codigo, descricao, preco);
		produtos.remove(retornaIndex(codigo));
		produtos.add(editado);
	}
	
	public void removerProduto(String codigo) {
		produtos.remove(retornaIndex(codigo));
	}
	
	@Override
	public String toString() {
		return "RepositorioProdutos [produtos=" + produtos + "]";
	}
	
	

}
