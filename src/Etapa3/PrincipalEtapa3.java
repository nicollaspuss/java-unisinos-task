package Etapa3;

public class PrincipalEtapa3 {

    /**
     * Converte uma string de expressão em uma Stack de caracteres.
     * A ordem dos caracteres na pilha deve ser invertida em relação à string,
     * pois o método checkBrackets inverte novamente para processar.
     * @param expressao A string da expressão.
     * @return Uma Stack<Character> com os caracteres da expressão.
     */
    private static Stack<Character> stringToStack(String expressao) {
        // O tamanho da pilha deve ser o tamanho da expressão para a StaticStack
        StaticStack<Character> stack = new StaticStack<>(expressao.length());
        try {
            // Empilha os caracteres da string.
            for (int i = 0; i < expressao.length(); i++) {
                stack.push(expressao.charAt(i));
            }
        } catch (OverflowException e) {
            // Não deve ocorrer se o tamanho for correto.
            System.err.println("Erro de Overflow ao criar a pilha.");
        }
        return stack;
    }

    public static void main(String[] args) {
        Etapa3 validador = new Etapa3();

        // Expressões de teste
        String[] expressoes = {
            "((A+B)-(C+D))", // Válida
            "((A+B)-(C+D)",  // Inválida
            "(A+B))",        // Inválida
            "((A+B)",        // Inválida
            "A+B",           // Válida
            "()",            // Inválida
            ")("             // Válida
        };

        System.out.println("===========================================================================");
        System.out.println("         RELATÓRIO DE EXECUÇÃO - Etapa 3 (Validação de Parênteses)");
        System.out.println("===========================================================================");

        for (String exp : expressoes) {
            // Cria a pilha a partir da string
            Stack<Character> pilhaExpressao = stringToStack(exp);
            
            // Chama o método de validação
            boolean resultado = validador.checkBrackets(pilhaExpressao);

            // Imprime o resultado
            String status = resultado ? "[VÁLIDA]" : "[INVÁLIDA]";
            System.out.printf("Expressão: %-20s -> %s\n", exp, status);
        }
        
        System.out.println("===========================================================================");
    }
}