package promiserpkg;

@FunctionalInterface
public interface Resolver<T> {
	public Promiser run(T t);
}
