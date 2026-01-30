package Etapa1;

public class PrincipalLabirinto {

    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto();
        
        // O validador testa com "src/Etapa1/labirinto.txt"
        labirinto.criaLabirinto("src/Etapa1/labirinto.txt");

        System.out.println("--- Labirinto Inicial ---");
        labirinto.imprimeLabirinto();

        boolean encontrouSolucao = labirinto.percorreLabirinto();

        System.out.println("\n--- Labirinto Final ---");
        labirinto.imprimeLabirinto();

        if (encontrouSolucao) {
            System.out.println("\nSolução encontrada!");
        } else {
            System.out.println("\nNão foi possível encontrar a solução.");
        }
    }
}
