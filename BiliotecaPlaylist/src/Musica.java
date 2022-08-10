//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;

public class Musica {

	private String titulo;
	private double duracao;
	private Set<String> artistas;
	
	
	public Musica(String titulo, double duracao, String artista) {
		super();
		this.titulo = titulo;
		this.duracao = duracao;
		Set<String> aux = new HashSet<String>();
		this.artistas = aux;
		addArtista(artista);
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public double getDuracao() {
		return duracao;
	}

	public Set<String> getArtistas() {
		return artistas;
	}

	
	//3: Adicionar e remover artistas de uma música.
	public void addArtista(String nome) {
		this.artistas.add(nome);
	}
	
	public void removeArtista(String nome) {
		artistas.forEach(artista ->{
			if(artista==titulo) {
				artistas.remove(artista);
			}
		});
	}
	
	public String toString() {
		return "Titulo: " + getTitulo() + " Duracao: "+ getDuracao() + " Artistas: "+ getArtistas();
	}
}
