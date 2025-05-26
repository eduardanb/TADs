package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;
import tad.conjuntoDinamico.ConjuntoDinamicoIF;
import tad.conjuntoDinamico.MeuConjuntoDinamico;

public class TestaConjuntoDinamico {
    
    private ConjuntoDinamicoIF<Integer> cd = null;
    
    @Before
    public void iniciar() {
        cd = new MeuConjuntoDinamico();
    }
    
    @Test
    public void tamanhoTest() {
        Assert.assertEquals(0, cd.tamanho());
        cd.inserir(2);
        Assert.assertEquals(1, cd.tamanho());
        cd.inserir(2);
        Assert.assertEquals(2, cd.tamanho());
        cd.inserir(1);
        Assert.assertEquals(3, cd.tamanho());
        cd.inserir(5);
        Assert.assertEquals(4, cd.tamanho());
    }
    
    @Test
    public void inserirTeste() {
        Assert.assertEquals(0, cd.tamanho());
        cd.inserir(9);
        Assert.assertEquals(1, cd.tamanho());
        cd.inserir(4);
        Assert.assertEquals(2, cd.tamanho());
        cd.inserir(1);
        Assert.assertEquals(3, cd.tamanho());
        cd.inserir(1);
        Assert.assertEquals(4, cd.tamanho());
    }
    
    @Test
    public void removerTeste() {
        Assert.assertEquals(0, cd.tamanho());
        cd.inserir(2);
        cd.inserir(2);
        cd.inserir(1);
        cd.inserir(5);
        Assert.assertEquals(new Integer(2), cd.remover(2));
        Assert.assertEquals(3, cd.tamanho());
        
        Assert.assertEquals(new Integer(1), cd.remover(1));
        Assert.assertEquals(2, cd.tamanho());
        
        Assert.assertEquals(new Integer(5), cd.remover(5));
        Assert.assertEquals(1, cd.tamanho());
        
        Assert.assertEquals(new Integer(2), cd.remover(2));
        Assert.assertEquals(0, cd.tamanho());
    }
    
    @Test(expected=NoSuchElementException.class)
    public void removerFailTeste() {
        cd.remover(3);
    }
    
    @Test(expected=NoSuchElementException.class)
    public void removerFail2Teste() {
        cd.inserir(4);
        cd.inserir(5);
        cd.inserir(10);
        cd.inserir(8);
        cd.remover(3);
    }
    
    @Test
    public void buscarTeste() {
        cd.inserir(4);
        cd.inserir(5);
        cd.inserir(10);
        cd.inserir(8);
        Assert.assertEquals(new Integer(10), cd.buscar(10));
    }
    
    @Test(expected=NoSuchElementException.class)
    public void buscarFailTeste() {
        cd.inserir(4);
        cd.inserir(5);
        cd.inserir(10);
        cd.inserir(8);
        cd.buscar(1);
    }
    
    @Test
    public void minimumTeste() {
        try {
            cd.minimum();
            Assert.fail("Deveria lançar exceção ao chamar minimum em conjunto vazio");
        } catch (NoSuchElementException e) {}
        
        cd.inserir(4);
        cd.inserir(5);
        cd.inserir(10);
        cd.inserir(8);
        Assert.assertEquals(new Integer(4), cd.minimum());
    }
    
    @Test
    public void maximumTest() {
        try {
            cd.maximum();
            Assert.fail("Deveria lançar exceção ao chamar maximum em conjunto vazio");
        } catch (NoSuchElementException e) {}
        
        cd.inserir(5);
        cd.inserir(4);
        cd.inserir(10);
        cd.inserir(8);
        Assert.assertEquals(new Integer(10), cd.maximum());
    }
    
    @Test
    public void sucessorTeste() {
        try {
            cd.sucessor(5);
            Assert.fail("Deveria lançar exceção ao chamar sucessor em conjunto vazio");
        } catch (NoSuchElementException e) {}
        
        cd.inserir(4);
        cd.inserir(5);
        cd.inserir(10);
        cd.inserir(8);
        
        // Ordem lógica dos elementos: 4, 5, 8, 10
        Assert.assertEquals(new Integer(5), cd.sucessor(4));
        Assert.assertEquals(new Integer(8), cd.sucessor(5));
        Assert.assertEquals(new Integer(10), cd.sucessor(8));
        
        try {
            cd.sucessor(10); // Não tem sucessor
            Assert.fail("Deveria lançar exceção quando não há sucessor");
        } catch (NoSuchElementException e) {}
    }
    
    @Test
    public void predecessorTeste() {
        try {
            cd.predecessor(5);
            Assert.fail("Deveria lançar exceção ao chamar predecessor em conjunto vazio");
        } catch (NoSuchElementException e) {}
        
        cd.inserir(4);
        cd.inserir(5);
        cd.inserir(10);
        cd.inserir(8);
        
        // Ordem lógica dos elementos: 4, 5, 8, 10
        try {
            cd.predecessor(4); // Não tem predecessor
            Assert.fail("Deveria lançar exceção quando não há predecessor");
        } catch (NoSuchElementException e) {}
        
        Assert.assertEquals(new Integer(4), cd.predecessor(5));
        Assert.assertEquals(new Integer(5), cd.predecessor(8));
        Assert.assertEquals(new Integer(8), cd.predecessor(10));
        
        try {
            cd.predecessor(83); // Elemento não existe
            Assert.fail("Deveria lançar exceção quando o elemento não existe");
        } catch (NoSuchElementException e) {}
    }
}