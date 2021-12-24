package projetobiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Livro implements Sistema {
	Scanner ler = new Scanner(System.in);
	ArrayList<Livro> livro = new ArrayList<>();
	Cliente cliente01 = new Cliente(null, null, 0, null, 0);

	private String titulo;
	private String categoria;
	private String autor;
	private int codigo;
	private int numeroPagina;
	private int quantidadeEstoque;
	boolean validado = false;
	String login;
	String acesso = " ";
	int senha;
	int x = 0;
	boolean confirma = false;

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
			if (login.equals("admin")) {
				do {
					System.out.println("Agora, digite sua senha: ");
					senha = ler.nextInt();
					if (senha == 123) {
						System.out.println("Acesso Liberado");
					} else {
						System.out.println("Senha incorreta!!! Digite novamente.");
					}
				} while (senha != 123);
			} else {
				System.out.println("Login incorreto!!! Digite novamente.");
			}
		} while ((login.equals("admin") == false) && (senha != 123));
		acesso = "liberado";
	}

	private void estoque() {
		if (acesso.equals("liberado") == true) {
			livro.add(new Livro("Naruto", "Manga", "Kishimoto", 123, 180, 5));
			livro.add(new Livro("Dragon ball", "Manga", "Kishimoto", 124, 180, 8));
			livro.add(new Livro("Homem Aranha", "Hq", "Stan Lee", 125, 200, 5));
			livro.add(new Livro("Capitão America", "Hq", "Stan Lee", 126, 100, 5));
			livro.add(new Livro("Um Livro", "Livro", "Algém", 127, 70, 5));
			livro.add(new Livro("AmendoBobo", "Livro", "Bob Esponja", 8789, 5000, 2));
		} else {
			System.out.println("Você não tem acesso ao estoque");
		}

	}

	@Override
	public void consultarEstoque() {
		if (acesso.equals("liberado") == true) {
			this.estoque();
			System.out.println(livro);
		} else {
			System.out.println("Você não tem acesso ao estoque");
		}

	}

	@Override
	public void cadastrarLivro() {
		if (acesso.equals("liberado") == true) {
			do {
				ler.nextLine();
				System.out.println("Digite o Titulo do livro: ");
				this.setTitulo(ler.nextLine());
				System.out.println("Informe a Categoria: ");
				this.setCategoria(ler.nextLine());
				System.out.println("Informe o Autor: ");
				this.setAutor(ler.nextLine());
				System.out.println("Informe o Código: ");
				int z = ler.nextInt();
				do {
					confirma = false;
					for (int y = 0; y < livro.size(); y++) {
						if (livro.get(y).codigo == z) {
							System.out.println("Código já existente. Digite outro código");
							z = ler.nextInt();
							confirma = true;
							break;
						}
					}
				} while (confirma == true);
				this.setCodigo(z);
				System.out.println("Informe a quantidade de paginas: ");
				this.setNumeroPagina(ler.nextInt());
				System.out.println("Quantidade em Estoque: ");
				this.setQuantidadeEstoque(ler.nextInt());
				livro.add(new Livro(this.titulo, this.categoria, this.autor, this.codigo, this.numeroPagina,
						this.quantidadeEstoque));
				System.out.println("Quer cadastrar mais algum livro?\nSe sim, digite 1 | Se não, digite 2.");
				x = ler.nextInt();
			} while (x == 1);
			System.out.println("Estoque atual: ");
			System.out.println(livro);

		} else {
			System.out.println("Você não tem acesso ao cadastro de livros");
		}

	}

	@Override
	public void retirarLivro() {
		if (acesso.equals("liberado") == true) {
			int y, check;
			//
			validado = cliente01.validarCpf();
			do {
			System.out.println("Qual livro será emprestado? ");
			y = ler.nextInt();
			System.out.println(livro.get(y));	
			System.out.println("Para confirmar, digite 1");
			System.out.println("Para cancelar, digite 2");
			check = ler.nextInt();
		} while(check != 1);
			if (livro.get(y).quantidadeEstoque > 0) {
				livro.get(y).setQuantidadeEstoque(livro.get(y).quantidadeEstoque - 1);
				cliente01.setLivroEmprestado(livro.get(y).titulo);
				cliente01.clienteRetirada();
				System.out.println("Livro emprestado!!! Muito obrigado\n");
				System.out.println("\nEstoque atual desse livro: \n" + livro.get(y));
			} else {
				System.out.println("Infelizmente não temos estoque desse livro");
			}

		} else {
			System.out.println("Você não tem acesso a devolução de livros");
		}

	}

	@Override
	public void devolverLivro() {
		if (acesso.equals("liberado") == true) {
			int y, check;
			do {
				System.out.println("Qual unidade você quer devolver?");
				y = ler.nextInt();
				System.out.println(livro.get(y));
				System.out.println("Para confirmar, digite 1");
				System.out.println("Para cancelar, digite 2");
				check = ler.nextInt();
			} while (check != 1);
			livro.get(y).setQuantidadeEstoque(livro.get(y).getQuantidadeEstoque() + 1);
			System.out.println("Livro Devolvido!!!\n");
			System.out.println(livro.get(y));
		} else {
			System.out.println("Você não tem acesso a devolução de livros");
		}

	}

	@Override
	public void excluirLivro() {
		if (acesso.equals("liberado") == true) {
			int y, check;
			do {
				System.out.println("Qual livro você quer excluir?");
				y = ler.nextInt();
				System.out.println(livro.get(y));
				System.out.println("Para confirmar, digite 1");
				System.out.println("Para cancelar, digite 2");
				check = ler.nextInt();
			} while (check != 1);
			livro.remove(y);
			System.out.println("Livro removido!!!\n");
			System.out.println(livro);
		} else {
			System.out.println("Você não tem acesso a devolução de livros");
		}

	}

	@Override
	public String toString() {
		return "\nLivro: " + titulo + "\nCategoria: " + categoria + "\nAutor: " + autor + "\nCodigo: " + codigo
				+ "\nNumeroPagina: " + numeroPagina + "\nQuantidade em Estoque: " + quantidadeEstoque
				+ "\n--------------------------";
	}

}
