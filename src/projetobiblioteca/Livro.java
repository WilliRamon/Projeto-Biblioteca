package projetobiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Livro implements Sistema{
	Scanner ler = new Scanner(System.in);
	ArrayList<Livro> livro = new ArrayList<>();
	
	private String titulo;
	private String categoria;
	private String autor;
	private int codigo;
	private int numeroPagina;
	private int quantidadeEstoque;
	String login;
	int senha;
	String acesso = " ";
	int x = 0;
	
	
	
	public Livro(String titulo, String categoria, String autor, int codigo, int numeroPagina, int quantidadeEsoque) {
		this.setTitulo(titulo);
		this.setCategoria(categoria);
		this.setAutor(autor);
		this.setCodigo(codigo);
		this.setNumeroPagina(numeroPagina);
		this.setQuantidadeEstoque(quantidadeEsoque);
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





	@Override
	public void acesso() {
		do {
		System.out.println("Para ter acesso ao Sistema, primeiro, digite seu login: ");
		login = ler.nextLine();
		if(login.equals("admin")) {
			do {
			System.out.println("Agora, digite sua senha: ");
			senha = ler.nextInt();
			if(senha == 123) {
				System.out.println("Acesso Liberado");
			}else {
				System.out.println("Senha incorreta!!! Digite novamente.");
			}}while(senha != 123);
		}else {
			System.out.println("Login incorreto!!! Digite novamente.");
		}
		}while((login.equals("admin") == false) && (senha != 123));
		acesso = "liberado";
	}
	
	@Override
	public void estoque() {
		if(acesso.equals("liberado") == true) {
			livro.add(new Livro("Naruto", "Manga", "Kishimoto", 123, 180, 5));
			livro.add(new Livro("Dragon ball", "Manga", "Kishimoto", 124, 180, 8));
			livro.add(new Livro("Homem Aranha", "Hq", "Stan Lee", 125, 200, 5));
			livro.add(new Livro("Capit�o America", "Hq", "Stan Lee", 126, 100, 5));
			livro.add(new Livro("Um Livro", "Livro", "Alg�m", 127, 70, 5));
		}else {
			System.out.println("Voc� n�o tem acesso ao estoque");
		}
		
	}


	@Override
	public void consultarEstoque() {
		if(acesso.equals("liberado") == true) {
			this.estoque();
			System.out.println(livro);
		}else {
			System.out.println("Voc� n�o tem acesso ao estoque");
		}
		
	}





	@Override
	public void cadastrarLivro() {
		if(acesso.equals("liberado") == true) {
			do {
				System.out.println("Digite o Titulo do livro: ");
				this.setTitulo(ler.nextLine());
				System.out.println("Informe a Categoria: ");
				this.setCategoria(ler.nextLine());
				System.out.println("Informe o Autor: ");
				this.setAutor(ler.nextLine());
				System.out.println("Informe o C�digo: ");
				this.setCodigo(ler.nextInt());
				System.out.println("Informe a quantidade de paginas: ");
				this.setNumeroPagina(ler.nextInt());
				System.out.println("Quantidade em Estoque: ");
				this.setQuantidadeEstoque(ler.nextInt());
				
				System.out.println("Quer cadastrar mais algum livro?\nSe sim, digite 1 | Se n�o, digite 2.");
				x = ler.nextInt();
			}while(x != 1);
			
		}else {
			System.out.println("Voc� n�o tem acesso ao cadastro de livros");
		}
		
	}





	@Override
	public void retirarLivro() {
		if(acesso.equals("liberado") == true) {
			System.out.println("Voc� tem acesso a devolu��o de livros");
		}else {
			System.out.println("Voc� n�o tem acesso a devolu��o de livros");
		}
		
	}





	@Override
	public void devolverLivro() {
		if(acesso.equals("liberado") == true) {
			System.out.println("Voc� tem acesso a devolu��o de livros");
		}else {
			System.out.println("Voc� n�o tem acesso a devolu��o de livros");
		}
		
	}





	@Override
	public String toString() {
		return "Livro: " + titulo + ", categoria: " + categoria + ", autor: " + autor + ", codigo: " + codigo
				+ ", numeroPagina: " + numeroPagina + ", Quantidade em Estoque: " + quantidadeEstoque + "\n";
	}
	
	
	

}