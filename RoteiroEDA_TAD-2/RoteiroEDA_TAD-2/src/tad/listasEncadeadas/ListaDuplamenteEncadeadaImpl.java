package tad.listasEncadeadas;

import java.lang.reflect.Array;

public class ListaDuplamenteEncadeadaImpl<T extends Comparable<T>> implements ListaDuplamenteEncadeadaIF<T> {

    private NodoListaDuplamenteEncadeada<T> cabeca;
    private NodoListaDuplamenteEncadeada<T> cauda;

    public ListaDuplamenteEncadeadaImpl() {
        cabeca = new NodoListaDuplamenteEncadeada<>();
        cauda = new NodoListaDuplamenteEncadeada<>();
        cabeca.setProximo(cauda);
        cabeca.setAnterior(null);
        cauda.setAnterior(cabeca);
        cauda.setProximo(null);
    }

    @Override
    public boolean isEmpty() {
        return cabeca.getProximo() == cauda;
    }

    @Override
    public int size() {
        int count = 0;
        NodoListaDuplamenteEncadeada<T> atual = cabeca.getProximo();
        while (atual != cauda) {
            count++;
            atual = atual.getProximo();
        }
        return count;
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> search(T chave) {
        NodoListaDuplamenteEncadeada<T> atual = cabeca.getProximo();
        while (atual != cauda) {
            if (atual.getChave().equals(chave)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    @Override
    public void insert(T chave) {
        // Insere no final (antes da cauda)
        NodoListaDuplamenteEncadeada<T> novo = new NodoListaDuplamenteEncadeada<>(chave);
        NodoListaDuplamenteEncadeada<T> ultimo = cauda.getAnterior();

        novo.setProximo(cauda);
        novo.setAnterior(ultimo);
        ultimo.setProximo(novo);
        cauda.setAnterior(novo);
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> remove(T chave) {
        if (isEmpty()) return null;
        NodoListaDuplamenteEncadeada<T> atual = search(chave);
        if (atual != null) {
            atual.getAnterior().setProximo(atual.getProximo());
            atual.getProximo().setAnterior(atual.getAnterior());
            atual.setProximo(null);
            atual.setAnterior(null);
            return atual;
        }
        return null;
    }

    @Override
    public String imprimeEmOrdem() {
        StringBuilder sb = new StringBuilder();
        NodoListaDuplamenteEncadeada<T> atual = cabeca.getProximo();
        while (atual != cauda) {
            sb.append(atual.getChave());
            if (atual.getProximo() != cauda) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }
        return sb.toString();
    }

    @Override
    public String imprimeInverso() {
        StringBuilder sb = new StringBuilder();
        NodoListaDuplamenteEncadeada<T> atual = cauda.getAnterior();
        while (atual != cabeca) {
            sb.append(atual.getChave());
            if (atual.getAnterior() != cabeca) {
                sb.append(", ");
            }
            atual = atual.getAnterior();
        }
        return sb.toString();
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> sucessor(T chave) {
        NodoListaDuplamenteEncadeada<T> atual = search(chave);
        if (atual != null && atual.getProximo() != cauda) {
            return atual.getProximo();
        }
        return null;
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> predecessor(T chave) {
        NodoListaDuplamenteEncadeada<T> atual = search(chave);
        if (atual != null && atual.getAnterior() != cabeca) {
            return atual.getAnterior();
        }
        return null;
    }

    @Override
    public T[] toArray(Class<T> clazz) {
        int size = size();
        if (size == 0) return null;
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, size);
        NodoListaDuplamenteEncadeada<T> atual = cabeca.getProximo();
        int i = 0;
        while (atual != cauda) {
            array[i++] = atual.getChave();
            atual = atual.getProximo();
        }
        return array;
    }

    @Override
    public void inserePrimeiro(T elemento) {
        // Insere logo após a cabeça
        NodoListaDuplamenteEncadeada<T> novo = new NodoListaDuplamenteEncadeada<>(elemento);
        NodoListaDuplamenteEncadeada<T> primeiro = cabeca.getProximo();

        novo.setProximo(primeiro);
        novo.setAnterior(cabeca);
        cabeca.setProximo(novo);
        primeiro.setAnterior(novo);
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> removeUltimo() {
        if (isEmpty()) return null;
        NodoListaDuplamenteEncadeada<T> ultimo = cauda.getAnterior();
        NodoListaDuplamenteEncadeada<T> penultimo = ultimo.getAnterior();

        penultimo.setProximo(cauda);
        cauda.setAnterior(penultimo);

        ultimo.setAnterior(null);
        ultimo.setProximo(null);

        return ultimo;
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> removePrimeiro() {
        if (isEmpty()) return null;
        NodoListaDuplamenteEncadeada<T> primeiro = cabeca.getProximo();
        NodoListaDuplamenteEncadeada<T> segundo = primeiro.getProximo();

        cabeca.setProximo(segundo);
        segundo.setAnterior(cabeca);

        primeiro.setAnterior(null);
        primeiro.setProximo(null);

        return primeiro;
    }

    @Override
    public void insert(T chave, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }

        NodoListaDuplamenteEncadeada<T> atual = cabeca;
        for (int i = 0; i < index; i++) {
            atual = atual.getProximo();
        }

        NodoListaDuplamenteEncadeada<T> proximo = atual.getProximo();
        NodoListaDuplamenteEncadeada<T> novo = new NodoListaDuplamenteEncadeada<>(chave);

        novo.setAnterior(atual);
        novo.setProximo(proximo);
        atual.setProximo(novo);
        proximo.setAnterior(novo);
    }
}
