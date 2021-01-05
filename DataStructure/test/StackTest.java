import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    Stack<Integer> stack;
    final Integer initData = 1;

    @BeforeEach
    void init(){
        stack = new Stack<>(initData);
    }

    @org.junit.jupiter.api.Test
    public void topIsEmpty() {
        boolean result = stack.isEmpty();
        Assertions.assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    public void push() {
        Integer expectedData = 1;
        stack.push(1);
        Integer peek = stack.peek();
        Assertions.assertEquals(expectedData,peek);
    }

    @org.junit.jupiter.api.Test
    public void peek() {
        Integer peek = stack.peek();
        Integer expectedData = 1;
        Assertions.assertEquals(expectedData,peek);
    }

    @Test
    public void pop(){
        Integer popdata = stack.pop();
        boolean ExpectedIsEmpty = true;
        boolean isEmptyData = stack.isEmpty();
        Assertions.assertEquals(initData, popdata);
        Assertions.assertEquals(ExpectedIsEmpty, isEmptyData);
    }

    @Test
    public void Mpop(){
        stack.push(1);
        stack.push(2);
        Integer expectedData = 2;
        Integer pop = stack.pop();
        Assertions.assertEquals(2, pop);
    }
}