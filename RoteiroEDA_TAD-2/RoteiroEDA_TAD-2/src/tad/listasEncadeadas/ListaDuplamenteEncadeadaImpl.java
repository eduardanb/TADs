package tad.listasEncadeadas;

import java.lang.reflect.Array;

public class ListaDuplamenteEncadeadaImpl<T extends Comparable<T>> implements ListaDuplamenteEncadeadaIF<T> {

    NodoListaDuplamenteEncadeada<T> cabeca = null; // sentinela
    NodoListaDuplamenteEncadeada<T> cauda = null;  // sentinela

    public ListaDuplamenteEncadeadaImpl() {
        cabeca = new NodoListaDuplamenteEncadeada<T>();
        cauda = new NodoListaDuplamenteEncadeada<T>();
        cabeca.setProximo(cauda);
        cabeca.setAnterior(cauda);
        cauda.setAnterior(cabeca);
        cauda.setProximo(null);
    }

    @Override
    public boolean isEmpty() {
        return cabeca.getProximo().equals(cauda);
    }

    @Override
    public int size() {
        int count = 0;
        NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        while (!atual.equals(cauda)) {
            count++;
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        }
        return count;
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> search(T chave) {
        NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        while (!atual.equals(cauda)) {
            if (atual.getChave().equals(chave)) {
                return atual;
            }
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        }
        return null;
    }

    @Override
    public void insert(T chave) {
        NodoListaDuplamenteEncadeada<T> novoNo = new NodoListaDuplamenteEncadeada<T>(chave);
        NodoListaDuplamenteEncadeada<T> primeiro = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();

        novoNo.setProximo(primeiro);
        novoNo.setAnterior(cabeca);
        cabeca.setProximo(novoNo);
        primeiro.setAnterior(novoNo);
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> remove(T chave) {
        NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        while (!atual.equals(cauda)) {
            if (atual.getChave().equals(chave)) {
                NodoListaDuplamenteEncadeada<T> anterior = (NodoListaDuplamenteEncadeada<T>) atual.getAnterior();
                NodoListaDuplamenteEncadeada<T> proximo = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
                anterior.setProximo(proximo);
                proximo.setAnterior(anterior);
                atual.setProximo(null);
                atual.setAnterior(null);
                return atual;
            }
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        }
        return null;
    }

    @Override
    public String imprimeEmOrdem() {
        StringBuilder sb = new StringBuilder();
        NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        while (!atual.equals(cauda)) {
            sb.append(atual.getChave());
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
            if (!atual.equals(cauda)) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public String imprimeInverso() {
        StringBuilder sb = new StringBuilder();
        NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cauda.getAnterior();
        while (!atual.equals(cabeca)) {
            sb.append(atual.getChave());
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getAnterior();
            if (!atual.equals(cabeca)) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> sucessor(T chave) {
        NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        while (!atual.equals(cauda)) {
            if (atual.getChave().equals(chave)) {
                NodoListaDuplamenteEncadeada<T> prox = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
                return prox.equals(cauda) ? null : prox;
            }
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        }
        return null;
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> predecessor(T chave) {
        NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        while (!atual.equals(cauda)) {
            if (atual.getChave().equals(chave)) {
                NodoListaDuplamenteEncadeada<T> ant = (NodoListaDuplamenteEncadeada<T>) atual.getAnterior();
                return ant.equals(cabeca) ? null : ant;
            }
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        }
        return null;
    }

    @Override
    public T[] toArray(Class<T> clazz) {
        int tam = size();
        if (tam == 0) return null;
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, tam);
        NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        int i = 0;
        while (!atual.equals(cauda)) {
            array[i++] = atual.getChave();
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        }
        return array;
    }

    @Override
    public void inserePrimeiro(T elemento) {
        insert(elemento);
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> removeUltimo() {
        if (isEmpty()) return null;
        NodoListaDuplamenteEncadeada<T> ultimo = (NodoListaDuplamenteEncadeada<T>) cauda.getAnterior();
        NodoListaDuplamenteEncadeada<T> penultimo = (NodoListaDuplamenteEncadeada<T>) ultimo.getAnterior();
        penultimo.setProximo(cauda);
        cauda.setAnterior(penultimo);
        ultimo.setProximo(null);
        ultimo.setAnterior(null);
        return ultimo;
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> removePrimeiro() {
        if (isEmpty()) return null;
        NodoListaDuplamenteEncadeada<T> primeiro = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        NodoListaDuplamenteEncadeada<T> segundo = (NodoListaDuplamenteEncadeada<T>) primeiro.getProximo();
        cabeca.setProximo(segundo);
        segundo.setAnterior(cabeca);
        primeiro.setProximo(null);
        primeiro.setAnterior(null);
        return primeiro;
    }

    @Override
    public void insert(T chave, int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        NodoListaDuplamenteEncadeada<T> novoNo = new NodoListaDuplamenteEncadeada<T>(chave);
        NodoListaDuplamenteEncadeada<T> atual = cabeca;
        int i = 0;
        while (i < index && !atual.getProximo().equals(cauda)) {
            atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
            i++;
        }
        NodoListaDuplamenteEncadeada<T> prox = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
        novoNo.setProximo(prox);
        novoNo.setAnterior(atual);
        atual.setProximo(novoNo);
        prox.setAnterior(novoNo);
    }
}
