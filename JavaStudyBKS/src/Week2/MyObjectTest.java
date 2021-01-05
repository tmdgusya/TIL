package Week2;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MyObjectTest {

    @Test
    void serializableTest() throws IOException {
        byte[] serializedObject;
        final Integer ExpectedValue = 1;
        Integer resultvalue = null;

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();) { // 직렬화된 바이트 스트림 획
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);) {
                MyObject myObject = new MyObject(ExpectedValue);
                objectOutputStream.writeObject(myObject);
                serializedObject = byteArrayOutputStream.toByteArray();
            }
        }
        
        try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedObject);){
            try(ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)){
                Object objectMyObject = objectInputStream.readObject();
                MyObject myObject = (MyObject) objectMyObject;
                System.out.println("myObject.value = " + myObject.value);
                resultvalue = myObject.value;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        Assertions.assertEquals(ExpectedValue, resultvalue);
    }
    
}