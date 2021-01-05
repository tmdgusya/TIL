import java.util.EmptyStackException;

public class Stack<T> {

    private T data;
    private T min;
    private Stack<T> next;
    private Stack<T> top;

    public Stack() {}

    public Stack(T data) {
        this.data = data;
        if(min == null){
            this.min = data;
        }
    }

    public T pop(){
        if(top == null) {
            if(this.data == null){
                throw new EmptyStackException();
            }
            else return this.data;
        }else{
            return ifExistTop();
        }
    }

    public void push(T item){
            if(this.data == null){
                this.data = item;
                if(this.data instanceof Integer){
                    compare(min, data);
                }
            }else{
                ifExistSelfData(item);
            }
    }

    private Object compare(T min, T data) {
        if(min instanceof Integer){
            Integer min_ = (Integer) min;
            Integer data_ = (Integer) data;
            return Integer.compare(min_, data_);
        }else{
            Long min_ = (Long) min;
            Long data_ = (Long) data;
            return Long.compare(min_, data_);
        }
    }


    public T peek(){
        if(top == null) {
            if(this.data == null){
                throw new EmptyStackException();
            }
            else return this.data;
        }else{
            return top.data;
        }
    }

    public boolean isEmpty(){
        if(top == null){
            return (this.data == null && this.next == null);
        }else{
            return top == null;
        }
    }

    private T ifExistTop() {
        T item = top.data;
        top = top.next;
        return item;
    }

    private void ifExistSelfData(T item) {
        Stack<T> node = new Stack<T>(item);
        node.next = top;
        top = node;
    }

    public T getData() {
        return data;
    }

    public T getMin() {
        return min;
    }

    public Stack<T> getNext() {
        return next;
    }

    public Stack<T> getTop() {
        return top;
    }
}
