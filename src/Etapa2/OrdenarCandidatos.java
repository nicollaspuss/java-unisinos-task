package Etapa2;

import java.util.Arrays;
import java.util.Comparator;

public class OrdenarCandidatos {

    /**
     * Ordena o array de Candidato por nome (estável).
     * @param candidatos Array de Candidato a ser ordenado.
     */
    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        // Usa Arrays.sort com um Comparator para ordenar por nome.
        // O Arrays.sort em Java para objetos é um MergeSort ou Timsort, que são estáveis.
        Arrays.sort(candidatos, Comparator.comparing(Candidato::getNome));
    }

    /**
     * Ordena o array de Candidato por intenções de votos (estável).
     * @param candidatos Array de Candidato a ser ordenado.
     */
    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {
        // Ordena em ordem decrescente de votos.
        Arrays.sort(candidatos, Comparator.comparing(Candidato::getIntencoesVotos).reversed());
    }

    /**
     * Ordena o array de Candidato por partido (estável).
     * @param candidatos Array de Candidato a ser ordenado.
     */
    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {
        Arrays.sort(candidatos, Comparator.comparing(Candidato::getPartido));
    }

    /**
     * Realiza uma pesquisa binária no array de Candidato por nome.
     * O array DEVE estar ordenado por nome.
     * @param candidatos Array de Candidato ordenado por nome.
     * @param nome Nome do candidato a ser pesquisado.
     * @return O índice do candidato encontrado ou -1 se não encontrado.
     */
    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
        // O Arrays.binarySearch requer que o array esteja ordenado e que o Comparator
        // seja compatível com a ordenação.
        return Arrays.binarySearch(candidatos, new Candidato(nome, "", 0), Comparator.comparing(Candidato::getNome));
    }
}