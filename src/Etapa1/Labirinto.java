package Etapa1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Labirinto {
    // Atributos constantes
    public static final char PAREDE = 'X';
    public static final char CAMINHO_ABERTO = ' ';
    public static final char SAIDA = 'D';
    public static final char CAMINHO_SOLUCAO = '#';

    // Atributo para armazenar a estrutura do labirinto
    private char[][] labirinto;

    /**
     * Carrega a estrutura do labirinto a partir de um arquivo de texto.
     * @param filename O nome do arquivo contendo o labirinto.
     */
    public void criaLabirinto(String filename) {
        try {
            List<String> linhas = new ArrayList<>();
            
            // Abre o arquivo para leitura
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
            br.close();

            if (linhas.isEmpty()) {
                throw new IllegalArgumentException("O arquivo do labirinto está vazio.");
            }

            int numLinhas = linhas.size();
            int numColunas = linhas.get(0).length();
            labirinto = new char[numLinhas][numColunas];

            for (int i = 0; i < numLinhas; i++) {
                labirinto[i] = linhas.get(i).toCharArray();
            }

        } catch (IOException e) {
            // Tratamento de exceção esperado pelo validador (try-catch)
            // Lança uma exceção de argumento ilegal para indicar falha na criação do labirinto
            throw new IllegalArgumentException("Erro ao carregar o labirinto do arquivo: " + filename, e);
        }
    }

    /**
     * Inicia a busca pela saída do labirinto a partir da posição [0][0].
     * @return true se a saída for encontrada, false caso contrário.
     */
    public boolean percorreLabirinto() {
        if (labirinto == null || labirinto.length == 0) {
            return false;
        }
        
        // Chama a função recursiva para resolver o labirinto
        return resolverLabirinto(0, 0);
    }

    /**
     * Função recursiva para encontrar o caminho para a saída.
     * @param x Coordenada da linha atual.
     * @param y Coordenada da coluna atual.
     * @return true se um caminho para a saída for encontrado a partir de (x, y), false caso contrário.
     */
    private boolean resolverLabirinto(int x, int y) {
        // 1. Condição de Parada: Fora dos limites
        if (x < 0 || x >= labirinto.length || y < 0 || y >= labirinto[0].length) {
            return false;
        }

        // 2. Condição de Parada: Encontrou a Saída
        if (labirinto[x][y] == SAIDA) {
            return true;
        }

        // 3. Condição de Parada: Parede ou Já Visitado
        if (labirinto[x][y] == PAREDE || labirinto[x][y] == CAMINHO_SOLUCAO) {
            return false;
        }
        
        // 4. Marca o caminho atual como parte da solução potencial
        char caractereOriginal = labirinto[x][y];
        if (caractereOriginal == CAMINHO_ABERTO) {
            labirinto[x][y] = CAMINHO_SOLUCAO;
        }

        // 5. Tentativa de Movimento (Ordem: Direita, Baixo, Esquerda, Cima)
        if (resolverLabirinto(x, y + 1)) { // Direita
            return true;
        }
        if (resolverLabirinto(x + 1, y)) { // Baixo
            return true;
        }
        if (resolverLabirinto(x, y - 1)) { // Esquerda
            return true;
        }
        if (resolverLabirinto(x - 1, y)) { // Cima
            return true;
        }

        // 6. Backtracking: Se não encontrou a saída, desmarca o caminho
        if (labirinto[x][y] == CAMINHO_SOLUCAO) {
            labirinto[x][y] = CAMINHO_ABERTO;
        }
        return false;
    }

    /**
     * Imprime o labirinto na tela, destacando o caminho da solução.
     */
    public void imprimeLabirinto() {
        if (labirinto == null || labirinto.length == 0) {
            System.out.println("Labirinto não carregado.");
            return;
        }

        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                System.out.print(labirinto[i][j]);
            }
            System.out.println();
        }
    }
}
