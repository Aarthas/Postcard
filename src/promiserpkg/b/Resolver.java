package promiserpkg.b;

@FunctionalInterface
public interface Resolver<T> {
	public Promiser run(T t);
}
