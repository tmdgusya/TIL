# I/O

자바에서 입력과 출력을 작업을 처리해주는 클래스들

# Stream ?

우리가 하드웨어 측면에서 입력 혹은 출력을 받는 것을 스트림이라고 한다. 예전에 리눅스상에서 소켓프로그래밍을 공부했을때, 
리눅스에는 파일 디스크럽터라는 일련의 흐름이 하나 존재했는데, 표준 출력, 표준 입력, 표준 에러 총 3가지가 존재했다. 
아마 모든 프로그래밍 방식들이 이와 비슷한 스트림을 가지고있는 것으로 인지하고 있다.
일단 우리는 자바에서 해당 스트림들이 어떻게 구현되고 있는지 먼져 알아보는걸 이번 스터디의 기준으로 삼을 것이다.
그 중 사전지식이 조금 필요하다고 생각되는 것들을 내가 정리해보았다.

## Buffer 

A ⇒ B 로 보내기전 데이터를 임시적으로 담아두는 장소. <br>
즉 우리가 보내기전에 임시적으로 저장한다(Tempository Store) 니까 메모리 영역상에 임시적으로 보관해준다.<br>
이제 우리가 유튜브 같은 영상을 볼때 흔히 말하는 **Buffering 이라는 작업은, Buffer 를 채우는 동작을 의미한다.**<br>
Socket 통신도 하나의 Data Stream 이므로 Buffer 를 이용한다.<br>
즉 , Buffer는 속도 차이가 있는 장치 사이에서 데이터를 전송할 때, 데이터의 손실을 방지하고 효율적으로 사용하기 위한 임시 저장공간이라고 할 수 있습니다.<br>
예를 들면 하드디스크의 전송속도가 초당 5개라고 해보자.<br>
근데 CPU 는 초당 100개의 데이터를 처리한다고 했을때, 하드디스크에 보관했다가 보내는건 정말 CPU 를 효율적으로 이용하지 못한다고 볼 수 있다. <br>
그래서 우리는 RAM(주기억장치) 에 DATA 를 쌓아두는데 이때 Buffer 를 이용하여 쌓아둔다.  <br>
상대적으로 주기억장치의 보조기억장치가 훨씬 더 빠르므로 CPU 를 더욱 효율적으로 이용할 수 있는 것이다.<br>
우리가 이제 자바에서 이용하는 Buffer가 왜 더 빠르다고 하는지, 이제 이해가 가는가? 


## 입력 받는 문자

- 크게 **Byte** 와 **Char** 형태로 구성되어 있다.
- Byte - **InputStream 과 OutputStream** 으로 구성되어 있다.
- Char - **Reader 와 Writer** 로 구성되어 있다.

## ByteExam01.class

- MyObject File 로 부터 한 바이트씩 읽어와서 한 바이트씩 쓰는 작업을 함. 
- FileInputStream 은 파일로 부터 값을 읽어오거나 쓰는 등 여러가지 역할을 하는 클래스

```java
fis = new FileInputStream("src/Week2/ByteExam1.java");
```

- 상대 경로는 프로젝트 기반으로 설정 가능하며, 절대 경로로도 수행가능하다.

```java
while((readData = fis.read()) != -1){
    System.out.println("readData = " + fis.read());
    fos.write(readData);
}
```
- readData() 는 값을 읽어오는 함수로 한 바이트씩 가져와서 읽어오는데 읽어올것이 있다면 계속해서 양수를 리턴하고, 없다면 -1 을 리턴하게된다.

# ByteExam02.class

- 해당 클래스는 버퍼를 도입하여 512 byte 씩 읽어올 수 있도록 했다. 
- 그리고 시작부터 ~ 종료까지 걸리는 시간을 재보았다.
```
ByteExam01 은 7
ByteExam02 는 0 
```

결과값을 보면 천차만별이다. 따라서 버퍼를 두고 읽어오는게 맞는것 같다.

# BufferedReader vs Scanner

솔직히 최근에 알고리즘 문제들을 풀기전까지는 왜 BufferReader 를 쓰는지 잘 이해를 하지 못했다. <br>
솔직히 이번 이주차에서 I/O를 고르게 된 이유도 해당 이유가 가장크다. <br>
일단 실질적인 속도차이를 눈으로 본적이 없었는데 진짜 해보니 차이가 엄청나게 컸다. 일단 코드를 보자! <br>

```java
public class InputExam01 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        for(int i = 0; i < 1000000; i++){
            sum += 100;
            bw.write( s );
        }
        long endTime = System.currentTimeMillis();
        System.out.println(startTime-endTime);
        br.close();
        bw.close();
    }
}
```

```java
public class InputExam02 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        for(int i = 0; i < 1000000; i++){
            sum += 100;
            System.out.println(s);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(startTime-endTime);
        scan.close();
    }
}
```

이렇게 코드를 짜고 똑같이 값을 넣어주고, 실행해봤는데 둘이 시간차이가 눈에 보일정도로 난다. <br>

Scanner 는 문자가 키보드에서 입력될때 마다 전송을 한다. 즉 메모리를 거치지 않고 하나하나씩 보내는 것이다. <br>
**그런데 실질적으로 속도 측정을 해보면 어마 무시하게 속도차이가 많이나는데 그 이유는 Scanner 는 파싱기능을 제공하는데, 
이는 알아서 Tokenizing 과 Parsing 과정을 거쳐서 오래걸리는 면도 있다고한다.**
그런데 Buffer 는 키보드의 입력이 있을때마다 한문자씩 전송하며, 개행이나 버퍼가 가득찰 경우 버퍼의 내용을 한번에 전송한다. <br>
즉 메모리의 저장공간을 이용하므로, 속도가 더 빠를 수 밖에 없는 것이다. <br>

우리가 알고리즘을 풀때 사용하는 InputStreamReader 는 default 로 1024 바이트까지 저장한다음, <br>
전송해준다고 하는데 이는 정말 알고리즘에선 충분한 사이즈이다. <br>
앞으로 알고리즘을 풀때는 줄여서 사용해도 될것같다? 메모리 효율성따졌을때? <br>

