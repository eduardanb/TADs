# Projeto TADs - Estruturas de Dados em Java

Este projeto contém implementações de TADs (Tipos Abstratos de Dados) clássicos em Java, desenvolvidas para fins didáticos na disciplina de Estruturas de Dados (LEDA/UEPB).

## Estruturas Implementadas

- **Fila**
  - `MinhaFila`: Implementação de fila usando array (circular).
  - `MinhaFilaEncadeada`: Implementação de fila usando lista encadeada.
- **Pilha**
  - `MinhaPilha`: Implementação de pilha usando array.
  - `MinhaPilhaEncadeada`: Implementação de pilha usando lista encadeada.
- **Lista Encadeada**
  - `NodoListaEncadeada`: Nó genérico para listas encadeadas.
- **Exceções**
  - `FilaVaziaException`, `FilaCheiaException`: Exceções para controle de fila.

## Organização das Pastas

```
src/
 ├── tad/
 │    ├── fila/
 │    │    ├── MinhaFila.java
 │    │    ├── MinhaFilaEncadeada.java
 │    │    ├── FilaIF.java
 │    │    ├── FilaVaziaException.java
 │    │    └── FilaCheiaException.java
 │    ├── pilha/
 │    │    ├── MinhaPilha.java
 │    │    ├── MinhaPilhaEncadeada.java
 │    │    └── PilhaIF.java
 │    └── listasEncadeadas/
 │         └── NodoListaEncadeada.java
```

## Como Compilar e Executar

1. **Compilar:**
   Abra o terminal na pasta `src` e execute:
   ```sh
   javac tad/fila/*.java tad/pilha/*.java tad/listasEncadeadas/*.java
   ```

2. **Executar Testes:**
   Se você possui classes de teste (JUnit ou main), execute:
   ```sh
   java tad.fila.NomeDaClasseDeTeste
   ```
   ou, para JUnit:
   ```sh
   java -cp .;caminho\para\junit-4.x.jar org.junit.runner.JUnitCore NomeDaClasseDeTeste
   ```

## Requisitos

- Java 8 ou superior
- (Opcional) JUnit 4.x para testes automatizados

## Autor

- Adrielly Carla, João Victor Guimarães e Maria Eduarda (LEDA - UEPB)

---
