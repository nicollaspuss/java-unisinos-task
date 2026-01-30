package Etapa4;

public class PrincipalEtapa4 {

    public static void main(String[] args) {
        System.out.println("===========================================================================");
        System.out.println("         RELATÓRIO DE EXECUÇÃO - Etapa 4");
        System.out.println("===========================================================================");

        try {
            // Teste 1: Operações com Pilha (LinkedStack)
            System.out.println("Teste 1: Operações na Pilha (LinkedStack)");
            LinkedStack<Integer> stack = new LinkedStack<>();

            // Verifica se a pilha está vazia
            System.out.println("Pilha está vazia? " + stack.isEmpty()); // Esperado: true

            // Empilhando elementos
            stack.push(10);
            stack.push(20);
            stack.push(30);
            System.out.println("Elemento no topo da pilha: " + stack.top()); // Esperado: 30

            // Desempilhando um elemento
            System.out.println("Desempilhando: " + stack.pop()); // Esperado: 30
            System.out.println("Número de elementos na pilha: " + stack.numElements()); // Esperado: 2
            System.out.println("---------------------------------------------------");

            // Teste 2: Operações com Fila (LinkedQueue)
            System.out.println("Teste 2: Operações na Fila (LinkedQueue)");
            LinkedQueue<Integer> queue = new LinkedQueue<>();

            // Verifica se a fila está vazia
            System.out.println("Fila está vazia? " + queue.isEmpty()); // Esperado: true

            // Enfileirando elementos
            queue.enqueue(100);
            queue.enqueue(200);
            queue.enqueue(300);
            System.out.println("Primeiro da fila (front): " + queue.front()); // Esperado: 100

            // Desenfileirando um elemento
            System.out.println("Desenfileirando: " + queue.dequeue()); // Esperado: 100
            System.out.println("Número de elementos na fila: " + queue.numElements()); // Esperado: 2

            // Verificar último elemento (back)
            System.out.println("Último da fila (back): " + queue.back()); // Esperado: 300
            System.out.println("---------------------------------------------------");

        } catch (Exception e) {
            System.err.println("Ocorreu um erro durante a execução: " + e.getMessage());
        }
    }
}