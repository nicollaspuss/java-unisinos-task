package Etapa2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {

    private static final String ARQUIVO_NOMES = "src/Etapa2/nomes.txt";
    private static final String ARQUIVO_PARTIDOS = "src/Etapa2/partidos.txt";

    public static void main(String[] args) {
        List<String> nomes = lerArquivo(ARQUIVO_NOMES);
        List<String> partidos = lerArquivo(ARQUIVO_PARTIDOS);

        if (nomes.isEmpty() || partidos.isEmpty()) {
            System.err.println("Erro: Não foi possível carregar os dados dos arquivos.");
            return;
        }

        Random random = new Random();
        // Tamanho aleatório entre 1 e 100
        int tamanhoArray = random.nextInt(100) + 1; 

        Candidato[] candidatos = new Candidato[tamanhoArray];

        for (int i = 0; i < tamanhoArray; i++) {
            // Seleciona um nome e partido aleatório
            String nome = nomes.get(random.nextInt(nomes.size()));
            String partido = partidos.get(random.nextInt(partidos.size()));
            // Intenções de voto aleatórias entre 100 e 1000
            int votos = random.nextInt(901) + 100; 

            candidatos[i] = new Candidato(nome, partido, votos);
        }

        // ---------------------------------------------------------------------
        // 1. Apresentação Inicial
        // ---------------------------------------------------------------------
        System.out.println("===========================================================================");
        System.out.println("         RELATÓRIO DE VOTAÇÃO");
        System.out.println("===========================================================================");
        System.out.println("Nome                 Partido         Intenções de Votos");
        System.out.println("===========================================================================");
        
        // ---------------------------------------------------------------------
        // 2. Ordenação e Impressão (por Nome)
        // ---------------------------------------------------------------------
        OrdenarCandidatos.ordenaCandidatosPorNome(candidatos);
        System.out.println("Candidatos ordenados por nome:");
        imprimirCandidatos(candidatos);

        // ---------------------------------------------------------------------
        // 3. Ordenação e Impressão (por Votos)
        // ---------------------------------------------------------------------
        OrdenarCandidatos.ordenaCandidatosPorVotos(candidatos);
        System.out.println("\nCandidatos ordenados por votos (decrescente):");
        imprimirCandidatos(candidatos);
        
        // ---------------------------------------------------------------------
        // 4. Ordenação e Impressão (por Partido)
        // ---------------------------------------------------------------------
        OrdenarCandidatos.ordenaCandidatosPorPartido(candidatos);
        System.out.println("\nCandidatos ordenados por partido:");
        imprimirCandidatos(candidatos);

        // ---------------------------------------------------------------------
        // 5. Pesquisa Binária
        // ---------------------------------------------------------------------
        // Para a pesquisa binária funcionar, o array deve estar ordenado pelo critério de pesquisa (Nome).
        OrdenarCandidatos.ordenaCandidatosPorNome(candidatos);
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o nome do candidato para pesquisa binária: ");
        String nomePesquisa = scanner.nextLine();
        
        int indice = OrdenarCandidatos.pesquisaBinariaCandidatos(candidatos, nomePesquisa);

        if (indice >= 0) {
            System.out.println("[OK] Candidato encontrado na posição " + indice + ": " + candidatos[indice].toString());
        } else {
            System.out.println("[NOK] Candidato '" + nomePesquisa + "' não encontrado.");
        }
        
        scanner.close();
    }

    /**
     * Método auxiliar para ler o conteúdo de um arquivo linha por linha.
     * @param filename Nome do arquivo.
     * @return Lista de strings contendo as linhas do arquivo.
     */
    private static List<String> lerArquivo(String filename) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha.trim());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + filename + ": " + e.getMessage());
        }
        return linhas;
    }

    /**
     * Método auxiliar para imprimir os candidatos.
     * @param candidatos Array de Candidato.
     */
    private static void imprimirCandidatos(Candidato[] candidatos) {
        for (Candidato c : candidatos) {
            System.out.println(c.toString());
        }
    }
}