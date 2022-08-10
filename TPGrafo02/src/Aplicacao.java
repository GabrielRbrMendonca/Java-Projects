public class Aplicacao {
    private static final int VERTICE_A = 0;
    private static final int VERTICE_B = 1;
    private static final int VERTICE_C = 2;
    private static final int VERTICE_D = 3;
    private static final int VERTICE_E = 4;
    private static final int VERTICE_F = 5;
    private static final int NUMERO_VERTICES = 6;

    public static void main(String[] args) {
        int verticeOrigem = VERTICE_A;
        int verticeDestino = VERTICE_F;
        
        Grafo grafo = preencherGrafo();

        grafo.mostrarTodosOsCaminhos(verticeOrigem, verticeDestino);
    }

    public static Grafo preencherGrafo() { 
        Grafo grafo = new Grafo(NUMERO_VERTICES);
        
        grafo.adicionarAresta(VERTICE_A, VERTICE_B);
        grafo.adicionarAresta(VERTICE_A, VERTICE_D);
        grafo.adicionarAresta(VERTICE_A, VERTICE_E);

        grafo.adicionarAresta(VERTICE_B, VERTICE_C);
        grafo.adicionarAresta(VERTICE_B, VERTICE_D);
        grafo.adicionarAresta(VERTICE_B, VERTICE_E);

        grafo.adicionarAresta(VERTICE_C, VERTICE_F);
        
        grafo.adicionarAresta(VERTICE_D, VERTICE_C);
        grafo.adicionarAresta(VERTICE_D, VERTICE_F);

        grafo.adicionarAresta(VERTICE_E, VERTICE_C);
        grafo.adicionarAresta(VERTICE_E, VERTICE_F);

        return grafo;
    }
}