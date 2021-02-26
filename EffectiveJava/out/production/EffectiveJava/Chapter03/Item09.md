# [Item09] try-finally 보다는 try-with-resource 를 사용하라.

자바 라이브러리에는 DB 등 close 를 메소드를 호출해 직접 닫아줘야 하는 자원이 많다. <br>
자원 닫기는 클라이언트가 놓치기 쉬워서 예측할 수 없는 성능 문제로 이어지기도 한다. <br>
이 문제는 내가 직접 겪었던 문제로 실제로 Maria DB 의 Connection Pool 이 넘친적이 있다. <br>
학교 4학년 신분으로 실습생이던 시절에는 잘몰랐지만, 파고들다보니 해당 문제라는걸 알게 되었고, 불필요한 Connection 도 줄이고, close 관련해서도
처리해주었었다. 근데 책에서 **try-finally 보다는 try-with-resource** 가 더 좋다고 기술되어 있으니, 이제 천천히 왜 그런지 알아보자! <br>

원래코드는 아래와 같다. 한가지일 경우는 뭐 뻔하기때문에 자원이 두가지인 경우로 기술하겠다.

```java
static void copy(String src, String dst) throws IOException {
	InputStream in = new FileStream(src);
	try{
		OutputStream out = new FileOutputStream(dst);
		try{
			byte[] buf = new byte[BUFFER_SIZE];
			int n;
			while((n = in.read(buf)) >= 0){
				out.write(buf, 0, n);
			}
		}finally{
			out.close();
		}
	}finally{
		in.close();
	}
}
```

이런 프로그래밍 방식은 상당히 진부하고, 잘못된 방식이다. 내가 토비의 스프링책을 읽을때도 한번 정리한적있는데,
이런 코드는 문제를 찾아내기도 어려울 뿐더러, 첫번째 예외가 두번째 예외를 잠식해 버리는 오류를 범할 수도 있다.
그래서 우리는 **try-with-resource** 를 사용해야 한다. <br>

아래의 사용코드를 보자!

```java
static void copy(String src, String dst) throws IOException {
	try(
	InputStream in - new FileInputStream(src);
	OutputStream out = new FileOutputStream(dst);){
		byte[] buf = new byte[BUFFER_SIZE];
		int n;
		while((n = in.read(buf)) >= 0){
			out.write(buf, 0, n);
		}
	}
}
```

try-with-resource 버전이 짧고 읽기 수월할 뿐 아니라, 문제를 진단하기도 훨씬 좋다. <br>
try-with-resource 는 무조건적으로 해당 작업이 예외 혹은 종료되면 정상적으로 자원을 반환해준다 <br>
따라서 DataBase 에 해당 작업을 진행해줄때는 try-with-resource 를 이용해야 한다!! <br>

이건 진짜 중요한 내역인거 같으니 앞으로 이렇게 적도록 하자!!
