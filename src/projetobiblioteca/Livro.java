package projetobiblioteca;

public class Livro {

	private String titulo;
	private String categoria;
	private String autor;
	private int codigo;
	private int posicaoEstoque;
	private int numeroPagina;
	private int quantidadeEstoque;
	
	public Livro() {
		
	}

	public Livro(String titulo, String categoria, String autor, int codigo, int posicaoEstoque, int numeroPagina,
			int quantidadeEsoque) {
		this.setTitulo(titulo);
		this.setCategoria(categoria);
		this.setAutor(autor);
		this.setCodigo(codigo);
		this.setPosicaoEstoque(posicaoEstoque);
		this.setNumeroPagina(numeroPagina);
		this.setQuantidadeEstoque(quantidadeEsoque);
	}

	@Override
	public String toString() {
		return "\nLivro: " + titulo + "\nCategoria: " + categoria + "\nAutor: " + autor + "\nCodigo: " + codigo
				+ "\nPosi??o no Estoque: " + posicaoEstoque + "\nNumeroPagina: " + numeroPagina
				+ "\nQuantidade em Estoque: " + quantidadeEstoque + "\n--------------------------";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPosicaoEstoque() {
		return posicaoEstoque;
	}

	public void setPosicaoEstoque(int posicaoEstoque) {
		this.posicaoEstoque = posicaoEstoque;
	}

	public int getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

}
