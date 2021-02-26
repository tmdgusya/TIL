class GenericExample<T> {
	T data;

	public GenericExample(T data) {
		this.data = data;
	}

	public static void main(String[] args) {
		GenericExample<String> ge = new GenericExample<>("Cool");
	}
}
