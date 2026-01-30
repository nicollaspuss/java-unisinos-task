package Etapa2;

public class Candidato {
    private String nome;
    private String partido;
    private int intencoesVotos;

    public Candidato(String nome, String partido, int intencoesVotos) {
        this.nome = nome;
        this.partido = partido;
        this.intencoesVotos = intencoesVotos;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getPartido() {
        return partido;
    }

    public int getIntencoesVotos() {
        return intencoesVotos;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public void setIntencoesVotos(int intencoesVotos) {
        this.intencoesVotos = intencoesVotos;
    }

    /**
     * Retorna uma representação formatada do objeto Candidato.
     * O formato deve ser: "Nome                 Partido         Intenções de Votos"
     * O validador espera um formato específico para a saída.
     */
    @Override
    public String toString() {
        // Formata o nome para ter 20 caracteres (ajustado para o console)
        String nomeFormatado = String.format("%-20s", nome);
        // Formata o partido para ter 15 caracteres
        String partidoFormatado = String.format("%-15s", partido);
        
        return nomeFormatado + partidoFormatado + intencoesVotos;
    }
}