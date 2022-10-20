import data.structures.Busca;
import data.structures.BuscaImpl;

import java.util.Random;

public class EntryPoint {
    public static void main(String[] args) {
        int size = new Random().nextInt(20+1);
        System.out.println("Tamanho gerado aleatório: " + size);

        Integer[] elements = new Integer[size];
        System.out.println("Tamanho do vetor de inteiros: " + elements.length);

        for (int i = 0; i < size; i++) {
            elements[i] = new Random().nextInt(20+1);
        }
        System.out.println("Vetor de inteiros: ");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + elements[i]);
        }
        System.out.println("");
        Busca<Integer> busca = new BuscaImpl<>();
        System.out.println(busca.getClass());
        System.out.println(busca.buscaSequencial(new Integer[] {2,4,7,1}, 4));

    }
}
