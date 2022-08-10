import java.util.ArrayList;
import java.util.List;
 
public class Grafo {
    private int quantidadeVertices;
    private ArrayList<Integer>[] listaDeAdjacencia;
    private int contadorCaminhos;

    public Grafo(int quantidadeVertices) {
        this.quantidadeVertices = quantidadeVertices;
        inicializarListaDeAdjacencia();
        contadorCaminhos = 0;
    }
    
    private void inicializarListaDeAdjacencia() {
        listaDeAdjacencia = new ArrayList[quantidadeVertices];
 
        for (int i = 0; i < quantidadeVertices; i++) {
            listaDeAdjacencia[i] = new ArrayList<>();
        }
    }
 
    public void adicionarAresta(int origem, int destino) {
        listaDeAdjacencia[origem].add(destino);
    }

    public void mostrarTodosOsCaminhos(int verticeOrigem, int verticeDestino) {
        boolean[] visitado = new boolean[quantidadeVertices];
        ArrayList<String> listaDeCaminhos = new ArrayList<>();
 
        listaDeCaminhos.add(tratarValorVertice(verticeOrigem));
        obterCaminho(verticeOrigem, verticeDestino, visitado, listaDeCaminhos);

        System.out.println("Número de caminhos distintos:" + contadorCaminhos);
    }

    private String tratarValorVertice(int vertice) {
        switch (vertice) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2: 
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            default:
                return "";
        }
    }
 
    private void obterCaminho(Integer vertice, Integer verticeDestino, boolean[] visitado, List<String> listaCaminho) {
        if (vertice.equals(verticeDestino)) {
            System.out.println(listaCaminho);
            contadorCaminhos++;
            return;
        }
 
        visitado[vertice] = true;
        
        for (Integer v : listaDeAdjacencia[vertice]) {
            if (!visitado[v]) {
                String verticeTratado = tratarValorVertice(v);
                listaCaminho.add(verticeTratado);
                obterCaminho(v, verticeDestino, visitado, listaCaminho);

                listaCaminho.remove(verticeTratado);
            }
        }
 
        visitado[vertice] = false;
    }
}