package projetobiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
	private String nomeCliente;
	private String enderecoCliente;
	private long cpf;
	private String livroEmprestado;
	private int quantidadeEmprestimo = 0;
	int x;
	boolean confirma = false;
	boolean validado = false;
	Scanner ler = new Scanner(System.in);
	ArrayList<Cliente> cliente = new ArrayList<>();

	// MÉTODO CONSTRUTOR - INICIO
	public Cliente(String nomeCliente, String enderecoCliente, long cpf, String livroEmprestimo, int quantidadeEmprestimo) {
		this.setNomeCliente(nomeCliente);
		this.setEnderecoCliente(enderecoCliente);
		this.setCpf(cpf);
		this.setLivroEmprestado(livroEmprestimo);
		this.setQuantidadeEmprestimo(quantidadeEmprestimo);
	}
	// MÉTODO CONSTRUTOR - FINAL

	public void cadastrarCliente() {
		System.out.println("TELA PARA CADASTRAR CLIENTE");
		System.out.println("Digite o nome do Cliente");
		this.setNomeCliente(ler.nextLine());
		System.out.println("Digite o endereço do Cliente");
		this.setEnderecoCliente(ler.nextLine());
		System.out.println("Digite o CPF do Cliente");
		this.setCpf(ler.nextLong());
		cliente.add(new Cliente(this.nomeCliente, this.enderecoCliente, this.cpf, this.livroEmprestado, this.quantidadeEmprestimo));
		System.out.println("Cliente Cadastrado!!!");
		System.out.println(cliente);
		ler.nextLine();
	}

	public Boolean validarCpf() {
		System.out.println("Primeiramente, informe seu CPF");
		long y = ler.nextLong();
		do {
			confirma = false;
			for(x = 0; x < cliente.size(); x++) {
				if(cliente.get(x).cpf != y) {
					System.out.println("CPF não encontrado! Digite novamente");
					y = ler.nextLong();
					confirma = true;
					break;
				}
			}
		} while (confirma == true);
		System.out.println("CPF encontrado!!!");
		return validado = true;
	}
	
	public void clienteRetirada(String titulo) {
		cliente.get(0).livroEmprestado = titulo;
		this.setQuantidadeEmprestimo(getQuantidadeEmprestimo() + 1);
		System.out.println(cliente);
	}

	// MÉTODOS ESPECIAIS - INICIO
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getLivroEmprestado() {
		return livroEmprestado;
	}

	public void setLivroEmprestado(String livroEmprestado) {
		this.livroEmprestado = livroEmprestado;
	}

	public int getQuantidadeEmprestimo() {
		return quantidadeEmprestimo;
	}

	public void setQuantidadeEmprestimo(int quantidadeEmprestimo) {
		this.quantidadeEmprestimo = quantidadeEmprestimo;
	}
	// MÉTODOS ESPECIAIS - FINAL

	//MÉTODO toSTRING - INICIO
	@Override
	public String toString() {
		return "\nNome do Cliente: " + nomeCliente + "\nEndereço Cliente: " + enderecoCliente + "\nCpf: " + cpf
				+ "\nLivro Emprestado: " + livroEmprestado + "\nQuantidade Emprestimo: " + quantidadeEmprestimo;
	}
	//MÉTODO toSTRING - FINAL
	
	

}
