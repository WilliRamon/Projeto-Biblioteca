package projetobiblioteca;

public class SistemaBiblioteca {

	public static void main(String[] args) {
		Livro acesso = new Livro(null, null, null, 0, 0, 0);
		Cliente cliente = new Cliente(null, null, 0);
		boolean validar = false;
		
		cliente.cadastrarCliente();
		validar = cliente.validarCpf();
		
		if(validar == true) {
			System.out.println("Deu certo!!!");
		}else {
			System.out.println("Deu errado");
		}

	}

}
