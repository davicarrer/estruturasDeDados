package data.structures;

public interface ListaDuplamenteLigada<T> extends ListaLigada<T>{
    // cada nó possui dois ponteiros, um para a lista anterior e outro para o próximo elemento
    void reverse();

}
