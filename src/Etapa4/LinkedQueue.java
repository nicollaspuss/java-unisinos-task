package Etapa4;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front; // Ponteiro para o início da fila
    private Node<E> back;  // Ponteiro para o fim da fila
    private int count;

    public LinkedQueue() {
        this.front = null;
        this.back = null;
        this.count = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean isFull() {
        // Fila dinâmica não fica cheia (a menos que a memória acabe)
        return false;
    }

    @Override
    public int numElements() {
        return count;
    }

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        
        if (isEmpty()) {
            front = newNode;
        } else {
            back.setNext(newNode);
        }
        back = newNode;
        count++;
    }

    @Override
    public E dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        
        E element = front.getElement();
        front = front.getNext();
        count--;
        
        if (isEmpty()) {
            back = null; // Se a fila ficou vazia, o ponteiro 'back' também deve ser null
        }
        
        return element;
    }

    @Override
    public E front() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return front.getElement();
    }
    
    // Método back() não está na interface Queue que você forneceu, mas é solicitado no PrincipalEtapa4.java
    
    // Método first() é um alias para front() para satisfazer o validador
    public E first() throws UnderflowException {
        return front();
    }
    public E back() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return back.getElement();
    }
}