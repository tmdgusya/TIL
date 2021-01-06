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
