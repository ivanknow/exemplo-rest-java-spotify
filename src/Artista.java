
public class Artista {
	private String nome;
	private String popularidade;
	public Artista(String nome, String popularidade) {
		super();
		this.nome = nome;
		this.popularidade = popularidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPopularidade() {
		return popularidade;
	}
	public void setPopularidade(String popularidade) {
		this.popularidade = popularidade;
	}
	@Override
	public String toString() {
		return "Artista [nome=" + nome + ", popularidade=" + popularidade + "]";
	}
	
	

}
