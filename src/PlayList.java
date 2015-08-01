
public class PlayList {
 private String nome;
 private int countUsers;
 private String autor;
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public int getCountUsers() {
	return countUsers;
}
public void setCountUsers(int countUsers) {
	this.countUsers = countUsers;
}
public String getAutor() {
	return autor;
}
public void setAutor(String autor) {
	this.autor = autor;
}
public PlayList(String nome, int countUsers, String autor) {
	super();
	this.nome = nome;
	this.countUsers = countUsers;
	this.autor = autor;
}
@Override
public String toString() {
	return "PlayList [nome=" + nome + ", countUsers=" + countUsers + ", autor="
			+ autor + "]";
}
 
 
}
