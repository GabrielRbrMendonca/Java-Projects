
import java.io.File;
import java.io.IOException;

//import java.util.ArrayList;
import java.util.Scanner;

public class Leitor {
	static int x;
	static int y;
	static int z;
	
	
	public static void main(String[] args) throws IOException {
		Grafo g = new Grafo(1,1,1);	
		//for (int i=1; i<41;i++) {
			File arquivo = new File("C:\\Users\\gabim\\eclipse-workspace\\TrabalhoGrafico\\"
					+ "pmed2.txt");
			Scanner scan = new Scanner(arquivo);			
			while (scan.hasNext()) {
			x=scan.nextInt();
			y=scan.nextInt();
			z=scan.nextInt();
		//	System.out.println(x);
			if(x%100==0 && y%100==0) {
				g.nvertices=x;
				g.narestas=y;
				g.k=z;
				int matriz2[][] = new int[x][x];
				g.matriz=matriz2;
			}
			else {
				g.addAresta(x, y, z);
			}
			
			
		}
		
			scan.close();
	//}
	/*	FileInputStream stream = new FileInputStream(
				"C:\\Users\\gabim\\eclipse-workspace\\TrabalhoGrafico\\pmed1.txt");//caminho
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		
		String linha = br.readLine();
		while (linha != null) {
			String nospace;
			nospace=linha.substring(1,linha.length());
			String[] nospace2=nospace.split(" ");
			
			x=Integer.parseInt(nospace2[0]);
			y=Integer.parseInt(nospace2[1]);
			z=Integer.parseInt(nospace2[2]);
			
			
			if(x%100==0 && y%100==0) {
				g.nvertices=x;
				g.narestas=y;
				g.k=z;
				int matriz2[][] = new int[x][x];
				g.matriz=matriz2;
			}
			g.addAresta(x, y, z);
		//	for(int i=0;i<g.arestas.size();i++){
		//		System.out.println(g.arestas.get(i));
		//	}
			
			linha = br.readLine();
		}
		br.close();
		*/
		g.geraMatrizInicial();
/*		for (int i = 0; i < g.nvertices; i++)
        {
            for (int j = 0; j < g.nvertices; j++)
            {
            	System.out.print(g.matriz[i][j]+" ");
            }
            System.out.println();
        }
		System.out.println("-------------------------------");*/
		g.floyd();
		
		/*for (int i = 0; i < g.nvertices; i++)
        {
            for (int j = 0; j < g.nvertices; j++)
            {
            	System.out.print(g.matriz[i][j]+" ");
            }
           System.out.println();
        }*/
		//System.out.println(g.raio);
		g.Metodo1(g.matriz);
		 System.out.println();
		g.Metodo2(g.matriz);
	}
	

}