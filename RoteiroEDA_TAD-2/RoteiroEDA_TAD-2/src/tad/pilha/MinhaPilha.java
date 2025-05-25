package tad.pilha;

public class MinhaPilha implements PilhaIF<Integer> {
    
    private int tamanho = 10;
    private Integer[] meusDados;
    private int topo = -1;

    public MinhaPilha(int tamanho) {
        this.tamanho = tamanho;
        this.meusDados = new Integer[tamanho];
    }
    
    public MinhaPilha() {
        this.meusDados = new Integer[tamanho];
    }

    @Override
    public void empilhar(Integer item) {
        if (isFull()) {
            throw new RuntimeException("Pilha cheia");
        }
        meusDados[++topo] = item;
    }

    @Override
    public Integer desempilhar() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        Integer valor = meusDados[topo];
        meusDados[topo--] = null;
        return valor;
    }

    @Override
    public Integer topo() {
        if (isEmpty()) {
            return null;
        }
        return meusDados[topo];
    }

    @Override
    public PilhaIF<Integer> multitop(int k) {
        MinhaPilha nova = new MinhaPilha(k);
        for (int i = topo, count = 0; i >= 0 && count < k; i--, count++) {
            nova.empilhar(meusDados[i]);
        }
        return nova;
    }

    @Override
    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == tamanho - 1;
    }
}