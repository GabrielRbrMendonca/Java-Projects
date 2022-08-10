
public class Aresta {
	int vinicial;
	int vfinal;
	int custo;
	public Aresta(int vinicial, int vfinal, int custo) {
		this.vinicial = vinicial;
		this.vfinal = vfinal;
		this.custo = custo;
	}
	
	 @Override
	    public String toString() {
	        return "Vértice Inicial: "+this.vinicial+" Vértice Final: "+this.vfinal + " Custo: " + this.custo;
	    }
}
