package Etapa3;

public class StaticStack<E> implements Stack<E> {
    private Object[] elements;
    private int top; // Índice do topo da pilha
    private int maxSize;

    @SuppressWarnings("unchecked")
    public StaticStack(int maxSize) {
        this.maxSize = maxSize;
        elements = new Object[maxSize];
        top = -1; // Pilha vazia
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public int numElements() {
        return top + 1;
    }

    @Override
    public void push(E element) throws OverflowException {
        if (isFull()) {
            throw new OverflowException();
        }
        top++;
        elements[top] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E element = (E) elements[top];
        elements[top] = null; // Opcional: Limpar a referência
        top--;
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return (E) elements[top];
    }
}
