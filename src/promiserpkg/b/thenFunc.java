package promiserpkg.b;

@FunctionalInterface
public interface thenFunc<T> {
	public T run(T t);
}
