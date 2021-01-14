package Chapter03.Item07;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ResolveMemory {
    public class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack(){
            ensureCapacity();
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e){
            elements[size++] = e;
        }

        public Object pop(){
            if(size == 0){
                throw new EmptyStackException();
            }
            Object result = elements[--size];
            elements[--size] = null;
            System.gc();
            return result;
        }

        /*
         * 원소를 확보하기 위한 공간을 적어도 하나이상 확보한다.
         * 배열 크기를 늘러야 할 때마다 두배씩 늘린다.
         * */
        private void ensureCapacity(){
            if(elements.length == size){
                elements = Arrays.copyOf(elements, 2 * size+1);
            }
        }
    }
}
