package projetobiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Controle implements Sistema {
	Scanner ler = new Scanner(System.in);
	Livro livro = new Livro(null, null, null, 0, 0, 0);
	Cliente cliente = new Cliente(null, null, 0, null, 0);
	ArrayList<Livro> listaLivro = new ArrayList<>();
	ArrayList<Cliente> listaCliente = new ArrayList<>();

	String login;
	String acesso = " ";
	int senha;
	boolean validado = false;

	int x;
	int localizarCliente;
	boolean confirma = false;

	private void estoque() {
		if (acesso.equals("liberado") == true) {
			listaLivro.add(new Livro("Naruto", "Manga", "Kishimoto", 123, 180, 5));
			listaLivro.add(new Livro("Dragon ball", "Manga", "Kishimoto", 124, 180, 8));
			listaLivro.add(new Livro("Homem Aranha", "Hq", "Stan Lee", 125, 200, 5));
			listaLivro.add(new Livro("Capit�o America", "Hq", "Stan Lee", 126, 100, 5));
			listaLivro.add(new Livro("Um Livro", "Livro", "Alg�m", 127, 70, 5));
			listaLivro.add(new Livro("AmendoBobo", "Livro", "Bob Esponja", 8789, 5000, 2));
		} else {
			System.out.println("Voc� n�o tem acesso ao estoque");
		}
	}

	private void cadastros() {
		if (acesso.equals("liberado") == true) {
			listaCliente.add(new Cliente("Willi", "Rua Suzano, 25", 1234567891, null, 0));
			listaCliente.add(new Cliente("Ramon", "Rua Suzano, 26", 23456789, null, 0));
			listaCliente.add(new Cliente("Sabino", "Rua Suzano, 27", 3465798, null, 0));

		} else {
			System.out.println("Voc� n�o tem acesso ao estoque");
		}
	}

	private void validarCpf() {
		System.out.println("Primeiramente, informe seu CPF");
		long y = ler.nextLong();
		do {
			confirma = false;
			for (x = 0; x < listaCliente.size(); x++) {
				if (listaCliente.get(x).getCpf() == y) {
					System.out.println("CPF encontrado!!!");
					confirma = true;
					localizarCliente = x;
				}
			}
			if (confirma == false) {
				System.out.println("CPF n�o encontrado! Digite novamente");
				y = ler.nextLong();
			}
		} while (confirma == false);
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
		this.estoque();
		this.cadastros();
	}

	@Override
	public void consultarEstoque() {
		if (acesso.equals("liberado") == true) {
			System.out.println("========CONSULTA DO ESTOQUE========");
			System.out.println(listaLivro);
		} else {
			System.out.println("Voc� n�o tem acesso ao estoque");
		}

	}

	@Override
	public void consultarCliente() {
		if (acesso.equals("liberado") == true) {
			System.out.println("========CONSULTA DE CADASTROS========");
			System.out.println(listaCliente);
		} else {
			System.out.println("Voc� n�o tem acesso ao estoque");
		}

	}

	@Override
	public void consultarPendencias() {
		if (acesso.equals("liberado") == true) {
			int n = 0;
			System.out.println("========PENDENCIAS===========");
			for (int y = 0; y < listaCliente.size(); y++) {
				if (listaCliente.get(y).getQuantidadeEmprestimo() > 0) {
					System.out.println(listaCliente.get(y));
					n++;
				}
			}
			if (n == 0) {
				System.out.println("N�o h� pend�ncias");
			}
		} else {
			System.out.println("Voc� n�o tem acesso ao estoque");
		}
	}

	@Override
	public void cadastrarLivro() {
		if (acesso.equals("liberado") == true) {
			System.out.println("========CADASTRAR EXEMPLAR========");
			do {
				ler.nextLine();
				System.out.println("Digite o Titulo do livro: ");
				livro.setTitulo(ler.nextLine());
				System.out.println("Informe a Categoria: ");
				livro.setCategoria(ler.nextLine());
				System.out.println("Informe o Autor: ");
				livro.setAutor(ler.nextLine());
				System.out.println("Informe o C�digo: ");
				int z = ler.nextInt();
				do {
					confirma = false;
					for (int y = 0; y < listaLivro.size(); y++) {
						if (listaLivro.get(y).getCodigo() == z) {
							System.out.println("C�digo j� existente. Digite outro c�digo");
							z = ler.nextInt();
							confirma = true;
							break;
						}
					}
				} while (confirma == true);
				livro.setCodigo(z);
				System.out.println("Informe a quantidade de paginas: ");
				livro.setNumeroPagina(ler.nextInt());
				System.out.println("Quantidade em Estoque: ");
				livro.setQuantidadeEstoque(ler.nextInt());
				listaLivro.add(new Livro(livro.getTitulo(), livro.getCategoria(), livro.getAutor(), livro.getCodigo(),
						livro.getNumeroPagina(), livro.getQuantidadeEstoque()));
				System.out.println("Quer cadastrar mais algum livro?\nSe sim, digite 1 | Se n�o, digite 2.");
				x = ler.nextInt();
			} while (x == 1);
			System.out.println("Estoque atual: ");
			System.out.println(listaLivro);

		} else {
			System.out.println("Voc� n�o tem acesso ao cadastro de livros");
		}
	}

	@Override
	public void cadastrarCliente() {
		if (acesso.equals("liberado") == true) {
			System.out.println("========CADASTRAR CLIENTE========");
			do {
				ler.nextLine();
				System.out.println("TELA PARA CADASTRAR CLIENTE");
				System.out.println("Digite o nome do Cliente");
				cliente.setNomeCliente(ler.nextLine());
				System.out.println("Digite o endere�o do Cliente");
				cliente.setEnderecoCliente(ler.nextLine());
				System.out.println("Digite o CPF do Cliente");
				int z = ler.nextInt();
				do {
					confirma = false;
					for (int y = 0; y < listaCliente.size(); y++) {
						if (listaCliente.get(y).getCpf() == z) {
							System.out.println("CPF j� existente. Digite outro CPF");
							z = ler.nextInt();
							confirma = true;
							break;
						}
					}
				} while (confirma == true);
				cliente.setCpf(z);
				listaCliente.add(new Cliente(cliente.getNomeCliente(), cliente.getEnderecoCliente(), cliente.getCpf(),
						cliente.getLivroEmprestado(), cliente.getQuantidadeEmprestimo()));
				System.out.println("Quer cadastrar mais algum Cliente?\nSe sim, digite 1 | Se n�o, digite 2.");
				x = ler.nextInt();
			} while (x == 1);
			System.out.println("Cliente Cadastrado!!!");
			System.out.println(listaCliente);
		} else {
			System.out.println("Voc� n�o tem acesso ao cadastro de livros");
		}
	}

	@Override
	public void retirarLivro() {
		if (acesso.equals("liberado") == true) {
			System.out.println("========EMPRESTAR EXEMPLAR========");
			this.consultarEstoque();
			int y, check;
			System.out.println("Voc� tem cadastro em nossa Biblioteca?");
			System.out.println("Se Sim, Digite 1\nSe n�o, Digite 2");
			int confirme = ler.nextInt();
			if(confirme == 2) {
				this.cadastrarCliente();
			}
			this.validarCpf();
			if (listaCliente.get(localizarCliente).getQuantidadeEmprestimo() == 0) {
				do {
					System.out.println("Qual livro ser� emprestado? ");
					y = ler.nextInt();
					System.out.println(listaLivro.get(y));
					System.out.println("Para confirmar, digite 1");
					System.out.println("Para cancelar, digite 2");
					check = ler.nextInt();
				} while (check != 1);
				if (listaLivro.get(y).getQuantidadeEstoque() > 0) {
					listaLivro.get(y).setQuantidadeEstoque(listaLivro.get(y).getQuantidadeEstoque() - 1);
					listaCliente.get(localizarCliente).setLivroEmprestado(listaLivro.get(y).getTitulo());
					listaCliente.get(localizarCliente)
							.setQuantidadeEmprestimo(listaCliente.get(localizarCliente).getQuantidadeEmprestimo() + 1);
					System.out.println("Livro emprestado!!! Muito obrigado\n");
					System.out.println("\nEstoque atual desse livro: \n" + listaLivro.get(y));
					System.out.println("\nDados do Cliente: \n" + listaCliente.get(localizarCliente));
				} else {
					System.out.println("Infelizmente n�o temos estoque desse livro");
				}
			} else {
				System.out.println(
						"N�o ser� poss�vel realizar novo emprestimo! Cliente precisa devolver ultimo exemplar");
			}

		} else {
			System.out.println("Voc� n�o tem acesso a devolu��o de livros");
		}

	}

	@Override
	public void devolverLivro() {
		if (acesso.equals("liberado") == true) {
			System.out.println("========DEVOLU��O DE EXEMPLAR========");
			int localizaLivro=0, check;
			do {
				this.validarCpf();
				while (listaCliente.get(localizarCliente).getQuantidadeEmprestimo() == 0) {
					System.out.println("Cliente n�o possui nenhum livro para ser devolvido.");
					this.validarCpf();
				}
				System.out.println("O Cliente " + listaCliente.get(localizarCliente).getNomeCliente()
						+ " deseja devolver o livro " + listaCliente.get(localizarCliente).getLivroEmprestado() + "?");
				System.out.println("Para confirmar, digite 1");
				System.out.println("Para cancelar, digite 2");
				check = ler.nextInt();
				if (check == 2) {
					System.out.println("Sendo assim, digite outro CPF");
				}
			} while (check != 1);
			for(int y = 0; y < listaLivro.size(); y++) {
				if(listaLivro.get(y).getTitulo().equals(listaCliente.get(localizarCliente).getLivroEmprestado())) {
					localizaLivro = y;
				}
			}
			listaLivro.get(localizaLivro).setQuantidadeEstoque(listaLivro.get(localizaLivro).getQuantidadeEstoque() + 1);
			listaCliente.get(localizarCliente).setLivroEmprestado(null);
			listaCliente.get(localizarCliente)
					.setQuantidadeEmprestimo(listaCliente.get(localizarCliente).getQuantidadeEmprestimo() - 1);
			System.out.println("Livro Devolvido!!!\n");
			System.out.println(listaLivro.get(localizaLivro));
			System.out.println("\nDados do Cliente: \n" + listaCliente.get(localizarCliente));
		} else {
			System.out.println("Voc� n�o tem acesso a devolu��o de livros");
		}

	}

	@Override
	public void excluirLivro() {
		if (acesso.equals("liberado") == true) {
			System.out.println("========EXCLUIR REGISTRO DE EXEMPLAR========");
			int y, check;
			do {
				System.out.println("Qual livro voc� quer excluir?");
				y = ler.nextInt();
				System.out.println(listaLivro.get(y));
				System.out.println("Para confirmar, digite 1");
				System.out.println("Para cancelar, digite 2");
				check = ler.nextInt();
			} while (check != 1);
			listaLivro.remove(y);
			System.out.println("Livro removido!!!\n");
			System.out.println(listaLivro);
		} else {
			System.out.println("Voc� n�o tem acesso a devolu��o de livros");
		}

	}

	@Override
	public void excluirCliente() {
		if (acesso.equals("liberado") == true) {
			System.out.println("========EXCLUIR CADASTRO========");
			int y, check;
			do {
				System.out.println("Qual Cadastro voc� quer excluir?");
				y = ler.nextInt();
				System.out.println(listaCliente.get(y));
				System.out.println("Para confirmar, digite 1");
				System.out.println("Para cancelar, digite 2");
				check = ler.nextInt();
			} while (check != 1);
			listaCliente.remove(y);
			System.out.println("Cadastro removido!!!\n");
			System.out.println(listaCliente);
		} else {
			System.out.println("Voc� n�o tem acesso a devolu��o de livros");
		}

	}

}
