public class ArrayRuntimeException {

	public static void main(String[] args) {
		Object[] array = new Long[2];
		array[0] = 1L;
		array[1] = "이건 될꺄요?";
		System.out.println(array[0]);
	}
}
