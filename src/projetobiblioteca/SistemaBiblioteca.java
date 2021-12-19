package projetobiblioteca;

public class SistemaBiblioteca {

	public static void main(String[] args) {
		Livro acesso = new Livro(null, null, null, 0, 0, 0);
		
		acesso.acesso();
		acesso.consultarEstoque();

	}

}
