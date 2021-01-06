# I/O

자바에서 입력과 출력을 작업을 처리해주는 클래스들

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
