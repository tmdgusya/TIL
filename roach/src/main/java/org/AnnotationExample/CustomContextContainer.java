package org.AnnotationExample;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CustomContextContainer {

    private <T> T invokeAnnotation(T instance) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();
        for(Field field : fields) {
            InsertIntData annotation = field.getAnnotation(InsertIntData.class);
            if(annotation != null && field.getType() == int.class) {
                field.setAccessible(true);
                field.set(instance, annotation.data());
            }
        }
        return instance;
    }

    public  <T> T get(Class<T> obj) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        T instance = obj.getDeclaredConstructor().newInstance();
        instance = invokeAnnotation(instance);
        return instance;
    }

}
