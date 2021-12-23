package projetobiblioteca;

public class SistemaBiblioteca {

	public static void main(String[] args) {
		Livro acesso = new Livro(null, null, null, 0, 0, 0);
		Cliente cliente = new Cliente(null, null, 0, null, 0);

		acesso.acesso();
		cliente.cadastrarCliente();

		acesso.consultarEstoque();
		acesso.retirarLivro();

	}

}
