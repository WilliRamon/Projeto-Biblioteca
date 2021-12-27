package projetobiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Controle implements Sistema {
	Scanner ler = new Scanner(System.in);
	Livro livro = new Livro(null, null, null, 0, 0, 0, 0);
	Cliente cliente = new Cliente(null, null, 0, 0, null, 0);
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
			listaLivro.add(new Livro("Alice's Adventures in Wonderland & Other Stories", "Livro", "Lewis Carroll", 123, 0, 1165, 5));
			listaLivro.add(new Livro("Box God of War - Volumes I & II", "Livro", "Matthew Stover e Robert E. Varderman", 124, 0, 765, 8));
			listaLivro.add(new Livro("A sutil arte de ligar o f*da-se", "Livro", "Mark Manson", 125, 0, 224, 10));
			listaLivro.add(new Livro("A Guerra dos Tronos. As Crônicas de Gelo e Fogo - Livro 1", "Livro", "George R. R. Martin", 10785, 0, 592, 5));
			listaLivro.add(new Livro("Pantera Negra: Uma Nação Sob Nossos Pés – Livro Um", "HQ", "Ta-Nehisi Coates", 7024, 0, 148, 9));
			listaLivro.add(new Livro("Pantera Negra: Uma Nação Sob Nossos Pés - Livro Dois", "HQ", "Ta-Nehisi Coates", 8076, 0, 144, 2));
			listaLivro.add(new Livro("Pantera Negra: Uma Nação Sob Nossos Pés - Livro Três", "HQ", "Ta-Nehisi Coates", 8083, 0, 148, 7));
			listaLivro.add(new Livro("Pantera Negra: Vingadores Do Novo Mundo - Livro Um", "HQ", "Ta-Nehisi Coates", 3131, 0, 144, 1));
			listaLivro.add(new Livro("Capitão América: Renascimento Capa dura", "HQ", "Ed Brubaker", 1526, 0, 340, 3));
			listaLivro.add(new Livro("Invasão Secreta", "HQ", "Brian Michael Bendis, Leinil Francis Yu", 4091, 0, 256, 12));
			listaLivro.add(new Livro("Naruto - Gold 67", "Manga", "Masashi Kishimoto", 9007, 0, 192, 5));
			listaLivro.add(new Livro("Naruto - Gold 68", "Manga", "Masashi Kishimoto", 8093, 0, 192, 10));
			listaLivro.add(new Livro("Naruto - Gold 69", "Manga", "Masashi Kishimoto", 7225, 0, 208, 13));
		} else {
			System.out.println("Você não tem acesso ao estoque");
		}
		for (int i = 0; i < listaLivro.size(); i++) {
			listaLivro.get(i).setPosicaoEstoque(i);
		}
	}

	private void cadastros() {
		if (acesso.equals("liberado") == true) {
			listaCliente.add(new Cliente("Naruto Uzumaki", "Konohagakure", 1234567891, 0, null, 0));
			listaCliente.add(new Cliente("Sasuke Uchiha", "Sem Residência Fixa", 23456789, 0, null, 0));
			listaCliente.add(new Cliente("Steven Rogers", "Lower East Side", 3465798, 0, null, 0));
			listaCliente.add(new Cliente("Ellie", "Jackson ", 456789, 0, null, 0));

		} else {
			System.out.println("Você não tem acesso ao estoque");
		}
		for (int i = 0; i < listaCliente.size(); i++) {
			listaCliente.get(i).setPosicaoCadastro(i);
		}
	}

	private void validarCpf() {
		System.out.println("Primeiramente, informe seu CPF sem o ultimo numero");
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
				System.out.println("CPF não encontrado! Digite novamente");
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
			System.out.println("Você não tem acesso ao estoque");
		}

	}

	@Override
	public void consultarCliente() {
		if (acesso.equals("liberado") == true) {
			System.out.println("========CONSULTA DE CADASTROS========");
			System.out.println(listaCliente);
		} else {
			System.out.println("Você não tem acesso ao estoque");
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
				System.out.println("Não há pendências");
			}
		} else {
			System.out.println("Você não tem acesso ao estoque");
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
				System.out.println("Informe o Código: ");
				int z = ler.nextInt();
				do {
					confirma = false;
					for (int y = 0; y < listaLivro.size(); y++) {
						if (listaLivro.get(y).getCodigo() == z) {
							System.out.println("Código já existente. Digite outro código");
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
						livro.getPosicaoEstoque(), livro.getNumeroPagina(), livro.getQuantidadeEstoque()));
				System.out.println("Quer cadastrar mais algum livro?\nSe sim, digite 1 | Se não, digite 2.");
				x = ler.nextInt();
			} while (x == 1);
			// Posição no estoque
			for (int i = 0; i < listaLivro.size(); i++) {
				listaLivro.get(i).setPosicaoEstoque(i);
			}
			System.out.println("Estoque atual: ");
			System.out.println(listaLivro);

		} else {
			System.out.println("Você não tem acesso ao cadastro de livros");
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
				System.out.println("Digite o endereço do Cliente");
				cliente.setEnderecoCliente(ler.nextLine());
				System.out.println("Digite o CPF do Cliente");
				int z = ler.nextInt();
				do {
					confirma = false;
					for (int y = 0; y < listaCliente.size(); y++) {
						if (listaCliente.get(y).getCpf() == z) {
							System.out.println("CPF já existente. Digite outro CPF");
							z = ler.nextInt();
							confirma = true;
							break;
						}
					}
				} while (confirma == true);
				cliente.setCpf(z);
				listaCliente.add(new Cliente(cliente.getNomeCliente(), cliente.getEnderecoCliente(), cliente.getCpf(),
						cliente.getPosicaoCadastro(), cliente.getLivroEmprestado(), cliente.getQuantidadeEmprestimo()));
				System.out.println("Quer cadastrar mais algum Cliente?\nSe sim, digite 1 | Se não, digite 2.");
				x = ler.nextInt();
			} while (x == 1);
			// Posição de Cadastro
			for (int i = 0; i < listaCliente.size(); i++) {
				listaCliente.get(i).setPosicaoCadastro(i);
			}
			System.out.println("Cliente Cadastrado!!!");
			System.out.println(listaCliente);
		} else {
			System.out.println("Você não tem acesso ao cadastro de livros");
		}
	}

	@Override
	public void retirarLivro() {
		if (acesso.equals("liberado") == true) {
			System.out.println("========EMPRESTAR EXEMPLAR========");
			this.consultarEstoque();
			int y, check;
			System.out.println("Você tem cadastro em nossa Biblioteca?");
			System.out.println("Se Sim, Digite 1\nSe não, Digite 2");
			int confirme = ler.nextInt();
			if (confirme == 2) {
				this.cadastrarCliente();
			}
			this.validarCpf();
			if (listaCliente.get(localizarCliente).getQuantidadeEmprestimo() == 0) {
				do {
					System.out.println("Qual livro será emprestado? \nDigite o Numero da Posição de Estoque");
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
					System.out.println("Infelizmente não temos estoque desse livro");
				}
			} else {
				System.out.println(
						"Não será possível realizar novo emprestimo! Cliente precisa devolver ultimo exemplar");
			}

		} else {
			System.out.println("Você não tem acesso a devolução de livros");
		}

	}

	@Override
	public void devolverLivro() {
		if (acesso.equals("liberado") == true) {
			System.out.println("========DEVOLUÇÃO DE EXEMPLAR========");
			int localizaLivro = 0, check;
			do {
				this.validarCpf();
				while (listaCliente.get(localizarCliente).getQuantidadeEmprestimo() == 0) {
					System.out.println("Cliente não possui nenhum livro para ser devolvido.");
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
			for (int y = 0; y < listaLivro.size(); y++) {
				if (listaLivro.get(y).getTitulo().equals(listaCliente.get(localizarCliente).getLivroEmprestado())) {
					localizaLivro = y;
				}
			}
			listaLivro.get(localizaLivro)
					.setQuantidadeEstoque(listaLivro.get(localizaLivro).getQuantidadeEstoque() + 1);
			listaCliente.get(localizarCliente).setLivroEmprestado(null);
			listaCliente.get(localizarCliente)
					.setQuantidadeEmprestimo(listaCliente.get(localizarCliente).getQuantidadeEmprestimo() - 1);
			System.out.println("Livro Devolvido!!!\n");
			System.out.println(listaLivro.get(localizaLivro));
			System.out.println("\nDados do Cliente: \n" + listaCliente.get(localizarCliente));
		} else {
			System.out.println("Você não tem acesso a devolução de livros");
		}

	}

	@Override
	public void excluirLivro() {
		if (acesso.equals("liberado") == true) {
			this.consultarEstoque();
			System.out.println("========EXCLUIR REGISTRO DE EXEMPLAR========");
			int y, check;
			do {
				System.out.println("Qual livro você quer excluir? Digite o Numero da Posição de Estoque");
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
			System.out.println("Você não tem acesso a devolução de livros");
		}

	}

	@Override
	public void excluirCliente() {
		if (acesso.equals("liberado") == true) {
			this.consultarCliente();
			;
			System.out.println("========EXCLUIR CADASTRO========");
			int y, check;
			do {
				System.out.println("Qual Cadastro você quer excluir? Digite o Numero da Posição de Cadastro");
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
			System.out.println("Você não tem acesso a devolução de livros");
		}

	}

}
