import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    Stack<Integer> stack;

    @BeforeEach
    void init(){
        stack = new Stack<>(1);
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
        Integer ExpectedData = 1;
        boolean ExpectedIsEmpty = true;
        boolean isEmptyData = stack.isEmpty();
        Assertions.assertEquals(ExpectedData, popdata);
        Assertions.assertEquals(ExpectedIsEmpty, isEmptyData);
    }
}