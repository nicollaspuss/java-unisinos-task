package Etapa3;

import java.util.Arrays;

public class StaticList<E> implements List<E> {
    private Object[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public StaticList(int maxSize) {
        elements = new Object[maxSize];
        size = 0;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == elements.length;
    }

    @Override
    public void insert(E element, int pos) {
        if (isFull()) {
            throw new OverflowException();
        }
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Posição de inserção inválida: " + pos);
        }

        // Desloca os elementos para a direita
        for (int i = size - 1; i >= pos; i--) {
            elements[i + 1] = elements[i];
        }

        elements[pos] = element;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int pos) {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição de remoção inválida: " + pos);
        }

        E element = (E) elements[pos];

        // Desloca os elementos para a esquerda
        for (int i = pos; i < size - 1; i--) { // Corrigido para i--
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null; // Limpa a última posição
        size--;

        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }
        return (E) elements[pos];
    }

    @Override
    public int search(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    
    // O método contaElementos não está na interface, então não deve ter @Override
    public int contaElementos(E el) {
        return contaElementosRecursivo(el, 0);
    }

    private int contaElementosRecursivo(E el, int index) {
        if (index == size) {
            return 0;
        }

        int contagem = contaElementosRecursivo(el, index + 1);

        if (elements[index].equals(el)) {
            contagem++;
        }

        return contagem;
    }
}
