package Etapa4;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int count;

    public LinkedStack() {
        this.top = null;
        this.count = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        // Pilha dinâmica não fica cheia (a menos que a memória acabe)
        return false;
    }

    @Override
    public int numElements() {
        return count;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.setNext(top);
        top = newNode;
        count++;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E element = top.getElement();
        top = top.getNext();
        count--;
        return element;
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return top.getElement();
    }
}