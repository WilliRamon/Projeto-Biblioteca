package projetobiblioteca;

public class SistemaBiblioteca {

	public static void main(String[] args) {

		Controle controle = new Controle();

		controle.acesso();
		controle.consultarEstoque();
		controle.consultarCliente();
		controle.cadastrarLivro();
		controle.cadastrarCliente();
		controle.retirarLivro();
		controle.consultarPendencias();
		controle.devolverLivro();
		controle.excluirLivro();
		controle.excluirCliente();

		
		
		

	}

}
