package Etapa3;

public class Etapa3 {

    /**
     * Verifica se uma expressão matemática tem os parênteses agrupados de forma correta.
     * A expressão é passada como uma Stack de caracteres.
     * @param s1 A pilha contendo a expressão.
     * @return true se os parênteses estiverem agrupados corretamente, false caso contrário.
     */
    public boolean checkBrackets(Stack<Character> s1) {
        StaticStack<Character> pilhaAuxiliar = new StaticStack<>(s1.numElements());
        
        // Passo 1: Transferir os elementos de s1 para uma lista para inverter a ordem.
        StaticList<Character> expressao = new StaticList<>(s1.numElements());
        int numElementos = s1.numElements();
        
        try {
            for (int i = 0; i < numElementos; i++) {
                expressao.insert(s1.pop(), i);
            }
        } catch (UnderflowException e) {
            // Não deve acontecer se numElements() estiver correto.
            return false; 
        }

        // Passo 2: Processar a expressão na ordem correta.
        try {
            for (int i = 0; i < expressao.numElements(); i++) {
                char c = expressao.get(i);
                
                if (c == '(') {
                    pilhaAuxiliar.push(c);
                } else if (c == ')') {
                    if (pilhaAuxiliar.isEmpty()) {
                        // Violou a regra (2): parêntese de fechamento sem um aberto correspondente.
                        return false; 
                    }
                    // Remove o parêntese aberto correspondente.
                    pilhaAuxiliar.pop();
                }
            }
        } catch (OverflowException | UnderflowException e) {
            // Exceções de pilha não devem afetar a lógica de agrupamento.
            return false;
        }

        // Passo 3: Verificar a regra (1) e o final da regra (2).
        // Se a pilha auxiliar estiver vazia, todos os parênteses abertos foram fechados.
        return pilhaAuxiliar.isEmpty();
    }
}