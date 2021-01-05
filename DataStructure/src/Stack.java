import java.util.EmptyStackException;

public class Stack<T> {

    private T data;
    private Stack<T> next;
    private Stack<T> top;

    public Stack() {}

    public Stack(T data) {
            this.data = data;
        }

        public T pop(){
            if(top == null) {
                if(this.data == null){
                    throw new EmptyStackException();
                }
                else return this.data;
            }else{
                T item = top.data;
                top = top.next;
                return item;
            }
        }

        public void push(T item){
            if(this.data == null){
                this.data = item;
            }else{
                Stack<T> node = new Stack<T>(item);
                node.next = top;
                top = node;
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
}
