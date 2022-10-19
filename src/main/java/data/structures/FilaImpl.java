package data.structures;

public class FilaImpl<T> implements Fila<T>{

    private final T[] elements;
    private int front;
    private int rear;

    public FilaImpl(int size) {
        if (size <= 0)  throw new RuntimeException("Tamanho invalido " + size);
        elements = (T[]) new Object[size];
        front = -1;
        rear = -1;
    }

    @Override
    public void enqueue(T data) {
        if(isEmpty()){                      // [Caso 1] primeiro elemento adicionado na fila vazia
            front++;
            rear++;
            elements[rear] = data;
        } else if (!isFull()) {             // [Caso 2] não é o primeiro elemento da fila, preciso verificar se está cheia
            if(rear == size()-1){           //  se estiver na última posicao -> mudo para zero
                rear = 0;
                elements[rear] = data;
            } else {                        // nao está na ultima posicao, basta ++rear
                elements[++rear] = data;
            }
        } else {
            throw new RuntimeException("Fila cheia");
        }
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {
            if(front == size()-1){           //  se estiver na última posicao -> mudo para zero
                front = 0;
                return elements[size()-1];
            } else {                        // nao está na ultima posicao, basta ++front
                if (front == rear){
                    front = rear = -1;
                } else
                    return elements[front++];
            }
        }
        throw new RuntimeException("Fila vazia");
    }

    @Override
    public T front() {
        if (isEmpty()) return null;
        else return elements[front];
    }

    public T rear(){
        if (isEmpty()) return null;
        else return elements[rear];
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public boolean isEmpty() {
        return (front == -1) && (front == rear);
    }

    @Override
    public boolean isFull() {

        return ((rear == size()-1 && front == 0) || (rear == front-1) || (rear == front +1));
    }
}