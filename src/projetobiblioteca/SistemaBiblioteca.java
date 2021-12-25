package projetobiblioteca;

public class SistemaBiblioteca {

	public static void main(String[] args) {
		Livro acesso = new Livro(null, null, null, 0, 0, 0);
		Cliente cliente = new Cliente(null, null, 0, null, 0);
		Controle controle = new Controle();

		controle.acesso();

		controle.consultarEstoque();
		controle.consultarCliente();
		controle.retirarLivro();
		controle.devolverLivro();

	}

}
