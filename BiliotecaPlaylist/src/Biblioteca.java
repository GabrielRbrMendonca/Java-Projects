import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Biblioteca {
	private static List<Playlist> playlists = new ArrayList<Playlist>();
	private static Set<Musica> allMusicas = new HashSet<Musica>();
	
	public static void addMusica(Musica m) {
		allMusicas.add(m);
	}
		
	//1: Armazenar e remover playlists na biblioteca.
	public static void criarPlaylist(String nome) {
		Playlist p = new Playlist(nome);
		playlists.add(p);
	}
	
	public static void removePlaylist(String nome) {
		playlists.forEach(playlist ->{
			if(playlist.getNome()==nome) {
				playlists.remove(playlist);
			}
		});
	}
	
	//4: Visualizar a lista de músicas na biblioteca.
	public static Set<Musica> getAllMusicas() {
		return allMusicas;
	}

	public static void setAllMusicas(Set<Musica> allMusicas) {
		Biblioteca.allMusicas = allMusicas;
	}

	//5: Visualizar todas as músicas de um determinado artista.
	public static List<Musica> getMusicasDeUmArtista(String artista){
		return allMusicas.stream().filter(m->m instanceof Musica).filter(m->m.getArtistas().contains(artista))
				.collect(Collectors.toList());
	}
	
	//6: Visualizar a duração média das playlists.
	public static double duracaoMediaPlaylists(){
		return playlists.stream().filter(p->p instanceof Playlist)
				.mapToDouble(Playlist::getDuracao).average().getAsDouble();
	}

}

