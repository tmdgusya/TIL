import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Queue<T> {


    private T item;
    private Queue<T> next;
    private Queue<T> first;
    private Queue<T> last;

    public Queue(T item) {
        this.item = item;
        if(first == null){
            first = this;
        }
        if(last == null){
            last = this;
        }
    }

    public void add(T item){
        Queue<T> next = new Queue<>(item);
        if(last != null){
            last.next = next;
        }
        last = next;
        if(first == null){
            first = last;
        }
    }

    public T peek(){
        return this.first.item;
    }

    public void remove(){
        if(first == null) throw new NoSuchElementException();
        if(first.next == null){
            first = null;
        }else{
            first = first.next;
            if(first == null){
                last = null;
            }
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public Queue<T> getFirst() {
        return first;
    }

    public void setFirst(Queue<T> first) {
        this.first = first;
    }

    public Queue<T> getLast() {
        return last;
    }

    public void setLast(Queue<T> last) {
        this.last = last;
    }
}
