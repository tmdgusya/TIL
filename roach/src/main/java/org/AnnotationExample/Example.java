package org.AnnotationExample;

public class Example {

    @InsertIntData(data = 30)
    private int data = 10;

    public Integer getInject() {
        return data;
    }

}
