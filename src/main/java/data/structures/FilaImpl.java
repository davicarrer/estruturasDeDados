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
            if (front == rear){         // só um elemento na fila
                int aux = front;
                front = -1;
                rear = -1;
                return elements[aux];
            } else if((front == size()-1) && (front != 0)){           //  se estiver na última posicao -> mudo para zero
                front = 0;
                return elements[size()-1];
            } else
                    return elements[front++];

        }
        throw new RuntimeException("Fila vazia");
    }

    @Override
    public T front() {
        if (isEmpty()) return null;
        else return elements[front];
    }
    @Override
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
        return ((rear == size()-1 && front == 0) || (rear == front-1));
    }
    @Override
    public int getIndexFront(){
        return front;
    }
    @Override
    public int getIndexRear(){
        return rear;
    }

    public void displayQueue(){
        if(front == -1)
            System.out.println("Fila vazia");
        else {
            System.out.print("Elementos da lista: ");
            if(rear >= front){
                for (int i = front; i < rear; i++) {
                    System.out.print(elements[i] + ", ");
                }

            } else{
                for (int i = front; i < size(); i++)
                {
                    System.out.print(elements[i] + ", ");
                }

                for (int i = 0; i <= rear; i++)
                {
                    System.out.print(elements[i] + ", ");
                }
            }
        }
    }
}