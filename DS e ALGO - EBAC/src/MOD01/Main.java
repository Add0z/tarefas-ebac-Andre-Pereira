package MOD01;

import MOD01.ListaEncadeada.ListaEncadeada;
import MOD01.ListaEncadeada.Node;

public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        pilha.pushar(10);
        //Pushar - Tempo:   O(1) - adiciona ao final ao topo da pilha, não precisando passar pelos elementos
//                 Espcaço: O(1)
        pilha.pushar(20);
        pilha.pushar(30);
        System.out.println(pilha);
        System.out.println("Tamanho da pilha: " +  pilha.sizear());
        //Sizear - Tempo:   O(n) - aumenta contador toda vez que passa pelos elementos, tendo que passar por todos os elementos
//                 Espcaço: O(1)
        System.out.println("Elemento removido: " +  pilha.popar() );
        //Popar - Tempo:   O(n) - por necessitar saber o tamanho da pilha para excluir para popar o ultimo, requer passar por todos os elementos
//                 Espcaço: O(1)
        System.out.println("Elemento topo: "+  pilha.toppear());
        //Toppear - Tempo:   O(n) - por necessitar saber o tamanho da pilha para olhar o ultimo, requer passar por todos os elementos
//                  Espcaço: O(1)
        pilha.isEmptyado();
        //IsEmptytado - Tempo:   O(n) - por necessitar saber o tamanho da pilha para olhar o ultimo, requer passar por todos os elementos
//                      Espcaço: O(1)
        System.out.println("Elemento removido: " +  pilha.popar() );
        System.out.println("Elemento removido: " +  pilha.popar() );
        pilha.isEmptyado();

        System.out.println("-----------");


        Fila fila = new Fila();
        //Enqueuear - Tempo:   O(1) - adiciona ao final ao topo da pilha, não precisando passar pelos elementos
//                    Espcaço: O(1)
        fila.enqueuear(10);
        fila.enqueuear(20);
        fila.enqueuear(30);
        System.out.println(fila);
        System.out.println("Tamanho da fila FIFO: " +  fila.sizear());
        //Sizear - Tempo:   O(n) - aumenta contador toda vez que passa pelos elementos, tendo que passar por todos os elementos
//                 Espcaço: O(1)
        System.out.println("Elemento removido do Front: " +  fila.denqueuear());
        //Denqueuear - Tempo:   O(n) - remover o primeiro elemento da lista requer reorgazinar todos os outros elementos em index -1
//                     Espcaço: O(1)
        System.out.println("Elemento no front: "+  fila.frontear());
        //Frontear - Tempo:   O(1) - olha o primeiro elemento da lista somente
//                   Espcaço: O(1)
        System.out.println("Elemento no rear: "+  fila.rearear());
        //Rearear - Tempo:   O(n) - passa por todos os elementos para olhar o ultimo
//                  Espcaço: O(1)
        fila.isEmptyado();
        //isEmptyado - Tempo:   O(n) - ((acredito que tenha como fazer O(1))) - verifica se o tamanho da fila é menor que 1
//                     Espcaço: O(1)
        System.out.println("Elemento removido: " +  fila.denqueuear() );
        System.out.println("Elemento removido: " +  fila.denqueuear() );
        fila.isEmptyado();
        System.out.println("-----------");

        ListaEncadeada linkedList = new ListaEncadeada();
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        linkedList.push(node1);
        //Push - Tempo:   O(n) - adicionar um node requer percorrer toda a lista
//               Espcaço: O(1)
        linkedList.push(node2);
        linkedList.push(node3);

        linkedList.printList();
        //Print - Tempo:   O(n) - imprimir um node requer percorrer toda a lista
//                Espcaço: O(n) - construir uma string com todos os node requer percorrer toda a lista

        Node removedNode = linkedList.pop();
        //Pop - Tempo:   O(n) - remover o ultimo node requer percorrer toda a lista
//              Espcaço: O(1)
        Node node4 = new Node(15);
        linkedList.insert(1, node4);
        //Insert - Tempo:   O(n) - inserir requer percorrer a lista até 2 nodes após o index desejado
//                 Espcaço: O(1)
        linkedList.remove(2);
        linkedList.printList();

        Node element = linkedList.elementAt(1);
        //ElementAt - Tempo:   O(n) - Buscar requer percorrer a lista até o index desejado
//                    Espcaço: O(1)
        System.out.println(element.data);
        int size = linkedList.size();
        //Size - Tempo:   O(n) - coletar o tamanho requer percorrer toda a lista
//               Espcaço: O(1)
        System.out.println(size);

    }
}
