package projetobiblioteca;

public interface Sistema {
	public abstract void acesso();
	public abstract void estoque();
	public abstract void consultarEstoque();
	public abstract void cadastrarLivro();
	public abstract void retirarLivro();
	public abstract void devolverLivro();
}
