import java.util.ArrayList;
import java.util.List;

public class Playlist {
	private String nome;
	private List<Musica> musicas;
	
	
	public Playlist(String nome) {
		this.nome = nome;
		List<Musica> auxMusicas = new ArrayList<Musica>();
		this.musicas=auxMusicas;
	}
	
	public void add(Musica m) {
		musicas.add(m);
		Biblioteca.addMusica(m);
	}
	
	//2:Adicionar e remover músicas nas playlists da biblioteca.
	public void remove(String titulo) {
		musicas.forEach(musica ->{
			if(musica.getTitulo()==titulo) {
				musicas.remove(musica);
			}
		});		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public double getDuracao() {
		return musicas.stream().mapToDouble(Musica::getDuracao).sum();
	}

}
