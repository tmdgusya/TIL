import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    Queue<Integer> queue;
    final Integer initData = 1;

    @BeforeEach
    void init(){
        queue = new Queue<Integer>(initData);
    }

    @Test
    void QueueTDDTest() {
        Integer expectedData = 2;
        boolean isEmpty = true;
        queue.add(expectedData);
        Integer peek = queue.peek();
        queue.remove();
        Integer result =  queue.peek();
        queue.remove();
        Assertions.assertEquals(initData, peek);
        Assertions.assertEquals(expectedData, result);
        Assertions.assertEquals(isEmpty, queue.isEmpty());
    }
}