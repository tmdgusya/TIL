package org.AnnotationExample;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        CustomContextContainer customContextContainer = new CustomContextContainer();
        //Example  data = 10;
        Example example = customContextContainer.get(Example.class);

        System.out.println(example.getInject());
    }

}
