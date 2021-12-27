package projetobiblioteca;

import java.util.Scanner;

public class SistemaBiblioteca {

	public static void main(String[] args) {

		Controle controle = new Controle();
		Scanner ler = new Scanner(System.in);
		int escolha = 0;

		controle.acesso();
		System.out.println("Seja bem vindo a mais um dia!!!");
		System.out.println("==================================================");
		System.out.println("Digite 1: Para Consultar o Estoque\n");
		System.out.println("Digite 2: Para Consultar Cadastros dos Clientes \n");
		System.out.println("Digite 3: Para Cadastrar Exemplar\n");
		System.out.println("Digite 4: Para Cadastrar Cliente\n");
		System.out.println("Digite 5: Para Emprestar Exemplar\n");
		System.out.println("Digite 6: Para Devolver Exemplar\n");
		System.out.println("Digite 7: Para Excluir Exemplar\n");
		System.out.println("Digite 8: Para Excluir Cadastro de Cliente\n");
		System.out.println("Digite 9: Para Consular Pendências\n");
		System.out.println("Digite 10: Para Sair");
		System.out.println("==================================================");
		escolha = ler.nextInt();

		while (escolha != 10) {

			switch (escolha) {
			case 1:
				controle.consultarEstoque();
				break;
			case 2:
				controle.consultarCliente();
				break;
			case 3:
				controle.cadastrarLivro();
				break;
			case 4:
				controle.cadastrarCliente();
				break;
			case 5:
				controle.retirarLivro();
				break;
			case 6:
				controle.devolverLivro();
				break;
			case 7:
				controle.excluirLivro();
				break;
			case 8:
				controle.excluirCliente();
				break;
			case 9:
				controle.consultarPendencias();
				break;
			default:
				System.out.println("Comando não encontrado");
				break;
			}
			System.out.println("==================================================");
			System.out.println("Digite 1: Para Consultar o Estoque\n");
			System.out.println("Digite 2: Para Consultar Cadastros dos Clientes \n");
			System.out.println("Digite 3: Para Cadastrar Exemplar\n");
			System.out.println("Digite 4: Para Cadastrar Cliente\n");
			System.out.println("Digite 5: Para Emprestar Exemplar\n");
			System.out.println("Digite 6: Para Devolver Exemplar\n");
			System.out.println("Digite 7: Para Excluir Exemplar\n");
			System.out.println("Digite 8: Para Excluir Cadastro de Cliente\n");
			System.out.println("Digite 9: Para Consular Pendências\n");
			System.out.println("Digite 10: Para Sair");
			System.out.println("==================================================");
			escolha = ler.nextInt();
		}
		System.out.println("Até Amanhã!!!");
	}

}
