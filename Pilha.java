package listaencadeada;
import java.util.Scanner;
import java.util.Random;
class Disco {
  private Integer valor;
  private Disco proximo;
  public Disco(){this.valor = null;this.proximo = null;}
  public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Disco getProximo() {
        return proximo;
    }

    public void setProximo(Disco proximo) {
        this.proximo = proximo;
    }
}
public class Pilha{
  private String nome;
  private Disco Pilha;
  public Pilha(String nome){
      this.nome = nome;
      this.Pilha = null;}
  public String getNome() {
        return nome;
    }
  public boolean vazia() {
        return Pilha == null;
    }
  public int pop(){
    if(Pilha == null)
    {
      System.out.println("Essa Pilha está vazia");
     return -1;
    }
    if (this.Pilha.getProximo() == null) {
      int valor = Pilha.getValor();
        this.Pilha = null;
        return valor;
    }
    Disco atual = Pilha;
    Disco anterior = null;

    while (atual.getProximo() != null) {
        anterior = atual;
        atual = atual.getProximo();
    }
    anterior.setProximo(null); 
    return atual.getValor();
  }
  public void push(Integer valor){
    if(valor == -1){return;}
    Disco disco = new Disco();
    disco.setValor(valor);
    if(Pilha == null){Pilha = disco;}
    else{
      Disco atual = Pilha;
      while(atual.getProximo() != null){
        atual = atual.getProximo();
      }
      atual.setProximo(disco);
    }
  }
  public int verificar(int tipo){
      Disco atual = Pilha;
      int ultimo = 0;
  switch(tipo){
      case 1:
    if(Pilha == null){return 1;}
    
    
    while(atual != null){
        if(atual.getValor() < ultimo) {return 0;} // Se encontrar um valor fora de ordem, retorna 0
        ultimo = atual.getValor();
        atual = atual.getProximo();
    }
    
    return 3; // A pilha está em ordem crescente
    case 2:
        ultimo = 100;
    if(Pilha == null){return 1;}
    
    
    while(atual != null){
        if(atual.getValor() > ultimo) {return 0;} // Se encontrar um valor fora de ordem, retorna 0
        ultimo = atual.getValor();
        atual = atual.getProximo();
    }
    
    return 3; // A pilha está em ordem crescente
  }
  return 0;
  }

  public void imprimir(){
      Disco atual = Pilha;
      System.out.println("-------------");
      while(atual!= null){
          if(atual.getValor() == null){System.out.println("\n");}
          else{
          System.out.printf("%d\n",atual.getValor() );
          atual = atual.getProximo();
          }
      }
      
  }

public static void ordenarPilha(Pilha origem, Pilha destino, Pilha auxiliar,int tamanho, int verificacao) {
switch(verificacao){
    case 1: 
        int movimentos = 0; // Contador de movimentos
 for (int i = 0; i < tamanho; i++) {
     int anterior = 101;

     while (!origem.vazia()) {
         int valor = origem.pop();
         if (valor < anterior) {
             if (anterior != 101) {
                 auxiliar.push(anterior);
             }
             anterior = valor;
         } else {
             auxiliar.push(valor);
         }

         movimentos++; // Incrementa o contador de movimentos a cada movimento
     }

     destino.push(anterior);
     // Mostra o passo atual e o número de movimentos
     System.out.println("Passo " + (i + 1) + ": Mover " + anterior + " da " + origem.getNome() + " para a " + destino.getNome() + ". Movimentos: " + movimentos);

     while (!auxiliar.vazia()) {
         origem.push(auxiliar.pop());
     }
 }
 break;
    case 2:
        movimentos = 0; // Contador de movimentos
        for (int i = 0; i < tamanho; i++) {
     int anterior = 0;

     while (!origem.vazia()) {
         int valor = origem.pop();
         if (valor > anterior) {
             if (anterior != 0) {
                 auxiliar.push(anterior);
             }
             anterior = valor;
         } else {
             auxiliar.push(valor);
         }

         movimentos++; // Incrementa o contador de movimentos a cada movimento
     }

     destino.push(anterior);
     // Mostra o passo atual e o número de movimentos
     System.out.println("Passo " + (i + 1) + ": Mover " + anterior + " da " + origem.getNome() + " para a " + destino.getNome() + ". Movimentos: " + movimentos);

     while (!auxiliar.vazia()) {
         origem.push(auxiliar.pop());
     }
 }
         break;
}}

    

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random gerador = new Random();
    System.out.println("Digite a quantidade de discos que deseja jogar: ");
    int quantidade = scanner.nextInt();
    System.out.println("Digite qual tipo de ordenação que deseja jogar(1 para crescente, 2 para decrescente): ");
    int verificacao = scanner.nextInt();
    Pilha pilha1 = new Pilha("Pilha1");
    for (int i = 0; i < quantidade;i++){
       pilha1.push(gerador.nextInt(101));
    }
    Pilha pilha2 = new Pilha("Pilha2");
    Pilha pilha3 = new Pilha("Pilha3");
    System.out.println("Digite qual ação deseja fazer(0 para Sair, 1 para Mover, 2 para Solução Automatica): ");
    int opcoes = scanner.nextInt();
    switch(opcoes){
        case 0:
            break;
        case 1:
            while(true){
                pilha1.imprimir();
                pilha2.imprimir();
                pilha3.imprimir();
                if(pilha1.verificar(verificacao)+pilha2.verificar(verificacao)+pilha3.verificar(verificacao) == 5){break;}
                System.out.println("Digite a pilha que deseja retirar o disco(1,2 ou 3: ");
                int pilha_retirar = scanner.nextInt();
                int valor = 0;
                switch (pilha_retirar) {
                    case 1:
                        valor = pilha1.pop();
                        break;
                    case 2:
                        valor = pilha2.pop();
                        break;
                    case 3:
                        valor = pilha3.pop();
                        break;
                }
                System.out.println("Digite a pilha que deseja inserir o disco(1,2 ou 3: ");
                int pilha_inserir = scanner.nextInt();
                switch (pilha_inserir) {
                    case 1:
                        pilha1.push(valor);
                        break;
                    case 2:
                        pilha2.push(valor);
                        break;
                    case 3:
                        pilha3.push(valor);
                        break;
                }
            }
            System.out.println("Parabens você conseguiu");
        case 2:
            pilha1.imprimir();
            pilha2.imprimir();
            pilha3.imprimir();
            pilha1.ordenarPilha(pilha1,pilha3,pilha2,quantidade,verificacao);   
            pilha1.imprimir();
            pilha2.imprimir();
            pilha3.imprimir();
            System.out.println("Parabéns, você concluiu a solução automática!");
                break;
    }
    }
    
    
  }
