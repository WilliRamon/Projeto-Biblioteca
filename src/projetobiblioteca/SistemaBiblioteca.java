package projetobiblioteca;

public class SistemaBiblioteca {

	public static void main(String[] args) {

		Controle controle = new Controle();

		controle.acesso();
		controle.retirarLivro();
		controle.retirarLivro();

		
		controle.consultarPendencias();
		

	}

}
