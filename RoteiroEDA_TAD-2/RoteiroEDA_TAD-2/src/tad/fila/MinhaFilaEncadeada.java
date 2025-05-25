package tad.fila;

public class MinhaFilaEncadeada implements FilaIF<Integer> {

    private class Node {
        Integer valor;
        Node prox;

        Node(Integer valor) {
            this.valor = valor;
            this.prox = null;
        }
    }

    private Node cabeca = null;
    private Node cauda = null;

    @Override
    public void enfileirar(Integer item) throws FilaCheiaException {
        Node novo = new Node(item);
        if (isEmpty()) {
            cabeca = novo;
            cauda = novo;
        } else {
            cauda.prox = novo;
            cauda = novo;
        }
    }

    @Override
    public Integer desenfileirar() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException();
        }
        Integer valor = cabeca.valor;
        cabeca = cabeca.prox;
        if (cabeca == null) {
            cauda = null;
        }
        return valor;
    }

    @Override
    public Integer verificarCauda() {
        if (cauda != null) {
            return cauda.valor;
        }
        return null;
    }

    @Override
    public Integer verificarCabeca() {
        if (cabeca != null) {
            return cabeca.valor;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return cabeca == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}