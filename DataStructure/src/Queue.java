import java.util.EmptyStackException;

public class Queue<T> {

    private T item;
    private Queue<T> top;
    private Queue<T> next;

    public Queue(T item) {
        this.item = item;
        this.top = this;
    }

    public void add(T item){
        if(this.item == null){
            this.item = item;
        }else{
            Queue<T> next = new Queue<>(item);
            this.next = next;
            next.top = this;
        }
    }

    public T peek(){
        if(this.top == null){
            return this.item;
        }else{
            return this.top.item;
        }
    }

    public void remove(){
        top.item = null;
        if(this.next != null){
            this.top = next;
        }else{
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty(){
        if(this.top != null){
            return this.top == null;
        }else{
            return this.item == null;
        }
    }
}
