package Item50;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Class<?> item50 = Class.forName("java.lang.String");
        Method[] item50Methods = item50.getMethods();
        Field[] item50Field = item50.getFields();
        System.out.println(Arrays.toString(item50Methods));
        System.out.println(Arrays.toString(item50Field));
        Field field = item50Field[0];
        field.set(field, "10");
    }
}
