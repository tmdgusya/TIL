# [Item07] 다 쓴 객체 참조를 해제하라

C 와 C++ 처럼 메모리를 직접 allocate 하거나 free 해주는 언어도있지만, 
Java 는 GC 가 객체들을 직접 관리해준다. 하지만 그렇다고 해서 우리가 아무런 행위도 해주지 않으면 안된다. <br>
GC 가 수집하는 조건 중 한가지가 객체가 참조를 하고 있지않을때 수거해간다. 즉 null 상태일때 수거한다는 것이다. <br>
아래의 코드를 한번보자, 객체를 계속해서 넣을 수 있도록 해주는 일련의 스택인데, 공간이 부족하면 공간을 계속해서 확장해준다. <br>
```java
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
        return elements[--size];
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
```

보기에는 별로 메모리 누수가 없어 보이지 않는가? 근데 어디서 누수가 일어날까? <br>
우리는 pop 해준후에, 해당 메모리를 꺼내고 아무런 조취를 취해주지 않는다. 이는 곧 메모리 누수로 이어진다. 왜냐하면 객체 참조값을 없애지않아
GC 가 유휴객체라고 인식하지 못하기때문이다. 따라서 아래와 같은 로직을 추가해주어야 한다. <br>
```java
        public Object pop(){
            if(size == 0){
                throw new EmptyStackException();
            }
            Object result = elements[--size];
            elements[--size] = null;
            return result;
        }
```

이제 element 가 null 이 되었으므로, 객체 참조가 해제되어 GC 가 유휴객체로 인식하고 정리해줄것이다!! :) <br>
하지만 책에서는 이러한 방식이 좋지 않은 방식이라고 말한다. 근데 내가 생각하기에도 좀 그러므로, 책에 나온 방법은
**그 참조를 담은 변수를 유효범위 밖으로 밀어내는 것** 이라고 한다.

이를 알아보기 위해서는 GC 에 대해 조금 더 깊게 알아봐야 한다.

# 가비지 컬렉터

- 공통적인 작업
    - 힙내의 객체 중에서 가비지를 찾아낸다.
    - 찾아낸 가비지를 처리해서 힙의 메모리를 처리한다.

가비지 컬렉터는 strong 외에도 soft, week, phantom 의 3가지 새로운 참조방식을 클래스로 쓸수있도록 지원해준다고 한다. <br>

## Reachability

Java GC 는 객체가 가비지 인지 판별하기 위해서 reachability 라는 개념을 사용한다. 어떤 객체에 유효한 참조가 담겨있으면 'reachable'로 
없으면 'unreachable' 로 구별한다. unreachable 객체를 가비지로 간주해 GC 로 간주한다. 한 객체는 여러 다른 객체를 참조하고, 참조된 다른
객체들도 마찬가지로 또 다른 객체들을 참조할 수 있으므로 객체들은 참조 사슬을 이룬다. 이러한 상황에서 유효한 참조 여부를 파악하려고 항상 유효한 최초의
참조자인 'root set' 이 있어야 한다.

힙에 있는 객체들에 대한 참조는 다음 4가지 종류중 하나이다.

- 힙내의 다른 객체에 의한 참조
- Java 스택, 즉 Java 메서드 실행시에 사용하는 지역변수와 파라미터들에 대한 참조
- 네이티브 스택, 즉 JNI 에 의해 생성된 객체에 대한 참조
- 메서드 영역의 정적변수에 의한 참

> Weak Reference 
  WeakHashMap의 작동 방식을 이해하려면 JVM의 GC와 관련하여 WeakReference  를 조금은 이해할 필요가 있다. 
  Java에서는 세 가지 주요 유형의 참조(Reference) 방식이 존재한다.   

**강한 참조 (Strong Reference)**
– Integer prime = 1;   와 같은 가장 일반적인 참조 유형이다.    
prime 변수 는 값이 1 인 Integer 객체에 대한 강한 참조 를가진다.  
이 객체를 가리키는 강한 참조가 있는 객체는 GC대상이 되지않는다.

**부드러운 참조 (Soft Reference)**
– SoftReference<Integer> soft = new SoftReference<Integer>(prime);   
와 같이 SoftReference Class를 이용하여 생성이 가능하다.  
만약 prime == null 상태가 되어 더이상 원본(최초 생성 시점에 이용 대상이 되었던 Strong Reference) 은 없고 대상을 참조하는 객체가 
SoftReference만 존재할 경우 GC대상으로 들어가도록 JVM은 동작한다.   
다만 WeakReference 와의 차이점은 메모리가 부족하지 않으면 굳이 GC하지 않는 점이다.  
때문에 조금은 엄격하지 않은 Cache Library들에서 널리 사용되는 것으로 알려져있다.

**약한 참조 (Weak Reference)**
– WeakReference<Integer> soft = new WeakReference<Integer>(prime);  
 와 같이 WeakReference Class를 이용하여 생성이 가능하다.  
 prime == null 되면 (해당 객체를 가리키는 참조가 WeakReference 뿐일 경우) GC 대상이 된다. 
  앞서 이야기 한 내용과 같이 SoftReference와 차이점은 메모리가 부족하지 않더라도 GC 대상이 된다는 것이다.    
  다음 GC가 발생하는 시점에 무조건 없어진다.
  
# 다시 본론으로..

그럼 우리의 Stack 은 어떻게 관리해야 할까? 
```java
            elements[--size] = null;
            System.gc();
```

일단은 지금 구조상에서는 null 로 처리하는게 맞는거 같으나, 애초에 유효범위를 정해놓고 짜야 하는것 같다.
