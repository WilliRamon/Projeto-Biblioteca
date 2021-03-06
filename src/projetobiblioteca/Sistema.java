package projetobiblioteca;

public interface Sistema {
	public abstract void acesso();

	public abstract void consultarEstoque();

	public abstract void consultarCliente();

	public abstract void consultarPendencias();

	public abstract void cadastrarLivro();

	public abstract void cadastrarCliente();

	public abstract void retirarLivro();

	public abstract void devolverLivro();

	public abstract void excluirLivro();

	public abstract void excluirCliente();
}
