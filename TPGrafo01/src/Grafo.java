import java.util.ArrayList;
import java.util.List;

public class Grafo {
	static int INF=9999;
	int nvertices;
	int narestas;
	int k;
	List<Aresta> arestas = new ArrayList<Aresta>();
	int matriz[][] = new int[nvertices][nvertices];
	int raio;
	
	
	
	public Grafo(int nvertices, int narestas, int k) {
		super();
		this.nvertices = nvertices;
		this.narestas = narestas;
		this.k = k;
		
	}

	public void addAresta(int x,int y, int z) {
		if(!(x%100==0 && y%100==0)) {
			Aresta a = new Aresta(x,y,z);
			arestas.add(a);
			
		}
		
	}
	
	public void geraMatrizInicial() {
		for (int i = 0; i < nvertices; i++)
        {
            for (int j = 0; j < nvertices; j++)
            {
            	matriz[i][j]=INF;
            }
        }
        for (int i = 0; i < nvertices; i++)
            {
        	
                for (int j = 0; j < nvertices; j++)
                {                	
                	for (int x=0; x<this.arestas.size(); x++)
                	{
                		if(this.arestas.get(x).vinicial-1==i && this.arestas.get(x).vfinal-1==j){
                			this.matriz[i][j]=this.arestas.get(x).custo;
                		}
                	}
                    if(i==j){
                    	this.matriz[i][j]=0;
                    }
                }
            }
  
}
	
	public void floyd() {
		for (int k = 0; k < this.nvertices; k++) {
		      for (int i = 0; i < this.nvertices; i++) {
		        for (int j = 0; j < this.nvertices; j++) {
		          if (this.matriz[i][k] + this.matriz[k][j] < this.matriz[i][j])
		        	  this.matriz[i][j] = this.matriz[i][k] + this.matriz[k][j];
		          
		        }
		      }
		    }
	/*	for (int i = 0; i < this.nvertices; i++)
        {
            for (int j = 0; j < this.nvertices; j++)
            {
            	System.out.print(this.matriz[i][j]+" ");
            }
            System.out.println();
        }*/
		
	}
	
	public  void Metodo1(int[][] grafo) {
		boolean[] added = new boolean[grafo.length];
		List<Integer> centros = new ArrayList<>();
		added[0] = true;
		centros.add(0);
		while (centros.size() != this.k) {
			int CustoMaximo = -1;
			int CustoMaximoAdd = 0;
			for (Integer node : centros) {
				int CustoMin = 9999;
				int CustoMinAdd = 0;
				for (int i = 0; i < grafo.length; i++) {
					if (!added[i] && grafo[node][i] != 0 && grafo[node][i] < CustoMin) {
						CustoMin = grafo[node][i];
						CustoMinAdd = i;
					}
				}
				if (CustoMin > CustoMaximo) {
					CustoMaximo = CustoMin;
					CustoMaximoAdd = CustoMinAdd;
				}
			}
			added[CustoMaximoAdd] = true;
			centros.add(CustoMaximoAdd);
	//		System.out.println(maxDisFromNode);
		}
		
	//	for (Integer n : centros)
	//		System.out.print(n + " ");
		
		int raio = 0; 
		for(int i = 0;i<centros.size();i++){
		    for ( int j = 0 ; j < this.nvertices ; j++ ){
		        if( grafo[centros.get(i)][j] > raio ){
		            raio = grafo[centros.get(i)][j];
		        }
		    }
		}

		System.out.print("Metodo1: "+raio);
	}
	
	
	
	public int valorMax(int[] custo, int n)
	{
	    int mi = 0;
	    for(int i = 0; i < n; i++)
	    {
	        if (custo[i] > custo[mi])
	            mi = i;
	    }
	    return mi;
	}
	 
	public void Metodo2(int custos[][])
	{
	    int[] raio = new int[this.nvertices];
	    ArrayList<Integer> centros = new ArrayList<>();
	    for(int i = 0; i < this.nvertices; i++)
	    {
	        raio[i] = 999;
	    }
	    int max = 0;
	    for(int i = 0; i < this.k; i++)
	    {
	        centros.add(max);
	        for(int j = 0; j < this.nvertices; j++)
	        {
	        	//Atualizando distancia dos vertices aos centros mais proximos
	            raio[j] = Math.min(raio[j],custos[max][j]);
	        }
	        //Atualizando maior valor de distancia
	        max = valorMax(raio, this.nvertices);
	    }	 
	    // Print distancia maxima
	    System.out.println("Metodo2: "+ raio[max]);
	    // Print centros
	    for(int i = 0; i < centros.size(); i++)
	    {
	//        System.out.print(centros.get(i) + " ");
	    }
	//   System.out.print("\n");
	}
	
}