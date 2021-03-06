package projetobiblioteca;

public class Cliente {

	private String nomeCliente;
	private String enderecoCliente;
	private long cpf;
	private int posicaoCadastro;
	private String livroEmprestado;
	private int quantidadeEmprestimo;

	// M?TODO CONSTRUTOR - INICIO
	public Cliente() {
		
	}
	
	public Cliente(String nomeCliente, String enderecoCliente, long cpf, int posicaoCadastro, String livroEmprestado,
			int quantidadeEmprestimo) {
		this.setNomeCliente(nomeCliente);
		this.setEnderecoCliente(enderecoCliente);
		this.setCpf(cpf);
		this.setPosicaoCadastro(posicaoCadastro);
		this.setLivroEmprestado(livroEmprestado);
		this.setQuantidadeEmprestimo(quantidadeEmprestimo);
	}
	// M?TODO CONSTRUTOR - FINAL

	// M?TODO toSTRING - INICIO
	@Override
	public String toString() {
		return "\nNome do Cliente: " + nomeCliente + "\nEndere?o Cliente: " + enderecoCliente + "\nCpf: " + cpf
				+ "\nPosi??o de Cadastro: " + posicaoCadastro + "\nLivro Emprestado: " + livroEmprestado
				+ "\nQuantidade Emprestimo: " + quantidadeEmprestimo + "\n--------------------------";
	}
	// M?TODO toSTRING - FINAL

	// M?TODOS ESPECIAIS - INICIO
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

	public int getPosicaoCadastro() {
		return posicaoCadastro;
	}

	public void setPosicaoCadastro(int posicaoCadastro) {
		this.posicaoCadastro = posicaoCadastro;
	}

	// M?TODOS ESPECIAIS - FINAL

}
