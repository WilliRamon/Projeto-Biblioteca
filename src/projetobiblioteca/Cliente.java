package projetobiblioteca;

public class Cliente {
	
	private String nomeCliente;
	private String enderecoCliente;
	private long cpf;
	private String livroEmprestado;
	private int quantidadeEmprestimo;


	// MÉTODO CONSTRUTOR - INICIO
	public Cliente(String nomeCliente, String enderecoCliente, long cpf, String livroEmprestado, int quantidadeEmprestimo) {
		this.setNomeCliente(nomeCliente);
		this.setEnderecoCliente(enderecoCliente);
		this.setCpf(cpf);
		this.setLivroEmprestado(livroEmprestado);
		this.setQuantidadeEmprestimo(quantidadeEmprestimo);
	}
	// MÉTODO CONSTRUTOR - FINAL
	
	//MÉTODO toSTRING - INICIO
	@Override
	public String toString() {
		return "\nNome do Cliente: " + nomeCliente + "\nEndereço Cliente: " + enderecoCliente + "\nCpf: " + cpf
				+ "\nLivro Emprestado: " + livroEmprestado + "\nQuantidade Emprestimo: " + quantidadeEmprestimo + "\n--------------------------";
	}
	//MÉTODO toSTRING - FINAL


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


	
	

}
