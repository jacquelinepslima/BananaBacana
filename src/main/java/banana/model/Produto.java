package banana.model;

import java.sql.SQLException;
import java.util.ArrayList;

import banana.dao.ProdutoDAO;

public class Produto {
	

	private int idProduto;
	private String descricao;
	private int quantidade;
	private double preco;
	private boolean onLine;
	
	//construtor vazio/padrão que cria o objeto quando a gente faz a chamada
	
	public Produto() {}
	

	
	public Produto(String descricao, int quantidade, double preco, boolean onLine) {
		super();
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.onLine = onLine;
	}



	// construtor que já pode setar os atributos de forma direta pelo parametro do construtor
	
	public Produto(int idProduto, String descricao, int quantidade, double preco, boolean onLine) {
		//com THIS para falar dos atributos e sem o THIS para falar dos parametros
		this.idProduto = idProduto;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.onLine = onLine;
	}



	public int getIdProduto() {
		return idProduto;
	}



	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	public double getPreco() {
		return preco;
	}



	public void setPreco(double preco) {
		this.preco = preco;
	}



	public boolean isOnLine() {
		return onLine;
	}



	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}

	public void salvar(Produto produto) throws ClassNotFoundException, SQLException {
		new ProdutoDAO().cadastrarProduto(produto);
	}
	
	public Produto consultarPorId(int id) throws ClassNotFoundException, SQLException, Exception {
		return new ProdutoDAO().buscarProdutoPorId(id);
	}
	
	public ArrayList<Produto> consultar(String descricao) throws ClassNotFoundException, SQLException {
		return new ProdutoDAO().consultarProdutosPorDescricao(descricao);
	}

	public void excluir(int idProduto) throws ClassNotFoundException, SQLException {
		new ProdutoDAO().excluirProduto(idProduto);
	}
	
	public void alterar(Produto produto) throws ClassNotFoundException, SQLException {
		new ProdutoDAO().alterarProduto(produto);
	}
}
