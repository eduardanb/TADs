package tad.listasEncadeadas;

import tad.fila.FilaCheiaException;
import tad.fila.FilaIF;
import tad.fila.FilaVaziaException;

public class FilaListaEncadeada implements FilaIF<NodoListaEncadeada<Integer>> {
    
    private ListaEncadeadaIF<Integer> fila;

    public FilaListaEncadeada() {
        this.fila = new ListaEncadeadaImpl<>();
    }

    @Override
    public void enfileirar(NodoListaEncadeada<Integer> item) throws FilaCheiaException {
        this.fila.insert(item.getChave());
    }

    @Override
    public NodoListaEncadeada<Integer> desenfileirar() throws FilaVaziaException {
        if (this.fila.isEmpty()) {
            throw new FilaVaziaException();
        }
        NodoListaEncadeada<Integer> cabeca = ((ListaEncadeadaImpl<Integer>) this.fila).verificarCabeca();
        if (cabeca == null) throw new FilaVaziaException();
        Integer chaveRemovida = cabeca.getChave();
        this.fila.remove(chaveRemovida);
        return new NodoListaEncadeada<>(chaveRemovida);
    }

    @Override
    public NodoListaEncadeada<Integer> verificarCauda() {
        if (this.fila.isEmpty()) {
            return null;
        }
        return ((ListaEncadeadaImpl<Integer>) this.fila).verificarCauda();
    }

    @Override
    public NodoListaEncadeada<Integer> verificarCabeca() {
        if (this.fila.isEmpty()) {
            return null;
        }
        return ((ListaEncadeadaImpl<Integer>) this.fila).verificarCabeca();
    }

    @Override
    public boolean isEmpty() {
        return this.fila.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
